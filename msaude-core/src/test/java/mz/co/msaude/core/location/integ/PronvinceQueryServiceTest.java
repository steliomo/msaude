/**
 *
 */
package mz.co.msaude.core.location.integ;

import static org.junit.Assert.assertFalse;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.core.config.AbstractServiceTest;
import mz.co.msaude.core.fixturefactory.ProvinceTemplate;
import mz.co.msaude.core.location.model.Province;
import mz.co.msaude.core.location.service.ProvinceQueryService;
import mz.co.msaude.core.location.service.ProvinceService;

/**
 * @author Stélio Moiane
 *
 */
public class PronvinceQueryServiceTest extends AbstractServiceTest {

	@Inject
	private ProvinceService provinceService;

	@Inject
	private ProvinceQueryService provinceQueryService;

	@Before
	public void setup() throws BusinessException {
		final Province province = EntityFactory.gimme(Province.class, ProvinceTemplate.VALID);
		this.provinceService.createProvince(this.getUserContext(), province);
	}

	@Test
	public void shouldFindAllProvinces() throws BusinessException {
		final List<Province> provinces = this.provinceQueryService.findAllProvinces();
		assertFalse(provinces.isEmpty());
	}

}
