/**
 *
 */
package mz.co.msaude.core.location.service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.core.location.model.Province;

/**
 * @author Stélio Moiane
 *
 */
public interface ProvinceService {

	Province createProvince(final UserContext userContext, final Province province) throws BusinessException;

}
