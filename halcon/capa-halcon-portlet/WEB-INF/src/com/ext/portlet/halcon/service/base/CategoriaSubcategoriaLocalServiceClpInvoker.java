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

import com.ext.portlet.halcon.service.CategoriaSubcategoriaLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class CategoriaSubcategoriaLocalServiceClpInvoker {
	public CategoriaSubcategoriaLocalServiceClpInvoker() {
		_methodName0 = "addCategoriaSubcategoria";

		_methodParameterTypes0 = new String[] {
				"com.ext.portlet.halcon.model.CategoriaSubcategoria"
			};

		_methodName1 = "createCategoriaSubcategoria";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteCategoriaSubcategoria";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteCategoriaSubcategoria";

		_methodParameterTypes3 = new String[] {
				"com.ext.portlet.halcon.model.CategoriaSubcategoria"
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

		_methodName9 = "fetchCategoriaSubcategoria";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getCategoriaSubcategoria";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getCategoriaSubcategorias";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getCategoriaSubcategoriasCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateCategoriaSubcategoria";

		_methodParameterTypes14 = new String[] {
				"com.ext.portlet.halcon.model.CategoriaSubcategoria"
			};

		_methodName15 = "updateCategoriaSubcategoria";

		_methodParameterTypes15 = new String[] {
				"com.ext.portlet.halcon.model.CategoriaSubcategoria", "boolean"
			};

		_methodName184 = "getBeanIdentifier";

		_methodParameterTypes184 = new String[] {  };

		_methodName185 = "setBeanIdentifier";

		_methodParameterTypes185 = new String[] { "java.lang.String" };

		_methodName190 = "insertar";

		_methodParameterTypes190 = new String[] {
				"java.lang.Integer", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.addCategoriaSubcategoria((com.ext.portlet.halcon.model.CategoriaSubcategoria)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.createCategoriaSubcategoria(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.deleteCategoriaSubcategoria(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.deleteCategoriaSubcategoria((com.ext.portlet.halcon.model.CategoriaSubcategoria)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.fetchCategoriaSubcategoria(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.getCategoriaSubcategoria(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.getCategoriaSubcategorias(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.getCategoriaSubcategoriasCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.updateCategoriaSubcategoria((com.ext.portlet.halcon.model.CategoriaSubcategoria)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.updateCategoriaSubcategoria((com.ext.portlet.halcon.model.CategoriaSubcategoria)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			CategoriaSubcategoriaLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return CategoriaSubcategoriaLocalServiceUtil.insertar((java.lang.Integer)arguments[0],
				(java.lang.String)arguments[1]);
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
}