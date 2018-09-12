/**
 *
 */
package mz.co.msaude.core.fixturefactory;

import java.time.LocalDate;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import mz.co.msaude.boot.frameworks.model.Gender;
import mz.co.msaude.core.patient.model.Patient;

/**
 * @author Stélio Moiane
 *
 */
public class PatientTemplate implements TemplateLoader {

	public static final String VALID = "VALID";

	@Override
	public void load() {
		Fixture.of(Patient.class).addTemplate(VALID, new Rule() {
			{
				this.add("name", this.random("Stélio", "Alima", "Kamilah", "Nailah", "Câmilo"));
				this.add("surname", "Moiane");
				this.add("gender", this.random(Gender.MALE, Gender.FEMALE));
				this.add("dateOfBirth", LocalDate.now());
				this.add("phoneNumber", "+258822546100");
				this.add("email", "steliomo@gmail.com");
			}
		});
	}
}
