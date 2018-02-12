package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbcompetenciasareasDTO;
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
public class TbcompetenciasareasView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbcompetenciasareasView.class);
    private InputText txtConsecutivo_Tbcatalogocompetencias;
    private InputText txtConsecutivo_Tbtemasareas;
    private InputText txtConsecutivo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TbcompetenciasareasDTO> data;
    private TbcompetenciasareasDTO selectedTbcompetenciasareas;
    private Tbcompetenciasareas entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TbcompetenciasareasView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TbcompetenciasareasDTO tbcompetenciasareasDTO = (TbcompetenciasareasDTO) e.getObject();

            if (txtConsecutivo_Tbcatalogocompetencias == null) {
                txtConsecutivo_Tbcatalogocompetencias = new InputText();
            }

            txtConsecutivo_Tbcatalogocompetencias.setValue(tbcompetenciasareasDTO.getConsecutivo_Tbcatalogocompetencias());

            if (txtConsecutivo_Tbtemasareas == null) {
                txtConsecutivo_Tbtemasareas = new InputText();
            }

            txtConsecutivo_Tbtemasareas.setValue(tbcompetenciasareasDTO.getConsecutivo_Tbtemasareas());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }

            txtConsecutivo.setValue(tbcompetenciasareasDTO.getConsecutivo());

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbcompetenciasareas(consecutivo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTbcompetenciasareas = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTbcompetenciasareas = null;

        if (txtConsecutivo_Tbcatalogocompetencias != null) {
            txtConsecutivo_Tbcatalogocompetencias.setValue(null);
            txtConsecutivo_Tbcatalogocompetencias.setDisabled(true);
        }

        if (txtConsecutivo_Tbtemasareas != null) {
            txtConsecutivo_Tbtemasareas.setValue(null);
            txtConsecutivo_Tbtemasareas.setDisabled(true);
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
                ? businessDelegatorView.getTbcompetenciasareas(consecutivo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtConsecutivo_Tbcatalogocompetencias.setDisabled(false);
            txtConsecutivo_Tbtemasareas.setDisabled(false);
            txtConsecutivo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtConsecutivo_Tbcatalogocompetencias.setValue(entity.getTbcatalogocompetencias()
                                                                 .getConsecutivo());
            txtConsecutivo_Tbcatalogocompetencias.setDisabled(false);
            txtConsecutivo_Tbtemasareas.setValue(entity.getTbtemasareas()
                                                       .getConsecutivo());
            txtConsecutivo_Tbtemasareas.setDisabled(false);
            txtConsecutivo.setValue(entity.getConsecutivo());
            txtConsecutivo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTbcompetenciasareas = (TbcompetenciasareasDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedTbcompetenciasareas"));
        txtConsecutivo_Tbcatalogocompetencias.setValue(selectedTbcompetenciasareas.getConsecutivo_Tbcatalogocompetencias());
        txtConsecutivo_Tbcatalogocompetencias.setDisabled(false);
        txtConsecutivo_Tbtemasareas.setValue(selectedTbcompetenciasareas.getConsecutivo_Tbtemasareas());
        txtConsecutivo_Tbtemasareas.setDisabled(false);
        txtConsecutivo.setValue(selectedTbcompetenciasareas.getConsecutivo());
        txtConsecutivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTbcompetenciasareas == null) && (entity == null)) {
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
            entity = new Tbcompetenciasareas();

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);

            entity.setConsecutivo(consecutivo);
            entity.setTbcatalogocompetencias((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogocompetencias) != null)
                ? businessDelegatorView.getTbcatalogocompetencias(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogocompetencias)) : null);
            entity.setTbtemasareas((FacesUtils.checkInteger(
                    txtConsecutivo_Tbtemasareas) != null)
                ? businessDelegatorView.getTbtemasareas(FacesUtils.checkInteger(
                        txtConsecutivo_Tbtemasareas)) : null);
            businessDelegatorView.saveTbcompetenciasareas(entity);
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
                Integer consecutivo = new Integer(selectedTbcompetenciasareas.getConsecutivo());
                entity = businessDelegatorView.getTbcompetenciasareas(consecutivo);
            }

            entity.setTbcatalogocompetencias((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogocompetencias) != null)
                ? businessDelegatorView.getTbcatalogocompetencias(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogocompetencias)) : null);
            entity.setTbtemasareas((FacesUtils.checkInteger(
                    txtConsecutivo_Tbtemasareas) != null)
                ? businessDelegatorView.getTbtemasareas(FacesUtils.checkInteger(
                        txtConsecutivo_Tbtemasareas)) : null);
            businessDelegatorView.updateTbcompetenciasareas(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTbcompetenciasareas = (TbcompetenciasareasDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedTbcompetenciasareas"));

            Integer consecutivo = new Integer(selectedTbcompetenciasareas.getConsecutivo());
            entity = businessDelegatorView.getTbcompetenciasareas(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbcompetenciasareas(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTbcompetenciasareas(entity);
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
            selectedTbcompetenciasareas = (TbcompetenciasareasDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedTbcompetenciasareas"));

            Integer consecutivo = new Integer(selectedTbcompetenciasareas.getConsecutivo());
            entity = businessDelegatorView.getTbcompetenciasareas(consecutivo);
            businessDelegatorView.deleteTbcompetenciasareas(entity);
            data.remove(selectedTbcompetenciasareas);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer consecutivo,
        Integer consecutivo_Tbcatalogocompetencias,
        Integer consecutivo_Tbtemasareas) throws Exception {
        try {
            businessDelegatorView.updateTbcompetenciasareas(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TbcompetenciasareasView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtConsecutivo_Tbcatalogocompetencias() {
        return txtConsecutivo_Tbcatalogocompetencias;
    }

    public void setTxtConsecutivo_Tbcatalogocompetencias(
        InputText txtConsecutivo_Tbcatalogocompetencias) {
        this.txtConsecutivo_Tbcatalogocompetencias = txtConsecutivo_Tbcatalogocompetencias;
    }

    public InputText getTxtConsecutivo_Tbtemasareas() {
        return txtConsecutivo_Tbtemasareas;
    }

    public void setTxtConsecutivo_Tbtemasareas(
        InputText txtConsecutivo_Tbtemasareas) {
        this.txtConsecutivo_Tbtemasareas = txtConsecutivo_Tbtemasareas;
    }

    public InputText getTxtConsecutivo() {
        return txtConsecutivo;
    }

    public void setTxtConsecutivo(InputText txtConsecutivo) {
        this.txtConsecutivo = txtConsecutivo;
    }

    public List<TbcompetenciasareasDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTbcompetenciasareas();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TbcompetenciasareasDTO> tbcompetenciasareasDTO) {
        this.data = tbcompetenciasareasDTO;
    }

    public TbcompetenciasareasDTO getSelectedTbcompetenciasareas() {
        return selectedTbcompetenciasareas;
    }

    public void setSelectedTbcompetenciasareas(
        TbcompetenciasareasDTO tbcompetenciasareas) {
        this.selectedTbcompetenciasareas = tbcompetenciasareas;
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
}
