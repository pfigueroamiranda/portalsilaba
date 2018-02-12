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
public class TbtemasareasDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbtemasareasDTO.class);
    private String codigo;
    private Integer consecutivo;
    private String descripcion;
    private String fechaCreacion;
    private String usuarioCreacion;
    private Integer consecutivo_Tbcatalogoareas;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Integer getConsecutivo_Tbcatalogoareas() {
        return consecutivo_Tbcatalogoareas;
    }

    public void setConsecutivo_Tbcatalogoareas(
        Integer consecutivo_Tbcatalogoareas) {
        this.consecutivo_Tbcatalogoareas = consecutivo_Tbcatalogoareas;
    }
}
