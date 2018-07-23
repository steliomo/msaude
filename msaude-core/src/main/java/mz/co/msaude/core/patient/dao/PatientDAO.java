/**
 *
 */
package mz.co.msaude.core.patient.dao;

import java.util.List;

import mz.co.msaude.boot.frameworks.dao.GenericDAO;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.core.patient.model.Patient;

/**
 * @author Stélio Moiane
 *
 */
public interface PatientDAO extends GenericDAO<Patient, Long> {

	class QUERY {
		public static final String findAll = "SELECT p FROM Patient p WHERE p.entityStatus = :entityStatus";
	}

	class QUERY_NAME {
		public static final String findAll = "Patient.findAll";
	}

	List<Patient> findAll(EntityStatus entityStatus) throws BusinessException;
}
