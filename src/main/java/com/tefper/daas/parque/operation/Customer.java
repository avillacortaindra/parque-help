package com.tefper.daas.parque.operation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tefper.daas.parque.business.CustomerBusiness;
import com.tefper.daas.parque.model.ExceptionType;
import com.tefper.daas.parque.model.ProductInstanceType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/customers", consumes = "application/json")
@RestController
@RequestMapping("/customers")
public class Customer {

	@Autowired
	private CustomerBusiness customerBusiness;

	@ApiOperation(value = "Retrieve list of products in inventory that belong to a customer", nickname = "retrieveCustomerProductInstances", notes = "", response = ProductInstanceType.class, responseContainer = "List", tags = {
			"products of a customer"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "List of product instances provided", response = ProductInstanceType.class, responseContainer = "List"),
			@ApiResponse(code = 400, message = "Bad Request", response = ExceptionType.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ExceptionType.class),
			@ApiResponse(code = 404, message = "Not Found", response = ExceptionType.class)})
	@GetMapping(value = "/{customerId}/products", produces = {"application/json"})
	public List<ProductInstanceType> retrieveCustomerProductInstances(
			@ApiParam(value = "ID of the customer whose products need to be fetched", required = true) @PathVariable("customerId") @Valid String customerId,
			HttpServletRequest request) throws MethodArgumentNotValidException {
		return customerBusiness.getCustomerProductById(customerId);
	}

	@ApiOperation(value = "Retrieve list of products in inventory that belong to a customer by documentNumber", nickname = "retrieveCustomerProductInstancesByDocument", notes = "", response = ProductInstanceType.class, responseContainer = "List", tags = {
			"products of a customer by document"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "List of product instances provided", response = ProductInstanceType.class, responseContainer = "List"),
			@ApiResponse(code = 400, message = "Bad Request", response = ExceptionType.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ExceptionType.class),
			@ApiResponse(code = 404, message = "Not Found", response = ExceptionType.class)})
	@GetMapping(value = "/products", produces = {"application/json"})
	public List<ProductInstanceType> retrieveCustomerProductByDocument(
			@ApiParam(value = "Document type of the customer whose products need to be fetched", required = true) @RequestHeader(name = "Document-Type", required = true) @Valid String documentType,
			@ApiParam(value = "Document number of the customer whose products need to be fetched", required = true) @RequestHeader(name = "Document-Number", required = true) @Valid String documentNumber,
			HttpServletRequest request) throws MethodArgumentNotValidException {
		return customerBusiness.getCustomerProductByTypeAndDocument(documentType, documentNumber.toUpperCase());
	}

}
