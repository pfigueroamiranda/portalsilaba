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
public class TbmetasxniveleducativoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbmetasxniveleducativoDTO.class);
    private Integer cosecutivo;
    private Integer meta;
    private Integer consecutivo_Tbcompetenciasareas;
    private Integer consecutivo_Tbniveleducativo;

    public Integer getCosecutivo() {
        return cosecutivo;
    }

    public void setCosecutivo(Integer cosecutivo) {
        this.cosecutivo = cosecutivo;
    }

    public Integer getMeta() {
        return meta;
    }

    public void setMeta(Integer meta) {
        this.meta = meta;
    }

    public Integer getConsecutivo_Tbcompetenciasareas() {
        return consecutivo_Tbcompetenciasareas;
    }

    public void setConsecutivo_Tbcompetenciasareas(
        Integer consecutivo_Tbcompetenciasareas) {
        this.consecutivo_Tbcompetenciasareas = consecutivo_Tbcompetenciasareas;
    }

    public Integer getConsecutivo_Tbniveleducativo() {
        return consecutivo_Tbniveleducativo;
    }

    public void setConsecutivo_Tbniveleducativo(
        Integer consecutivo_Tbniveleducativo) {
        this.consecutivo_Tbniveleducativo = consecutivo_Tbniveleducativo;
    }
}
