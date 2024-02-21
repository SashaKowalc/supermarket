package com.sasha.supermarket.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
public class Producto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_producto")
  private Integer idProducto;
  private String nombre;
  @Column(name = "id_categoria")
  private int idCategoria;
  @Column(name = "codigo_barras")
  private String codigoBarras;
  @Column(name = "precio_venta")
  private BigDecimal precioVenta;
  @Column(name = "cantidad_stock")
  private Integer cantidadStock;
  private Boolean estado;
  @ManyToOne
  @JoinColumn(name = "id_categoria", insertable = false, updatable = false) //a traves de esta notacion no vamos a borrar ni actualizar tabla categoria
  private Categoria categoria;

  public Producto() {
  }

  public Producto(Integer idProducto, String nombre, int idCategoria, String codigoBarras, BigDecimal precioVenta, Integer cantidadStock, Boolean estado) {
    this.idProducto = idProducto;
    this.nombre = nombre;
    this.idCategoria = idCategoria;
    this.codigoBarras = codigoBarras;
    this.precioVenta = precioVenta;
    this.cantidadStock = cantidadStock;
    this.estado = estado;
  }

  public Integer getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Integer idProducto) {
    this.idProducto = idProducto;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(int idCategoria) {
    this.idCategoria = idCategoria;
  }

  public String getCodigoBarras() {
    return codigoBarras;
  }

  public void setCodigoBarras(String codigoBarras) {
    this.codigoBarras = codigoBarras;
  }

  public BigDecimal getPrecioVenta() {
    return precioVenta;
  }

  public void setPrecioVenta(BigDecimal precioVenta) {
    this.precioVenta = precioVenta;
  }

  public Integer getCantidadStock() {
    return cantidadStock;
  }

  public void setCantidadStock(Integer cantidadStock) {
    this.cantidadStock = cantidadStock;
  }

  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
    this.estado = estado;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }
}
