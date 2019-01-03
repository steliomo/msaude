/**
 *
 */
package mz.co.msaude.integ.resources.consultation.resource;

import static mz.co.msaude.integ.resources.consultation.resource.ConsultationResource.NAME;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.core.location.model.Locality;
import mz.co.msaude.core.location.service.LocalityQueryService;
import mz.co.msaude.core.patient.model.Patient;
import mz.co.msaude.core.patient.service.PatientQueryService;
import mz.co.msaude.integ.resources.consultation.dto.ConsultationDTO;
import mz.co.msaude.integ.resources.util.UrlTargets;

/**
 * @author Stélio Moiane
 *
 */
@Path("consultations")
@Service(NAME)
public class ConsultationResource {

	public static final String NAME = "mz.co.msaude.integ.resources.consultation.resource.ConsultationResource";

	@Inject
	private PatientQueryService patientQueryService;

	@Inject
	private LocalityQueryService localityQueryService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response scheduleConsultation(@Context final HttpHeaders httpHeaders, final ConsultationDTO consultation) {

		final String TOKEN = httpHeaders.getHeaderString(HttpHeaders.AUTHORIZATION);
		final Client client = ClientBuilder.newClient();

		final ConsultationDTO consultationResponse = client.target(UrlTargets.CONSULTATION_MODULE).path("consultations")
		        .request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, TOKEN)
		        .post(Entity.entity(consultation, MediaType.APPLICATION_JSON), ConsultationDTO.class);

		return Response.ok(consultationResponse).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findConsultations(@Context final HttpHeaders httpHeaders,
	        @QueryParam("consultationStatus") final String consultationStatus) {

		final String TOKEN = httpHeaders.getHeaderString(HttpHeaders.AUTHORIZATION);
		final Client client = ClientBuilder.newClient();

		final GenericType<List<ConsultationDTO>> responseType = new GenericType<List<ConsultationDTO>>() {
		};

		final List<ConsultationDTO> consultations = client.target(UrlTargets.CONSULTATION_MODULE)
		        .queryParam("consultationStatus", consultationStatus).path("consultations")
		        .request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, TOKEN).get(responseType);

		consultations.forEach(consultation -> {
			this.populatePatientAndLocation(consultation);
		});

		return Response.ok(consultations).build();
	}

	private void populatePatientAndLocation(final ConsultationDTO consultation) {
		try {
			final Patient patientFound = this.patientQueryService.findPatientByUuid(consultation.getPatient());
			consultation.setPatient(patientFound.getFullName());
			final Locality locality = this.localityQueryService
			        .fetchLocalityByUuid(consultation.getHealthFacility().getLocalityUuid());
			consultation.getHealthFacility().setLocality(locality);
		}
		catch (final BusinessException e) {
			e.printStackTrace();
		}
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cancelConsultation(@Context final HttpHeaders httpHeaders, @PathParam("id") final Long id,
	        final ConsultationDTO consultationDTO) {

		final String TOKEN = httpHeaders.getHeaderString(HttpHeaders.AUTHORIZATION);
		final Client client = ClientBuilder.newClient();

		final ConsultationDTO consultationResponse = client.target(UrlTargets.CONSULTATION_MODULE)
		        .path("consultations/" + id).request(MediaType.APPLICATION_JSON)
		        .header(HttpHeaders.AUTHORIZATION, TOKEN)
		        .put(Entity.entity(consultationDTO, MediaType.APPLICATION_JSON), ConsultationDTO.class);

		return Response.ok(consultationResponse).build();
	}

}
