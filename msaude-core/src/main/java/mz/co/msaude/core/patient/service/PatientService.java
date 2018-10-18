/**
 *
 */
package mz.co.msaude.core.patient.service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.core.patient.model.Patient;

/**
 * @author Stélio Moiane
 *
 */
public interface PatientService {

	Patient createPatient(final UserContext userContext, final Patient patient) throws BusinessException;

	Patient updatePatient(final UserContext userContext, final Patient patient) throws BusinessException;

	Patient createMainMember(final UserContext userContext, final Patient patient) throws BusinessException;

	Patient createDependent(final UserContext userContext, final Patient patient) throws BusinessException;
}
