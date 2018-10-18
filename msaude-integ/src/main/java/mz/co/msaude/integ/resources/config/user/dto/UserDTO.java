/**
 *
 */
package mz.co.msaude.integ.resources.config.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Stélio Moiane
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

	private String username;

	private String password;

	private String createdBy;

	private String fullName;

	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public void setCreatedBy(final String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}
}
