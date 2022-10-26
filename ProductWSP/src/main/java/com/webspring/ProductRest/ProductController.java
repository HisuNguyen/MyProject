package com.webspring.ProductRest;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService ps;

	@GetMapping("/product")
	public List<Product> list() {
		return ps.listAll();
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id) {
		try {
			Product pro = ps.get(id);
			return new ResponseEntity<Product>(pro, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/product")
	public void add(@RequestBody Product product) {
		ps.save(product);
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
		try {
			Product existProduct = ps.get(id);
			ps.save(product);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/product/{id}")
	public void delete(@PathVariable Integer id) {
		ps.delete(id);
	}
}
