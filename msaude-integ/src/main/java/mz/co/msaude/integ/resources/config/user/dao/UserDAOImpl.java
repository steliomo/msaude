/**
 *
 */
package mz.co.msaude.integ.resources.config.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.model.UserContext;

/**
 * @author Stélio Moiane
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	private final List<UserContext> users;

	public UserDAOImpl() {
		this.users = new ArrayList<>();
	}

	@Override
	public UserContext findByUsername(final String username) {
		return this.users.stream().filter(user -> user.getPhoneNumber().equals(username)).findFirst().get();
	}

	@Override
	public UserContext createUser(final UserContext userContext) {
		this.users.add(userContext);
		return userContext;
	}
}
