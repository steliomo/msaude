/**
 *
 */
package mz.co.msaude.core.location.dao;

import static mz.co.msaude.core.location.dao.ProvinceDAOImpl.NAME;

import org.springframework.stereotype.Repository;

import mz.co.msaude.boot.frameworks.dao.GenericDAOImpl;
import mz.co.msaude.core.location.model.Province;

/**
 * @author Stélio Moiane
 *
 */
@Repository(NAME)
public class ProvinceDAOImpl extends GenericDAOImpl<Province, Long> implements ProvinceDAO {

	public static final String NAME = "mz.co.msaude.core.location.dao.ProvinceDAOImpl";

}
