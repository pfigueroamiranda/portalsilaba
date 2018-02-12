package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbcatalogopuntossilaba;
import com.seit.silaba.modelo.dto.TbcatalogopuntossilabaDTO;

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
public interface ITbcatalogopuntossilabaLogic {
    public List<Tbcatalogopuntossilaba> getTbcatalogopuntossilaba()
        throws Exception;

    /**
         * Save an new Tbcatalogopuntossilaba entity
         */
    public void saveTbcatalogopuntossilaba(Tbcatalogopuntossilaba entity)
        throws Exception;

    /**
         * Delete an existing Tbcatalogopuntossilaba entity
         *
         */
    public void deleteTbcatalogopuntossilaba(Tbcatalogopuntossilaba entity)
        throws Exception;

    /**
        * Update an existing Tbcatalogopuntossilaba entity
        *
        */
    public void updateTbcatalogopuntossilaba(Tbcatalogopuntossilaba entity)
        throws Exception;

    /**
         * Load an existing Tbcatalogopuntossilaba entity
         *
         */
    public Tbcatalogopuntossilaba getTbcatalogopuntossilaba(Integer consecutivo)
        throws Exception;

    public List<Tbcatalogopuntossilaba> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbcatalogopuntossilaba> findPageTbcatalogopuntossilaba(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbcatalogopuntossilaba()
        throws Exception;

    public List<TbcatalogopuntossilabaDTO> getDataTbcatalogopuntossilaba()
        throws Exception;
}
