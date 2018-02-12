package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbcontenidosilaber;
import com.seit.silaba.modelo.dto.TbcontenidosilaberDTO;

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
public interface ITbcontenidosilaberLogic {
    public List<Tbcontenidosilaber> getTbcontenidosilaber()
        throws Exception;

    /**
         * Save an new Tbcontenidosilaber entity
         */
    public void saveTbcontenidosilaber(Tbcontenidosilaber entity)
        throws Exception;

    /**
         * Delete an existing Tbcontenidosilaber entity
         *
         */
    public void deleteTbcontenidosilaber(Tbcontenidosilaber entity)
        throws Exception;

    /**
        * Update an existing Tbcontenidosilaber entity
        *
        */
    public void updateTbcontenidosilaber(Tbcontenidosilaber entity)
        throws Exception;

    /**
         * Load an existing Tbcontenidosilaber entity
         *
         */
    public Tbcontenidosilaber getTbcontenidosilaber(Integer consecutivo)
        throws Exception;

    public List<Tbcontenidosilaber> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tbcontenidosilaber> findPageTbcontenidosilaber(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbcontenidosilaber() throws Exception;

    public List<TbcontenidosilaberDTO> getDataTbcontenidosilaber()
        throws Exception;
}
