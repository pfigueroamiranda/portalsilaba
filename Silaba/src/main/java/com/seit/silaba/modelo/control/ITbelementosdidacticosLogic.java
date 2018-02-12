package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbelementosdidacticos;
import com.seit.silaba.modelo.dto.TbelementosdidacticosDTO;

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
public interface ITbelementosdidacticosLogic {
    public List<Tbelementosdidacticos> getTbelementosdidacticos()
        throws Exception;

    /**
         * Save an new Tbelementosdidacticos entity
         */
    public void saveTbelementosdidacticos(Tbelementosdidacticos entity)
        throws Exception;

    /**
         * Delete an existing Tbelementosdidacticos entity
         *
         */
    public void deleteTbelementosdidacticos(Tbelementosdidacticos entity)
        throws Exception;

    /**
        * Update an existing Tbelementosdidacticos entity
        *
        */
    public void updateTbelementosdidacticos(Tbelementosdidacticos entity)
        throws Exception;

    /**
         * Load an existing Tbelementosdidacticos entity
         *
         */
    public Tbelementosdidacticos getTbelementosdidacticos(Integer consecutivo)
        throws Exception;

    public List<Tbelementosdidacticos> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbelementosdidacticos> findPageTbelementosdidacticos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbelementosdidacticos()
        throws Exception;

    public List<TbelementosdidacticosDTO> getDataTbelementosdidacticos()
        throws Exception;
}
