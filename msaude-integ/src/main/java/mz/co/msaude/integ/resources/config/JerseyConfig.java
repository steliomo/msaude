/**
 *
 */
package mz.co.msaude.integ.resources.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Service;

import mz.co.msaude.integ.resources.config.user.UserResource;
import mz.co.msaude.integ.resources.consultation.resource.ConsultationResource;
import mz.co.msaude.integ.resources.doctor.resource.DoctorResource;
import mz.co.msaude.integ.resources.healthfacility.resource.HealthFacilityResource;
import mz.co.msaude.integ.resources.location.LocalityResource;
import mz.co.msaude.integ.resources.location.ProvinceResource;
import mz.co.msaude.integ.resources.patient.PatientResource;

/**
 * @author Stélio Moiane
 *
 */
@Service
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		this.register(PatientResource.class);
		this.register(ProvinceResource.class);
		this.register(LocalityResource.class);
		this.register(UserResource.class);
		this.register(ConsultationResource.class);
		this.register(HealthFacilityResource.class);
		this.register(DoctorResource.class);
	}
}
