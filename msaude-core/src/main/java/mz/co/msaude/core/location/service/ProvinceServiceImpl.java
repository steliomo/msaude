/**
 *
 */
package mz.co.msaude.core.location.service;

import static mz.co.msaude.core.location.service.ProvinceServiceImpl.NAME;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.service.AbstractService;
import mz.co.msaude.core.location.dao.ProvinceDAO;
import mz.co.msaude.core.location.model.Province;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class ProvinceServiceImpl extends AbstractService implements ProvinceService {

	public static final String NAME = "mz.co.msaude.core.location.service.ProvinceServiceImpl";

	@Inject
	private ProvinceDAO provinceDAO;

	@Override
	public Province createProvince(final UserContext userContext, final Province province) throws BusinessException {
		return this.provinceDAO.create(userContext, province);
	}
}
