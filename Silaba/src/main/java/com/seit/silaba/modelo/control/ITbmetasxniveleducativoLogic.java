package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbmetasxniveleducativo;
import com.seit.silaba.modelo.dto.TbmetasxniveleducativoDTO;

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
public interface ITbmetasxniveleducativoLogic {
    public List<Tbmetasxniveleducativo> getTbmetasxniveleducativo()
        throws Exception;

    /**
         * Save an new Tbmetasxniveleducativo entity
         */
    public void saveTbmetasxniveleducativo(Tbmetasxniveleducativo entity)
        throws Exception;

    /**
         * Delete an existing Tbmetasxniveleducativo entity
         *
         */
    public void deleteTbmetasxniveleducativo(Tbmetasxniveleducativo entity)
        throws Exception;

    /**
        * Update an existing Tbmetasxniveleducativo entity
        *
        */
    public void updateTbmetasxniveleducativo(Tbmetasxniveleducativo entity)
        throws Exception;

    /**
         * Load an existing Tbmetasxniveleducativo entity
         *
         */
    public Tbmetasxniveleducativo getTbmetasxniveleducativo(Integer cosecutivo)
        throws Exception;

    public List<Tbmetasxniveleducativo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbmetasxniveleducativo> findPageTbmetasxniveleducativo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbmetasxniveleducativo()
        throws Exception;

    public List<TbmetasxniveleducativoDTO> getDataTbmetasxniveleducativo()
        throws Exception;
}
