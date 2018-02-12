package com.seit.silaba.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public class TbelementosdidacticosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbelementosdidacticosDTO.class);
    private Integer cantidad;
    private Integer consecutivo;
    private String descripcion;
    private Integer consecutivo_Tbsocio;

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getConsecutivo_Tbsocio() {
        return consecutivo_Tbsocio;
    }

    public void setConsecutivo_Tbsocio(Integer consecutivo_Tbsocio) {
        this.consecutivo_Tbsocio = consecutivo_Tbsocio;
    }
}
