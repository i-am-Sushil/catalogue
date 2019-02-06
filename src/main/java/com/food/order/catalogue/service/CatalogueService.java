package com.food.order.catalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.order.catalogue.model.Product;
import com.food.order.catalogue.repository.CatalogueRepository;

@Service
public class CatalogueService {
	@Autowired
	private CatalogueRepository catalogueRepository;

	public Boolean addProduct(final Product product) {
		return catalogueRepository.addProduct(product);
	}

	public Boolean updateProduct(final Product product) {
		return catalogueRepository.updateProduct(product);
	}

	public Boolean deleteProduct(final Integer productId) {
		return catalogueRepository.deleteProduct(productId);
	}

	public List<Product> listProducts() {
		return catalogueRepository.listProducts();
	}

	public Product getProduct(final Integer productId) {
		return catalogueRepository.getProduct(productId);
	}

}
