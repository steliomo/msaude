/**
 *
 */
package mz.co.msaude.integ.resources.healthfacility.resource;

import static mz.co.msaude.integ.resources.healthfacility.resource.HealthFacilityResource.NAME;
import static mz.co.msaude.integ.resources.util.UrlTargets.CONSULTATION_MODULE;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mz.co.msaude.integ.resources.healthfacility.dto.HealthFacilityDTO;;

/**
 * @author Stélio Moiane
 *
 */
@Path("health-facilities")
@Service(NAME)
public class HealthFacilityResource {

	public static final String NAME = "mz.co.msaude.integ.resources.healthfacility.resource.HealthFacilityResource";

	@GET
	@Path("{localityUuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findHealthFacilitiesByLocationUuid(@Context final HttpHeaders httpHeaders,
	        @PathParam("localityUuid") final String localityUuid) {

		final String TOKEN = httpHeaders.getHeaderString(HttpHeaders.AUTHORIZATION);
		final Client client = ClientBuilder.newClient();

		final GenericType<List<HealthFacilityDTO>> responseType = new GenericType<List<HealthFacilityDTO>>() {
		};

		final List<HealthFacilityDTO> healthFacilities = client.target(CONSULTATION_MODULE)
		        .path("health-facilities/" + localityUuid).request(MediaType.APPLICATION_JSON)
		        .header(HttpHeaders.AUTHORIZATION, TOKEN).get(responseType);

		return Response.ok(healthFacilities).build();
	}

}
