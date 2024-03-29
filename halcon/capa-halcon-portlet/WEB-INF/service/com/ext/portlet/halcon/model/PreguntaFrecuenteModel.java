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
 * The base model interface for the PreguntaFrecuente service. Represents a row in the &quot;T_PREGUNTA_FRECUENTE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.halcon.model.impl.PreguntaFrecuenteModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.halcon.model.impl.PreguntaFrecuenteImpl}.
 * </p>
 *
 * @author Infonet-Consulting
 * @see PreguntaFrecuente
 * @see com.ext.portlet.halcon.model.impl.PreguntaFrecuenteImpl
 * @see com.ext.portlet.halcon.model.impl.PreguntaFrecuenteModelImpl
 * @generated
 */
public interface PreguntaFrecuenteModel extends BaseModel<PreguntaFrecuente> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a pregunta frecuente model instance should use the {@link PreguntaFrecuente} interface instead.
	 */

	/**
	 * Returns the primary key of this pregunta frecuente.
	 *
	 * @return the primary key of this pregunta frecuente
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this pregunta frecuente.
	 *
	 * @param primaryKey the primary key of this pregunta frecuente
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the id pregunta frecuente of this pregunta frecuente.
	 *
	 * @return the id pregunta frecuente of this pregunta frecuente
	 */
	public int getIdPreguntaFrecuente();

	/**
	 * Sets the id pregunta frecuente of this pregunta frecuente.
	 *
	 * @param idPreguntaFrecuente the id pregunta frecuente of this pregunta frecuente
	 */
	public void setIdPreguntaFrecuente(int idPreguntaFrecuente);

	/**
	 * Returns the id categoria sub cat of this pregunta frecuente.
	 *
	 * @return the id categoria sub cat of this pregunta frecuente
	 */
	public Integer getIdCategoriaSubCat();

	/**
	 * Sets the id categoria sub cat of this pregunta frecuente.
	 *
	 * @param idCategoriaSubCat the id categoria sub cat of this pregunta frecuente
	 */
	public void setIdCategoriaSubCat(Integer idCategoriaSubCat);

	/**
	 * Returns the enunciado of this pregunta frecuente.
	 *
	 * @return the enunciado of this pregunta frecuente
	 */
	@AutoEscape
	public String getEnunciado();

	/**
	 * Sets the enunciado of this pregunta frecuente.
	 *
	 * @param enunciado the enunciado of this pregunta frecuente
	 */
	public void setEnunciado(String enunciado);

	/**
	 * Returns the respuesta of this pregunta frecuente.
	 *
	 * @return the respuesta of this pregunta frecuente
	 */
	@AutoEscape
	public String getRespuesta();

	/**
	 * Sets the respuesta of this pregunta frecuente.
	 *
	 * @param respuesta the respuesta of this pregunta frecuente
	 */
	public void setRespuesta(String respuesta);

	/**
	 * Returns the estado of this pregunta frecuente.
	 *
	 * @return the estado of this pregunta frecuente
	 */
	public Boolean getEstado();

	/**
	 * Sets the estado of this pregunta frecuente.
	 *
	 * @param estado the estado of this pregunta frecuente
	 */
	public void setEstado(Boolean estado);

	/**
	 * Returns the etiqueta of this pregunta frecuente.
	 *
	 * @return the etiqueta of this pregunta frecuente
	 */
	@AutoEscape
	public String getEtiqueta();

	/**
	 * Sets the etiqueta of this pregunta frecuente.
	 *
	 * @param etiqueta the etiqueta of this pregunta frecuente
	 */
	public void setEtiqueta(String etiqueta);

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

	public int compareTo(PreguntaFrecuente preguntaFrecuente);

	public int hashCode();

	public CacheModel<PreguntaFrecuente> toCacheModel();

	public PreguntaFrecuente toEscapedModel();

	public String toString();

	public String toXmlString();
}