/**
 *
 */
package mz.co.msaude.integ.resources.location;

import static mz.co.msaude.integ.resources.location.ProvinceResource.NAME;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.core.location.model.Province;
import mz.co.msaude.core.location.service.ProvinceService;

/**
 * @author Stélio Moiane
 *
 */
@Path("provinces")
@Service(NAME)
public class ProvinceResource {

	public static final String NAME = "mz.co.msaude.integ.resources.location.ProvinceResource";

	@Inject
	private ProvinceService provinceService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProvince(final LocationBean locationBean) throws BusinessException {

		final Province province = this.provinceService.createProvince(locationBean.getContext(),
		        locationBean.getProvince());

		return Response.ok(province).build();
	}
}
