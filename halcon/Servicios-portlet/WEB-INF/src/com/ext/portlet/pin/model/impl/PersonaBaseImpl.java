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
import com.ext.portlet.pin.service.PersonaLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the Persona service. Represents a row in the &quot;Persona&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PersonaImpl}.
 * </p>
 *
 * @author arodriguez
 * @see PersonaImpl
 * @see com.ext.portlet.pin.model.Persona
 * @generated
 */
public abstract class PersonaBaseImpl extends PersonaModelImpl
	implements Persona {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a persona model instance should use the {@link Persona} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			PersonaLocalServiceUtil.addPersona(this);
		}
		else {
			PersonaLocalServiceUtil.updatePersona(this);
		}
	}
}