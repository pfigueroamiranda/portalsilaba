package com.seit.silaba.modelo.control;

import com.seit.silaba.dataaccess.dao.*;
import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbsilaberDTO;
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
@Service("TbsilaberLogic")
public class TbsilaberLogic implements ITbsilaberLogic {
    private static final Logger log = LoggerFactory.getLogger(TbsilaberLogic.class);

    /**
     * DAO injected by Spring that manages Tbsilaber entities
     *
     */
    @Autowired
    private ITbsilaberDAO tbsilaberDAO;

    /**
    * DAO injected by Spring that manages Tbprogramacionexperienciasilaber entities
    *
    */
    @Autowired
    private ITbprogramacionexperienciasilaberDAO tbprogramacionexperienciasilaberDAO;

    /**
    * DAO injected by Spring that manages Tbrutaexperienciaaprendizaje entities
    *
    */
    @Autowired
    private ITbrutaexperienciaaprendizajeDAO tbrutaexperienciaaprendizajeDAO;

    @Transactional(readOnly = true)
    public List<Tbsilaber> getTbsilaber() throws Exception {
        log.debug("finding all Tbsilaber instances");

        List<Tbsilaber> list = new ArrayList<Tbsilaber>();

        try {
            list = tbsilaberDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Tbsilaber failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Tbsilaber");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTbsilaber(Tbsilaber entity) throws Exception {
        log.debug("saving Tbsilaber instance");

        try {
            if ((entity.getApellido() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getApellido(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException("apellido");
            }

            if (entity.getConsecutivo() == null) {
                throw new ZMessManager().new EmptyFieldException("consecutivo");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        45) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }
            
            if ((entity.getUsuario() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getUsuario(),
                        25) == false)) {
                throw new ZMessManager().new NotValidFormatException("usuario");
            }
            
            if ((entity.getContrasena() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getContrasena(),
                        25) == false)) {
                throw new ZMessManager().new NotValidFormatException("contrasena");
            }

            if ((entity.getTelefonoCelular() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTelefonoCelular(), 15) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "telefonoCelular");
            }

            if ((entity.getTelefonoFijo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTelefonoFijo(), 15) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "telefonoFijo");
            }

            if ((entity.getUsuarioCreacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuarioCreacion(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "usuarioCreacion");
            }

            if (getTbsilaber(entity.getConsecutivo()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            tbsilaberDAO.save(entity);

            log.debug("save Tbsilaber successful");
        } catch (Exception e) {
            log.error("save Tbsilaber failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteTbsilaber(Tbsilaber entity) throws Exception {
        log.debug("deleting Tbsilaber instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Tbsilaber");
        }

        if (entity.getConsecutivo() == null) {
            throw new ZMessManager().new EmptyFieldException("consecutivo");
        }

        List<Tbprogramacionexperienciasilaber> tbprogramacionexperienciasilabers =
            null;
        List<Tbrutaexperienciaaprendizaje> tbrutaexperienciaaprendizajes = null;

        try {
            tbprogramacionexperienciasilabers = tbprogramacionexperienciasilaberDAO.findByProperty("tbsilaber.consecutivo",
                    entity.getConsecutivo());

            if (Utilities.validationsList(tbprogramacionexperienciasilabers) == true) {
                throw new ZMessManager().new DeletingException(
                    "tbprogramacionexperienciasilabers");
            }

            tbrutaexperienciaaprendizajes = tbrutaexperienciaaprendizajeDAO.findByProperty("tbsilaber.consecutivo",
                    entity.getConsecutivo());

            if (Utilities.validationsList(tbrutaexperienciaaprendizajes) == true) {
                throw new ZMessManager().new DeletingException(
                    "tbrutaexperienciaaprendizajes");
            }

            tbsilaberDAO.delete(entity);

            log.debug("delete Tbsilaber successful");
        } catch (Exception e) {
            log.error("delete Tbsilaber failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateTbsilaber(Tbsilaber entity) throws Exception {
        log.debug("updating Tbsilaber instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Tbsilaber");
            }

            if ((entity.getApellido() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getApellido(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException("apellido");
            }

            if (entity.getConsecutivo() == null) {
                throw new ZMessManager().new EmptyFieldException("consecutivo");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        45) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }
            
            if ((entity.getUsuario() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getUsuario(),
                        25) == false)) {
                throw new ZMessManager().new NotValidFormatException("usuario");
            }
            
            if ((entity.getContrasena() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getContrasena(),
                        25) == false)) {
                throw new ZMessManager().new NotValidFormatException("contrasena");
            }

            if ((entity.getTelefonoCelular() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTelefonoCelular(), 15) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "telefonoCelular");
            }

            if ((entity.getTelefonoFijo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTelefonoFijo(), 15) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "telefonoFijo");
            }

            if ((entity.getUsuarioCreacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuarioCreacion(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "usuarioCreacion");
            }

            tbsilaberDAO.update(entity);

            log.debug("update Tbsilaber successful");
        } catch (Exception e) {
            log.error("update Tbsilaber failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<TbsilaberDTO> getDataTbsilaber() throws Exception {
        try {
            List<Tbsilaber> tbsilaber = tbsilaberDAO.findAll();

            List<TbsilaberDTO> tbsilaberDTO = new ArrayList<TbsilaberDTO>();

            for (Tbsilaber tbsilaberTmp : tbsilaber) {
                TbsilaberDTO tbsilaberDTO2 = new TbsilaberDTO();

                tbsilaberDTO2.setConsecutivo(tbsilaberTmp.getConsecutivo());
                tbsilaberDTO2.setApellido((tbsilaberTmp.getApellido() != null)
                    ? tbsilaberTmp.getApellido() : null);
                tbsilaberDTO2.setFechaCreacion(tbsilaberTmp.getFechaCreacion());
                tbsilaberDTO2.setFechaNacimiento(tbsilaberTmp.getFechaNacimiento());
                tbsilaberDTO2.setNombre((tbsilaberTmp.getNombre() != null)
                    ? tbsilaberTmp.getNombre() : null);
                tbsilaberDTO2.setTelefonoCelular((tbsilaberTmp.getTelefonoCelular() != null)
                    ? tbsilaberTmp.getTelefonoCelular() : null);
                tbsilaberDTO2.setTelefonoFijo((tbsilaberTmp.getTelefonoFijo() != null)
                    ? tbsilaberTmp.getTelefonoFijo() : null);
                tbsilaberDTO2.setUsuarioCreacion((tbsilaberTmp.getUsuarioCreacion() != null)
                    ? tbsilaberTmp.getUsuarioCreacion() : null);
                tbsilaberDTO2.setUsuario((tbsilaberTmp.getUsuario() != null)
                        ? tbsilaberTmp.getUsuario() : null);
                tbsilaberDTO2.setContrasena((tbsilaberTmp.getContrasena() != null)
                        ? tbsilaberTmp.getContrasena() : null);
                tbsilaberDTO.add(tbsilaberDTO2);
            }

            return tbsilaberDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Tbsilaber getTbsilaber(Integer consecutivo)
        throws Exception {
        log.debug("getting Tbsilaber instance");

        Tbsilaber entity = null;

        try {
            entity = tbsilaberDAO.findById(consecutivo);
        } catch (Exception e) {
            log.error("get Tbsilaber failed", e);
            throw new ZMessManager().new FindingException("Tbsilaber");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Tbsilaber> findPageTbsilaber(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Tbsilaber> entity = null;

        try {
            entity = tbsilaberDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Tbsilaber Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberTbsilaber() throws Exception {
        Long entity = null;

        try {
            entity = tbsilaberDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Tbsilaber Count");
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
    public List<Tbsilaber> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Tbsilaber> list = new ArrayList<Tbsilaber>();
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
            list = tbsilaberDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
