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

import com.fds.vr.business.model.VRCOPReportAttach;
import com.fds.vr.business.model.VRCOPReportAttachModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the VRCOPReportAttach service. Represents a row in the &quot;vr_copreport_attach&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link VRCOPReportAttachModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VRCOPReportAttachImpl}.
 * </p>
 *
 * @author LamTV
 * @see VRCOPReportAttachImpl
 * @see VRCOPReportAttach
 * @see VRCOPReportAttachModel
 * @generated
 */
@ProviderType
public class VRCOPReportAttachModelImpl extends BaseModelImpl<VRCOPReportAttach>
	implements VRCOPReportAttachModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vrcop report attach model instance should use the {@link VRCOPReportAttach} interface instead.
	 */
	public static final String TABLE_NAME = "vr_copreport_attach";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "mtCore", Types.BIGINT },
			{ "copReportRepositoryID", Types.BIGINT },
			{ "copReportNo", Types.VARCHAR },
			{ "sequenceNo", Types.BIGINT },
			{ "DocName", Types.VARCHAR },
			{ "DocNo", Types.VARCHAR },
			{ "Remarks", Types.VARCHAR },
			{ "modifyDate", Types.TIMESTAMP },
			{ "syncDate", Types.TIMESTAMP },
			{ "dossierId", Types.BIGINT },
			{ "dossierIdCTN", Types.VARCHAR },
			{ "dossierNo", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("mtCore", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("copReportRepositoryID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("copReportNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sequenceNo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("DocName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("DocNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("Remarks", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modifyDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("syncDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dossierId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dossierIdCTN", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dossierNo", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table vr_copreport_attach (id LONG not null primary key,mtCore LONG,copReportRepositoryID LONG,copReportNo VARCHAR(75) null,sequenceNo LONG,DocName VARCHAR(75) null,DocNo VARCHAR(75) null,Remarks VARCHAR(75) null,modifyDate DATE null,syncDate DATE null,dossierId LONG,dossierIdCTN VARCHAR(75) null,dossierNo VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table vr_copreport_attach";
	public static final String ORDER_BY_JPQL = " ORDER BY vrcopReportAttach.modifyDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY vr_copreport_attach.modifyDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fds.vr.business.model.VRCOPReportAttach"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fds.vr.business.model.VRCOPReportAttach"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.fds.vr.business.model.VRCOPReportAttach"),
			true);
	public static final long COPREPORTNO_COLUMN_BITMASK = 1L;
	public static final long COPREPORTREPOSITORYID_COLUMN_BITMASK = 2L;
	public static final long DOSSIERID_COLUMN_BITMASK = 4L;
	public static final long MTCORE_COLUMN_BITMASK = 8L;
	public static final long MODIFYDATE_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.fds.vr.service.util.ServiceProps.get(
				"lock.expiration.time.com.fds.vr.business.model.VRCOPReportAttach"));

	public VRCOPReportAttachModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return VRCOPReportAttach.class;
	}

	@Override
	public String getModelClassName() {
		return VRCOPReportAttach.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("mtCore", getMtCore());
		attributes.put("copReportRepositoryID", getCopReportRepositoryID());
		attributes.put("copReportNo", getCopReportNo());
		attributes.put("sequenceNo", getSequenceNo());
		attributes.put("docName", getDocName());
		attributes.put("docNo", getDocNo());
		attributes.put("remarks", getRemarks());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("syncDate", getSyncDate());
		attributes.put("dossierId", getDossierId());
		attributes.put("dossierIdCTN", getDossierIdCTN());
		attributes.put("dossierNo", getDossierNo());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long mtCore = (Long)attributes.get("mtCore");

		if (mtCore != null) {
			setMtCore(mtCore);
		}

		Long copReportRepositoryID = (Long)attributes.get(
				"copReportRepositoryID");

		if (copReportRepositoryID != null) {
			setCopReportRepositoryID(copReportRepositoryID);
		}

		String copReportNo = (String)attributes.get("copReportNo");

		if (copReportNo != null) {
			setCopReportNo(copReportNo);
		}

		Long sequenceNo = (Long)attributes.get("sequenceNo");

		if (sequenceNo != null) {
			setSequenceNo(sequenceNo);
		}

		String docName = (String)attributes.get("docName");

		if (docName != null) {
			setDocName(docName);
		}

		String docNo = (String)attributes.get("docNo");

		if (docNo != null) {
			setDocNo(docNo);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
		}

		Date syncDate = (Date)attributes.get("syncDate");

		if (syncDate != null) {
			setSyncDate(syncDate);
		}

		Long dossierId = (Long)attributes.get("dossierId");

		if (dossierId != null) {
			setDossierId(dossierId);
		}

		String dossierIdCTN = (String)attributes.get("dossierIdCTN");

		if (dossierIdCTN != null) {
			setDossierIdCTN(dossierIdCTN);
		}

		String dossierNo = (String)attributes.get("dossierNo");

		if (dossierNo != null) {
			setDossierNo(dossierNo);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public long getMtCore() {
		return _mtCore;
	}

	@Override
	public void setMtCore(long mtCore) {
		_columnBitmask |= MTCORE_COLUMN_BITMASK;

		if (!_setOriginalMtCore) {
			_setOriginalMtCore = true;

			_originalMtCore = _mtCore;
		}

		_mtCore = mtCore;
	}

	public long getOriginalMtCore() {
		return _originalMtCore;
	}

	@Override
	public long getCopReportRepositoryID() {
		return _copReportRepositoryID;
	}

	@Override
	public void setCopReportRepositoryID(long copReportRepositoryID) {
		_columnBitmask |= COPREPORTREPOSITORYID_COLUMN_BITMASK;

		if (!_setOriginalCopReportRepositoryID) {
			_setOriginalCopReportRepositoryID = true;

			_originalCopReportRepositoryID = _copReportRepositoryID;
		}

		_copReportRepositoryID = copReportRepositoryID;
	}

	public long getOriginalCopReportRepositoryID() {
		return _originalCopReportRepositoryID;
	}

	@Override
	public String getCopReportNo() {
		if (_copReportNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _copReportNo;
		}
	}

	@Override
	public void setCopReportNo(String copReportNo) {
		_columnBitmask |= COPREPORTNO_COLUMN_BITMASK;

		if (_originalCopReportNo == null) {
			_originalCopReportNo = _copReportNo;
		}

		_copReportNo = copReportNo;
	}

	public String getOriginalCopReportNo() {
		return GetterUtil.getString(_originalCopReportNo);
	}

	@Override
	public long getSequenceNo() {
		return _sequenceNo;
	}

	@Override
	public void setSequenceNo(long sequenceNo) {
		_sequenceNo = sequenceNo;
	}

	@Override
	public String getDocName() {
		if (_docName == null) {
			return StringPool.BLANK;
		}
		else {
			return _docName;
		}
	}

	@Override
	public void setDocName(String docName) {
		_docName = docName;
	}

	@Override
	public String getDocNo() {
		if (_docNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _docNo;
		}
	}

	@Override
	public void setDocNo(String docNo) {
		_docNo = docNo;
	}

	@Override
	public String getRemarks() {
		if (_remarks == null) {
			return StringPool.BLANK;
		}
		else {
			return _remarks;
		}
	}

	@Override
	public void setRemarks(String remarks) {
		_remarks = remarks;
	}

	@Override
	public Date getModifyDate() {
		return _modifyDate;
	}

	@Override
	public void setModifyDate(Date modifyDate) {
		_columnBitmask = -1L;

		_modifyDate = modifyDate;
	}

	@Override
	public Date getSyncDate() {
		return _syncDate;
	}

	@Override
	public void setSyncDate(Date syncDate) {
		_syncDate = syncDate;
	}

	@Override
	public long getDossierId() {
		return _dossierId;
	}

	@Override
	public void setDossierId(long dossierId) {
		_columnBitmask |= DOSSIERID_COLUMN_BITMASK;

		if (!_setOriginalDossierId) {
			_setOriginalDossierId = true;

			_originalDossierId = _dossierId;
		}

		_dossierId = dossierId;
	}

	public long getOriginalDossierId() {
		return _originalDossierId;
	}

	@Override
	public String getDossierIdCTN() {
		if (_dossierIdCTN == null) {
			return StringPool.BLANK;
		}
		else {
			return _dossierIdCTN;
		}
	}

	@Override
	public void setDossierIdCTN(String dossierIdCTN) {
		_dossierIdCTN = dossierIdCTN;
	}

	@Override
	public String getDossierNo() {
		if (_dossierNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _dossierNo;
		}
	}

	@Override
	public void setDossierNo(String dossierNo) {
		_dossierNo = dossierNo;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			VRCOPReportAttach.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VRCOPReportAttach toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VRCOPReportAttach)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VRCOPReportAttachImpl vrcopReportAttachImpl = new VRCOPReportAttachImpl();

		vrcopReportAttachImpl.setId(getId());
		vrcopReportAttachImpl.setMtCore(getMtCore());
		vrcopReportAttachImpl.setCopReportRepositoryID(getCopReportRepositoryID());
		vrcopReportAttachImpl.setCopReportNo(getCopReportNo());
		vrcopReportAttachImpl.setSequenceNo(getSequenceNo());
		vrcopReportAttachImpl.setDocName(getDocName());
		vrcopReportAttachImpl.setDocNo(getDocNo());
		vrcopReportAttachImpl.setRemarks(getRemarks());
		vrcopReportAttachImpl.setModifyDate(getModifyDate());
		vrcopReportAttachImpl.setSyncDate(getSyncDate());
		vrcopReportAttachImpl.setDossierId(getDossierId());
		vrcopReportAttachImpl.setDossierIdCTN(getDossierIdCTN());
		vrcopReportAttachImpl.setDossierNo(getDossierNo());

		vrcopReportAttachImpl.resetOriginalValues();

		return vrcopReportAttachImpl;
	}

	@Override
	public int compareTo(VRCOPReportAttach vrcopReportAttach) {
		int value = 0;

		value = DateUtil.compareTo(getModifyDate(),
				vrcopReportAttach.getModifyDate());

		value = value * -1;

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

		if (!(obj instanceof VRCOPReportAttach)) {
			return false;
		}

		VRCOPReportAttach vrcopReportAttach = (VRCOPReportAttach)obj;

		long primaryKey = vrcopReportAttach.getPrimaryKey();

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
		VRCOPReportAttachModelImpl vrcopReportAttachModelImpl = this;

		vrcopReportAttachModelImpl._originalMtCore = vrcopReportAttachModelImpl._mtCore;

		vrcopReportAttachModelImpl._setOriginalMtCore = false;

		vrcopReportAttachModelImpl._originalCopReportRepositoryID = vrcopReportAttachModelImpl._copReportRepositoryID;

		vrcopReportAttachModelImpl._setOriginalCopReportRepositoryID = false;

		vrcopReportAttachModelImpl._originalCopReportNo = vrcopReportAttachModelImpl._copReportNo;

		vrcopReportAttachModelImpl._originalDossierId = vrcopReportAttachModelImpl._dossierId;

		vrcopReportAttachModelImpl._setOriginalDossierId = false;

		vrcopReportAttachModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VRCOPReportAttach> toCacheModel() {
		VRCOPReportAttachCacheModel vrcopReportAttachCacheModel = new VRCOPReportAttachCacheModel();

		vrcopReportAttachCacheModel.id = getId();

		vrcopReportAttachCacheModel.mtCore = getMtCore();

		vrcopReportAttachCacheModel.copReportRepositoryID = getCopReportRepositoryID();

		vrcopReportAttachCacheModel.copReportNo = getCopReportNo();

		String copReportNo = vrcopReportAttachCacheModel.copReportNo;

		if ((copReportNo != null) && (copReportNo.length() == 0)) {
			vrcopReportAttachCacheModel.copReportNo = null;
		}

		vrcopReportAttachCacheModel.sequenceNo = getSequenceNo();

		vrcopReportAttachCacheModel.docName = getDocName();

		String docName = vrcopReportAttachCacheModel.docName;

		if ((docName != null) && (docName.length() == 0)) {
			vrcopReportAttachCacheModel.docName = null;
		}

		vrcopReportAttachCacheModel.docNo = getDocNo();

		String docNo = vrcopReportAttachCacheModel.docNo;

		if ((docNo != null) && (docNo.length() == 0)) {
			vrcopReportAttachCacheModel.docNo = null;
		}

		vrcopReportAttachCacheModel.remarks = getRemarks();

		String remarks = vrcopReportAttachCacheModel.remarks;

		if ((remarks != null) && (remarks.length() == 0)) {
			vrcopReportAttachCacheModel.remarks = null;
		}

		Date modifyDate = getModifyDate();

		if (modifyDate != null) {
			vrcopReportAttachCacheModel.modifyDate = modifyDate.getTime();
		}
		else {
			vrcopReportAttachCacheModel.modifyDate = Long.MIN_VALUE;
		}

		Date syncDate = getSyncDate();

		if (syncDate != null) {
			vrcopReportAttachCacheModel.syncDate = syncDate.getTime();
		}
		else {
			vrcopReportAttachCacheModel.syncDate = Long.MIN_VALUE;
		}

		vrcopReportAttachCacheModel.dossierId = getDossierId();

		vrcopReportAttachCacheModel.dossierIdCTN = getDossierIdCTN();

		String dossierIdCTN = vrcopReportAttachCacheModel.dossierIdCTN;

		if ((dossierIdCTN != null) && (dossierIdCTN.length() == 0)) {
			vrcopReportAttachCacheModel.dossierIdCTN = null;
		}

		vrcopReportAttachCacheModel.dossierNo = getDossierNo();

		String dossierNo = vrcopReportAttachCacheModel.dossierNo;

		if ((dossierNo != null) && (dossierNo.length() == 0)) {
			vrcopReportAttachCacheModel.dossierNo = null;
		}

		return vrcopReportAttachCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", mtCore=");
		sb.append(getMtCore());
		sb.append(", copReportRepositoryID=");
		sb.append(getCopReportRepositoryID());
		sb.append(", copReportNo=");
		sb.append(getCopReportNo());
		sb.append(", sequenceNo=");
		sb.append(getSequenceNo());
		sb.append(", docName=");
		sb.append(getDocName());
		sb.append(", docNo=");
		sb.append(getDocNo());
		sb.append(", remarks=");
		sb.append(getRemarks());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", syncDate=");
		sb.append(getSyncDate());
		sb.append(", dossierId=");
		sb.append(getDossierId());
		sb.append(", dossierIdCTN=");
		sb.append(getDossierIdCTN());
		sb.append(", dossierNo=");
		sb.append(getDossierNo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.fds.vr.business.model.VRCOPReportAttach");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mtCore</column-name><column-value><![CDATA[");
		sb.append(getMtCore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>copReportRepositoryID</column-name><column-value><![CDATA[");
		sb.append(getCopReportRepositoryID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>copReportNo</column-name><column-value><![CDATA[");
		sb.append(getCopReportNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sequenceNo</column-name><column-value><![CDATA[");
		sb.append(getSequenceNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>docName</column-name><column-value><![CDATA[");
		sb.append(getDocName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>docNo</column-name><column-value><![CDATA[");
		sb.append(getDocNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remarks</column-name><column-value><![CDATA[");
		sb.append(getRemarks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifyDate</column-name><column-value><![CDATA[");
		sb.append(getModifyDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>syncDate</column-name><column-value><![CDATA[");
		sb.append(getSyncDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierId</column-name><column-value><![CDATA[");
		sb.append(getDossierId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierIdCTN</column-name><column-value><![CDATA[");
		sb.append(getDossierIdCTN());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierNo</column-name><column-value><![CDATA[");
		sb.append(getDossierNo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = VRCOPReportAttach.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			VRCOPReportAttach.class
		};
	private long _id;
	private long _mtCore;
	private long _originalMtCore;
	private boolean _setOriginalMtCore;
	private long _copReportRepositoryID;
	private long _originalCopReportRepositoryID;
	private boolean _setOriginalCopReportRepositoryID;
	private String _copReportNo;
	private String _originalCopReportNo;
	private long _sequenceNo;
	private String _docName;
	private String _docNo;
	private String _remarks;
	private Date _modifyDate;
	private Date _syncDate;
	private long _dossierId;
	private long _originalDossierId;
	private boolean _setOriginalDossierId;
	private String _dossierIdCTN;
	private String _dossierNo;
	private long _columnBitmask;
	private VRCOPReportAttach _escapedModel;
}