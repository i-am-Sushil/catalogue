package com.food.order.catalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.food.order.catalogue.model.Product;
import com.food.order.catalogue.service.CatalogueService;

@RestController
public class CatalogueController {
	@Autowired
	private CatalogueService catalogueService;

	@RequestMapping(value = "/catalogue", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> listProducts() {
		return catalogueService.listProducts();
	}

	@RequestMapping(value = "/catalogue/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product getProduct(@PathVariable("productId") final Integer productId) {
		System.out.println("ProductId:" + productId);
		return catalogueService.getProduct(productId);
	}

	@RequestMapping(value = "/catalogue", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Boolean addProduct(@RequestBody final Product product) {
		System.out.println("Product- " + "ProductId:" + product.getProductId() + ", ProductName:"
				+ product.getProductName() + ", ProductDescription:" + product.getProductDescription()
				+ ", ProductPrice:" + product.getProductPrice());
		return catalogueService.addProduct(product);
	}
	
	@RequestMapping(value = "/catalogue", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Boolean updateProduct(@RequestBody final Product product) {
		System.out.println("Product- " + "ProductId:" + product.getProductId() + ", ProductName:"
				+ product.getProductName() + ", ProductDescription:" + product.getProductDescription()
				+ ", ProductPrice:" + product.getProductPrice());
		return catalogueService.updateProduct(product);
	}

	@RequestMapping(value = "/catalogue/{productId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Boolean deleteProduct(@PathVariable("productId") final Integer productId) {
		System.out.println("ProductId:" + productId);
		return catalogueService.deleteProduct(productId);
	}
}
