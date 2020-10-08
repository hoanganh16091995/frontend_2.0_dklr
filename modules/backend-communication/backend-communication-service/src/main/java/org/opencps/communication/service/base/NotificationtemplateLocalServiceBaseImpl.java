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

package org.opencps.communication.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import org.opencps.communication.model.Notificationtemplate;
import org.opencps.communication.service.NotificationtemplateLocalService;
import org.opencps.communication.service.persistence.NotificationQueuePersistence;
import org.opencps.communication.service.persistence.NotificationtemplatePersistence;
import org.opencps.communication.service.persistence.ServerConfigPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the notificationtemplate local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.opencps.communication.service.impl.NotificationtemplateLocalServiceImpl}.
 * </p>
 *
 * @author khoavd
 * @see org.opencps.communication.service.impl.NotificationtemplateLocalServiceImpl
 * @see org.opencps.communication.service.NotificationtemplateLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class NotificationtemplateLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements NotificationtemplateLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.opencps.communication.service.NotificationtemplateLocalServiceUtil} to access the notificationtemplate local service.
	 */

	/**
	 * Adds the notificationtemplate to the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificationtemplate the notificationtemplate
	 * @return the notificationtemplate that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Notificationtemplate addNotificationtemplate(
		Notificationtemplate notificationtemplate) {
		notificationtemplate.setNew(true);

		return notificationtemplatePersistence.update(notificationtemplate);
	}

	/**
	 * Creates a new notificationtemplate with the primary key. Does not add the notificationtemplate to the database.
	 *
	 * @param notificationTemplateId the primary key for the new notificationtemplate
	 * @return the new notificationtemplate
	 */
	@Override
	public Notificationtemplate createNotificationtemplate(
		long notificationTemplateId) {
		return notificationtemplatePersistence.create(notificationTemplateId);
	}

	/**
	 * Deletes the notificationtemplate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificationTemplateId the primary key of the notificationtemplate
	 * @return the notificationtemplate that was removed
	 * @throws PortalException if a notificationtemplate with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Notificationtemplate deleteNotificationtemplate(
		long notificationTemplateId) throws PortalException {
		return notificationtemplatePersistence.remove(notificationTemplateId);
	}

	/**
	 * Deletes the notificationtemplate from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificationtemplate the notificationtemplate
	 * @return the notificationtemplate that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Notificationtemplate deleteNotificationtemplate(
		Notificationtemplate notificationtemplate) {
		return notificationtemplatePersistence.remove(notificationtemplate);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Notificationtemplate.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return notificationtemplatePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.communication.model.impl.NotificationtemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return notificationtemplatePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.communication.model.impl.NotificationtemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return notificationtemplatePersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return notificationtemplatePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return notificationtemplatePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Notificationtemplate fetchNotificationtemplate(
		long notificationTemplateId) {
		return notificationtemplatePersistence.fetchByPrimaryKey(notificationTemplateId);
	}

	/**
	 * Returns the notificationtemplate with the primary key.
	 *
	 * @param notificationTemplateId the primary key of the notificationtemplate
	 * @return the notificationtemplate
	 * @throws PortalException if a notificationtemplate with the primary key could not be found
	 */
	@Override
	public Notificationtemplate getNotificationtemplate(
		long notificationTemplateId) throws PortalException {
		return notificationtemplatePersistence.findByPrimaryKey(notificationTemplateId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(notificationtemplateLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Notificationtemplate.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"notificationTemplateId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(notificationtemplateLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Notificationtemplate.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"notificationTemplateId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(notificationtemplateLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Notificationtemplate.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"notificationTemplateId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return notificationtemplateLocalService.deleteNotificationtemplate((Notificationtemplate)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return notificationtemplatePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the notificationtemplates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.communication.model.impl.NotificationtemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of notificationtemplates
	 * @param end the upper bound of the range of notificationtemplates (not inclusive)
	 * @return the range of notificationtemplates
	 */
	@Override
	public List<Notificationtemplate> getNotificationtemplates(int start,
		int end) {
		return notificationtemplatePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of notificationtemplates.
	 *
	 * @return the number of notificationtemplates
	 */
	@Override
	public int getNotificationtemplatesCount() {
		return notificationtemplatePersistence.countAll();
	}

	/**
	 * Updates the notificationtemplate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param notificationtemplate the notificationtemplate
	 * @return the notificationtemplate that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Notificationtemplate updateNotificationtemplate(
		Notificationtemplate notificationtemplate) {
		return notificationtemplatePersistence.update(notificationtemplate);
	}

	/**
	 * Returns the notification queue local service.
	 *
	 * @return the notification queue local service
	 */
	public org.opencps.communication.service.NotificationQueueLocalService getNotificationQueueLocalService() {
		return notificationQueueLocalService;
	}

	/**
	 * Sets the notification queue local service.
	 *
	 * @param notificationQueueLocalService the notification queue local service
	 */
	public void setNotificationQueueLocalService(
		org.opencps.communication.service.NotificationQueueLocalService notificationQueueLocalService) {
		this.notificationQueueLocalService = notificationQueueLocalService;
	}

	/**
	 * Returns the notification queue persistence.
	 *
	 * @return the notification queue persistence
	 */
	public NotificationQueuePersistence getNotificationQueuePersistence() {
		return notificationQueuePersistence;
	}

	/**
	 * Sets the notification queue persistence.
	 *
	 * @param notificationQueuePersistence the notification queue persistence
	 */
	public void setNotificationQueuePersistence(
		NotificationQueuePersistence notificationQueuePersistence) {
		this.notificationQueuePersistence = notificationQueuePersistence;
	}

	/**
	 * Returns the notificationtemplate local service.
	 *
	 * @return the notificationtemplate local service
	 */
	public NotificationtemplateLocalService getNotificationtemplateLocalService() {
		return notificationtemplateLocalService;
	}

	/**
	 * Sets the notificationtemplate local service.
	 *
	 * @param notificationtemplateLocalService the notificationtemplate local service
	 */
	public void setNotificationtemplateLocalService(
		NotificationtemplateLocalService notificationtemplateLocalService) {
		this.notificationtemplateLocalService = notificationtemplateLocalService;
	}

	/**
	 * Returns the notificationtemplate persistence.
	 *
	 * @return the notificationtemplate persistence
	 */
	public NotificationtemplatePersistence getNotificationtemplatePersistence() {
		return notificationtemplatePersistence;
	}

	/**
	 * Sets the notificationtemplate persistence.
	 *
	 * @param notificationtemplatePersistence the notificationtemplate persistence
	 */
	public void setNotificationtemplatePersistence(
		NotificationtemplatePersistence notificationtemplatePersistence) {
		this.notificationtemplatePersistence = notificationtemplatePersistence;
	}

	/**
	 * Returns the server config local service.
	 *
	 * @return the server config local service
	 */
	public org.opencps.communication.service.ServerConfigLocalService getServerConfigLocalService() {
		return serverConfigLocalService;
	}

	/**
	 * Sets the server config local service.
	 *
	 * @param serverConfigLocalService the server config local service
	 */
	public void setServerConfigLocalService(
		org.opencps.communication.service.ServerConfigLocalService serverConfigLocalService) {
		this.serverConfigLocalService = serverConfigLocalService;
	}

	/**
	 * Returns the server config persistence.
	 *
	 * @return the server config persistence
	 */
	public ServerConfigPersistence getServerConfigPersistence() {
		return serverConfigPersistence;
	}

	/**
	 * Sets the server config persistence.
	 *
	 * @param serverConfigPersistence the server config persistence
	 */
	public void setServerConfigPersistence(
		ServerConfigPersistence serverConfigPersistence) {
		this.serverConfigPersistence = serverConfigPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("org.opencps.communication.model.Notificationtemplate",
			notificationtemplateLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"org.opencps.communication.model.Notificationtemplate");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return NotificationtemplateLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Notificationtemplate.class;
	}

	protected String getModelClassName() {
		return Notificationtemplate.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = notificationtemplatePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.opencps.communication.service.NotificationQueueLocalService.class)
	protected org.opencps.communication.service.NotificationQueueLocalService notificationQueueLocalService;
	@BeanReference(type = NotificationQueuePersistence.class)
	protected NotificationQueuePersistence notificationQueuePersistence;
	@BeanReference(type = NotificationtemplateLocalService.class)
	protected NotificationtemplateLocalService notificationtemplateLocalService;
	@BeanReference(type = NotificationtemplatePersistence.class)
	protected NotificationtemplatePersistence notificationtemplatePersistence;
	@BeanReference(type = org.opencps.communication.service.ServerConfigLocalService.class)
	protected org.opencps.communication.service.ServerConfigLocalService serverConfigLocalService;
	@BeanReference(type = ServerConfigPersistence.class)
	protected ServerConfigPersistence serverConfigPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}