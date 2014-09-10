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

import com.ext.portlet.halcon.service.CargaTiendaLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Infonet-Consulting
 */
public class CargaTiendaClp extends BaseModelImpl<CargaTienda>
	implements CargaTienda {
	public CargaTiendaClp() {
	}

	public Class<?> getModelClass() {
		return CargaTienda.class;
	}

	public String getModelClassName() {
		return CargaTienda.class.getName();
	}

	public long getPrimaryKey() {
		return _idCargaTienda;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdCargaTienda(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idCargaTienda);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idCargaTienda", getIdCargaTienda());
		attributes.put("idPtoServicio", getIdPtoServicio());
		attributes.put("idCanal", getIdCanal());
		attributes.put("idSubCanal", getIdSubCanal());
		attributes.put("codDepartamento", getCodDepartamento());
		attributes.put("codProvincia", getCodProvincia());
		attributes.put("codDistrito", getCodDistrito());
		attributes.put("nomDepartamento", getNomDepartamento());
		attributes.put("nomProvincia", getNomProvincia());
		attributes.put("nomDistrito", getNomDistrito());
		attributes.put("latitud", getLatitud());
		attributes.put("longitud", getLongitud());
		attributes.put("direccion", getDireccion());
		attributes.put("horario", getHorario());
		attributes.put("tipoLocacion", getTipoLocacion());
		attributes.put("codTienda", getCodTienda());
		attributes.put("idLocacion", getIdLocacion());
		attributes.put("locacion", getLocacion());
		attributes.put("emailCom", getEmailCom());
		attributes.put("telefono", getTelefono());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idCargaTienda = (Long)attributes.get("idCargaTienda");

		if (idCargaTienda != null) {
			setIdCargaTienda(idCargaTienda);
		}

		String idPtoServicio = (String)attributes.get("idPtoServicio");

		if (idPtoServicio != null) {
			setIdPtoServicio(idPtoServicio);
		}

		String idCanal = (String)attributes.get("idCanal");

		if (idCanal != null) {
			setIdCanal(idCanal);
		}

		String idSubCanal = (String)attributes.get("idSubCanal");

		if (idSubCanal != null) {
			setIdSubCanal(idSubCanal);
		}

		String codDepartamento = (String)attributes.get("codDepartamento");

		if (codDepartamento != null) {
			setCodDepartamento(codDepartamento);
		}

		String codProvincia = (String)attributes.get("codProvincia");

		if (codProvincia != null) {
			setCodProvincia(codProvincia);
		}

		String codDistrito = (String)attributes.get("codDistrito");

		if (codDistrito != null) {
			setCodDistrito(codDistrito);
		}

		String nomDepartamento = (String)attributes.get("nomDepartamento");

		if (nomDepartamento != null) {
			setNomDepartamento(nomDepartamento);
		}

		String nomProvincia = (String)attributes.get("nomProvincia");

		if (nomProvincia != null) {
			setNomProvincia(nomProvincia);
		}

		String nomDistrito = (String)attributes.get("nomDistrito");

		if (nomDistrito != null) {
			setNomDistrito(nomDistrito);
		}

		String latitud = (String)attributes.get("latitud");

		if (latitud != null) {
			setLatitud(latitud);
		}

		String longitud = (String)attributes.get("longitud");

		if (longitud != null) {
			setLongitud(longitud);
		}

		String direccion = (String)attributes.get("direccion");

		if (direccion != null) {
			setDireccion(direccion);
		}

		String horario = (String)attributes.get("horario");

		if (horario != null) {
			setHorario(horario);
		}

		String tipoLocacion = (String)attributes.get("tipoLocacion");

		if (tipoLocacion != null) {
			setTipoLocacion(tipoLocacion);
		}

		Integer codTienda = (Integer)attributes.get("codTienda");

		if (codTienda != null) {
			setCodTienda(codTienda);
		}

		Integer idLocacion = (Integer)attributes.get("idLocacion");

		if (idLocacion != null) {
			setIdLocacion(idLocacion);
		}

		String locacion = (String)attributes.get("locacion");

		if (locacion != null) {
			setLocacion(locacion);
		}

		String emailCom = (String)attributes.get("emailCom");

		if (emailCom != null) {
			setEmailCom(emailCom);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}
	}

	public long getIdCargaTienda() {
		return _idCargaTienda;
	}

	public void setIdCargaTienda(long idCargaTienda) {
		_idCargaTienda = idCargaTienda;
	}

	public String getIdPtoServicio() {
		return _idPtoServicio;
	}

	public void setIdPtoServicio(String idPtoServicio) {
		_idPtoServicio = idPtoServicio;
	}

	public String getIdCanal() {
		return _idCanal;
	}

	public void setIdCanal(String idCanal) {
		_idCanal = idCanal;
	}

	public String getIdSubCanal() {
		return _idSubCanal;
	}

	public void setIdSubCanal(String idSubCanal) {
		_idSubCanal = idSubCanal;
	}

	public String getCodDepartamento() {
		return _codDepartamento;
	}

	public void setCodDepartamento(String codDepartamento) {
		_codDepartamento = codDepartamento;
	}

	public String getCodProvincia() {
		return _codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		_codProvincia = codProvincia;
	}

	public String getCodDistrito() {
		return _codDistrito;
	}

	public void setCodDistrito(String codDistrito) {
		_codDistrito = codDistrito;
	}

	public String getNomDepartamento() {
		return _nomDepartamento;
	}

	public void setNomDepartamento(String nomDepartamento) {
		_nomDepartamento = nomDepartamento;
	}

	public String getNomProvincia() {
		return _nomProvincia;
	}

	public void setNomProvincia(String nomProvincia) {
		_nomProvincia = nomProvincia;
	}

	public String getNomDistrito() {
		return _nomDistrito;
	}

	public void setNomDistrito(String nomDistrito) {
		_nomDistrito = nomDistrito;
	}

	public String getLatitud() {
		return _latitud;
	}

	public void setLatitud(String latitud) {
		_latitud = latitud;
	}

	public String getLongitud() {
		return _longitud;
	}

	public void setLongitud(String longitud) {
		_longitud = longitud;
	}

	public String getDireccion() {
		return _direccion;
	}

	public void setDireccion(String direccion) {
		_direccion = direccion;
	}

	public String getHorario() {
		return _horario;
	}

	public void setHorario(String horario) {
		_horario = horario;
	}

	public String getTipoLocacion() {
		return _tipoLocacion;
	}

	public void setTipoLocacion(String tipoLocacion) {
		_tipoLocacion = tipoLocacion;
	}

	public Integer getCodTienda() {
		return _codTienda;
	}

	public void setCodTienda(Integer codTienda) {
		_codTienda = codTienda;
	}

	public Integer getIdLocacion() {
		return _idLocacion;
	}

	public void setIdLocacion(Integer idLocacion) {
		_idLocacion = idLocacion;
	}

	public String getLocacion() {
		return _locacion;
	}

	public void setLocacion(String locacion) {
		_locacion = locacion;
	}

	public String getEmailCom() {
		return _emailCom;
	}

	public void setEmailCom(String emailCom) {
		_emailCom = emailCom;
	}

	public String getTelefono() {
		return _telefono;
	}

	public void setTelefono(String telefono) {
		_telefono = telefono;
	}

	public BaseModel<?> getCargaTiendaRemoteModel() {
		return _cargaTiendaRemoteModel;
	}

	public void setCargaTiendaRemoteModel(BaseModel<?> cargaTiendaRemoteModel) {
		_cargaTiendaRemoteModel = cargaTiendaRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CargaTiendaLocalServiceUtil.addCargaTienda(this);
		}
		else {
			CargaTiendaLocalServiceUtil.updateCargaTienda(this);
		}
	}

	@Override
	public CargaTienda toEscapedModel() {
		return (CargaTienda)Proxy.newProxyInstance(CargaTienda.class.getClassLoader(),
			new Class[] { CargaTienda.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CargaTiendaClp clone = new CargaTiendaClp();

		clone.setIdCargaTienda(getIdCargaTienda());
		clone.setIdPtoServicio(getIdPtoServicio());
		clone.setIdCanal(getIdCanal());
		clone.setIdSubCanal(getIdSubCanal());
		clone.setCodDepartamento(getCodDepartamento());
		clone.setCodProvincia(getCodProvincia());
		clone.setCodDistrito(getCodDistrito());
		clone.setNomDepartamento(getNomDepartamento());
		clone.setNomProvincia(getNomProvincia());
		clone.setNomDistrito(getNomDistrito());
		clone.setLatitud(getLatitud());
		clone.setLongitud(getLongitud());
		clone.setDireccion(getDireccion());
		clone.setHorario(getHorario());
		clone.setTipoLocacion(getTipoLocacion());
		clone.setCodTienda(getCodTienda());
		clone.setIdLocacion(getIdLocacion());
		clone.setLocacion(getLocacion());
		clone.setEmailCom(getEmailCom());
		clone.setTelefono(getTelefono());

		return clone;
	}

	public int compareTo(CargaTienda cargaTienda) {
		long primaryKey = cargaTienda.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CargaTiendaClp cargaTienda = null;

		try {
			cargaTienda = (CargaTiendaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = cargaTienda.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{idCargaTienda=");
		sb.append(getIdCargaTienda());
		sb.append(", idPtoServicio=");
		sb.append(getIdPtoServicio());
		sb.append(", idCanal=");
		sb.append(getIdCanal());
		sb.append(", idSubCanal=");
		sb.append(getIdSubCanal());
		sb.append(", codDepartamento=");
		sb.append(getCodDepartamento());
		sb.append(", codProvincia=");
		sb.append(getCodProvincia());
		sb.append(", codDistrito=");
		sb.append(getCodDistrito());
		sb.append(", nomDepartamento=");
		sb.append(getNomDepartamento());
		sb.append(", nomProvincia=");
		sb.append(getNomProvincia());
		sb.append(", nomDistrito=");
		sb.append(getNomDistrito());
		sb.append(", latitud=");
		sb.append(getLatitud());
		sb.append(", longitud=");
		sb.append(getLongitud());
		sb.append(", direccion=");
		sb.append(getDireccion());
		sb.append(", horario=");
		sb.append(getHorario());
		sb.append(", tipoLocacion=");
		sb.append(getTipoLocacion());
		sb.append(", codTienda=");
		sb.append(getCodTienda());
		sb.append(", idLocacion=");
		sb.append(getIdLocacion());
		sb.append(", locacion=");
		sb.append(getLocacion());
		sb.append(", emailCom=");
		sb.append(getEmailCom());
		sb.append(", telefono=");
		sb.append(getTelefono());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.CargaTienda");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idCargaTienda</column-name><column-value><![CDATA[");
		sb.append(getIdCargaTienda());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idPtoServicio</column-name><column-value><![CDATA[");
		sb.append(getIdPtoServicio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idCanal</column-name><column-value><![CDATA[");
		sb.append(getIdCanal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idSubCanal</column-name><column-value><![CDATA[");
		sb.append(getIdSubCanal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codDepartamento</column-name><column-value><![CDATA[");
		sb.append(getCodDepartamento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codProvincia</column-name><column-value><![CDATA[");
		sb.append(getCodProvincia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codDistrito</column-name><column-value><![CDATA[");
		sb.append(getCodDistrito());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomDepartamento</column-name><column-value><![CDATA[");
		sb.append(getNomDepartamento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomProvincia</column-name><column-value><![CDATA[");
		sb.append(getNomProvincia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomDistrito</column-name><column-value><![CDATA[");
		sb.append(getNomDistrito());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitud</column-name><column-value><![CDATA[");
		sb.append(getLatitud());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitud</column-name><column-value><![CDATA[");
		sb.append(getLongitud());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>direccion</column-name><column-value><![CDATA[");
		sb.append(getDireccion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>horario</column-name><column-value><![CDATA[");
		sb.append(getHorario());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoLocacion</column-name><column-value><![CDATA[");
		sb.append(getTipoLocacion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codTienda</column-name><column-value><![CDATA[");
		sb.append(getCodTienda());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idLocacion</column-name><column-value><![CDATA[");
		sb.append(getIdLocacion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locacion</column-name><column-value><![CDATA[");
		sb.append(getLocacion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailCom</column-name><column-value><![CDATA[");
		sb.append(getEmailCom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefono</column-name><column-value><![CDATA[");
		sb.append(getTelefono());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idCargaTienda;
	private String _idPtoServicio;
	private String _idCanal;
	private String _idSubCanal;
	private String _codDepartamento;
	private String _codProvincia;
	private String _codDistrito;
	private String _nomDepartamento;
	private String _nomProvincia;
	private String _nomDistrito;
	private String _latitud;
	private String _longitud;
	private String _direccion;
	private String _horario;
	private String _tipoLocacion;
	private Integer _codTienda;
	private Integer _idLocacion;
	private String _locacion;
	private String _emailCom;
	private String _telefono;
	private BaseModel<?> _cargaTiendaRemoteModel;
}