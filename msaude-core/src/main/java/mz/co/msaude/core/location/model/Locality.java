/**
 *
 */
package mz.co.msaude.core.location.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import mz.co.msaude.boot.frameworks.model.GenericEntity;
import mz.co.msaude.core.location.dao.LocalityDAO;

/**
 * @author Stélio Moiane
 *
 */
@NamedQueries({
        @NamedQuery(name = LocalityDAO.QUERY_NAME.findByProvinceUuid, query = LocalityDAO.QUERY.findByProvinceUuid),
        @NamedQuery(name = LocalityDAO.QUERY_NAME.fetchByUuid, query = LocalityDAO.QUERY.fetchByUuid) })
@Entity
@Table(name = "LOCALITIES")
public class Locality extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "NAME", nullable = false, length = 30)
	private String name;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROVINCE_ID", nullable = false)
	private Province province;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(final Province province) {
		this.province = province;
	}

	@Override
	public boolean equals(final Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "province");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "province");
	}
}
