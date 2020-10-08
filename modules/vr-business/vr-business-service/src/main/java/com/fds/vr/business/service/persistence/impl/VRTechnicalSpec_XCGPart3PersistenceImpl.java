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

package com.fds.vr.business.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.fds.vr.business.exception.NoSuchVRTechnicalSpec_XCGPart3Exception;
import com.fds.vr.business.model.VRTechnicalSpec_XCGPart3;
import com.fds.vr.business.model.impl.VRTechnicalSpec_XCGPart3Impl;
import com.fds.vr.business.model.impl.VRTechnicalSpec_XCGPart3ModelImpl;
import com.fds.vr.business.service.persistence.VRTechnicalSpec_XCGPart3Persistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the vr technical spec_xcg part3 service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LamTV
 * @see VRTechnicalSpec_XCGPart3Persistence
 * @see com.fds.vr.business.service.persistence.VRTechnicalSpec_XCGPart3Util
 * @generated
 */
@ProviderType
public class VRTechnicalSpec_XCGPart3PersistenceImpl extends BasePersistenceImpl<VRTechnicalSpec_XCGPart3>
	implements VRTechnicalSpec_XCGPart3Persistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VRTechnicalSpec_XCGPart3Util} to access the vr technical spec_xcg part3 persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VRTechnicalSpec_XCGPart3Impl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DOSSIERNO =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDossierNo",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERNO =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDossierNo",
			new String[] { String.class.getName(), Long.class.getName() },
			VRTechnicalSpec_XCGPart3ModelImpl.DOSSIERNO_COLUMN_BITMASK |
			VRTechnicalSpec_XCGPart3ModelImpl.MTCORE_COLUMN_BITMASK |
			VRTechnicalSpec_XCGPart3ModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOSSIERNO = new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDossierNo",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the vr technical spec_xcg part3s where dossierNo = &#63; and mtCore = &#63;.
	 *
	 * @param dossierNo the dossier no
	 * @param mtCore the mt core
	 * @return the matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDossierNo(String dossierNo,
		long mtCore) {
		return findByDossierNo(dossierNo, mtCore, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr technical spec_xcg part3s where dossierNo = &#63; and mtCore = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierNo the dossier no
	 * @param mtCore the mt core
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @return the range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDossierNo(String dossierNo,
		long mtCore, int start, int end) {
		return findByDossierNo(dossierNo, mtCore, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where dossierNo = &#63; and mtCore = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierNo the dossier no
	 * @param mtCore the mt core
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDossierNo(String dossierNo,
		long mtCore, int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		return findByDossierNo(dossierNo, mtCore, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where dossierNo = &#63; and mtCore = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierNo the dossier no
	 * @param mtCore the mt core
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDossierNo(String dossierNo,
		long mtCore, int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERNO;
			finderArgs = new Object[] { dossierNo, mtCore };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DOSSIERNO;
			finderArgs = new Object[] {
					dossierNo, mtCore,
					
					start, end, orderByComparator
				};
		}

		List<VRTechnicalSpec_XCGPart3> list = null;

		if (retrieveFromCache) {
			list = (List<VRTechnicalSpec_XCGPart3>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : list) {
					if (!Objects.equals(dossierNo,
								vrTechnicalSpec_XCGPart3.getDossierNo()) ||
							(mtCore != vrTechnicalSpec_XCGPart3.getMtCore())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

			boolean bindDossierNo = false;

			if (dossierNo == null) {
				query.append(_FINDER_COLUMN_DOSSIERNO_DOSSIERNO_1);
			}
			else if (dossierNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOSSIERNO_DOSSIERNO_3);
			}
			else {
				bindDossierNo = true;

				query.append(_FINDER_COLUMN_DOSSIERNO_DOSSIERNO_2);
			}

			query.append(_FINDER_COLUMN_DOSSIERNO_MTCORE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDossierNo) {
					qPos.add(dossierNo);
				}

				qPos.add(mtCore);

				if (!pagination) {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where dossierNo = &#63; and mtCore = &#63;.
	 *
	 * @param dossierNo the dossier no
	 * @param mtCore the mt core
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByDossierNo_First(String dossierNo,
		long mtCore,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByDossierNo_First(dossierNo,
				mtCore, orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierNo=");
		msg.append(dossierNo);

		msg.append(", mtCore=");
		msg.append(mtCore);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where dossierNo = &#63; and mtCore = &#63;.
	 *
	 * @param dossierNo the dossier no
	 * @param mtCore the mt core
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByDossierNo_First(String dossierNo,
		long mtCore,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		List<VRTechnicalSpec_XCGPart3> list = findByDossierNo(dossierNo,
				mtCore, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where dossierNo = &#63; and mtCore = &#63;.
	 *
	 * @param dossierNo the dossier no
	 * @param mtCore the mt core
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByDossierNo_Last(String dossierNo,
		long mtCore,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByDossierNo_Last(dossierNo,
				mtCore, orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierNo=");
		msg.append(dossierNo);

		msg.append(", mtCore=");
		msg.append(mtCore);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where dossierNo = &#63; and mtCore = &#63;.
	 *
	 * @param dossierNo the dossier no
	 * @param mtCore the mt core
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByDossierNo_Last(String dossierNo,
		long mtCore,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		int count = countByDossierNo(dossierNo, mtCore);

		if (count == 0) {
			return null;
		}

		List<VRTechnicalSpec_XCGPart3> list = findByDossierNo(dossierNo,
				mtCore, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr technical spec_xcg part3s before and after the current vr technical spec_xcg part3 in the ordered set where dossierNo = &#63; and mtCore = &#63;.
	 *
	 * @param id the primary key of the current vr technical spec_xcg part3
	 * @param dossierNo the dossier no
	 * @param mtCore the mt core
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a vr technical spec_xcg part3 with the primary key could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3[] findByDossierNo_PrevAndNext(long id,
		String dossierNo, long mtCore,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRTechnicalSpec_XCGPart3[] array = new VRTechnicalSpec_XCGPart3Impl[3];

			array[0] = getByDossierNo_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, dossierNo, mtCore,
					orderByComparator, true);

			array[1] = vrTechnicalSpec_XCGPart3;

			array[2] = getByDossierNo_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, dossierNo, mtCore,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VRTechnicalSpec_XCGPart3 getByDossierNo_PrevAndNext(
		Session session, VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3,
		String dossierNo, long mtCore,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

		boolean bindDossierNo = false;

		if (dossierNo == null) {
			query.append(_FINDER_COLUMN_DOSSIERNO_DOSSIERNO_1);
		}
		else if (dossierNo.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DOSSIERNO_DOSSIERNO_3);
		}
		else {
			bindDossierNo = true;

			query.append(_FINDER_COLUMN_DOSSIERNO_DOSSIERNO_2);
		}

		query.append(_FINDER_COLUMN_DOSSIERNO_MTCORE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDossierNo) {
			qPos.add(dossierNo);
		}

		qPos.add(mtCore);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrTechnicalSpec_XCGPart3);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRTechnicalSpec_XCGPart3> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr technical spec_xcg part3s where dossierNo = &#63; and mtCore = &#63; from the database.
	 *
	 * @param dossierNo the dossier no
	 * @param mtCore the mt core
	 */
	@Override
	public void removeByDossierNo(String dossierNo, long mtCore) {
		for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : findByDossierNo(
				dossierNo, mtCore, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vrTechnicalSpec_XCGPart3);
		}
	}

	/**
	 * Returns the number of vr technical spec_xcg part3s where dossierNo = &#63; and mtCore = &#63;.
	 *
	 * @param dossierNo the dossier no
	 * @param mtCore the mt core
	 * @return the number of matching vr technical spec_xcg part3s
	 */
	@Override
	public int countByDossierNo(String dossierNo, long mtCore) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DOSSIERNO;

		Object[] finderArgs = new Object[] { dossierNo, mtCore };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VRTECHNICALSPEC_XCGPART3_WHERE);

			boolean bindDossierNo = false;

			if (dossierNo == null) {
				query.append(_FINDER_COLUMN_DOSSIERNO_DOSSIERNO_1);
			}
			else if (dossierNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOSSIERNO_DOSSIERNO_3);
			}
			else {
				bindDossierNo = true;

				query.append(_FINDER_COLUMN_DOSSIERNO_DOSSIERNO_2);
			}

			query.append(_FINDER_COLUMN_DOSSIERNO_MTCORE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDossierNo) {
					qPos.add(dossierNo);
				}

				qPos.add(mtCore);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DOSSIERNO_DOSSIERNO_1 = "vrTechnicalSpec_XCGPart3.dossierNo IS NULL AND ";
	private static final String _FINDER_COLUMN_DOSSIERNO_DOSSIERNO_2 = "vrTechnicalSpec_XCGPart3.dossierNo = ? AND ";
	private static final String _FINDER_COLUMN_DOSSIERNO_DOSSIERNO_3 = "(vrTechnicalSpec_XCGPart3.dossierNo IS NULL OR vrTechnicalSpec_XCGPart3.dossierNo = '') AND ";
	private static final String _FINDER_COLUMN_DOSSIERNO_MTCORE_2 = "vrTechnicalSpec_XCGPart3.mtCore = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DOSSIERIDCTN =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDossierIdCTN",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERIDCTN =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDossierIdCTN",
			new String[] { String.class.getName() },
			VRTechnicalSpec_XCGPart3ModelImpl.DOSSIERIDCTN_COLUMN_BITMASK |
			VRTechnicalSpec_XCGPart3ModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOSSIERIDCTN = new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDossierIdCTN",
			new String[] { String.class.getName() });

	/**
	 * Returns all the vr technical spec_xcg part3s where dossierIdCTN = &#63;.
	 *
	 * @param dossierIdCTN the dossier ID ctn
	 * @return the matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDossierIdCTN(
		String dossierIdCTN) {
		return findByDossierIdCTN(dossierIdCTN, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr technical spec_xcg part3s where dossierIdCTN = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierIdCTN the dossier ID ctn
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @return the range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDossierIdCTN(
		String dossierIdCTN, int start, int end) {
		return findByDossierIdCTN(dossierIdCTN, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where dossierIdCTN = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierIdCTN the dossier ID ctn
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDossierIdCTN(
		String dossierIdCTN, int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		return findByDossierIdCTN(dossierIdCTN, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where dossierIdCTN = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierIdCTN the dossier ID ctn
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDossierIdCTN(
		String dossierIdCTN, int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERIDCTN;
			finderArgs = new Object[] { dossierIdCTN };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DOSSIERIDCTN;
			finderArgs = new Object[] {
					dossierIdCTN,
					
					start, end, orderByComparator
				};
		}

		List<VRTechnicalSpec_XCGPart3> list = null;

		if (retrieveFromCache) {
			list = (List<VRTechnicalSpec_XCGPart3>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : list) {
					if (!Objects.equals(dossierIdCTN,
								vrTechnicalSpec_XCGPart3.getDossierIdCTN())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

			boolean bindDossierIdCTN = false;

			if (dossierIdCTN == null) {
				query.append(_FINDER_COLUMN_DOSSIERIDCTN_DOSSIERIDCTN_1);
			}
			else if (dossierIdCTN.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOSSIERIDCTN_DOSSIERIDCTN_3);
			}
			else {
				bindDossierIdCTN = true;

				query.append(_FINDER_COLUMN_DOSSIERIDCTN_DOSSIERIDCTN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDossierIdCTN) {
					qPos.add(dossierIdCTN);
				}

				if (!pagination) {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where dossierIdCTN = &#63;.
	 *
	 * @param dossierIdCTN the dossier ID ctn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByDossierIdCTN_First(
		String dossierIdCTN,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByDossierIdCTN_First(dossierIdCTN,
				orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierIdCTN=");
		msg.append(dossierIdCTN);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where dossierIdCTN = &#63;.
	 *
	 * @param dossierIdCTN the dossier ID ctn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByDossierIdCTN_First(
		String dossierIdCTN,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		List<VRTechnicalSpec_XCGPart3> list = findByDossierIdCTN(dossierIdCTN,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where dossierIdCTN = &#63;.
	 *
	 * @param dossierIdCTN the dossier ID ctn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByDossierIdCTN_Last(
		String dossierIdCTN,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByDossierIdCTN_Last(dossierIdCTN,
				orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierIdCTN=");
		msg.append(dossierIdCTN);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where dossierIdCTN = &#63;.
	 *
	 * @param dossierIdCTN the dossier ID ctn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByDossierIdCTN_Last(
		String dossierIdCTN,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		int count = countByDossierIdCTN(dossierIdCTN);

		if (count == 0) {
			return null;
		}

		List<VRTechnicalSpec_XCGPart3> list = findByDossierIdCTN(dossierIdCTN,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr technical spec_xcg part3s before and after the current vr technical spec_xcg part3 in the ordered set where dossierIdCTN = &#63;.
	 *
	 * @param id the primary key of the current vr technical spec_xcg part3
	 * @param dossierIdCTN the dossier ID ctn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a vr technical spec_xcg part3 with the primary key could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3[] findByDossierIdCTN_PrevAndNext(long id,
		String dossierIdCTN,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRTechnicalSpec_XCGPart3[] array = new VRTechnicalSpec_XCGPart3Impl[3];

			array[0] = getByDossierIdCTN_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, dossierIdCTN, orderByComparator,
					true);

			array[1] = vrTechnicalSpec_XCGPart3;

			array[2] = getByDossierIdCTN_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, dossierIdCTN, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VRTechnicalSpec_XCGPart3 getByDossierIdCTN_PrevAndNext(
		Session session, VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3,
		String dossierIdCTN,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

		boolean bindDossierIdCTN = false;

		if (dossierIdCTN == null) {
			query.append(_FINDER_COLUMN_DOSSIERIDCTN_DOSSIERIDCTN_1);
		}
		else if (dossierIdCTN.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DOSSIERIDCTN_DOSSIERIDCTN_3);
		}
		else {
			bindDossierIdCTN = true;

			query.append(_FINDER_COLUMN_DOSSIERIDCTN_DOSSIERIDCTN_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDossierIdCTN) {
			qPos.add(dossierIdCTN);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrTechnicalSpec_XCGPart3);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRTechnicalSpec_XCGPart3> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr technical spec_xcg part3s where dossierIdCTN = &#63; from the database.
	 *
	 * @param dossierIdCTN the dossier ID ctn
	 */
	@Override
	public void removeByDossierIdCTN(String dossierIdCTN) {
		for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : findByDossierIdCTN(
				dossierIdCTN, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vrTechnicalSpec_XCGPart3);
		}
	}

	/**
	 * Returns the number of vr technical spec_xcg part3s where dossierIdCTN = &#63;.
	 *
	 * @param dossierIdCTN the dossier ID ctn
	 * @return the number of matching vr technical spec_xcg part3s
	 */
	@Override
	public int countByDossierIdCTN(String dossierIdCTN) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DOSSIERIDCTN;

		Object[] finderArgs = new Object[] { dossierIdCTN };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VRTECHNICALSPEC_XCGPART3_WHERE);

			boolean bindDossierIdCTN = false;

			if (dossierIdCTN == null) {
				query.append(_FINDER_COLUMN_DOSSIERIDCTN_DOSSIERIDCTN_1);
			}
			else if (dossierIdCTN.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOSSIERIDCTN_DOSSIERIDCTN_3);
			}
			else {
				bindDossierIdCTN = true;

				query.append(_FINDER_COLUMN_DOSSIERIDCTN_DOSSIERIDCTN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDossierIdCTN) {
					qPos.add(dossierIdCTN);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DOSSIERIDCTN_DOSSIERIDCTN_1 = "vrTechnicalSpec_XCGPart3.dossierIdCTN IS NULL";
	private static final String _FINDER_COLUMN_DOSSIERIDCTN_DOSSIERIDCTN_2 = "vrTechnicalSpec_XCGPart3.dossierIdCTN = ?";
	private static final String _FINDER_COLUMN_DOSSIERIDCTN_DOSSIERIDCTN_3 = "(vrTechnicalSpec_XCGPart3.dossierIdCTN IS NULL OR vrTechnicalSpec_XCGPart3.dossierIdCTN = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DELIVERABLECODE =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDeliverableCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELIVERABLECODE =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDeliverableCode",
			new String[] { String.class.getName() },
			VRTechnicalSpec_XCGPart3ModelImpl.DELIVERABLECODE_COLUMN_BITMASK |
			VRTechnicalSpec_XCGPart3ModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DELIVERABLECODE = new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDeliverableCode", new String[] { String.class.getName() });

	/**
	 * Returns all the vr technical spec_xcg part3s where deliverableCode = &#63;.
	 *
	 * @param deliverableCode the deliverable code
	 * @return the matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDeliverableCode(
		String deliverableCode) {
		return findByDeliverableCode(deliverableCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr technical spec_xcg part3s where deliverableCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deliverableCode the deliverable code
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @return the range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDeliverableCode(
		String deliverableCode, int start, int end) {
		return findByDeliverableCode(deliverableCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where deliverableCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deliverableCode the deliverable code
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDeliverableCode(
		String deliverableCode, int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		return findByDeliverableCode(deliverableCode, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where deliverableCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deliverableCode the deliverable code
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDeliverableCode(
		String deliverableCode, int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELIVERABLECODE;
			finderArgs = new Object[] { deliverableCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DELIVERABLECODE;
			finderArgs = new Object[] {
					deliverableCode,
					
					start, end, orderByComparator
				};
		}

		List<VRTechnicalSpec_XCGPart3> list = null;

		if (retrieveFromCache) {
			list = (List<VRTechnicalSpec_XCGPart3>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : list) {
					if (!Objects.equals(deliverableCode,
								vrTechnicalSpec_XCGPart3.getDeliverableCode())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

			boolean bindDeliverableCode = false;

			if (deliverableCode == null) {
				query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_1);
			}
			else if (deliverableCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_3);
			}
			else {
				bindDeliverableCode = true;

				query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDeliverableCode) {
					qPos.add(deliverableCode);
				}

				if (!pagination) {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where deliverableCode = &#63;.
	 *
	 * @param deliverableCode the deliverable code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByDeliverableCode_First(
		String deliverableCode,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByDeliverableCode_First(deliverableCode,
				orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deliverableCode=");
		msg.append(deliverableCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where deliverableCode = &#63;.
	 *
	 * @param deliverableCode the deliverable code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByDeliverableCode_First(
		String deliverableCode,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		List<VRTechnicalSpec_XCGPart3> list = findByDeliverableCode(deliverableCode,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where deliverableCode = &#63;.
	 *
	 * @param deliverableCode the deliverable code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByDeliverableCode_Last(
		String deliverableCode,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByDeliverableCode_Last(deliverableCode,
				orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deliverableCode=");
		msg.append(deliverableCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where deliverableCode = &#63;.
	 *
	 * @param deliverableCode the deliverable code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByDeliverableCode_Last(
		String deliverableCode,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		int count = countByDeliverableCode(deliverableCode);

		if (count == 0) {
			return null;
		}

		List<VRTechnicalSpec_XCGPart3> list = findByDeliverableCode(deliverableCode,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr technical spec_xcg part3s before and after the current vr technical spec_xcg part3 in the ordered set where deliverableCode = &#63;.
	 *
	 * @param id the primary key of the current vr technical spec_xcg part3
	 * @param deliverableCode the deliverable code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a vr technical spec_xcg part3 with the primary key could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3[] findByDeliverableCode_PrevAndNext(
		long id, String deliverableCode,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRTechnicalSpec_XCGPart3[] array = new VRTechnicalSpec_XCGPart3Impl[3];

			array[0] = getByDeliverableCode_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, deliverableCode,
					orderByComparator, true);

			array[1] = vrTechnicalSpec_XCGPart3;

			array[2] = getByDeliverableCode_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, deliverableCode,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VRTechnicalSpec_XCGPart3 getByDeliverableCode_PrevAndNext(
		Session session, VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3,
		String deliverableCode,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

		boolean bindDeliverableCode = false;

		if (deliverableCode == null) {
			query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_1);
		}
		else if (deliverableCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_3);
		}
		else {
			bindDeliverableCode = true;

			query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDeliverableCode) {
			qPos.add(deliverableCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrTechnicalSpec_XCGPart3);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRTechnicalSpec_XCGPart3> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr technical spec_xcg part3s where deliverableCode = &#63; from the database.
	 *
	 * @param deliverableCode the deliverable code
	 */
	@Override
	public void removeByDeliverableCode(String deliverableCode) {
		for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : findByDeliverableCode(
				deliverableCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vrTechnicalSpec_XCGPart3);
		}
	}

	/**
	 * Returns the number of vr technical spec_xcg part3s where deliverableCode = &#63;.
	 *
	 * @param deliverableCode the deliverable code
	 * @return the number of matching vr technical spec_xcg part3s
	 */
	@Override
	public int countByDeliverableCode(String deliverableCode) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DELIVERABLECODE;

		Object[] finderArgs = new Object[] { deliverableCode };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VRTECHNICALSPEC_XCGPART3_WHERE);

			boolean bindDeliverableCode = false;

			if (deliverableCode == null) {
				query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_1);
			}
			else if (deliverableCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_3);
			}
			else {
				bindDeliverableCode = true;

				query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDeliverableCode) {
					qPos.add(deliverableCode);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_1 =
		"vrTechnicalSpec_XCGPart3.deliverableCode IS NULL";
	private static final String _FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_2 =
		"vrTechnicalSpec_XCGPart3.deliverableCode = ?";
	private static final String _FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_3 =
		"(vrTechnicalSpec_XCGPart3.deliverableCode IS NULL OR vrTechnicalSpec_XCGPart3.deliverableCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DOSSIERID =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDossierId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERID =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDossierId",
			new String[] { Long.class.getName(), Long.class.getName() },
			VRTechnicalSpec_XCGPart3ModelImpl.DOSSIERID_COLUMN_BITMASK |
			VRTechnicalSpec_XCGPart3ModelImpl.MTCORE_COLUMN_BITMASK |
			VRTechnicalSpec_XCGPart3ModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOSSIERID = new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDossierId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the vr technical spec_xcg part3s where dossierId = &#63; and mtCore = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param mtCore the mt core
	 * @return the matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDossierId(long dossierId,
		long mtCore) {
		return findByDossierId(dossierId, mtCore, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr technical spec_xcg part3s where dossierId = &#63; and mtCore = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierId the dossier ID
	 * @param mtCore the mt core
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @return the range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDossierId(long dossierId,
		long mtCore, int start, int end) {
		return findByDossierId(dossierId, mtCore, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where dossierId = &#63; and mtCore = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierId the dossier ID
	 * @param mtCore the mt core
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDossierId(long dossierId,
		long mtCore, int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		return findByDossierId(dossierId, mtCore, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where dossierId = &#63; and mtCore = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierId the dossier ID
	 * @param mtCore the mt core
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByDossierId(long dossierId,
		long mtCore, int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERID;
			finderArgs = new Object[] { dossierId, mtCore };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DOSSIERID;
			finderArgs = new Object[] {
					dossierId, mtCore,
					
					start, end, orderByComparator
				};
		}

		List<VRTechnicalSpec_XCGPart3> list = null;

		if (retrieveFromCache) {
			list = (List<VRTechnicalSpec_XCGPart3>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : list) {
					if ((dossierId != vrTechnicalSpec_XCGPart3.getDossierId()) ||
							(mtCore != vrTechnicalSpec_XCGPart3.getMtCore())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

			query.append(_FINDER_COLUMN_DOSSIERID_DOSSIERID_2);

			query.append(_FINDER_COLUMN_DOSSIERID_MTCORE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierId);

				qPos.add(mtCore);

				if (!pagination) {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where dossierId = &#63; and mtCore = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param mtCore the mt core
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByDossierId_First(long dossierId,
		long mtCore,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByDossierId_First(dossierId,
				mtCore, orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierId=");
		msg.append(dossierId);

		msg.append(", mtCore=");
		msg.append(mtCore);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where dossierId = &#63; and mtCore = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param mtCore the mt core
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByDossierId_First(long dossierId,
		long mtCore,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		List<VRTechnicalSpec_XCGPart3> list = findByDossierId(dossierId,
				mtCore, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where dossierId = &#63; and mtCore = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param mtCore the mt core
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByDossierId_Last(long dossierId,
		long mtCore,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByDossierId_Last(dossierId,
				mtCore, orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierId=");
		msg.append(dossierId);

		msg.append(", mtCore=");
		msg.append(mtCore);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where dossierId = &#63; and mtCore = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param mtCore the mt core
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByDossierId_Last(long dossierId,
		long mtCore,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		int count = countByDossierId(dossierId, mtCore);

		if (count == 0) {
			return null;
		}

		List<VRTechnicalSpec_XCGPart3> list = findByDossierId(dossierId,
				mtCore, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr technical spec_xcg part3s before and after the current vr technical spec_xcg part3 in the ordered set where dossierId = &#63; and mtCore = &#63;.
	 *
	 * @param id the primary key of the current vr technical spec_xcg part3
	 * @param dossierId the dossier ID
	 * @param mtCore the mt core
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a vr technical spec_xcg part3 with the primary key could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3[] findByDossierId_PrevAndNext(long id,
		long dossierId, long mtCore,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRTechnicalSpec_XCGPart3[] array = new VRTechnicalSpec_XCGPart3Impl[3];

			array[0] = getByDossierId_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, dossierId, mtCore,
					orderByComparator, true);

			array[1] = vrTechnicalSpec_XCGPart3;

			array[2] = getByDossierId_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, dossierId, mtCore,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VRTechnicalSpec_XCGPart3 getByDossierId_PrevAndNext(
		Session session, VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3,
		long dossierId, long mtCore,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

		query.append(_FINDER_COLUMN_DOSSIERID_DOSSIERID_2);

		query.append(_FINDER_COLUMN_DOSSIERID_MTCORE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dossierId);

		qPos.add(mtCore);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrTechnicalSpec_XCGPart3);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRTechnicalSpec_XCGPart3> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr technical spec_xcg part3s where dossierId = &#63; and mtCore = &#63; from the database.
	 *
	 * @param dossierId the dossier ID
	 * @param mtCore the mt core
	 */
	@Override
	public void removeByDossierId(long dossierId, long mtCore) {
		for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : findByDossierId(
				dossierId, mtCore, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vrTechnicalSpec_XCGPart3);
		}
	}

	/**
	 * Returns the number of vr technical spec_xcg part3s where dossierId = &#63; and mtCore = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param mtCore the mt core
	 * @return the number of matching vr technical spec_xcg part3s
	 */
	@Override
	public int countByDossierId(long dossierId, long mtCore) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DOSSIERID;

		Object[] finderArgs = new Object[] { dossierId, mtCore };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VRTECHNICALSPEC_XCGPART3_WHERE);

			query.append(_FINDER_COLUMN_DOSSIERID_DOSSIERID_2);

			query.append(_FINDER_COLUMN_DOSSIERID_MTCORE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierId);

				qPos.add(mtCore);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DOSSIERID_DOSSIERID_2 = "vrTechnicalSpec_XCGPart3.dossierId = ? AND ";
	private static final String _FINDER_COLUMN_DOSSIERID_MTCORE_2 = "vrTechnicalSpec_XCGPart3.mtCore = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY__DOSSIERID =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBy_DossierId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY__DOSSIERID =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBy_DossierId",
			new String[] { Long.class.getName() },
			VRTechnicalSpec_XCGPart3ModelImpl.DOSSIERID_COLUMN_BITMASK |
			VRTechnicalSpec_XCGPart3ModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY__DOSSIERID = new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBy_DossierId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the vr technical spec_xcg part3s where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @return the matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findBy_DossierId(long dossierId) {
		return findBy_DossierId(dossierId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr technical spec_xcg part3s where dossierId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierId the dossier ID
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @return the range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findBy_DossierId(long dossierId,
		int start, int end) {
		return findBy_DossierId(dossierId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where dossierId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierId the dossier ID
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findBy_DossierId(long dossierId,
		int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		return findBy_DossierId(dossierId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where dossierId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dossierId the dossier ID
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findBy_DossierId(long dossierId,
		int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY__DOSSIERID;
			finderArgs = new Object[] { dossierId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY__DOSSIERID;
			finderArgs = new Object[] { dossierId, start, end, orderByComparator };
		}

		List<VRTechnicalSpec_XCGPart3> list = null;

		if (retrieveFromCache) {
			list = (List<VRTechnicalSpec_XCGPart3>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : list) {
					if ((dossierId != vrTechnicalSpec_XCGPart3.getDossierId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

			query.append(_FINDER_COLUMN__DOSSIERID_DOSSIERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierId);

				if (!pagination) {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findBy_DossierId_First(long dossierId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchBy_DossierId_First(dossierId,
				orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierId=");
		msg.append(dossierId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchBy_DossierId_First(long dossierId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		List<VRTechnicalSpec_XCGPart3> list = findBy_DossierId(dossierId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findBy_DossierId_Last(long dossierId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchBy_DossierId_Last(dossierId,
				orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dossierId=");
		msg.append(dossierId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchBy_DossierId_Last(long dossierId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		int count = countBy_DossierId(dossierId);

		if (count == 0) {
			return null;
		}

		List<VRTechnicalSpec_XCGPart3> list = findBy_DossierId(dossierId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr technical spec_xcg part3s before and after the current vr technical spec_xcg part3 in the ordered set where dossierId = &#63;.
	 *
	 * @param id the primary key of the current vr technical spec_xcg part3
	 * @param dossierId the dossier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a vr technical spec_xcg part3 with the primary key could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3[] findBy_DossierId_PrevAndNext(long id,
		long dossierId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRTechnicalSpec_XCGPart3[] array = new VRTechnicalSpec_XCGPart3Impl[3];

			array[0] = getBy_DossierId_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, dossierId, orderByComparator, true);

			array[1] = vrTechnicalSpec_XCGPart3;

			array[2] = getBy_DossierId_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, dossierId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VRTechnicalSpec_XCGPart3 getBy_DossierId_PrevAndNext(
		Session session, VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3,
		long dossierId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

		query.append(_FINDER_COLUMN__DOSSIERID_DOSSIERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dossierId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrTechnicalSpec_XCGPart3);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRTechnicalSpec_XCGPart3> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr technical spec_xcg part3s where dossierId = &#63; from the database.
	 *
	 * @param dossierId the dossier ID
	 */
	@Override
	public void removeBy_DossierId(long dossierId) {
		for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : findBy_DossierId(
				dossierId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vrTechnicalSpec_XCGPart3);
		}
	}

	/**
	 * Returns the number of vr technical spec_xcg part3s where dossierId = &#63;.
	 *
	 * @param dossierId the dossier ID
	 * @return the number of matching vr technical spec_xcg part3s
	 */
	@Override
	public int countBy_DossierId(long dossierId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY__DOSSIERID;

		Object[] finderArgs = new Object[] { dossierId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VRTECHNICALSPEC_XCGPART3_WHERE);

			query.append(_FINDER_COLUMN__DOSSIERID_DOSSIERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dossierId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN__DOSSIERID_DOSSIERID_2 = "vrTechnicalSpec_XCGPart3.dossierId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONVERTASSEMBLEID =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConvertAssembleId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONVERTASSEMBLEID =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByConvertAssembleId", new String[] { Long.class.getName() },
			VRTechnicalSpec_XCGPart3ModelImpl.CONVERTASSEMBLEID_COLUMN_BITMASK |
			VRTechnicalSpec_XCGPart3ModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONVERTASSEMBLEID = new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByConvertAssembleId", new String[] { Long.class.getName() });

	/**
	 * Returns all the vr technical spec_xcg part3s where convertAssembleId = &#63;.
	 *
	 * @param convertAssembleId the convert assemble ID
	 * @return the matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByConvertAssembleId(
		long convertAssembleId) {
		return findByConvertAssembleId(convertAssembleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr technical spec_xcg part3s where convertAssembleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param convertAssembleId the convert assemble ID
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @return the range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByConvertAssembleId(
		long convertAssembleId, int start, int end) {
		return findByConvertAssembleId(convertAssembleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where convertAssembleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param convertAssembleId the convert assemble ID
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByConvertAssembleId(
		long convertAssembleId, int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		return findByConvertAssembleId(convertAssembleId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where convertAssembleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param convertAssembleId the convert assemble ID
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByConvertAssembleId(
		long convertAssembleId, int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONVERTASSEMBLEID;
			finderArgs = new Object[] { convertAssembleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONVERTASSEMBLEID;
			finderArgs = new Object[] {
					convertAssembleId,
					
					start, end, orderByComparator
				};
		}

		List<VRTechnicalSpec_XCGPart3> list = null;

		if (retrieveFromCache) {
			list = (List<VRTechnicalSpec_XCGPart3>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : list) {
					if ((convertAssembleId != vrTechnicalSpec_XCGPart3.getConvertAssembleId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

			query.append(_FINDER_COLUMN_CONVERTASSEMBLEID_CONVERTASSEMBLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(convertAssembleId);

				if (!pagination) {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where convertAssembleId = &#63;.
	 *
	 * @param convertAssembleId the convert assemble ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByConvertAssembleId_First(
		long convertAssembleId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByConvertAssembleId_First(convertAssembleId,
				orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("convertAssembleId=");
		msg.append(convertAssembleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where convertAssembleId = &#63;.
	 *
	 * @param convertAssembleId the convert assemble ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByConvertAssembleId_First(
		long convertAssembleId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		List<VRTechnicalSpec_XCGPart3> list = findByConvertAssembleId(convertAssembleId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where convertAssembleId = &#63;.
	 *
	 * @param convertAssembleId the convert assemble ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByConvertAssembleId_Last(
		long convertAssembleId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByConvertAssembleId_Last(convertAssembleId,
				orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("convertAssembleId=");
		msg.append(convertAssembleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where convertAssembleId = &#63;.
	 *
	 * @param convertAssembleId the convert assemble ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByConvertAssembleId_Last(
		long convertAssembleId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		int count = countByConvertAssembleId(convertAssembleId);

		if (count == 0) {
			return null;
		}

		List<VRTechnicalSpec_XCGPart3> list = findByConvertAssembleId(convertAssembleId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr technical spec_xcg part3s before and after the current vr technical spec_xcg part3 in the ordered set where convertAssembleId = &#63;.
	 *
	 * @param id the primary key of the current vr technical spec_xcg part3
	 * @param convertAssembleId the convert assemble ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a vr technical spec_xcg part3 with the primary key could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3[] findByConvertAssembleId_PrevAndNext(
		long id, long convertAssembleId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRTechnicalSpec_XCGPart3[] array = new VRTechnicalSpec_XCGPart3Impl[3];

			array[0] = getByConvertAssembleId_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, convertAssembleId,
					orderByComparator, true);

			array[1] = vrTechnicalSpec_XCGPart3;

			array[2] = getByConvertAssembleId_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, convertAssembleId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VRTechnicalSpec_XCGPart3 getByConvertAssembleId_PrevAndNext(
		Session session, VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3,
		long convertAssembleId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

		query.append(_FINDER_COLUMN_CONVERTASSEMBLEID_CONVERTASSEMBLEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(convertAssembleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrTechnicalSpec_XCGPart3);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRTechnicalSpec_XCGPart3> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr technical spec_xcg part3s where convertAssembleId = &#63; from the database.
	 *
	 * @param convertAssembleId the convert assemble ID
	 */
	@Override
	public void removeByConvertAssembleId(long convertAssembleId) {
		for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : findByConvertAssembleId(
				convertAssembleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vrTechnicalSpec_XCGPart3);
		}
	}

	/**
	 * Returns the number of vr technical spec_xcg part3s where convertAssembleId = &#63;.
	 *
	 * @param convertAssembleId the convert assemble ID
	 * @return the number of matching vr technical spec_xcg part3s
	 */
	@Override
	public int countByConvertAssembleId(long convertAssembleId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONVERTASSEMBLEID;

		Object[] finderArgs = new Object[] { convertAssembleId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VRTECHNICALSPEC_XCGPART3_WHERE);

			query.append(_FINDER_COLUMN_CONVERTASSEMBLEID_CONVERTASSEMBLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(convertAssembleId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONVERTASSEMBLEID_CONVERTASSEMBLEID_2 =
		"vrTechnicalSpec_XCGPart3.convertAssembleId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REFERENCEUID =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReferenceUid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFERENCEUID =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReferenceUid",
			new String[] { String.class.getName() },
			VRTechnicalSpec_XCGPart3ModelImpl.REFERENCEUID_COLUMN_BITMASK |
			VRTechnicalSpec_XCGPart3ModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REFERENCEUID = new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReferenceUid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the vr technical spec_xcg part3s where referenceUid = &#63;.
	 *
	 * @param referenceUid the reference uid
	 * @return the matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByReferenceUid(
		String referenceUid) {
		return findByReferenceUid(referenceUid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr technical spec_xcg part3s where referenceUid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param referenceUid the reference uid
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @return the range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByReferenceUid(
		String referenceUid, int start, int end) {
		return findByReferenceUid(referenceUid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where referenceUid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param referenceUid the reference uid
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByReferenceUid(
		String referenceUid, int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		return findByReferenceUid(referenceUid, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where referenceUid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param referenceUid the reference uid
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByReferenceUid(
		String referenceUid, int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFERENCEUID;
			finderArgs = new Object[] { referenceUid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REFERENCEUID;
			finderArgs = new Object[] {
					referenceUid,
					
					start, end, orderByComparator
				};
		}

		List<VRTechnicalSpec_XCGPart3> list = null;

		if (retrieveFromCache) {
			list = (List<VRTechnicalSpec_XCGPart3>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : list) {
					if (!Objects.equals(referenceUid,
								vrTechnicalSpec_XCGPart3.getReferenceUid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

			boolean bindReferenceUid = false;

			if (referenceUid == null) {
				query.append(_FINDER_COLUMN_REFERENCEUID_REFERENCEUID_1);
			}
			else if (referenceUid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REFERENCEUID_REFERENCEUID_3);
			}
			else {
				bindReferenceUid = true;

				query.append(_FINDER_COLUMN_REFERENCEUID_REFERENCEUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReferenceUid) {
					qPos.add(referenceUid);
				}

				if (!pagination) {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where referenceUid = &#63;.
	 *
	 * @param referenceUid the reference uid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByReferenceUid_First(
		String referenceUid,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByReferenceUid_First(referenceUid,
				orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("referenceUid=");
		msg.append(referenceUid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where referenceUid = &#63;.
	 *
	 * @param referenceUid the reference uid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByReferenceUid_First(
		String referenceUid,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		List<VRTechnicalSpec_XCGPart3> list = findByReferenceUid(referenceUid,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where referenceUid = &#63;.
	 *
	 * @param referenceUid the reference uid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByReferenceUid_Last(
		String referenceUid,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByReferenceUid_Last(referenceUid,
				orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("referenceUid=");
		msg.append(referenceUid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where referenceUid = &#63;.
	 *
	 * @param referenceUid the reference uid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByReferenceUid_Last(
		String referenceUid,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		int count = countByReferenceUid(referenceUid);

		if (count == 0) {
			return null;
		}

		List<VRTechnicalSpec_XCGPart3> list = findByReferenceUid(referenceUid,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr technical spec_xcg part3s before and after the current vr technical spec_xcg part3 in the ordered set where referenceUid = &#63;.
	 *
	 * @param id the primary key of the current vr technical spec_xcg part3
	 * @param referenceUid the reference uid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a vr technical spec_xcg part3 with the primary key could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3[] findByReferenceUid_PrevAndNext(long id,
		String referenceUid,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRTechnicalSpec_XCGPart3[] array = new VRTechnicalSpec_XCGPart3Impl[3];

			array[0] = getByReferenceUid_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, referenceUid, orderByComparator,
					true);

			array[1] = vrTechnicalSpec_XCGPart3;

			array[2] = getByReferenceUid_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, referenceUid, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VRTechnicalSpec_XCGPart3 getByReferenceUid_PrevAndNext(
		Session session, VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3,
		String referenceUid,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

		boolean bindReferenceUid = false;

		if (referenceUid == null) {
			query.append(_FINDER_COLUMN_REFERENCEUID_REFERENCEUID_1);
		}
		else if (referenceUid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_REFERENCEUID_REFERENCEUID_3);
		}
		else {
			bindReferenceUid = true;

			query.append(_FINDER_COLUMN_REFERENCEUID_REFERENCEUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindReferenceUid) {
			qPos.add(referenceUid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrTechnicalSpec_XCGPart3);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRTechnicalSpec_XCGPart3> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr technical spec_xcg part3s where referenceUid = &#63; from the database.
	 *
	 * @param referenceUid the reference uid
	 */
	@Override
	public void removeByReferenceUid(String referenceUid) {
		for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : findByReferenceUid(
				referenceUid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vrTechnicalSpec_XCGPart3);
		}
	}

	/**
	 * Returns the number of vr technical spec_xcg part3s where referenceUid = &#63;.
	 *
	 * @param referenceUid the reference uid
	 * @return the number of matching vr technical spec_xcg part3s
	 */
	@Override
	public int countByReferenceUid(String referenceUid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REFERENCEUID;

		Object[] finderArgs = new Object[] { referenceUid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VRTECHNICALSPEC_XCGPART3_WHERE);

			boolean bindReferenceUid = false;

			if (referenceUid == null) {
				query.append(_FINDER_COLUMN_REFERENCEUID_REFERENCEUID_1);
			}
			else if (referenceUid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REFERENCEUID_REFERENCEUID_3);
			}
			else {
				bindReferenceUid = true;

				query.append(_FINDER_COLUMN_REFERENCEUID_REFERENCEUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReferenceUid) {
					qPos.add(referenceUid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_REFERENCEUID_REFERENCEUID_1 = "vrTechnicalSpec_XCGPart3.referenceUid IS NULL";
	private static final String _FINDER_COLUMN_REFERENCEUID_REFERENCEUID_2 = "vrTechnicalSpec_XCGPart3.referenceUid = ?";
	private static final String _FINDER_COLUMN_REFERENCEUID_REFERENCEUID_3 = "(vrTechnicalSpec_XCGPart3.referenceUid IS NULL OR vrTechnicalSpec_XCGPart3.referenceUid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VEHICLETYPECERTIFICATEID =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByvehicleTypeCertificateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VEHICLETYPECERTIFICATEID =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByvehicleTypeCertificateId",
			new String[] { Long.class.getName() },
			VRTechnicalSpec_XCGPart3ModelImpl.VEHICLETYPECERTIFICATEID_COLUMN_BITMASK |
			VRTechnicalSpec_XCGPart3ModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VEHICLETYPECERTIFICATEID =
		new FinderPath(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3ModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByvehicleTypeCertificateId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the vr technical spec_xcg part3s where vehicleTypeCertificateId = &#63;.
	 *
	 * @param vehicleTypeCertificateId the vehicle type certificate ID
	 * @return the matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByvehicleTypeCertificateId(
		long vehicleTypeCertificateId) {
		return findByvehicleTypeCertificateId(vehicleTypeCertificateId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr technical spec_xcg part3s where vehicleTypeCertificateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehicleTypeCertificateId the vehicle type certificate ID
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @return the range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByvehicleTypeCertificateId(
		long vehicleTypeCertificateId, int start, int end) {
		return findByvehicleTypeCertificateId(vehicleTypeCertificateId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where vehicleTypeCertificateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehicleTypeCertificateId the vehicle type certificate ID
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByvehicleTypeCertificateId(
		long vehicleTypeCertificateId, int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		return findByvehicleTypeCertificateId(vehicleTypeCertificateId, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s where vehicleTypeCertificateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehicleTypeCertificateId the vehicle type certificate ID
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findByvehicleTypeCertificateId(
		long vehicleTypeCertificateId, int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VEHICLETYPECERTIFICATEID;
			finderArgs = new Object[] { vehicleTypeCertificateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VEHICLETYPECERTIFICATEID;
			finderArgs = new Object[] {
					vehicleTypeCertificateId,
					
					start, end, orderByComparator
				};
		}

		List<VRTechnicalSpec_XCGPart3> list = null;

		if (retrieveFromCache) {
			list = (List<VRTechnicalSpec_XCGPart3>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : list) {
					if ((vehicleTypeCertificateId != vrTechnicalSpec_XCGPart3.getVehicleTypeCertificateId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

			query.append(_FINDER_COLUMN_VEHICLETYPECERTIFICATEID_VEHICLETYPECERTIFICATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vehicleTypeCertificateId);

				if (!pagination) {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where vehicleTypeCertificateId = &#63;.
	 *
	 * @param vehicleTypeCertificateId the vehicle type certificate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByvehicleTypeCertificateId_First(
		long vehicleTypeCertificateId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByvehicleTypeCertificateId_First(vehicleTypeCertificateId,
				orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vehicleTypeCertificateId=");
		msg.append(vehicleTypeCertificateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the first vr technical spec_xcg part3 in the ordered set where vehicleTypeCertificateId = &#63;.
	 *
	 * @param vehicleTypeCertificateId the vehicle type certificate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByvehicleTypeCertificateId_First(
		long vehicleTypeCertificateId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		List<VRTechnicalSpec_XCGPart3> list = findByvehicleTypeCertificateId(vehicleTypeCertificateId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where vehicleTypeCertificateId = &#63;.
	 *
	 * @param vehicleTypeCertificateId the vehicle type certificate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByvehicleTypeCertificateId_Last(
		long vehicleTypeCertificateId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByvehicleTypeCertificateId_Last(vehicleTypeCertificateId,
				orderByComparator);

		if (vrTechnicalSpec_XCGPart3 != null) {
			return vrTechnicalSpec_XCGPart3;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vehicleTypeCertificateId=");
		msg.append(vehicleTypeCertificateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRTechnicalSpec_XCGPart3Exception(msg.toString());
	}

	/**
	 * Returns the last vr technical spec_xcg part3 in the ordered set where vehicleTypeCertificateId = &#63;.
	 *
	 * @param vehicleTypeCertificateId the vehicle type certificate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr technical spec_xcg part3, or <code>null</code> if a matching vr technical spec_xcg part3 could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByvehicleTypeCertificateId_Last(
		long vehicleTypeCertificateId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		int count = countByvehicleTypeCertificateId(vehicleTypeCertificateId);

		if (count == 0) {
			return null;
		}

		List<VRTechnicalSpec_XCGPart3> list = findByvehicleTypeCertificateId(vehicleTypeCertificateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr technical spec_xcg part3s before and after the current vr technical spec_xcg part3 in the ordered set where vehicleTypeCertificateId = &#63;.
	 *
	 * @param id the primary key of the current vr technical spec_xcg part3
	 * @param vehicleTypeCertificateId the vehicle type certificate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a vr technical spec_xcg part3 with the primary key could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3[] findByvehicleTypeCertificateId_PrevAndNext(
		long id, long vehicleTypeCertificateId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRTechnicalSpec_XCGPart3[] array = new VRTechnicalSpec_XCGPart3Impl[3];

			array[0] = getByvehicleTypeCertificateId_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, vehicleTypeCertificateId,
					orderByComparator, true);

			array[1] = vrTechnicalSpec_XCGPart3;

			array[2] = getByvehicleTypeCertificateId_PrevAndNext(session,
					vrTechnicalSpec_XCGPart3, vehicleTypeCertificateId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VRTechnicalSpec_XCGPart3 getByvehicleTypeCertificateId_PrevAndNext(
		Session session, VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3,
		long vehicleTypeCertificateId,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE);

		query.append(_FINDER_COLUMN_VEHICLETYPECERTIFICATEID_VEHICLETYPECERTIFICATEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(vehicleTypeCertificateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrTechnicalSpec_XCGPart3);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRTechnicalSpec_XCGPart3> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr technical spec_xcg part3s where vehicleTypeCertificateId = &#63; from the database.
	 *
	 * @param vehicleTypeCertificateId the vehicle type certificate ID
	 */
	@Override
	public void removeByvehicleTypeCertificateId(long vehicleTypeCertificateId) {
		for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : findByvehicleTypeCertificateId(
				vehicleTypeCertificateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(vrTechnicalSpec_XCGPart3);
		}
	}

	/**
	 * Returns the number of vr technical spec_xcg part3s where vehicleTypeCertificateId = &#63;.
	 *
	 * @param vehicleTypeCertificateId the vehicle type certificate ID
	 * @return the number of matching vr technical spec_xcg part3s
	 */
	@Override
	public int countByvehicleTypeCertificateId(long vehicleTypeCertificateId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VEHICLETYPECERTIFICATEID;

		Object[] finderArgs = new Object[] { vehicleTypeCertificateId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VRTECHNICALSPEC_XCGPART3_WHERE);

			query.append(_FINDER_COLUMN_VEHICLETYPECERTIFICATEID_VEHICLETYPECERTIFICATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vehicleTypeCertificateId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_VEHICLETYPECERTIFICATEID_VEHICLETYPECERTIFICATEID_2 =
		"vrTechnicalSpec_XCGPart3.vehicleTypeCertificateId = ?";

	public VRTechnicalSpec_XCGPart3PersistenceImpl() {
		setModelClass(VRTechnicalSpec_XCGPart3.class);
	}

	/**
	 * Caches the vr technical spec_xcg part3 in the entity cache if it is enabled.
	 *
	 * @param vrTechnicalSpec_XCGPart3 the vr technical spec_xcg part3
	 */
	@Override
	public void cacheResult(VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3) {
		entityCache.putResult(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			vrTechnicalSpec_XCGPart3.getPrimaryKey(), vrTechnicalSpec_XCGPart3);

		vrTechnicalSpec_XCGPart3.resetOriginalValues();
	}

	/**
	 * Caches the vr technical spec_xcg part3s in the entity cache if it is enabled.
	 *
	 * @param vrTechnicalSpec_XCGPart3s the vr technical spec_xcg part3s
	 */
	@Override
	public void cacheResult(
		List<VRTechnicalSpec_XCGPart3> vrTechnicalSpec_XCGPart3s) {
		for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : vrTechnicalSpec_XCGPart3s) {
			if (entityCache.getResult(
						VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
						VRTechnicalSpec_XCGPart3Impl.class,
						vrTechnicalSpec_XCGPart3.getPrimaryKey()) == null) {
				cacheResult(vrTechnicalSpec_XCGPart3);
			}
			else {
				vrTechnicalSpec_XCGPart3.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vr technical spec_xcg part3s.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VRTechnicalSpec_XCGPart3Impl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vr technical spec_xcg part3.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3) {
		entityCache.removeResult(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			vrTechnicalSpec_XCGPart3.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<VRTechnicalSpec_XCGPart3> vrTechnicalSpec_XCGPart3s) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : vrTechnicalSpec_XCGPart3s) {
			entityCache.removeResult(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
				VRTechnicalSpec_XCGPart3Impl.class,
				vrTechnicalSpec_XCGPart3.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vr technical spec_xcg part3 with the primary key. Does not add the vr technical spec_xcg part3 to the database.
	 *
	 * @param id the primary key for the new vr technical spec_xcg part3
	 * @return the new vr technical spec_xcg part3
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 create(long id) {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = new VRTechnicalSpec_XCGPart3Impl();

		vrTechnicalSpec_XCGPart3.setNew(true);
		vrTechnicalSpec_XCGPart3.setPrimaryKey(id);

		return vrTechnicalSpec_XCGPart3;
	}

	/**
	 * Removes the vr technical spec_xcg part3 with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vr technical spec_xcg part3
	 * @return the vr technical spec_xcg part3 that was removed
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a vr technical spec_xcg part3 with the primary key could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 remove(long id)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		return remove((Serializable)id);
	}

	/**
	 * Removes the vr technical spec_xcg part3 with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vr technical spec_xcg part3
	 * @return the vr technical spec_xcg part3 that was removed
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a vr technical spec_xcg part3 with the primary key could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 remove(Serializable primaryKey)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		Session session = null;

		try {
			session = openSession();

			VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = (VRTechnicalSpec_XCGPart3)session.get(VRTechnicalSpec_XCGPart3Impl.class,
					primaryKey);

			if (vrTechnicalSpec_XCGPart3 == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVRTechnicalSpec_XCGPart3Exception(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vrTechnicalSpec_XCGPart3);
		}
		catch (NoSuchVRTechnicalSpec_XCGPart3Exception nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected VRTechnicalSpec_XCGPart3 removeImpl(
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3) {
		vrTechnicalSpec_XCGPart3 = toUnwrappedModel(vrTechnicalSpec_XCGPart3);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vrTechnicalSpec_XCGPart3)) {
				vrTechnicalSpec_XCGPart3 = (VRTechnicalSpec_XCGPart3)session.get(VRTechnicalSpec_XCGPart3Impl.class,
						vrTechnicalSpec_XCGPart3.getPrimaryKeyObj());
			}

			if (vrTechnicalSpec_XCGPart3 != null) {
				session.delete(vrTechnicalSpec_XCGPart3);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vrTechnicalSpec_XCGPart3 != null) {
			clearCache(vrTechnicalSpec_XCGPart3);
		}

		return vrTechnicalSpec_XCGPart3;
	}

	@Override
	public VRTechnicalSpec_XCGPart3 updateImpl(
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3) {
		vrTechnicalSpec_XCGPart3 = toUnwrappedModel(vrTechnicalSpec_XCGPart3);

		boolean isNew = vrTechnicalSpec_XCGPart3.isNew();

		VRTechnicalSpec_XCGPart3ModelImpl vrTechnicalSpec_XCGPart3ModelImpl = (VRTechnicalSpec_XCGPart3ModelImpl)vrTechnicalSpec_XCGPart3;

		Session session = null;

		try {
			session = openSession();

			if (vrTechnicalSpec_XCGPart3.isNew()) {
				session.save(vrTechnicalSpec_XCGPart3);

				vrTechnicalSpec_XCGPart3.setNew(false);
			}
			else {
				vrTechnicalSpec_XCGPart3 = (VRTechnicalSpec_XCGPart3)session.merge(vrTechnicalSpec_XCGPart3);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VRTechnicalSpec_XCGPart3ModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vrTechnicalSpec_XCGPart3ModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getOriginalDossierNo(),
						vrTechnicalSpec_XCGPart3ModelImpl.getOriginalMtCore()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DOSSIERNO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERNO,
					args);

				args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getDossierNo(),
						vrTechnicalSpec_XCGPart3ModelImpl.getMtCore()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DOSSIERNO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERNO,
					args);
			}

			if ((vrTechnicalSpec_XCGPart3ModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERIDCTN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getOriginalDossierIdCTN()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DOSSIERIDCTN, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERIDCTN,
					args);

				args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getDossierIdCTN()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DOSSIERIDCTN, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERIDCTN,
					args);
			}

			if ((vrTechnicalSpec_XCGPart3ModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELIVERABLECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getOriginalDeliverableCode()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DELIVERABLECODE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELIVERABLECODE,
					args);

				args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getDeliverableCode()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DELIVERABLECODE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELIVERABLECODE,
					args);
			}

			if ((vrTechnicalSpec_XCGPart3ModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getOriginalDossierId(),
						vrTechnicalSpec_XCGPart3ModelImpl.getOriginalMtCore()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DOSSIERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERID,
					args);

				args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getDossierId(),
						vrTechnicalSpec_XCGPart3ModelImpl.getMtCore()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DOSSIERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOSSIERID,
					args);
			}

			if ((vrTechnicalSpec_XCGPart3ModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY__DOSSIERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getOriginalDossierId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY__DOSSIERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY__DOSSIERID,
					args);

				args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getDossierId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY__DOSSIERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY__DOSSIERID,
					args);
			}

			if ((vrTechnicalSpec_XCGPart3ModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONVERTASSEMBLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getOriginalConvertAssembleId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CONVERTASSEMBLEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONVERTASSEMBLEID,
					args);

				args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getConvertAssembleId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CONVERTASSEMBLEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONVERTASSEMBLEID,
					args);
			}

			if ((vrTechnicalSpec_XCGPart3ModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFERENCEUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getOriginalReferenceUid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REFERENCEUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFERENCEUID,
					args);

				args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getReferenceUid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REFERENCEUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REFERENCEUID,
					args);
			}

			if ((vrTechnicalSpec_XCGPart3ModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VEHICLETYPECERTIFICATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getOriginalVehicleTypeCertificateId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VEHICLETYPECERTIFICATEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VEHICLETYPECERTIFICATEID,
					args);

				args = new Object[] {
						vrTechnicalSpec_XCGPart3ModelImpl.getVehicleTypeCertificateId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VEHICLETYPECERTIFICATEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VEHICLETYPECERTIFICATEID,
					args);
			}
		}

		entityCache.putResult(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
			VRTechnicalSpec_XCGPart3Impl.class,
			vrTechnicalSpec_XCGPart3.getPrimaryKey(), vrTechnicalSpec_XCGPart3,
			false);

		vrTechnicalSpec_XCGPart3.resetOriginalValues();

		return vrTechnicalSpec_XCGPart3;
	}

	protected VRTechnicalSpec_XCGPart3 toUnwrappedModel(
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3) {
		if (vrTechnicalSpec_XCGPart3 instanceof VRTechnicalSpec_XCGPart3Impl) {
			return vrTechnicalSpec_XCGPart3;
		}

		VRTechnicalSpec_XCGPart3Impl vrTechnicalSpec_XCGPart3Impl = new VRTechnicalSpec_XCGPart3Impl();

		vrTechnicalSpec_XCGPart3Impl.setNew(vrTechnicalSpec_XCGPart3.isNew());
		vrTechnicalSpec_XCGPart3Impl.setPrimaryKey(vrTechnicalSpec_XCGPart3.getPrimaryKey());

		vrTechnicalSpec_XCGPart3Impl.setId(vrTechnicalSpec_XCGPart3.getId());
		vrTechnicalSpec_XCGPart3Impl.setMtCore(vrTechnicalSpec_XCGPart3.getMtCore());
		vrTechnicalSpec_XCGPart3Impl.setConvertAssembleId(vrTechnicalSpec_XCGPart3.getConvertAssembleId());
		vrTechnicalSpec_XCGPart3Impl.setDossierId(vrTechnicalSpec_XCGPart3.getDossierId());
		vrTechnicalSpec_XCGPart3Impl.setDossierNo(vrTechnicalSpec_XCGPart3.getDossierNo());
		vrTechnicalSpec_XCGPart3Impl.setReferenceUid(vrTechnicalSpec_XCGPart3.getReferenceUid());
		vrTechnicalSpec_XCGPart3Impl.setDossierIdCTN(vrTechnicalSpec_XCGPart3.getDossierIdCTN());
		vrTechnicalSpec_XCGPart3Impl.setDeliverableCode(vrTechnicalSpec_XCGPart3.getDeliverableCode());
		vrTechnicalSpec_XCGPart3Impl.setVehicleTypeCertificateId(vrTechnicalSpec_XCGPart3.getVehicleTypeCertificateId());
		vrTechnicalSpec_XCGPart3Impl.setXCG01310(vrTechnicalSpec_XCGPart3.getXCG01310());
		vrTechnicalSpec_XCGPart3Impl.setXCG01311(vrTechnicalSpec_XCGPart3.getXCG01311());
		vrTechnicalSpec_XCGPart3Impl.setXCG01312(vrTechnicalSpec_XCGPart3.getXCG01312());
		vrTechnicalSpec_XCGPart3Impl.setXCG01313(vrTechnicalSpec_XCGPart3.getXCG01313());
		vrTechnicalSpec_XCGPart3Impl.setXCG01314(vrTechnicalSpec_XCGPart3.getXCG01314());
		vrTechnicalSpec_XCGPart3Impl.setXCG01315(vrTechnicalSpec_XCGPart3.getXCG01315());
		vrTechnicalSpec_XCGPart3Impl.setXCG01316(vrTechnicalSpec_XCGPart3.getXCG01316());
		vrTechnicalSpec_XCGPart3Impl.setXCG01317(vrTechnicalSpec_XCGPart3.getXCG01317());
		vrTechnicalSpec_XCGPart3Impl.setXCG01318(vrTechnicalSpec_XCGPart3.getXCG01318());
		vrTechnicalSpec_XCGPart3Impl.setXCG01319(vrTechnicalSpec_XCGPart3.getXCG01319());
		vrTechnicalSpec_XCGPart3Impl.setXCG01320(vrTechnicalSpec_XCGPart3.getXCG01320());
		vrTechnicalSpec_XCGPart3Impl.setXCG01321(vrTechnicalSpec_XCGPart3.getXCG01321());
		vrTechnicalSpec_XCGPart3Impl.setXCG01322(vrTechnicalSpec_XCGPart3.getXCG01322());
		vrTechnicalSpec_XCGPart3Impl.setXCG01323(vrTechnicalSpec_XCGPart3.getXCG01323());
		vrTechnicalSpec_XCGPart3Impl.setXCG01324(vrTechnicalSpec_XCGPart3.getXCG01324());
		vrTechnicalSpec_XCGPart3Impl.setXCG01325(vrTechnicalSpec_XCGPart3.getXCG01325());
		vrTechnicalSpec_XCGPart3Impl.setXCG01326(vrTechnicalSpec_XCGPart3.getXCG01326());
		vrTechnicalSpec_XCGPart3Impl.setXCG01327(vrTechnicalSpec_XCGPart3.getXCG01327());
		vrTechnicalSpec_XCGPart3Impl.setXCG01328(vrTechnicalSpec_XCGPart3.getXCG01328());
		vrTechnicalSpec_XCGPart3Impl.setXCG01330(vrTechnicalSpec_XCGPart3.getXCG01330());
		vrTechnicalSpec_XCGPart3Impl.setXCG01331(vrTechnicalSpec_XCGPart3.getXCG01331());
		vrTechnicalSpec_XCGPart3Impl.setXCG01332(vrTechnicalSpec_XCGPart3.getXCG01332());
		vrTechnicalSpec_XCGPart3Impl.setXCG01333(vrTechnicalSpec_XCGPart3.getXCG01333());
		vrTechnicalSpec_XCGPart3Impl.setXCG01334(vrTechnicalSpec_XCGPart3.getXCG01334());
		vrTechnicalSpec_XCGPart3Impl.setXCG01335(vrTechnicalSpec_XCGPart3.getXCG01335());
		vrTechnicalSpec_XCGPart3Impl.setXCG01336(vrTechnicalSpec_XCGPart3.getXCG01336());
		vrTechnicalSpec_XCGPart3Impl.setXCG01337(vrTechnicalSpec_XCGPart3.getXCG01337());
		vrTechnicalSpec_XCGPart3Impl.setXCG01338(vrTechnicalSpec_XCGPart3.getXCG01338());
		vrTechnicalSpec_XCGPart3Impl.setXCG01339(vrTechnicalSpec_XCGPart3.getXCG01339());
		vrTechnicalSpec_XCGPart3Impl.setXCG01340(vrTechnicalSpec_XCGPart3.getXCG01340());
		vrTechnicalSpec_XCGPart3Impl.setXCG01341(vrTechnicalSpec_XCGPart3.getXCG01341());
		vrTechnicalSpec_XCGPart3Impl.setXCG01342(vrTechnicalSpec_XCGPart3.getXCG01342());
		vrTechnicalSpec_XCGPart3Impl.setXCG01343(vrTechnicalSpec_XCGPart3.getXCG01343());
		vrTechnicalSpec_XCGPart3Impl.setXCG01344(vrTechnicalSpec_XCGPart3.getXCG01344());
		vrTechnicalSpec_XCGPart3Impl.setXCG01345(vrTechnicalSpec_XCGPart3.getXCG01345());
		vrTechnicalSpec_XCGPart3Impl.setXCG01346(vrTechnicalSpec_XCGPart3.getXCG01346());
		vrTechnicalSpec_XCGPart3Impl.setXCG01347(vrTechnicalSpec_XCGPart3.getXCG01347());
		vrTechnicalSpec_XCGPart3Impl.setXCG01348(vrTechnicalSpec_XCGPart3.getXCG01348());
		vrTechnicalSpec_XCGPart3Impl.setXCG01349(vrTechnicalSpec_XCGPart3.getXCG01349());
		vrTechnicalSpec_XCGPart3Impl.setXCG01350(vrTechnicalSpec_XCGPart3.getXCG01350());
		vrTechnicalSpec_XCGPart3Impl.setXCG01351(vrTechnicalSpec_XCGPart3.getXCG01351());
		vrTechnicalSpec_XCGPart3Impl.setXCG01352(vrTechnicalSpec_XCGPart3.getXCG01352());
		vrTechnicalSpec_XCGPart3Impl.setXCG01353(vrTechnicalSpec_XCGPart3.getXCG01353());
		vrTechnicalSpec_XCGPart3Impl.setXCG01354(vrTechnicalSpec_XCGPart3.getXCG01354());
		vrTechnicalSpec_XCGPart3Impl.setXCG01355(vrTechnicalSpec_XCGPart3.getXCG01355());
		vrTechnicalSpec_XCGPart3Impl.setXCG01356(vrTechnicalSpec_XCGPart3.getXCG01356());
		vrTechnicalSpec_XCGPart3Impl.setXCG01357(vrTechnicalSpec_XCGPart3.getXCG01357());
		vrTechnicalSpec_XCGPart3Impl.setXCG01358(vrTechnicalSpec_XCGPart3.getXCG01358());
		vrTechnicalSpec_XCGPart3Impl.setXCG01359(vrTechnicalSpec_XCGPart3.getXCG01359());
		vrTechnicalSpec_XCGPart3Impl.setXCG01360(vrTechnicalSpec_XCGPart3.getXCG01360());
		vrTechnicalSpec_XCGPart3Impl.setXCG01361(vrTechnicalSpec_XCGPart3.getXCG01361());
		vrTechnicalSpec_XCGPart3Impl.setXCG01362(vrTechnicalSpec_XCGPart3.getXCG01362());
		vrTechnicalSpec_XCGPart3Impl.setXCG01363(vrTechnicalSpec_XCGPart3.getXCG01363());
		vrTechnicalSpec_XCGPart3Impl.setXCG01364(vrTechnicalSpec_XCGPart3.getXCG01364());
		vrTechnicalSpec_XCGPart3Impl.setXCG01365(vrTechnicalSpec_XCGPart3.getXCG01365());
		vrTechnicalSpec_XCGPart3Impl.setXCG01366(vrTechnicalSpec_XCGPart3.getXCG01366());
		vrTechnicalSpec_XCGPart3Impl.setXCG01367(vrTechnicalSpec_XCGPart3.getXCG01367());
		vrTechnicalSpec_XCGPart3Impl.setXCG01368(vrTechnicalSpec_XCGPart3.getXCG01368());
		vrTechnicalSpec_XCGPart3Impl.setXCG01369(vrTechnicalSpec_XCGPart3.getXCG01369());
		vrTechnicalSpec_XCGPart3Impl.setXCG01370(vrTechnicalSpec_XCGPart3.getXCG01370());
		vrTechnicalSpec_XCGPart3Impl.setXCG01371(vrTechnicalSpec_XCGPart3.getXCG01371());
		vrTechnicalSpec_XCGPart3Impl.setXCG01372(vrTechnicalSpec_XCGPart3.getXCG01372());
		vrTechnicalSpec_XCGPart3Impl.setXCG01373(vrTechnicalSpec_XCGPart3.getXCG01373());
		vrTechnicalSpec_XCGPart3Impl.setXCG01374(vrTechnicalSpec_XCGPart3.getXCG01374());
		vrTechnicalSpec_XCGPart3Impl.setXCG01375(vrTechnicalSpec_XCGPart3.getXCG01375());
		vrTechnicalSpec_XCGPart3Impl.setXCG01376(vrTechnicalSpec_XCGPart3.getXCG01376());
		vrTechnicalSpec_XCGPart3Impl.setXCG01377(vrTechnicalSpec_XCGPart3.getXCG01377());
		vrTechnicalSpec_XCGPart3Impl.setXCG01378(vrTechnicalSpec_XCGPart3.getXCG01378());
		vrTechnicalSpec_XCGPart3Impl.setXCG01379(vrTechnicalSpec_XCGPart3.getXCG01379());
		vrTechnicalSpec_XCGPart3Impl.setXCG01381(vrTechnicalSpec_XCGPart3.getXCG01381());
		vrTechnicalSpec_XCGPart3Impl.setXCG01382(vrTechnicalSpec_XCGPart3.getXCG01382());
		vrTechnicalSpec_XCGPart3Impl.setXCG01383(vrTechnicalSpec_XCGPart3.getXCG01383());
		vrTechnicalSpec_XCGPart3Impl.setXCG01384(vrTechnicalSpec_XCGPart3.getXCG01384());
		vrTechnicalSpec_XCGPart3Impl.setXCG01385(vrTechnicalSpec_XCGPart3.getXCG01385());
		vrTechnicalSpec_XCGPart3Impl.setXCG01386(vrTechnicalSpec_XCGPart3.getXCG01386());
		vrTechnicalSpec_XCGPart3Impl.setXCG01387(vrTechnicalSpec_XCGPart3.getXCG01387());
		vrTechnicalSpec_XCGPart3Impl.setXCG01388(vrTechnicalSpec_XCGPart3.getXCG01388());
		vrTechnicalSpec_XCGPart3Impl.setXCG01389(vrTechnicalSpec_XCGPart3.getXCG01389());
		vrTechnicalSpec_XCGPart3Impl.setXCG01390(vrTechnicalSpec_XCGPart3.getXCG01390());
		vrTechnicalSpec_XCGPart3Impl.setXCG01391(vrTechnicalSpec_XCGPart3.getXCG01391());
		vrTechnicalSpec_XCGPart3Impl.setXCG01392(vrTechnicalSpec_XCGPart3.getXCG01392());
		vrTechnicalSpec_XCGPart3Impl.setXCG01393(vrTechnicalSpec_XCGPart3.getXCG01393());
		vrTechnicalSpec_XCGPart3Impl.setXCG01394(vrTechnicalSpec_XCGPart3.getXCG01394());
		vrTechnicalSpec_XCGPart3Impl.setXCG01395(vrTechnicalSpec_XCGPart3.getXCG01395());
		vrTechnicalSpec_XCGPart3Impl.setXCG01396(vrTechnicalSpec_XCGPart3.getXCG01396());
		vrTechnicalSpec_XCGPart3Impl.setXCG01397(vrTechnicalSpec_XCGPart3.getXCG01397());
		vrTechnicalSpec_XCGPart3Impl.setXCG01398(vrTechnicalSpec_XCGPart3.getXCG01398());
		vrTechnicalSpec_XCGPart3Impl.setXCG01399(vrTechnicalSpec_XCGPart3.getXCG01399());
		vrTechnicalSpec_XCGPart3Impl.setXCG01400(vrTechnicalSpec_XCGPart3.getXCG01400());
		vrTechnicalSpec_XCGPart3Impl.setXCG01402(vrTechnicalSpec_XCGPart3.getXCG01402());
		vrTechnicalSpec_XCGPart3Impl.setXCG01403(vrTechnicalSpec_XCGPart3.getXCG01403());
		vrTechnicalSpec_XCGPart3Impl.setXCG01404(vrTechnicalSpec_XCGPart3.getXCG01404());
		vrTechnicalSpec_XCGPart3Impl.setXCG01405(vrTechnicalSpec_XCGPart3.getXCG01405());
		vrTechnicalSpec_XCGPart3Impl.setXCG01406(vrTechnicalSpec_XCGPart3.getXCG01406());
		vrTechnicalSpec_XCGPart3Impl.setXCG01407(vrTechnicalSpec_XCGPart3.getXCG01407());
		vrTechnicalSpec_XCGPart3Impl.setXCG01408(vrTechnicalSpec_XCGPart3.getXCG01408());
		vrTechnicalSpec_XCGPart3Impl.setXCG01409(vrTechnicalSpec_XCGPart3.getXCG01409());
		vrTechnicalSpec_XCGPart3Impl.setXCG01410(vrTechnicalSpec_XCGPart3.getXCG01410());
		vrTechnicalSpec_XCGPart3Impl.setXCG01411(vrTechnicalSpec_XCGPart3.getXCG01411());
		vrTechnicalSpec_XCGPart3Impl.setXCG01412(vrTechnicalSpec_XCGPart3.getXCG01412());
		vrTechnicalSpec_XCGPart3Impl.setXCG01413(vrTechnicalSpec_XCGPart3.getXCG01413());
		vrTechnicalSpec_XCGPart3Impl.setXCG01414(vrTechnicalSpec_XCGPart3.getXCG01414());
		vrTechnicalSpec_XCGPart3Impl.setXCG01415(vrTechnicalSpec_XCGPart3.getXCG01415());
		vrTechnicalSpec_XCGPart3Impl.setXCG01416(vrTechnicalSpec_XCGPart3.getXCG01416());
		vrTechnicalSpec_XCGPart3Impl.setXCG01417(vrTechnicalSpec_XCGPart3.getXCG01417());
		vrTechnicalSpec_XCGPart3Impl.setXCG01418(vrTechnicalSpec_XCGPart3.getXCG01418());
		vrTechnicalSpec_XCGPart3Impl.setXCG01419(vrTechnicalSpec_XCGPart3.getXCG01419());
		vrTechnicalSpec_XCGPart3Impl.setXCG01420(vrTechnicalSpec_XCGPart3.getXCG01420());
		vrTechnicalSpec_XCGPart3Impl.setXCG01421(vrTechnicalSpec_XCGPart3.getXCG01421());
		vrTechnicalSpec_XCGPart3Impl.setXCG01422(vrTechnicalSpec_XCGPart3.getXCG01422());
		vrTechnicalSpec_XCGPart3Impl.setXCG01423(vrTechnicalSpec_XCGPart3.getXCG01423());
		vrTechnicalSpec_XCGPart3Impl.setXCG01424(vrTechnicalSpec_XCGPart3.getXCG01424());
		vrTechnicalSpec_XCGPart3Impl.setXCG01425(vrTechnicalSpec_XCGPart3.getXCG01425());
		vrTechnicalSpec_XCGPart3Impl.setXCG01426(vrTechnicalSpec_XCGPart3.getXCG01426());
		vrTechnicalSpec_XCGPart3Impl.setXCG01427(vrTechnicalSpec_XCGPart3.getXCG01427());
		vrTechnicalSpec_XCGPart3Impl.setXCG01428(vrTechnicalSpec_XCGPart3.getXCG01428());
		vrTechnicalSpec_XCGPart3Impl.setXCG01437(vrTechnicalSpec_XCGPart3.getXCG01437());
		vrTechnicalSpec_XCGPart3Impl.setXCG01429(vrTechnicalSpec_XCGPart3.getXCG01429());
		vrTechnicalSpec_XCGPart3Impl.setXCG01430(vrTechnicalSpec_XCGPart3.getXCG01430());
		vrTechnicalSpec_XCGPart3Impl.setXCG01431(vrTechnicalSpec_XCGPart3.getXCG01431());
		vrTechnicalSpec_XCGPart3Impl.setXCG01432(vrTechnicalSpec_XCGPart3.getXCG01432());
		vrTechnicalSpec_XCGPart3Impl.setXCG01433(vrTechnicalSpec_XCGPart3.getXCG01433());
		vrTechnicalSpec_XCGPart3Impl.setXCG01434(vrTechnicalSpec_XCGPart3.getXCG01434());
		vrTechnicalSpec_XCGPart3Impl.setXCG01435(vrTechnicalSpec_XCGPart3.getXCG01435());
		vrTechnicalSpec_XCGPart3Impl.setXCG01436(vrTechnicalSpec_XCGPart3.getXCG01436());
		vrTechnicalSpec_XCGPart3Impl.setXCG01439(vrTechnicalSpec_XCGPart3.getXCG01439());
		vrTechnicalSpec_XCGPart3Impl.setXCG01440(vrTechnicalSpec_XCGPart3.getXCG01440());
		vrTechnicalSpec_XCGPart3Impl.setXCG01441(vrTechnicalSpec_XCGPart3.getXCG01441());
		vrTechnicalSpec_XCGPart3Impl.setXCG01442(vrTechnicalSpec_XCGPart3.getXCG01442());
		vrTechnicalSpec_XCGPart3Impl.setXCG01443(vrTechnicalSpec_XCGPart3.getXCG01443());
		vrTechnicalSpec_XCGPart3Impl.setXCG01445(vrTechnicalSpec_XCGPart3.getXCG01445());
		vrTechnicalSpec_XCGPart3Impl.setXCG01446(vrTechnicalSpec_XCGPart3.getXCG01446());
		vrTechnicalSpec_XCGPart3Impl.setXCG01447(vrTechnicalSpec_XCGPart3.getXCG01447());
		vrTechnicalSpec_XCGPart3Impl.setXCG01448(vrTechnicalSpec_XCGPart3.getXCG01448());
		vrTechnicalSpec_XCGPart3Impl.setXCG01449(vrTechnicalSpec_XCGPart3.getXCG01449());
		vrTechnicalSpec_XCGPart3Impl.setXCG01450(vrTechnicalSpec_XCGPart3.getXCG01450());
		vrTechnicalSpec_XCGPart3Impl.setXCG01451(vrTechnicalSpec_XCGPart3.getXCG01451());
		vrTechnicalSpec_XCGPart3Impl.setXCG01452(vrTechnicalSpec_XCGPart3.getXCG01452());
		vrTechnicalSpec_XCGPart3Impl.setXCG01453(vrTechnicalSpec_XCGPart3.getXCG01453());
		vrTechnicalSpec_XCGPart3Impl.setXCG01454(vrTechnicalSpec_XCGPart3.getXCG01454());
		vrTechnicalSpec_XCGPart3Impl.setXCG01455(vrTechnicalSpec_XCGPart3.getXCG01455());
		vrTechnicalSpec_XCGPart3Impl.setXCG01456(vrTechnicalSpec_XCGPart3.getXCG01456());
		vrTechnicalSpec_XCGPart3Impl.setXCG01457(vrTechnicalSpec_XCGPart3.getXCG01457());
		vrTechnicalSpec_XCGPart3Impl.setXCG01458(vrTechnicalSpec_XCGPart3.getXCG01458());
		vrTechnicalSpec_XCGPart3Impl.setXCG01459(vrTechnicalSpec_XCGPart3.getXCG01459());
		vrTechnicalSpec_XCGPart3Impl.setXCG01460(vrTechnicalSpec_XCGPart3.getXCG01460());
		vrTechnicalSpec_XCGPart3Impl.setXCG01461(vrTechnicalSpec_XCGPart3.getXCG01461());
		vrTechnicalSpec_XCGPart3Impl.setXCG01462(vrTechnicalSpec_XCGPart3.getXCG01462());
		vrTechnicalSpec_XCGPart3Impl.setXCG01463(vrTechnicalSpec_XCGPart3.getXCG01463());
		vrTechnicalSpec_XCGPart3Impl.setXCG01464(vrTechnicalSpec_XCGPart3.getXCG01464());
		vrTechnicalSpec_XCGPart3Impl.setXCG01465(vrTechnicalSpec_XCGPart3.getXCG01465());
		vrTechnicalSpec_XCGPart3Impl.setXCG01466(vrTechnicalSpec_XCGPart3.getXCG01466());
		vrTechnicalSpec_XCGPart3Impl.setXCG01467(vrTechnicalSpec_XCGPart3.getXCG01467());
		vrTechnicalSpec_XCGPart3Impl.setXCG01468(vrTechnicalSpec_XCGPart3.getXCG01468());
		vrTechnicalSpec_XCGPart3Impl.setXCG01469(vrTechnicalSpec_XCGPart3.getXCG01469());
		vrTechnicalSpec_XCGPart3Impl.setXCG01470(vrTechnicalSpec_XCGPart3.getXCG01470());
		vrTechnicalSpec_XCGPart3Impl.setXCG01471(vrTechnicalSpec_XCGPart3.getXCG01471());
		vrTechnicalSpec_XCGPart3Impl.setXCG01472(vrTechnicalSpec_XCGPart3.getXCG01472());
		vrTechnicalSpec_XCGPart3Impl.setXCG01473(vrTechnicalSpec_XCGPart3.getXCG01473());
		vrTechnicalSpec_XCGPart3Impl.setXCG01474(vrTechnicalSpec_XCGPart3.getXCG01474());
		vrTechnicalSpec_XCGPart3Impl.setXCG01475(vrTechnicalSpec_XCGPart3.getXCG01475());
		vrTechnicalSpec_XCGPart3Impl.setXCG01476(vrTechnicalSpec_XCGPart3.getXCG01476());
		vrTechnicalSpec_XCGPart3Impl.setXCG01477(vrTechnicalSpec_XCGPart3.getXCG01477());
		vrTechnicalSpec_XCGPart3Impl.setXCG01478(vrTechnicalSpec_XCGPart3.getXCG01478());
		vrTechnicalSpec_XCGPart3Impl.setXCG01479(vrTechnicalSpec_XCGPart3.getXCG01479());
		vrTechnicalSpec_XCGPart3Impl.setXCG01480(vrTechnicalSpec_XCGPart3.getXCG01480());
		vrTechnicalSpec_XCGPart3Impl.setXCG01481(vrTechnicalSpec_XCGPart3.getXCG01481());
		vrTechnicalSpec_XCGPart3Impl.setXCG01482(vrTechnicalSpec_XCGPart3.getXCG01482());
		vrTechnicalSpec_XCGPart3Impl.setXCG01483(vrTechnicalSpec_XCGPart3.getXCG01483());
		vrTechnicalSpec_XCGPart3Impl.setXCG01484(vrTechnicalSpec_XCGPart3.getXCG01484());
		vrTechnicalSpec_XCGPart3Impl.setXCG01485(vrTechnicalSpec_XCGPart3.getXCG01485());
		vrTechnicalSpec_XCGPart3Impl.setXCG01486(vrTechnicalSpec_XCGPart3.getXCG01486());
		vrTechnicalSpec_XCGPart3Impl.setXCG01487(vrTechnicalSpec_XCGPart3.getXCG01487());
		vrTechnicalSpec_XCGPart3Impl.setXCG01488(vrTechnicalSpec_XCGPart3.getXCG01488());
		vrTechnicalSpec_XCGPart3Impl.setXCG01489(vrTechnicalSpec_XCGPart3.getXCG01489());
		vrTechnicalSpec_XCGPart3Impl.setXCG01490(vrTechnicalSpec_XCGPart3.getXCG01490());
		vrTechnicalSpec_XCGPart3Impl.setXCG01491(vrTechnicalSpec_XCGPart3.getXCG01491());
		vrTechnicalSpec_XCGPart3Impl.setXCG01492(vrTechnicalSpec_XCGPart3.getXCG01492());
		vrTechnicalSpec_XCGPart3Impl.setXCG01493(vrTechnicalSpec_XCGPart3.getXCG01493());
		vrTechnicalSpec_XCGPart3Impl.setXCG01494(vrTechnicalSpec_XCGPart3.getXCG01494());
		vrTechnicalSpec_XCGPart3Impl.setModifyDate(vrTechnicalSpec_XCGPart3.getModifyDate());
		vrTechnicalSpec_XCGPart3Impl.setSyncDate(vrTechnicalSpec_XCGPart3.getSyncDate());

		return vrTechnicalSpec_XCGPart3Impl;
	}

	/**
	 * Returns the vr technical spec_xcg part3 with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vr technical spec_xcg part3
	 * @return the vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a vr technical spec_xcg part3 with the primary key could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByPrimaryKey(primaryKey);

		if (vrTechnicalSpec_XCGPart3 == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVRTechnicalSpec_XCGPart3Exception(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vrTechnicalSpec_XCGPart3;
	}

	/**
	 * Returns the vr technical spec_xcg part3 with the primary key or throws a {@link NoSuchVRTechnicalSpec_XCGPart3Exception} if it could not be found.
	 *
	 * @param id the primary key of the vr technical spec_xcg part3
	 * @return the vr technical spec_xcg part3
	 * @throws NoSuchVRTechnicalSpec_XCGPart3Exception if a vr technical spec_xcg part3 with the primary key could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 findByPrimaryKey(long id)
		throws NoSuchVRTechnicalSpec_XCGPart3Exception {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the vr technical spec_xcg part3 with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vr technical spec_xcg part3
	 * @return the vr technical spec_xcg part3, or <code>null</code> if a vr technical spec_xcg part3 with the primary key could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
				VRTechnicalSpec_XCGPart3Impl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = (VRTechnicalSpec_XCGPart3)serializable;

		if (vrTechnicalSpec_XCGPart3 == null) {
			Session session = null;

			try {
				session = openSession();

				vrTechnicalSpec_XCGPart3 = (VRTechnicalSpec_XCGPart3)session.get(VRTechnicalSpec_XCGPart3Impl.class,
						primaryKey);

				if (vrTechnicalSpec_XCGPart3 != null) {
					cacheResult(vrTechnicalSpec_XCGPart3);
				}
				else {
					entityCache.putResult(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
						VRTechnicalSpec_XCGPart3Impl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
					VRTechnicalSpec_XCGPart3Impl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vrTechnicalSpec_XCGPart3;
	}

	/**
	 * Returns the vr technical spec_xcg part3 with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vr technical spec_xcg part3
	 * @return the vr technical spec_xcg part3, or <code>null</code> if a vr technical spec_xcg part3 with the primary key could not be found
	 */
	@Override
	public VRTechnicalSpec_XCGPart3 fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, VRTechnicalSpec_XCGPart3> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, VRTechnicalSpec_XCGPart3> map = new HashMap<Serializable, VRTechnicalSpec_XCGPart3>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 = fetchByPrimaryKey(primaryKey);

			if (vrTechnicalSpec_XCGPart3 != null) {
				map.put(primaryKey, vrTechnicalSpec_XCGPart3);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
					VRTechnicalSpec_XCGPart3Impl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (VRTechnicalSpec_XCGPart3)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : (List<VRTechnicalSpec_XCGPart3>)q.list()) {
				map.put(vrTechnicalSpec_XCGPart3.getPrimaryKeyObj(),
					vrTechnicalSpec_XCGPart3);

				cacheResult(vrTechnicalSpec_XCGPart3);

				uncachedPrimaryKeys.remove(vrTechnicalSpec_XCGPart3.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(VRTechnicalSpec_XCGPart3ModelImpl.ENTITY_CACHE_ENABLED,
					VRTechnicalSpec_XCGPart3Impl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the vr technical spec_xcg part3s.
	 *
	 * @return the vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr technical spec_xcg part3s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @return the range of vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findAll(int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr technical spec_xcg part3s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRTechnicalSpec_XCGPart3ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr technical spec_xcg part3s
	 * @param end the upper bound of the range of vr technical spec_xcg part3s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of vr technical spec_xcg part3s
	 */
	@Override
	public List<VRTechnicalSpec_XCGPart3> findAll(int start, int end,
		OrderByComparator<VRTechnicalSpec_XCGPart3> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<VRTechnicalSpec_XCGPart3> list = null;

		if (retrieveFromCache) {
			list = (List<VRTechnicalSpec_XCGPart3>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VRTECHNICALSPEC_XCGPART3);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VRTECHNICALSPEC_XCGPART3;

				if (pagination) {
					sql = sql.concat(VRTechnicalSpec_XCGPart3ModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRTechnicalSpec_XCGPart3>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the vr technical spec_xcg part3s from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 : findAll()) {
			remove(vrTechnicalSpec_XCGPart3);
		}
	}

	/**
	 * Returns the number of vr technical spec_xcg part3s.
	 *
	 * @return the number of vr technical spec_xcg part3s
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VRTECHNICALSPEC_XCGPART3);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VRTechnicalSpec_XCGPart3ModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the vr technical spec_xcg part3 persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(VRTechnicalSpec_XCGPart3Impl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_VRTECHNICALSPEC_XCGPART3 = "SELECT vrTechnicalSpec_XCGPart3 FROM VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3";
	private static final String _SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE_PKS_IN =
		"SELECT vrTechnicalSpec_XCGPart3 FROM VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 WHERE id IN (";
	private static final String _SQL_SELECT_VRTECHNICALSPEC_XCGPART3_WHERE = "SELECT vrTechnicalSpec_XCGPart3 FROM VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 WHERE ";
	private static final String _SQL_COUNT_VRTECHNICALSPEC_XCGPART3 = "SELECT COUNT(vrTechnicalSpec_XCGPart3) FROM VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3";
	private static final String _SQL_COUNT_VRTECHNICALSPEC_XCGPART3_WHERE = "SELECT COUNT(vrTechnicalSpec_XCGPart3) FROM VRTechnicalSpec_XCGPart3 vrTechnicalSpec_XCGPart3 WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vrTechnicalSpec_XCGPart3.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VRTechnicalSpec_XCGPart3 exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VRTechnicalSpec_XCGPart3 exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(VRTechnicalSpec_XCGPart3PersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"convertAssembleId"
			});
}