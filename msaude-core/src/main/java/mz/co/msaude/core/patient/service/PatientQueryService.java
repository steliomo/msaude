/**
 *
 */
package mz.co.msaude.core.patient.service;

import java.util.List;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.core.patient.model.Patient;

/**
 * @author Stélio Moiane
 *
 */
public interface PatientQueryService {

	List<Patient> findAllPatients() throws BusinessException;

}
