/**
 * 
 */
package com.fds.vr.business.action.impl;

import com.fds.vr.business.action.VRExpiredCertificateActions;
import com.fds.vr.business.model.VRDossier;
import com.fds.vr.business.model.VRExpireCertificate;
import com.fds.vr.business.model.impl.VRDossierModelImpl;
import com.fds.vr.business.model.impl.VRExpireCertificateModelImpl;
import com.fds.vr.business.service.VRDossierLocalServiceUtil;
import com.fds.vr.business.service.VRExpireCertificateLocalServiceUtil;
import com.fds.vr.service.util.BusinessUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Date;
import java.util.List;

/**
 * @author ddung
 *
 */
public class VRExpiredCertificateActionsImpl implements VRExpiredCertificateActions {

	@Override
	public JSONObject findByDossierStatus(String dossierStatus, int start, int end) {
		List<VRExpireCertificate> vrExpireCertificates = VRExpireCertificateLocalServiceUtil
				.findByDossierStatus(dossierStatus, start, end);
		JSONArray array = JSONFactoryUtil.createJSONArray();
		for (VRExpireCertificate vrExpireCertificate : vrExpireCertificates) {
			VRDossier vrDossier_CTN = VRDossierLocalServiceUtil.fetchVRDossier(vrExpireCertificate.getDossierId());
			VRDossier vrDossier_CXL = VRDossierLocalServiceUtil.getByRef(55301L, vrDossier_CTN.getReferenceUid());
			if (vrDossier_CXL != null) {
				try {
					JSONObject obj = BusinessUtil.object2Json_originColumnName(vrDossier_CXL, VRDossierModelImpl.class,
							StringPool.BLANK);
					obj.put("expireCertificateId", vrExpireCertificate.getPrimaryKey());
					obj.put("dossierIdCTN", "");
					obj.put("certNo", "");
					obj.put("certDate", "");
					array.put(obj);
				} catch (JSONException e) {
				}
			}
		}
		JSONObject result = JSONFactoryUtil.createJSONObject();
		result.put("data", array);
		result.put("total", VRExpireCertificateLocalServiceUtil
				.findByDossierStatus(dossierStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS).size());

		return result;
	}

	@Override
	public JSONObject updateVRExpiredCertificate(long id, long mtCore, long convertAssembleId, long validDossierId,
			String validDossierIdCTN, String validDossierNo, long vehicleTypeCertificateId, long dossierId,
			String dossierIdCTN, String dossierNo, String dossierStatus, Date previousExpireDate,
			String certificateRecordNo, Date certificateRecordDate, Date certificateRecordExpireDate, int expiredStatus,
			String vehicleClass, String certifiedVehicleType, String certifiedVehicleTypeDescription,
			String certifiedTrademark, String certifiedTrademarkName, String certifiedCommercialName,
			String certifiedModelCode, String productionCountry, String safetytestReportNo, Date safetytestReportDate,
			String emissionTestReportNo, Date emissionTestReportDate, String commonSafetyStandard,
			String commonSafetyDescription, String emissionStandard, String emissionDescription,
			String othertestReportNo, Date othertestReportDate, String copReportNo, Date copReportDate,
			Date copReportExpireDate, String validRequestNo, Date validRequestDate, String validInspectionRecordNo,
			Date validInspectionRecordDate, long validCorporationId, long validInspectorId, String validInspectorName,
			String validRemarks, String validInspectionNote, long deliverableFileEntryId, long documentFileEntryId,
			Date syncDate, String typeUpdate, Company company) throws JSONException {
		VRExpireCertificate vrExpireCertificate = VRExpireCertificateLocalServiceUtil.updateVRExpireCertificate(id,
				mtCore, convertAssembleId, validDossierId, validDossierIdCTN, validDossierNo, vehicleTypeCertificateId,
				dossierId, dossierIdCTN, dossierNo, dossierStatus, previousExpireDate, certificateRecordNo,
				certificateRecordDate, certificateRecordExpireDate, expiredStatus, vehicleClass, certifiedVehicleType,
				certifiedVehicleTypeDescription, certifiedTrademark, certifiedTrademarkName, certifiedCommercialName,
				certifiedModelCode, productionCountry, safetytestReportNo, safetytestReportDate, emissionTestReportNo,
				emissionTestReportDate, commonSafetyStandard, commonSafetyDescription, emissionStandard,
				emissionDescription, othertestReportNo, othertestReportDate, copReportNo, copReportDate,
				copReportExpireDate, validRequestNo, validRequestDate, validInspectionRecordNo,
				validInspectionRecordDate, validCorporationId, validInspectorId, validInspectorName, validRemarks,
				validInspectionNote, deliverableFileEntryId, documentFileEntryId, syncDate, typeUpdate, company);

		return BusinessUtil.object2Json_originColumnName(vrExpireCertificate, VRExpireCertificateModelImpl.class,
				StringPool.BLANK);
	}

}
