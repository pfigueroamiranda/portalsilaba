package com.seit.silaba.modelo;
// Generated 19-jul-2017 6:40:16 by Hibernate Tools 4.3.1.Final


import java.util.HashSet;
import java.util.Set;

/**
 * Tbniveleducativo generated by hbm2java
 */
public class Tbniveleducativo  implements java.io.Serializable {


     private Integer consecutivo;
     private String descripcion;
     private Set<Tbmetasxniveleducativo> tbmetasxniveleducativos = new HashSet<Tbmetasxniveleducativo>(0);

    public Tbniveleducativo() {
    }

	
    public Tbniveleducativo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }
    public Tbniveleducativo(Integer consecutivo, String descripcion, Set<Tbmetasxniveleducativo> tbmetasxniveleducativos) {
       this.consecutivo = consecutivo;
       this.descripcion = descripcion;
       this.tbmetasxniveleducativos = tbmetasxniveleducativos;
    }
   
    public Integer getConsecutivo() {
        return this.consecutivo;
    }
    
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set<Tbmetasxniveleducativo> getTbmetasxniveleducativos() {
        return this.tbmetasxniveleducativos;
    }
    
    public void setTbmetasxniveleducativos(Set<Tbmetasxniveleducativo> tbmetasxniveleducativos) {
        this.tbmetasxniveleducativos = tbmetasxniveleducativos;
    }




}


