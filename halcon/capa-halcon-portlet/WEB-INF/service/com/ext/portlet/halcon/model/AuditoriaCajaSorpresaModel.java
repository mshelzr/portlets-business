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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AuditoriaCajaSorpresa service. Represents a row in the &quot;T_AUDITORIA_CAJA_SORPRESA&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.halcon.model.impl.AuditoriaCajaSorpresaModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.halcon.model.impl.AuditoriaCajaSorpresaImpl}.
 * </p>
 *
 * @author Infonet-Consulting
 * @see AuditoriaCajaSorpresa
 * @see com.ext.portlet.halcon.model.impl.AuditoriaCajaSorpresaImpl
 * @see com.ext.portlet.halcon.model.impl.AuditoriaCajaSorpresaModelImpl
 * @generated
 */
public interface AuditoriaCajaSorpresaModel extends BaseModel<AuditoriaCajaSorpresa> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a auditoria caja sorpresa model instance should use the {@link AuditoriaCajaSorpresa} interface instead.
	 */

	/**
	 * Returns the primary key of this auditoria caja sorpresa.
	 *
	 * @return the primary key of this auditoria caja sorpresa
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this auditoria caja sorpresa.
	 *
	 * @param primaryKey the primary key of this auditoria caja sorpresa
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id auditoria caj sorp of this auditoria caja sorpresa.
	 *
	 * @return the id auditoria caj sorp of this auditoria caja sorpresa
	 */
	public long getIdAuditoriaCajSorp();

	/**
	 * Sets the id auditoria caj sorp of this auditoria caja sorpresa.
	 *
	 * @param idAuditoriaCajSorp the id auditoria caj sorp of this auditoria caja sorpresa
	 */
	public void setIdAuditoriaCajSorp(long idAuditoriaCajSorp);

	/**
	 * Returns the id transaccion of this auditoria caja sorpresa.
	 *
	 * @return the id transaccion of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getIdTransaccion();

	/**
	 * Sets the id transaccion of this auditoria caja sorpresa.
	 *
	 * @param idTransaccion the id transaccion of this auditoria caja sorpresa
	 */
	public void setIdTransaccion(String idTransaccion);

	/**
	 * Returns the tipo documento of this auditoria caja sorpresa.
	 *
	 * @return the tipo documento of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getTipoDocumento();

	/**
	 * Sets the tipo documento of this auditoria caja sorpresa.
	 *
	 * @param tipoDocumento the tipo documento of this auditoria caja sorpresa
	 */
	public void setTipoDocumento(String tipoDocumento);

	/**
	 * Returns the num documento of this auditoria caja sorpresa.
	 *
	 * @return the num documento of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getNumDocumento();

	/**
	 * Sets the num documento of this auditoria caja sorpresa.
	 *
	 * @param numDocumento the num documento of this auditoria caja sorpresa
	 */
	public void setNumDocumento(String numDocumento);

	/**
	 * Returns the producto1 of this auditoria caja sorpresa.
	 *
	 * @return the producto1 of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getProducto1();

	/**
	 * Sets the producto1 of this auditoria caja sorpresa.
	 *
	 * @param producto1 the producto1 of this auditoria caja sorpresa
	 */
	public void setProducto1(String producto1);

	/**
	 * Returns the producto2 of this auditoria caja sorpresa.
	 *
	 * @return the producto2 of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getProducto2();

	/**
	 * Sets the producto2 of this auditoria caja sorpresa.
	 *
	 * @param producto2 the producto2 of this auditoria caja sorpresa
	 */
	public void setProducto2(String producto2);

	/**
	 * Returns the producto3 of this auditoria caja sorpresa.
	 *
	 * @return the producto3 of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getProducto3();

	/**
	 * Sets the producto3 of this auditoria caja sorpresa.
	 *
	 * @param producto3 the producto3 of this auditoria caja sorpresa
	 */
	public void setProducto3(String producto3);

	/**
	 * Returns the producto4 of this auditoria caja sorpresa.
	 *
	 * @return the producto4 of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getProducto4();

	/**
	 * Sets the producto4 of this auditoria caja sorpresa.
	 *
	 * @param producto4 the producto4 of this auditoria caja sorpresa
	 */
	public void setProducto4(String producto4);

	/**
	 * Returns the cod producto1 of this auditoria caja sorpresa.
	 *
	 * @return the cod producto1 of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getCodProducto1();

	/**
	 * Sets the cod producto1 of this auditoria caja sorpresa.
	 *
	 * @param codProducto1 the cod producto1 of this auditoria caja sorpresa
	 */
	public void setCodProducto1(String codProducto1);

	/**
	 * Returns the cod producto2 of this auditoria caja sorpresa.
	 *
	 * @return the cod producto2 of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getCodProducto2();

	/**
	 * Sets the cod producto2 of this auditoria caja sorpresa.
	 *
	 * @param codProducto2 the cod producto2 of this auditoria caja sorpresa
	 */
	public void setCodProducto2(String codProducto2);

	/**
	 * Returns the cod producto3 of this auditoria caja sorpresa.
	 *
	 * @return the cod producto3 of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getCodProducto3();

	/**
	 * Sets the cod producto3 of this auditoria caja sorpresa.
	 *
	 * @param codProducto3 the cod producto3 of this auditoria caja sorpresa
	 */
	public void setCodProducto3(String codProducto3);

	/**
	 * Returns the cod producto4 of this auditoria caja sorpresa.
	 *
	 * @return the cod producto4 of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getCodProducto4();

	/**
	 * Sets the cod producto4 of this auditoria caja sorpresa.
	 *
	 * @param codProducto4 the cod producto4 of this auditoria caja sorpresa
	 */
	public void setCodProducto4(String codProducto4);

	/**
	 * Returns the i p of this auditoria caja sorpresa.
	 *
	 * @return the i p of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getIP();

	/**
	 * Sets the i p of this auditoria caja sorpresa.
	 *
	 * @param IP the i p of this auditoria caja sorpresa
	 */
	public void setIP(String IP);

	/**
	 * Returns the session of this auditoria caja sorpresa.
	 *
	 * @return the session of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getSession();

	/**
	 * Sets the session of this auditoria caja sorpresa.
	 *
	 * @param session the session of this auditoria caja sorpresa
	 */
	public void setSession(String session);

	/**
	 * Returns the fecha hora of this auditoria caja sorpresa.
	 *
	 * @return the fecha hora of this auditoria caja sorpresa
	 */
	public Date getFechaHora();

	/**
	 * Sets the fecha hora of this auditoria caja sorpresa.
	 *
	 * @param fechaHora the fecha hora of this auditoria caja sorpresa
	 */
	public void setFechaHora(Date fechaHora);

	/**
	 * Returns the u t m source of this auditoria caja sorpresa.
	 *
	 * @return the u t m source of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getUTMSource();

	/**
	 * Sets the u t m source of this auditoria caja sorpresa.
	 *
	 * @param UTMSource the u t m source of this auditoria caja sorpresa
	 */
	public void setUTMSource(String UTMSource);

	/**
	 * Returns the u t m medium of this auditoria caja sorpresa.
	 *
	 * @return the u t m medium of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getUTMMedium();

	/**
	 * Sets the u t m medium of this auditoria caja sorpresa.
	 *
	 * @param UTMMedium the u t m medium of this auditoria caja sorpresa
	 */
	public void setUTMMedium(String UTMMedium);

	/**
	 * Returns the u t m campaing of this auditoria caja sorpresa.
	 *
	 * @return the u t m campaing of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getUTMCampaing();

	/**
	 * Sets the u t m campaing of this auditoria caja sorpresa.
	 *
	 * @param UTMCampaing the u t m campaing of this auditoria caja sorpresa
	 */
	public void setUTMCampaing(String UTMCampaing);

	/**
	 * Returns the u t m content of this auditoria caja sorpresa.
	 *
	 * @return the u t m content of this auditoria caja sorpresa
	 */
	@AutoEscape
	public String getUTMContent();

	/**
	 * Sets the u t m content of this auditoria caja sorpresa.
	 *
	 * @param UTMContent the u t m content of this auditoria caja sorpresa
	 */
	public void setUTMContent(String UTMContent);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(AuditoriaCajaSorpresa auditoriaCajaSorpresa);

	public int hashCode();

	public CacheModel<AuditoriaCajaSorpresa> toCacheModel();

	public AuditoriaCajaSorpresa toEscapedModel();

	public String toString();

	public String toXmlString();
}