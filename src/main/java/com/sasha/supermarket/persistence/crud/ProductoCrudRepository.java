package com.sasha.supermarket.persistence.crud;

import com.sasha.supermarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Solo hay que definirle al CrudRepository la clase (Producto) y el tipo de dato que es su clave primaria (Integer).
public interface ProductoCrudRepository extends CrudRepository <Producto, Integer> {
  List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

  Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
