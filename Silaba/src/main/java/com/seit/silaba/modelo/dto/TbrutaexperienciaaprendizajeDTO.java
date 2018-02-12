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
public class TbrutaexperienciaaprendizajeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbrutaexperienciaaprendizajeDTO.class);
    private String codigo;
    private Integer consecutivo;
    private String descripcion;
    private String fechaCreacion;
    private String usuarioCreacion;
    private Integer consecutivo_Tbcatalogoexperienciaaprendizaje;
    private Integer consecutivo_Tbsilaber;
    
    private Integer consecutivoCtlgoPto;
    private String  descripcionCtlgoPto;
    private Date  fechaPosibleVisita;
    private Date fechaRealVisita ;
    private Integer estado;

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

	public Integer getConsecutivoCtlgoPto() {
		return consecutivoCtlgoPto;
	}

	public void setConsecutivoCtlgoPto(Integer consecutivoCtlgoPto) {
		this.consecutivoCtlgoPto = consecutivoCtlgoPto;
	}

	public String getDescripcionCtlgoPto() {
		return descripcionCtlgoPto;
	}

	public void setDescripcionCtlgoPto(String descripcionCtlgoPto) {
		this.descripcionCtlgoPto = descripcionCtlgoPto;
	}

	public Date getFechaPosibleVisita() {
		return fechaPosibleVisita;
	}

	public void setFechaPosibleVisita(Date fechaPosibleVisita) {
		this.fechaPosibleVisita = fechaPosibleVisita;
	}

	public Date getFechaRealVisita() {
		return fechaRealVisita;
	}

	public void setFechaRealVisita(Date fechaRealVisita) {
		this.fechaRealVisita = fechaRealVisita;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
    
    
}
