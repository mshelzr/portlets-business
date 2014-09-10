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

package com.ext.portlet.halcon.model.impl;

import com.ext.portlet.halcon.model.PreguntaFrecuente;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing PreguntaFrecuente in entity cache.
 *
 * @author Infonet-Consulting
 * @see PreguntaFrecuente
 * @generated
 */
public class PreguntaFrecuenteCacheModel implements CacheModel<PreguntaFrecuente>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{idPreguntaFrecuente=");
		sb.append(idPreguntaFrecuente);
		sb.append(", idCategoriaSubCat=");
		sb.append(idCategoriaSubCat);
		sb.append(", enunciado=");
		sb.append(enunciado);
		sb.append(", respuesta=");
		sb.append(respuesta);
		sb.append(", estado=");
		sb.append(estado);
		sb.append(", etiqueta=");
		sb.append(etiqueta);
		sb.append("}");

		return sb.toString();
	}

	public PreguntaFrecuente toEntityModel() {
		PreguntaFrecuenteImpl preguntaFrecuenteImpl = new PreguntaFrecuenteImpl();

		preguntaFrecuenteImpl.setIdPreguntaFrecuente(idPreguntaFrecuente);
		preguntaFrecuenteImpl.setIdCategoriaSubCat(idCategoriaSubCat);

		if (enunciado == null) {
			preguntaFrecuenteImpl.setEnunciado(StringPool.BLANK);
		}
		else {
			preguntaFrecuenteImpl.setEnunciado(enunciado);
		}

		if (respuesta == null) {
			preguntaFrecuenteImpl.setRespuesta(StringPool.BLANK);
		}
		else {
			preguntaFrecuenteImpl.setRespuesta(respuesta);
		}

		preguntaFrecuenteImpl.setEstado(estado);

		if (etiqueta == null) {
			preguntaFrecuenteImpl.setEtiqueta(StringPool.BLANK);
		}
		else {
			preguntaFrecuenteImpl.setEtiqueta(etiqueta);
		}

		preguntaFrecuenteImpl.resetOriginalValues();

		return preguntaFrecuenteImpl;
	}

	public int idPreguntaFrecuente;
	public Integer idCategoriaSubCat;
	public String enunciado;
	public String respuesta;
	public Boolean estado;
	public String etiqueta;
}