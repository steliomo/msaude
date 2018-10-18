/**
 *
 */
package mz.co.msaude.core.location.service;

import static mz.co.msaude.core.location.service.ProvinceQueryServiceImpl.NAME;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.core.location.dao.ProvinceDAO;
import mz.co.msaude.core.location.model.Province;

/**
 * @author Stélio Moiane
 *
 */
@Service(NAME)
public class ProvinceQueryServiceImpl implements ProvinceQueryService {

	public static final String NAME = "mz.co.msaude.core.location.service.ProvinceQueryServiceImpl";

	@Inject
	private ProvinceDAO provinceDAO;

	@Override
	public List<Province> findAllProvinces() throws BusinessException {
		return this.provinceDAO.findAllProvinces(EntityStatus.ACTIVE);
	}
}
