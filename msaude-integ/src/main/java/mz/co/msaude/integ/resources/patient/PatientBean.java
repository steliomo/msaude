/**
 *
 */
package mz.co.msaude.integ.resources.patient;

import mz.co.msaude.core.patient.model.Patient;
import mz.co.msaude.integ.resources.BeanResource;

/**
 * @author Stélio Moiane
 *
 */
public class PatientBean extends BeanResource {

	private static final long serialVersionUID = 1L;

	private Patient patient;

	public Patient getPatient() {
		return this.patient;
	}
}
