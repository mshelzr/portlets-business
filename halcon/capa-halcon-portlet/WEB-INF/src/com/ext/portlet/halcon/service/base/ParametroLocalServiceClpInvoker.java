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

package com.ext.portlet.halcon.service.base;

import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class ParametroLocalServiceClpInvoker {
	public ParametroLocalServiceClpInvoker() {
		_methodName0 = "addParametro";

		_methodParameterTypes0 = new String[] {
				"com.ext.portlet.halcon.model.Parametro"
			};

		_methodName1 = "createParametro";

		_methodParameterTypes1 = new String[] { "int" };

		_methodName2 = "deleteParametro";

		_methodParameterTypes2 = new String[] { "int" };

		_methodName3 = "deleteParametro";

		_methodParameterTypes3 = new String[] {
				"com.ext.portlet.halcon.model.Parametro"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "fetchParametro";

		_methodParameterTypes9 = new String[] { "int" };

		_methodName10 = "getParametro";

		_methodParameterTypes10 = new String[] { "int" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getParametros";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getParametrosCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateParametro";

		_methodParameterTypes14 = new String[] {
				"com.ext.portlet.halcon.model.Parametro"
			};

		_methodName15 = "updateParametro";

		_methodParameterTypes15 = new String[] {
				"com.ext.portlet.halcon.model.Parametro", "boolean"
			};

		_methodName184 = "getBeanIdentifier";

		_methodParameterTypes184 = new String[] {  };

		_methodName185 = "setBeanIdentifier";

		_methodParameterTypes185 = new String[] { "java.lang.String" };

		_methodName190 = "listarParametro";

		_methodParameterTypes190 = new String[] {  };

		_methodName191 = "obtenerParametroPadre";

		_methodParameterTypes191 = new String[] { "java.lang.Integer" };

		_methodName192 = "obtenerParametrosHijos";

		_methodParameterTypes192 = new String[] { "java.lang.Integer" };

		_methodName193 = "obtenerParametrosHijos";

		_methodParameterTypes193 = new String[] { "java.lang.String" };

		_methodName194 = "obtenerParametrosPorTipo";

		_methodParameterTypes194 = new String[] { "java.lang.Integer" };

		_methodName195 = "obtenerParametrosPorDescripcion";

		_methodParameterTypes195 = new String[] { "java.lang.String" };

		_methodName196 = "obtenerParametrosPorDescripcion";

		_methodParameterTypes196 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName197 = "cambiarParametroEstado";

		_methodParameterTypes197 = new String[] {
				"java.lang.Integer", "java.lang.Integer"
			};

		_methodName198 = "obtenerParametroListaPadre";

		_methodParameterTypes198 = new String[] {  };

		_methodName199 = "obtenerRangoValor";

		_methodParameterTypes199 = new String[] { "java.lang.Integer" };

		_methodName200 = "validarTipo";

		_methodParameterTypes200 = new String[] { "java.lang.Integer" };

		_methodName201 = "obtenerParametrosHijosDos";

		_methodParameterTypes201 = new String[] { "java.lang.Integer" };

		_methodName202 = "listarPadresJson";

		_methodParameterTypes202 = new String[] { "java.lang.Integer" };

		_methodName203 = "listarHijosPadresJson";

		_methodParameterTypes203 = new String[] { "java.lang.Integer" };

		_methodName204 = "registrarCabeceraDetalle";

		_methodParameterTypes204 = new String[] {
				"com.ext.portlet.halcon.model.Parametro",
				"com.ext.portlet.halcon.model.Parametro"
			};

		_methodName205 = "getInstance";

		_methodParameterTypes205 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ParametroLocalServiceUtil.addParametro((com.ext.portlet.halcon.model.Parametro)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ParametroLocalServiceUtil.createParametro(((Integer)arguments[0]).intValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ParametroLocalServiceUtil.deleteParametro(((Integer)arguments[0]).intValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ParametroLocalServiceUtil.deleteParametro((com.ext.portlet.halcon.model.Parametro)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ParametroLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ParametroLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ParametroLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ParametroLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ParametroLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ParametroLocalServiceUtil.fetchParametro(((Integer)arguments[0]).intValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ParametroLocalServiceUtil.getParametro(((Integer)arguments[0]).intValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ParametroLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ParametroLocalServiceUtil.getParametros(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ParametroLocalServiceUtil.getParametrosCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ParametroLocalServiceUtil.updateParametro((com.ext.portlet.halcon.model.Parametro)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ParametroLocalServiceUtil.updateParametro((com.ext.portlet.halcon.model.Parametro)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return ParametroLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			ParametroLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return ParametroLocalServiceUtil.listarParametro();
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return ParametroLocalServiceUtil.obtenerParametroPadre((java.lang.Integer)arguments[0]);
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return ParametroLocalServiceUtil.obtenerParametrosHijos((java.lang.Integer)arguments[0]);
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return ParametroLocalServiceUtil.obtenerParametrosHijos((java.lang.String)arguments[0]);
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return ParametroLocalServiceUtil.obtenerParametrosPorTipo((java.lang.Integer)arguments[0]);
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			return ParametroLocalServiceUtil.obtenerParametrosPorDescripcion((java.lang.String)arguments[0]);
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return ParametroLocalServiceUtil.obtenerParametrosPorDescripcion((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return ParametroLocalServiceUtil.cambiarParametroEstado((java.lang.Integer)arguments[0],
				(java.lang.Integer)arguments[1]);
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return ParametroLocalServiceUtil.obtenerParametroListaPadre();
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			return ParametroLocalServiceUtil.obtenerRangoValor((java.lang.Integer)arguments[0]);
		}

		if (_methodName200.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
			return ParametroLocalServiceUtil.validarTipo((java.lang.Integer)arguments[0]);
		}

		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
			return ParametroLocalServiceUtil.obtenerParametrosHijosDos((java.lang.Integer)arguments[0]);
		}

		if (_methodName202.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
			return ParametroLocalServiceUtil.listarPadresJson((java.lang.Integer)arguments[0]);
		}

		if (_methodName203.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes203, parameterTypes)) {
			return ParametroLocalServiceUtil.listarHijosPadresJson((java.lang.Integer)arguments[0]);
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			return ParametroLocalServiceUtil.registrarCabeceraDetalle((com.ext.portlet.halcon.model.Parametro)arguments[0],
				(com.ext.portlet.halcon.model.Parametro)arguments[1]);
		}

		if (_methodName205.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
			return ParametroLocalServiceUtil.getInstance();
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName184;
	private String[] _methodParameterTypes184;
	private String _methodName185;
	private String[] _methodParameterTypes185;
	private String _methodName190;
	private String[] _methodParameterTypes190;
	private String _methodName191;
	private String[] _methodParameterTypes191;
	private String _methodName192;
	private String[] _methodParameterTypes192;
	private String _methodName193;
	private String[] _methodParameterTypes193;
	private String _methodName194;
	private String[] _methodParameterTypes194;
	private String _methodName195;
	private String[] _methodParameterTypes195;
	private String _methodName196;
	private String[] _methodParameterTypes196;
	private String _methodName197;
	private String[] _methodParameterTypes197;
	private String _methodName198;
	private String[] _methodParameterTypes198;
	private String _methodName199;
	private String[] _methodParameterTypes199;
	private String _methodName200;
	private String[] _methodParameterTypes200;
	private String _methodName201;
	private String[] _methodParameterTypes201;
	private String _methodName202;
	private String[] _methodParameterTypes202;
	private String _methodName203;
	private String[] _methodParameterTypes203;
	private String _methodName204;
	private String[] _methodParameterTypes204;
	private String _methodName205;
	private String[] _methodParameterTypes205;
}