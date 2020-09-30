package com.cookiesandcream.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cookiesandcream.app.entity.Product;
import com.cookiesandcream.app.exception.ResourceNotFoundException;
import com.cookiesandcream.app.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	//get all products
	@GetMapping
	public List<Product> getAllProducts(){
		return this.productRepository.findAll();
	}
	
	//get product by id
	public Product getProductById(@PathVariable (value= "id") long productId) {
		return this.productRepository.findById(productId).orElseThrow(() -> 
		new ResourceNotFoundException("Product not found with id:" +productId));
	}
		
	
	//save product
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return this.productRepository.save(product);
	}
	
	//update product
	@PutMapping("/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable ("id") long productId) {
		Product existingProduct = this.productRepository.findById(productId)
				.orElseThrow( () -> new ResourceNotFoundException("Product not found with id:" + productId));
		existingProduct.setProductName(product.getProductName());
		existingProduct.setProductCode(product.getProductCode());
		existingProduct.setProductQuantity((int) product.getProductPrice());
		existingProduct.setProductPrice(product.getProductPrice());
		return this.productRepository.save(existingProduct);
		
	}
	
	//delete product by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteUser(@PathVariable ("id") long productId){
			Product existingProduct = this.productRepository.findById(productId)
			.orElseThrow( () -> new ResourceNotFoundException("Product not found with id:" + productId));
			this.productRepository.delete(existingProduct);
			return ResponseEntity.ok().build();
	}
}
