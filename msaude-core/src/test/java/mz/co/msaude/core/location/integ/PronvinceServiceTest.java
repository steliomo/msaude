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
import mz.co.msaude.core.fixturefactory.ProvinceTemplate;
import mz.co.msaude.core.location.model.Province;
import mz.co.msaude.core.location.service.ProvinceService;

/**
 * @author Stélio Moiane
 *
 */
public class PronvinceServiceTest extends AbstractServiceTest {

	@Inject
	private ProvinceService provinceService;

	@Test
	public void shouldCreateProvince() throws BusinessException {
		final Province province = EntityFactory.gimme(Province.class, ProvinceTemplate.VALID);

		this.provinceService.createProvince(this.getUserContext(), province);

		TestUtil.assertCreation(province);
	}
}
