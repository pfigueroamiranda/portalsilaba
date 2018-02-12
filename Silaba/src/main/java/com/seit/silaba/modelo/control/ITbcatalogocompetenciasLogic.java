package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbcatalogocompetencias;
import com.seit.silaba.modelo.dto.TbcatalogocompetenciasDTO;

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
public interface ITbcatalogocompetenciasLogic {
    public List<Tbcatalogocompetencias> getTbcatalogocompetencias()
        throws Exception;

    /**
         * Save an new Tbcatalogocompetencias entity
         */
    public void saveTbcatalogocompetencias(Tbcatalogocompetencias entity)
        throws Exception;

    /**
         * Delete an existing Tbcatalogocompetencias entity
         *
         */
    public void deleteTbcatalogocompetencias(Tbcatalogocompetencias entity)
        throws Exception;

    /**
        * Update an existing Tbcatalogocompetencias entity
        *
        */
    public void updateTbcatalogocompetencias(Tbcatalogocompetencias entity)
        throws Exception;

    /**
         * Load an existing Tbcatalogocompetencias entity
         *
         */
    public Tbcatalogocompetencias getTbcatalogocompetencias(Integer consecutivo)
        throws Exception;

    public List<Tbcatalogocompetencias> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbcatalogocompetencias> findPageTbcatalogocompetencias(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbcatalogocompetencias()
        throws Exception;

    public List<TbcatalogocompetenciasDTO> getDataTbcatalogocompetencias()
        throws Exception;
}
