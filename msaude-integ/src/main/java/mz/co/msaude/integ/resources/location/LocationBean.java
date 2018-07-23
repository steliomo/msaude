/**
 *
 */
package mz.co.msaude.integ.resources.location;

import mz.co.msaude.core.location.model.Locality;
import mz.co.msaude.core.location.model.Province;
import mz.co.msaude.integ.resources.BeanResource;

/**
 * @author Stélio Moiane
 *
 */
public class LocationBean extends BeanResource {

	private static final long serialVersionUID = 1L;

	private Province province;

	private Locality locality;

	public Province getProvince() {
		return this.province;
	}

	public Locality getLocality() {
		return this.locality;
	}
}
