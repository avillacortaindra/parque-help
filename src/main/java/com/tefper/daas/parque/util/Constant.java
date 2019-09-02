package com.tefper.daas.parque.util;

public final class Constant {

	/* Gestión de logs y entornos */
	public static final String	CICLE_BILLING					= "ciclyBilling";
	public static final String	INDICATOR_MT					= "indicatorMT";
	public static final String	ROLE							= "Consumer";
	public static final String	SUBPRODUCT						= "Subproduct";
	public static final String	CHARACTERISTIC_SEPARATOR		= "+";
	public static final String	CHARACTERISTIC_DELIMITER		= ";";
	public static final String	ATTRIBUTE_TO_CONSIDER			= "es";

	public static final String	SVC1003_CODE					= "SVC1003";
	public static final String	SVC1003_EXCEPTION				= "Invalid requested Operation";
	public static final String	SVC1003_DESCRIPTION				= "Requested operation does not exist";
	public static final String	SVC1003_TEXT					= "Requested HTTP Method Operation does not exist";

	public static final String	SVC1000_CODE					= "SVC1000";
	public static final String	SVC1000_EXCEPTION				= "Missing mandatory parameter";
	public static final String	SVC1000_DESCRIPTION				= "API Request withour mandatory field";
	public static final String	SVC1000_TEXT					= "Missing mandatory parameter: ";

	public static final String	SVC1001_CODE					= "SVC1001";
	public static final String	SVC1001_EXCEPTION				= "Invalid parameter";
	public static final String	SVC1001_DESCRIPTION				= "API Request with an element not conforming to swagger definitions or to a list a allowed Query Parameters";
	public static final String	SVC1001_TEXT					= "Invalid parameter: ";

	public static final String	SVR1000_CODE					= "SVR1000";
	public static final String	SVR1000_EXCEPTION				= "Generic Server Fault";
	public static final String	SVR1000_DESCRIPTION				= "There was a problem in the Service Providers network that prevented to carry out the request";
	public static final String	SVR1000_TEXT					= "Generic Server Error";

	public static final String	SVC1006_CODE					= "SVC1006";
	public static final String	SVC1006_EXCEPTION				= "Not existing Resource Id";
	public static final String	SVC1006_DESCRIPTION				= "Reference to a resource {0} identifier wich does not exist";
	public static final String	SVC1006_TEXT					= "Resource does not exist";

	public static final String	HREF_PRODUCT_INSTANCE_TYPE		= "/productInventory/v2/products/";
	public static final String	HREF_BILLING_ACCOUNT			= "/accounts/v3/accounts/";
	public static final String	HREF_PRODUCT_OFFERING			= "/productCatalog/v2/offerings/";

	public static final String	MOBILE_QUOTA_VOICE				= "Voz";
	public static final String	MOBILE_QUOTA_DATA				= "Datos";
	public static final String	MOBILE_QUOTA_SMS				= "SMS";

	public static final String	BILLINGMETHOD_PREPAID			= "Prepago";
	public static final String	BILLINGMETHOD_POSTPAID			= "Postpago";
	public static final String	BILLINGMETHOD_CONTROL			= "Control";
	public static final String	BILLINGMETHOD_CARIBU			= "Caribu";

	public static final String	STATEPRODUCT_ACTIVE				= "Activo";
	public static final String	STATEPRODUCT_SUSPENDED			= "Suspendido";
	public static final String	STATEPRODUCT_TERMINATED			= "En baja";

	public static final String	INDICADOR_PLAN					= "1";
	public static final String	TIME_ZONE						= "America/Lima";

	public static final String	FORMAT_DATETIME					= "yyyy-MM-dd'T'HH:mm:ss";

	public static final String	SHARINGDATACONSUMER_VALUE		= "Sharing Data Consumer";
	public static final String	SHARINGDATAOWNER_VALUE			= "Sharing Data Owner";

	public static final String	SHARINGDATACONSUMER_NAME		= "SharingDataConsumer";
	public static final String	SHARINGDATAOWNER_NAME			= "SharingDataOwner";

	public static final String	APPSILIMITADA_PRODUCTTYPE_SVA	= "sva";
	public static final String	APPSILIMITADA_ID				= "Unavailable";

	private Constant() {}
}
