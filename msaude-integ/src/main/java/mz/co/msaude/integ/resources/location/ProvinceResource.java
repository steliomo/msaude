/**
 *
 */
package mz.co.msaude.integ.resources.location;

import static mz.co.msaude.integ.resources.location.ProvinceResource.NAME;

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
import mz.co.msaude.core.location.model.Province;
import mz.co.msaude.core.location.service.ProvinceQueryService;
import mz.co.msaude.core.location.service.ProvinceService;
import mz.co.msaude.integ.resources.AbstractResource;

/**
 * @author Stélio Moiane
 *
 */
@Path("provinces")
@Service(NAME)
public class ProvinceResource extends AbstractResource {

	public static final String NAME = "mz.co.msaude.integ.resources.location.ProvinceResource";

	@Inject
	private ProvinceService provinceService;

	@Inject
	private ProvinceQueryService provinceQueryService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProvince(final Province province) throws BusinessException {

		this.provinceService.createProvince(this.getContext(), province);

		return Response.ok(province).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllProvinces() throws BusinessException {

		final List<Province> provinces = this.provinceQueryService.findAllProvinces();

		return Response.ok(provinces).build();
	}
}
