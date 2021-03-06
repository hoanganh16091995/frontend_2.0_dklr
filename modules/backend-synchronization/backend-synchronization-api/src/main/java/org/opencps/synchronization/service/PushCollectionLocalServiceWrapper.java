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

package org.opencps.synchronization.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PushCollectionLocalService}.
 *
 * @author trungdk
 * @see PushCollectionLocalService
 * @generated
 */
@ProviderType
public class PushCollectionLocalServiceWrapper
	implements PushCollectionLocalService,
		ServiceWrapper<PushCollectionLocalService> {
	public PushCollectionLocalServiceWrapper(
		PushCollectionLocalService pushCollectionLocalService) {
		_pushCollectionLocalService = pushCollectionLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _pushCollectionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pushCollectionLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _pushCollectionLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _pushCollectionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pushCollectionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pushCollectionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of push collections.
	*
	* @return the number of push collections
	*/
	@Override
	public int getPushCollectionsCount() {
		return _pushCollectionLocalService.getPushCollectionsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _pushCollectionLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _pushCollectionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.synchronization.model.impl.PushCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _pushCollectionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.synchronization.model.impl.PushCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _pushCollectionLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<org.opencps.synchronization.model.PushCollection> findAll(
		int start, int end) {
		return _pushCollectionLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<org.opencps.synchronization.model.PushCollection> findByGroupId_ServerNo(
		long groupId, java.lang.String serverNo, int start, int end) {
		return _pushCollectionLocalService.findByGroupId_ServerNo(groupId,
			serverNo, start, end);
	}

	/**
	* Returns a range of all the push collections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.synchronization.model.impl.PushCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of push collections
	* @param end the upper bound of the range of push collections (not inclusive)
	* @return the range of push collections
	*/
	@Override
	public java.util.List<org.opencps.synchronization.model.PushCollection> getPushCollections(
		int start, int end) {
		return _pushCollectionLocalService.getPushCollections(start, end);
	}

	/**
	* Returns all the push collections matching the UUID and company.
	*
	* @param uuid the UUID of the push collections
	* @param companyId the primary key of the company
	* @return the matching push collections, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<org.opencps.synchronization.model.PushCollection> getPushCollectionsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _pushCollectionLocalService.getPushCollectionsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of push collections matching the UUID and company.
	*
	* @param uuid the UUID of the push collections
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of push collections
	* @param end the upper bound of the range of push collections (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching push collections, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<org.opencps.synchronization.model.PushCollection> getPushCollectionsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<org.opencps.synchronization.model.PushCollection> orderByComparator) {
		return _pushCollectionLocalService.getPushCollectionsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _pushCollectionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _pushCollectionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.opencps.synchronization.model.PushCollection addPushCollection(
		long userId, long groupId, java.lang.String serverNo,
		java.lang.String collectionCode, java.lang.String collectionName,
		java.lang.String collectionNameEN, java.lang.String description,
		java.lang.String method, java.lang.String dataForm,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			org.opencps.auth.api.exception.UnauthenticationException,
			org.opencps.auth.api.exception.UnauthorizationException {
		return _pushCollectionLocalService.addPushCollection(userId, groupId,
			serverNo, collectionCode, collectionName, collectionNameEN,
			description, method, dataForm, serviceContext);
	}

	/**
	* Adds the push collection to the database. Also notifies the appropriate model listeners.
	*
	* @param pushCollection the push collection
	* @return the push collection that was added
	*/
	@Override
	public org.opencps.synchronization.model.PushCollection addPushCollection(
		org.opencps.synchronization.model.PushCollection pushCollection) {
		return _pushCollectionLocalService.addPushCollection(pushCollection);
	}

	/**
	* Creates a new push collection with the primary key. Does not add the push collection to the database.
	*
	* @param pushCollectionId the primary key for the new push collection
	* @return the new push collection
	*/
	@Override
	public org.opencps.synchronization.model.PushCollection createPushCollection(
		long pushCollectionId) {
		return _pushCollectionLocalService.createPushCollection(pushCollectionId);
	}

	/**
	* Deletes the push collection with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pushCollectionId the primary key of the push collection
	* @return the push collection that was removed
	* @throws PortalException if a push collection with the primary key could not be found
	*/
	@Override
	public org.opencps.synchronization.model.PushCollection deletePushCollection(
		long pushCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pushCollectionLocalService.deletePushCollection(pushCollectionId);
	}

	@Override
	public org.opencps.synchronization.model.PushCollection deletePushCollection(
		long pushCollectionId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws org.opencps.auth.api.exception.NotFoundException,
			org.opencps.auth.api.exception.UnauthenticationException,
			org.opencps.auth.api.exception.UnauthorizationException {
		return _pushCollectionLocalService.deletePushCollection(pushCollectionId,
			serviceContext);
	}

	/**
	* Deletes the push collection from the database. Also notifies the appropriate model listeners.
	*
	* @param pushCollection the push collection
	* @return the push collection that was removed
	*/
	@Override
	public org.opencps.synchronization.model.PushCollection deletePushCollection(
		org.opencps.synchronization.model.PushCollection pushCollection) {
		return _pushCollectionLocalService.deletePushCollection(pushCollection);
	}

	@Override
	public org.opencps.synchronization.model.PushCollection fetchPushCollection(
		long pushCollectionId) {
		return _pushCollectionLocalService.fetchPushCollection(pushCollectionId);
	}

	/**
	* Returns the push collection matching the UUID and group.
	*
	* @param uuid the push collection's UUID
	* @param groupId the primary key of the group
	* @return the matching push collection, or <code>null</code> if a matching push collection could not be found
	*/
	@Override
	public org.opencps.synchronization.model.PushCollection fetchPushCollectionByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _pushCollectionLocalService.fetchPushCollectionByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public org.opencps.synchronization.model.PushCollection findByCollectionCode_Method(
		long groupId, java.lang.String collectionCode, java.lang.String method)
		throws org.opencps.synchronization.exception.NoSuchPushCollectionException {
		return _pushCollectionLocalService.findByCollectionCode_Method(groupId,
			collectionCode, method);
	}

	/**
	* Returns the push collection with the primary key.
	*
	* @param pushCollectionId the primary key of the push collection
	* @return the push collection
	* @throws PortalException if a push collection with the primary key could not be found
	*/
	@Override
	public org.opencps.synchronization.model.PushCollection getPushCollection(
		long pushCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pushCollectionLocalService.getPushCollection(pushCollectionId);
	}

	/**
	* Returns the push collection matching the UUID and group.
	*
	* @param uuid the push collection's UUID
	* @param groupId the primary key of the group
	* @return the matching push collection
	* @throws PortalException if a matching push collection could not be found
	*/
	@Override
	public org.opencps.synchronization.model.PushCollection getPushCollectionByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pushCollectionLocalService.getPushCollectionByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public org.opencps.synchronization.model.PushCollection updatePushCollection(
		long userId, long groupId, long pushCollectionId,
		java.lang.String serverNo, java.lang.String collectionCode,
		java.lang.String collectionName, java.lang.String collectionNameEN,
		java.lang.String description, java.lang.String method,
		java.lang.String dataForm,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException,
			org.opencps.auth.api.exception.UnauthenticationException,
			org.opencps.auth.api.exception.UnauthorizationException,
			org.opencps.synchronization.exception.NoSuchPushCollectionException {
		return _pushCollectionLocalService.updatePushCollection(userId,
			groupId, pushCollectionId, serverNo, collectionCode,
			collectionName, collectionNameEN, description, method, dataForm,
			serviceContext);
	}

	/**
	* Updates the push collection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pushCollection the push collection
	* @return the push collection that was updated
	*/
	@Override
	public org.opencps.synchronization.model.PushCollection updatePushCollection(
		org.opencps.synchronization.model.PushCollection pushCollection) {
		return _pushCollectionLocalService.updatePushCollection(pushCollection);
	}

	@Override
	public PushCollectionLocalService getWrappedService() {
		return _pushCollectionLocalService;
	}

	@Override
	public void setWrappedService(
		PushCollectionLocalService pushCollectionLocalService) {
		_pushCollectionLocalService = pushCollectionLocalService;
	}

	private PushCollectionLocalService _pushCollectionLocalService;
}