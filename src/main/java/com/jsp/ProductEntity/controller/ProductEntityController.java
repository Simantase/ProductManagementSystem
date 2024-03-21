package com.jsp.ProductEntity.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.ProductEntity.dto.ProductEntityRequestDto;
import com.jsp.ProductEntity.entity.ProductEntity;
import com.jsp.ProductEntity.service.impl.ProductEntityServiceImpl;
import com.jsp.ProductEntity.utility.ErrorStructure;
import com.jsp.ProductEntity.utility.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
@RestController
public class ProductEntityController {
	private ProductEntityServiceImpl productEntityServiceImpl;
	public ProductEntityController(ProductEntityServiceImpl productEntityServiceImpl) {
		super();
		this.productEntityServiceImpl = productEntityServiceImpl;
	}
	@Operation(description =  "This EndPoint Is Used To Save The Product Based On ProductId", 
			responses = {
					@ApiResponse(responseCode ="200",description = "Product Is Saved Successfully"),
					@ApiResponse(responseCode = "400",description = "Invalid Inputs")
	})
	@PostMapping("/products")
	public ResponseEntity<ResponseStructure<ProductEntity>> save(@RequestBody ProductEntityRequestDto productEntityRequestDto){
		return productEntityServiceImpl.save(productEntityRequestDto);
	}
	@Operation(description =  "This EndPoint Is Used To Update The Product Based On ProductId", 
			responses = {
					@ApiResponse(responseCode ="200",description = "Product Is Updated Successfully"),
					@ApiResponse(responseCode = "400",description = "Invalid Inputs"),
					@ApiResponse(responseCode = "404",description = "Product Is Not Found By Given Id")
	})
	@PutMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<ProductEntity>> update(@PathVariable int productId,@RequestBody ProductEntityRequestDto productEntityRequestDto)
	{
		return productEntityServiceImpl.update(productId, productEntityRequestDto);
	}
	@Operation(description = "This Endpoint Is Used To Delete The Product Based On ProductId",responses= {
			@ApiResponse(responseCode = "200", description = "Product Is Deleted Successfully"),
			@ApiResponse(responseCode = "404",description = "Product Is Not Deleted" , content= {
					@Content(schema = @Schema(implementation = ErrorStructure.class))
			})
	})
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<ProductEntity>> delete(@PathVariable int productId)
	{
		return productEntityServiceImpl.delete(productId);
	}
	@Operation(description =  "This EndPoint Is Used To Fetch The Product Based On ProductId", 
			responses = {
					@ApiResponse(responseCode ="200",description = "Product Is Found Successfuly"),
					@ApiResponse(responseCode = "404",description = "Product Is Not Found By Given Id", content = {
							@Content(schema = @Schema(implementation = ErrorStructure.class))
					})
	})
	@GetMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<ProductEntity>> fetchById(@PathVariable int productId)
	{
		return productEntityServiceImpl.findById(productId);
	}
	@Operation(description =  "This EndPoint Is Used  The Products", 
			responses = {
					@ApiResponse(responseCode ="200",description = "Products Are Found Successfuly"),
					@ApiResponse(responseCode = "404",description = "Products Are Not Found", content = {
							@Content(schema = @Schema(implementation = ErrorStructure.class))
					}
							)})
	@GetMapping("/products")
	public ResponseEntity<ResponseStructure<List<ProductEntity>>> fetchAll()
	{
		return productEntityServiceImpl.findAll();
	}
}
