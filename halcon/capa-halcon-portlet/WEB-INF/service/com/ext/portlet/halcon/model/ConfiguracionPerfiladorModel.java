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
 * The base model interface for the ConfiguracionPerfilador service. Represents a row in the &quot;T_CONFIGURACION_PERFILADOR&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.halcon.model.impl.ConfiguracionPerfiladorModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.halcon.model.impl.ConfiguracionPerfiladorImpl}.
 * </p>
 *
 * @author Infonet-Consulting
 * @see ConfiguracionPerfilador
 * @see com.ext.portlet.halcon.model.impl.ConfiguracionPerfiladorImpl
 * @see com.ext.portlet.halcon.model.impl.ConfiguracionPerfiladorModelImpl
 * @generated
 */
public interface ConfiguracionPerfiladorModel extends BaseModel<ConfiguracionPerfilador> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a configuracion perfilador model instance should use the {@link ConfiguracionPerfilador} interface instead.
	 */

	/**
	 * Returns the primary key of this configuracion perfilador.
	 *
	 * @return the primary key of this configuracion perfilador
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this configuracion perfilador.
	 *
	 * @param primaryKey the primary key of this configuracion perfilador
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id configuracion perfilador of this configuracion perfilador.
	 *
	 * @return the id configuracion perfilador of this configuracion perfilador
	 */
	public long getIdConfiguracionPerfilador();

	/**
	 * Sets the id configuracion perfilador of this configuracion perfilador.
	 *
	 * @param idConfiguracionPerfilador the id configuracion perfilador of this configuracion perfilador
	 */
	public void setIdConfiguracionPerfilador(long idConfiguracionPerfilador);

	/**
	 * Returns the tipo variable of this configuracion perfilador.
	 *
	 * @return the tipo variable of this configuracion perfilador
	 */
	public Long getTipoVariable();

	/**
	 * Sets the tipo variable of this configuracion perfilador.
	 *
	 * @param tipoVariable the tipo variable of this configuracion perfilador
	 */
	public void setTipoVariable(Long tipoVariable);

	/**
	 * Returns the nombre variable of this configuracion perfilador.
	 *
	 * @return the nombre variable of this configuracion perfilador
	 */
	@AutoEscape
	public String getNombreVariable();

	/**
	 * Sets the nombre variable of this configuracion perfilador.
	 *
	 * @param nombreVariable the nombre variable of this configuracion perfilador
	 */
	public void setNombreVariable(String nombreVariable);

	/**
	 * Returns the codigo clasificacion of this configuracion perfilador.
	 *
	 * @return the codigo clasificacion of this configuracion perfilador
	 */
	public Long getCodigoClasificacion();

	/**
	 * Sets the codigo clasificacion of this configuracion perfilador.
	 *
	 * @param codigoClasificacion the codigo clasificacion of this configuracion perfilador
	 */
	public void setCodigoClasificacion(Long codigoClasificacion);

	/**
	 * Returns the codigo variable padre of this configuracion perfilador.
	 *
	 * @return the codigo variable padre of this configuracion perfilador
	 */
	public Long getCodigoVariablePadre();

	/**
	 * Sets the codigo variable padre of this configuracion perfilador.
	 *
	 * @param codigoVariablePadre the codigo variable padre of this configuracion perfilador
	 */
	public void setCodigoVariablePadre(Long codigoVariablePadre);

	/**
	 * Returns the valor1 of this configuracion perfilador.
	 *
	 * @return the valor1 of this configuracion perfilador
	 */
	@AutoEscape
	public String getValor1();

	/**
	 * Sets the valor1 of this configuracion perfilador.
	 *
	 * @param valor1 the valor1 of this configuracion perfilador
	 */
	public void setValor1(String valor1);

	/**
	 * Returns the valor2 of this configuracion perfilador.
	 *
	 * @return the valor2 of this configuracion perfilador
	 */
	@AutoEscape
	public String getValor2();

	/**
	 * Sets the valor2 of this configuracion perfilador.
	 *
	 * @param valor2 the valor2 of this configuracion perfilador
	 */
	public void setValor2(String valor2);

	/**
	 * Returns the valor3 of this configuracion perfilador.
	 *
	 * @return the valor3 of this configuracion perfilador
	 */
	@AutoEscape
	public String getValor3();

	/**
	 * Sets the valor3 of this configuracion perfilador.
	 *
	 * @param valor3 the valor3 of this configuracion perfilador
	 */
	public void setValor3(String valor3);

	/**
	 * Returns the estado of this configuracion perfilador.
	 *
	 * @return the estado of this configuracion perfilador
	 */
	public Integer getEstado();

	/**
	 * Sets the estado of this configuracion perfilador.
	 *
	 * @param estado the estado of this configuracion perfilador
	 */
	public void setEstado(Integer estado);

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

	public int compareTo(ConfiguracionPerfilador configuracionPerfilador);

	public int hashCode();

	public CacheModel<ConfiguracionPerfilador> toCacheModel();

	public ConfiguracionPerfilador toEscapedModel();

	public String toString();

	public String toXmlString();
}