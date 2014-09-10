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

import com.ext.portlet.halcon.service.SolicitudContactoLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Infonet-Consulting
 */
public class SolicitudContactoClp extends BaseModelImpl<SolicitudContacto>
	implements SolicitudContacto {
	public SolicitudContactoClp() {
	}

	public Class<?> getModelClass() {
		return SolicitudContacto.class;
	}

	public String getModelClassName() {
		return SolicitudContacto.class.getName();
	}

	public long getPrimaryKey() {
		return _idSolicitudContacto;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdSolicitudContacto(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idSolicitudContacto);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idSolicitudContacto", getIdSolicitudContacto());
		attributes.put("esCliente", getEsCliente());
		attributes.put("nombres", getNombres());
		attributes.put("apellidos", getApellidos());
		attributes.put("email", getEmail());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("ndocumento", getNdocumento());
		attributes.put("direccion", getDireccion());
		attributes.put("departamento", getDepartamento());
		attributes.put("provincia", getProvincia());
		attributes.put("distrito", getDistrito());
		attributes.put("telefono", getTelefono());
		attributes.put("fecha", getFecha());
		attributes.put("mensaje", getMensaje());
		attributes.put("moneda", getMoneda());
		attributes.put("importe", getImporte());
		attributes.put("tipoMensaje", getTipoMensaje());
		attributes.put("tipoTema", getTipoTema());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idSolicitudContacto = (Long)attributes.get("idSolicitudContacto");

		if (idSolicitudContacto != null) {
			setIdSolicitudContacto(idSolicitudContacto);
		}

		Integer esCliente = (Integer)attributes.get("esCliente");

		if (esCliente != null) {
			setEsCliente(esCliente);
		}

		String nombres = (String)attributes.get("nombres");

		if (nombres != null) {
			setNombres(nombres);
		}

		String apellidos = (String)attributes.get("apellidos");

		if (apellidos != null) {
			setApellidos(apellidos);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String tipoDocumento = (String)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		String ndocumento = (String)attributes.get("ndocumento");

		if (ndocumento != null) {
			setNdocumento(ndocumento);
		}

		String direccion = (String)attributes.get("direccion");

		if (direccion != null) {
			setDireccion(direccion);
		}

		String departamento = (String)attributes.get("departamento");

		if (departamento != null) {
			setDepartamento(departamento);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		String distrito = (String)attributes.get("distrito");

		if (distrito != null) {
			setDistrito(distrito);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}

		Date fecha = (Date)attributes.get("fecha");

		if (fecha != null) {
			setFecha(fecha);
		}

		String mensaje = (String)attributes.get("mensaje");

		if (mensaje != null) {
			setMensaje(mensaje);
		}

		String moneda = (String)attributes.get("moneda");

		if (moneda != null) {
			setMoneda(moneda);
		}

		String importe = (String)attributes.get("importe");

		if (importe != null) {
			setImporte(importe);
		}

		String tipoMensaje = (String)attributes.get("tipoMensaje");

		if (tipoMensaje != null) {
			setTipoMensaje(tipoMensaje);
		}

		String tipoTema = (String)attributes.get("tipoTema");

		if (tipoTema != null) {
			setTipoTema(tipoTema);
		}
	}

	public long getIdSolicitudContacto() {
		return _idSolicitudContacto;
	}

	public void setIdSolicitudContacto(long idSolicitudContacto) {
		_idSolicitudContacto = idSolicitudContacto;
	}

	public Integer getEsCliente() {
		return _esCliente;
	}

	public void setEsCliente(Integer esCliente) {
		_esCliente = esCliente;
	}

	public String getNombres() {
		return _nombres;
	}

	public void setNombres(String nombres) {
		_nombres = nombres;
	}

	public String getApellidos() {
		return _apellidos;
	}

	public void setApellidos(String apellidos) {
		_apellidos = apellidos;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getTipoDocumento() {
		return _tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		_tipoDocumento = tipoDocumento;
	}

	public String getNdocumento() {
		return _ndocumento;
	}

	public void setNdocumento(String ndocumento) {
		_ndocumento = ndocumento;
	}

	public String getDireccion() {
		return _direccion;
	}

	public void setDireccion(String direccion) {
		_direccion = direccion;
	}

	public String getDepartamento() {
		return _departamento;
	}

	public void setDepartamento(String departamento) {
		_departamento = departamento;
	}

	public String getProvincia() {
		return _provincia;
	}

	public void setProvincia(String provincia) {
		_provincia = provincia;
	}

	public String getDistrito() {
		return _distrito;
	}

	public void setDistrito(String distrito) {
		_distrito = distrito;
	}

	public String getTelefono() {
		return _telefono;
	}

	public void setTelefono(String telefono) {
		_telefono = telefono;
	}

	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	public String getMensaje() {
		return _mensaje;
	}

	public void setMensaje(String mensaje) {
		_mensaje = mensaje;
	}

	public String getMoneda() {
		return _moneda;
	}

	public void setMoneda(String moneda) {
		_moneda = moneda;
	}

	public String getImporte() {
		return _importe;
	}

	public void setImporte(String importe) {
		_importe = importe;
	}

	public String getTipoMensaje() {
		return _tipoMensaje;
	}

	public void setTipoMensaje(String tipoMensaje) {
		_tipoMensaje = tipoMensaje;
	}

	public String getTipoTema() {
		return _tipoTema;
	}

	public void setTipoTema(String tipoTema) {
		_tipoTema = tipoTema;
	}

	public BaseModel<?> getSolicitudContactoRemoteModel() {
		return _solicitudContactoRemoteModel;
	}

	public void setSolicitudContactoRemoteModel(
		BaseModel<?> solicitudContactoRemoteModel) {
		_solicitudContactoRemoteModel = solicitudContactoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			SolicitudContactoLocalServiceUtil.addSolicitudContacto(this);
		}
		else {
			SolicitudContactoLocalServiceUtil.updateSolicitudContacto(this);
		}
	}

	@Override
	public SolicitudContacto toEscapedModel() {
		return (SolicitudContacto)Proxy.newProxyInstance(SolicitudContacto.class.getClassLoader(),
			new Class[] { SolicitudContacto.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SolicitudContactoClp clone = new SolicitudContactoClp();

		clone.setIdSolicitudContacto(getIdSolicitudContacto());
		clone.setEsCliente(getEsCliente());
		clone.setNombres(getNombres());
		clone.setApellidos(getApellidos());
		clone.setEmail(getEmail());
		clone.setTipoDocumento(getTipoDocumento());
		clone.setNdocumento(getNdocumento());
		clone.setDireccion(getDireccion());
		clone.setDepartamento(getDepartamento());
		clone.setProvincia(getProvincia());
		clone.setDistrito(getDistrito());
		clone.setTelefono(getTelefono());
		clone.setFecha(getFecha());
		clone.setMensaje(getMensaje());
		clone.setMoneda(getMoneda());
		clone.setImporte(getImporte());
		clone.setTipoMensaje(getTipoMensaje());
		clone.setTipoTema(getTipoTema());

		return clone;
	}

	public int compareTo(SolicitudContacto solicitudContacto) {
		long primaryKey = solicitudContacto.getPrimaryKey();

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

		SolicitudContactoClp solicitudContacto = null;

		try {
			solicitudContacto = (SolicitudContactoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = solicitudContacto.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{idSolicitudContacto=");
		sb.append(getIdSolicitudContacto());
		sb.append(", esCliente=");
		sb.append(getEsCliente());
		sb.append(", nombres=");
		sb.append(getNombres());
		sb.append(", apellidos=");
		sb.append(getApellidos());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", tipoDocumento=");
		sb.append(getTipoDocumento());
		sb.append(", ndocumento=");
		sb.append(getNdocumento());
		sb.append(", direccion=");
		sb.append(getDireccion());
		sb.append(", departamento=");
		sb.append(getDepartamento());
		sb.append(", provincia=");
		sb.append(getProvincia());
		sb.append(", distrito=");
		sb.append(getDistrito());
		sb.append(", telefono=");
		sb.append(getTelefono());
		sb.append(", fecha=");
		sb.append(getFecha());
		sb.append(", mensaje=");
		sb.append(getMensaje());
		sb.append(", moneda=");
		sb.append(getMoneda());
		sb.append(", importe=");
		sb.append(getImporte());
		sb.append(", tipoMensaje=");
		sb.append(getTipoMensaje());
		sb.append(", tipoTema=");
		sb.append(getTipoTema());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.SolicitudContacto");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idSolicitudContacto</column-name><column-value><![CDATA[");
		sb.append(getIdSolicitudContacto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esCliente</column-name><column-value><![CDATA[");
		sb.append(getEsCliente());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombres</column-name><column-value><![CDATA[");
		sb.append(getNombres());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>apellidos</column-name><column-value><![CDATA[");
		sb.append(getApellidos());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoDocumento</column-name><column-value><![CDATA[");
		sb.append(getTipoDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ndocumento</column-name><column-value><![CDATA[");
		sb.append(getNdocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>direccion</column-name><column-value><![CDATA[");
		sb.append(getDireccion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departamento</column-name><column-value><![CDATA[");
		sb.append(getDepartamento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>provincia</column-name><column-value><![CDATA[");
		sb.append(getProvincia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>distrito</column-name><column-value><![CDATA[");
		sb.append(getDistrito());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefono</column-name><column-value><![CDATA[");
		sb.append(getTelefono());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecha</column-name><column-value><![CDATA[");
		sb.append(getFecha());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mensaje</column-name><column-value><![CDATA[");
		sb.append(getMensaje());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moneda</column-name><column-value><![CDATA[");
		sb.append(getMoneda());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>importe</column-name><column-value><![CDATA[");
		sb.append(getImporte());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoMensaje</column-name><column-value><![CDATA[");
		sb.append(getTipoMensaje());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoTema</column-name><column-value><![CDATA[");
		sb.append(getTipoTema());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idSolicitudContacto;
	private Integer _esCliente;
	private String _nombres;
	private String _apellidos;
	private String _email;
	private String _tipoDocumento;
	private String _ndocumento;
	private String _direccion;
	private String _departamento;
	private String _provincia;
	private String _distrito;
	private String _telefono;
	private Date _fecha;
	private String _mensaje;
	private String _moneda;
	private String _importe;
	private String _tipoMensaje;
	private String _tipoTema;
	private BaseModel<?> _solicitudContactoRemoteModel;
}