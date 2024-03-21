package com.jsp.ProductEntity.service.impl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.ProductEntity.dto.ProductEntityRequestDto;
import com.jsp.ProductEntity.entity.ProductEntity;
import com.jsp.ProductEntity.exception.ProductNotFoundException;
import com.jsp.ProductEntity.exception.ProductNotFoundException1;
import com.jsp.ProductEntity.exception.ProductNotFoundException2;
import com.jsp.ProductEntity.exception.ProductNotFoundException3;
import com.jsp.ProductEntity.repository.ProductEntityRepository;
import com.jsp.ProductEntity.service.ProductEntityService;
import com.jsp.ProductEntity.utility.ResponseStructure;
@Service
public class ProductEntityServiceImpl implements ProductEntityService {
	private ProductEntityRepository productEntityRepository;
	private ResponseStructure<ProductEntity> responseStructure;
	private ResponseStructure<List<ProductEntity>> responseStructure2;
	public ProductEntityServiceImpl(ProductEntityRepository productEntityRepository,
			ResponseStructure<ProductEntity> responseStructure,
			ResponseStructure<List<ProductEntity>> responseStructure2) {
		super();
		this.productEntityRepository = productEntityRepository;
		this.responseStructure = responseStructure;
		this.responseStructure2 = responseStructure2;
	}
	@Override
	public ResponseEntity<ResponseStructure<ProductEntity>> save(ProductEntityRequestDto productEntityRequestDto) {
		//mapping DTO to entity
		ProductEntity productEntity=productEntityRepository.save(mapToProduct(productEntityRequestDto, new ProductEntity()));
		return ResponseEntity.ok(
				responseStructure.setStatusCode(HttpStatus.OK.value())
				.setStatusMessage("Data Saved Sucessfully")
				.setData(productEntity));

	}
	private ProductEntity mapToProduct(ProductEntityRequestDto productEntityRequestDto,ProductEntity productEntity) {
		productEntity.setProductId(productEntityRequestDto.getProductId());
		productEntity.setProductName(productEntityRequestDto.getProductName());
		productEntity.setProductPrice(productEntityRequestDto.getProductPrice());
		return productEntity;
	}
	// Lombok Design Pattern
	//	private ProductEntity mapToProduct(ProductEntityRequestDto productEntityRequestDto,ProductEntity productEntity) {
	//		return	ProductEntity.builder()
	//				.productId(productEntityRequestDto.getProductId())
	//				.productName(productEntityRequestDto.getProductName())
	//				.productPrice(productEntityRequestDto.getProductPrice()).build();
	//	}
	@Override
	public ResponseEntity<ResponseStructure<ProductEntity>> update(int productId,ProductEntityRequestDto productRequestDto) {
		ProductEntity product = mapToProduct(productRequestDto, new ProductEntity());
		return productEntityRepository.findById(productId).map(exProduct -> {
			product.setProductId(exProduct.getProductId());
			exProduct=productEntityRepository.save(product);
			return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
					.setStatusMessage("Data Is Updated Successfully")
					.setData(exProduct));
		}).orElseThrow(()-> new ProductNotFoundException3("Data Is Not Updated"));
	}
	@Override
	public ResponseEntity<ResponseStructure<ProductEntity>> findById(int productId) {
		return productEntityRepository.findById(productId)
				.map(p -> ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
						.setStatusMessage("Data Is Fetched Successfully")
						.setData(p)))
				.orElseThrow(() -> new ProductNotFoundException2("Data Is Not Fetched!!!"));
	}
	@Override
	public ResponseEntity<ResponseStructure<ProductEntity>> delete(int productId) {
		Optional<ProductEntity> optional = productEntityRepository.findById(productId);
		return optional.map(product -> {
			productEntityRepository.delete(product);
			return ResponseEntity.ok(
					responseStructure.setStatusCode(HttpStatus.OK.value())
					.setStatusMessage("Product Is Deleted Successfully")
					.setData(product));
		}).orElseThrow(()->new ProductNotFoundException3("Data Is Not Deleted"));
	}
	@Override
	public ResponseEntity<ResponseStructure<List<ProductEntity>>> findAll() {
		List<ProductEntity> products=productEntityRepository.findAll();
		if(!products.isEmpty()) {
			return ResponseEntity.ok(
					responseStructure2.setStatusCode(HttpStatus.OK.value())
					.setStatusMessage("All The Data Are Fetched Successfully")
					.setData(productEntityRepository.findAll()));
		}
		else throw new ProductNotFoundException3("Data Is Not Fetched!!!");
	}

}
