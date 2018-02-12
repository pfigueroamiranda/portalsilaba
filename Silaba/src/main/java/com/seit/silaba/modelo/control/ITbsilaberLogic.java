package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbsilaber;
import com.seit.silaba.modelo.dto.TbsilaberDTO;

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
public interface ITbsilaberLogic {
    public List<Tbsilaber> getTbsilaber() throws Exception;

    /**
         * Save an new Tbsilaber entity
         */
    public void saveTbsilaber(Tbsilaber entity) throws Exception;

    /**
         * Delete an existing Tbsilaber entity
         *
         */
    public void deleteTbsilaber(Tbsilaber entity) throws Exception;

    /**
        * Update an existing Tbsilaber entity
        *
        */
    public void updateTbsilaber(Tbsilaber entity) throws Exception;

    /**
         * Load an existing Tbsilaber entity
         *
         */
    public Tbsilaber getTbsilaber(Integer consecutivo)
        throws Exception;

    public List<Tbsilaber> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbsilaber> findPageTbsilaber(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTbsilaber() throws Exception;

    public List<TbsilaberDTO> getDataTbsilaber() throws Exception;
}
