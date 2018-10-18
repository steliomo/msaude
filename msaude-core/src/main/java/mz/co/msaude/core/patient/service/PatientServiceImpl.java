/**
 *
 */
package mz.co.msaude.core.patient.service;

import static mz.co.msaude.core.patient.service.PatientServiceImpl.NAME;

import javax.inject.Inject;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.service.AbstractService;
import mz.co.msaude.core.patient.dao.PatientDAO;
import mz.co.msaude.core.patient.model.Patient;
import mz.co.msaude.core.patient.model.PatientType;
import mz.co.msaude.core.patient.model.RelationshipType;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class PatientServiceImpl extends AbstractService implements PatientService {

	public static final String NAME = "mz.co.msaude.core.patient.service.PatientServiceImpl";

	@Inject
	private PatientDAO patientDAO;

	@Inject
	Environment environment;

	@Override
	public Patient createPatient(final UserContext userContext, final Patient patient) throws BusinessException {
		return this.patientDAO.create(userContext, patient);
	}

	@Override
	public Patient updatePatient(final UserContext userContext, final Patient patient) throws BusinessException {
		return this.patientDAO.update(userContext, patient);
	}

	@Override
	public Patient createMainMember(final UserContext userContext, final Patient patient) throws BusinessException {

		if (!PatientType.MAIN_MEMBER.equals(patient.getPatientType())) {
			throw new BusinessException(this.environment.getProperty("patient.type.must.be.main.member"));
		}

		if (!RelationshipType.NONE.equals(patient.getRelationshipType())) {
			throw new BusinessException(this.environment.getProperty("patient.relationship.type.must.none"));
		}

		if (patient.getMainMemberUuid() != null) {
			throw new BusinessException(this.environment.getProperty("patient.member.uuid.must.be.null"));
		}

		return this.createPatient(userContext, patient);
	}

	@Override
	public Patient createDependent(final UserContext userContext, final Patient patient) throws BusinessException {

		if (!PatientType.DEPENDENT.equals(patient.getPatientType())) {
			throw new BusinessException(this.environment.getProperty("patient.type.must.be.dependent"));
		}

		if (RelationshipType.NONE.equals(patient.getRelationshipType())) {
			throw new BusinessException(this.environment.getProperty("patient.relationship.type.must.not.be.none"));
		}

		if (patient.getMainMemberUuid() == null) {
			throw new BusinessException(this.environment.getProperty("patient.member.uuid.must.not.be.null"));
		}

		return this.createPatient(userContext, patient);
	}
}
