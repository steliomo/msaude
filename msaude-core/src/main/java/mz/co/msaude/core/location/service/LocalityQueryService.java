/**
 *
 */
package mz.co.msaude.core.location.service;

import java.util.List;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.core.location.model.Locality;

/**
 * @author Stélio Moiane
 *
 */
public interface LocalityQueryService {

	List<Locality> findLocalitiesByProvinceUuid(String provinceUuid) throws BusinessException;

	Locality fetchLocalityByUuid(final String localityUuid) throws BusinessException;
}
