package com.seit.silaba.modelo;
// Generated 19-jul-2017 6:40:16 by Hibernate Tools 4.3.1.Final


import java.util.HashSet;
import java.util.Set;

/**
 * Tbcompetenciaspuntossilaba generated by hbm2java
 */
public class Tbcompetenciaspuntossilaba  implements java.io.Serializable {


     private Integer consecutivo;
     private Tbcatalogocompetencias tbcatalogocompetencias;
     private Tbcatalogopuntossilaba tbcatalogopuntossilaba;
     private Set<Tbmapacompetenciassilaber> tbmapacompetenciassilabers = new HashSet<Tbmapacompetenciassilaber>(0);

    public Tbcompetenciaspuntossilaba() {
    }

	
    public Tbcompetenciaspuntossilaba(Integer consecutivo, Tbcatalogocompetencias tbcatalogocompetencias, Tbcatalogopuntossilaba tbcatalogopuntossilaba) {
        this.consecutivo = consecutivo;
        this.tbcatalogocompetencias = tbcatalogocompetencias;
        this.tbcatalogopuntossilaba = tbcatalogopuntossilaba;
    }
    public Tbcompetenciaspuntossilaba(Integer consecutivo, Tbcatalogocompetencias tbcatalogocompetencias, Tbcatalogopuntossilaba tbcatalogopuntossilaba, Set<Tbmapacompetenciassilaber> tbmapacompetenciassilabers) {
       this.consecutivo = consecutivo;
       this.tbcatalogocompetencias = tbcatalogocompetencias;
       this.tbcatalogopuntossilaba = tbcatalogopuntossilaba;
       this.tbmapacompetenciassilabers = tbmapacompetenciassilabers;
    }
   
    public Integer getConsecutivo() {
        return this.consecutivo;
    }
    
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }
    public Tbcatalogocompetencias getTbcatalogocompetencias() {
        return this.tbcatalogocompetencias;
    }
    
    public void setTbcatalogocompetencias(Tbcatalogocompetencias tbcatalogocompetencias) {
        this.tbcatalogocompetencias = tbcatalogocompetencias;
    }
    public Tbcatalogopuntossilaba getTbcatalogopuntossilaba() {
        return this.tbcatalogopuntossilaba;
    }
    
    public void setTbcatalogopuntossilaba(Tbcatalogopuntossilaba tbcatalogopuntossilaba) {
        this.tbcatalogopuntossilaba = tbcatalogopuntossilaba;
    }
    public Set<Tbmapacompetenciassilaber> getTbmapacompetenciassilabers() {
        return this.tbmapacompetenciassilabers;
    }
    
    public void setTbmapacompetenciassilabers(Set<Tbmapacompetenciassilaber> tbmapacompetenciassilabers) {
        this.tbmapacompetenciassilabers = tbmapacompetenciassilabers;
    }




}


