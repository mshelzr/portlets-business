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

import com.ext.portlet.halcon.model.ValorCuota;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ValorCuota in entity cache.
 *
 * @author Infonet-Consulting
 * @see ValorCuota
 * @generated
 */
public class ValorCuotaCacheModel implements CacheModel<ValorCuota>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{IdValorCuota=");
		sb.append(IdValorCuota);
		sb.append(", tipoFondoMutuo=");
		sb.append(tipoFondoMutuo);
		sb.append(", fecha=");
		sb.append(fecha);
		sb.append(", valorCuota=");
		sb.append(valorCuota);
		sb.append("}");

		return sb.toString();
	}

	public ValorCuota toEntityModel() {
		ValorCuotaImpl valorCuotaImpl = new ValorCuotaImpl();

		valorCuotaImpl.setIdValorCuota(IdValorCuota);
		valorCuotaImpl.setTipoFondoMutuo(tipoFondoMutuo);

		if (fecha == Long.MIN_VALUE) {
			valorCuotaImpl.setFecha(null);
		}
		else {
			valorCuotaImpl.setFecha(new Date(fecha));
		}

		valorCuotaImpl.setValorCuota(valorCuota);

		valorCuotaImpl.resetOriginalValues();

		return valorCuotaImpl;
	}

	public long IdValorCuota;
	public Integer tipoFondoMutuo;
	public long fecha;
	public Double valorCuota;
}