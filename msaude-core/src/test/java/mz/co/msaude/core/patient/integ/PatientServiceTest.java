/**
 *
 */
package mz.co.msaude.core.patient.integ;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.boot.frameworks.util.TestUtil;
import mz.co.msaude.core.config.AbstractServiceTest;
import mz.co.msaude.core.fixturefactory.PatientTemplate;
import mz.co.msaude.core.patient.model.Patient;
import mz.co.msaude.core.patient.service.PatientService;

/**
 * @author Stélio Moiane
 *
 */
public class PatientServiceTest extends AbstractServiceTest {

	@Inject
	private PatientService patientService;

	private Patient patient;

	@Before
	public void setup() {
		this.patient = EntityFactory.gimme(Patient.class, PatientTemplate.VALID);

	}

	@Test
	public void shouldCreatePatient() throws BusinessException {
		this.patientService.createPatient(this.getUserContext(), this.patient);

		TestUtil.assertCreation(this.patient);
	}

	@Test
	public void shouldUpdatePatient() throws BusinessException {
		this.patientService.createPatient(this.getUserContext(), this.patient);
		this.patientService.updatePatient(this.getUserContext(), this.patient);

		TestUtil.assertUpdate(this.patient);
	}
}
