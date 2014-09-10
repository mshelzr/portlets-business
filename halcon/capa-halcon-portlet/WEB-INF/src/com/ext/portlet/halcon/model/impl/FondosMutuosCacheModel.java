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

import com.ext.portlet.halcon.model.FondosMutuos;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing FondosMutuos in entity cache.
 *
 * @author Infonet-Consulting
 * @see FondosMutuos
 * @generated
 */
public class FondosMutuosCacheModel implements CacheModel<FondosMutuos>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{idValorCuota=");
		sb.append(idValorCuota);
		sb.append(", codigoMoneda=");
		sb.append(codigoMoneda);
		sb.append(", tipoFondo=");
		sb.append(tipoFondo);
		sb.append(", valorCuota=");
		sb.append(valorCuota);
		sb.append(", fecha=");
		sb.append(fecha);
		sb.append("}");

		return sb.toString();
	}

	public FondosMutuos toEntityModel() {
		FondosMutuosImpl fondosMutuosImpl = new FondosMutuosImpl();

		fondosMutuosImpl.setIdValorCuota(idValorCuota);

		if (codigoMoneda == null) {
			fondosMutuosImpl.setCodigoMoneda(StringPool.BLANK);
		}
		else {
			fondosMutuosImpl.setCodigoMoneda(codigoMoneda);
		}

		if (tipoFondo == null) {
			fondosMutuosImpl.setTipoFondo(StringPool.BLANK);
		}
		else {
			fondosMutuosImpl.setTipoFondo(tipoFondo);
		}

		fondosMutuosImpl.setValorCuota(valorCuota);

		if (fecha == null) {
			fondosMutuosImpl.setFecha(StringPool.BLANK);
		}
		else {
			fondosMutuosImpl.setFecha(fecha);
		}

		fondosMutuosImpl.resetOriginalValues();

		return fondosMutuosImpl;
	}

	public long idValorCuota;
	public String codigoMoneda;
	public String tipoFondo;
	public Double valorCuota;
	public String fecha;
}