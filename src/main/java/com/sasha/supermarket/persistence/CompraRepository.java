package com.sasha.supermarket.persistence;

import com.sasha.supermarket.domain.Purchase;
import com.sasha.supermarket.domain.repository.PurchaseRepository;
import com.sasha.supermarket.persistence.crud.CompraCrudRepository;
import com.sasha.supermarket.persistence.entity.Compra;
import com.sasha.supermarket.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.hibernate.Hibernate.map;

@Repository
public class CompraRepository implements PurchaseRepository {
  @Autowired
  private CompraCrudRepository compraCrudRepository;

  @Autowired
  private PurchaseMapper mapper;

  @Override
  public List<Purchase> getAll() {
    return mapper.toPurchase((List<Compra>) compraCrudRepository.findAll());
  }

  @Override
  public Optional<List<Purchase>> getByClient(String clientId) {
    return compraCrudRepository.findByIdCliente(clientId)
        .map(compras -> mapper.toPurchase(compras));
  }

  @Override
  public Purchase save(Purchase purchase) {
    Compra compra = mapper.toCompra(purchase);
    compra.getProductos().forEach(producto -> producto.setCompra(compra));

    return mapper.toPurchase(compraCrudRepository.save(compra));
  }
}
