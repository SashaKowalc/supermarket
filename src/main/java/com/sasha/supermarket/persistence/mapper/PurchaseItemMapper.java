package com.sasha.supermarket.persistence.mapper;

import com.sasha.supermarket.domain.PurchaseItem;
import com.sasha.supermarket.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {


  @Mapping(source = "id.idProducto" , target = "productId")
  @Mapping(source = "cantidad" , target = "quantity")
  @Mapping(source = "estado" , target = "active")
  PurchaseItem toPurchaseItem(ComprasProducto producto);

  @InheritInverseConfiguration
  @Mapping(target = "compra", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "id.idCompra", ignore = true)
  ComprasProducto toComprasProducto(PurchaseItem item);
}
