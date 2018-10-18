/**
 *
 */
package mz.co.msaude.integ.resources.config.user.service;

import static mz.co.msaude.integ.resources.config.user.service.CustomUserDetailsServiceImpl.NAME;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.core.patient.model.Patient;
import mz.co.msaude.core.patient.model.PatientType;
import mz.co.msaude.core.patient.model.RelationshipType;
import mz.co.msaude.core.patient.service.PatientService;
import mz.co.msaude.integ.resources.config.user.dto.UserDTO;
import mz.co.msaude.integ.resources.config.user.model.UserDetailsImpl;
import mz.co.msaude.integ.resources.util.UrlTargets;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

	public static final String NAME = "mz.co.msaude.integ.resources.config.user.service.UserDetailsServiceImpl";

	@Inject
	private PatientService patientService;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		final UserContext user = new UserContext();
		user.setUsername(username);

		final Client client = ClientBuilder.newClient();
		final UserDTO userDTO = client.target(UrlTargets.ACCOUNT_MODULE).path("users/user/" + username)
		        .request(MediaType.APPLICATION_JSON).get(UserDTO.class);

		user.setPassword(userDTO.getPassword());
		user.setUuid(userDTO.getCreatedBy());
		user.setFullName(userDTO.getFullName());

		return new UserDetailsImpl(user);
	}

	@Override
	public UserContext createUser(final UserContext userContext) throws BusinessException {

		final Client client = ClientBuilder.newClient();

		userContext.setFullName();
		userContext.setUsername();

		client.target(UrlTargets.ACCOUNT_MODULE).path("users/create").request(MediaType.APPLICATION_JSON)
		        .post(Entity.entity(userContext, MediaType.APPLICATION_JSON));

		final Patient patient = new Patient();

		patient.setUuid(userContext.getUuid());
		patient.setName(userContext.getName());
		patient.setSurname(userContext.getSurname());
		patient.setGender(userContext.getGender());
		patient.setDateOfBirth(userContext.getDateOfBirth());
		patient.setPhoneNumber(userContext.getPhoneNumber());
		patient.setEmail(userContext.getEmail());
		patient.setPatientType(PatientType.MAIN_MEMBER);
		patient.setRelationshipType(RelationshipType.NONE);

		this.patientService.createMainMember(userContext, patient);

		return userContext;
	}
}
