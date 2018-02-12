package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbcompetenciasareas;
import com.seit.silaba.modelo.dto.TbcompetenciasareasDTO;

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
public interface ITbcompetenciasareasLogic {
    public List<Tbcompetenciasareas> getTbcompetenciasareas()
        throws Exception;

    /**
         * Save an new Tbcompetenciasareas entity
         */
    public void saveTbcompetenciasareas(Tbcompetenciasareas entity)
        throws Exception;

    /**
         * Delete an existing Tbcompetenciasareas entity
         *
         */
    public void deleteTbcompetenciasareas(Tbcompetenciasareas entity)
        throws Exception;

    /**
        * Update an existing Tbcompetenciasareas entity
        *
        */
    public void updateTbcompetenciasareas(Tbcompetenciasareas entity)
        throws Exception;

    /**
         * Load an existing Tbcompetenciasareas entity
         *
         */
    public Tbcompetenciasareas getTbcompetenciasareas(Integer consecutivo)
        throws Exception;

    public List<Tbcompetenciasareas> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbcompetenciasareas> findPageTbcompetenciasareas(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbcompetenciasareas() throws Exception;

    public List<TbcompetenciasareasDTO> getDataTbcompetenciasareas()
        throws Exception;
}
