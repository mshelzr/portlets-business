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

package com.ext.portlet.pin.service.impl;

import com.ext.portlet.pin.model.Persona;
import com.ext.portlet.pin.service.base.PersonaLocalServiceBaseImpl;

/**
 * The implementation of the persona local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.pin.service.PersonaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author arodriguez
 * @see com.ext.portlet.pin.service.base.PersonaLocalServiceBaseImpl
 * @see com.ext.portlet.pin.service.PersonaLocalServiceUtil
 */
public class PersonaLocalServiceImpl extends PersonaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ext.portlet.pin.service.PersonaLocalServiceUtil} to access the persona local service.
	 */
	
	public String getNombre(long personaID){
		
		String nombre ="--";
		try{
			Persona p=personaPersistence.findByPrimaryKey(personaID);
			nombre=p.getNombres();
		}catch(Exception e ){
			e.printStackTrace();
		}
		
		return nombre;
	}
	
	public String getApellidos(long personaID){
		
		String nombre ="--";
		try{
			Persona p=personaPersistence.findByPrimaryKey(personaID);
			nombre=p.getApellidoPaterno()+" "+p.getApellidoMaterno();
		}catch(Exception e ){
			e.printStackTrace();
		}
		
		return nombre;
	}
}