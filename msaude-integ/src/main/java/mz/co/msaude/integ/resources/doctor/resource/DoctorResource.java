/**
 *
 */
package mz.co.msaude.integ.resources.doctor.resource;

import static mz.co.msaude.integ.resources.doctor.resource.DoctorResource.NAME;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mz.co.msaude.integ.resources.doctor.dto.DoctorDTO;
import mz.co.msaude.integ.resources.util.UrlTargets;

/**
 * @author Stélio Moiane
 *
 */
@Path("doctors")
@Service(NAME)
public class DoctorResource {

	public static final String NAME = "mz.co.msaude.integ.resources.doctor.resource.DoctorResource";

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findDoctorsByConsultationTypeAndHealthFacilityAndConsultationDate(
	        @Context final HttpHeaders httpHeaders, @QueryParam("consultationType") final String consultationType,
	        @QueryParam("healthFacility") final String healthFacility,
	        @QueryParam("consultationDate") final String consultationDate) {

		final String TOKEN = httpHeaders.getHeaderString(HttpHeaders.AUTHORIZATION);
		final Client client = ClientBuilder.newClient();

		final List<DoctorDTO> doctors = client.target(UrlTargets.CONSULTATION_MODULE).path("doctors")
		        .request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, TOKEN)
		        .get(this.getResponseType());

		return Response.ok(doctors).build();
	}

	private GenericType<List<DoctorDTO>> getResponseType() {
		final GenericType<List<DoctorDTO>> responseType = new GenericType<List<DoctorDTO>>() {
		};
		return responseType;
	}

}
