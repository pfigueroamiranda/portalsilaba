package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbtemasareas;
import com.seit.silaba.modelo.dto.TbtemasareasDTO;

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
public interface ITbtemasareasLogic {
    public List<Tbtemasareas> getTbtemasareas() throws Exception;

    /**
         * Save an new Tbtemasareas entity
         */
    public void saveTbtemasareas(Tbtemasareas entity) throws Exception;

    /**
         * Delete an existing Tbtemasareas entity
         *
         */
    public void deleteTbtemasareas(Tbtemasareas entity)
        throws Exception;

    /**
        * Update an existing Tbtemasareas entity
        *
        */
    public void updateTbtemasareas(Tbtemasareas entity)
        throws Exception;

    /**
         * Load an existing Tbtemasareas entity
         *
         */
    public Tbtemasareas getTbtemasareas(Integer consecutivo)
        throws Exception;

    public List<Tbtemasareas> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbtemasareas> findPageTbtemasareas(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTbtemasareas() throws Exception;

    public List<TbtemasareasDTO> getDataTbtemasareas()
        throws Exception;
}
