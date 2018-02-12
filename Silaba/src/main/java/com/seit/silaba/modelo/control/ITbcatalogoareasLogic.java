package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbcatalogoareas;
import com.seit.silaba.modelo.dto.TbcatalogoareasDTO;

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
public interface ITbcatalogoareasLogic {
    public List<Tbcatalogoareas> getTbcatalogoareas() throws Exception;

    /**
         * Save an new Tbcatalogoareas entity
         */
    public void saveTbcatalogoareas(Tbcatalogoareas entity)
        throws Exception;

    /**
         * Delete an existing Tbcatalogoareas entity
         *
         */
    public void deleteTbcatalogoareas(Tbcatalogoareas entity)
        throws Exception;

    /**
        * Update an existing Tbcatalogoareas entity
        *
        */
    public void updateTbcatalogoareas(Tbcatalogoareas entity)
        throws Exception;

    /**
         * Load an existing Tbcatalogoareas entity
         *
         */
    public Tbcatalogoareas getTbcatalogoareas(Integer consecutivo)
        throws Exception;

    public List<Tbcatalogoareas> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbcatalogoareas> findPageTbcatalogoareas(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbcatalogoareas() throws Exception;

    public List<TbcatalogoareasDTO> getDataTbcatalogoareas()
        throws Exception;
}
