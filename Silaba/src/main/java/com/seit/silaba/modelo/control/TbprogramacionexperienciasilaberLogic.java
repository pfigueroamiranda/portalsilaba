package com.seit.silaba.modelo.control;

import com.seit.silaba.dataaccess.dao.*;
import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbprogramacionexperienciasilaberDTO;
import com.seit.silaba.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("TbprogramacionexperienciasilaberLogic")
public class TbprogramacionexperienciasilaberLogic
    implements ITbprogramacionexperienciasilaberLogic {
    private static final Logger log = LoggerFactory.getLogger(TbprogramacionexperienciasilaberLogic.class);

    /**
     * DAO injected by Spring that manages Tbprogramacionexperienciasilaber entities
     *
     */
    @Autowired
    private ITbprogramacionexperienciasilaberDAO tbprogramacionexperienciasilaberDAO;

    /**
    * DAO injected by Spring that manages Tbmapacompetenciassilaber entities
    *
    */
    @Autowired
    private ITbmapacompetenciassilaberDAO tbmapacompetenciassilaberDAO;

    /**
    * Logic injected by Spring that manages Tbcontenidosilaber entities
    *
    */
    @Autowired
    ITbcontenidosilaberLogic logicTbcontenidosilaber1;

    /**
    * Logic injected by Spring that manages Tbsilaber entities
    *
    */
    @Autowired
    ITbsilaberLogic logicTbsilaber2;

    @Transactional(readOnly = true)
    public List<Tbprogramacionexperienciasilaber> getTbprogramacionexperienciasilaber()
        throws Exception {
        log.debug("finding all Tbprogramacionexperienciasilaber instances");

        List<Tbprogramacionexperienciasilaber> list = new ArrayList<Tbprogramacionexperienciasilaber>();

        try {
            list = tbprogramacionexperienciasilaberDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Tbprogramacionexperienciasilaber failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Tbprogramacionexperienciasilaber");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTbprogramacionexperienciasilaber(
        Tbprogramacionexperienciasilaber entity) throws Exception {
        log.debug("saving Tbprogramacionexperienciasilaber instance");

        try {
            if (entity.getTbcontenidosilaber() == null) {
                throw new ZMessManager().new ForeignException(
                    "tbcontenidosilaber");
            }

            if (entity.getTbsilaber() == null) {
                throw new ZMessManager().new ForeignException("tbsilaber");
            }

            if (entity.getConsecutivo() == null) {
                throw new ZMessManager().new EmptyFieldException("consecutivo");
            }

            if (entity.getTbcontenidosilaber().getConsecutivo() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "consecutivo_Tbcontenidosilaber");
            }

            if (entity.getTbsilaber().getConsecutivo() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "consecutivo_Tbsilaber");
            }

            if (getTbprogramacionexperienciasilaber(entity.getConsecutivo()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            tbprogramacionexperienciasilaberDAO.save(entity);

            log.debug("save Tbprogramacionexperienciasilaber successful");
        } catch (Exception e) {
            log.error("save Tbprogramacionexperienciasilaber failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteTbprogramacionexperienciasilaber(
        Tbprogramacionexperienciasilaber entity) throws Exception {
        log.debug("deleting Tbprogramacionexperienciasilaber instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "Tbprogramacionexperienciasilaber");
        }

        if (entity.getConsecutivo() == null) {
            throw new ZMessManager().new EmptyFieldException("consecutivo");
        }

        List<Tbmapacompetenciassilaber> tbmapacompetenciassilabers = null;

        try {
            tbmapacompetenciassilabers = tbmapacompetenciassilaberDAO.findByProperty("tbprogramacionexperienciasilaber.consecutivo",
                    entity.getConsecutivo());

            if (Utilities.validationsList(tbmapacompetenciassilabers) == true) {
                throw new ZMessManager().new DeletingException(
                    "tbmapacompetenciassilabers");
            }

            tbprogramacionexperienciasilaberDAO.delete(entity);

            log.debug("delete Tbprogramacionexperienciasilaber successful");
        } catch (Exception e) {
            log.error("delete Tbprogramacionexperienciasilaber failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateTbprogramacionexperienciasilaber(
        Tbprogramacionexperienciasilaber entity) throws Exception {
        log.debug("updating Tbprogramacionexperienciasilaber instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "Tbprogramacionexperienciasilaber");
            }

            if (entity.getTbcontenidosilaber() == null) {
                throw new ZMessManager().new ForeignException(
                    "tbcontenidosilaber");
            }

            if (entity.getTbsilaber() == null) {
                throw new ZMessManager().new ForeignException("tbsilaber");
            }

            if (entity.getConsecutivo() == null) {
                throw new ZMessManager().new EmptyFieldException("consecutivo");
            }

            if (entity.getTbcontenidosilaber().getConsecutivo() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "consecutivo_Tbcontenidosilaber");
            }

            if (entity.getTbsilaber().getConsecutivo() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "consecutivo_Tbsilaber");
            }

            tbprogramacionexperienciasilaberDAO.update(entity);

            log.debug("update Tbprogramacionexperienciasilaber successful");
        } catch (Exception e) {
            log.error("update Tbprogramacionexperienciasilaber failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<TbprogramacionexperienciasilaberDTO> getDataTbprogramacionexperienciasilaber()
        throws Exception {
        try {
            List<Tbprogramacionexperienciasilaber> tbprogramacionexperienciasilaber =
                tbprogramacionexperienciasilaberDAO.findAll();

            List<TbprogramacionexperienciasilaberDTO> tbprogramacionexperienciasilaberDTO =
                new ArrayList<TbprogramacionexperienciasilaberDTO>();

            for (Tbprogramacionexperienciasilaber tbprogramacionexperienciasilaberTmp : tbprogramacionexperienciasilaber) {
                TbprogramacionexperienciasilaberDTO tbprogramacionexperienciasilaberDTO2 =
                    new TbprogramacionexperienciasilaberDTO();

                tbprogramacionexperienciasilaberDTO2.setConsecutivo(tbprogramacionexperienciasilaberTmp.getConsecutivo());
                tbprogramacionexperienciasilaberDTO2.setFechaProgramacion(tbprogramacionexperienciasilaberTmp.getFechaProgramacion());
                tbprogramacionexperienciasilaberDTO2.setConsecutivo_Tbcontenidosilaber((tbprogramacionexperienciasilaberTmp.getTbcontenidosilaber()
                                                                                                                           .getConsecutivo() != null)
                    ? tbprogramacionexperienciasilaberTmp.getTbcontenidosilaber()
                                                         .getConsecutivo() : null);
                tbprogramacionexperienciasilaberDTO2.setConsecutivo_Tbsilaber((tbprogramacionexperienciasilaberTmp.getTbsilaber()
                                                                                                                  .getConsecutivo() != null)
                    ? tbprogramacionexperienciasilaberTmp.getTbsilaber()
                                                         .getConsecutivo() : null);
                tbprogramacionexperienciasilaberDTO.add(tbprogramacionexperienciasilaberDTO2);
            }

            return tbprogramacionexperienciasilaberDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Tbprogramacionexperienciasilaber getTbprogramacionexperienciasilaber(
        Integer consecutivo) throws Exception {
        log.debug("getting Tbprogramacionexperienciasilaber instance");

        Tbprogramacionexperienciasilaber entity = null;

        try {
            entity = tbprogramacionexperienciasilaberDAO.findById(consecutivo);
        } catch (Exception e) {
            log.error("get Tbprogramacionexperienciasilaber failed", e);
            throw new ZMessManager().new FindingException(
                "Tbprogramacionexperienciasilaber");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Tbprogramacionexperienciasilaber> findPageTbprogramacionexperienciasilaber(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<Tbprogramacionexperienciasilaber> entity = null;

        try {
            entity = tbprogramacionexperienciasilaberDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "Tbprogramacionexperienciasilaber Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberTbprogramacionexperienciasilaber()
        throws Exception {
        Long entity = null;

        try {
            entity = tbprogramacionexperienciasilaberDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "Tbprogramacionexperienciasilaber Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Tbprogramacionexperienciasilaber> findByCriteria(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        List<Tbprogramacionexperienciasilaber> list = new ArrayList<Tbprogramacionexperienciasilaber>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = tbprogramacionexperienciasilaberDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
