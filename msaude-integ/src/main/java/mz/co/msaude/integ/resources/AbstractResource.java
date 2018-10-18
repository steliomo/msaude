/**
 *
 */
package mz.co.msaude.integ.resources;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.integ.resources.config.user.model.CustomUserDetails;

/**
 * @author Stélio Moiane
 *
 */
public abstract class AbstractResource {

	private final UserContext context;

	public AbstractResource() {
		this.context = new UserContext();
	}

	public UserContext getContext() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
		this.context.setUuid(principal.getUuid());
		return this.context;
	}
}
