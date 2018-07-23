/**
 *
 */
package mz.co.msaude.core.patient.dao;

import static mz.co.msaude.core.patient.dao.PatientDAOImpl.NAME;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.util.ParamBuilder;
import mz.co.msaude.core.patient.model.Patient;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class PatientDAOImpl extends GenericDAOImpl<Patient, Long> implements PatientDAO {

	public static final String NAME = "mz.co.msaude.core.patient.dao.PatientDAOImpl";

	@Override
	public List<Patient> findAll(final EntityStatus entityStatus) throws BusinessException {
		return this.findByNamedQuery(PatientDAO.QUERY_NAME.findAll,
		        new ParamBuilder().add("entityStatus", entityStatus).process());
	}

}
