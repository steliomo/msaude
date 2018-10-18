/**
 *
 */
package mz.co.msaude.core.fixturefactory;

import java.time.LocalDate;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import mz.co.msaude.boot.frameworks.model.Gender;
import mz.co.msaude.boot.frameworks.util.UuidFactory;
import mz.co.msaude.core.patient.model.Patient;
import mz.co.msaude.core.patient.model.PatientType;
import mz.co.msaude.core.patient.model.RelationshipType;

/**
 * @author Stélio Moiane
 *
 */
public class PatientTemplate implements TemplateLoader {

	public static final String VALID = "VALID";
	public static final String MAIN_MEMBER = "MAIN_MEMBER";
	public static final String DEPENDENT = "DEPENDENT";

	@Override
	public void load() {
		Fixture.of(Patient.class).addTemplate(VALID, new Rule() {
			{
				this.add("name", this.random("Stélio", "Alima", "Kamilah", "Nailah", "Câmilo"));
				this.add("surname", "Moiane");
				this.add("gender", this.random(Gender.MALE, Gender.FEMALE));
				this.add("dateOfBirth", LocalDate.now());
				this.add("patientType", this.random(PatientType.DEPENDENT, PatientType.MAIN_MEMBER));
				this.add("relationshipType", this.random(RelationshipType.NONE, RelationshipType.PARTNER,
				        RelationshipType.SON, RelationshipType.DAUGHTER));
				this.add("phoneNumber", "+258822546100");
				this.add("email", "steliomo@gmail.com");
			}
		});

		Fixture.of(Patient.class).addTemplate(MAIN_MEMBER).inherits(VALID, new Rule() {
			{
				this.add("patientType", PatientType.MAIN_MEMBER);
				this.add("relationshipType", RelationshipType.NONE);
			}
		});

		Fixture.of(Patient.class).addTemplate(DEPENDENT).inherits(VALID, new Rule() {
			{
				this.add("patientType", PatientType.DEPENDENT);
				this.add("relationshipType",
				        this.random(RelationshipType.PARTNER, RelationshipType.SON, RelationshipType.DAUGHTER));
				this.add("mainMemberUuid", UuidFactory.generate());
			}
		});
	}
}
