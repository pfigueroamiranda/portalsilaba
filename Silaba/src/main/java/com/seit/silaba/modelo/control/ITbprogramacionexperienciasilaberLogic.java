package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbprogramacionexperienciasilaber;
import com.seit.silaba.modelo.dto.TbprogramacionexperienciasilaberDTO;

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
public interface ITbprogramacionexperienciasilaberLogic {
    public List<Tbprogramacionexperienciasilaber> getTbprogramacionexperienciasilaber()
        throws Exception;

    /**
         * Save an new Tbprogramacionexperienciasilaber entity
         */
    public void saveTbprogramacionexperienciasilaber(
        Tbprogramacionexperienciasilaber entity) throws Exception;

    /**
         * Delete an existing Tbprogramacionexperienciasilaber entity
         *
         */
    public void deleteTbprogramacionexperienciasilaber(
        Tbprogramacionexperienciasilaber entity) throws Exception;

    /**
        * Update an existing Tbprogramacionexperienciasilaber entity
        *
        */
    public void updateTbprogramacionexperienciasilaber(
        Tbprogramacionexperienciasilaber entity) throws Exception;

    /**
         * Load an existing Tbprogramacionexperienciasilaber entity
         *
         */
    public Tbprogramacionexperienciasilaber getTbprogramacionexperienciasilaber(
        Integer consecutivo) throws Exception;

    public List<Tbprogramacionexperienciasilaber> findByCriteria(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbprogramacionexperienciasilaber> findPageTbprogramacionexperienciasilaber(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbprogramacionexperienciasilaber()
        throws Exception;

    public List<TbprogramacionexperienciasilaberDTO> getDataTbprogramacionexperienciasilaber()
        throws Exception;
}
