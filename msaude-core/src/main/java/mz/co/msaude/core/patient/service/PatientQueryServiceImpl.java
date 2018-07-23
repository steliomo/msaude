/**
 *
 */
package mz.co.msaude.core.patient.service;

import static mz.co.msaude.core.patient.service.PatientQueryServiceImpl.NAME;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.core.patient.dao.PatientDAO;
import mz.co.msaude.core.patient.model.Patient;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class PatientQueryServiceImpl implements PatientQueryService {

	public static final String NAME = "mz.co.msaude.core.patient.service.PatientQueryServiceImpl";

	@Inject
	private PatientDAO patientDAO;

	@Override
	public List<Patient> findAllPatients() throws BusinessException {
		return this.patientDAO.findAll(EntityStatus.ACTIVE);
	}
}
