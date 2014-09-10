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

import com.ext.portlet.halcon.model.Parametro;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Parametro in entity cache.
 *
 * @author Infonet-Consulting
 * @see Parametro
 * @generated
 */
public class ParametroCacheModel implements CacheModel<Parametro>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{idParametro=");
		sb.append(idParametro);
		sb.append(", idParametroPadre=");
		sb.append(idParametroPadre);
		sb.append(", valorMonto1=");
		sb.append(valorMonto1);
		sb.append(", valorMonto2=");
		sb.append(valorMonto2);
		sb.append(", valorMonto3=");
		sb.append(valorMonto3);
		sb.append(", dato1=");
		sb.append(dato1);
		sb.append(", dato2=");
		sb.append(dato2);
		sb.append(", dato3=");
		sb.append(dato3);
		sb.append(", dato4=");
		sb.append(dato4);
		sb.append(", num1=");
		sb.append(num1);
		sb.append(", num2=");
		sb.append(num2);
		sb.append(", num3=");
		sb.append(num3);
		sb.append("}");

		return sb.toString();
	}

	public Parametro toEntityModel() {
		ParametroImpl parametroImpl = new ParametroImpl();

		parametroImpl.setIdParametro(idParametro);
		parametroImpl.setIdParametroPadre(idParametroPadre);

		if (valorMonto1 == null) {
			parametroImpl.setValorMonto1(StringPool.BLANK);
		}
		else {
			parametroImpl.setValorMonto1(valorMonto1);
		}

		if (valorMonto2 == null) {
			parametroImpl.setValorMonto2(StringPool.BLANK);
		}
		else {
			parametroImpl.setValorMonto2(valorMonto2);
		}

		if (valorMonto3 == null) {
			parametroImpl.setValorMonto3(StringPool.BLANK);
		}
		else {
			parametroImpl.setValorMonto3(valorMonto3);
		}

		if (dato1 == null) {
			parametroImpl.setDato1(StringPool.BLANK);
		}
		else {
			parametroImpl.setDato1(dato1);
		}

		if (dato2 == null) {
			parametroImpl.setDato2(StringPool.BLANK);
		}
		else {
			parametroImpl.setDato2(dato2);
		}

		if (dato3 == null) {
			parametroImpl.setDato3(StringPool.BLANK);
		}
		else {
			parametroImpl.setDato3(dato3);
		}

		if (dato4 == null) {
			parametroImpl.setDato4(StringPool.BLANK);
		}
		else {
			parametroImpl.setDato4(dato4);
		}

		parametroImpl.setNum1(num1);
		parametroImpl.setNum2(num2);
		parametroImpl.setNum3(num3);

		parametroImpl.resetOriginalValues();

		return parametroImpl;
	}

	public int idParametro;
	public Integer idParametroPadre;
	public String valorMonto1;
	public String valorMonto2;
	public String valorMonto3;
	public String dato1;
	public String dato2;
	public String dato3;
	public String dato4;
	public Integer num1;
	public Integer num2;
	public Integer num3;
}