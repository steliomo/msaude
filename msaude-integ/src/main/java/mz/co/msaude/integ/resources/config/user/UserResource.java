/**
 *
 */
package mz.co.msaude.integ.resources.config.user;

import static mz.co.msaude.integ.resources.config.user.UserResource.NAME;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.integ.resources.config.user.model.CustomUserDetails;
import mz.co.msaude.integ.resources.config.user.service.CustomUserDetailsService;

/**
 * @author Stélio Moiane
 *
 */
@Path("users")
@Service(NAME)
public class UserResource {

	public static final String NAME = "mz.co.msaude.integ.resources.config.user.UserResource";

	@Inject
	private CustomUserDetailsService customUserDetailsService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(final UserContext userContext) throws BusinessException {

		this.customUserDetailsService.createUser(userContext);

		return Response.ok(userContext).build();
	}

	@GET
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login() {

		final CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
		        .getPrincipal();

		final UserContext context = new UserContext();
		context.setUuid(userDetails.getUuid());
		context.setFullName(userDetails.fullName());

		return Response.ok(context).build();
	}

	@PUT
	@Path("reset-password/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response resetPassword(@PathParam("email") final String email) {

		final UserContext context = new UserContext();
		context.setEmail(email);

		return Response.ok(context).build();
	}
}
