/**
 *
 */
package mz.co.msaude.integ.resources.config.user.dao;

import mz.co.msaude.boot.frameworks.model.UserContext;

/**
 * @author Stélio Moiane
 *
 */
public interface UserDAO {

	UserContext findByUsername(String username);

	UserContext createUser(UserContext userContext);
}
