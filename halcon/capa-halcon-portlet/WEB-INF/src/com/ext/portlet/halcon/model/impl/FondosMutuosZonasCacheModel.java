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

import com.ext.portlet.halcon.model.FondosMutuosZonas;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing FondosMutuosZonas in entity cache.
 *
 * @author Infonet-Consulting
 * @see FondosMutuosZonas
 * @generated
 */
public class FondosMutuosZonasCacheModel implements CacheModel<FondosMutuosZonas>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{idFondoMutuoZona=");
		sb.append(idFondoMutuoZona);
		sb.append(", codigoZona=");
		sb.append(codigoZona);
		sb.append(", zona=");
		sb.append(zona);
		sb.append(", puntajeInicial=");
		sb.append(puntajeInicial);
		sb.append(", puntajeFinal=");
		sb.append(puntajeFinal);
		sb.append(", descripcionZona=");
		sb.append(descripcionZona);
		sb.append(", moneda=");
		sb.append(moneda);
		sb.append(", riesgo=");
		sb.append(riesgo);
		sb.append("}");

		return sb.toString();
	}

	public FondosMutuosZonas toEntityModel() {
		FondosMutuosZonasImpl fondosMutuosZonasImpl = new FondosMutuosZonasImpl();

		fondosMutuosZonasImpl.setIdFondoMutuoZona(idFondoMutuoZona);

		if (codigoZona == null) {
			fondosMutuosZonasImpl.setCodigoZona(StringPool.BLANK);
		}
		else {
			fondosMutuosZonasImpl.setCodigoZona(codigoZona);
		}

		if (zona == null) {
			fondosMutuosZonasImpl.setZona(StringPool.BLANK);
		}
		else {
			fondosMutuosZonasImpl.setZona(zona);
		}

		fondosMutuosZonasImpl.setPuntajeInicial(puntajeInicial);
		fondosMutuosZonasImpl.setPuntajeFinal(puntajeFinal);

		if (descripcionZona == null) {
			fondosMutuosZonasImpl.setDescripcionZona(StringPool.BLANK);
		}
		else {
			fondosMutuosZonasImpl.setDescripcionZona(descripcionZona);
		}

		if (moneda == null) {
			fondosMutuosZonasImpl.setMoneda(StringPool.BLANK);
		}
		else {
			fondosMutuosZonasImpl.setMoneda(moneda);
		}

		if (riesgo == null) {
			fondosMutuosZonasImpl.setRiesgo(StringPool.BLANK);
		}
		else {
			fondosMutuosZonasImpl.setRiesgo(riesgo);
		}

		fondosMutuosZonasImpl.resetOriginalValues();

		return fondosMutuosZonasImpl;
	}

	public long idFondoMutuoZona;
	public String codigoZona;
	public String zona;
	public Integer puntajeInicial;
	public Integer puntajeFinal;
	public String descripcionZona;
	public String moneda;
	public String riesgo;
}