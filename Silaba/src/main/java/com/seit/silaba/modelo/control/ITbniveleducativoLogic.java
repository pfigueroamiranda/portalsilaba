package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbniveleducativo;
import com.seit.silaba.modelo.dto.TbniveleducativoDTO;

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
public interface ITbniveleducativoLogic {
    public List<Tbniveleducativo> getTbniveleducativo()
        throws Exception;

    /**
         * Save an new Tbniveleducativo entity
         */
    public void saveTbniveleducativo(Tbniveleducativo entity)
        throws Exception;

    /**
         * Delete an existing Tbniveleducativo entity
         *
         */
    public void deleteTbniveleducativo(Tbniveleducativo entity)
        throws Exception;

    /**
        * Update an existing Tbniveleducativo entity
        *
        */
    public void updateTbniveleducativo(Tbniveleducativo entity)
        throws Exception;

    /**
         * Load an existing Tbniveleducativo entity
         *
         */
    public Tbniveleducativo getTbniveleducativo(Integer consecutivo)
        throws Exception;

    public List<Tbniveleducativo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbniveleducativo> findPageTbniveleducativo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbniveleducativo() throws Exception;

    public List<TbniveleducativoDTO> getDataTbniveleducativo()
        throws Exception;
}
