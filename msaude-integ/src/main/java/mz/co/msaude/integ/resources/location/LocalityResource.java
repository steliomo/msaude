/**
 *
 */
package mz.co.msaude.integ.resources.location;

import static mz.co.msaude.integ.resources.location.LocalityResource.NAME;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.core.location.model.Locality;
import mz.co.msaude.core.location.service.LocalityService;

/**
 * @author Stélio Moiane
 *
 */
@Path("localities")
@Service(NAME)
public class LocalityResource {

	public static final String NAME = "mz.co.msaude.integ.resources.location.LocalityResource";

	@Inject
	private LocalityService localityService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createLocality(final LocationBean locationBean) throws BusinessException {

		final Locality locality = this.localityService.createLocality(locationBean.getContext(),
		        locationBean.getLocality());

		return Response.ok(locality).build();
	}
}
