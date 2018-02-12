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
public class TbcompetenciasareasDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbcompetenciasareasDTO.class);
    private Integer consecutivo;
    private Integer consecutivo_Tbcatalogocompetencias;
    private Integer consecutivo_Tbtemasareas;

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

    public Integer getConsecutivo_Tbtemasareas() {
        return consecutivo_Tbtemasareas;
    }

    public void setConsecutivo_Tbtemasareas(Integer consecutivo_Tbtemasareas) {
        this.consecutivo_Tbtemasareas = consecutivo_Tbtemasareas;
    }
}
