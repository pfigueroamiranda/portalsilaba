package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbrutaexperienciaaprendizaje;
import com.seit.silaba.modelo.dto.RutaFormacionDTO;
import com.seit.silaba.modelo.dto.TbrutaexperienciaaprendizajeDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ITbrutaexperienciaaprendizajeLogic {
    public List<Tbrutaexperienciaaprendizaje> getTbrutaexperienciaaprendizaje()
        throws Exception;

    /**
         * Save an new Tbrutaexperienciaaprendizaje entity
         */
    public void saveTbrutaexperienciaaprendizaje(
        Tbrutaexperienciaaprendizaje entity) throws Exception;

    /**
         * Delete an existing Tbrutaexperienciaaprendizaje entity
         *
         */
    public void deleteTbrutaexperienciaaprendizaje(
        Tbrutaexperienciaaprendizaje entity) throws Exception;

    /**
        * Update an existing Tbrutaexperienciaaprendizaje entity
        *
        */
    public void updateTbrutaexperienciaaprendizaje(
        Tbrutaexperienciaaprendizaje entity) throws Exception;

    /**
         * Load an existing Tbrutaexperienciaaprendizaje entity
         *
         */
    public Tbrutaexperienciaaprendizaje getTbrutaexperienciaaprendizaje(
        Integer consecutivo) throws Exception;

    public List<Tbrutaexperienciaaprendizaje> findByCriteria(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbrutaexperienciaaprendizaje> findPageTbrutaexperienciaaprendizaje(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbrutaexperienciaaprendizaje()
        throws Exception;

    public List<TbrutaexperienciaaprendizajeDTO> getDataTbrutaexperienciaaprendizaje()
        throws Exception;
    
    public List<Tbrutaexperienciaaprendizaje> consultarRutasFormacion(String user)
    		 throws Exception;
    public List<TbrutaexperienciaaprendizajeDTO> getDataTbrutaexperienciaaprendizaje(Integer codSilaber) throws Exception;
}
