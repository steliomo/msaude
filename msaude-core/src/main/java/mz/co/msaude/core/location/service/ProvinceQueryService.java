/**
 *
 */
package mz.co.msaude.core.location.service;

import java.util.List;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.core.location.model.Province;

/**
 * @author Stélio Moiane
 *
 */
public interface ProvinceQueryService {
	List<Province> findAllProvinces() throws BusinessException;
}
