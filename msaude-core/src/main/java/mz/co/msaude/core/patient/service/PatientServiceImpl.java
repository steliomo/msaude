/**
 *
 */
package mz.co.msaude.core.patient.service;

import static mz.co.msaude.core.patient.service.PatientServiceImpl.NAME;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.service.AbstractService;
import mz.co.msaude.core.patient.dao.PatientDAO;
import mz.co.msaude.core.patient.model.Patient;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class PatientServiceImpl extends AbstractService implements PatientService {

	public static final String NAME = "mz.co.msaude.core.patient.service.PatientServiceImpl";

	@Inject
	private PatientDAO patientDAO;

	@Override
	public Patient createPatient(final UserContext userContext, final Patient patient) throws BusinessException {
		return this.patientDAO.create(userContext, patient);
	}

	@Override
	public Patient updatePatient(final UserContext userContext, final Patient patient) throws BusinessException {
		return this.patientDAO.update(userContext, patient);
	}
}
