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

package com.ext.portlet.halcon.service;

import com.ext.portlet.halcon.model.AuditoriaCajaSorpresaClp;
import com.ext.portlet.halcon.model.AuditoriaPerfiladorClp;
import com.ext.portlet.halcon.model.AuditoriaSimuladorClp;
import com.ext.portlet.halcon.model.CargaDescuentoClp;
import com.ext.portlet.halcon.model.CargaSocioRemesaClp;
import com.ext.portlet.halcon.model.CargaTiendaClp;
import com.ext.portlet.halcon.model.CategoriaSubcategoriaClp;
import com.ext.portlet.halcon.model.ConfiguracionPerfiladorClp;
import com.ext.portlet.halcon.model.ConfiguracionProductoClp;
import com.ext.portlet.halcon.model.FondosMutuosClp;
import com.ext.portlet.halcon.model.LogIncidenciasClp;
import com.ext.portlet.halcon.model.OcurrenciaClp;
import com.ext.portlet.halcon.model.PaisClp;
import com.ext.portlet.halcon.model.ParametroClp;
import com.ext.portlet.halcon.model.PreguntaFrecuenteClp;
import com.ext.portlet.halcon.model.ProductoComplementarioClp;
import com.ext.portlet.halcon.model.SolicitudContactoClp;
import com.ext.portlet.halcon.model.SolicitudProductoClp;
import com.ext.portlet.halcon.model.TelefonoSolicitudProductoClp;
import com.ext.portlet.halcon.model.UbigeoClp;
import com.ext.portlet.halcon.model.ValorCuotaClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"capa-halcon-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"capa-halcon-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "capa-halcon-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AuditoriaCajaSorpresaClp.class.getName())) {
			return translateInputAuditoriaCajaSorpresa(oldModel);
		}

		if (oldModelClassName.equals(AuditoriaPerfiladorClp.class.getName())) {
			return translateInputAuditoriaPerfilador(oldModel);
		}

		if (oldModelClassName.equals(AuditoriaSimuladorClp.class.getName())) {
			return translateInputAuditoriaSimulador(oldModel);
		}

		if (oldModelClassName.equals(CargaDescuentoClp.class.getName())) {
			return translateInputCargaDescuento(oldModel);
		}

		if (oldModelClassName.equals(CargaSocioRemesaClp.class.getName())) {
			return translateInputCargaSocioRemesa(oldModel);
		}

		if (oldModelClassName.equals(CargaTiendaClp.class.getName())) {
			return translateInputCargaTienda(oldModel);
		}

		if (oldModelClassName.equals(CategoriaSubcategoriaClp.class.getName())) {
			return translateInputCategoriaSubcategoria(oldModel);
		}

		if (oldModelClassName.equals(ConfiguracionPerfiladorClp.class.getName())) {
			return translateInputConfiguracionPerfilador(oldModel);
		}

		if (oldModelClassName.equals(ConfiguracionProductoClp.class.getName())) {
			return translateInputConfiguracionProducto(oldModel);
		}

		if (oldModelClassName.equals(FondosMutuosClp.class.getName())) {
			return translateInputFondosMutuos(oldModel);
		}

		if (oldModelClassName.equals(LogIncidenciasClp.class.getName())) {
			return translateInputLogIncidencias(oldModel);
		}

		if (oldModelClassName.equals(OcurrenciaClp.class.getName())) {
			return translateInputOcurrencia(oldModel);
		}

		if (oldModelClassName.equals(PaisClp.class.getName())) {
			return translateInputPais(oldModel);
		}

		if (oldModelClassName.equals(ParametroClp.class.getName())) {
			return translateInputParametro(oldModel);
		}

		if (oldModelClassName.equals(PreguntaFrecuenteClp.class.getName())) {
			return translateInputPreguntaFrecuente(oldModel);
		}

		if (oldModelClassName.equals(ProductoComplementarioClp.class.getName())) {
			return translateInputProductoComplementario(oldModel);
		}

		if (oldModelClassName.equals(SolicitudContactoClp.class.getName())) {
			return translateInputSolicitudContacto(oldModel);
		}

		if (oldModelClassName.equals(SolicitudProductoClp.class.getName())) {
			return translateInputSolicitudProducto(oldModel);
		}

		if (oldModelClassName.equals(
					TelefonoSolicitudProductoClp.class.getName())) {
			return translateInputTelefonoSolicitudProducto(oldModel);
		}

		if (oldModelClassName.equals(UbigeoClp.class.getName())) {
			return translateInputUbigeo(oldModel);
		}

		if (oldModelClassName.equals(ValorCuotaClp.class.getName())) {
			return translateInputValorCuota(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputAuditoriaCajaSorpresa(
		BaseModel<?> oldModel) {
		AuditoriaCajaSorpresaClp oldClpModel = (AuditoriaCajaSorpresaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAuditoriaCajaSorpresaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAuditoriaPerfilador(
		BaseModel<?> oldModel) {
		AuditoriaPerfiladorClp oldClpModel = (AuditoriaPerfiladorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAuditoriaPerfiladorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAuditoriaSimulador(BaseModel<?> oldModel) {
		AuditoriaSimuladorClp oldClpModel = (AuditoriaSimuladorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAuditoriaSimuladorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCargaDescuento(BaseModel<?> oldModel) {
		CargaDescuentoClp oldClpModel = (CargaDescuentoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCargaDescuentoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCargaSocioRemesa(BaseModel<?> oldModel) {
		CargaSocioRemesaClp oldClpModel = (CargaSocioRemesaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCargaSocioRemesaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCargaTienda(BaseModel<?> oldModel) {
		CargaTiendaClp oldClpModel = (CargaTiendaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCargaTiendaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCategoriaSubcategoria(
		BaseModel<?> oldModel) {
		CategoriaSubcategoriaClp oldClpModel = (CategoriaSubcategoriaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCategoriaSubcategoriaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputConfiguracionPerfilador(
		BaseModel<?> oldModel) {
		ConfiguracionPerfiladorClp oldClpModel = (ConfiguracionPerfiladorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getConfiguracionPerfiladorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputConfiguracionProducto(
		BaseModel<?> oldModel) {
		ConfiguracionProductoClp oldClpModel = (ConfiguracionProductoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getConfiguracionProductoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFondosMutuos(BaseModel<?> oldModel) {
		FondosMutuosClp oldClpModel = (FondosMutuosClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFondosMutuosRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLogIncidencias(BaseModel<?> oldModel) {
		LogIncidenciasClp oldClpModel = (LogIncidenciasClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLogIncidenciasRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOcurrencia(BaseModel<?> oldModel) {
		OcurrenciaClp oldClpModel = (OcurrenciaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOcurrenciaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPais(BaseModel<?> oldModel) {
		PaisClp oldClpModel = (PaisClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPaisRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputParametro(BaseModel<?> oldModel) {
		ParametroClp oldClpModel = (ParametroClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getParametroRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPreguntaFrecuente(BaseModel<?> oldModel) {
		PreguntaFrecuenteClp oldClpModel = (PreguntaFrecuenteClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPreguntaFrecuenteRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProductoComplementario(
		BaseModel<?> oldModel) {
		ProductoComplementarioClp oldClpModel = (ProductoComplementarioClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProductoComplementarioRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSolicitudContacto(BaseModel<?> oldModel) {
		SolicitudContactoClp oldClpModel = (SolicitudContactoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSolicitudContactoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSolicitudProducto(BaseModel<?> oldModel) {
		SolicitudProductoClp oldClpModel = (SolicitudProductoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSolicitudProductoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTelefonoSolicitudProducto(
		BaseModel<?> oldModel) {
		TelefonoSolicitudProductoClp oldClpModel = (TelefonoSolicitudProductoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTelefonoSolicitudProductoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUbigeo(BaseModel<?> oldModel) {
		UbigeoClp oldClpModel = (UbigeoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUbigeoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputValorCuota(BaseModel<?> oldModel) {
		ValorCuotaClp oldClpModel = (ValorCuotaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getValorCuotaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.AuditoriaCajaSorpresaImpl")) {
			return translateOutputAuditoriaCajaSorpresa(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.AuditoriaPerfiladorImpl")) {
			return translateOutputAuditoriaPerfilador(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.AuditoriaSimuladorImpl")) {
			return translateOutputAuditoriaSimulador(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.CargaDescuentoImpl")) {
			return translateOutputCargaDescuento(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.CargaSocioRemesaImpl")) {
			return translateOutputCargaSocioRemesa(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.CargaTiendaImpl")) {
			return translateOutputCargaTienda(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.CategoriaSubcategoriaImpl")) {
			return translateOutputCategoriaSubcategoria(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.ConfiguracionPerfiladorImpl")) {
			return translateOutputConfiguracionPerfilador(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.ConfiguracionProductoImpl")) {
			return translateOutputConfiguracionProducto(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.FondosMutuosImpl")) {
			return translateOutputFondosMutuos(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.LogIncidenciasImpl")) {
			return translateOutputLogIncidencias(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.OcurrenciaImpl")) {
			return translateOutputOcurrencia(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.PaisImpl")) {
			return translateOutputPais(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.ParametroImpl")) {
			return translateOutputParametro(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.PreguntaFrecuenteImpl")) {
			return translateOutputPreguntaFrecuente(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.ProductoComplementarioImpl")) {
			return translateOutputProductoComplementario(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.SolicitudContactoImpl")) {
			return translateOutputSolicitudContacto(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.SolicitudProductoImpl")) {
			return translateOutputSolicitudProducto(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.TelefonoSolicitudProductoImpl")) {
			return translateOutputTelefonoSolicitudProducto(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.UbigeoImpl")) {
			return translateOutputUbigeo(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ext.portlet.halcon.model.impl.ValorCuotaImpl")) {
			return translateOutputValorCuota(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException")) {
			return new com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException")) {
			return new com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchAuditoriaSimuladorException")) {
			return new com.ext.portlet.halcon.NoSuchAuditoriaSimuladorException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchCargaDescuentoException")) {
			return new com.ext.portlet.halcon.NoSuchCargaDescuentoException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchCargaSocioRemesaException")) {
			return new com.ext.portlet.halcon.NoSuchCargaSocioRemesaException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchCargaTiendaException")) {
			return new com.ext.portlet.halcon.NoSuchCargaTiendaException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException")) {
			return new com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException")) {
			return new com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchConfiguracionProductoException")) {
			return new com.ext.portlet.halcon.NoSuchConfiguracionProductoException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchFondosMutuosException")) {
			return new com.ext.portlet.halcon.NoSuchFondosMutuosException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchLogIncidenciasException")) {
			return new com.ext.portlet.halcon.NoSuchLogIncidenciasException();
		}

		if (className.equals("com.ext.portlet.halcon.NoSuchOcurrenciaException")) {
			return new com.ext.portlet.halcon.NoSuchOcurrenciaException();
		}

		if (className.equals("com.ext.portlet.halcon.NoSuchPaisException")) {
			return new com.ext.portlet.halcon.NoSuchPaisException();
		}

		if (className.equals("com.ext.portlet.halcon.NoSuchParametroException")) {
			return new com.ext.portlet.halcon.NoSuchParametroException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException")) {
			return new com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchProductoComplementarioException")) {
			return new com.ext.portlet.halcon.NoSuchProductoComplementarioException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchSolicitudContactoException")) {
			return new com.ext.portlet.halcon.NoSuchSolicitudContactoException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchSolicitudProductoException")) {
			return new com.ext.portlet.halcon.NoSuchSolicitudProductoException();
		}

		if (className.equals(
					"com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException")) {
			return new com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException();
		}

		if (className.equals("com.ext.portlet.halcon.NoSuchUbigeoException")) {
			return new com.ext.portlet.halcon.NoSuchUbigeoException();
		}

		if (className.equals("com.ext.portlet.halcon.NoSuchValorCuotaException")) {
			return new com.ext.portlet.halcon.NoSuchValorCuotaException();
		}

		return throwable;
	}

	public static Object translateOutputAuditoriaCajaSorpresa(
		BaseModel<?> oldModel) {
		AuditoriaCajaSorpresaClp newModel = new AuditoriaCajaSorpresaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAuditoriaCajaSorpresaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAuditoriaPerfilador(
		BaseModel<?> oldModel) {
		AuditoriaPerfiladorClp newModel = new AuditoriaPerfiladorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAuditoriaPerfiladorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAuditoriaSimulador(
		BaseModel<?> oldModel) {
		AuditoriaSimuladorClp newModel = new AuditoriaSimuladorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAuditoriaSimuladorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCargaDescuento(BaseModel<?> oldModel) {
		CargaDescuentoClp newModel = new CargaDescuentoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCargaDescuentoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCargaSocioRemesa(BaseModel<?> oldModel) {
		CargaSocioRemesaClp newModel = new CargaSocioRemesaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCargaSocioRemesaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCargaTienda(BaseModel<?> oldModel) {
		CargaTiendaClp newModel = new CargaTiendaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCargaTiendaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCategoriaSubcategoria(
		BaseModel<?> oldModel) {
		CategoriaSubcategoriaClp newModel = new CategoriaSubcategoriaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCategoriaSubcategoriaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputConfiguracionPerfilador(
		BaseModel<?> oldModel) {
		ConfiguracionPerfiladorClp newModel = new ConfiguracionPerfiladorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setConfiguracionPerfiladorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputConfiguracionProducto(
		BaseModel<?> oldModel) {
		ConfiguracionProductoClp newModel = new ConfiguracionProductoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setConfiguracionProductoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFondosMutuos(BaseModel<?> oldModel) {
		FondosMutuosClp newModel = new FondosMutuosClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFondosMutuosRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLogIncidencias(BaseModel<?> oldModel) {
		LogIncidenciasClp newModel = new LogIncidenciasClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLogIncidenciasRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOcurrencia(BaseModel<?> oldModel) {
		OcurrenciaClp newModel = new OcurrenciaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOcurrenciaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPais(BaseModel<?> oldModel) {
		PaisClp newModel = new PaisClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPaisRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputParametro(BaseModel<?> oldModel) {
		ParametroClp newModel = new ParametroClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setParametroRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPreguntaFrecuente(BaseModel<?> oldModel) {
		PreguntaFrecuenteClp newModel = new PreguntaFrecuenteClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPreguntaFrecuenteRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProductoComplementario(
		BaseModel<?> oldModel) {
		ProductoComplementarioClp newModel = new ProductoComplementarioClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProductoComplementarioRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSolicitudContacto(BaseModel<?> oldModel) {
		SolicitudContactoClp newModel = new SolicitudContactoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSolicitudContactoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSolicitudProducto(BaseModel<?> oldModel) {
		SolicitudProductoClp newModel = new SolicitudProductoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSolicitudProductoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTelefonoSolicitudProducto(
		BaseModel<?> oldModel) {
		TelefonoSolicitudProductoClp newModel = new TelefonoSolicitudProductoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTelefonoSolicitudProductoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUbigeo(BaseModel<?> oldModel) {
		UbigeoClp newModel = new UbigeoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUbigeoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputValorCuota(BaseModel<?> oldModel) {
		ValorCuotaClp newModel = new ValorCuotaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setValorCuotaRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}