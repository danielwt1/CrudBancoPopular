package com.crud.bancopopular.crudbancopopular.model.dto;


import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;

import java.time.LocalDate;

public class ClienteDTO {
    private Integer id;
    @NotNull
    @Min(1)
    private Integer estado;

    @NotNull
    private LocalDate fecha;
    @NotNull

    @Min(1000000)
    private Long monto;
    @NotNull
    @Min(1)
    private Integer id_cliente;

    public ClienteDTO() {
    }

    public ClienteDTO(Integer id, Integer estado, LocalDate fecha, Long monto, Integer id_cliente) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
        this.monto = monto;
        this.id_cliente = id_cliente;
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
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }
}
