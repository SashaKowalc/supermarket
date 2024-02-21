package com.sasha.supermarket.domain.service;

import com.sasha.supermarket.domain.Product;
import com.sasha.supermarket.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Esta es la capa service. Es la que sirve de intermediaria entre el repository y la persitencia
@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public List<Product> getAll() {
    return productRepository.getAll();
  }

  public Optional<Product> getProduct(int productId) {
    return productRepository.getProduct(productId);
  }

  public Optional<List<Product>> getByCategory (int categoryId) {
    return productRepository.getByCategory(categoryId);
  }

  public Product save(Product product) {
    return productRepository.save(product);
  }

  public boolean delete(int productId) {
    return getProduct(productId).map(product -> {
      productRepository.delete(productId);
      return true;
    }).orElse(false);
  }

}
