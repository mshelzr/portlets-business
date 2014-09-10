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

import com.ext.portlet.halcon.model.ConfiguracionPerfilador;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing ConfiguracionPerfilador in entity cache.
 *
 * @author Infonet-Consulting
 * @see ConfiguracionPerfilador
 * @generated
 */
public class ConfiguracionPerfiladorCacheModel implements CacheModel<ConfiguracionPerfilador>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{idConfiguracionPerfilador=");
		sb.append(idConfiguracionPerfilador);
		sb.append(", tipoVariable=");
		sb.append(tipoVariable);
		sb.append(", nombreVariable=");
		sb.append(nombreVariable);
		sb.append(", codigoClasificacion=");
		sb.append(codigoClasificacion);
		sb.append(", codigoVariablePadre=");
		sb.append(codigoVariablePadre);
		sb.append(", valor1=");
		sb.append(valor1);
		sb.append(", valor2=");
		sb.append(valor2);
		sb.append(", valor3=");
		sb.append(valor3);
		sb.append(", estado=");
		sb.append(estado);
		sb.append("}");

		return sb.toString();
	}

	public ConfiguracionPerfilador toEntityModel() {
		ConfiguracionPerfiladorImpl configuracionPerfiladorImpl = new ConfiguracionPerfiladorImpl();

		configuracionPerfiladorImpl.setIdConfiguracionPerfilador(idConfiguracionPerfilador);
		configuracionPerfiladorImpl.setTipoVariable(tipoVariable);

		if (nombreVariable == null) {
			configuracionPerfiladorImpl.setNombreVariable(StringPool.BLANK);
		}
		else {
			configuracionPerfiladorImpl.setNombreVariable(nombreVariable);
		}

		configuracionPerfiladorImpl.setCodigoClasificacion(codigoClasificacion);
		configuracionPerfiladorImpl.setCodigoVariablePadre(codigoVariablePadre);

		if (valor1 == null) {
			configuracionPerfiladorImpl.setValor1(StringPool.BLANK);
		}
		else {
			configuracionPerfiladorImpl.setValor1(valor1);
		}

		if (valor2 == null) {
			configuracionPerfiladorImpl.setValor2(StringPool.BLANK);
		}
		else {
			configuracionPerfiladorImpl.setValor2(valor2);
		}

		if (valor3 == null) {
			configuracionPerfiladorImpl.setValor3(StringPool.BLANK);
		}
		else {
			configuracionPerfiladorImpl.setValor3(valor3);
		}

		configuracionPerfiladorImpl.setEstado(estado);

		configuracionPerfiladorImpl.resetOriginalValues();

		return configuracionPerfiladorImpl;
	}

	public long idConfiguracionPerfilador;
	public Long tipoVariable;
	public String nombreVariable;
	public Long codigoClasificacion;
	public Long codigoVariablePadre;
	public String valor1;
	public String valor2;
	public String valor3;
	public Integer estado;
}