/**
 *
 */
package mz.co.msaude.integ.resources;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.util.UuidFactory;

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
		this.context.setUuid(UuidFactory.generate());
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		this.context.setUsername(authentication.getName());
		return this.context;
	}
}
