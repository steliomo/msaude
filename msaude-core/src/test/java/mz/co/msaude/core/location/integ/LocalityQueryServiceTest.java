/**
 *
 */
package mz.co.msaude.core.location.integ;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.fixturefactory.EntityFactory;
import mz.co.msaude.core.config.AbstractServiceTest;
import mz.co.msaude.core.fixturefactory.LocalityTemplate;
import mz.co.msaude.core.location.model.Locality;
import mz.co.msaude.core.location.service.LocalityQueryService;
import mz.co.msaude.core.location.service.LocalityService;
import mz.co.msaude.core.location.service.ProvinceService;

/**
 * @author Stélio Moiane
 *
 */
public class LocalityQueryServiceTest extends AbstractServiceTest {

	@Inject
	private ProvinceService provinceService;

	@Inject
	private LocalityService localityService;

	@Inject
	private LocalityQueryService localityQueryService;

	private Locality locality;

	@Before
	public void setup() throws BusinessException {
		this.locality = EntityFactory.gimme(Locality.class, LocalityTemplate.VALID);
		this.provinceService.createProvince(this.getUserContext(), this.locality.getProvince());
		this.localityService.createLocality(this.getUserContext(), this.locality);
	}

	@Test
	public void shoulFindAllLocalities() throws BusinessException {
		final List<Locality> localities = this.localityQueryService
		        .findLocalitiesByProvinceUuid(this.locality.getProvince().getUuid());
		assertFalse(localities.isEmpty());
	}

	@Test
	public void shouldFetchLocalityByUuid() throws BusinessException {
		final Locality localityFound = this.localityQueryService.fetchLocalityByUuid(this.locality.getUuid());
		assertNotNull(localityFound);
		assertNotNull(localityFound.getProvince());
	}
}
