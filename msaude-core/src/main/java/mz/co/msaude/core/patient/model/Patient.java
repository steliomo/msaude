/**
 *
 */
package mz.co.msaude.core.patient.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import mz.co.msaude.boot.frameworks.model.Gender;
import mz.co.msaude.boot.frameworks.model.GenericEntity;
import mz.co.msaude.boot.frameworks.util.LocalDateAdapter;
import mz.co.msaude.core.patient.dao.PatientDAO;

/**
 * @author Stélio Moiane
 *
 */
@NamedQueries(@NamedQuery(name = PatientDAO.QUERY_NAME.findAll, query = PatientDAO.QUERY.findAll))
@Entity
@Table(name = "PATIENTS")
public class Patient extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "NAME", nullable = false, length = 50)
	private String name;

	@NotEmpty
	@Column(name = "SURNAME", nullable = false, length = 50)
	private String surname;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "GENDER", nullable = false, length = 15)
	private Gender gender;

	@NotNull
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	@Column(name = "DATE_OF_BIRTH", nullable = false)
	private LocalDate dateOfBirth;

	@NotEmpty
	@Column(name = "PHONE_NUMBER", nullable = false, length = 15)
	private String phoneNumber;

	@NotEmpty
	@Email
	@Column(name = "email", nullable = false, length = 50)
	private String email;

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

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(final LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	@Override
	public boolean equals(final Object that) {
		return EqualsBuilder.reflectionEquals(this, that);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}