/**
 *
 */
package mz.co.msaude.integ.resources.patient;

import java.io.Serializable;

import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.util.UuidFactory;
import mz.co.msaude.core.patient.model.Patient;

/**
 * @author Stélio Moiane
 *
 */
public class PatientBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private UserContext context;
	private Patient patient;

	public UserContext getContext() {
		this.context.setUuid(UuidFactory.generate());
		return this.context;
	}

	public Patient getPatient() {
		return this.patient;
	}
}
