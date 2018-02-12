package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbmapacompetenciassilaber;
import com.seit.silaba.modelo.dto.TbmapacompetenciassilaberDTO;

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
public interface ITbmapacompetenciassilaberLogic {
    public List<Tbmapacompetenciassilaber> getTbmapacompetenciassilaber()
        throws Exception;

    /**
         * Save an new Tbmapacompetenciassilaber entity
         */
    public void saveTbmapacompetenciassilaber(Tbmapacompetenciassilaber entity)
        throws Exception;

    /**
         * Delete an existing Tbmapacompetenciassilaber entity
         *
         */
    public void deleteTbmapacompetenciassilaber(
        Tbmapacompetenciassilaber entity) throws Exception;

    /**
        * Update an existing Tbmapacompetenciassilaber entity
        *
        */
    public void updateTbmapacompetenciassilaber(
        Tbmapacompetenciassilaber entity) throws Exception;

    /**
         * Load an existing Tbmapacompetenciassilaber entity
         *
         */
    public Tbmapacompetenciassilaber getTbmapacompetenciassilaber(
        Integer consecutivo) throws Exception;

    public List<Tbmapacompetenciassilaber> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbmapacompetenciassilaber> findPageTbmapacompetenciassilaber(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbmapacompetenciassilaber()
        throws Exception;

    public List<TbmapacompetenciassilaberDTO> getDataTbmapacompetenciassilaber()
        throws Exception;
}
