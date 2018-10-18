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
public class ConsultationTypeDTO extends GenericDTO {

	private String name;

	private String description;

	private String imagePath;

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public String getImagePath() {
		return this.imagePath;
	}
}
