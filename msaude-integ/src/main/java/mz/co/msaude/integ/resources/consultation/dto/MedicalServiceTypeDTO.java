/**
 *
 */
package mz.co.msaude.integ.resources.consultation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import mz.co.msaude.integ.resources.dto.GenericDTO;

/**
 * @author Stélio Moiane
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicalServiceTypeDTO extends GenericDTO {

	private String name;

	private String description;

	private String imagePath;

	private String serviceType;

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public String getServiceType() {
		return this.serviceType;
	}
}
