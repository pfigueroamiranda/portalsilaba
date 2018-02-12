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
public class TbcompetenciaspuntossilabaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbcompetenciaspuntossilabaDTO.class);
    private Integer consecutivo;
    private Integer consecutivo_Tbcatalogocompetencias;
    private Integer consecutivo_Tbcatalogopuntossilaba;

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Integer getConsecutivo_Tbcatalogocompetencias() {
        return consecutivo_Tbcatalogocompetencias;
    }

    public void setConsecutivo_Tbcatalogocompetencias(
        Integer consecutivo_Tbcatalogocompetencias) {
        this.consecutivo_Tbcatalogocompetencias = consecutivo_Tbcatalogocompetencias;
    }

    public Integer getConsecutivo_Tbcatalogopuntossilaba() {
        return consecutivo_Tbcatalogopuntossilaba;
    }

    public void setConsecutivo_Tbcatalogopuntossilaba(
        Integer consecutivo_Tbcatalogopuntossilaba) {
        this.consecutivo_Tbcatalogopuntossilaba = consecutivo_Tbcatalogopuntossilaba;
    }
}
