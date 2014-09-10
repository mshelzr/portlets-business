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

import com.ext.portlet.halcon.service.CargaDescuentoLocalServiceUtil;

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
public class CargaDescuentoClp extends BaseModelImpl<CargaDescuento>
	implements CargaDescuento {
	public CargaDescuentoClp() {
	}

	public Class<?> getModelClass() {
		return CargaDescuento.class;
	}

	public String getModelClassName() {
		return CargaDescuento.class.getName();
	}

	public long getPrimaryKey() {
		return _idCargaDesc;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdCargaDesc(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idCargaDesc);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idCargaDesc", getIdCargaDesc());
		attributes.put("local", getLocal());
		attributes.put("descuentoGeneral", getDescuentoGeneral());
		attributes.put("condicionesRestricciones", getCondicionesRestricciones());
		attributes.put("direccion", getDireccion());
		attributes.put("idDistrito", getIdDistrito());
		attributes.put("distrito", getDistrito());
		attributes.put("telefono", getTelefono());
		attributes.put("web", getWeb());
		attributes.put("finVigencia", getFinVigencia());
		attributes.put("categoria", getCategoria());
		attributes.put("coordenada", getCoordenada());
		attributes.put("URLImagen", getURLImagen());
		attributes.put("latitud", getLatitud());
		attributes.put("longitud", getLongitud());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idCargaDesc = (Long)attributes.get("idCargaDesc");

		if (idCargaDesc != null) {
			setIdCargaDesc(idCargaDesc);
		}

		String local = (String)attributes.get("local");

		if (local != null) {
			setLocal(local);
		}

		String descuentoGeneral = (String)attributes.get("descuentoGeneral");

		if (descuentoGeneral != null) {
			setDescuentoGeneral(descuentoGeneral);
		}

		String condicionesRestricciones = (String)attributes.get(
				"condicionesRestricciones");

		if (condicionesRestricciones != null) {
			setCondicionesRestricciones(condicionesRestricciones);
		}

		String direccion = (String)attributes.get("direccion");

		if (direccion != null) {
			setDireccion(direccion);
		}

		String idDistrito = (String)attributes.get("idDistrito");

		if (idDistrito != null) {
			setIdDistrito(idDistrito);
		}

		String distrito = (String)attributes.get("distrito");

		if (distrito != null) {
			setDistrito(distrito);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}

		String web = (String)attributes.get("web");

		if (web != null) {
			setWeb(web);
		}

		Date finVigencia = (Date)attributes.get("finVigencia");

		if (finVigencia != null) {
			setFinVigencia(finVigencia);
		}

		String categoria = (String)attributes.get("categoria");

		if (categoria != null) {
			setCategoria(categoria);
		}

		String coordenada = (String)attributes.get("coordenada");

		if (coordenada != null) {
			setCoordenada(coordenada);
		}

		String URLImagen = (String)attributes.get("URLImagen");

		if (URLImagen != null) {
			setURLImagen(URLImagen);
		}

		String latitud = (String)attributes.get("latitud");

		if (latitud != null) {
			setLatitud(latitud);
		}

		String longitud = (String)attributes.get("longitud");

		if (longitud != null) {
			setLongitud(longitud);
		}
	}

	public long getIdCargaDesc() {
		return _idCargaDesc;
	}

	public void setIdCargaDesc(long idCargaDesc) {
		_idCargaDesc = idCargaDesc;
	}

	public String getLocal() {
		return _local;
	}

	public void setLocal(String local) {
		_local = local;
	}

	public String getDescuentoGeneral() {
		return _descuentoGeneral;
	}

	public void setDescuentoGeneral(String descuentoGeneral) {
		_descuentoGeneral = descuentoGeneral;
	}

	public String getCondicionesRestricciones() {
		return _condicionesRestricciones;
	}

	public void setCondicionesRestricciones(String condicionesRestricciones) {
		_condicionesRestricciones = condicionesRestricciones;
	}

	public String getDireccion() {
		return _direccion;
	}

	public void setDireccion(String direccion) {
		_direccion = direccion;
	}

	public String getIdDistrito() {
		return _idDistrito;
	}

	public void setIdDistrito(String idDistrito) {
		_idDistrito = idDistrito;
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

	public String getWeb() {
		return _web;
	}

	public void setWeb(String web) {
		_web = web;
	}

	public Date getFinVigencia() {
		return _finVigencia;
	}

	public void setFinVigencia(Date finVigencia) {
		_finVigencia = finVigencia;
	}

	public String getCategoria() {
		return _categoria;
	}

	public void setCategoria(String categoria) {
		_categoria = categoria;
	}

	public String getCoordenada() {
		return _coordenada;
	}

	public void setCoordenada(String coordenada) {
		_coordenada = coordenada;
	}

	public String getURLImagen() {
		return _URLImagen;
	}

	public void setURLImagen(String URLImagen) {
		_URLImagen = URLImagen;
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

	public BaseModel<?> getCargaDescuentoRemoteModel() {
		return _cargaDescuentoRemoteModel;
	}

	public void setCargaDescuentoRemoteModel(
		BaseModel<?> cargaDescuentoRemoteModel) {
		_cargaDescuentoRemoteModel = cargaDescuentoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CargaDescuentoLocalServiceUtil.addCargaDescuento(this);
		}
		else {
			CargaDescuentoLocalServiceUtil.updateCargaDescuento(this);
		}
	}

	@Override
	public CargaDescuento toEscapedModel() {
		return (CargaDescuento)Proxy.newProxyInstance(CargaDescuento.class.getClassLoader(),
			new Class[] { CargaDescuento.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CargaDescuentoClp clone = new CargaDescuentoClp();

		clone.setIdCargaDesc(getIdCargaDesc());
		clone.setLocal(getLocal());
		clone.setDescuentoGeneral(getDescuentoGeneral());
		clone.setCondicionesRestricciones(getCondicionesRestricciones());
		clone.setDireccion(getDireccion());
		clone.setIdDistrito(getIdDistrito());
		clone.setDistrito(getDistrito());
		clone.setTelefono(getTelefono());
		clone.setWeb(getWeb());
		clone.setFinVigencia(getFinVigencia());
		clone.setCategoria(getCategoria());
		clone.setCoordenada(getCoordenada());
		clone.setURLImagen(getURLImagen());
		clone.setLatitud(getLatitud());
		clone.setLongitud(getLongitud());

		return clone;
	}

	public int compareTo(CargaDescuento cargaDescuento) {
		long primaryKey = cargaDescuento.getPrimaryKey();

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

		CargaDescuentoClp cargaDescuento = null;

		try {
			cargaDescuento = (CargaDescuentoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = cargaDescuento.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{idCargaDesc=");
		sb.append(getIdCargaDesc());
		sb.append(", local=");
		sb.append(getLocal());
		sb.append(", descuentoGeneral=");
		sb.append(getDescuentoGeneral());
		sb.append(", condicionesRestricciones=");
		sb.append(getCondicionesRestricciones());
		sb.append(", direccion=");
		sb.append(getDireccion());
		sb.append(", idDistrito=");
		sb.append(getIdDistrito());
		sb.append(", distrito=");
		sb.append(getDistrito());
		sb.append(", telefono=");
		sb.append(getTelefono());
		sb.append(", web=");
		sb.append(getWeb());
		sb.append(", finVigencia=");
		sb.append(getFinVigencia());
		sb.append(", categoria=");
		sb.append(getCategoria());
		sb.append(", coordenada=");
		sb.append(getCoordenada());
		sb.append(", URLImagen=");
		sb.append(getURLImagen());
		sb.append(", latitud=");
		sb.append(getLatitud());
		sb.append(", longitud=");
		sb.append(getLongitud());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.CargaDescuento");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idCargaDesc</column-name><column-value><![CDATA[");
		sb.append(getIdCargaDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>local</column-name><column-value><![CDATA[");
		sb.append(getLocal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descuentoGeneral</column-name><column-value><![CDATA[");
		sb.append(getDescuentoGeneral());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>condicionesRestricciones</column-name><column-value><![CDATA[");
		sb.append(getCondicionesRestricciones());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>direccion</column-name><column-value><![CDATA[");
		sb.append(getDireccion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idDistrito</column-name><column-value><![CDATA[");
		sb.append(getIdDistrito());
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
			"<column><column-name>web</column-name><column-value><![CDATA[");
		sb.append(getWeb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finVigencia</column-name><column-value><![CDATA[");
		sb.append(getFinVigencia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoria</column-name><column-value><![CDATA[");
		sb.append(getCategoria());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coordenada</column-name><column-value><![CDATA[");
		sb.append(getCoordenada());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>URLImagen</column-name><column-value><![CDATA[");
		sb.append(getURLImagen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitud</column-name><column-value><![CDATA[");
		sb.append(getLatitud());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitud</column-name><column-value><![CDATA[");
		sb.append(getLongitud());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idCargaDesc;
	private String _local;
	private String _descuentoGeneral;
	private String _condicionesRestricciones;
	private String _direccion;
	private String _idDistrito;
	private String _distrito;
	private String _telefono;
	private String _web;
	private Date _finVigencia;
	private String _categoria;
	private String _coordenada;
	private String _URLImagen;
	private String _latitud;
	private String _longitud;
	private BaseModel<?> _cargaDescuentoRemoteModel;
}