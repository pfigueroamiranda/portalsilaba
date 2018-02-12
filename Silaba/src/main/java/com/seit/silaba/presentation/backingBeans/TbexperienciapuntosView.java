package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbexperienciapuntosDTO;
import com.seit.silaba.presentation.businessDelegate.*;
import com.seit.silaba.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TbexperienciapuntosView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbexperienciapuntosView.class);
    private InputText txtConsecutivo_Tbcatalogoexperienciaaprendizaje;
    private InputText txtConsecutivo_Tbcatalogopuntossilaba;
    private InputText txtConsecutivo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TbexperienciapuntosDTO> data;
    private TbexperienciapuntosDTO selectedTbexperienciapuntos;
    private Tbexperienciapuntos entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;
    
    private List<Tbexperienciapuntos> listaExperienciaXPunto ;

    public TbexperienciapuntosView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TbexperienciapuntosDTO tbexperienciapuntosDTO = (TbexperienciapuntosDTO) e.getObject();

            if (txtConsecutivo_Tbcatalogoexperienciaaprendizaje == null) {
                txtConsecutivo_Tbcatalogoexperienciaaprendizaje = new InputText();
            }

            txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setValue(tbexperienciapuntosDTO.getConsecutivo_Tbcatalogoexperienciaaprendizaje());

            if (txtConsecutivo_Tbcatalogopuntossilaba == null) {
                txtConsecutivo_Tbcatalogopuntossilaba = new InputText();
            }

            txtConsecutivo_Tbcatalogopuntossilaba.setValue(tbexperienciapuntosDTO.getConsecutivo_Tbcatalogopuntossilaba());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }

            txtConsecutivo.setValue(tbexperienciapuntosDTO.getConsecutivo());

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbexperienciapuntos(consecutivo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTbexperienciapuntos = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTbexperienciapuntos = null;

        if (txtConsecutivo_Tbcatalogoexperienciaaprendizaje != null) {
            txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setValue(null);
            txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setDisabled(true);
        }

        if (txtConsecutivo_Tbcatalogopuntossilaba != null) {
            txtConsecutivo_Tbcatalogopuntossilaba.setValue(null);
            txtConsecutivo_Tbcatalogopuntossilaba.setDisabled(true);
        }

        if (txtConsecutivo != null) {
            txtConsecutivo.setValue(null);
            txtConsecutivo.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = (consecutivo != null)
                ? businessDelegatorView.getTbexperienciapuntos(consecutivo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setDisabled(false);
            txtConsecutivo_Tbcatalogopuntossilaba.setDisabled(false);
            txtConsecutivo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setValue(entity.getTbcatalogoexperienciaaprendizaje()
                                                                           .getConsecutivo());
            txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setDisabled(false);
            txtConsecutivo_Tbcatalogopuntossilaba.setValue(entity.getTbcatalogopuntossilaba()
                                                                 .getConsecutivo());
            txtConsecutivo_Tbcatalogopuntossilaba.setDisabled(false);
            txtConsecutivo.setValue(entity.getConsecutivo());
            txtConsecutivo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTbexperienciapuntos = (TbexperienciapuntosDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedTbexperienciapuntos"));
        txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setValue(selectedTbexperienciapuntos.getConsecutivo_Tbcatalogoexperienciaaprendizaje());
        txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setDisabled(false);
        txtConsecutivo_Tbcatalogopuntossilaba.setValue(selectedTbexperienciapuntos.getConsecutivo_Tbcatalogopuntossilaba());
        txtConsecutivo_Tbcatalogopuntossilaba.setDisabled(false);
        txtConsecutivo.setValue(selectedTbexperienciapuntos.getConsecutivo());
        txtConsecutivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTbexperienciapuntos == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new Tbexperienciapuntos();

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);

            entity.setConsecutivo(consecutivo);
            entity.setTbcatalogoexperienciaaprendizaje((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogoexperienciaaprendizaje) != null)
                ? businessDelegatorView.getTbcatalogoexperienciaaprendizaje(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogoexperienciaaprendizaje)) : null);
            entity.setTbcatalogopuntossilaba((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogopuntossilaba) != null)
                ? businessDelegatorView.getTbcatalogopuntossilaba(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogopuntossilaba)) : null);
            businessDelegatorView.saveTbexperienciapuntos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Integer consecutivo = new Integer(selectedTbexperienciapuntos.getConsecutivo());
                entity = businessDelegatorView.getTbexperienciapuntos(consecutivo);
            }

            entity.setTbcatalogoexperienciaaprendizaje((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogoexperienciaaprendizaje) != null)
                ? businessDelegatorView.getTbcatalogoexperienciaaprendizaje(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogoexperienciaaprendizaje)) : null);
            entity.setTbcatalogopuntossilaba((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogopuntossilaba) != null)
                ? businessDelegatorView.getTbcatalogopuntossilaba(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogopuntossilaba)) : null);
            businessDelegatorView.updateTbexperienciapuntos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTbexperienciapuntos = (TbexperienciapuntosDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedTbexperienciapuntos"));

            Integer consecutivo = new Integer(selectedTbexperienciapuntos.getConsecutivo());
            entity = businessDelegatorView.getTbexperienciapuntos(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbexperienciapuntos(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTbexperienciapuntos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String actionDeleteDataTableEditable(ActionEvent evt) {
        try {
            selectedTbexperienciapuntos = (TbexperienciapuntosDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedTbexperienciapuntos"));

            Integer consecutivo = new Integer(selectedTbexperienciapuntos.getConsecutivo());
            entity = businessDelegatorView.getTbexperienciapuntos(consecutivo);
            businessDelegatorView.deleteTbexperienciapuntos(entity);
            data.remove(selectedTbexperienciapuntos);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer consecutivo,
        Integer consecutivo_Tbcatalogoexperienciaaprendizaje,
        Integer consecutivo_Tbcatalogopuntossilaba) throws Exception {
        try {
            businessDelegatorView.updateTbexperienciapuntos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TbexperienciapuntosView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }
   
/******************DESARROLLO NUEVO**************/
    
public String consultarExperienciaXPuntoSilaba(){
	
	/*  Object[] variables = {"tbsilaber.consecutivo", false, codSilaber, "="};
	
	listaExperienciaXPunto */
	return "";
	
}
    public InputText getTxtConsecutivo_Tbcatalogoexperienciaaprendizaje() {
        return txtConsecutivo_Tbcatalogoexperienciaaprendizaje;
    }

    public void setTxtConsecutivo_Tbcatalogoexperienciaaprendizaje(
        InputText txtConsecutivo_Tbcatalogoexperienciaaprendizaje) {
        this.txtConsecutivo_Tbcatalogoexperienciaaprendizaje = txtConsecutivo_Tbcatalogoexperienciaaprendizaje;
    }

    public InputText getTxtConsecutivo_Tbcatalogopuntossilaba() {
        return txtConsecutivo_Tbcatalogopuntossilaba;
    }

    public void setTxtConsecutivo_Tbcatalogopuntossilaba(
        InputText txtConsecutivo_Tbcatalogopuntossilaba) {
        this.txtConsecutivo_Tbcatalogopuntossilaba = txtConsecutivo_Tbcatalogopuntossilaba;
    }

    public InputText getTxtConsecutivo() {
        return txtConsecutivo;
    }

    public void setTxtConsecutivo(InputText txtConsecutivo) {
        this.txtConsecutivo = txtConsecutivo;
    }

    public List<TbexperienciapuntosDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTbexperienciapuntos();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TbexperienciapuntosDTO> tbexperienciapuntosDTO) {
        this.data = tbexperienciapuntosDTO;
    }

    public TbexperienciapuntosDTO getSelectedTbexperienciapuntos() {
        return selectedTbexperienciapuntos;
    }

    public void setSelectedTbexperienciapuntos(
        TbexperienciapuntosDTO tbexperienciapuntos) {
        this.selectedTbexperienciapuntos = tbexperienciapuntos;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }

	public List<Tbexperienciapuntos> getListaExperienciaXPunto() {
		return listaExperienciaXPunto;
	}

	public void setListaExperienciaXPunto(List<Tbexperienciapuntos> listaExperienciaXPunto) {
		this.listaExperienciaXPunto = listaExperienciaXPunto;
	}
}
