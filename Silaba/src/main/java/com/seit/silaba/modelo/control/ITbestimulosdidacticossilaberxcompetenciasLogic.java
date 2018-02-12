package com.seit.silaba.modelo.control;

import com.seit.silaba.modelo.Tbestimulosdidacticossilaberxcompetencias;
import com.seit.silaba.modelo.dto.TbestimulosdidacticossilaberxcompetenciasDTO;

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
public interface ITbestimulosdidacticossilaberxcompetenciasLogic {
    public List<Tbestimulosdidacticossilaberxcompetencias> getTbestimulosdidacticossilaberxcompetencias()
        throws Exception;

    /**
         * Save an new Tbestimulosdidacticossilaberxcompetencias entity
         */
    public void saveTbestimulosdidacticossilaberxcompetencias(
        Tbestimulosdidacticossilaberxcompetencias entity)
        throws Exception;

    /**
         * Delete an existing Tbestimulosdidacticossilaberxcompetencias entity
         *
         */
    public void deleteTbestimulosdidacticossilaberxcompetencias(
        Tbestimulosdidacticossilaberxcompetencias entity)
        throws Exception;

    /**
        * Update an existing Tbestimulosdidacticossilaberxcompetencias entity
        *
        */
    public void updateTbestimulosdidacticossilaberxcompetencias(
        Tbestimulosdidacticossilaberxcompetencias entity)
        throws Exception;

    /**
         * Load an existing Tbestimulosdidacticossilaberxcompetencias entity
         *
         */
    public Tbestimulosdidacticossilaberxcompetencias getTbestimulosdidacticossilaberxcompetencias(
        Integer consecutivo) throws Exception;

    public List<Tbestimulosdidacticossilaberxcompetencias> findByCriteria(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Tbestimulosdidacticossilaberxcompetencias> findPageTbestimulosdidacticossilaberxcompetencias(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTbestimulosdidacticossilaberxcompetencias()
        throws Exception;

    public List<TbestimulosdidacticossilaberxcompetenciasDTO> getDataTbestimulosdidacticossilaberxcompetencias()
        throws Exception;
}
