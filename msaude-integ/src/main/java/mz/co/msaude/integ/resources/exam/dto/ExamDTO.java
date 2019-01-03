/**
 *
 */
package mz.co.msaude.integ.resources.exam.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import mz.co.msaude.boot.frameworks.util.LocalDateAdapter;
import mz.co.msaude.boot.frameworks.util.LocalTimeAdapter;
import mz.co.msaude.integ.resources.consultation.dto.MedicalServiceTypeDTO;
import mz.co.msaude.integ.resources.dto.GenericDTO;
import mz.co.msaude.integ.resources.healthfacility.dto.HealthFacilityDTO;

/**
 * @author Stélio Moiane
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExamDTO extends GenericDTO {

	private MedicalServiceTypeDTO medicalServiceType;

	private HealthFacilityDTO healthFacility;

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate examDate;

	@XmlJavaTypeAdapter(LocalTimeAdapter.class)
	private LocalTime examTime;

	private String patient;

	private String examStatus;

	public MedicalServiceTypeDTO getMedicalServiceType() {
		return this.medicalServiceType;
	}

	public void setMedicalServiceType(final MedicalServiceTypeDTO medicalServiceType) {
		this.medicalServiceType = medicalServiceType;
	}

	public HealthFacilityDTO getHealthFacility() {
		return this.healthFacility;
	}

	public void setHealthFacility(final HealthFacilityDTO healthFacility) {
		this.healthFacility = healthFacility;
	}

	public LocalDate getExamDate() {
		return this.examDate;
	}

	public void setExamDate(final LocalDate examDate) {
		this.examDate = examDate;
	}

	public LocalTime getExamTime() {
		return this.examTime;
	}

	public void setExamTime(final LocalTime examTime) {
		this.examTime = examTime;
	}

	public String getPatient() {
		return this.patient;
	}

	public void setPatient(final String patient) {
		this.patient = patient;
	}

	public String getExamStatus() {
		return this.examStatus;
	}

	public void setExamStatus(final String examStatus) {
		this.examStatus = examStatus;
	}
}
