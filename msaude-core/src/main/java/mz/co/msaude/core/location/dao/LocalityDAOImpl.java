/**
 *
 */
package mz.co.msaude.core.location.dao;

import static mz.co.msaude.core.location.dao.LocalityDAOImpl.NAME;

import java.util.List;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.util.ParamBuilder;
import mz.co.msaude.core.location.model.Locality;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class LocalityDAOImpl extends GenericDAOImpl<Locality, Long> implements LocalityDAO {

	public static final String NAME = "mz.co.msaude.core.location.dao.LocalityDAOImpl";

	@Override
	public List<Locality> findByProvinceUuid(final String provinceUuid, final EntityStatus entityStatus)
	        throws BusinessException {

		return this.findByNamedQuery(LocalityDAO.QUERY_NAME.findByProvinceUuid,
		        new ParamBuilder().add("provinceUuid", provinceUuid).add("entityStatus", entityStatus).process());
	}

	@Override
	public Locality fetchByUuid(final String localityUuid) throws BusinessException {
		return this.findSingleByNamedQuery(LocalityDAO.QUERY_NAME.fetchByUuid,
		        new ParamBuilder().add("localityUuid", localityUuid).process());
	}
}
