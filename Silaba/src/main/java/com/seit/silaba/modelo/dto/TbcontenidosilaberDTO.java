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
public class TbcontenidosilaberDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbcontenidosilaberDTO.class);
    private Integer consecutivo;
    private String descripcion;
    private Date fechaCreacion;
    private String observacion;
    private String url;
    private String usuarioCreacion;
    private Integer consecutivo_Tbcatalogopuntossilaba;

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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Integer getConsecutivo_Tbcatalogopuntossilaba() {
        return consecutivo_Tbcatalogopuntossilaba;
    }

    public void setConsecutivo_Tbcatalogopuntossilaba(
        Integer consecutivo_Tbcatalogopuntossilaba) {
        this.consecutivo_Tbcatalogopuntossilaba = consecutivo_Tbcatalogopuntossilaba;
    }
}
