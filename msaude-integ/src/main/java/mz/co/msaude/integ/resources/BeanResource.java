/**
 *
 */
package mz.co.msaude.integ.resources;

import java.io.Serializable;

import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.util.UuidFactory;

/**
 * @author Stélio Moiane
 *
 */
public abstract class BeanResource implements Serializable {

	private static final long serialVersionUID = 1L;

	private UserContext context;

	public UserContext getContext() {
		this.context.setUuid(UuidFactory.generate());
		return this.context;
	}
}
