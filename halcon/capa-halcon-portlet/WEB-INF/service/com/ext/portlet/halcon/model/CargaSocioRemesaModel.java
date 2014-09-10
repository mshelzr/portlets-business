/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ext.portlet.halcon.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the CargaSocioRemesa service. Represents a row in the &quot;T_CARGA_SOCIO_REMESA&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.halcon.model.impl.CargaSocioRemesaModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.halcon.model.impl.CargaSocioRemesaImpl}.
 * </p>
 *
 * @author Infonet-Consulting
 * @see CargaSocioRemesa
 * @see com.ext.portlet.halcon.model.impl.CargaSocioRemesaImpl
 * @see com.ext.portlet.halcon.model.impl.CargaSocioRemesaModelImpl
 * @generated
 */
public interface CargaSocioRemesaModel extends BaseModel<CargaSocioRemesa> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a carga socio remesa model instance should use the {@link CargaSocioRemesa} interface instead.
	 */

	/**
	 * Returns the primary key of this carga socio remesa.
	 *
	 * @return the primary key of this carga socio remesa
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this carga socio remesa.
	 *
	 * @param primaryKey the primary key of this carga socio remesa
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id socio remesa of this carga socio remesa.
	 *
	 * @return the id socio remesa of this carga socio remesa
	 */
	public long getIdSocioRemesa();

	/**
	 * Sets the id socio remesa of this carga socio remesa.
	 *
	 * @param idSocioRemesa the id socio remesa of this carga socio remesa
	 */
	public void setIdSocioRemesa(long idSocioRemesa);

	/**
	 * Returns the empresa of this carga socio remesa.
	 *
	 * @return the empresa of this carga socio remesa
	 */
	@AutoEscape
	public String getEmpresa();

	/**
	 * Sets the empresa of this carga socio remesa.
	 *
	 * @param empresa the empresa of this carga socio remesa
	 */
	public void setEmpresa(String empresa);

	/**
	 * Returns the pais cobertura of this carga socio remesa.
	 *
	 * @return the pais cobertura of this carga socio remesa
	 */
	@AutoEscape
	public String getPaisCobertura();

	/**
	 * Sets the pais cobertura of this carga socio remesa.
	 *
	 * @param paisCobertura the pais cobertura of this carga socio remesa
	 */
	public void setPaisCobertura(String paisCobertura);

	/**
	 * Returns the pagina web of this carga socio remesa.
	 *
	 * @return the pagina web of this carga socio remesa
	 */
	@AutoEscape
	public String getPaginaWeb();

	/**
	 * Sets the pagina web of this carga socio remesa.
	 *
	 * @param paginaWeb the pagina web of this carga socio remesa
	 */
	public void setPaginaWeb(String paginaWeb);

	/**
	 * Returns the telefono of this carga socio remesa.
	 *
	 * @return the telefono of this carga socio remesa
	 */
	@AutoEscape
	public String getTelefono();

	/**
	 * Sets the telefono of this carga socio remesa.
	 *
	 * @param telefono the telefono of this carga socio remesa
	 */
	public void setTelefono(String telefono);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(CargaSocioRemesa cargaSocioRemesa);

	public int hashCode();

	public CacheModel<CargaSocioRemesa> toCacheModel();

	public CargaSocioRemesa toEscapedModel();

	public String toString();

	public String toXmlString();
}