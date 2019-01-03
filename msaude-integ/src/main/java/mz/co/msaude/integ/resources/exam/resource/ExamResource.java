/**
 *
 */
package mz.co.msaude.integ.resources.exam.resource;

import static mz.co.msaude.integ.resources.exam.resource.ExamResource.NAME;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
import mz.co.msaude.integ.resources.exam.dto.ExamDTO;
import mz.co.msaude.integ.resources.util.UrlTargets;

/**
 * @author Stélio Moiane
 *
 */
@Path("exams")
@Service(NAME)
public class ExamResource {

	public static final String NAME = "mz.co.msaude.integ.resources.exam.resource.ExamResource";

	@Inject
	private PatientQueryService patientQueryService;

	@Inject
	private LocalityQueryService localityQueryService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response scheduleExam(@Context final HttpHeaders httpHeaders, final ExamDTO exam) {

		final String TOKEN = httpHeaders.getHeaderString(HttpHeaders.AUTHORIZATION);
		final Client client = ClientBuilder.newClient();

		final ExamDTO examDTOResponse = client.target(UrlTargets.CONSULTATION_MODULE).path("exams")
		        .request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, TOKEN)
		        .post(Entity.entity(exam, MediaType.APPLICATION_JSON), ExamDTO.class);

		return Response.ok(examDTOResponse).build();
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchExamByUserAndStatus(@Context final HttpHeaders httpHeaders,
	        @QueryParam("examStatus") final String examStatus) {

		final String TOKEN = httpHeaders.getHeaderString(HttpHeaders.AUTHORIZATION);
		final Client client = ClientBuilder.newClient();

		final GenericType<List<ExamDTO>> responseType = new GenericType<List<ExamDTO>>() {
		};

		final List<ExamDTO> exams = client.target(UrlTargets.CONSULTATION_MODULE).queryParam("examStatus", examStatus)
		        .path("exams").request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, TOKEN)
		        .get(responseType);

		exams.forEach(exam -> {
			this.populatePatientAndLocation(exam);
		});

		return Response.ok(exams).build();
	}

	private void populatePatientAndLocation(final ExamDTO exam) {
		try {
			final Patient patientFound = this.patientQueryService.findPatientByUuid(exam.getPatient());
			exam.setPatient(patientFound.getFullName());
			final Locality locality = this.localityQueryService
			        .fetchLocalityByUuid(exam.getHealthFacility().getLocalityUuid());
			exam.getHealthFacility().setLocality(locality);
		}
		catch (final BusinessException e) {
			e.printStackTrace();
		}
	}
}
