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
public class TbprogramacionexperienciasilaberDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbprogramacionexperienciasilaberDTO.class);
    private Integer consecutivo;
    private Date fechaProgramacion;
    private Integer consecutivo_Tbcontenidosilaber;
    private Integer consecutivo_Tbsilaber;

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Date getFechaProgramacion() {
        return fechaProgramacion;
    }

    public void setFechaProgramacion(Date fechaProgramacion) {
        this.fechaProgramacion = fechaProgramacion;
    }

    public Integer getConsecutivo_Tbcontenidosilaber() {
        return consecutivo_Tbcontenidosilaber;
    }

    public void setConsecutivo_Tbcontenidosilaber(
        Integer consecutivo_Tbcontenidosilaber) {
        this.consecutivo_Tbcontenidosilaber = consecutivo_Tbcontenidosilaber;
    }

    public Integer getConsecutivo_Tbsilaber() {
        return consecutivo_Tbsilaber;
    }

    public void setConsecutivo_Tbsilaber(Integer consecutivo_Tbsilaber) {
        this.consecutivo_Tbsilaber = consecutivo_Tbsilaber;
    }
}
