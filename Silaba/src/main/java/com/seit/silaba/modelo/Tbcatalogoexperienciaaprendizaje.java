package com.seit.silaba.modelo;
// Generated 19-jul-2017 6:40:16 by Hibernate Tools 4.3.1.Final


import java.util.HashSet;
import java.util.Set;

/**
 * Tbcatalogoexperienciaaprendizaje generated by hbm2java
 */
public class Tbcatalogoexperienciaaprendizaje  implements java.io.Serializable {


     private Integer consecutivo;
     private Tbcatalogoexperienciaaprendizaje tbcatalogoexperienciaaprendizaje;
     private String codigo;
     private String descripcion;
     private String fechaCreacion;
     private String usuarioCreacion;
     private Set<Tbexperienciapuntos> tbexperienciapuntoses = new HashSet<Tbexperienciapuntos>(0);
    // private Set<Tbcatalogoexperienciaaprendizaje> tbcatalogoexperienciaaprendizajes = new HashSet<Tbcatalogoexperienciaaprendizaje>(0);
     private Set<Tbrutaexperienciaaprendizaje> tbrutaexperienciaaprendizajes = new HashSet<Tbrutaexperienciaaprendizaje>(0);

    public Tbcatalogoexperienciaaprendizaje() {
    }

	
    public Tbcatalogoexperienciaaprendizaje(Integer consecutivo, Tbcatalogoexperienciaaprendizaje tbcatalogoexperienciaaprendizaje) {
        this.consecutivo = consecutivo;
        this.tbcatalogoexperienciaaprendizaje = tbcatalogoexperienciaaprendizaje;
    }
    public Tbcatalogoexperienciaaprendizaje(Integer consecutivo, Tbcatalogoexperienciaaprendizaje tbcatalogoexperienciaaprendizaje, String codigo, String descripcion, String fechaCreacion, String usuarioCreacion, Set<Tbexperienciapuntos> tbexperienciapuntoses, Set<Tbcatalogoexperienciaaprendizaje> tbcatalogoexperienciaaprendizajes, Set<Tbrutaexperienciaaprendizaje> tbrutaexperienciaaprendizajes) {
       this.consecutivo = consecutivo;
       this.tbcatalogoexperienciaaprendizaje = tbcatalogoexperienciaaprendizaje;
       this.codigo = codigo;
       this.descripcion = descripcion;
       this.fechaCreacion = fechaCreacion;
       this.usuarioCreacion = usuarioCreacion;
       this.tbexperienciapuntoses = tbexperienciapuntoses;
       //this.tbcatalogoexperienciaaprendizajes = tbcatalogoexperienciaaprendizajes;
       this.tbrutaexperienciaaprendizajes = tbrutaexperienciaaprendizajes;
    }
   
    public Integer getConsecutivo() {
        return this.consecutivo;
    }
    
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }
    public Tbcatalogoexperienciaaprendizaje getTbcatalogoexperienciaaprendizaje() {
        return this.tbcatalogoexperienciaaprendizaje;
    }
    
    public void setTbcatalogoexperienciaaprendizaje(Tbcatalogoexperienciaaprendizaje tbcatalogoexperienciaaprendizaje) {
        this.tbcatalogoexperienciaaprendizaje = tbcatalogoexperienciaaprendizaje;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getUsuarioCreacion() {
        return this.usuarioCreacion;
    }
    
    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
    public Set<Tbexperienciapuntos> getTbexperienciapuntoses() {
        return this.tbexperienciapuntoses;
    }
    
    public void setTbexperienciapuntoses(Set<Tbexperienciapuntos> tbexperienciapuntoses) {
        this.tbexperienciapuntoses = tbexperienciapuntoses;
    }
    /*public Set<Tbcatalogoexperienciaaprendizaje> getTbcatalogoexperienciaaprendizajes() {
        return this.tbcatalogoexperienciaaprendizajes;
    }
    
    public void setTbcatalogoexperienciaaprendizajes(Set<Tbcatalogoexperienciaaprendizaje> tbcatalogoexperienciaaprendizajes) {
        this.tbcatalogoexperienciaaprendizajes = tbcatalogoexperienciaaprendizajes;
    }*/
    public Set<Tbrutaexperienciaaprendizaje> getTbrutaexperienciaaprendizajes() {
        return this.tbrutaexperienciaaprendizajes;
    }
    
    public void setTbrutaexperienciaaprendizajes(Set<Tbrutaexperienciaaprendizaje> tbrutaexperienciaaprendizajes) {
        this.tbrutaexperienciaaprendizajes = tbrutaexperienciaaprendizajes;
    }




}


