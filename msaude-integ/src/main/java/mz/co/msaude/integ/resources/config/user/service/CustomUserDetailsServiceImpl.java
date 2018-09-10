/**
 *
 */
package mz.co.msaude.integ.resources.config.user.service;

import static mz.co.msaude.integ.resources.config.user.service.CustomUserDetailsServiceImpl.NAME;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.integ.resources.config.user.dao.UserDAO;
import mz.co.msaude.integ.resources.config.user.model.UserDetailsImpl;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

	public static final String NAME = "mz.co.msaude.integ.resources.config.user.service.UserDetailsServiceImpl";

	@Inject
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		final UserContext user = this.userDAO.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return new UserDetailsImpl(user);
	}

	@Override
	public UserContext createUser(final UserContext userContext) throws BusinessException {
		return this.userDAO.createUser(userContext);
	}
}
