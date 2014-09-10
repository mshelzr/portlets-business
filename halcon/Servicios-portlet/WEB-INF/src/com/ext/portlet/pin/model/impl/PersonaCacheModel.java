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

package com.ext.portlet.pin.model.impl;

import com.ext.portlet.pin.model.Persona;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Persona in entity cache.
 *
 * @author arodriguez
 * @see Persona
 * @generated
 */
public class PersonaCacheModel implements CacheModel<Persona>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", nombres=");
		sb.append(nombres);
		sb.append(", apellidoPaterno=");
		sb.append(apellidoPaterno);
		sb.append(", apellidoMaterno=");
		sb.append(apellidoMaterno);
		sb.append(", dni=");
		sb.append(dni);
		sb.append(", tipoDocumento=");
		sb.append(tipoDocumento);
		sb.append("}");

		return sb.toString();
	}

	public Persona toEntityModel() {
		PersonaImpl personaImpl = new PersonaImpl();

		personaImpl.setUserId(userId);

		if (nombres == null) {
			personaImpl.setNombres(StringPool.BLANK);
		}
		else {
			personaImpl.setNombres(nombres);
		}

		if (apellidoPaterno == null) {
			personaImpl.setApellidoPaterno(StringPool.BLANK);
		}
		else {
			personaImpl.setApellidoPaterno(apellidoPaterno);
		}

		if (apellidoMaterno == null) {
			personaImpl.setApellidoMaterno(StringPool.BLANK);
		}
		else {
			personaImpl.setApellidoMaterno(apellidoMaterno);
		}

		if (dni == null) {
			personaImpl.setDni(StringPool.BLANK);
		}
		else {
			personaImpl.setDni(dni);
		}

		personaImpl.setTipoDocumento(tipoDocumento);

		personaImpl.resetOriginalValues();

		return personaImpl;
	}

	public long userId;
	public String nombres;
	public String apellidoPaterno;
	public String apellidoMaterno;
	public String dni;
	public int tipoDocumento;
}