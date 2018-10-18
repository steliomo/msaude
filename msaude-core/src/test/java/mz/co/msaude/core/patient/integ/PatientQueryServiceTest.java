/**
 *
 */
package mz.co.msaude.core.patient.integ;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
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

	private Patient patient;

	@Before
	public void setup() throws BusinessException {
		this.patient = EntityFactory.gimme(Patient.class, PatientTemplate.VALID);
		this.patientService.createPatient(this.getUserContext(), this.patient);
	}

	@Test
	public void shouldFindAllPatients() throws BusinessException {
		final List<Patient> patients = this.patientQueryService.findAllPatients();

		assertFalse(patients.isEmpty());
	}

	@Test
	public void shouldFindPatientByUuid() throws BusinessException {
		final Patient foundPatient = this.patientQueryService.findPatientByUuid(this.patient.getUuid());
		assertNotNull(foundPatient);
	}

}
