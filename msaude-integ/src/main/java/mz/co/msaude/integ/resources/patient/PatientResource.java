/**
 *
 */
package mz.co.msaude.integ.resources.patient;

import static mz.co.msaude.integ.resources.patient.PatientResource.NAME;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.core.patient.model.Patient;
import mz.co.msaude.core.patient.service.PatientQueryService;
import mz.co.msaude.core.patient.service.PatientService;

/**
 * @author Stélio Moiane
 *
 */
@Path("patients")
@Service(NAME)
public class PatientResource {

	public static final String NAME = "mz.co.msaude.integ.resources.patient.PatientResource";

	@Inject
	private PatientService patientService;

	@Inject
	private PatientQueryService patientQueryService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Patient> findAllPatients() throws BusinessException {
		return this.patientQueryService.findAllPatients();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPatient(final PatientBean patientBean) throws BusinessException {

		final Patient patient = this.patientService.createPatient(patientBean.getContext(), patientBean.getPatient());

		return Response.ok(patient).build();
	}
}
