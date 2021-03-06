/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.fds.vr.business.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.fds.vr.business.model.VRTechnicalSpec_XMYPart2;
import com.fds.vr.business.service.VRTechnicalSpec_XMYPart2LocalServiceUtil;

/**
 * The extended model base implementation for the VRTechnicalSpec_XMYPart2 service. Represents a row in the &quot;vr_technicalspec_xmy&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VRTechnicalSpec_XMYPart2Impl}.
 * </p>
 *
 * @author LamTV
 * @see VRTechnicalSpec_XMYPart2Impl
 * @see VRTechnicalSpec_XMYPart2
 * @generated
 */
@ProviderType
public abstract class VRTechnicalSpec_XMYPart2BaseImpl
	extends VRTechnicalSpec_XMYPart2ModelImpl
	implements VRTechnicalSpec_XMYPart2 {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vr technical spec_xmy part2 model instance should use the {@link VRTechnicalSpec_XMYPart2} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			VRTechnicalSpec_XMYPart2LocalServiceUtil.addVRTechnicalSpec_XMYPart2(this);
		}
		else {
			VRTechnicalSpec_XMYPart2LocalServiceUtil.updateVRTechnicalSpec_XMYPart2(this);
		}
	}
}