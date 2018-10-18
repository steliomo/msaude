/**
 *
 */
package mz.co.msaude.core.location.service;

import static mz.co.msaude.core.location.service.LocalityQueryServiceImpl.NAME;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.core.location.dao.LocalityDAO;
import mz.co.msaude.core.location.model.Locality;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class LocalityQueryServiceImpl implements LocalityQueryService {

	public static final String NAME = "mz.co.msaude.core.location.service.LocalityQueryServiceImpl";

	@Inject
	private LocalityDAO localityDAO;

	@Override
	public List<Locality> findLocalitiesByProvinceUuid(final String provinceUuid) throws BusinessException {
		return this.localityDAO.findByProvinceUuid(provinceUuid, EntityStatus.ACTIVE);
	}

	@Override
	public Locality fetchLocalityByUuid(final String localityUuid) throws BusinessException {
		return this.localityDAO.fetchByUuid(localityUuid);
	}
}
