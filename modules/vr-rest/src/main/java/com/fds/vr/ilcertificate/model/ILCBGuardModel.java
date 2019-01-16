//
//This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
//See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
//Any modifications to this file will be lost upon recompilation of the source schema. 
//Generated on: 2017.10.16 at 02:30:16 PM ICT 
//


package com.fds.vr.ilcertificate.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
* <p>Java class for DeliverableModel complex type.
* 
* <p>The following schema fragment specifies the expected content contained within this class.
* 
* <pre>
* &lt;complexType name="DeliverableModel">
*   &lt;complexContent>
*     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
*       &lt;sequence>
*         &lt;element name="deliverableId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
*         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
*         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="createDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="modifiedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="deliverableCode" type="{http://www.w3.org/2001/XMLSchema}String" minOccurs="0"/>
*         &lt;element name="deliverableName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="deliverableType" type="{http://www.w3.org/2001/XMLSchema}String" minOccurs="0"/>
*         &lt;element name="govAgencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="govAgencyName" type="{http://www.w3.org/2001/XMLSchema}String" minOccurs="0"/>
*         &lt;element name="applicantIdNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="applicantName" type="{http://www.w3.org/2001/XMLSchema}String" minOccurs="0"/>
*         &lt;element name="subject" type="{http://www.w3.org/2001/XMLSchema}String" minOccurs="0"/>
*         &lt;element name="issueDate" type="{http://www.w3.org/2001/XMLSchema}String" minOccurs="0"/>
*         &lt;element name="expireDate" type="{http://www.w3.org/2001/XMLSchema}String" minOccurs="0"/>
*         &lt;element name="revalidate" type="{http://www.w3.org/2001/XMLSchema}String" minOccurs="0"/>
*         &lt;element name="deliverableState" type="{http://www.w3.org/2001/XMLSchema}String" minOccurs="0"/>
*       &lt;/sequence>
*     &lt;/restriction>
*   &lt;/complexContent>
* &lt;/complexType>
* </pre>
* 
* 
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ILCBGuardModel", propOrder = {
	"registrationNumber",
	"expImpGateType",
	"expImpGate",
	"driverName",
	"driverLicenceNo",
	"registrationDate",
	"customsDepartureDate",
	"customsArrivalDate",
	"borderGuardsDepartureDate",
	"borderGuardsArrivalDate"
})
@XmlRootElement(name = "ILCBGuardModel")
public class ILCBGuardModel {
	protected String registrationNumber;
	protected String expImpGateType;
	protected String expImpGate;
	protected String driverName;
	protected String driverLicenceNo;
	protected String registrationDate;
	protected String customsDepartureDate;
	protected String customsArrivalDate;
	protected String borderGuardsDepartureDate;
	protected String borderGuardsArrivalDate;

	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getExpImpGateType() {
		return expImpGateType;
	}
	public void setExpImpGateType(String expImpGateType) {
		this.expImpGateType = expImpGateType;
	}
	public String getExpImpGate() {
		return expImpGate;
	}
	public void setExpImpGate(String expImpGate) {
		this.expImpGate = expImpGate;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverLicenceNo() {
		return driverLicenceNo;
	}
	public void setDriverLicenceNo(String driverLicenceNo) {
		this.driverLicenceNo = driverLicenceNo;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getCustomsDepartureDate() {
		return customsDepartureDate;
	}
	public void setCustomsDepartureDate(String customsDepartureDate) {
		this.customsDepartureDate = customsDepartureDate;
	}
	public String getCustomsArrivalDate() {
		return customsArrivalDate;
	}
	public void setCustomsArrivalDate(String customsArrivalDate) {
		this.customsArrivalDate = customsArrivalDate;
	}
	public String getBorderGuardsDepartureDate() {
		return borderGuardsDepartureDate;
	}
	public void setBorderGuardsDepartureDate(String borderGuardsDepartureDate) {
		this.borderGuardsDepartureDate = borderGuardsDepartureDate;
	}
	public String getBorderGuardsArrivalDate() {
		return borderGuardsArrivalDate;
	}
	public void setBorderGuardsArrivalDate(String borderGuardsArrivalDate) {
		this.borderGuardsArrivalDate = borderGuardsArrivalDate;
	}

}