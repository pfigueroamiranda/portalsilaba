package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbsociospuntosilaba;
import com.seit.silaba.modelo.dto.TbsociospuntosilabaDTO;

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
public interface ITbsociospuntosilabaLogic {
    public List<Tbsociospuntosilaba> getTbsociospuntosilaba()
        throws Exception;

    /**
         * Save an new Tbsociospuntosilaba entity
         */
    public void saveTbsociospuntosilaba(Tbsociospuntosilaba entity)
        throws Exception;

    /**
         * Delete an existing Tbsociospuntosilaba entity
         *
         */
    public void deleteTbsociospuntosilaba(Tbsociospuntosilaba entity)
        throws Exception;

    /**
        * Update an existing Tbsociospuntosilaba entity
        *
        */
    public void updateTbsociospuntosilaba(Tbsociospuntosilaba entity)
        throws Exception;

    /**
         * Load an existing Tbsociospuntosilaba entity
         *
         */
    public Tbsociospuntosilaba getTbsociospuntosilaba(Integer consecutivo)
        throws Exception;

    public List<Tbsociospuntosilaba> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbsociospuntosilaba> findPageTbsociospuntosilaba(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbsociospuntosilaba() throws Exception;

    public List<TbsociospuntosilabaDTO> getDataTbsociospuntosilaba()
        throws Exception;
}
