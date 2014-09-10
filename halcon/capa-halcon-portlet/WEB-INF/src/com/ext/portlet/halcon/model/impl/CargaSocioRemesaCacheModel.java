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

import com.ext.portlet.halcon.model.CargaSocioRemesa;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing CargaSocioRemesa in entity cache.
 *
 * @author Infonet-Consulting
 * @see CargaSocioRemesa
 * @generated
 */
public class CargaSocioRemesaCacheModel implements CacheModel<CargaSocioRemesa>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{idSocioRemesa=");
		sb.append(idSocioRemesa);
		sb.append(", empresa=");
		sb.append(empresa);
		sb.append(", paisCobertura=");
		sb.append(paisCobertura);
		sb.append(", paginaWeb=");
		sb.append(paginaWeb);
		sb.append(", telefono=");
		sb.append(telefono);
		sb.append("}");

		return sb.toString();
	}

	public CargaSocioRemesa toEntityModel() {
		CargaSocioRemesaImpl cargaSocioRemesaImpl = new CargaSocioRemesaImpl();

		cargaSocioRemesaImpl.setIdSocioRemesa(idSocioRemesa);

		if (empresa == null) {
			cargaSocioRemesaImpl.setEmpresa(StringPool.BLANK);
		}
		else {
			cargaSocioRemesaImpl.setEmpresa(empresa);
		}

		if (paisCobertura == null) {
			cargaSocioRemesaImpl.setPaisCobertura(StringPool.BLANK);
		}
		else {
			cargaSocioRemesaImpl.setPaisCobertura(paisCobertura);
		}

		if (paginaWeb == null) {
			cargaSocioRemesaImpl.setPaginaWeb(StringPool.BLANK);
		}
		else {
			cargaSocioRemesaImpl.setPaginaWeb(paginaWeb);
		}

		if (telefono == null) {
			cargaSocioRemesaImpl.setTelefono(StringPool.BLANK);
		}
		else {
			cargaSocioRemesaImpl.setTelefono(telefono);
		}

		cargaSocioRemesaImpl.resetOriginalValues();

		return cargaSocioRemesaImpl;
	}

	public long idSocioRemesa;
	public String empresa;
	public String paisCobertura;
	public String paginaWeb;
	public String telefono;
}