/**
 *
 */
package mz.co.msaude.integ.resources.config.user.model;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Stélio Moiane
 *
 */
public interface CustomUserDetails extends UserDetails {

	String getUuid();

}
