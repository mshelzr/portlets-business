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

import com.ext.portlet.halcon.service.FondosMutuosLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class FondosMutuosLocalServiceClpInvoker {
	public FondosMutuosLocalServiceClpInvoker() {
		_methodName0 = "addFondosMutuos";

		_methodParameterTypes0 = new String[] {
				"com.ext.portlet.halcon.model.FondosMutuos"
			};

		_methodName1 = "createFondosMutuos";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteFondosMutuos";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteFondosMutuos";

		_methodParameterTypes3 = new String[] {
				"com.ext.portlet.halcon.model.FondosMutuos"
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

		_methodName9 = "fetchFondosMutuos";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getFondosMutuos";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getFondosMutuoses";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getFondosMutuosesCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateFondosMutuos";

		_methodParameterTypes14 = new String[] {
				"com.ext.portlet.halcon.model.FondosMutuos"
			};

		_methodName15 = "updateFondosMutuos";

		_methodParameterTypes15 = new String[] {
				"com.ext.portlet.halcon.model.FondosMutuos", "boolean"
			};

		_methodName184 = "getBeanIdentifier";

		_methodParameterTypes184 = new String[] {  };

		_methodName185 = "setBeanIdentifier";

		_methodParameterTypes185 = new String[] { "java.lang.String" };

		_methodName190 = "obtenerFondoMutuoZona";

		_methodParameterTypes190 = new String[] {
				"java.lang.Integer", "java.lang.String", "java.lang.String"
			};

		_methodName191 = "ListarPlazozFondoMutuo";

		_methodParameterTypes191 = new String[] { "java.lang.String" };

		_methodName192 = "ListarFondoMutuo";

		_methodParameterTypes192 = new String[] {
				"java.lang.String", "java.util.List", "java.lang.String"
			};

		_methodName193 = "insertarFondoMutuo";

		_methodParameterTypes193 = new String[] { "java.util.List" };

		_methodName194 = "consultarUltimaFecha";

		_methodParameterTypes194 = new String[] {  };

		_methodName195 = "consultarFondoMutuoTipos";

		_methodParameterTypes195 = new String[] {
				"java.lang.Integer", "java.lang.String", "java.lang.String"
			};

		_methodName196 = "obtenerFondosMutuosPuntos";

		_methodParameterTypes196 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName197 = "consultarFondosMutuosParte";

		_methodParameterTypes197 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.Integer", "java.util.List"
			};

		_methodName198 = "consultarDiasDesdeIdentificadorSlider";

		_methodParameterTypes198 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName199 = "getInstance";

		_methodParameterTypes199 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.addFondosMutuos((com.ext.portlet.halcon.model.FondosMutuos)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.createFondosMutuos(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.deleteFondosMutuos(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.deleteFondosMutuos((com.ext.portlet.halcon.model.FondosMutuos)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.fetchFondosMutuos(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.getFondosMutuos(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.getFondosMutuoses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.getFondosMutuosesCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.updateFondosMutuos((com.ext.portlet.halcon.model.FondosMutuos)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.updateFondosMutuos((com.ext.portlet.halcon.model.FondosMutuos)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			FondosMutuosLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.obtenerFondoMutuoZona((java.lang.Integer)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.ListarPlazozFondoMutuo((java.lang.String)arguments[0]);
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.ListarFondoMutuo((java.lang.String)arguments[0],
				(java.util.List<java.lang.String>)arguments[1],
				(java.lang.String)arguments[2]);
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.insertarFondoMutuo((java.util.List<com.ext.portlet.halcon.model.FondosMutuos>)arguments[0]);
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.consultarUltimaFecha();
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.consultarFondoMutuoTipos((java.lang.Integer)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.obtenerFondosMutuosPuntos((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.consultarFondosMutuosParte((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				(java.lang.Integer)arguments[4],
				(java.util.List<java.lang.String>)arguments[5]);
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.consultarDiasDesdeIdentificadorSlider((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			return FondosMutuosLocalServiceUtil.getInstance();
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
}