/**
 *
 */
package mz.co.msaude.core.location.dao;

import static mz.co.msaude.core.location.dao.ProvinceDAOImpl.NAME;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.util.ParamBuilder;
import mz.co.msaude.core.location.model.Province;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class ProvinceDAOImpl extends GenericDAOImpl<Province, Long> implements ProvinceDAO {

	public static final String NAME = "mz.co.msaude.core.location.dao.ProvinceDAOImpl";

	@Override
	public List<Province> findAllProvinces(final EntityStatus entityStatus) throws BusinessException {
		return this.findByNamedQuery(ProvinceDAO.QUERY_NAME.findAllProvinces,
		        new ParamBuilder().add("entityStatus", entityStatus).process());
	}

}
