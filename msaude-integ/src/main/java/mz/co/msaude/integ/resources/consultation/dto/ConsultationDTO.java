/**
 *
 */
package mz.co.msaude.integ.resources.consultation.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import mz.co.msaude.boot.frameworks.util.LocalDateAdapter;
import mz.co.msaude.boot.frameworks.util.LocalTimeAdapter;
import mz.co.msaude.integ.resources.doctor.dto.DoctorDTO;
import mz.co.msaude.integ.resources.dto.GenericDTO;
import mz.co.msaude.integ.resources.healthfacility.dto.HealthFacilityDTO;

/**
 * @author Stélio Moiane
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultationDTO extends GenericDTO {

	private ConsultationTypeDTO consultationType;

	private HealthFacilityDTO healthFacility;

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate consultationDate;

	@XmlJavaTypeAdapter(LocalTimeAdapter.class)
	private LocalTime consultationTime;

	private DoctorDTO doctor;

	private String patient;

	private String consultationStatus;

	public ConsultationTypeDTO getConsultationType() {
		return this.consultationType;
	}

	public void setConsultationType(final ConsultationTypeDTO consultationType) {
		this.consultationType = consultationType;
	}

	public HealthFacilityDTO getHealthFacility() {
		return this.healthFacility;
	}

	public void setHealthFacility(final HealthFacilityDTO healthFacility) {
		this.healthFacility = healthFacility;
	}

	public LocalDate getConsultationDate() {
		return this.consultationDate;
	}

	public void setConsultationDate(final LocalDate consultationDate) {
		this.consultationDate = consultationDate;
	}

	public LocalTime getConsultationTime() {
		return this.consultationTime;
	}

	public void setConsultationTime(final LocalTime consultationTime) {
		this.consultationTime = consultationTime;
	}

	public DoctorDTO getDoctor() {
		return this.doctor;
	}

	public void setDoctor(final DoctorDTO doctor) {
		this.doctor = doctor;
	}

	public String getPatient() {
		return this.patient;
	}

	public void setPatient(final String patient) {
		this.patient = patient;
	}

	public String getConsultationStatus() {
		return this.consultationStatus;
	}

	public void setConsultationStatus(final String consultationStatus) {
		this.consultationStatus = consultationStatus;
	}
}
