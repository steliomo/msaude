/**
 *
 */
package mz.co.msaude.integ.resources.config.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;

/**
 * @author Stélio Moiane
 *
 */
public interface CustomUserDetailsService extends UserDetailsService {

	UserContext createUser(final UserContext userContext) throws BusinessException;
}
