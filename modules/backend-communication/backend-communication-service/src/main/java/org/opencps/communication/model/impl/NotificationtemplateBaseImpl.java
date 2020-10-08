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

package org.opencps.communication.model.impl;

import aQute.bnd.annotation.ProviderType;

import org.opencps.communication.model.Notificationtemplate;
import org.opencps.communication.service.NotificationtemplateLocalServiceUtil;

/**
 * The extended model base implementation for the Notificationtemplate service. Represents a row in the &quot;opencps_notificationtemplate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NotificationtemplateImpl}.
 * </p>
 *
 * @author khoavd
 * @see NotificationtemplateImpl
 * @see Notificationtemplate
 * @generated
 */
@ProviderType
public abstract class NotificationtemplateBaseImpl
	extends NotificationtemplateModelImpl implements Notificationtemplate {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a notificationtemplate model instance should use the {@link Notificationtemplate} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			NotificationtemplateLocalServiceUtil.addNotificationtemplate(this);
		}
		else {
			NotificationtemplateLocalServiceUtil.updateNotificationtemplate(this);
		}
	}
}