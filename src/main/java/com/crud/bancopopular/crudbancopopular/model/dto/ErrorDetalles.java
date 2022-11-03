package com.crud.bancopopular.crudbancopopular.model.dto;

import java.time.LocalDateTime;

public class ErrorDetalles {
    private LocalDateTime fecha;
    private String message;
    private String ruta;

    public ErrorDetalles() {
    }

    public ErrorDetalles(LocalDateTime fecha, String message, String ruta) {
        this.fecha = fecha;
        this.message = message;
        this.ruta = ruta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
