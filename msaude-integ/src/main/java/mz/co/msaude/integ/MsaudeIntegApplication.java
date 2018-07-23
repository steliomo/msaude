/**
 *
 */
package mz.co.msaude.integ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Stélio Moiane
 *
 */
@SpringBootApplication
@ComponentScan({ "mz.co.msaude.core", "mz.co.msaude.integ" })
public class MsaudeIntegApplication {

	public static void main(final String[] args) {
		SpringApplication.run(MsaudeIntegApplication.class, args);
	}
}
