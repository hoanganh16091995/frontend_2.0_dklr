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

package org.opencps.datamgt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import org.opencps.datamgt.model.WorkTime;
import org.opencps.datamgt.model.WorkTimeModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the WorkTime service. Represents a row in the &quot;opencps_workTime&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link WorkTimeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WorkTimeImpl}.
 * </p>
 *
 * @author khoavu
 * @see WorkTimeImpl
 * @see WorkTime
 * @see WorkTimeModel
 * @generated
 */
@ProviderType
public class WorkTimeModelImpl extends BaseModelImpl<WorkTime>
	implements WorkTimeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a work time model instance should use the {@link WorkTime} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_workTime";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "workTimeId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "day", Types.INTEGER },
			{ "hours", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("workTimeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("day", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("hours", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_workTime (uuid_ VARCHAR(75) null,workTimeId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,day INTEGER,hours VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_workTime";
	public static final String ORDER_BY_JPQL = " ORDER BY workTime.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_workTime.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.datamgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.datamgt.model.WorkTime"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.datamgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.datamgt.model.WorkTime"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.datamgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.datamgt.model.WorkTime"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long DAY_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long CREATEDATE_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.datamgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.datamgt.model.WorkTime"));

	public WorkTimeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _workTimeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWorkTimeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workTimeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return WorkTime.class;
	}

	@Override
	public String getModelClassName() {
		return WorkTime.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("workTimeId", getWorkTimeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("day", getDay());
		attributes.put("hours", getHours());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long workTimeId = (Long)attributes.get("workTimeId");

		if (workTimeId != null) {
			setWorkTimeId(workTimeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Integer day = (Integer)attributes.get("day");

		if (day != null) {
			setDay(day);
		}

		String hours = (String)attributes.get("hours");

		if (hours != null) {
			setHours(hours);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getWorkTimeId() {
		return _workTimeId;
	}

	@Override
	public void setWorkTimeId(long workTimeId) {
		_workTimeId = workTimeId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
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
		_columnBitmask = -1L;

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
	public int getDay() {
		return _day;
	}

	@Override
	public void setDay(int day) {
		_columnBitmask |= DAY_COLUMN_BITMASK;

		if (!_setOriginalDay) {
			_setOriginalDay = true;

			_originalDay = _day;
		}

		_day = day;
	}

	public int getOriginalDay() {
		return _originalDay;
	}

	@Override
	public String getHours() {
		if (_hours == null) {
			return StringPool.BLANK;
		}
		else {
			return _hours;
		}
	}

	@Override
	public void setHours(String hours) {
		_hours = hours;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				WorkTime.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			WorkTime.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public WorkTime toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (WorkTime)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		WorkTimeImpl workTimeImpl = new WorkTimeImpl();

		workTimeImpl.setUuid(getUuid());
		workTimeImpl.setWorkTimeId(getWorkTimeId());
		workTimeImpl.setCompanyId(getCompanyId());
		workTimeImpl.setGroupId(getGroupId());
		workTimeImpl.setUserId(getUserId());
		workTimeImpl.setUserName(getUserName());
		workTimeImpl.setCreateDate(getCreateDate());
		workTimeImpl.setModifiedDate(getModifiedDate());
		workTimeImpl.setDay(getDay());
		workTimeImpl.setHours(getHours());

		workTimeImpl.resetOriginalValues();

		return workTimeImpl;
	}

	@Override
	public int compareTo(WorkTime workTime) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), workTime.getCreateDate());

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

		if (!(obj instanceof WorkTime)) {
			return false;
		}

		WorkTime workTime = (WorkTime)obj;

		long primaryKey = workTime.getPrimaryKey();

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
		WorkTimeModelImpl workTimeModelImpl = this;

		workTimeModelImpl._originalUuid = workTimeModelImpl._uuid;

		workTimeModelImpl._originalCompanyId = workTimeModelImpl._companyId;

		workTimeModelImpl._setOriginalCompanyId = false;

		workTimeModelImpl._originalGroupId = workTimeModelImpl._groupId;

		workTimeModelImpl._setOriginalGroupId = false;

		workTimeModelImpl._setModifiedDate = false;

		workTimeModelImpl._originalDay = workTimeModelImpl._day;

		workTimeModelImpl._setOriginalDay = false;

		workTimeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WorkTime> toCacheModel() {
		WorkTimeCacheModel workTimeCacheModel = new WorkTimeCacheModel();

		workTimeCacheModel.uuid = getUuid();

		String uuid = workTimeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			workTimeCacheModel.uuid = null;
		}

		workTimeCacheModel.workTimeId = getWorkTimeId();

		workTimeCacheModel.companyId = getCompanyId();

		workTimeCacheModel.groupId = getGroupId();

		workTimeCacheModel.userId = getUserId();

		workTimeCacheModel.userName = getUserName();

		String userName = workTimeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			workTimeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			workTimeCacheModel.createDate = createDate.getTime();
		}
		else {
			workTimeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			workTimeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			workTimeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		workTimeCacheModel.day = getDay();

		workTimeCacheModel.hours = getHours();

		String hours = workTimeCacheModel.hours;

		if ((hours != null) && (hours.length() == 0)) {
			workTimeCacheModel.hours = null;
		}

		return workTimeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", workTimeId=");
		sb.append(getWorkTimeId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", day=");
		sb.append(getDay());
		sb.append(", hours=");
		sb.append(getHours());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.opencps.datamgt.model.WorkTime");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workTimeId</column-name><column-value><![CDATA[");
		sb.append(getWorkTimeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
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
			"<column><column-name>day</column-name><column-value><![CDATA[");
		sb.append(getDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hours</column-name><column-value><![CDATA[");
		sb.append(getHours());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = WorkTime.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			WorkTime.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _workTimeId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _day;
	private int _originalDay;
	private boolean _setOriginalDay;
	private String _hours;
	private long _columnBitmask;
	private WorkTime _escapedModel;
}