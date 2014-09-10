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

import com.ext.portlet.halcon.service.FondosMutuosZonasLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class FondosMutuosZonasLocalServiceClpInvoker {
	public FondosMutuosZonasLocalServiceClpInvoker() {
		_methodName0 = "addFondosMutuosZonas";

		_methodParameterTypes0 = new String[] {
				"com.ext.portlet.halcon.model.FondosMutuosZonas"
			};

		_methodName1 = "createFondosMutuosZonas";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteFondosMutuosZonas";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteFondosMutuosZonas";

		_methodParameterTypes3 = new String[] {
				"com.ext.portlet.halcon.model.FondosMutuosZonas"
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

		_methodName9 = "fetchFondosMutuosZonas";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getFondosMutuosZonas";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getFondosMutuosZonases";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getFondosMutuosZonasesCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateFondosMutuosZonas";

		_methodParameterTypes14 = new String[] {
				"com.ext.portlet.halcon.model.FondosMutuosZonas"
			};

		_methodName15 = "updateFondosMutuosZonas";

		_methodParameterTypes15 = new String[] {
				"com.ext.portlet.halcon.model.FondosMutuosZonas", "boolean"
			};

		_methodName186 = "getBeanIdentifier";

		_methodParameterTypes186 = new String[] {  };

		_methodName187 = "setBeanIdentifier";

		_methodParameterTypes187 = new String[] { "java.lang.String" };

		_methodName192 = "getInstance";

		_methodParameterTypes192 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.addFondosMutuosZonas((com.ext.portlet.halcon.model.FondosMutuosZonas)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.createFondosMutuosZonas(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.deleteFondosMutuosZonas(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.deleteFondosMutuosZonas((com.ext.portlet.halcon.model.FondosMutuosZonas)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.fetchFondosMutuosZonas(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.getFondosMutuosZonas(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.getFondosMutuosZonases(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.getFondosMutuosZonasesCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.updateFondosMutuosZonas((com.ext.portlet.halcon.model.FondosMutuosZonas)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.updateFondosMutuosZonas((com.ext.portlet.halcon.model.FondosMutuosZonas)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			FondosMutuosZonasLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return FondosMutuosZonasLocalServiceUtil.getInstance();
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
	private String _methodName186;
	private String[] _methodParameterTypes186;
	private String _methodName187;
	private String[] _methodParameterTypes187;
	private String _methodName192;
	private String[] _methodParameterTypes192;
}