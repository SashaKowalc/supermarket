package com.sasha.supermarket.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Compra {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_compra")
  private Integer idCompra;
  @Column(name = "id_cliente")
  private String idCliente;
  private LocalDateTime fecha;
  @Column(name = "medio_pago")
  private String medioPago;
  private String comentario;
  private String estado;
  @ManyToOne
  @JoinColumn(name = "id_cliente", insertable = false, updatable = false)//no permite crear, actualizar o borrar datos de tabla clientes
  private Cliente cliente;
  @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL})
  private List<ComprasProducto> productos;

  public Compra() {
  }

  public Compra(Integer idCompra, String idCliente, LocalDateTime fecha, String medioPago, String comentario, String estado) {
    this.idCompra = idCompra;
    this.idCliente = idCliente;
    this.fecha = fecha;
    this.medioPago = medioPago;
    this.comentario = comentario;
    this.estado = estado;
  }

  public Integer getIdCompra() {
    return idCompra;
  }

  public void setIdCompra(Integer idCompra) {
    this.idCompra = idCompra;
  }

  public String getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(String idCliente) {
    this.idCliente = idCliente;
  }

  public LocalDateTime getFecha() {
    return fecha;
  }

  public void setFecha(LocalDateTime fecha) {
    this.fecha = fecha;
  }

  public String getMedioPago() {
    return medioPago;
  }

  public void setMedioPago(String medioPago) {
    this.medioPago = medioPago;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public List<ComprasProducto> getProductos() {
    return productos;
  }

  public void setProductos(List<ComprasProducto> productos) {
    this.productos = productos;
  }
}
