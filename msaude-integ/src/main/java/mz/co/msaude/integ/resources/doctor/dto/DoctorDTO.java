/**
 *
 */
package mz.co.msaude.integ.resources.doctor.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import mz.co.msaude.boot.frameworks.model.Gender;
import mz.co.msaude.integ.resources.dto.GenericDTO;

/**
 * @author Stélio Moiane
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorDTO extends GenericDTO {

	private String name;

	private String surname;

	private Gender gender;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(final Gender gender) {
		this.gender = gender;
	}
}
