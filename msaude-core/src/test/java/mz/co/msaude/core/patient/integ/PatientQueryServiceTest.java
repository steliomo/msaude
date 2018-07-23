/**
 *
 */
package mz.co.msaude.core.patient.integ;

import static org.junit.Assert.assertFalse;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.core.config.AbstractServiceTest;
import mz.co.msaude.core.fixturefactory.PatientTemplate;
import mz.co.msaude.core.patient.model.Patient;
import mz.co.msaude.core.patient.service.PatientQueryService;
import mz.co.msaude.core.patient.service.PatientService;

/**
 * @author Stélio Moiane
 *
 */
public class PatientQueryServiceTest extends AbstractServiceTest {

	@Inject
	private PatientService patientService;

	@Inject
	private PatientQueryService patientQueryService;

	@Test
	public void shouldFindAllPatients() throws BusinessException {
		final Patient patient = EntityFactory.gimme(Patient.class, PatientTemplate.VALID);
		this.patientService.createPatient(this.getUserContext(), patient);

		final List<Patient> patients = this.patientQueryService.findAllPatients();

		assertFalse(patients.isEmpty());
	}
}
