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
public class TbestimulosdidacticossilaberxcompetenciasDTO
    implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbestimulosdidacticossilaberxcompetenciasDTO.class);
    private Integer consecutivo;
    private Integer consecutivo_Tbelementosdidacticos;
    private Integer consecutivo_Tbmapacompetenciassilaber;

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Integer getConsecutivo_Tbelementosdidacticos() {
        return consecutivo_Tbelementosdidacticos;
    }

    public void setConsecutivo_Tbelementosdidacticos(
        Integer consecutivo_Tbelementosdidacticos) {
        this.consecutivo_Tbelementosdidacticos = consecutivo_Tbelementosdidacticos;
    }

    public Integer getConsecutivo_Tbmapacompetenciassilaber() {
        return consecutivo_Tbmapacompetenciassilaber;
    }

    public void setConsecutivo_Tbmapacompetenciassilaber(
        Integer consecutivo_Tbmapacompetenciassilaber) {
        this.consecutivo_Tbmapacompetenciassilaber = consecutivo_Tbmapacompetenciassilaber;
    }
}
