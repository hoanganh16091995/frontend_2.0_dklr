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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import org.opencps.communication.model.NotificationQueue;
import org.opencps.communication.model.NotificationQueueModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the NotificationQueue service. Represents a row in the &quot;opencps_notificationqueue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link NotificationQueueModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NotificationQueueImpl}.
 * </p>
 *
 * @author khoavd
 * @see NotificationQueueImpl
 * @see NotificationQueue
 * @see NotificationQueueModel
 * @generated
 */
@ProviderType
public class NotificationQueueModelImpl extends BaseModelImpl<NotificationQueue>
	implements NotificationQueueModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a notification queue model instance should use the {@link NotificationQueue} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_notificationqueue";
	public static final Object[][] TABLE_COLUMNS = {
			{ "notificationQueueId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "notificationType", Types.VARCHAR },
			{ "className", Types.VARCHAR },
			{ "classPK", Types.VARCHAR },
			{ "payload", Types.VARCHAR },
			{ "fromUsername", Types.VARCHAR },
			{ "toUsername", Types.VARCHAR },
			{ "toUserId", Types.BIGINT },
			{ "toEmail", Types.VARCHAR },
			{ "toTelNo", Types.VARCHAR },
			{ "publicationDate", Types.TIMESTAMP },
			{ "expireDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("notificationQueueId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("notificationType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("className", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("classPK", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("payload", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fromUsername", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("toUsername", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("toUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("toEmail", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("toTelNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("publicationDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("expireDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_notificationqueue (notificationQueueId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,notificationType VARCHAR(75) null,className VARCHAR(75) null,classPK VARCHAR(75) null,payload VARCHAR(75) null,fromUsername VARCHAR(75) null,toUsername VARCHAR(75) null,toUserId LONG,toEmail VARCHAR(75) null,toTelNo VARCHAR(75) null,publicationDate DATE null,expireDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_notificationqueue";
	public static final String ORDER_BY_JPQL = " ORDER BY notificationQueue.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_notificationqueue.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(backend.communication.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.communication.model.NotificationQueue"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(backend.communication.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.communication.model.NotificationQueue"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(backend.communication.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.communication.model.NotificationQueue"));

	public NotificationQueueModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _notificationQueueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNotificationQueueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _notificationQueueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return NotificationQueue.class;
	}

	@Override
	public String getModelClassName() {
		return NotificationQueue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("notificationQueueId", getNotificationQueueId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("notificationType", getNotificationType());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("payload", getPayload());
		attributes.put("fromUsername", getFromUsername());
		attributes.put("toUsername", getToUsername());
		attributes.put("toUserId", getToUserId());
		attributes.put("toEmail", getToEmail());
		attributes.put("toTelNo", getToTelNo());
		attributes.put("publicationDate", getPublicationDate());
		attributes.put("expireDate", getExpireDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long notificationQueueId = (Long)attributes.get("notificationQueueId");

		if (notificationQueueId != null) {
			setNotificationQueueId(notificationQueueId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String notificationType = (String)attributes.get("notificationType");

		if (notificationType != null) {
			setNotificationType(notificationType);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		String classPK = (String)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String payload = (String)attributes.get("payload");

		if (payload != null) {
			setPayload(payload);
		}

		String fromUsername = (String)attributes.get("fromUsername");

		if (fromUsername != null) {
			setFromUsername(fromUsername);
		}

		String toUsername = (String)attributes.get("toUsername");

		if (toUsername != null) {
			setToUsername(toUsername);
		}

		Long toUserId = (Long)attributes.get("toUserId");

		if (toUserId != null) {
			setToUserId(toUserId);
		}

		String toEmail = (String)attributes.get("toEmail");

		if (toEmail != null) {
			setToEmail(toEmail);
		}

		String toTelNo = (String)attributes.get("toTelNo");

		if (toTelNo != null) {
			setToTelNo(toTelNo);
		}

		Date publicationDate = (Date)attributes.get("publicationDate");

		if (publicationDate != null) {
			setPublicationDate(publicationDate);
		}

		Date expireDate = (Date)attributes.get("expireDate");

		if (expireDate != null) {
			setExpireDate(expireDate);
		}
	}

	@Override
	public long getNotificationQueueId() {
		return _notificationQueueId;
	}

	@Override
	public void setNotificationQueueId(long notificationQueueId) {
		_notificationQueueId = notificationQueueId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getNotificationType() {
		if (_notificationType == null) {
			return StringPool.BLANK;
		}
		else {
			return _notificationType;
		}
	}

	@Override
	public void setNotificationType(String notificationType) {
		_notificationType = notificationType;
	}

	@Override
	public String getClassName() {
		if (_className == null) {
			return StringPool.BLANK;
		}
		else {
			return _className;
		}
	}

	@Override
	public void setClassName(String className) {
		_className = className;
	}

	@Override
	public String getClassPK() {
		if (_classPK == null) {
			return StringPool.BLANK;
		}
		else {
			return _classPK;
		}
	}

	@Override
	public void setClassPK(String classPK) {
		_classPK = classPK;
	}

	@Override
	public String getPayload() {
		if (_payload == null) {
			return StringPool.BLANK;
		}
		else {
			return _payload;
		}
	}

	@Override
	public void setPayload(String payload) {
		_payload = payload;
	}

	@Override
	public String getFromUsername() {
		if (_fromUsername == null) {
			return StringPool.BLANK;
		}
		else {
			return _fromUsername;
		}
	}

	@Override
	public void setFromUsername(String fromUsername) {
		_fromUsername = fromUsername;
	}

	@Override
	public String getToUsername() {
		if (_toUsername == null) {
			return StringPool.BLANK;
		}
		else {
			return _toUsername;
		}
	}

	@Override
	public void setToUsername(String toUsername) {
		_toUsername = toUsername;
	}

	@Override
	public long getToUserId() {
		return _toUserId;
	}

	@Override
	public void setToUserId(long toUserId) {
		_toUserId = toUserId;
	}

	@Override
	public String getToUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getToUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setToUserUuid(String toUserUuid) {
	}

	@Override
	public String getToEmail() {
		if (_toEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _toEmail;
		}
	}

	@Override
	public void setToEmail(String toEmail) {
		_toEmail = toEmail;
	}

	@Override
	public String getToTelNo() {
		if (_toTelNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _toTelNo;
		}
	}

	@Override
	public void setToTelNo(String toTelNo) {
		_toTelNo = toTelNo;
	}

	@Override
	public Date getPublicationDate() {
		return _publicationDate;
	}

	@Override
	public void setPublicationDate(Date publicationDate) {
		_publicationDate = publicationDate;
	}

	@Override
	public Date getExpireDate() {
		return _expireDate;
	}

	@Override
	public void setExpireDate(Date expireDate) {
		_expireDate = expireDate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			NotificationQueue.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public NotificationQueue toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (NotificationQueue)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		NotificationQueueImpl notificationQueueImpl = new NotificationQueueImpl();

		notificationQueueImpl.setNotificationQueueId(getNotificationQueueId());
		notificationQueueImpl.setGroupId(getGroupId());
		notificationQueueImpl.setCompanyId(getCompanyId());
		notificationQueueImpl.setUserId(getUserId());
		notificationQueueImpl.setUserName(getUserName());
		notificationQueueImpl.setCreateDate(getCreateDate());
		notificationQueueImpl.setModifiedDate(getModifiedDate());
		notificationQueueImpl.setNotificationType(getNotificationType());
		notificationQueueImpl.setClassName(getClassName());
		notificationQueueImpl.setClassPK(getClassPK());
		notificationQueueImpl.setPayload(getPayload());
		notificationQueueImpl.setFromUsername(getFromUsername());
		notificationQueueImpl.setToUsername(getToUsername());
		notificationQueueImpl.setToUserId(getToUserId());
		notificationQueueImpl.setToEmail(getToEmail());
		notificationQueueImpl.setToTelNo(getToTelNo());
		notificationQueueImpl.setPublicationDate(getPublicationDate());
		notificationQueueImpl.setExpireDate(getExpireDate());

		notificationQueueImpl.resetOriginalValues();

		return notificationQueueImpl;
	}

	@Override
	public int compareTo(NotificationQueue notificationQueue) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				notificationQueue.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificationQueue)) {
			return false;
		}

		NotificationQueue notificationQueue = (NotificationQueue)obj;

		long primaryKey = notificationQueue.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		NotificationQueueModelImpl notificationQueueModelImpl = this;

		notificationQueueModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<NotificationQueue> toCacheModel() {
		NotificationQueueCacheModel notificationQueueCacheModel = new NotificationQueueCacheModel();

		notificationQueueCacheModel.notificationQueueId = getNotificationQueueId();

		notificationQueueCacheModel.groupId = getGroupId();

		notificationQueueCacheModel.companyId = getCompanyId();

		notificationQueueCacheModel.userId = getUserId();

		notificationQueueCacheModel.userName = getUserName();

		String userName = notificationQueueCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			notificationQueueCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			notificationQueueCacheModel.createDate = createDate.getTime();
		}
		else {
			notificationQueueCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			notificationQueueCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			notificationQueueCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		notificationQueueCacheModel.notificationType = getNotificationType();

		String notificationType = notificationQueueCacheModel.notificationType;

		if ((notificationType != null) && (notificationType.length() == 0)) {
			notificationQueueCacheModel.notificationType = null;
		}

		notificationQueueCacheModel.className = getClassName();

		String className = notificationQueueCacheModel.className;

		if ((className != null) && (className.length() == 0)) {
			notificationQueueCacheModel.className = null;
		}

		notificationQueueCacheModel.classPK = getClassPK();

		String classPK = notificationQueueCacheModel.classPK;

		if ((classPK != null) && (classPK.length() == 0)) {
			notificationQueueCacheModel.classPK = null;
		}

		notificationQueueCacheModel.payload = getPayload();

		String payload = notificationQueueCacheModel.payload;

		if ((payload != null) && (payload.length() == 0)) {
			notificationQueueCacheModel.payload = null;
		}

		notificationQueueCacheModel.fromUsername = getFromUsername();

		String fromUsername = notificationQueueCacheModel.fromUsername;

		if ((fromUsername != null) && (fromUsername.length() == 0)) {
			notificationQueueCacheModel.fromUsername = null;
		}

		notificationQueueCacheModel.toUsername = getToUsername();

		String toUsername = notificationQueueCacheModel.toUsername;

		if ((toUsername != null) && (toUsername.length() == 0)) {
			notificationQueueCacheModel.toUsername = null;
		}

		notificationQueueCacheModel.toUserId = getToUserId();

		notificationQueueCacheModel.toEmail = getToEmail();

		String toEmail = notificationQueueCacheModel.toEmail;

		if ((toEmail != null) && (toEmail.length() == 0)) {
			notificationQueueCacheModel.toEmail = null;
		}

		notificationQueueCacheModel.toTelNo = getToTelNo();

		String toTelNo = notificationQueueCacheModel.toTelNo;

		if ((toTelNo != null) && (toTelNo.length() == 0)) {
			notificationQueueCacheModel.toTelNo = null;
		}

		Date publicationDate = getPublicationDate();

		if (publicationDate != null) {
			notificationQueueCacheModel.publicationDate = publicationDate.getTime();
		}
		else {
			notificationQueueCacheModel.publicationDate = Long.MIN_VALUE;
		}

		Date expireDate = getExpireDate();

		if (expireDate != null) {
			notificationQueueCacheModel.expireDate = expireDate.getTime();
		}
		else {
			notificationQueueCacheModel.expireDate = Long.MIN_VALUE;
		}

		return notificationQueueCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{notificationQueueId=");
		sb.append(getNotificationQueueId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", notificationType=");
		sb.append(getNotificationType());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", payload=");
		sb.append(getPayload());
		sb.append(", fromUsername=");
		sb.append(getFromUsername());
		sb.append(", toUsername=");
		sb.append(getToUsername());
		sb.append(", toUserId=");
		sb.append(getToUserId());
		sb.append(", toEmail=");
		sb.append(getToEmail());
		sb.append(", toTelNo=");
		sb.append(getToTelNo());
		sb.append(", publicationDate=");
		sb.append(getPublicationDate());
		sb.append(", expireDate=");
		sb.append(getExpireDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("org.opencps.communication.model.NotificationQueue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>notificationQueueId</column-name><column-value><![CDATA[");
		sb.append(getNotificationQueueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notificationType</column-name><column-value><![CDATA[");
		sb.append(getNotificationType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>payload</column-name><column-value><![CDATA[");
		sb.append(getPayload());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromUsername</column-name><column-value><![CDATA[");
		sb.append(getFromUsername());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toUsername</column-name><column-value><![CDATA[");
		sb.append(getToUsername());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toUserId</column-name><column-value><![CDATA[");
		sb.append(getToUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toEmail</column-name><column-value><![CDATA[");
		sb.append(getToEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toTelNo</column-name><column-value><![CDATA[");
		sb.append(getToTelNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publicationDate</column-name><column-value><![CDATA[");
		sb.append(getPublicationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expireDate</column-name><column-value><![CDATA[");
		sb.append(getExpireDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = NotificationQueue.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			NotificationQueue.class
		};
	private long _notificationQueueId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _notificationType;
	private String _className;
	private String _classPK;
	private String _payload;
	private String _fromUsername;
	private String _toUsername;
	private long _toUserId;
	private String _toEmail;
	private String _toTelNo;
	private Date _publicationDate;
	private Date _expireDate;
	private NotificationQueue _escapedModel;
}