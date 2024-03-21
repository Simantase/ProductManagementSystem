package com.jsp.ProductEntity.service;
import java.util.List;
import org.springframework.http.ResponseEntity;

import com.jsp.ProductEntity.dto.ProductEntityRequestDto;
import com.jsp.ProductEntity.entity.ProductEntity;
import com.jsp.ProductEntity.utility.ResponseStructure;
public interface ProductEntityService {
	ResponseEntity<ResponseStructure<ProductEntity>> save(ProductEntityRequestDto productEntityRequestDto);
	ResponseEntity<ResponseStructure<ProductEntity>> delete(int productId);
	ResponseEntity<ResponseStructure<ProductEntity>> findById(int productId);
	ResponseEntity<ResponseStructure<List<ProductEntity>>> findAll();
	ResponseEntity<ResponseStructure<ProductEntity>> update(int productId, ProductEntityRequestDto productRequestDto);
	
}
