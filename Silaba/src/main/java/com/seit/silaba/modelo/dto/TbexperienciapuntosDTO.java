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
public class TbexperienciapuntosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbexperienciapuntosDTO.class);
    private Integer consecutivo;
    private Integer consecutivo_Tbcatalogoexperienciaaprendizaje;
    private Integer consecutivo_Tbcatalogopuntossilaba;

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Integer getConsecutivo_Tbcatalogoexperienciaaprendizaje() {
        return consecutivo_Tbcatalogoexperienciaaprendizaje;
    }

    public void setConsecutivo_Tbcatalogoexperienciaaprendizaje(
        Integer consecutivo_Tbcatalogoexperienciaaprendizaje) {
        this.consecutivo_Tbcatalogoexperienciaaprendizaje = consecutivo_Tbcatalogoexperienciaaprendizaje;
    }

    public Integer getConsecutivo_Tbcatalogopuntossilaba() {
        return consecutivo_Tbcatalogopuntossilaba;
    }

    public void setConsecutivo_Tbcatalogopuntossilaba(
        Integer consecutivo_Tbcatalogopuntossilaba) {
        this.consecutivo_Tbcatalogopuntossilaba = consecutivo_Tbcatalogopuntossilaba;
    }
}
