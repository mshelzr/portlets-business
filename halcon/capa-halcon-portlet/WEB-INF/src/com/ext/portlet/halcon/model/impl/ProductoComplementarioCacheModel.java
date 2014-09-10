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

import com.ext.portlet.halcon.model.ProductoComplementario;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing ProductoComplementario in entity cache.
 *
 * @author Infonet-Consulting
 * @see ProductoComplementario
 * @generated
 */
public class ProductoComplementarioCacheModel implements CacheModel<ProductoComplementario>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{idProductoComplementario=");
		sb.append(idProductoComplementario);
		sb.append(", idSolicitudProducto=");
		sb.append(idSolicitudProducto);
		sb.append(", principalidad=");
		sb.append(principalidad);
		sb.append(", producto=");
		sb.append(producto);
		sb.append(", idProducto=");
		sb.append(idProducto);
		sb.append(", idGrupoProducto=");
		sb.append(idGrupoProducto);
		sb.append(", emailSupervisor=");
		sb.append(emailSupervisor);
		sb.append("}");

		return sb.toString();
	}

	public ProductoComplementario toEntityModel() {
		ProductoComplementarioImpl productoComplementarioImpl = new ProductoComplementarioImpl();

		productoComplementarioImpl.setIdProductoComplementario(idProductoComplementario);
		productoComplementarioImpl.setIdSolicitudProducto(idSolicitudProducto);

		if (principalidad == null) {
			productoComplementarioImpl.setPrincipalidad(StringPool.BLANK);
		}
		else {
			productoComplementarioImpl.setPrincipalidad(principalidad);
		}

		if (producto == null) {
			productoComplementarioImpl.setProducto(StringPool.BLANK);
		}
		else {
			productoComplementarioImpl.setProducto(producto);
		}

		if (idProducto == null) {
			productoComplementarioImpl.setIdProducto(StringPool.BLANK);
		}
		else {
			productoComplementarioImpl.setIdProducto(idProducto);
		}

		if (idGrupoProducto == null) {
			productoComplementarioImpl.setIdGrupoProducto(StringPool.BLANK);
		}
		else {
			productoComplementarioImpl.setIdGrupoProducto(idGrupoProducto);
		}

		if (emailSupervisor == null) {
			productoComplementarioImpl.setEmailSupervisor(StringPool.BLANK);
		}
		else {
			productoComplementarioImpl.setEmailSupervisor(emailSupervisor);
		}

		productoComplementarioImpl.resetOriginalValues();

		return productoComplementarioImpl;
	}

	public long idProductoComplementario;
	public long idSolicitudProducto;
	public String principalidad;
	public String producto;
	public String idProducto;
	public String idGrupoProducto;
	public String emailSupervisor;
}