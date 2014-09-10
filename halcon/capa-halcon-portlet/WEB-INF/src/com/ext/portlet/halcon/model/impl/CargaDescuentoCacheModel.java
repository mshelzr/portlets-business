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

import com.ext.portlet.halcon.model.CargaDescuento;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CargaDescuento in entity cache.
 *
 * @author Infonet-Consulting
 * @see CargaDescuento
 * @generated
 */
public class CargaDescuentoCacheModel implements CacheModel<CargaDescuento>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{idCargaDesc=");
		sb.append(idCargaDesc);
		sb.append(", local=");
		sb.append(local);
		sb.append(", descuentoGeneral=");
		sb.append(descuentoGeneral);
		sb.append(", condicionesRestricciones=");
		sb.append(condicionesRestricciones);
		sb.append(", direccion=");
		sb.append(direccion);
		sb.append(", idDistrito=");
		sb.append(idDistrito);
		sb.append(", distrito=");
		sb.append(distrito);
		sb.append(", telefono=");
		sb.append(telefono);
		sb.append(", web=");
		sb.append(web);
		sb.append(", finVigencia=");
		sb.append(finVigencia);
		sb.append(", categoria=");
		sb.append(categoria);
		sb.append(", coordenada=");
		sb.append(coordenada);
		sb.append(", URLImagen=");
		sb.append(URLImagen);
		sb.append(", latitud=");
		sb.append(latitud);
		sb.append(", longitud=");
		sb.append(longitud);
		sb.append("}");

		return sb.toString();
	}

	public CargaDescuento toEntityModel() {
		CargaDescuentoImpl cargaDescuentoImpl = new CargaDescuentoImpl();

		cargaDescuentoImpl.setIdCargaDesc(idCargaDesc);

		if (local == null) {
			cargaDescuentoImpl.setLocal(StringPool.BLANK);
		}
		else {
			cargaDescuentoImpl.setLocal(local);
		}

		if (descuentoGeneral == null) {
			cargaDescuentoImpl.setDescuentoGeneral(StringPool.BLANK);
		}
		else {
			cargaDescuentoImpl.setDescuentoGeneral(descuentoGeneral);
		}

		if (condicionesRestricciones == null) {
			cargaDescuentoImpl.setCondicionesRestricciones(StringPool.BLANK);
		}
		else {
			cargaDescuentoImpl.setCondicionesRestricciones(condicionesRestricciones);
		}

		if (direccion == null) {
			cargaDescuentoImpl.setDireccion(StringPool.BLANK);
		}
		else {
			cargaDescuentoImpl.setDireccion(direccion);
		}

		if (idDistrito == null) {
			cargaDescuentoImpl.setIdDistrito(StringPool.BLANK);
		}
		else {
			cargaDescuentoImpl.setIdDistrito(idDistrito);
		}

		if (distrito == null) {
			cargaDescuentoImpl.setDistrito(StringPool.BLANK);
		}
		else {
			cargaDescuentoImpl.setDistrito(distrito);
		}

		if (telefono == null) {
			cargaDescuentoImpl.setTelefono(StringPool.BLANK);
		}
		else {
			cargaDescuentoImpl.setTelefono(telefono);
		}

		if (web == null) {
			cargaDescuentoImpl.setWeb(StringPool.BLANK);
		}
		else {
			cargaDescuentoImpl.setWeb(web);
		}

		if (finVigencia == Long.MIN_VALUE) {
			cargaDescuentoImpl.setFinVigencia(null);
		}
		else {
			cargaDescuentoImpl.setFinVigencia(new Date(finVigencia));
		}

		if (categoria == null) {
			cargaDescuentoImpl.setCategoria(StringPool.BLANK);
		}
		else {
			cargaDescuentoImpl.setCategoria(categoria);
		}

		if (coordenada == null) {
			cargaDescuentoImpl.setCoordenada(StringPool.BLANK);
		}
		else {
			cargaDescuentoImpl.setCoordenada(coordenada);
		}

		if (URLImagen == null) {
			cargaDescuentoImpl.setURLImagen(StringPool.BLANK);
		}
		else {
			cargaDescuentoImpl.setURLImagen(URLImagen);
		}

		if (latitud == null) {
			cargaDescuentoImpl.setLatitud(StringPool.BLANK);
		}
		else {
			cargaDescuentoImpl.setLatitud(latitud);
		}

		if (longitud == null) {
			cargaDescuentoImpl.setLongitud(StringPool.BLANK);
		}
		else {
			cargaDescuentoImpl.setLongitud(longitud);
		}

		cargaDescuentoImpl.resetOriginalValues();

		return cargaDescuentoImpl;
	}

	public long idCargaDesc;
	public String local;
	public String descuentoGeneral;
	public String condicionesRestricciones;
	public String direccion;
	public String idDistrito;
	public String distrito;
	public String telefono;
	public String web;
	public long finVigencia;
	public String categoria;
	public String coordenada;
	public String URLImagen;
	public String latitud;
	public String longitud;
}