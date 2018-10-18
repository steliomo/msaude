/**
 *
 */
package mz.co.msaude.core.location.dao;

import java.util.List;

import mz.co.msaude.boot.frameworks.dao.GenericDAO;
import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.core.location.model.Locality;

/**
 * @author Stélio Moiane
 *
 */
public interface LocalityDAO extends GenericDAO<Locality, Long> {

	class QUERY {
		public static final String findByProvinceUuid = "SELECT l FROM Locality l INNER JOIN FETCH l.province p WHERE p.uuid = :provinceUuid AND l.entityStatus = :entityStatus";
		public static final String fetchByUuid = "SELECT l FROM Locality l INNER JOIN FETCH l.province WHERE l.uuid = :localityUuid";
	}

	class QUERY_NAME {
		public static final String findByProvinceUuid = "Locality.findByProvinceUuid";
		public static final String fetchByUuid = "Locality.fetchByUuid";
	}

	List<Locality> findByProvinceUuid(final String provinceUuid, final EntityStatus entityStatus)
	        throws BusinessException;

	Locality fetchByUuid(final String localityUuid) throws BusinessException;
}
