package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbcatalogoexperienciaaprendizaje;
import com.seit.silaba.modelo.dto.TbcatalogoexperienciaaprendizajeDTO;

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
public interface ITbcatalogoexperienciaaprendizajeLogic {
    public List<Tbcatalogoexperienciaaprendizaje> getTbcatalogoexperienciaaprendizaje()
        throws Exception;

    /**
         * Save an new Tbcatalogoexperienciaaprendizaje entity
         */
    public void saveTbcatalogoexperienciaaprendizaje(
        Tbcatalogoexperienciaaprendizaje entity) throws Exception;

    /**
         * Delete an existing Tbcatalogoexperienciaaprendizaje entity
         *
         */
    public void deleteTbcatalogoexperienciaaprendizaje(
        Tbcatalogoexperienciaaprendizaje entity) throws Exception;

    /**
        * Update an existing Tbcatalogoexperienciaaprendizaje entity
        *
        */
    public void updateTbcatalogoexperienciaaprendizaje(
        Tbcatalogoexperienciaaprendizaje entity) throws Exception;

    /**
         * Load an existing Tbcatalogoexperienciaaprendizaje entity
         *
         */
    public Tbcatalogoexperienciaaprendizaje getTbcatalogoexperienciaaprendizaje(
        Integer consecutivo) throws Exception;

    public List<Tbcatalogoexperienciaaprendizaje> findByCriteria(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbcatalogoexperienciaaprendizaje> findPageTbcatalogoexperienciaaprendizaje(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbcatalogoexperienciaaprendizaje()
        throws Exception;

    public List<TbcatalogoexperienciaaprendizajeDTO> getDataTbcatalogoexperienciaaprendizaje()
        throws Exception;
}
