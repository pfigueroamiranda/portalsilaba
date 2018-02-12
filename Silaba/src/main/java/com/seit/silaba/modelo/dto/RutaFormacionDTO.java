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
public class RutaFormacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RutaFormacionDTO.class);
    private String codigo;
    private Integer consecutivo;
    private String descripcion;
    private String fechaCreacion;
    private String usuarioCreacion;
    private Integer consecutivo_Tbcatalogoexperienciaaprendizaje;
    private Integer consecutivo_Tbsilaber;

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

    public Integer getConsecutivo_Tbcatalogoexperienciaaprendizaje() {
        return consecutivo_Tbcatalogoexperienciaaprendizaje;
    }

    public void setConsecutivo_Tbcatalogoexperienciaaprendizaje(
        Integer consecutivo_Tbcatalogoexperienciaaprendizaje) {
        this.consecutivo_Tbcatalogoexperienciaaprendizaje = consecutivo_Tbcatalogoexperienciaaprendizaje;
    }

    public Integer getConsecutivo_Tbsilaber() {
        return consecutivo_Tbsilaber;
    }

    public void setConsecutivo_Tbsilaber(Integer consecutivo_Tbsilaber) {
        this.consecutivo_Tbsilaber = consecutivo_Tbsilaber;
    }
}
