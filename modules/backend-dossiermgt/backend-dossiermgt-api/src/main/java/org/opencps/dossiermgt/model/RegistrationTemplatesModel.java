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

package org.opencps.dossiermgt.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the RegistrationTemplates service. Represents a row in the &quot;opencps_registrationtemplate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.opencps.dossiermgt.model.impl.RegistrationTemplatesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.opencps.dossiermgt.model.impl.RegistrationTemplatesImpl}.
 * </p>
 *
 * @author huymq
 * @see RegistrationTemplates
 * @see org.opencps.dossiermgt.model.impl.RegistrationTemplatesImpl
 * @see org.opencps.dossiermgt.model.impl.RegistrationTemplatesModelImpl
 * @generated
 */
@ProviderType
public interface RegistrationTemplatesModel extends BaseModel<RegistrationTemplates> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a registration templates model instance should use the {@link RegistrationTemplates} interface instead.
	 */

	/**
	 * Returns the primary key of this registration templates.
	 *
	 * @return the primary key of this registration templates
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this registration templates.
	 *
	 * @param primaryKey the primary key of this registration templates
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this registration templates.
	 *
	 * @return the uuid of this registration templates
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this registration templates.
	 *
	 * @param uuid the uuid of this registration templates
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the registration template ID of this registration templates.
	 *
	 * @return the registration template ID of this registration templates
	 */
	public long getRegistrationTemplateId();

	/**
	 * Sets the registration template ID of this registration templates.
	 *
	 * @param registrationTemplateId the registration template ID of this registration templates
	 */
	public void setRegistrationTemplateId(long registrationTemplateId);

	/**
	 * Returns the group ID of this registration templates.
	 *
	 * @return the group ID of this registration templates
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this registration templates.
	 *
	 * @param groupId the group ID of this registration templates
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this registration templates.
	 *
	 * @return the user ID of this registration templates
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this registration templates.
	 *
	 * @param userId the user ID of this registration templates
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this registration templates.
	 *
	 * @return the user uuid of this registration templates
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this registration templates.
	 *
	 * @param userUuid the user uuid of this registration templates
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this registration templates.
	 *
	 * @return the user name of this registration templates
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this registration templates.
	 *
	 * @param userName the user name of this registration templates
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this registration templates.
	 *
	 * @return the create date of this registration templates
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this registration templates.
	 *
	 * @param createDate the create date of this registration templates
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this registration templates.
	 *
	 * @return the modified date of this registration templates
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this registration templates.
	 *
	 * @param modifiedDate the modified date of this registration templates
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the gov agency code of this registration templates.
	 *
	 * @return the gov agency code of this registration templates
	 */
	@AutoEscape
	public String getGovAgencyCode();

	/**
	 * Sets the gov agency code of this registration templates.
	 *
	 * @param govAgencyCode the gov agency code of this registration templates
	 */
	public void setGovAgencyCode(String govAgencyCode);

	/**
	 * Returns the gov agency name of this registration templates.
	 *
	 * @return the gov agency name of this registration templates
	 */
	@AutoEscape
	public String getGovAgencyName();

	/**
	 * Sets the gov agency name of this registration templates.
	 *
	 * @param govAgencyName the gov agency name of this registration templates
	 */
	public void setGovAgencyName(String govAgencyName);

	/**
	 * Returns the form no of this registration templates.
	 *
	 * @return the form no of this registration templates
	 */
	@AutoEscape
	public String getFormNo();

	/**
	 * Sets the form no of this registration templates.
	 *
	 * @param formNo the form no of this registration templates
	 */
	public void setFormNo(String formNo);

	/**
	 * Returns the form name of this registration templates.
	 *
	 * @return the form name of this registration templates
	 */
	@AutoEscape
	public String getFormName();

	/**
	 * Sets the form name of this registration templates.
	 *
	 * @param formName the form name of this registration templates
	 */
	public void setFormName(String formName);

	/**
	 * Returns the multiple of this registration templates.
	 *
	 * @return the multiple of this registration templates
	 */
	public boolean getMultiple();

	/**
	 * Returns <code>true</code> if this registration templates is multiple.
	 *
	 * @return <code>true</code> if this registration templates is multiple; <code>false</code> otherwise
	 */
	public boolean isMultiple();

	/**
	 * Sets whether this registration templates is multiple.
	 *
	 * @param multiple the multiple of this registration templates
	 */
	public void setMultiple(boolean multiple);

	/**
	 * Returns the form script of this registration templates.
	 *
	 * @return the form script of this registration templates
	 */
	@AutoEscape
	public String getFormScript();

	/**
	 * Sets the form script of this registration templates.
	 *
	 * @param formScript the form script of this registration templates
	 */
	public void setFormScript(String formScript);

	/**
	 * Returns the form report of this registration templates.
	 *
	 * @return the form report of this registration templates
	 */
	@AutoEscape
	public String getFormReport();

	/**
	 * Sets the form report of this registration templates.
	 *
	 * @param formReport the form report of this registration templates
	 */
	public void setFormReport(String formReport);

	/**
	 * Returns the sample data of this registration templates.
	 *
	 * @return the sample data of this registration templates
	 */
	@AutoEscape
	public String getSampleData();

	/**
	 * Sets the sample data of this registration templates.
	 *
	 * @param sampleData the sample data of this registration templates
	 */
	public void setSampleData(String sampleData);

	/**
	 * Returns the form script official of this registration templates.
	 *
	 * @return the form script official of this registration templates
	 */
	@AutoEscape
	public String getFormScriptOfficial();

	/**
	 * Sets the form script official of this registration templates.
	 *
	 * @param formScriptOfficial the form script official of this registration templates
	 */
	public void setFormScriptOfficial(String formScriptOfficial);

	/**
	 * Returns the form report official of this registration templates.
	 *
	 * @return the form report official of this registration templates
	 */
	@AutoEscape
	public String getFormReportOfficial();

	/**
	 * Sets the form report official of this registration templates.
	 *
	 * @param formReportOfficial the form report official of this registration templates
	 */
	public void setFormReportOfficial(String formReportOfficial);

	/**
	 * Returns the sample data official of this registration templates.
	 *
	 * @return the sample data official of this registration templates
	 */
	@AutoEscape
	public String getSampleDataOfficial();

	/**
	 * Sets the sample data official of this registration templates.
	 *
	 * @param sampleDataOfficial the sample data official of this registration templates
	 */
	public void setSampleDataOfficial(String sampleDataOfficial);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(RegistrationTemplates registrationTemplates);

	@Override
	public int hashCode();

	@Override
	public CacheModel<RegistrationTemplates> toCacheModel();

	@Override
	public RegistrationTemplates toEscapedModel();

	@Override
	public RegistrationTemplates toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}