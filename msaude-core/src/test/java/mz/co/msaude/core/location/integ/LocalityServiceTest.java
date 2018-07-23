/**
 *
 */
package mz.co.msaude.core.location.integ;

import javax.inject.Inject;

import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.boot.frameworks.util.TestUtil;
import mz.co.msaude.core.config.AbstractServiceTest;
import mz.co.msaude.core.fixturefactory.LocalityTemplate;
import mz.co.msaude.core.location.model.Locality;
import mz.co.msaude.core.location.service.LocalityService;
import mz.co.msaude.core.location.service.ProvinceService;

/**
 * @author Stélio Moiane
 *
 */
public class LocalityServiceTest extends AbstractServiceTest {

	@Inject
	private LocalityService localityService;

	@Inject
	private ProvinceService provinceService;

	@Test
	public void shouldCreateLocality() throws BusinessException {

		final Locality locality = EntityFactory.gimme(Locality.class, LocalityTemplate.VALID);
		this.provinceService.createProvince(this.getUserContext(), locality.getProvince());

		this.localityService.createLocality(this.getUserContext(), locality);

		TestUtil.assertCreation(locality);
	}
}
