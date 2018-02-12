package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbsocio;
import com.seit.silaba.modelo.dto.TbsocioDTO;

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
public interface ITbsocioLogic {
    public List<Tbsocio> getTbsocio() throws Exception;

    /**
         * Save an new Tbsocio entity
         */
    public void saveTbsocio(Tbsocio entity) throws Exception;

    /**
         * Delete an existing Tbsocio entity
         *
         */
    public void deleteTbsocio(Tbsocio entity) throws Exception;

    /**
        * Update an existing Tbsocio entity
        *
        */
    public void updateTbsocio(Tbsocio entity) throws Exception;

    /**
         * Load an existing Tbsocio entity
         *
         */
    public Tbsocio getTbsocio(Integer consecutivo) throws Exception;

    public List<Tbsocio> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbsocio> findPageTbsocio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTbsocio() throws Exception;

    public List<TbsocioDTO> getDataTbsocio() throws Exception;
}
