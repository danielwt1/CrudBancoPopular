package com.crud.bancopopular.crudbancopopular.model;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "cliente", indexes = @Index(columnList = "clienteId"))
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "fecha")
    private LocalDate fecha;


    @Column(name = "monto")
    private Long monto;

    @Column(name = "clienteId")
    private Integer idCliente ;

    public Cliente() {
    }

    public Cliente(Integer id, Integer estado, LocalDate fecha, Long monto, Integer idCliente) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
        this.monto = monto;
        this.idCliente = idCliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public Integer getId_cliente() {
        return idCliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.idCliente = id_cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(estado, cliente.estado) && Objects.equals(fecha, cliente.fecha) && Objects.equals(monto, cliente.monto) && Objects.equals(idCliente, cliente.idCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estado, fecha, monto, idCliente);
    }
}
