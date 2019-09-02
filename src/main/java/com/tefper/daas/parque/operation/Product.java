package com.tefper.daas.parque.operation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tefper.daas.parque.business.ProductBusiness;
import com.tefper.daas.parque.model.ExceptionType;
import com.tefper.daas.parque.model.ProductInstanceType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/products", consumes = "application/json")
@RestController
@RequestMapping("/products")
public class Product {

	@Autowired
	private ProductBusiness productBusiness;

	@ApiOperation(value = "Retrieve details of a single product instance in the server", nickname = "retrieveSingleProductInstance", notes = "", response = ProductInstanceType.class, tags = {
			"products",})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Details of a product instance", response = ProductInstanceType.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ExceptionType.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ExceptionType.class),
			@ApiResponse(code = 404, message = "Not Found", response = ExceptionType.class)})
	@GetMapping(value = "/{productId}", produces = {"application/json"})
	public List<ProductInstanceType> retrieveSingleProductInstance(
			@ApiParam(value = "ID of the product instance", required = true) @PathVariable("productId") String productId, HttpServletRequest request) throws MethodArgumentNotValidException {
		return productBusiness.getProductById(productId);
	}

	@ApiOperation(value = "Retrieve list of products in inventory", nickname = "retrieveProductInstances", notes = "", response = ProductInstanceType.class, responseContainer = "List", tags = {
			"products"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "List of product instances provided", response = ProductInstanceType.class, responseContainer = "List"),
			@ApiResponse(code = 400, message = "Bad Request", response = ExceptionType.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ExceptionType.class),
			@ApiResponse(code = 404, message = "Not Found", response = ExceptionType.class)})
	@GetMapping(produces = {"application/json"})
	public List<ProductInstanceType> retrieveProductInstances(
			@ApiParam(value = "To obtain the list of products stored in the server that are of a given type") @Valid @RequestParam(value = "type", required = false) String type,
			@ApiParam(value = "to obtain the list of products associated with a given public identifier (e.g.: an msisdn subscription id)") @Valid @RequestParam(value = "publicId", required = false) String publicId, HttpServletRequest request) throws MethodArgumentNotValidException {
		return productBusiness.getProductByPublicIdAndProductType(publicId, type.toLowerCase());
	}

}
