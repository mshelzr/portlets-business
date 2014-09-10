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

import com.ext.portlet.halcon.model.AuditoriaCajaSorpresa;
import com.ext.portlet.halcon.model.AuditoriaCajaSorpresaModel;
import com.ext.portlet.halcon.model.AuditoriaCajaSorpresaSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the AuditoriaCajaSorpresa service. Represents a row in the &quot;T_AUDITORIA_CAJA_SORPRESA&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.halcon.model.AuditoriaCajaSorpresaModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AuditoriaCajaSorpresaImpl}.
 * </p>
 *
 * @author Infonet-Consulting
 * @see AuditoriaCajaSorpresaImpl
 * @see com.ext.portlet.halcon.model.AuditoriaCajaSorpresa
 * @see com.ext.portlet.halcon.model.AuditoriaCajaSorpresaModel
 * @generated
 */
@JSON(strict = true)
public class AuditoriaCajaSorpresaModelImpl extends BaseModelImpl<AuditoriaCajaSorpresa>
	implements AuditoriaCajaSorpresaModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a auditoria caja sorpresa model instance should use the {@link com.ext.portlet.halcon.model.AuditoriaCajaSorpresa} interface instead.
	 */
	public static final String TABLE_NAME = "T_AUDITORIA_CAJA_SORPRESA";
	public static final Object[][] TABLE_COLUMNS = {
			{ "aucs_IdAuditoriaCajSorp", Types.BIGINT },
			{ "aucs_IdTransaccion", Types.VARCHAR },
			{ "aucs_TipoDocumento", Types.VARCHAR },
			{ "aucs_NumDocumento", Types.VARCHAR },
			{ "aucs_Producto1", Types.VARCHAR },
			{ "aucs_Producto2", Types.VARCHAR },
			{ "aucs_Producto3", Types.VARCHAR },
			{ "aucs_Producto4", Types.VARCHAR },
			{ "aucs_CodProducto1", Types.VARCHAR },
			{ "aucs_CodProducto2", Types.VARCHAR },
			{ "aucs_CodProducto3", Types.VARCHAR },
			{ "aucs_CodProducto4", Types.VARCHAR },
			{ "aucs_IP", Types.VARCHAR },
			{ "aucs_Session", Types.VARCHAR },
			{ "aucs_FechaHora", Types.TIMESTAMP },
			{ "aucs_UTMSource", Types.VARCHAR },
			{ "aucs_UTMMedium", Types.VARCHAR },
			{ "aucs_UTMCampaing", Types.VARCHAR },
			{ "aucs_UTMContent", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table T_AUDITORIA_CAJA_SORPRESA (aucs_IdAuditoriaCajSorp LONG not null primary key IDENTITY,aucs_IdTransaccion VARCHAR(75) null,aucs_TipoDocumento VARCHAR(75) null,aucs_NumDocumento VARCHAR(75) null,aucs_Producto1 VARCHAR(75) null,aucs_Producto2 VARCHAR(75) null,aucs_Producto3 VARCHAR(75) null,aucs_Producto4 VARCHAR(75) null,aucs_CodProducto1 VARCHAR(75) null,aucs_CodProducto2 VARCHAR(75) null,aucs_CodProducto3 VARCHAR(75) null,aucs_CodProducto4 VARCHAR(75) null,aucs_IP VARCHAR(75) null,aucs_Session VARCHAR(75) null,aucs_FechaHora DATE null,aucs_UTMSource VARCHAR(75) null,aucs_UTMMedium VARCHAR(75) null,aucs_UTMCampaing VARCHAR(75) null,aucs_UTMContent VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table T_AUDITORIA_CAJA_SORPRESA";
	public static final String DATA_SOURCE = "halconDataSource";
	public static final String SESSION_FACTORY = "halconSessionFactory";
	public static final String TX_MANAGER = "halconTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ext.portlet.halcon.model.AuditoriaCajaSorpresa"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ext.portlet.halcon.model.AuditoriaCajaSorpresa"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AuditoriaCajaSorpresa toModel(
		AuditoriaCajaSorpresaSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AuditoriaCajaSorpresa model = new AuditoriaCajaSorpresaImpl();

		model.setIdAuditoriaCajSorp(soapModel.getIdAuditoriaCajSorp());
		model.setIdTransaccion(soapModel.getIdTransaccion());
		model.setTipoDocumento(soapModel.getTipoDocumento());
		model.setNumDocumento(soapModel.getNumDocumento());
		model.setProducto1(soapModel.getProducto1());
		model.setProducto2(soapModel.getProducto2());
		model.setProducto3(soapModel.getProducto3());
		model.setProducto4(soapModel.getProducto4());
		model.setCodProducto1(soapModel.getCodProducto1());
		model.setCodProducto2(soapModel.getCodProducto2());
		model.setCodProducto3(soapModel.getCodProducto3());
		model.setCodProducto4(soapModel.getCodProducto4());
		model.setIP(soapModel.getIP());
		model.setSession(soapModel.getSession());
		model.setFechaHora(soapModel.getFechaHora());
		model.setUTMSource(soapModel.getUTMSource());
		model.setUTMMedium(soapModel.getUTMMedium());
		model.setUTMCampaing(soapModel.getUTMCampaing());
		model.setUTMContent(soapModel.getUTMContent());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AuditoriaCajaSorpresa> toModels(
		AuditoriaCajaSorpresaSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AuditoriaCajaSorpresa> models = new ArrayList<AuditoriaCajaSorpresa>(soapModels.length);

		for (AuditoriaCajaSorpresaSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ext.portlet.halcon.model.AuditoriaCajaSorpresa"));

	public AuditoriaCajaSorpresaModelImpl() {
	}

	public long getPrimaryKey() {
		return _idAuditoriaCajSorp;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdAuditoriaCajSorp(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idAuditoriaCajSorp);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return AuditoriaCajaSorpresa.class;
	}

	public String getModelClassName() {
		return AuditoriaCajaSorpresa.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idAuditoriaCajSorp", getIdAuditoriaCajSorp());
		attributes.put("idTransaccion", getIdTransaccion());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("numDocumento", getNumDocumento());
		attributes.put("producto1", getProducto1());
		attributes.put("producto2", getProducto2());
		attributes.put("producto3", getProducto3());
		attributes.put("producto4", getProducto4());
		attributes.put("codProducto1", getCodProducto1());
		attributes.put("codProducto2", getCodProducto2());
		attributes.put("codProducto3", getCodProducto3());
		attributes.put("codProducto4", getCodProducto4());
		attributes.put("IP", getIP());
		attributes.put("session", getSession());
		attributes.put("fechaHora", getFechaHora());
		attributes.put("UTMSource", getUTMSource());
		attributes.put("UTMMedium", getUTMMedium());
		attributes.put("UTMCampaing", getUTMCampaing());
		attributes.put("UTMContent", getUTMContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idAuditoriaCajSorp = (Long)attributes.get("idAuditoriaCajSorp");

		if (idAuditoriaCajSorp != null) {
			setIdAuditoriaCajSorp(idAuditoriaCajSorp);
		}

		String idTransaccion = (String)attributes.get("idTransaccion");

		if (idTransaccion != null) {
			setIdTransaccion(idTransaccion);
		}

		String tipoDocumento = (String)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		String numDocumento = (String)attributes.get("numDocumento");

		if (numDocumento != null) {
			setNumDocumento(numDocumento);
		}

		String producto1 = (String)attributes.get("producto1");

		if (producto1 != null) {
			setProducto1(producto1);
		}

		String producto2 = (String)attributes.get("producto2");

		if (producto2 != null) {
			setProducto2(producto2);
		}

		String producto3 = (String)attributes.get("producto3");

		if (producto3 != null) {
			setProducto3(producto3);
		}

		String producto4 = (String)attributes.get("producto4");

		if (producto4 != null) {
			setProducto4(producto4);
		}

		String codProducto1 = (String)attributes.get("codProducto1");

		if (codProducto1 != null) {
			setCodProducto1(codProducto1);
		}

		String codProducto2 = (String)attributes.get("codProducto2");

		if (codProducto2 != null) {
			setCodProducto2(codProducto2);
		}

		String codProducto3 = (String)attributes.get("codProducto3");

		if (codProducto3 != null) {
			setCodProducto3(codProducto3);
		}

		String codProducto4 = (String)attributes.get("codProducto4");

		if (codProducto4 != null) {
			setCodProducto4(codProducto4);
		}

		String IP = (String)attributes.get("IP");

		if (IP != null) {
			setIP(IP);
		}

		String session = (String)attributes.get("session");

		if (session != null) {
			setSession(session);
		}

		Date fechaHora = (Date)attributes.get("fechaHora");

		if (fechaHora != null) {
			setFechaHora(fechaHora);
		}

		String UTMSource = (String)attributes.get("UTMSource");

		if (UTMSource != null) {
			setUTMSource(UTMSource);
		}

		String UTMMedium = (String)attributes.get("UTMMedium");

		if (UTMMedium != null) {
			setUTMMedium(UTMMedium);
		}

		String UTMCampaing = (String)attributes.get("UTMCampaing");

		if (UTMCampaing != null) {
			setUTMCampaing(UTMCampaing);
		}

		String UTMContent = (String)attributes.get("UTMContent");

		if (UTMContent != null) {
			setUTMContent(UTMContent);
		}
	}

	@JSON
	public long getIdAuditoriaCajSorp() {
		return _idAuditoriaCajSorp;
	}

	public void setIdAuditoriaCajSorp(long idAuditoriaCajSorp) {
		_idAuditoriaCajSorp = idAuditoriaCajSorp;
	}

	@JSON
	public String getIdTransaccion() {
		if (_idTransaccion == null) {
			return StringPool.BLANK;
		}
		else {
			return _idTransaccion;
		}
	}

	public void setIdTransaccion(String idTransaccion) {
		_idTransaccion = idTransaccion;
	}

	@JSON
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

	@JSON
	public String getNumDocumento() {
		if (_numDocumento == null) {
			return StringPool.BLANK;
		}
		else {
			return _numDocumento;
		}
	}

	public void setNumDocumento(String numDocumento) {
		_numDocumento = numDocumento;
	}

	@JSON
	public String getProducto1() {
		if (_producto1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _producto1;
		}
	}

	public void setProducto1(String producto1) {
		_producto1 = producto1;
	}

	@JSON
	public String getProducto2() {
		if (_producto2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _producto2;
		}
	}

	public void setProducto2(String producto2) {
		_producto2 = producto2;
	}

	@JSON
	public String getProducto3() {
		if (_producto3 == null) {
			return StringPool.BLANK;
		}
		else {
			return _producto3;
		}
	}

	public void setProducto3(String producto3) {
		_producto3 = producto3;
	}

	@JSON
	public String getProducto4() {
		if (_producto4 == null) {
			return StringPool.BLANK;
		}
		else {
			return _producto4;
		}
	}

	public void setProducto4(String producto4) {
		_producto4 = producto4;
	}

	@JSON
	public String getCodProducto1() {
		if (_codProducto1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _codProducto1;
		}
	}

	public void setCodProducto1(String codProducto1) {
		_codProducto1 = codProducto1;
	}

	@JSON
	public String getCodProducto2() {
		if (_codProducto2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _codProducto2;
		}
	}

	public void setCodProducto2(String codProducto2) {
		_codProducto2 = codProducto2;
	}

	@JSON
	public String getCodProducto3() {
		if (_codProducto3 == null) {
			return StringPool.BLANK;
		}
		else {
			return _codProducto3;
		}
	}

	public void setCodProducto3(String codProducto3) {
		_codProducto3 = codProducto3;
	}

	@JSON
	public String getCodProducto4() {
		if (_codProducto4 == null) {
			return StringPool.BLANK;
		}
		else {
			return _codProducto4;
		}
	}

	public void setCodProducto4(String codProducto4) {
		_codProducto4 = codProducto4;
	}

	@JSON
	public String getIP() {
		if (_IP == null) {
			return StringPool.BLANK;
		}
		else {
			return _IP;
		}
	}

	public void setIP(String IP) {
		_IP = IP;
	}

	@JSON
	public String getSession() {
		if (_session == null) {
			return StringPool.BLANK;
		}
		else {
			return _session;
		}
	}

	public void setSession(String session) {
		_session = session;
	}

	@JSON
	public Date getFechaHora() {
		return _fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		_fechaHora = fechaHora;
	}

	@JSON
	public String getUTMSource() {
		if (_UTMSource == null) {
			return StringPool.BLANK;
		}
		else {
			return _UTMSource;
		}
	}

	public void setUTMSource(String UTMSource) {
		_UTMSource = UTMSource;
	}

	@JSON
	public String getUTMMedium() {
		if (_UTMMedium == null) {
			return StringPool.BLANK;
		}
		else {
			return _UTMMedium;
		}
	}

	public void setUTMMedium(String UTMMedium) {
		_UTMMedium = UTMMedium;
	}

	@JSON
	public String getUTMCampaing() {
		if (_UTMCampaing == null) {
			return StringPool.BLANK;
		}
		else {
			return _UTMCampaing;
		}
	}

	public void setUTMCampaing(String UTMCampaing) {
		_UTMCampaing = UTMCampaing;
	}

	@JSON
	public String getUTMContent() {
		if (_UTMContent == null) {
			return StringPool.BLANK;
		}
		else {
			return _UTMContent;
		}
	}

	public void setUTMContent(String UTMContent) {
		_UTMContent = UTMContent;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			AuditoriaCajaSorpresa.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AuditoriaCajaSorpresa toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (AuditoriaCajaSorpresa)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		AuditoriaCajaSorpresaImpl auditoriaCajaSorpresaImpl = new AuditoriaCajaSorpresaImpl();

		auditoriaCajaSorpresaImpl.setIdAuditoriaCajSorp(getIdAuditoriaCajSorp());
		auditoriaCajaSorpresaImpl.setIdTransaccion(getIdTransaccion());
		auditoriaCajaSorpresaImpl.setTipoDocumento(getTipoDocumento());
		auditoriaCajaSorpresaImpl.setNumDocumento(getNumDocumento());
		auditoriaCajaSorpresaImpl.setProducto1(getProducto1());
		auditoriaCajaSorpresaImpl.setProducto2(getProducto2());
		auditoriaCajaSorpresaImpl.setProducto3(getProducto3());
		auditoriaCajaSorpresaImpl.setProducto4(getProducto4());
		auditoriaCajaSorpresaImpl.setCodProducto1(getCodProducto1());
		auditoriaCajaSorpresaImpl.setCodProducto2(getCodProducto2());
		auditoriaCajaSorpresaImpl.setCodProducto3(getCodProducto3());
		auditoriaCajaSorpresaImpl.setCodProducto4(getCodProducto4());
		auditoriaCajaSorpresaImpl.setIP(getIP());
		auditoriaCajaSorpresaImpl.setSession(getSession());
		auditoriaCajaSorpresaImpl.setFechaHora(getFechaHora());
		auditoriaCajaSorpresaImpl.setUTMSource(getUTMSource());
		auditoriaCajaSorpresaImpl.setUTMMedium(getUTMMedium());
		auditoriaCajaSorpresaImpl.setUTMCampaing(getUTMCampaing());
		auditoriaCajaSorpresaImpl.setUTMContent(getUTMContent());

		auditoriaCajaSorpresaImpl.resetOriginalValues();

		return auditoriaCajaSorpresaImpl;
	}

	public int compareTo(AuditoriaCajaSorpresa auditoriaCajaSorpresa) {
		long primaryKey = auditoriaCajaSorpresa.getPrimaryKey();

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

		AuditoriaCajaSorpresa auditoriaCajaSorpresa = null;

		try {
			auditoriaCajaSorpresa = (AuditoriaCajaSorpresa)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = auditoriaCajaSorpresa.getPrimaryKey();

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
	public CacheModel<AuditoriaCajaSorpresa> toCacheModel() {
		AuditoriaCajaSorpresaCacheModel auditoriaCajaSorpresaCacheModel = new AuditoriaCajaSorpresaCacheModel();

		auditoriaCajaSorpresaCacheModel.idAuditoriaCajSorp = getIdAuditoriaCajSorp();

		auditoriaCajaSorpresaCacheModel.idTransaccion = getIdTransaccion();

		String idTransaccion = auditoriaCajaSorpresaCacheModel.idTransaccion;

		if ((idTransaccion != null) && (idTransaccion.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.idTransaccion = null;
		}

		auditoriaCajaSorpresaCacheModel.tipoDocumento = getTipoDocumento();

		String tipoDocumento = auditoriaCajaSorpresaCacheModel.tipoDocumento;

		if ((tipoDocumento != null) && (tipoDocumento.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.tipoDocumento = null;
		}

		auditoriaCajaSorpresaCacheModel.numDocumento = getNumDocumento();

		String numDocumento = auditoriaCajaSorpresaCacheModel.numDocumento;

		if ((numDocumento != null) && (numDocumento.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.numDocumento = null;
		}

		auditoriaCajaSorpresaCacheModel.producto1 = getProducto1();

		String producto1 = auditoriaCajaSorpresaCacheModel.producto1;

		if ((producto1 != null) && (producto1.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.producto1 = null;
		}

		auditoriaCajaSorpresaCacheModel.producto2 = getProducto2();

		String producto2 = auditoriaCajaSorpresaCacheModel.producto2;

		if ((producto2 != null) && (producto2.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.producto2 = null;
		}

		auditoriaCajaSorpresaCacheModel.producto3 = getProducto3();

		String producto3 = auditoriaCajaSorpresaCacheModel.producto3;

		if ((producto3 != null) && (producto3.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.producto3 = null;
		}

		auditoriaCajaSorpresaCacheModel.producto4 = getProducto4();

		String producto4 = auditoriaCajaSorpresaCacheModel.producto4;

		if ((producto4 != null) && (producto4.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.producto4 = null;
		}

		auditoriaCajaSorpresaCacheModel.codProducto1 = getCodProducto1();

		String codProducto1 = auditoriaCajaSorpresaCacheModel.codProducto1;

		if ((codProducto1 != null) && (codProducto1.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.codProducto1 = null;
		}

		auditoriaCajaSorpresaCacheModel.codProducto2 = getCodProducto2();

		String codProducto2 = auditoriaCajaSorpresaCacheModel.codProducto2;

		if ((codProducto2 != null) && (codProducto2.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.codProducto2 = null;
		}

		auditoriaCajaSorpresaCacheModel.codProducto3 = getCodProducto3();

		String codProducto3 = auditoriaCajaSorpresaCacheModel.codProducto3;

		if ((codProducto3 != null) && (codProducto3.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.codProducto3 = null;
		}

		auditoriaCajaSorpresaCacheModel.codProducto4 = getCodProducto4();

		String codProducto4 = auditoriaCajaSorpresaCacheModel.codProducto4;

		if ((codProducto4 != null) && (codProducto4.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.codProducto4 = null;
		}

		auditoriaCajaSorpresaCacheModel.IP = getIP();

		String IP = auditoriaCajaSorpresaCacheModel.IP;

		if ((IP != null) && (IP.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.IP = null;
		}

		auditoriaCajaSorpresaCacheModel.session = getSession();

		String session = auditoriaCajaSorpresaCacheModel.session;

		if ((session != null) && (session.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.session = null;
		}

		Date fechaHora = getFechaHora();

		if (fechaHora != null) {
			auditoriaCajaSorpresaCacheModel.fechaHora = fechaHora.getTime();
		}
		else {
			auditoriaCajaSorpresaCacheModel.fechaHora = Long.MIN_VALUE;
		}

		auditoriaCajaSorpresaCacheModel.UTMSource = getUTMSource();

		String UTMSource = auditoriaCajaSorpresaCacheModel.UTMSource;

		if ((UTMSource != null) && (UTMSource.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.UTMSource = null;
		}

		auditoriaCajaSorpresaCacheModel.UTMMedium = getUTMMedium();

		String UTMMedium = auditoriaCajaSorpresaCacheModel.UTMMedium;

		if ((UTMMedium != null) && (UTMMedium.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.UTMMedium = null;
		}

		auditoriaCajaSorpresaCacheModel.UTMCampaing = getUTMCampaing();

		String UTMCampaing = auditoriaCajaSorpresaCacheModel.UTMCampaing;

		if ((UTMCampaing != null) && (UTMCampaing.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.UTMCampaing = null;
		}

		auditoriaCajaSorpresaCacheModel.UTMContent = getUTMContent();

		String UTMContent = auditoriaCajaSorpresaCacheModel.UTMContent;

		if ((UTMContent != null) && (UTMContent.length() == 0)) {
			auditoriaCajaSorpresaCacheModel.UTMContent = null;
		}

		return auditoriaCajaSorpresaCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{idAuditoriaCajSorp=");
		sb.append(getIdAuditoriaCajSorp());
		sb.append(", idTransaccion=");
		sb.append(getIdTransaccion());
		sb.append(", tipoDocumento=");
		sb.append(getTipoDocumento());
		sb.append(", numDocumento=");
		sb.append(getNumDocumento());
		sb.append(", producto1=");
		sb.append(getProducto1());
		sb.append(", producto2=");
		sb.append(getProducto2());
		sb.append(", producto3=");
		sb.append(getProducto3());
		sb.append(", producto4=");
		sb.append(getProducto4());
		sb.append(", codProducto1=");
		sb.append(getCodProducto1());
		sb.append(", codProducto2=");
		sb.append(getCodProducto2());
		sb.append(", codProducto3=");
		sb.append(getCodProducto3());
		sb.append(", codProducto4=");
		sb.append(getCodProducto4());
		sb.append(", IP=");
		sb.append(getIP());
		sb.append(", session=");
		sb.append(getSession());
		sb.append(", fechaHora=");
		sb.append(getFechaHora());
		sb.append(", UTMSource=");
		sb.append(getUTMSource());
		sb.append(", UTMMedium=");
		sb.append(getUTMMedium());
		sb.append(", UTMCampaing=");
		sb.append(getUTMCampaing());
		sb.append(", UTMContent=");
		sb.append(getUTMContent());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.AuditoriaCajaSorpresa");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idAuditoriaCajSorp</column-name><column-value><![CDATA[");
		sb.append(getIdAuditoriaCajSorp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idTransaccion</column-name><column-value><![CDATA[");
		sb.append(getIdTransaccion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoDocumento</column-name><column-value><![CDATA[");
		sb.append(getTipoDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numDocumento</column-name><column-value><![CDATA[");
		sb.append(getNumDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>producto1</column-name><column-value><![CDATA[");
		sb.append(getProducto1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>producto2</column-name><column-value><![CDATA[");
		sb.append(getProducto2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>producto3</column-name><column-value><![CDATA[");
		sb.append(getProducto3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>producto4</column-name><column-value><![CDATA[");
		sb.append(getProducto4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codProducto1</column-name><column-value><![CDATA[");
		sb.append(getCodProducto1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codProducto2</column-name><column-value><![CDATA[");
		sb.append(getCodProducto2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codProducto3</column-name><column-value><![CDATA[");
		sb.append(getCodProducto3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codProducto4</column-name><column-value><![CDATA[");
		sb.append(getCodProducto4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IP</column-name><column-value><![CDATA[");
		sb.append(getIP());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>session</column-name><column-value><![CDATA[");
		sb.append(getSession());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaHora</column-name><column-value><![CDATA[");
		sb.append(getFechaHora());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UTMSource</column-name><column-value><![CDATA[");
		sb.append(getUTMSource());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UTMMedium</column-name><column-value><![CDATA[");
		sb.append(getUTMMedium());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UTMCampaing</column-name><column-value><![CDATA[");
		sb.append(getUTMCampaing());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UTMContent</column-name><column-value><![CDATA[");
		sb.append(getUTMContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = AuditoriaCajaSorpresa.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			AuditoriaCajaSorpresa.class
		};
	private long _idAuditoriaCajSorp;
	private String _idTransaccion;
	private String _tipoDocumento;
	private String _numDocumento;
	private String _producto1;
	private String _producto2;
	private String _producto3;
	private String _producto4;
	private String _codProducto1;
	private String _codProducto2;
	private String _codProducto3;
	private String _codProducto4;
	private String _IP;
	private String _session;
	private Date _fechaHora;
	private String _UTMSource;
	private String _UTMMedium;
	private String _UTMCampaing;
	private String _UTMContent;
	private AuditoriaCajaSorpresa _escapedModelProxy;
}