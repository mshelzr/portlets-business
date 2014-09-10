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

import com.ext.portlet.halcon.model.CargaTienda;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing CargaTienda in entity cache.
 *
 * @author Infonet-Consulting
 * @see CargaTienda
 * @generated
 */
public class CargaTiendaCacheModel implements CacheModel<CargaTienda>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{idCargaTienda=");
		sb.append(idCargaTienda);
		sb.append(", idPtoServicio=");
		sb.append(idPtoServicio);
		sb.append(", idCanal=");
		sb.append(idCanal);
		sb.append(", idSubCanal=");
		sb.append(idSubCanal);
		sb.append(", codDepartamento=");
		sb.append(codDepartamento);
		sb.append(", codProvincia=");
		sb.append(codProvincia);
		sb.append(", codDistrito=");
		sb.append(codDistrito);
		sb.append(", nomDepartamento=");
		sb.append(nomDepartamento);
		sb.append(", nomProvincia=");
		sb.append(nomProvincia);
		sb.append(", nomDistrito=");
		sb.append(nomDistrito);
		sb.append(", latitud=");
		sb.append(latitud);
		sb.append(", longitud=");
		sb.append(longitud);
		sb.append(", direccion=");
		sb.append(direccion);
		sb.append(", horario=");
		sb.append(horario);
		sb.append(", tipoLocacion=");
		sb.append(tipoLocacion);
		sb.append(", codTienda=");
		sb.append(codTienda);
		sb.append(", idLocacion=");
		sb.append(idLocacion);
		sb.append(", locacion=");
		sb.append(locacion);
		sb.append(", emailCom=");
		sb.append(emailCom);
		sb.append(", telefono=");
		sb.append(telefono);
		sb.append("}");

		return sb.toString();
	}

	public CargaTienda toEntityModel() {
		CargaTiendaImpl cargaTiendaImpl = new CargaTiendaImpl();

		cargaTiendaImpl.setIdCargaTienda(idCargaTienda);

		if (idPtoServicio == null) {
			cargaTiendaImpl.setIdPtoServicio(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setIdPtoServicio(idPtoServicio);
		}

		if (idCanal == null) {
			cargaTiendaImpl.setIdCanal(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setIdCanal(idCanal);
		}

		if (idSubCanal == null) {
			cargaTiendaImpl.setIdSubCanal(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setIdSubCanal(idSubCanal);
		}

		if (codDepartamento == null) {
			cargaTiendaImpl.setCodDepartamento(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setCodDepartamento(codDepartamento);
		}

		if (codProvincia == null) {
			cargaTiendaImpl.setCodProvincia(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setCodProvincia(codProvincia);
		}

		if (codDistrito == null) {
			cargaTiendaImpl.setCodDistrito(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setCodDistrito(codDistrito);
		}

		if (nomDepartamento == null) {
			cargaTiendaImpl.setNomDepartamento(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setNomDepartamento(nomDepartamento);
		}

		if (nomProvincia == null) {
			cargaTiendaImpl.setNomProvincia(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setNomProvincia(nomProvincia);
		}

		if (nomDistrito == null) {
			cargaTiendaImpl.setNomDistrito(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setNomDistrito(nomDistrito);
		}

		if (latitud == null) {
			cargaTiendaImpl.setLatitud(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setLatitud(latitud);
		}

		if (longitud == null) {
			cargaTiendaImpl.setLongitud(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setLongitud(longitud);
		}

		if (direccion == null) {
			cargaTiendaImpl.setDireccion(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setDireccion(direccion);
		}

		if (horario == null) {
			cargaTiendaImpl.setHorario(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setHorario(horario);
		}

		if (tipoLocacion == null) {
			cargaTiendaImpl.setTipoLocacion(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setTipoLocacion(tipoLocacion);
		}

		cargaTiendaImpl.setCodTienda(codTienda);
		cargaTiendaImpl.setIdLocacion(idLocacion);

		if (locacion == null) {
			cargaTiendaImpl.setLocacion(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setLocacion(locacion);
		}

		if (emailCom == null) {
			cargaTiendaImpl.setEmailCom(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setEmailCom(emailCom);
		}

		if (telefono == null) {
			cargaTiendaImpl.setTelefono(StringPool.BLANK);
		}
		else {
			cargaTiendaImpl.setTelefono(telefono);
		}

		cargaTiendaImpl.resetOriginalValues();

		return cargaTiendaImpl;
	}

	public long idCargaTienda;
	public String idPtoServicio;
	public String idCanal;
	public String idSubCanal;
	public String codDepartamento;
	public String codProvincia;
	public String codDistrito;
	public String nomDepartamento;
	public String nomProvincia;
	public String nomDistrito;
	public String latitud;
	public String longitud;
	public String direccion;
	public String horario;
	public String tipoLocacion;
	public Integer codTienda;
	public Integer idLocacion;
	public String locacion;
	public String emailCom;
	public String telefono;
}