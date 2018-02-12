package com.seit.silaba.modelo.control;

import com.seit.silaba.dataaccess.dao.*;
import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbcatalogopuntossilabaDTO;
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
@Service("TbcatalogopuntossilabaLogic")
public class TbcatalogopuntossilabaLogic implements ITbcatalogopuntossilabaLogic {
    private static final Logger log = LoggerFactory.getLogger(TbcatalogopuntossilabaLogic.class);

    /**
     * DAO injected by Spring that manages Tbcatalogopuntossilaba entities
     *
     */
    @Autowired
    private ITbcatalogopuntossilabaDAO tbcatalogopuntossilabaDAO;

    /**
    * DAO injected by Spring that manages Tbcompetenciaspuntossilaba entities
    *
    */
    @Autowired
    private ITbcompetenciaspuntossilabaDAO tbcompetenciaspuntossilabaDAO;

    /**
    * DAO injected by Spring that manages Tbcontenidosilaber entities
    *
    */
    @Autowired
    private ITbcontenidosilaberDAO tbcontenidosilaberDAO;

    /**
    * DAO injected by Spring that manages Tbexperienciapuntos entities
    *
    */
    @Autowired
    private ITbexperienciapuntosDAO tbexperienciapuntosDAO;

    /**
    * DAO injected by Spring that manages Tbsociospuntosilaba entities
    *
    */
    @Autowired
    private ITbsociospuntosilabaDAO tbsociospuntosilabaDAO;

    @Transactional(readOnly = true)
    public List<Tbcatalogopuntossilaba> getTbcatalogopuntossilaba()
        throws Exception {
        log.debug("finding all Tbcatalogopuntossilaba instances");

        List<Tbcatalogopuntossilaba> list = new ArrayList<Tbcatalogopuntossilaba>();

        try {
            list = tbcatalogopuntossilabaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Tbcatalogopuntossilaba failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Tbcatalogopuntossilaba");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTbcatalogopuntossilaba(Tbcatalogopuntossilaba entity)
        throws Exception {
        log.debug("saving Tbcatalogopuntossilaba instance");

        try {
            if ((entity.getCodigo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCodigo(),
                        45) == false)) {
                throw new ZMessManager().new NotValidFormatException("codigo");
            }

            if (entity.getConsecutivo() == null) {
                throw new ZMessManager().new EmptyFieldException("consecutivo");
            }

            if ((entity.getDescripcion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcion(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcion");
            }

            if ((entity.getFechaCreacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getFechaCreacion(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "fechaCreacion");
            }

            if ((entity.getUsuarioCreacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuarioCreacion(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "usuarioCreacion");
            }

            if (getTbcatalogopuntossilaba(entity.getConsecutivo()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            tbcatalogopuntossilabaDAO.save(entity);

            log.debug("save Tbcatalogopuntossilaba successful");
        } catch (Exception e) {
            log.error("save Tbcatalogopuntossilaba failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteTbcatalogopuntossilaba(Tbcatalogopuntossilaba entity)
        throws Exception {
        log.debug("deleting Tbcatalogopuntossilaba instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "Tbcatalogopuntossilaba");
        }

        if (entity.getConsecutivo() == null) {
            throw new ZMessManager().new EmptyFieldException("consecutivo");
        }

        List<Tbcompetenciaspuntossilaba> tbcompetenciaspuntossilabas = null;
        List<Tbcontenidosilaber> tbcontenidosilabers = null;
        List<Tbexperienciapuntos> tbexperienciapuntoses = null;
        List<Tbsociospuntosilaba> tbsociospuntosilabas = null;

        try {
            tbcompetenciaspuntossilabas = tbcompetenciaspuntossilabaDAO.findByProperty("tbcatalogopuntossilaba.consecutivo",
                    entity.getConsecutivo());

            if (Utilities.validationsList(tbcompetenciaspuntossilabas) == true) {
                throw new ZMessManager().new DeletingException(
                    "tbcompetenciaspuntossilabas");
            }

            tbcontenidosilabers = tbcontenidosilaberDAO.findByProperty("tbcatalogopuntossilaba.consecutivo",
                    entity.getConsecutivo());

            if (Utilities.validationsList(tbcontenidosilabers) == true) {
                throw new ZMessManager().new DeletingException(
                    "tbcontenidosilabers");
            }

            tbexperienciapuntoses = tbexperienciapuntosDAO.findByProperty("tbcatalogopuntossilaba.consecutivo",
                    entity.getConsecutivo());

            if (Utilities.validationsList(tbexperienciapuntoses) == true) {
                throw new ZMessManager().new DeletingException(
                    "tbexperienciapuntoses");
            }

            tbsociospuntosilabas = tbsociospuntosilabaDAO.findByProperty("tbcatalogopuntossilaba.consecutivo",
                    entity.getConsecutivo());

            if (Utilities.validationsList(tbsociospuntosilabas) == true) {
                throw new ZMessManager().new DeletingException(
                    "tbsociospuntosilabas");
            }

            tbcatalogopuntossilabaDAO.delete(entity);

            log.debug("delete Tbcatalogopuntossilaba successful");
        } catch (Exception e) {
            log.error("delete Tbcatalogopuntossilaba failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateTbcatalogopuntossilaba(Tbcatalogopuntossilaba entity)
        throws Exception {
        log.debug("updating Tbcatalogopuntossilaba instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "Tbcatalogopuntossilaba");
            }

            if ((entity.getCodigo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCodigo(),
                        45) == false)) {
                throw new ZMessManager().new NotValidFormatException("codigo");
            }

            if (entity.getConsecutivo() == null) {
                throw new ZMessManager().new EmptyFieldException("consecutivo");
            }

            if ((entity.getDescripcion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcion(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcion");
            }

            if ((entity.getFechaCreacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getFechaCreacion(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "fechaCreacion");
            }

            if ((entity.getUsuarioCreacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuarioCreacion(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "usuarioCreacion");
            }

            tbcatalogopuntossilabaDAO.update(entity);

            log.debug("update Tbcatalogopuntossilaba successful");
        } catch (Exception e) {
            log.error("update Tbcatalogopuntossilaba failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<TbcatalogopuntossilabaDTO> getDataTbcatalogopuntossilaba()
        throws Exception {
        try {
            List<Tbcatalogopuntossilaba> tbcatalogopuntossilaba = tbcatalogopuntossilabaDAO.findAll();

            List<TbcatalogopuntossilabaDTO> tbcatalogopuntossilabaDTO = new ArrayList<TbcatalogopuntossilabaDTO>();

            for (Tbcatalogopuntossilaba tbcatalogopuntossilabaTmp : tbcatalogopuntossilaba) {
                TbcatalogopuntossilabaDTO tbcatalogopuntossilabaDTO2 = new TbcatalogopuntossilabaDTO();

                tbcatalogopuntossilabaDTO2.setConsecutivo(tbcatalogopuntossilabaTmp.getConsecutivo());
                tbcatalogopuntossilabaDTO2.setCodigo((tbcatalogopuntossilabaTmp.getCodigo() != null)
                    ? tbcatalogopuntossilabaTmp.getCodigo() : null);
                tbcatalogopuntossilabaDTO2.setDescripcion((tbcatalogopuntossilabaTmp.getDescripcion() != null)
                    ? tbcatalogopuntossilabaTmp.getDescripcion() : null);
                tbcatalogopuntossilabaDTO2.setFechaCreacion((tbcatalogopuntossilabaTmp.getFechaCreacion() != null)
                    ? tbcatalogopuntossilabaTmp.getFechaCreacion() : null);
                tbcatalogopuntossilabaDTO2.setUsuarioCreacion((tbcatalogopuntossilabaTmp.getUsuarioCreacion() != null)
                    ? tbcatalogopuntossilabaTmp.getUsuarioCreacion() : null);
                tbcatalogopuntossilabaDTO.add(tbcatalogopuntossilabaDTO2);
            }

            return tbcatalogopuntossilabaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Tbcatalogopuntossilaba getTbcatalogopuntossilaba(Integer consecutivo)
        throws Exception {
        log.debug("getting Tbcatalogopuntossilaba instance");

        Tbcatalogopuntossilaba entity = null;

        try {
            entity = tbcatalogopuntossilabaDAO.findById(consecutivo);
        } catch (Exception e) {
            log.error("get Tbcatalogopuntossilaba failed", e);
            throw new ZMessManager().new FindingException(
                "Tbcatalogopuntossilaba");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Tbcatalogopuntossilaba> findPageTbcatalogopuntossilaba(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<Tbcatalogopuntossilaba> entity = null;

        try {
            entity = tbcatalogopuntossilabaDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "Tbcatalogopuntossilaba Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberTbcatalogopuntossilaba()
        throws Exception {
        Long entity = null;

        try {
            entity = tbcatalogopuntossilabaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "Tbcatalogopuntossilaba Count");
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
    public List<Tbcatalogopuntossilaba> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Tbcatalogopuntossilaba> list = new ArrayList<Tbcatalogopuntossilaba>();
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
            list = tbcatalogopuntossilabaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
