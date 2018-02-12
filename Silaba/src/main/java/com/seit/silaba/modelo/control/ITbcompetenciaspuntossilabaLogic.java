package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbcompetenciaspuntossilaba;
import com.seit.silaba.modelo.dto.TbcompetenciaspuntossilabaDTO;

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
public interface ITbcompetenciaspuntossilabaLogic {
    public List<Tbcompetenciaspuntossilaba> getTbcompetenciaspuntossilaba()
        throws Exception;

    /**
         * Save an new Tbcompetenciaspuntossilaba entity
         */
    public void saveTbcompetenciaspuntossilaba(
        Tbcompetenciaspuntossilaba entity) throws Exception;

    /**
         * Delete an existing Tbcompetenciaspuntossilaba entity
         *
         */
    public void deleteTbcompetenciaspuntossilaba(
        Tbcompetenciaspuntossilaba entity) throws Exception;

    /**
        * Update an existing Tbcompetenciaspuntossilaba entity
        *
        */
    public void updateTbcompetenciaspuntossilaba(
        Tbcompetenciaspuntossilaba entity) throws Exception;

    /**
         * Load an existing Tbcompetenciaspuntossilaba entity
         *
         */
    public Tbcompetenciaspuntossilaba getTbcompetenciaspuntossilaba(
        Integer consecutivo) throws Exception;

    public List<Tbcompetenciaspuntossilaba> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbcompetenciaspuntossilaba> findPageTbcompetenciaspuntossilaba(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbcompetenciaspuntossilaba()
        throws Exception;

    public List<TbcompetenciaspuntossilabaDTO> getDataTbcompetenciaspuntossilaba()
        throws Exception;
}
