/**
 *
 */
package mz.co.msaude.core.location.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import mz.co.msaude.boot.frameworks.model.GenericEntity;
import mz.co.msaude.core.location.dao.ProvinceDAO;

/**
 * @author Stélio Moiane
 *
 */
@NamedQueries({
        @NamedQuery(name = ProvinceDAO.QUERY_NAME.findAllProvinces, query = ProvinceDAO.QUERY.findAllProvinces) })
@Entity
@Table(name = "PROVINCES")
public class Province extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "NAME", nullable = false, length = 30)
	private String name;

	@NotEmpty
	@Column(name = "IMAGE_PATH", nullable = false, length = 50)
	private String imagePath;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(final String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public boolean equals(final Object that) {
		return EqualsBuilder.reflectionEquals(this, that);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
