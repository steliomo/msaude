/**
 *
 */
package mz.co.msaude.core.location.service;

import static mz.co.msaude.core.location.service.LocalityServiceImpl.NAME;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.service.AbstractService;
import mz.co.msaude.core.location.dao.LocalityDAO;
import mz.co.msaude.core.location.model.Locality;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class LocalityServiceImpl extends AbstractService implements LocalityService {

	public static final String NAME = "mz.co.msaude.core.location.service.LocalityServiceImpl";

	@Inject
	private LocalityDAO localityDAO;

	@Override
	public Locality createLocality(final UserContext userContext, final Locality locality) throws BusinessException {
		return this.localityDAO.create(userContext, locality);
	}
}
