/**
 *
 */
package mz.co.msaude.integ.resources.healthfacility.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import mz.co.msaude.core.location.model.Locality;
import mz.co.msaude.integ.resources.dto.GenericDTO;

/**
 * @author Stélio Moiane
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HealthFacilityDTO extends GenericDTO {

	private String name;

	private String localityUuid;

	private Locality locality;

	public String getName() {
		return this.name;
	}

	public String getLocalityUuid() {
		return this.localityUuid;
	}

	public Locality getLocality() {
		return this.locality;
	}

	public void setLocality(final Locality locality) {
		this.locality = locality;
	}
}
