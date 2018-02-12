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
public class TbmapacompetenciassilaberDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbmapacompetenciassilaberDTO.class);
    private Integer consecutivo;
    private Integer consecutivo_Tbcompetenciaspuntossilaba;
    private Integer consecutivo_Tbprogramacionexperienciasilaber;

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Integer getConsecutivo_Tbcompetenciaspuntossilaba() {
        return consecutivo_Tbcompetenciaspuntossilaba;
    }

    public void setConsecutivo_Tbcompetenciaspuntossilaba(
        Integer consecutivo_Tbcompetenciaspuntossilaba) {
        this.consecutivo_Tbcompetenciaspuntossilaba = consecutivo_Tbcompetenciaspuntossilaba;
    }

    public Integer getConsecutivo_Tbprogramacionexperienciasilaber() {
        return consecutivo_Tbprogramacionexperienciasilaber;
    }

    public void setConsecutivo_Tbprogramacionexperienciasilaber(
        Integer consecutivo_Tbprogramacionexperienciasilaber) {
        this.consecutivo_Tbprogramacionexperienciasilaber = consecutivo_Tbprogramacionexperienciasilaber;
    }
}
