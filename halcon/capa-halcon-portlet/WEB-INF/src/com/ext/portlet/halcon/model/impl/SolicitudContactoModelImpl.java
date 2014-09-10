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

import com.ext.portlet.halcon.model.SolicitudContacto;
import com.ext.portlet.halcon.model.SolicitudContactoModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SolicitudContacto service. Represents a row in the &quot;T_SOLICITUD_CONTACTO&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.halcon.model.SolicitudContactoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SolicitudContactoImpl}.
 * </p>
 *
 * @author Infonet-Consulting
 * @see SolicitudContactoImpl
 * @see com.ext.portlet.halcon.model.SolicitudContacto
 * @see com.ext.portlet.halcon.model.SolicitudContactoModel
 * @generated
 */
public class SolicitudContactoModelImpl extends BaseModelImpl<SolicitudContacto>
	implements SolicitudContactoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a solicitud contacto model instance should use the {@link com.ext.portlet.halcon.model.SolicitudContacto} interface instead.
	 */
	public static final String TABLE_NAME = "T_SOLICITUD_CONTACTO";
	public static final Object[][] TABLE_COLUMNS = {
			{ "slct_IdSolicitudContacto", Types.BIGINT },
			{ "slct_EsCliente", Types.INTEGER },
			{ "slct_Nombres", Types.VARCHAR },
			{ "slct_Apellidos", Types.VARCHAR },
			{ "slct_Email", Types.VARCHAR },
			{ "slct_TipoDocumento", Types.VARCHAR },
			{ "slct_Ndocumento", Types.VARCHAR },
			{ "slct_Direccion", Types.VARCHAR },
			{ "slct_Departamento", Types.VARCHAR },
			{ "slct_Provincia", Types.VARCHAR },
			{ "slct_Distrito", Types.VARCHAR },
			{ "slct_Telefono", Types.VARCHAR },
			{ "slct_Fecha", Types.TIMESTAMP },
			{ "slct_Mensaje", Types.VARCHAR },
			{ "slct_Moneda", Types.VARCHAR },
			{ "slct_Importe", Types.VARCHAR },
			{ "slct_TipoMensaje", Types.VARCHAR },
			{ "slct_TipoTema", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table T_SOLICITUD_CONTACTO (slct_IdSolicitudContacto LONG not null primary key IDENTITY,slct_EsCliente INTEGER,slct_Nombres VARCHAR(75) null,slct_Apellidos VARCHAR(75) null,slct_Email VARCHAR(75) null,slct_TipoDocumento VARCHAR(75) null,slct_Ndocumento VARCHAR(75) null,slct_Direccion VARCHAR(75) null,slct_Departamento VARCHAR(75) null,slct_Provincia VARCHAR(75) null,slct_Distrito VARCHAR(75) null,slct_Telefono VARCHAR(75) null,slct_Fecha DATE null,slct_Mensaje VARCHAR(75) null,slct_Moneda VARCHAR(75) null,slct_Importe VARCHAR(75) null,slct_TipoMensaje VARCHAR(75) null,slct_TipoTema VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table T_SOLICITUD_CONTACTO";
	public static final String DATA_SOURCE = "halconDataSource";
	public static final String SESSION_FACTORY = "halconSessionFactory";
	public static final String TX_MANAGER = "halconTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ext.portlet.halcon.model.SolicitudContacto"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ext.portlet.halcon.model.SolicitudContacto"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ext.portlet.halcon.model.SolicitudContacto"));

	public SolicitudContactoModelImpl() {
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

	public Class<?> getModelClass() {
		return SolicitudContacto.class;
	}

	public String getModelClassName() {
		return SolicitudContacto.class.getName();
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
		if (_nombres == null) {
			return StringPool.BLANK;
		}
		else {
			return _nombres;
		}
	}

	public void setNombres(String nombres) {
		_nombres = nombres;
	}

	public String getApellidos() {
		if (_apellidos == null) {
			return StringPool.BLANK;
		}
		else {
			return _apellidos;
		}
	}

	public void setApellidos(String apellidos) {
		_apellidos = apellidos;
	}

	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getTipoDocumento() {
		if (_tipoDocumento == null) {
			return StringPool.BLANK;
		}
		else {
			return _tipoDocumento;
		}
	}

	public void setTipoDocumento(String tipoDocumento) {
		_tipoDocumento = tipoDocumento;
	}

	public String getNdocumento() {
		if (_ndocumento == null) {
			return StringPool.BLANK;
		}
		else {
			return _ndocumento;
		}
	}

	public void setNdocumento(String ndocumento) {
		_ndocumento = ndocumento;
	}

	public String getDireccion() {
		if (_direccion == null) {
			return StringPool.BLANK;
		}
		else {
			return _direccion;
		}
	}

	public void setDireccion(String direccion) {
		_direccion = direccion;
	}

	public String getDepartamento() {
		if (_departamento == null) {
			return StringPool.BLANK;
		}
		else {
			return _departamento;
		}
	}

	public void setDepartamento(String departamento) {
		_departamento = departamento;
	}

	public String getProvincia() {
		if (_provincia == null) {
			return StringPool.BLANK;
		}
		else {
			return _provincia;
		}
	}

	public void setProvincia(String provincia) {
		_provincia = provincia;
	}

	public String getDistrito() {
		if (_distrito == null) {
			return StringPool.BLANK;
		}
		else {
			return _distrito;
		}
	}

	public void setDistrito(String distrito) {
		_distrito = distrito;
	}

	public String getTelefono() {
		if (_telefono == null) {
			return StringPool.BLANK;
		}
		else {
			return _telefono;
		}
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
		if (_mensaje == null) {
			return StringPool.BLANK;
		}
		else {
			return _mensaje;
		}
	}

	public void setMensaje(String mensaje) {
		_mensaje = mensaje;
	}

	public String getMoneda() {
		if (_moneda == null) {
			return StringPool.BLANK;
		}
		else {
			return _moneda;
		}
	}

	public void setMoneda(String moneda) {
		_moneda = moneda;
	}

	public String getImporte() {
		if (_importe == null) {
			return StringPool.BLANK;
		}
		else {
			return _importe;
		}
	}

	public void setImporte(String importe) {
		_importe = importe;
	}

	public String getTipoMensaje() {
		if (_tipoMensaje == null) {
			return StringPool.BLANK;
		}
		else {
			return _tipoMensaje;
		}
	}

	public void setTipoMensaje(String tipoMensaje) {
		_tipoMensaje = tipoMensaje;
	}

	public String getTipoTema() {
		if (_tipoTema == null) {
			return StringPool.BLANK;
		}
		else {
			return _tipoTema;
		}
	}

	public void setTipoTema(String tipoTema) {
		_tipoTema = tipoTema;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			SolicitudContacto.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SolicitudContacto toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (SolicitudContacto)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		SolicitudContactoImpl solicitudContactoImpl = new SolicitudContactoImpl();

		solicitudContactoImpl.setIdSolicitudContacto(getIdSolicitudContacto());
		solicitudContactoImpl.setEsCliente(getEsCliente());
		solicitudContactoImpl.setNombres(getNombres());
		solicitudContactoImpl.setApellidos(getApellidos());
		solicitudContactoImpl.setEmail(getEmail());
		solicitudContactoImpl.setTipoDocumento(getTipoDocumento());
		solicitudContactoImpl.setNdocumento(getNdocumento());
		solicitudContactoImpl.setDireccion(getDireccion());
		solicitudContactoImpl.setDepartamento(getDepartamento());
		solicitudContactoImpl.setProvincia(getProvincia());
		solicitudContactoImpl.setDistrito(getDistrito());
		solicitudContactoImpl.setTelefono(getTelefono());
		solicitudContactoImpl.setFecha(getFecha());
		solicitudContactoImpl.setMensaje(getMensaje());
		solicitudContactoImpl.setMoneda(getMoneda());
		solicitudContactoImpl.setImporte(getImporte());
		solicitudContactoImpl.setTipoMensaje(getTipoMensaje());
		solicitudContactoImpl.setTipoTema(getTipoTema());

		solicitudContactoImpl.resetOriginalValues();

		return solicitudContactoImpl;
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

		SolicitudContacto solicitudContacto = null;

		try {
			solicitudContacto = (SolicitudContacto)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<SolicitudContacto> toCacheModel() {
		SolicitudContactoCacheModel solicitudContactoCacheModel = new SolicitudContactoCacheModel();

		solicitudContactoCacheModel.idSolicitudContacto = getIdSolicitudContacto();

		solicitudContactoCacheModel.esCliente = getEsCliente();

		solicitudContactoCacheModel.nombres = getNombres();

		String nombres = solicitudContactoCacheModel.nombres;

		if ((nombres != null) && (nombres.length() == 0)) {
			solicitudContactoCacheModel.nombres = null;
		}

		solicitudContactoCacheModel.apellidos = getApellidos();

		String apellidos = solicitudContactoCacheModel.apellidos;

		if ((apellidos != null) && (apellidos.length() == 0)) {
			solicitudContactoCacheModel.apellidos = null;
		}

		solicitudContactoCacheModel.email = getEmail();

		String email = solicitudContactoCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			solicitudContactoCacheModel.email = null;
		}

		solicitudContactoCacheModel.tipoDocumento = getTipoDocumento();

		String tipoDocumento = solicitudContactoCacheModel.tipoDocumento;

		if ((tipoDocumento != null) && (tipoDocumento.length() == 0)) {
			solicitudContactoCacheModel.tipoDocumento = null;
		}

		solicitudContactoCacheModel.ndocumento = getNdocumento();

		String ndocumento = solicitudContactoCacheModel.ndocumento;

		if ((ndocumento != null) && (ndocumento.length() == 0)) {
			solicitudContactoCacheModel.ndocumento = null;
		}

		solicitudContactoCacheModel.direccion = getDireccion();

		String direccion = solicitudContactoCacheModel.direccion;

		if ((direccion != null) && (direccion.length() == 0)) {
			solicitudContactoCacheModel.direccion = null;
		}

		solicitudContactoCacheModel.departamento = getDepartamento();

		String departamento = solicitudContactoCacheModel.departamento;

		if ((departamento != null) && (departamento.length() == 0)) {
			solicitudContactoCacheModel.departamento = null;
		}

		solicitudContactoCacheModel.provincia = getProvincia();

		String provincia = solicitudContactoCacheModel.provincia;

		if ((provincia != null) && (provincia.length() == 0)) {
			solicitudContactoCacheModel.provincia = null;
		}

		solicitudContactoCacheModel.distrito = getDistrito();

		String distrito = solicitudContactoCacheModel.distrito;

		if ((distrito != null) && (distrito.length() == 0)) {
			solicitudContactoCacheModel.distrito = null;
		}

		solicitudContactoCacheModel.telefono = getTelefono();

		String telefono = solicitudContactoCacheModel.telefono;

		if ((telefono != null) && (telefono.length() == 0)) {
			solicitudContactoCacheModel.telefono = null;
		}

		Date fecha = getFecha();

		if (fecha != null) {
			solicitudContactoCacheModel.fecha = fecha.getTime();
		}
		else {
			solicitudContactoCacheModel.fecha = Long.MIN_VALUE;
		}

		solicitudContactoCacheModel.mensaje = getMensaje();

		String mensaje = solicitudContactoCacheModel.mensaje;

		if ((mensaje != null) && (mensaje.length() == 0)) {
			solicitudContactoCacheModel.mensaje = null;
		}

		solicitudContactoCacheModel.moneda = getMoneda();

		String moneda = solicitudContactoCacheModel.moneda;

		if ((moneda != null) && (moneda.length() == 0)) {
			solicitudContactoCacheModel.moneda = null;
		}

		solicitudContactoCacheModel.importe = getImporte();

		String importe = solicitudContactoCacheModel.importe;

		if ((importe != null) && (importe.length() == 0)) {
			solicitudContactoCacheModel.importe = null;
		}

		solicitudContactoCacheModel.tipoMensaje = getTipoMensaje();

		String tipoMensaje = solicitudContactoCacheModel.tipoMensaje;

		if ((tipoMensaje != null) && (tipoMensaje.length() == 0)) {
			solicitudContactoCacheModel.tipoMensaje = null;
		}

		solicitudContactoCacheModel.tipoTema = getTipoTema();

		String tipoTema = solicitudContactoCacheModel.tipoTema;

		if ((tipoTema != null) && (tipoTema.length() == 0)) {
			solicitudContactoCacheModel.tipoTema = null;
		}

		return solicitudContactoCacheModel;
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

	private static ClassLoader _classLoader = SolicitudContacto.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			SolicitudContacto.class
		};
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
	private SolicitudContacto _escapedModelProxy;
}