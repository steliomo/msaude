/**
 *
 */
package mz.co.msaude.core.location.dao;

import java.util.List;

import mz.co.msaude.boot.frameworks.dao.GenericDAO;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.core.location.model.Province;

/**
 * @author Stélio Moiane
 *
 */
public interface ProvinceDAO extends GenericDAO<Province, Long> {

	public class QUERY {
		public static final String findAllProvinces = "SELECT p FROM Province p WHERE p.entityStatus = :entityStatus";
	}

	public class QUERY_NAME {

		public static final String findAllProvinces = "Province.findAllProvinces";

	}

	List<Province> findAllProvinces(EntityStatus entityStatus) throws BusinessException;

}
