/**
 *
 */
package mz.co.msaude.integ.resources.consultation.resource;

import static mz.co.msaude.integ.resources.consultation.resource.MedicalServiceTypeResource.NAME;

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

import mz.co.msaude.integ.resources.consultation.dto.MedicalServiceTypeDTO;
import mz.co.msaude.integ.resources.util.UrlTargets;

/**
 * @author Stélio Moiane
 *
 */
@Path("medical-service-types")
@Service(NAME)
public class MedicalServiceTypeResource {

	public static final String NAME = "mz.co.msaude.integ.resources.consultation.resource.MedicalServiceTypeResource";

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConsultationTypes(@Context final HttpHeaders httpHeaders,
	        @QueryParam("serviceType") final String serviceType) {

		final String TOKEN = httpHeaders.getHeaderString(HttpHeaders.AUTHORIZATION);
		final Client client = ClientBuilder.newClient();

		final GenericType<List<MedicalServiceTypeDTO>> responseType = new GenericType<List<MedicalServiceTypeDTO>>() {
		};

		final List<MedicalServiceTypeDTO> medicalServiceTypes = client.target(UrlTargets.CONSULTATION_MODULE)
		        .queryParam("serviceType", serviceType).path("medical-service-types")
		        .request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, TOKEN).get(responseType);

		return Response.ok(medicalServiceTypes).build();
	}
}
