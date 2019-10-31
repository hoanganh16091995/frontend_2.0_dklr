package com.fds.vr.business.action.impl;

import com.fds.vr.business.action.VRApplicantProfileAction;
import com.fds.vr.business.action.util.ActionUtil;
import com.fds.vr.business.engine.SQLQueryInstance;
import com.fds.vr.business.model.VRApplicantProfile;
import com.fds.vr.business.model.VRProductionClassification;
import com.fds.vr.business.model.impl.VRApplicantProfileImpl;
import com.fds.vr.business.model.impl.VRApplicantProfileModelImpl;
import com.fds.vr.business.model.impl.VRProductionClassificationImpl;
import com.fds.vr.business.service.VRApplicantProfileLocalServiceUtil;
import com.fds.vr.business.service.VRProductionClassificationLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.LinkedHashMap;

import javax.net.ssl.HttpsURLConnection;

/**
 * @author trungnt
 *
 */
public class VRApplicantProfileActionImpl implements VRApplicantProfileAction {
	private Log _log = LogFactoryUtil.getLog(VRApplicantProfileActionImpl.class);

	@Override
	public JSONObject findVRApplicantProfileDetail(User user, ServiceContext serviceContext,
			LinkedHashMap<String, Object> params) {
		Long id = null;
		Long mtCore = null;
		String applicantCode = StringPool.BLANK;
		if (params != null) {
			if (params.containsKey("applicantcode") && params.containsKey("mtcore")) {
				applicantCode = (String) params.get("applicantcode");
				mtCore = (Long) params.get("mtcore");
				if (Validator.isNotNull(applicantCode) && (mtCore != null)) {
					try {
						VRApplicantProfile applicantProfile = VRApplicantProfileLocalServiceUtil
								.findByMT_APP_CODE(mtCore, applicantCode);
						if (applicantProfile != null) {
							return ActionUtil.object2Json(applicantProfile, VRApplicantProfileModelImpl.class,
									StringPool.BLANK);
						}

						return null;

					} catch (Exception e) {
						_log.error(e);
						return null;
					}
				}
			}

			if (params.containsKey("id")) {
				try {
					id = (Long) params.get("id");
					VRApplicantProfile applicantProfile = VRApplicantProfileLocalServiceUtil.getVRApplicantProfile(id);
					return ActionUtil.object2Json(applicantProfile, VRApplicantProfileModelImpl.class,
							StringPool.BLANK);
				} catch (Exception e) {
					_log.error(e);
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public JSONObject findVRApplicantProfile(User user, ServiceContext serviceContext,
			LinkedHashMap<String, Object> params) {

		int start = ActionUtil.getStart(params);
		int end = ActionUtil.getEnd(params);
		String keyword = ActionUtil.getKeyword(params);
		String applicantcode = StringPool.BLANK;
		String applicantname = StringPool.BLANK;
		String mappingma_cty = StringPool.BLANK;
		String mappingten_cty = StringPool.BLANK;
		String mappingdia_chi_cty = StringPool.BLANK;

		if (params != null) {

			if (params.containsKey("applicantcode")) {
				applicantcode = (String) params.get("applicantcode");
			}
			if (params.containsKey("applicantname")) {
				applicantcode = (String) params.get("applicantname");
			}

			if (params.containsKey("mappingma_cty")) {
				mappingma_cty = (String) params.get("mappingma_cty");
			}
			if (params.containsKey("mappingten_cty")) {
				mappingten_cty = (String) params.get("mappingten_cty");
			}
			if (params.containsKey("mappingdia_chi_cty")) {
				mappingdia_chi_cty = (String) params.get("mappingdia_chi_cty");
			}

		}

		String tableAlias = StringPool.BLANK;

		String sqlStatementPattern = "SELECT [$STATEMENT_COLUMN$] FROM vr_applicantprofile"
				+ (Validator.isNotNull(tableAlias) ? " AS " + tableAlias : StringPool.BLANK)
				+ " [$CONDITION$] [$ORDERBY$]";

		LinkedHashMap<String, String> columnStatementMap = new LinkedHashMap<String, String>();
		columnStatementMap.put(ActionUtil.createSCNWTAS("id", tableAlias), long.class.getName());
		columnStatementMap.put(ActionUtil.createSCNWTAS("mtcore", tableAlias), long.class.getName());
		columnStatementMap.put(ActionUtil.createSCNWTAS("mappingma_cty", tableAlias), String.class.getName());
		columnStatementMap.put(ActionUtil.createSCNWTAS("mappingten_cty", tableAlias), String.class.getName());
		columnStatementMap.put(ActionUtil.createSCNWTAS("mappingdia_chi_cty", tableAlias), String.class.getName());

		StringBuilder conditions = new StringBuilder();

		conditions.append(" WHERE 1 = 1 ");

		if (Validator.isNotNull(mappingma_cty)) {
			conditions.append(ActionUtil.buildSQLCondition("mappingma_cty", mappingma_cty, " AND ", StringPool.EQUAL,
					tableAlias));
		}

		if (Validator.isNotNull(mappingten_cty)) {
			conditions.append(ActionUtil.buildSQLCondition("mappingten_cty", "'%" + mappingten_cty + "%'", " AND ",
					StringPool.LIKE, tableAlias));
		}

		if (Validator.isNotNull(keyword)) {
			conditions
					.append(ActionUtil.buildSQLCondition(
							"(" + ActionUtil.buildSQLCondition("mappingten_cty", "'%" + keyword + "%'", "",
									StringPool.LIKE, tableAlias)
									+ ActionUtil.buildSQLCondition("mappingdia_chi_cty", "'%" + keyword + "%'", " OR ",
											StringPool.LIKE, tableAlias)
									+ ")",
							StringPool.BLANK, " AND ", StringPool.BLANK));
		}

		LinkedHashMap<String, String> sortedby = ActionUtil.getOrderFiledMap(params, columnStatementMap);

		SQLQueryInstance instance = ActionUtil.createSQLQueryInstance(sqlStatementPattern, columnStatementMap,
				conditions, sortedby, VRApplicantProfileImpl.class, StringPool.BLANK, tableAlias, StringPool.BLANK);

		// System.out.println("SQL Statement:" + instance.getSqlStatemanent());

		JSONArray array = VRApplicantProfileLocalServiceUtil.findVRAppicantProfile(instance.getSqlStatemanent(),
				instance.getColumnAliasNames(), instance.getColumnDataTypes(), instance.getReturnClassName(),
				instance.getClassName(), start, end);

		long total = VRApplicantProfileLocalServiceUtil.countVRAppicantProfile(instance.getCountStatemanent());

		JSONObject result = JSONFactoryUtil.createJSONObject();

		result.put("total", total);
		result.put("data", array);
		return result;
	}
	
	public JSONObject createVRApplicantProfile(VRApplicantProfile object) {

		object.setId(0);

		return updateVRApplicantProfile(object);
	}

	public JSONObject updateVRApplicantProfile(VRApplicantProfile object) {

		JSONObject returnObj = JSONFactoryUtil.createJSONObject();
		JSONObject result = JSONFactoryUtil.createJSONObject();

		try {

			object = VRApplicantProfileLocalServiceUtil.updateVRApplicantProfile(object);

			result = ActionUtil.object2Json(object, VRApplicantProfileImpl.class, StringPool.BLANK);

			returnObj.put("status", HttpsURLConnection.HTTP_OK);
			returnObj.put("content", result);

		} catch (Exception e) {
			_log.error(e);

			returnObj.put("status", HttpsURLConnection.HTTP_INTERNAL_ERROR);

		}

		return returnObj;
	}

}
