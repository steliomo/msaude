/**
 *
 */
package mz.co.msaude.core.fixturefactory;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import mz.co.msaude.core.location.model.Locality;
import mz.co.msaude.core.location.model.Province;

/**
 * @author Stélio Moiane
 *
 */
public class LocalityTemplate implements TemplateLoader {

	public static final String VALID = "VALID";

	@Override
	public void load() {
		Fixture.of(Locality.class).addTemplate(VALID, new Rule() {
			{
				this.add("name", this.random("Maputo-Cidade", "Boane", "Matola"));
				this.add("province", this.one(Province.class, ProvinceTemplate.VALID));
			}
		});
	}
}
