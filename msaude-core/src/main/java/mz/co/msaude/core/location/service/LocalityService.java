/**
 *
 */
package mz.co.msaude.core.location.service;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.core.location.model.Locality;

/**
 * @author Stélio Moiane
 *
 */
public interface LocalityService {

	Locality createLocality(final UserContext userContext, final Locality locality) throws BusinessException;

}
