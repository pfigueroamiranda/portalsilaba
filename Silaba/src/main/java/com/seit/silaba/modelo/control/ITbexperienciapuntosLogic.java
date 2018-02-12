package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbexperienciapuntos;
import com.seit.silaba.modelo.dto.TbexperienciapuntosDTO;

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
public interface ITbexperienciapuntosLogic {
    public List<Tbexperienciapuntos> getTbexperienciapuntos()
        throws Exception;

    /**
         * Save an new Tbexperienciapuntos entity
         */
    public void saveTbexperienciapuntos(Tbexperienciapuntos entity)
        throws Exception;

    /**
         * Delete an existing Tbexperienciapuntos entity
         *
         */
    public void deleteTbexperienciapuntos(Tbexperienciapuntos entity)
        throws Exception;

    /**
        * Update an existing Tbexperienciapuntos entity
        *
        */
    public void updateTbexperienciapuntos(Tbexperienciapuntos entity)
        throws Exception;

    /**
         * Load an existing Tbexperienciapuntos entity
         *
         */
    public Tbexperienciapuntos getTbexperienciapuntos(Integer consecutivo)
        throws Exception;

    public List<Tbexperienciapuntos> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbexperienciapuntos> findPageTbexperienciapuntos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbexperienciapuntos() throws Exception;

    public List<TbexperienciapuntosDTO> getDataTbexperienciapuntos()
        throws Exception;
}
