/**
 *
 */
package mz.co.msaude.core.location.dao;

import static mz.co.msaude.core.location.dao.LocalityDAOImpl.NAME;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.core.location.model.Locality;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class LocalityDAOImpl extends GenericDAOImpl<Locality, Long> implements LocalityDAO {

	public static final String NAME = "mz.co.msaude.core.location.dao.LocalityDAOImpl";

}
