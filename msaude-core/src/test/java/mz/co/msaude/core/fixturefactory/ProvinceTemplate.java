/**
 *
 */
package mz.co.msaude.core.fixturefactory;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import mz.co.msaude.core.location.model.Province;

/**
 * @author Stélio Moiane
 *
 */
public class ProvinceTemplate implements TemplateLoader {

	public static final String VALID = "VALID";

	@Override
	public void load() {
		Fixture.of(Province.class).addTemplate(VALID, new Rule() {
			{
				this.add("name", this.random("Maputo", "Gaza", "Inhambane", "Zambézia"));
				this.add("imagePath", "/opt/images.png");
			}
		});
	}
}
