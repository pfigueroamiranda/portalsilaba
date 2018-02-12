package com.seit.silaba.presentation.businessDelegate;

import com.seit.silaba.modelo.Tbcatalogoareas;
import com.seit.silaba.modelo.Tbcatalogocompetencias;
import com.seit.silaba.modelo.Tbcatalogoexperienciaaprendizaje;
import com.seit.silaba.modelo.Tbcatalogopuntossilaba;
import com.seit.silaba.modelo.Tbcompetenciasareas;
import com.seit.silaba.modelo.Tbcompetenciaspuntossilaba;
import com.seit.silaba.modelo.Tbcontenidosilaber;
import com.seit.silaba.modelo.Tbelementosdidacticos;
import com.seit.silaba.modelo.Tbestimulosdidacticossilaberxcompetencias;
import com.seit.silaba.modelo.Tbexperienciapuntos;
import com.seit.silaba.modelo.Tbmapacompetenciassilaber;
import com.seit.silaba.modelo.Tbmetasxniveleducativo;
import com.seit.silaba.modelo.Tbniveleducativo;
import com.seit.silaba.modelo.Tbprogramacionexperienciasilaber;
import com.seit.silaba.modelo.Tbrutaexperienciaaprendizaje;
import com.seit.silaba.modelo.Tbsilaber;
import com.seit.silaba.modelo.Tbsocio;
import com.seit.silaba.modelo.Tbsociospuntosilaba;
import com.seit.silaba.modelo.Tbtemasareas;
import com.seit.silaba.modelo.control.ITbcatalogoareasLogic;
import com.seit.silaba.modelo.control.ITbcatalogocompetenciasLogic;
import com.seit.silaba.modelo.control.ITbcatalogoexperienciaaprendizajeLogic;
import com.seit.silaba.modelo.control.ITbcatalogopuntossilabaLogic;
import com.seit.silaba.modelo.control.ITbcompetenciasareasLogic;
import com.seit.silaba.modelo.control.ITbcompetenciaspuntossilabaLogic;
import com.seit.silaba.modelo.control.ITbcontenidosilaberLogic;
import com.seit.silaba.modelo.control.ITbelementosdidacticosLogic;
import com.seit.silaba.modelo.control.ITbestimulosdidacticossilaberxcompetenciasLogic;
import com.seit.silaba.modelo.control.ITbexperienciapuntosLogic;
import com.seit.silaba.modelo.control.ITbmapacompetenciassilaberLogic;
import com.seit.silaba.modelo.control.ITbmetasxniveleducativoLogic;
import com.seit.silaba.modelo.control.ITbniveleducativoLogic;
import com.seit.silaba.modelo.control.ITbprogramacionexperienciasilaberLogic;
import com.seit.silaba.modelo.control.ITbrutaexperienciaaprendizajeLogic;
import com.seit.silaba.modelo.control.ITbsilaberLogic;
import com.seit.silaba.modelo.control.ITbsocioLogic;
import com.seit.silaba.modelo.control.ITbsociospuntosilabaLogic;
import com.seit.silaba.modelo.control.ITbtemasareasLogic;
import com.seit.silaba.modelo.control.TbcatalogoareasLogic;
import com.seit.silaba.modelo.control.TbcatalogocompetenciasLogic;
import com.seit.silaba.modelo.control.TbcatalogoexperienciaaprendizajeLogic;
import com.seit.silaba.modelo.control.TbcatalogopuntossilabaLogic;
import com.seit.silaba.modelo.control.TbcompetenciasareasLogic;
import com.seit.silaba.modelo.control.TbcompetenciaspuntossilabaLogic;
import com.seit.silaba.modelo.control.TbcontenidosilaberLogic;
import com.seit.silaba.modelo.control.TbelementosdidacticosLogic;
import com.seit.silaba.modelo.control.TbestimulosdidacticossilaberxcompetenciasLogic;
import com.seit.silaba.modelo.control.TbexperienciapuntosLogic;
import com.seit.silaba.modelo.control.TbmapacompetenciassilaberLogic;
import com.seit.silaba.modelo.control.TbmetasxniveleducativoLogic;
import com.seit.silaba.modelo.control.TbniveleducativoLogic;
import com.seit.silaba.modelo.control.TbprogramacionexperienciasilaberLogic;
import com.seit.silaba.modelo.control.TbrutaexperienciaaprendizajeLogic;
import com.seit.silaba.modelo.control.TbsilaberLogic;
import com.seit.silaba.modelo.control.TbsocioLogic;
import com.seit.silaba.modelo.control.TbsociospuntosilabaLogic;
import com.seit.silaba.modelo.control.TbtemasareasLogic;
import com.seit.silaba.modelo.dto.RutaFormacionDTO;
import com.seit.silaba.modelo.dto.TbcatalogoareasDTO;
import com.seit.silaba.modelo.dto.TbcatalogocompetenciasDTO;
import com.seit.silaba.modelo.dto.TbcatalogoexperienciaaprendizajeDTO;
import com.seit.silaba.modelo.dto.TbcatalogopuntossilabaDTO;
import com.seit.silaba.modelo.dto.TbcompetenciasareasDTO;
import com.seit.silaba.modelo.dto.TbcompetenciaspuntossilabaDTO;
import com.seit.silaba.modelo.dto.TbcontenidosilaberDTO;
import com.seit.silaba.modelo.dto.TbelementosdidacticosDTO;
import com.seit.silaba.modelo.dto.TbestimulosdidacticossilaberxcompetenciasDTO;
import com.seit.silaba.modelo.dto.TbexperienciapuntosDTO;
import com.seit.silaba.modelo.dto.TbmapacompetenciassilaberDTO;
import com.seit.silaba.modelo.dto.TbmetasxniveleducativoDTO;
import com.seit.silaba.modelo.dto.TbniveleducativoDTO;
import com.seit.silaba.modelo.dto.TbprogramacionexperienciasilaberDTO;
import com.seit.silaba.modelo.dto.TbrutaexperienciaaprendizajeDTO;
import com.seit.silaba.modelo.dto.TbsilaberDTO;
import com.seit.silaba.modelo.dto.TbsocioDTO;
import com.seit.silaba.modelo.dto.TbsociospuntosilabaDTO;
import com.seit.silaba.modelo.dto.TbtemasareasDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Tbcatalogoareas> getTbcatalogoareas() throws Exception;

    public void saveTbcatalogoareas(Tbcatalogoareas entity)
        throws Exception;

    public void deleteTbcatalogoareas(Tbcatalogoareas entity)
        throws Exception;

    public void updateTbcatalogoareas(Tbcatalogoareas entity)
        throws Exception;

    public Tbcatalogoareas getTbcatalogoareas(Integer consecutivo)
        throws Exception;

    public List<Tbcatalogoareas> findByCriteriaInTbcatalogoareas(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbcatalogoareas> findPageTbcatalogoareas(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbcatalogoareas() throws Exception;

    public List<TbcatalogoareasDTO> getDataTbcatalogoareas()
        throws Exception;

    public List<Tbcatalogocompetencias> getTbcatalogocompetencias()
        throws Exception;

    public void saveTbcatalogocompetencias(Tbcatalogocompetencias entity)
        throws Exception;

    public void deleteTbcatalogocompetencias(Tbcatalogocompetencias entity)
        throws Exception;

    public void updateTbcatalogocompetencias(Tbcatalogocompetencias entity)
        throws Exception;

    public Tbcatalogocompetencias getTbcatalogocompetencias(Integer consecutivo)
        throws Exception;

    public List<Tbcatalogocompetencias> findByCriteriaInTbcatalogocompetencias(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbcatalogocompetencias> findPageTbcatalogocompetencias(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbcatalogocompetencias()
        throws Exception;

    public List<TbcatalogocompetenciasDTO> getDataTbcatalogocompetencias()
        throws Exception;

    public List<Tbcatalogoexperienciaaprendizaje> getTbcatalogoexperienciaaprendizaje()
        throws Exception;

    public void saveTbcatalogoexperienciaaprendizaje(
        Tbcatalogoexperienciaaprendizaje entity) throws Exception;

    public void deleteTbcatalogoexperienciaaprendizaje(
        Tbcatalogoexperienciaaprendizaje entity) throws Exception;

    public void updateTbcatalogoexperienciaaprendizaje(
        Tbcatalogoexperienciaaprendizaje entity) throws Exception;

    public Tbcatalogoexperienciaaprendizaje getTbcatalogoexperienciaaprendizaje(
        Integer consecutivo) throws Exception;

    public List<Tbcatalogoexperienciaaprendizaje> findByCriteriaInTbcatalogoexperienciaaprendizaje(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbcatalogoexperienciaaprendizaje> findPageTbcatalogoexperienciaaprendizaje(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbcatalogoexperienciaaprendizaje()
        throws Exception;

    public List<TbcatalogoexperienciaaprendizajeDTO> getDataTbcatalogoexperienciaaprendizaje()
        throws Exception;

    public List<Tbcatalogopuntossilaba> getTbcatalogopuntossilaba()
        throws Exception;

    public void saveTbcatalogopuntossilaba(Tbcatalogopuntossilaba entity)
        throws Exception;

    public void deleteTbcatalogopuntossilaba(Tbcatalogopuntossilaba entity)
        throws Exception;

    public void updateTbcatalogopuntossilaba(Tbcatalogopuntossilaba entity)
        throws Exception;

    public Tbcatalogopuntossilaba getTbcatalogopuntossilaba(Integer consecutivo)
        throws Exception;

    public List<Tbcatalogopuntossilaba> findByCriteriaInTbcatalogopuntossilaba(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbcatalogopuntossilaba> findPageTbcatalogopuntossilaba(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbcatalogopuntossilaba()
        throws Exception;

    public List<TbcatalogopuntossilabaDTO> getDataTbcatalogopuntossilaba()
        throws Exception;

    public List<Tbcompetenciasareas> getTbcompetenciasareas()
        throws Exception;

    public void saveTbcompetenciasareas(Tbcompetenciasareas entity)
        throws Exception;

    public void deleteTbcompetenciasareas(Tbcompetenciasareas entity)
        throws Exception;

    public void updateTbcompetenciasareas(Tbcompetenciasareas entity)
        throws Exception;

    public Tbcompetenciasareas getTbcompetenciasareas(Integer consecutivo)
        throws Exception;

    public List<Tbcompetenciasareas> findByCriteriaInTbcompetenciasareas(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbcompetenciasareas> findPageTbcompetenciasareas(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbcompetenciasareas() throws Exception;

    public List<TbcompetenciasareasDTO> getDataTbcompetenciasareas()
        throws Exception;

    public List<Tbcompetenciaspuntossilaba> getTbcompetenciaspuntossilaba()
        throws Exception;

    public void saveTbcompetenciaspuntossilaba(
        Tbcompetenciaspuntossilaba entity) throws Exception;

    public void deleteTbcompetenciaspuntossilaba(
        Tbcompetenciaspuntossilaba entity) throws Exception;

    public void updateTbcompetenciaspuntossilaba(
        Tbcompetenciaspuntossilaba entity) throws Exception;

    public Tbcompetenciaspuntossilaba getTbcompetenciaspuntossilaba(
        Integer consecutivo) throws Exception;

    public List<Tbcompetenciaspuntossilaba> findByCriteriaInTbcompetenciaspuntossilaba(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbcompetenciaspuntossilaba> findPageTbcompetenciaspuntossilaba(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbcompetenciaspuntossilaba()
        throws Exception;

    public List<TbcompetenciaspuntossilabaDTO> getDataTbcompetenciaspuntossilaba()
        throws Exception;

    public List<Tbcontenidosilaber> getTbcontenidosilaber()
        throws Exception;

    public void saveTbcontenidosilaber(Tbcontenidosilaber entity)
        throws Exception;

    public void deleteTbcontenidosilaber(Tbcontenidosilaber entity)
        throws Exception;

    public void updateTbcontenidosilaber(Tbcontenidosilaber entity)
        throws Exception;

    public Tbcontenidosilaber getTbcontenidosilaber(Integer consecutivo)
        throws Exception;

    public List<Tbcontenidosilaber> findByCriteriaInTbcontenidosilaber(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbcontenidosilaber> findPageTbcontenidosilaber(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbcontenidosilaber() throws Exception;

    public List<TbcontenidosilaberDTO> getDataTbcontenidosilaber()
        throws Exception;

    public List<Tbelementosdidacticos> getTbelementosdidacticos()
        throws Exception;

    public void saveTbelementosdidacticos(Tbelementosdidacticos entity)
        throws Exception;

    public void deleteTbelementosdidacticos(Tbelementosdidacticos entity)
        throws Exception;

    public void updateTbelementosdidacticos(Tbelementosdidacticos entity)
        throws Exception;

    public Tbelementosdidacticos getTbelementosdidacticos(Integer consecutivo)
        throws Exception;

    public List<Tbelementosdidacticos> findByCriteriaInTbelementosdidacticos(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbelementosdidacticos> findPageTbelementosdidacticos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbelementosdidacticos()
        throws Exception;

    public List<TbelementosdidacticosDTO> getDataTbelementosdidacticos()
        throws Exception;

    public List<Tbestimulosdidacticossilaberxcompetencias> getTbestimulosdidacticossilaberxcompetencias()
        throws Exception;

    public void saveTbestimulosdidacticossilaberxcompetencias(
        Tbestimulosdidacticossilaberxcompetencias entity)
        throws Exception;

    public void deleteTbestimulosdidacticossilaberxcompetencias(
        Tbestimulosdidacticossilaberxcompetencias entity)
        throws Exception;

    public void updateTbestimulosdidacticossilaberxcompetencias(
        Tbestimulosdidacticossilaberxcompetencias entity)
        throws Exception;

    public Tbestimulosdidacticossilaberxcompetencias getTbestimulosdidacticossilaberxcompetencias(
        Integer consecutivo) throws Exception;

    public List<Tbestimulosdidacticossilaberxcompetencias> findByCriteriaInTbestimulosdidacticossilaberxcompetencias(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbestimulosdidacticossilaberxcompetencias> findPageTbestimulosdidacticossilaberxcompetencias(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbestimulosdidacticossilaberxcompetencias()
        throws Exception;

    public List<TbestimulosdidacticossilaberxcompetenciasDTO> getDataTbestimulosdidacticossilaberxcompetencias()
        throws Exception;

    public List<Tbexperienciapuntos> getTbexperienciapuntos()
        throws Exception;

    public void saveTbexperienciapuntos(Tbexperienciapuntos entity)
        throws Exception;

    public void deleteTbexperienciapuntos(Tbexperienciapuntos entity)
        throws Exception;

    public void updateTbexperienciapuntos(Tbexperienciapuntos entity)
        throws Exception;

    public Tbexperienciapuntos getTbexperienciapuntos(Integer consecutivo)
        throws Exception;

    public List<Tbexperienciapuntos> findByCriteriaInTbexperienciapuntos(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbexperienciapuntos> findPageTbexperienciapuntos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbexperienciapuntos() throws Exception;

    public List<TbexperienciapuntosDTO> getDataTbexperienciapuntos()
        throws Exception;

    public List<Tbmapacompetenciassilaber> getTbmapacompetenciassilaber()
        throws Exception;

    public void saveTbmapacompetenciassilaber(Tbmapacompetenciassilaber entity)
        throws Exception;

    public void deleteTbmapacompetenciassilaber(
        Tbmapacompetenciassilaber entity) throws Exception;

    public void updateTbmapacompetenciassilaber(
        Tbmapacompetenciassilaber entity) throws Exception;

    public Tbmapacompetenciassilaber getTbmapacompetenciassilaber(
        Integer consecutivo) throws Exception;

    public List<Tbmapacompetenciassilaber> findByCriteriaInTbmapacompetenciassilaber(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbmapacompetenciassilaber> findPageTbmapacompetenciassilaber(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbmapacompetenciassilaber()
        throws Exception;

    public List<TbmapacompetenciassilaberDTO> getDataTbmapacompetenciassilaber()
        throws Exception;

    public List<Tbmetasxniveleducativo> getTbmetasxniveleducativo()
        throws Exception;

    public void saveTbmetasxniveleducativo(Tbmetasxniveleducativo entity)
        throws Exception;

    public void deleteTbmetasxniveleducativo(Tbmetasxniveleducativo entity)
        throws Exception;

    public void updateTbmetasxniveleducativo(Tbmetasxniveleducativo entity)
        throws Exception;

    public Tbmetasxniveleducativo getTbmetasxniveleducativo(Integer cosecutivo)
        throws Exception;

    public List<Tbmetasxniveleducativo> findByCriteriaInTbmetasxniveleducativo(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbmetasxniveleducativo> findPageTbmetasxniveleducativo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbmetasxniveleducativo()
        throws Exception;

    public List<TbmetasxniveleducativoDTO> getDataTbmetasxniveleducativo()
        throws Exception;

    public List<Tbniveleducativo> getTbniveleducativo()
        throws Exception;

    public void saveTbniveleducativo(Tbniveleducativo entity)
        throws Exception;

    public void deleteTbniveleducativo(Tbniveleducativo entity)
        throws Exception;

    public void updateTbniveleducativo(Tbniveleducativo entity)
        throws Exception;

    public Tbniveleducativo getTbniveleducativo(Integer consecutivo)
        throws Exception;

    public List<Tbniveleducativo> findByCriteriaInTbniveleducativo(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbniveleducativo> findPageTbniveleducativo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbniveleducativo() throws Exception;

    public List<TbniveleducativoDTO> getDataTbniveleducativo()
        throws Exception;

    public List<Tbprogramacionexperienciasilaber> getTbprogramacionexperienciasilaber()
        throws Exception;

    public void saveTbprogramacionexperienciasilaber(
        Tbprogramacionexperienciasilaber entity) throws Exception;

    public void deleteTbprogramacionexperienciasilaber(
        Tbprogramacionexperienciasilaber entity) throws Exception;

    public void updateTbprogramacionexperienciasilaber(
        Tbprogramacionexperienciasilaber entity) throws Exception;

    public Tbprogramacionexperienciasilaber getTbprogramacionexperienciasilaber(
        Integer consecutivo) throws Exception;

    public List<Tbprogramacionexperienciasilaber> findByCriteriaInTbprogramacionexperienciasilaber(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbprogramacionexperienciasilaber> findPageTbprogramacionexperienciasilaber(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbprogramacionexperienciasilaber()
        throws Exception;

    public List<TbprogramacionexperienciasilaberDTO> getDataTbprogramacionexperienciasilaber()
        throws Exception;

    public List<Tbrutaexperienciaaprendizaje> getTbrutaexperienciaaprendizaje()
        throws Exception;

    public void saveTbrutaexperienciaaprendizaje(
        Tbrutaexperienciaaprendizaje entity) throws Exception;

    public void deleteTbrutaexperienciaaprendizaje(
        Tbrutaexperienciaaprendizaje entity) throws Exception;

    public void updateTbrutaexperienciaaprendizaje(
        Tbrutaexperienciaaprendizaje entity) throws Exception;

    public Tbrutaexperienciaaprendizaje getTbrutaexperienciaaprendizaje(
        Integer consecutivo) throws Exception;

    public List<Tbrutaexperienciaaprendizaje> findByCriteriaInTbrutaexperienciaaprendizaje(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbrutaexperienciaaprendizaje> findPageTbrutaexperienciaaprendizaje(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbrutaexperienciaaprendizaje()
        throws Exception;

    public List<TbrutaexperienciaaprendizajeDTO> getDataTbrutaexperienciaaprendizaje()
        throws Exception;

    public List<Tbsilaber> getTbsilaber() throws Exception;

    public void saveTbsilaber(Tbsilaber entity) throws Exception;

    public void deleteTbsilaber(Tbsilaber entity) throws Exception;

    public void updateTbsilaber(Tbsilaber entity) throws Exception;

    public Tbsilaber getTbsilaber(Integer consecutivo)
        throws Exception;

    public List<Tbsilaber> findByCriteriaInTbsilaber(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbsilaber> findPageTbsilaber(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTbsilaber() throws Exception;

    public List<TbsilaberDTO> getDataTbsilaber() throws Exception;

    public List<Tbsocio> getTbsocio() throws Exception;

    public void saveTbsocio(Tbsocio entity) throws Exception;

    public void deleteTbsocio(Tbsocio entity) throws Exception;

    public void updateTbsocio(Tbsocio entity) throws Exception;

    public Tbsocio getTbsocio(Integer consecutivo) throws Exception;

    public List<Tbsocio> findByCriteriaInTbsocio(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbsocio> findPageTbsocio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTbsocio() throws Exception;

    public List<TbsocioDTO> getDataTbsocio() throws Exception;

    public List<Tbsociospuntosilaba> getTbsociospuntosilaba()
        throws Exception;

    public void saveTbsociospuntosilaba(Tbsociospuntosilaba entity)
        throws Exception;

    public void deleteTbsociospuntosilaba(Tbsociospuntosilaba entity)
        throws Exception;

    public void updateTbsociospuntosilaba(Tbsociospuntosilaba entity)
        throws Exception;

    public Tbsociospuntosilaba getTbsociospuntosilaba(Integer consecutivo)
        throws Exception;

    public List<Tbsociospuntosilaba> findByCriteriaInTbsociospuntosilaba(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbsociospuntosilaba> findPageTbsociospuntosilaba(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbsociospuntosilaba() throws Exception;

    public List<TbsociospuntosilabaDTO> getDataTbsociospuntosilaba()
        throws Exception;

    public List<Tbtemasareas> getTbtemasareas() throws Exception;

    public void saveTbtemasareas(Tbtemasareas entity) throws Exception;

    public void deleteTbtemasareas(Tbtemasareas entity)
        throws Exception;

    public void updateTbtemasareas(Tbtemasareas entity)
        throws Exception;

    public Tbtemasareas getTbtemasareas(Integer consecutivo)
        throws Exception;

    public List<Tbtemasareas> findByCriteriaInTbtemasareas(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbtemasareas> findPageTbtemasareas(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTbtemasareas() throws Exception;

    public List<TbtemasareasDTO> getDataTbtemasareas()
        throws Exception;
    public List<Tbrutaexperienciaaprendizaje> consultarRutasFormacion(String user) throws Exception;
    public List<TbrutaexperienciaaprendizajeDTO> getDataTbrutaexperienciaaprendizaje(Integer codSilaber)
            throws Exception;
}
