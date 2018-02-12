package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbestimulosdidacticossilaberxcompetenciasDTO;
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
public class TbestimulosdidacticossilaberxcompetenciasView
    implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbestimulosdidacticossilaberxcompetenciasView.class);
    private InputText txtConsecutivo_Tbelementosdidacticos;
    private InputText txtConsecutivo_Tbmapacompetenciassilaber;
    private InputText txtConsecutivo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TbestimulosdidacticossilaberxcompetenciasDTO> data;
    private TbestimulosdidacticossilaberxcompetenciasDTO selectedTbestimulosdidacticossilaberxcompetencias;
    private Tbestimulosdidacticossilaberxcompetencias entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TbestimulosdidacticossilaberxcompetenciasView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TbestimulosdidacticossilaberxcompetenciasDTO tbestimulosdidacticossilaberxcompetenciasDTO =
                (TbestimulosdidacticossilaberxcompetenciasDTO) e.getObject();

            if (txtConsecutivo_Tbelementosdidacticos == null) {
                txtConsecutivo_Tbelementosdidacticos = new InputText();
            }

            txtConsecutivo_Tbelementosdidacticos.setValue(tbestimulosdidacticossilaberxcompetenciasDTO.getConsecutivo_Tbelementosdidacticos());

            if (txtConsecutivo_Tbmapacompetenciassilaber == null) {
                txtConsecutivo_Tbmapacompetenciassilaber = new InputText();
            }

            txtConsecutivo_Tbmapacompetenciassilaber.setValue(tbestimulosdidacticossilaberxcompetenciasDTO.getConsecutivo_Tbmapacompetenciassilaber());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }

            txtConsecutivo.setValue(tbestimulosdidacticossilaberxcompetenciasDTO.getConsecutivo());

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbestimulosdidacticossilaberxcompetencias(consecutivo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTbestimulosdidacticossilaberxcompetencias = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTbestimulosdidacticossilaberxcompetencias = null;

        if (txtConsecutivo_Tbelementosdidacticos != null) {
            txtConsecutivo_Tbelementosdidacticos.setValue(null);
            txtConsecutivo_Tbelementosdidacticos.setDisabled(true);
        }

        if (txtConsecutivo_Tbmapacompetenciassilaber != null) {
            txtConsecutivo_Tbmapacompetenciassilaber.setValue(null);
            txtConsecutivo_Tbmapacompetenciassilaber.setDisabled(true);
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
                ? businessDelegatorView.getTbestimulosdidacticossilaberxcompetencias(consecutivo)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtConsecutivo_Tbelementosdidacticos.setDisabled(false);
            txtConsecutivo_Tbmapacompetenciassilaber.setDisabled(false);
            txtConsecutivo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtConsecutivo_Tbelementosdidacticos.setValue(entity.getTbelementosdidacticos()
                                                                .getConsecutivo());
            txtConsecutivo_Tbelementosdidacticos.setDisabled(false);
            txtConsecutivo_Tbmapacompetenciassilaber.setValue(entity.getTbmapacompetenciassilaber()
                                                                    .getConsecutivo());
            txtConsecutivo_Tbmapacompetenciassilaber.setDisabled(false);
            txtConsecutivo.setValue(entity.getConsecutivo());
            txtConsecutivo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTbestimulosdidacticossilaberxcompetencias = (TbestimulosdidacticossilaberxcompetenciasDTO) (evt.getComponent()
                                                                                                               .getAttributes()
                                                                                                               .get("selectedTbestimulosdidacticossilaberxcompetencias"));
        txtConsecutivo_Tbelementosdidacticos.setValue(selectedTbestimulosdidacticossilaberxcompetencias.getConsecutivo_Tbelementosdidacticos());
        txtConsecutivo_Tbelementosdidacticos.setDisabled(false);
        txtConsecutivo_Tbmapacompetenciassilaber.setValue(selectedTbestimulosdidacticossilaberxcompetencias.getConsecutivo_Tbmapacompetenciassilaber());
        txtConsecutivo_Tbmapacompetenciassilaber.setDisabled(false);
        txtConsecutivo.setValue(selectedTbestimulosdidacticossilaberxcompetencias.getConsecutivo());
        txtConsecutivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTbestimulosdidacticossilaberxcompetencias == null) &&
                    (entity == null)) {
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
            entity = new Tbestimulosdidacticossilaberxcompetencias();

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);

            entity.setConsecutivo(consecutivo);
            entity.setTbelementosdidacticos((FacesUtils.checkInteger(
                    txtConsecutivo_Tbelementosdidacticos) != null)
                ? businessDelegatorView.getTbelementosdidacticos(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbelementosdidacticos)) : null);
            entity.setTbmapacompetenciassilaber((FacesUtils.checkInteger(
                    txtConsecutivo_Tbmapacompetenciassilaber) != null)
                ? businessDelegatorView.getTbmapacompetenciassilaber(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbmapacompetenciassilaber)) : null);
            businessDelegatorView.saveTbestimulosdidacticossilaberxcompetencias(entity);
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
                Integer consecutivo = new Integer(selectedTbestimulosdidacticossilaberxcompetencias.getConsecutivo());
                entity = businessDelegatorView.getTbestimulosdidacticossilaberxcompetencias(consecutivo);
            }

            entity.setTbelementosdidacticos((FacesUtils.checkInteger(
                    txtConsecutivo_Tbelementosdidacticos) != null)
                ? businessDelegatorView.getTbelementosdidacticos(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbelementosdidacticos)) : null);
            entity.setTbmapacompetenciassilaber((FacesUtils.checkInteger(
                    txtConsecutivo_Tbmapacompetenciassilaber) != null)
                ? businessDelegatorView.getTbmapacompetenciassilaber(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbmapacompetenciassilaber)) : null);
            businessDelegatorView.updateTbestimulosdidacticossilaberxcompetencias(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTbestimulosdidacticossilaberxcompetencias = (TbestimulosdidacticossilaberxcompetenciasDTO) (evt.getComponent()
                                                                                                                   .getAttributes()
                                                                                                                   .get("selectedTbestimulosdidacticossilaberxcompetencias"));

            Integer consecutivo = new Integer(selectedTbestimulosdidacticossilaberxcompetencias.getConsecutivo());
            entity = businessDelegatorView.getTbestimulosdidacticossilaberxcompetencias(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbestimulosdidacticossilaberxcompetencias(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTbestimulosdidacticossilaberxcompetencias(entity);
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
            selectedTbestimulosdidacticossilaberxcompetencias = (TbestimulosdidacticossilaberxcompetenciasDTO) (evt.getComponent()
                                                                                                                   .getAttributes()
                                                                                                                   .get("selectedTbestimulosdidacticossilaberxcompetencias"));

            Integer consecutivo = new Integer(selectedTbestimulosdidacticossilaberxcompetencias.getConsecutivo());
            entity = businessDelegatorView.getTbestimulosdidacticossilaberxcompetencias(consecutivo);
            businessDelegatorView.deleteTbestimulosdidacticossilaberxcompetencias(entity);
            data.remove(selectedTbestimulosdidacticossilaberxcompetencias);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer consecutivo,
        Integer consecutivo_Tbelementosdidacticos,
        Integer consecutivo_Tbmapacompetenciassilaber)
        throws Exception {
        try {
            businessDelegatorView.updateTbestimulosdidacticossilaberxcompetencias(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TbestimulosdidacticossilaberxcompetenciasView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtConsecutivo_Tbelementosdidacticos() {
        return txtConsecutivo_Tbelementosdidacticos;
    }

    public void setTxtConsecutivo_Tbelementosdidacticos(
        InputText txtConsecutivo_Tbelementosdidacticos) {
        this.txtConsecutivo_Tbelementosdidacticos = txtConsecutivo_Tbelementosdidacticos;
    }

    public InputText getTxtConsecutivo_Tbmapacompetenciassilaber() {
        return txtConsecutivo_Tbmapacompetenciassilaber;
    }

    public void setTxtConsecutivo_Tbmapacompetenciassilaber(
        InputText txtConsecutivo_Tbmapacompetenciassilaber) {
        this.txtConsecutivo_Tbmapacompetenciassilaber = txtConsecutivo_Tbmapacompetenciassilaber;
    }

    public InputText getTxtConsecutivo() {
        return txtConsecutivo;
    }

    public void setTxtConsecutivo(InputText txtConsecutivo) {
        this.txtConsecutivo = txtConsecutivo;
    }

    public List<TbestimulosdidacticossilaberxcompetenciasDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTbestimulosdidacticossilaberxcompetencias();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<TbestimulosdidacticossilaberxcompetenciasDTO> tbestimulosdidacticossilaberxcompetenciasDTO) {
        this.data = tbestimulosdidacticossilaberxcompetenciasDTO;
    }

    public TbestimulosdidacticossilaberxcompetenciasDTO getSelectedTbestimulosdidacticossilaberxcompetencias() {
        return selectedTbestimulosdidacticossilaberxcompetencias;
    }

    public void setSelectedTbestimulosdidacticossilaberxcompetencias(
        TbestimulosdidacticossilaberxcompetenciasDTO tbestimulosdidacticossilaberxcompetencias) {
        this.selectedTbestimulosdidacticossilaberxcompetencias = tbestimulosdidacticossilaberxcompetencias;
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
