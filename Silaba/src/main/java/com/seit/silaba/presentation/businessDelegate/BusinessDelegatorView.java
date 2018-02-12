package com.seit.silaba.presentation.businessDelegate;

import com.seit.silaba.modelo.Tbcatalogoareas;
import com.seit.silaba.modelo.Tbcatalogocompetencias;
import com.seit.silaba.modelo.Tbcatalogoexperienciaaprendizaje;
import com.seit.silaba.modelo.Tbcatalogopuntossilaba;
import com.seit.silaba.modelo.Tbcompetenciasareas;
import com.seit.silaba.modelo.Tbcompetenciaspuntossilaba;
import com.seit.silaba.modelo.Tbcontenidosilaber;
import com.seit.silaba.modelo.Tbelementosdidacticos;
import com.seit.silaba.modelo.Tbestimulosdidacticossilaberxcompetencias;
import com.seit.silaba.modelo.Tbexperienciapuntos;
import com.seit.silaba.modelo.Tbmapacompetenciassilaber;
import com.seit.silaba.modelo.Tbmetasxniveleducativo;
import com.seit.silaba.modelo.Tbniveleducativo;
import com.seit.silaba.modelo.Tbprogramacionexperienciasilaber;
import com.seit.silaba.modelo.Tbrutaexperienciaaprendizaje;
import com.seit.silaba.modelo.Tbsilaber;
import com.seit.silaba.modelo.Tbsocio;
import com.seit.silaba.modelo.Tbsociospuntosilaba;
import com.seit.silaba.modelo.Tbtemasareas;
import com.seit.silaba.modelo.control.ITbcatalogoareasLogic;
import com.seit.silaba.modelo.control.ITbcatalogocompetenciasLogic;
import com.seit.silaba.modelo.control.ITbcatalogoexperienciaaprendizajeLogic;
import com.seit.silaba.modelo.control.ITbcatalogopuntossilabaLogic;
import com.seit.silaba.modelo.control.ITbcompetenciasareasLogic;
import com.seit.silaba.modelo.control.ITbcompetenciaspuntossilabaLogic;
import com.seit.silaba.modelo.control.ITbcontenidosilaberLogic;
import com.seit.silaba.modelo.control.ITbelementosdidacticosLogic;
import com.seit.silaba.modelo.control.ITbestimulosdidacticossilaberxcompetenciasLogic;
import com.seit.silaba.modelo.control.ITbexperienciapuntosLogic;
import com.seit.silaba.modelo.control.ITbmapacompetenciassilaberLogic;
import com.seit.silaba.modelo.control.ITbmetasxniveleducativoLogic;
import com.seit.silaba.modelo.control.ITbniveleducativoLogic;
import com.seit.silaba.modelo.control.ITbprogramacionexperienciasilaberLogic;
import com.seit.silaba.modelo.control.ITbrutaexperienciaaprendizajeLogic;
import com.seit.silaba.modelo.control.ITbsilaberLogic;
import com.seit.silaba.modelo.control.ITbsocioLogic;
import com.seit.silaba.modelo.control.ITbsociospuntosilabaLogic;
import com.seit.silaba.modelo.control.ITbtemasareasLogic;
import com.seit.silaba.modelo.control.TbcatalogoareasLogic;
import com.seit.silaba.modelo.control.TbcatalogocompetenciasLogic;
import com.seit.silaba.modelo.control.TbcatalogoexperienciaaprendizajeLogic;
import com.seit.silaba.modelo.control.TbcatalogopuntossilabaLogic;
import com.seit.silaba.modelo.control.TbcompetenciasareasLogic;
import com.seit.silaba.modelo.control.TbcompetenciaspuntossilabaLogic;
import com.seit.silaba.modelo.control.TbcontenidosilaberLogic;
import com.seit.silaba.modelo.control.TbelementosdidacticosLogic;
import com.seit.silaba.modelo.control.TbestimulosdidacticossilaberxcompetenciasLogic;
import com.seit.silaba.modelo.control.TbexperienciapuntosLogic;
import com.seit.silaba.modelo.control.TbmapacompetenciassilaberLogic;
import com.seit.silaba.modelo.control.TbmetasxniveleducativoLogic;
import com.seit.silaba.modelo.control.TbniveleducativoLogic;
import com.seit.silaba.modelo.control.TbprogramacionexperienciasilaberLogic;
import com.seit.silaba.modelo.control.TbrutaexperienciaaprendizajeLogic;
import com.seit.silaba.modelo.control.TbsilaberLogic;
import com.seit.silaba.modelo.control.TbsocioLogic;
import com.seit.silaba.modelo.control.TbsociospuntosilabaLogic;
import com.seit.silaba.modelo.control.TbtemasareasLogic;
import com.seit.silaba.modelo.dto.RutaFormacionDTO;
import com.seit.silaba.modelo.dto.TbcatalogoareasDTO;
import com.seit.silaba.modelo.dto.TbcatalogocompetenciasDTO;
import com.seit.silaba.modelo.dto.TbcatalogoexperienciaaprendizajeDTO;
import com.seit.silaba.modelo.dto.TbcatalogopuntossilabaDTO;
import com.seit.silaba.modelo.dto.TbcompetenciasareasDTO;
import com.seit.silaba.modelo.dto.TbcompetenciaspuntossilabaDTO;
import com.seit.silaba.modelo.dto.TbcontenidosilaberDTO;
import com.seit.silaba.modelo.dto.TbelementosdidacticosDTO;
import com.seit.silaba.modelo.dto.TbestimulosdidacticossilaberxcompetenciasDTO;
import com.seit.silaba.modelo.dto.TbexperienciapuntosDTO;
import com.seit.silaba.modelo.dto.TbmapacompetenciassilaberDTO;
import com.seit.silaba.modelo.dto.TbmetasxniveleducativoDTO;
import com.seit.silaba.modelo.dto.TbniveleducativoDTO;
import com.seit.silaba.modelo.dto.TbprogramacionexperienciasilaberDTO;
import com.seit.silaba.modelo.dto.TbrutaexperienciaaprendizajeDTO;
import com.seit.silaba.modelo.dto.TbsilaberDTO;
import com.seit.silaba.modelo.dto.TbsocioDTO;
import com.seit.silaba.modelo.dto.TbsociospuntosilabaDTO;
import com.seit.silaba.modelo.dto.TbtemasareasDTO;
import com.seit.silaba.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private ITbcatalogoareasLogic tbcatalogoareasLogic;
    @Autowired
    private ITbcatalogocompetenciasLogic tbcatalogocompetenciasLogic;
    @Autowired
    private ITbcatalogoexperienciaaprendizajeLogic tbcatalogoexperienciaaprendizajeLogic;
    @Autowired
    private ITbcatalogopuntossilabaLogic tbcatalogopuntossilabaLogic;
    @Autowired
    private ITbcompetenciasareasLogic tbcompetenciasareasLogic;
    @Autowired
    private ITbcompetenciaspuntossilabaLogic tbcompetenciaspuntossilabaLogic;
    @Autowired
    private ITbcontenidosilaberLogic tbcontenidosilaberLogic;
    @Autowired
    private ITbelementosdidacticosLogic tbelementosdidacticosLogic;
    @Autowired
    private ITbestimulosdidacticossilaberxcompetenciasLogic tbestimulosdidacticossilaberxcompetenciasLogic;
    @Autowired
    private ITbexperienciapuntosLogic tbexperienciapuntosLogic;
    @Autowired
    private ITbmapacompetenciassilaberLogic tbmapacompetenciassilaberLogic;
    @Autowired
    private ITbmetasxniveleducativoLogic tbmetasxniveleducativoLogic;
    @Autowired
    private ITbniveleducativoLogic tbniveleducativoLogic;
    @Autowired
    private ITbprogramacionexperienciasilaberLogic tbprogramacionexperienciasilaberLogic;
    @Autowired
    private ITbrutaexperienciaaprendizajeLogic tbrutaexperienciaaprendizajeLogic;
    @Autowired
    private ITbsilaberLogic tbsilaberLogic;
    @Autowired
    private ITbsocioLogic tbsocioLogic;
    @Autowired
    private ITbsociospuntosilabaLogic tbsociospuntosilabaLogic;
    @Autowired
    private ITbtemasareasLogic tbtemasareasLogic;

    public List<Tbcatalogoareas> getTbcatalogoareas() throws Exception {
        return tbcatalogoareasLogic.getTbcatalogoareas();
    }

    public void saveTbcatalogoareas(Tbcatalogoareas entity)
        throws Exception {
        tbcatalogoareasLogic.saveTbcatalogoareas(entity);
    }

    public void deleteTbcatalogoareas(Tbcatalogoareas entity)
        throws Exception {
        tbcatalogoareasLogic.deleteTbcatalogoareas(entity);
    }

    public void updateTbcatalogoareas(Tbcatalogoareas entity)
        throws Exception {
        tbcatalogoareasLogic.updateTbcatalogoareas(entity);
    }

    public Tbcatalogoareas getTbcatalogoareas(Integer consecutivo)
        throws Exception {
        Tbcatalogoareas tbcatalogoareas = null;

        try {
            tbcatalogoareas = tbcatalogoareasLogic.getTbcatalogoareas(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbcatalogoareas;
    }

    public List<Tbcatalogoareas> findByCriteriaInTbcatalogoareas(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbcatalogoareasLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Tbcatalogoareas> findPageTbcatalogoareas(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbcatalogoareasLogic.findPageTbcatalogoareas(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbcatalogoareas() throws Exception {
        return tbcatalogoareasLogic.findTotalNumberTbcatalogoareas();
    }

    public List<TbcatalogoareasDTO> getDataTbcatalogoareas()
        throws Exception {
        return tbcatalogoareasLogic.getDataTbcatalogoareas();
    }

    public List<Tbcatalogocompetencias> getTbcatalogocompetencias()
        throws Exception {
        return tbcatalogocompetenciasLogic.getTbcatalogocompetencias();
    }

    public void saveTbcatalogocompetencias(Tbcatalogocompetencias entity)
        throws Exception {
        tbcatalogocompetenciasLogic.saveTbcatalogocompetencias(entity);
    }

    public void deleteTbcatalogocompetencias(Tbcatalogocompetencias entity)
        throws Exception {
        tbcatalogocompetenciasLogic.deleteTbcatalogocompetencias(entity);
    }

    public void updateTbcatalogocompetencias(Tbcatalogocompetencias entity)
        throws Exception {
        tbcatalogocompetenciasLogic.updateTbcatalogocompetencias(entity);
    }

    public Tbcatalogocompetencias getTbcatalogocompetencias(Integer consecutivo)
        throws Exception {
        Tbcatalogocompetencias tbcatalogocompetencias = null;

        try {
            tbcatalogocompetencias = tbcatalogocompetenciasLogic.getTbcatalogocompetencias(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbcatalogocompetencias;
    }

    public List<Tbcatalogocompetencias> findByCriteriaInTbcatalogocompetencias(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbcatalogocompetenciasLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<Tbcatalogocompetencias> findPageTbcatalogocompetencias(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbcatalogocompetenciasLogic.findPageTbcatalogocompetencias(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbcatalogocompetencias()
        throws Exception {
        return tbcatalogocompetenciasLogic.findTotalNumberTbcatalogocompetencias();
    }

    public List<TbcatalogocompetenciasDTO> getDataTbcatalogocompetencias()
        throws Exception {
        return tbcatalogocompetenciasLogic.getDataTbcatalogocompetencias();
    }

    public List<Tbcatalogoexperienciaaprendizaje> getTbcatalogoexperienciaaprendizaje()
        throws Exception {
        return tbcatalogoexperienciaaprendizajeLogic.getTbcatalogoexperienciaaprendizaje();
    }

    public void saveTbcatalogoexperienciaaprendizaje(
        Tbcatalogoexperienciaaprendizaje entity) throws Exception {
        tbcatalogoexperienciaaprendizajeLogic.saveTbcatalogoexperienciaaprendizaje(entity);
    }

    public void deleteTbcatalogoexperienciaaprendizaje(
        Tbcatalogoexperienciaaprendizaje entity) throws Exception {
        tbcatalogoexperienciaaprendizajeLogic.deleteTbcatalogoexperienciaaprendizaje(entity);
    }

    public void updateTbcatalogoexperienciaaprendizaje(
        Tbcatalogoexperienciaaprendizaje entity) throws Exception {
        tbcatalogoexperienciaaprendizajeLogic.updateTbcatalogoexperienciaaprendizaje(entity);
    }

    public Tbcatalogoexperienciaaprendizaje getTbcatalogoexperienciaaprendizaje(
        Integer consecutivo) throws Exception {
        Tbcatalogoexperienciaaprendizaje tbcatalogoexperienciaaprendizaje = null;

        try {
            tbcatalogoexperienciaaprendizaje = tbcatalogoexperienciaaprendizajeLogic.getTbcatalogoexperienciaaprendizaje(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbcatalogoexperienciaaprendizaje;
    }

    public List<Tbcatalogoexperienciaaprendizaje> findByCriteriaInTbcatalogoexperienciaaprendizaje(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbcatalogoexperienciaaprendizajeLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<Tbcatalogoexperienciaaprendizaje> findPageTbcatalogoexperienciaaprendizaje(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbcatalogoexperienciaaprendizajeLogic.findPageTbcatalogoexperienciaaprendizaje(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbcatalogoexperienciaaprendizaje()
        throws Exception {
        return tbcatalogoexperienciaaprendizajeLogic.findTotalNumberTbcatalogoexperienciaaprendizaje();
    }

    public List<TbcatalogoexperienciaaprendizajeDTO> getDataTbcatalogoexperienciaaprendizaje()
        throws Exception {
        return tbcatalogoexperienciaaprendizajeLogic.getDataTbcatalogoexperienciaaprendizaje();
    }

    public List<Tbcatalogopuntossilaba> getTbcatalogopuntossilaba()
        throws Exception {
        return tbcatalogopuntossilabaLogic.getTbcatalogopuntossilaba();
    }

    public void saveTbcatalogopuntossilaba(Tbcatalogopuntossilaba entity)
        throws Exception {
        tbcatalogopuntossilabaLogic.saveTbcatalogopuntossilaba(entity);
    }

    public void deleteTbcatalogopuntossilaba(Tbcatalogopuntossilaba entity)
        throws Exception {
        tbcatalogopuntossilabaLogic.deleteTbcatalogopuntossilaba(entity);
    }

    public void updateTbcatalogopuntossilaba(Tbcatalogopuntossilaba entity)
        throws Exception {
        tbcatalogopuntossilabaLogic.updateTbcatalogopuntossilaba(entity);
    }

    public Tbcatalogopuntossilaba getTbcatalogopuntossilaba(Integer consecutivo)
        throws Exception {
        Tbcatalogopuntossilaba tbcatalogopuntossilaba = null;

        try {
            tbcatalogopuntossilaba = tbcatalogopuntossilabaLogic.getTbcatalogopuntossilaba(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbcatalogopuntossilaba;
    }

    public List<Tbcatalogopuntossilaba> findByCriteriaInTbcatalogopuntossilaba(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbcatalogopuntossilabaLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<Tbcatalogopuntossilaba> findPageTbcatalogopuntossilaba(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbcatalogopuntossilabaLogic.findPageTbcatalogopuntossilaba(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbcatalogopuntossilaba()
        throws Exception {
        return tbcatalogopuntossilabaLogic.findTotalNumberTbcatalogopuntossilaba();
    }

    public List<TbcatalogopuntossilabaDTO> getDataTbcatalogopuntossilaba()
        throws Exception {
        return tbcatalogopuntossilabaLogic.getDataTbcatalogopuntossilaba();
    }

    public List<Tbcompetenciasareas> getTbcompetenciasareas()
        throws Exception {
        return tbcompetenciasareasLogic.getTbcompetenciasareas();
    }

    public void saveTbcompetenciasareas(Tbcompetenciasareas entity)
        throws Exception {
        tbcompetenciasareasLogic.saveTbcompetenciasareas(entity);
    }

    public void deleteTbcompetenciasareas(Tbcompetenciasareas entity)
        throws Exception {
        tbcompetenciasareasLogic.deleteTbcompetenciasareas(entity);
    }

    public void updateTbcompetenciasareas(Tbcompetenciasareas entity)
        throws Exception {
        tbcompetenciasareasLogic.updateTbcompetenciasareas(entity);
    }

    public Tbcompetenciasareas getTbcompetenciasareas(Integer consecutivo)
        throws Exception {
        Tbcompetenciasareas tbcompetenciasareas = null;

        try {
            tbcompetenciasareas = tbcompetenciasareasLogic.getTbcompetenciasareas(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbcompetenciasareas;
    }

    public List<Tbcompetenciasareas> findByCriteriaInTbcompetenciasareas(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbcompetenciasareasLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<Tbcompetenciasareas> findPageTbcompetenciasareas(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbcompetenciasareasLogic.findPageTbcompetenciasareas(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbcompetenciasareas() throws Exception {
        return tbcompetenciasareasLogic.findTotalNumberTbcompetenciasareas();
    }

    public List<TbcompetenciasareasDTO> getDataTbcompetenciasareas()
        throws Exception {
        return tbcompetenciasareasLogic.getDataTbcompetenciasareas();
    }

    public List<Tbcompetenciaspuntossilaba> getTbcompetenciaspuntossilaba()
        throws Exception {
        return tbcompetenciaspuntossilabaLogic.getTbcompetenciaspuntossilaba();
    }

    public void saveTbcompetenciaspuntossilaba(
        Tbcompetenciaspuntossilaba entity) throws Exception {
        tbcompetenciaspuntossilabaLogic.saveTbcompetenciaspuntossilaba(entity);
    }

    public void deleteTbcompetenciaspuntossilaba(
        Tbcompetenciaspuntossilaba entity) throws Exception {
        tbcompetenciaspuntossilabaLogic.deleteTbcompetenciaspuntossilaba(entity);
    }

    public void updateTbcompetenciaspuntossilaba(
        Tbcompetenciaspuntossilaba entity) throws Exception {
        tbcompetenciaspuntossilabaLogic.updateTbcompetenciaspuntossilaba(entity);
    }

    public Tbcompetenciaspuntossilaba getTbcompetenciaspuntossilaba(
        Integer consecutivo) throws Exception {
        Tbcompetenciaspuntossilaba tbcompetenciaspuntossilaba = null;

        try {
            tbcompetenciaspuntossilaba = tbcompetenciaspuntossilabaLogic.getTbcompetenciaspuntossilaba(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbcompetenciaspuntossilaba;
    }

    public List<Tbcompetenciaspuntossilaba> findByCriteriaInTbcompetenciaspuntossilaba(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbcompetenciaspuntossilabaLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<Tbcompetenciaspuntossilaba> findPageTbcompetenciaspuntossilaba(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbcompetenciaspuntossilabaLogic.findPageTbcompetenciaspuntossilaba(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbcompetenciaspuntossilaba()
        throws Exception {
        return tbcompetenciaspuntossilabaLogic.findTotalNumberTbcompetenciaspuntossilaba();
    }

    public List<TbcompetenciaspuntossilabaDTO> getDataTbcompetenciaspuntossilaba()
        throws Exception {
        return tbcompetenciaspuntossilabaLogic.getDataTbcompetenciaspuntossilaba();
    }

    public List<Tbcontenidosilaber> getTbcontenidosilaber()
        throws Exception {
        return tbcontenidosilaberLogic.getTbcontenidosilaber();
    }

    public void saveTbcontenidosilaber(Tbcontenidosilaber entity)
        throws Exception {
        tbcontenidosilaberLogic.saveTbcontenidosilaber(entity);
    }

    public void deleteTbcontenidosilaber(Tbcontenidosilaber entity)
        throws Exception {
        tbcontenidosilaberLogic.deleteTbcontenidosilaber(entity);
    }

    public void updateTbcontenidosilaber(Tbcontenidosilaber entity)
        throws Exception {
        tbcontenidosilaberLogic.updateTbcontenidosilaber(entity);
    }

    public Tbcontenidosilaber getTbcontenidosilaber(Integer consecutivo)
        throws Exception {
        Tbcontenidosilaber tbcontenidosilaber = null;

        try {
            tbcontenidosilaber = tbcontenidosilaberLogic.getTbcontenidosilaber(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbcontenidosilaber;
    }

    public List<Tbcontenidosilaber> findByCriteriaInTbcontenidosilaber(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbcontenidosilaberLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<Tbcontenidosilaber> findPageTbcontenidosilaber(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbcontenidosilaberLogic.findPageTbcontenidosilaber(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbcontenidosilaber() throws Exception {
        return tbcontenidosilaberLogic.findTotalNumberTbcontenidosilaber();
    }

    public List<TbcontenidosilaberDTO> getDataTbcontenidosilaber()
        throws Exception {
        return tbcontenidosilaberLogic.getDataTbcontenidosilaber();
    }

    public List<Tbelementosdidacticos> getTbelementosdidacticos()
        throws Exception {
        return tbelementosdidacticosLogic.getTbelementosdidacticos();
    }

    public void saveTbelementosdidacticos(Tbelementosdidacticos entity)
        throws Exception {
        tbelementosdidacticosLogic.saveTbelementosdidacticos(entity);
    }

    public void deleteTbelementosdidacticos(Tbelementosdidacticos entity)
        throws Exception {
        tbelementosdidacticosLogic.deleteTbelementosdidacticos(entity);
    }

    public void updateTbelementosdidacticos(Tbelementosdidacticos entity)
        throws Exception {
        tbelementosdidacticosLogic.updateTbelementosdidacticos(entity);
    }

    public Tbelementosdidacticos getTbelementosdidacticos(Integer consecutivo)
        throws Exception {
        Tbelementosdidacticos tbelementosdidacticos = null;

        try {
            tbelementosdidacticos = tbelementosdidacticosLogic.getTbelementosdidacticos(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbelementosdidacticos;
    }

    public List<Tbelementosdidacticos> findByCriteriaInTbelementosdidacticos(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbelementosdidacticosLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<Tbelementosdidacticos> findPageTbelementosdidacticos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbelementosdidacticosLogic.findPageTbelementosdidacticos(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbelementosdidacticos()
        throws Exception {
        return tbelementosdidacticosLogic.findTotalNumberTbelementosdidacticos();
    }

    public List<TbelementosdidacticosDTO> getDataTbelementosdidacticos()
        throws Exception {
        return tbelementosdidacticosLogic.getDataTbelementosdidacticos();
    }

    public List<Tbestimulosdidacticossilaberxcompetencias> getTbestimulosdidacticossilaberxcompetencias()
        throws Exception {
        return tbestimulosdidacticossilaberxcompetenciasLogic.getTbestimulosdidacticossilaberxcompetencias();
    }

    public void saveTbestimulosdidacticossilaberxcompetencias(
        Tbestimulosdidacticossilaberxcompetencias entity)
        throws Exception {
        tbestimulosdidacticossilaberxcompetenciasLogic.saveTbestimulosdidacticossilaberxcompetencias(entity);
    }

    public void deleteTbestimulosdidacticossilaberxcompetencias(
        Tbestimulosdidacticossilaberxcompetencias entity)
        throws Exception {
        tbestimulosdidacticossilaberxcompetenciasLogic.deleteTbestimulosdidacticossilaberxcompetencias(entity);
    }

    public void updateTbestimulosdidacticossilaberxcompetencias(
        Tbestimulosdidacticossilaberxcompetencias entity)
        throws Exception {
        tbestimulosdidacticossilaberxcompetenciasLogic.updateTbestimulosdidacticossilaberxcompetencias(entity);
    }

    public Tbestimulosdidacticossilaberxcompetencias getTbestimulosdidacticossilaberxcompetencias(
        Integer consecutivo) throws Exception {
        Tbestimulosdidacticossilaberxcompetencias tbestimulosdidacticossilaberxcompetencias =
            null;

        try {
            tbestimulosdidacticossilaberxcompetencias = tbestimulosdidacticossilaberxcompetenciasLogic.getTbestimulosdidacticossilaberxcompetencias(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbestimulosdidacticossilaberxcompetencias;
    }

    public List<Tbestimulosdidacticossilaberxcompetencias> findByCriteriaInTbestimulosdidacticossilaberxcompetencias(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbestimulosdidacticossilaberxcompetenciasLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<Tbestimulosdidacticossilaberxcompetencias> findPageTbestimulosdidacticossilaberxcompetencias(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbestimulosdidacticossilaberxcompetenciasLogic.findPageTbestimulosdidacticossilaberxcompetencias(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbestimulosdidacticossilaberxcompetencias()
        throws Exception {
        return tbestimulosdidacticossilaberxcompetenciasLogic.findTotalNumberTbestimulosdidacticossilaberxcompetencias();
    }

    public List<TbestimulosdidacticossilaberxcompetenciasDTO> getDataTbestimulosdidacticossilaberxcompetencias()
        throws Exception {
        return tbestimulosdidacticossilaberxcompetenciasLogic.getDataTbestimulosdidacticossilaberxcompetencias();
    }

    public List<Tbexperienciapuntos> getTbexperienciapuntos()
        throws Exception {
        return tbexperienciapuntosLogic.getTbexperienciapuntos();
    }

    public void saveTbexperienciapuntos(Tbexperienciapuntos entity)
        throws Exception {
        tbexperienciapuntosLogic.saveTbexperienciapuntos(entity);
    }

    public void deleteTbexperienciapuntos(Tbexperienciapuntos entity)
        throws Exception {
        tbexperienciapuntosLogic.deleteTbexperienciapuntos(entity);
    }

    public void updateTbexperienciapuntos(Tbexperienciapuntos entity)
        throws Exception {
        tbexperienciapuntosLogic.updateTbexperienciapuntos(entity);
    }

    public Tbexperienciapuntos getTbexperienciapuntos(Integer consecutivo)
        throws Exception {
        Tbexperienciapuntos tbexperienciapuntos = null;

        try {
            tbexperienciapuntos = tbexperienciapuntosLogic.getTbexperienciapuntos(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbexperienciapuntos;
    }

    public List<Tbexperienciapuntos> findByCriteriaInTbexperienciapuntos(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbexperienciapuntosLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<Tbexperienciapuntos> findPageTbexperienciapuntos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbexperienciapuntosLogic.findPageTbexperienciapuntos(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbexperienciapuntos() throws Exception {
        return tbexperienciapuntosLogic.findTotalNumberTbexperienciapuntos();
    }

    public List<TbexperienciapuntosDTO> getDataTbexperienciapuntos()
        throws Exception {
        return tbexperienciapuntosLogic.getDataTbexperienciapuntos();
    }

    public List<Tbmapacompetenciassilaber> getTbmapacompetenciassilaber()
        throws Exception {
        return tbmapacompetenciassilaberLogic.getTbmapacompetenciassilaber();
    }

    public void saveTbmapacompetenciassilaber(Tbmapacompetenciassilaber entity)
        throws Exception {
        tbmapacompetenciassilaberLogic.saveTbmapacompetenciassilaber(entity);
    }

    public void deleteTbmapacompetenciassilaber(
        Tbmapacompetenciassilaber entity) throws Exception {
        tbmapacompetenciassilaberLogic.deleteTbmapacompetenciassilaber(entity);
    }

    public void updateTbmapacompetenciassilaber(
        Tbmapacompetenciassilaber entity) throws Exception {
        tbmapacompetenciassilaberLogic.updateTbmapacompetenciassilaber(entity);
    }

    public Tbmapacompetenciassilaber getTbmapacompetenciassilaber(
        Integer consecutivo) throws Exception {
        Tbmapacompetenciassilaber tbmapacompetenciassilaber = null;

        try {
            tbmapacompetenciassilaber = tbmapacompetenciassilaberLogic.getTbmapacompetenciassilaber(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbmapacompetenciassilaber;
    }

    public List<Tbmapacompetenciassilaber> findByCriteriaInTbmapacompetenciassilaber(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbmapacompetenciassilaberLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<Tbmapacompetenciassilaber> findPageTbmapacompetenciassilaber(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbmapacompetenciassilaberLogic.findPageTbmapacompetenciassilaber(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbmapacompetenciassilaber()
        throws Exception {
        return tbmapacompetenciassilaberLogic.findTotalNumberTbmapacompetenciassilaber();
    }

    public List<TbmapacompetenciassilaberDTO> getDataTbmapacompetenciassilaber()
        throws Exception {
        return tbmapacompetenciassilaberLogic.getDataTbmapacompetenciassilaber();
    }

    public List<Tbmetasxniveleducativo> getTbmetasxniveleducativo()
        throws Exception {
        return tbmetasxniveleducativoLogic.getTbmetasxniveleducativo();
    }

    public void saveTbmetasxniveleducativo(Tbmetasxniveleducativo entity)
        throws Exception {
        tbmetasxniveleducativoLogic.saveTbmetasxniveleducativo(entity);
    }

    public void deleteTbmetasxniveleducativo(Tbmetasxniveleducativo entity)
        throws Exception {
        tbmetasxniveleducativoLogic.deleteTbmetasxniveleducativo(entity);
    }

    public void updateTbmetasxniveleducativo(Tbmetasxniveleducativo entity)
        throws Exception {
        tbmetasxniveleducativoLogic.updateTbmetasxniveleducativo(entity);
    }

    public Tbmetasxniveleducativo getTbmetasxniveleducativo(Integer cosecutivo)
        throws Exception {
        Tbmetasxniveleducativo tbmetasxniveleducativo = null;

        try {
            tbmetasxniveleducativo = tbmetasxniveleducativoLogic.getTbmetasxniveleducativo(cosecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbmetasxniveleducativo;
    }

    public List<Tbmetasxniveleducativo> findByCriteriaInTbmetasxniveleducativo(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbmetasxniveleducativoLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<Tbmetasxniveleducativo> findPageTbmetasxniveleducativo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbmetasxniveleducativoLogic.findPageTbmetasxniveleducativo(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbmetasxniveleducativo()
        throws Exception {
        return tbmetasxniveleducativoLogic.findTotalNumberTbmetasxniveleducativo();
    }

    public List<TbmetasxniveleducativoDTO> getDataTbmetasxniveleducativo()
        throws Exception {
        return tbmetasxniveleducativoLogic.getDataTbmetasxniveleducativo();
    }

    public List<Tbniveleducativo> getTbniveleducativo()
        throws Exception {
        return tbniveleducativoLogic.getTbniveleducativo();
    }

    public void saveTbniveleducativo(Tbniveleducativo entity)
        throws Exception {
        tbniveleducativoLogic.saveTbniveleducativo(entity);
    }

    public void deleteTbniveleducativo(Tbniveleducativo entity)
        throws Exception {
        tbniveleducativoLogic.deleteTbniveleducativo(entity);
    }

    public void updateTbniveleducativo(Tbniveleducativo entity)
        throws Exception {
        tbniveleducativoLogic.updateTbniveleducativo(entity);
    }

    public Tbniveleducativo getTbniveleducativo(Integer consecutivo)
        throws Exception {
        Tbniveleducativo tbniveleducativo = null;

        try {
            tbniveleducativo = tbniveleducativoLogic.getTbniveleducativo(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbniveleducativo;
    }

    public List<Tbniveleducativo> findByCriteriaInTbniveleducativo(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbniveleducativoLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<Tbniveleducativo> findPageTbniveleducativo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbniveleducativoLogic.findPageTbniveleducativo(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbniveleducativo() throws Exception {
        return tbniveleducativoLogic.findTotalNumberTbniveleducativo();
    }

    public List<TbniveleducativoDTO> getDataTbniveleducativo()
        throws Exception {
        return tbniveleducativoLogic.getDataTbniveleducativo();
    }

    public List<Tbprogramacionexperienciasilaber> getTbprogramacionexperienciasilaber()
        throws Exception {
        return tbprogramacionexperienciasilaberLogic.getTbprogramacionexperienciasilaber();
    }

    public void saveTbprogramacionexperienciasilaber(
        Tbprogramacionexperienciasilaber entity) throws Exception {
        tbprogramacionexperienciasilaberLogic.saveTbprogramacionexperienciasilaber(entity);
    }

    public void deleteTbprogramacionexperienciasilaber(
        Tbprogramacionexperienciasilaber entity) throws Exception {
        tbprogramacionexperienciasilaberLogic.deleteTbprogramacionexperienciasilaber(entity);
    }

    public void updateTbprogramacionexperienciasilaber(
        Tbprogramacionexperienciasilaber entity) throws Exception {
        tbprogramacionexperienciasilaberLogic.updateTbprogramacionexperienciasilaber(entity);
    }

    public Tbprogramacionexperienciasilaber getTbprogramacionexperienciasilaber(
        Integer consecutivo) throws Exception {
        Tbprogramacionexperienciasilaber tbprogramacionexperienciasilaber = null;

        try {
            tbprogramacionexperienciasilaber = tbprogramacionexperienciasilaberLogic.getTbprogramacionexperienciasilaber(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbprogramacionexperienciasilaber;
    }

    public List<Tbprogramacionexperienciasilaber> findByCriteriaInTbprogramacionexperienciasilaber(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbprogramacionexperienciasilaberLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<Tbprogramacionexperienciasilaber> findPageTbprogramacionexperienciasilaber(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbprogramacionexperienciasilaberLogic.findPageTbprogramacionexperienciasilaber(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbprogramacionexperienciasilaber()
        throws Exception {
        return tbprogramacionexperienciasilaberLogic.findTotalNumberTbprogramacionexperienciasilaber();
    }

    public List<TbprogramacionexperienciasilaberDTO> getDataTbprogramacionexperienciasilaber()
        throws Exception {
        return tbprogramacionexperienciasilaberLogic.getDataTbprogramacionexperienciasilaber();
    }

    public List<Tbrutaexperienciaaprendizaje> getTbrutaexperienciaaprendizaje()
        throws Exception {
        return tbrutaexperienciaaprendizajeLogic.getTbrutaexperienciaaprendizaje();
    }

    public void saveTbrutaexperienciaaprendizaje(
        Tbrutaexperienciaaprendizaje entity) throws Exception {
        tbrutaexperienciaaprendizajeLogic.saveTbrutaexperienciaaprendizaje(entity);
    }

    public void deleteTbrutaexperienciaaprendizaje(
        Tbrutaexperienciaaprendizaje entity) throws Exception {
        tbrutaexperienciaaprendizajeLogic.deleteTbrutaexperienciaaprendizaje(entity);
    }

    public void updateTbrutaexperienciaaprendizaje(
        Tbrutaexperienciaaprendizaje entity) throws Exception {
        tbrutaexperienciaaprendizajeLogic.updateTbrutaexperienciaaprendizaje(entity);
    }

    public Tbrutaexperienciaaprendizaje getTbrutaexperienciaaprendizaje(
        Integer consecutivo) throws Exception {
        Tbrutaexperienciaaprendizaje tbrutaexperienciaaprendizaje = null;

        try {
            tbrutaexperienciaaprendizaje = tbrutaexperienciaaprendizajeLogic.getTbrutaexperienciaaprendizaje(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbrutaexperienciaaprendizaje;
    }

    public List<Tbrutaexperienciaaprendizaje> findByCriteriaInTbrutaexperienciaaprendizaje(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbrutaexperienciaaprendizajeLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<Tbrutaexperienciaaprendizaje> findPageTbrutaexperienciaaprendizaje(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbrutaexperienciaaprendizajeLogic.findPageTbrutaexperienciaaprendizaje(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbrutaexperienciaaprendizaje()
        throws Exception {
        return tbrutaexperienciaaprendizajeLogic.findTotalNumberTbrutaexperienciaaprendizaje();
    }

    public List<TbrutaexperienciaaprendizajeDTO> getDataTbrutaexperienciaaprendizaje()
        throws Exception {
        return tbrutaexperienciaaprendizajeLogic.getDataTbrutaexperienciaaprendizaje();
    }

    public List<Tbsilaber> getTbsilaber() throws Exception {
        return tbsilaberLogic.getTbsilaber();
    }

    public void saveTbsilaber(Tbsilaber entity) throws Exception {
        tbsilaberLogic.saveTbsilaber(entity);
    }

    public void deleteTbsilaber(Tbsilaber entity) throws Exception {
        tbsilaberLogic.deleteTbsilaber(entity);
    }

    public void updateTbsilaber(Tbsilaber entity) throws Exception {
        tbsilaberLogic.updateTbsilaber(entity);
    }

    public Tbsilaber getTbsilaber(Integer consecutivo)
        throws Exception {
        Tbsilaber tbsilaber = null;

        try {
            tbsilaber = tbsilaberLogic.getTbsilaber(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbsilaber;
    }
    public List<TbrutaexperienciaaprendizajeDTO> getDataTbrutaexperienciaaprendizaje(Integer codSilaber)
            throws Exception{
    	return tbrutaexperienciaaprendizajeLogic.getDataTbrutaexperienciaaprendizaje(codSilaber);
    }

    public List<Tbsilaber> findByCriteriaInTbsilaber(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tbsilaberLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Tbsilaber> findPageTbsilaber(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tbsilaberLogic.findPageTbsilaber(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberTbsilaber() throws Exception {
        return tbsilaberLogic.findTotalNumberTbsilaber();
    }

    public List<TbsilaberDTO> getDataTbsilaber() throws Exception {
        return tbsilaberLogic.getDataTbsilaber();
    }

    public List<Tbsocio> getTbsocio() throws Exception {
        return tbsocioLogic.getTbsocio();
    }

    public void saveTbsocio(Tbsocio entity) throws Exception {
        tbsocioLogic.saveTbsocio(entity);
    }

    public void deleteTbsocio(Tbsocio entity) throws Exception {
        tbsocioLogic.deleteTbsocio(entity);
    }

    public void updateTbsocio(Tbsocio entity) throws Exception {
        tbsocioLogic.updateTbsocio(entity);
    }

    public Tbsocio getTbsocio(Integer consecutivo) throws Exception {
        Tbsocio tbsocio = null;

        try {
            tbsocio = tbsocioLogic.getTbsocio(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbsocio;
    }

    public List<Tbsocio> findByCriteriaInTbsocio(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tbsocioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Tbsocio> findPageTbsocio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tbsocioLogic.findPageTbsocio(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberTbsocio() throws Exception {
        return tbsocioLogic.findTotalNumberTbsocio();
    }

    public List<TbsocioDTO> getDataTbsocio() throws Exception {
        return tbsocioLogic.getDataTbsocio();
    }

    public List<Tbsociospuntosilaba> getTbsociospuntosilaba()
        throws Exception {
        return tbsociospuntosilabaLogic.getTbsociospuntosilaba();
    }

    public void saveTbsociospuntosilaba(Tbsociospuntosilaba entity)
        throws Exception {
        tbsociospuntosilabaLogic.saveTbsociospuntosilaba(entity);
    }

    public void deleteTbsociospuntosilaba(Tbsociospuntosilaba entity)
        throws Exception {
        tbsociospuntosilabaLogic.deleteTbsociospuntosilaba(entity);
    }

    public void updateTbsociospuntosilaba(Tbsociospuntosilaba entity)
        throws Exception {
        tbsociospuntosilabaLogic.updateTbsociospuntosilaba(entity);
    }

    public Tbsociospuntosilaba getTbsociospuntosilaba(Integer consecutivo)
        throws Exception {
        Tbsociospuntosilaba tbsociospuntosilaba = null;

        try {
            tbsociospuntosilaba = tbsociospuntosilabaLogic.getTbsociospuntosilaba(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbsociospuntosilaba;
    }

    public List<Tbsociospuntosilaba> findByCriteriaInTbsociospuntosilaba(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tbsociospuntosilabaLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<Tbsociospuntosilaba> findPageTbsociospuntosilaba(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tbsociospuntosilabaLogic.findPageTbsociospuntosilaba(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbsociospuntosilaba() throws Exception {
        return tbsociospuntosilabaLogic.findTotalNumberTbsociospuntosilaba();
    }

    public List<TbsociospuntosilabaDTO> getDataTbsociospuntosilaba()
        throws Exception {
        return tbsociospuntosilabaLogic.getDataTbsociospuntosilaba();
    }

    public List<Tbtemasareas> getTbtemasareas() throws Exception {
        return tbtemasareasLogic.getTbtemasareas();
    }

    public void saveTbtemasareas(Tbtemasareas entity) throws Exception {
        tbtemasareasLogic.saveTbtemasareas(entity);
    }

    public void deleteTbtemasareas(Tbtemasareas entity)
        throws Exception {
        tbtemasareasLogic.deleteTbtemasareas(entity);
    }

    public void updateTbtemasareas(Tbtemasareas entity)
        throws Exception {
        tbtemasareasLogic.updateTbtemasareas(entity);
    }

    public Tbtemasareas getTbtemasareas(Integer consecutivo)
        throws Exception {
        Tbtemasareas tbtemasareas = null;

        try {
            tbtemasareas = tbtemasareasLogic.getTbtemasareas(consecutivo);
        } catch (Exception e) {
            throw e;
        }

        return tbtemasareas;
    }

    public List<Tbtemasareas> findByCriteriaInTbtemasareas(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tbtemasareasLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Tbtemasareas> findPageTbtemasareas(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tbtemasareasLogic.findPageTbtemasareas(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTbtemasareas() throws Exception {
        return tbtemasareasLogic.findTotalNumberTbtemasareas();
    }

    public List<TbtemasareasDTO> getDataTbtemasareas()
        throws Exception {
        return tbtemasareasLogic.getDataTbtemasareas();
    }
    public List<Tbrutaexperienciaaprendizaje> consultarRutasFormacion(String user) throws Exception{
    	return tbrutaexperienciaaprendizajeLogic.consultarRutasFormacion(user);
    }
}
