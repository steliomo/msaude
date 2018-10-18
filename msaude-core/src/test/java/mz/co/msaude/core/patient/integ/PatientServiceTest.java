/**
 *
 */
package mz.co.msaude.core.patient.integ;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.boot.frameworks.util.TestUtil;
import mz.co.msaude.core.config.AbstractServiceTest;
import mz.co.msaude.core.fixturefactory.PatientTemplate;
import mz.co.msaude.core.patient.model.Patient;
import mz.co.msaude.core.patient.model.PatientType;
import mz.co.msaude.core.patient.model.RelationshipType;
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

	@Test
	public void shouldCreateMainMember() throws BusinessException {

		final Patient patient = EntityFactory.gimme(Patient.class, PatientTemplate.MAIN_MEMBER);

		this.patientService.createMainMember(this.getUserContext(), patient);

		assertEquals(PatientType.MAIN_MEMBER, patient.getPatientType());
		assertEquals(RelationshipType.NONE, patient.getRelationshipType());
		assertNull(patient.getMainMemberUuid());
	}

	@Test
	public void shouldCreateDependent() throws BusinessException {

		final Patient patient = EntityFactory.gimme(Patient.class, PatientTemplate.DEPENDENT);

		this.patientService.createDependent(this.getUserContext(), patient);

		assertEquals(PatientType.DEPENDENT, patient.getPatientType());
		assertThat(RelationshipType.NONE, is(not(equalTo(patient.getRelationshipType()))));
		assertNotNull(patient.getMainMemberUuid());
	}
}
