package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbmapacompetenciassilaberDTO;
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
public class TbmapacompetenciassilaberView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbmapacompetenciassilaberView.class);
    private InputText txtConsecutivo_Tbcompetenciaspuntossilaba;
    private InputText txtConsecutivo_Tbprogramacionexperienciasilaber;
    private InputText txtConsecutivo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TbmapacompetenciassilaberDTO> data;
    private TbmapacompetenciassilaberDTO selectedTbmapacompetenciassilaber;
    private Tbmapacompetenciassilaber entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TbmapacompetenciassilaberView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TbmapacompetenciassilaberDTO tbmapacompetenciassilaberDTO = (TbmapacompetenciassilaberDTO) e.getObject();

            if (txtConsecutivo_Tbcompetenciaspuntossilaba == null) {
                txtConsecutivo_Tbcompetenciaspuntossilaba = new InputText();
            }

            txtConsecutivo_Tbcompetenciaspuntossilaba.setValue(tbmapacompetenciassilaberDTO.getConsecutivo_Tbcompetenciaspuntossilaba());

            if (txtConsecutivo_Tbprogramacionexperienciasilaber == null) {
                txtConsecutivo_Tbprogramacionexperienciasilaber = new InputText();
            }

            txtConsecutivo_Tbprogramacionexperienciasilaber.setValue(tbmapacompetenciassilaberDTO.getConsecutivo_Tbprogramacionexperienciasilaber());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }

            txtConsecutivo.setValue(tbmapacompetenciassilaberDTO.getConsecutivo());

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbmapacompetenciassilaber(consecutivo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTbmapacompetenciassilaber = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTbmapacompetenciassilaber = null;

        if (txtConsecutivo_Tbcompetenciaspuntossilaba != null) {
            txtConsecutivo_Tbcompetenciaspuntossilaba.setValue(null);
            txtConsecutivo_Tbcompetenciaspuntossilaba.setDisabled(true);
        }

        if (txtConsecutivo_Tbprogramacionexperienciasilaber != null) {
            txtConsecutivo_Tbprogramacionexperienciasilaber.setValue(null);
            txtConsecutivo_Tbprogramacionexperienciasilaber.setDisabled(true);
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
                ? businessDelegatorView.getTbmapacompetenciassilaber(consecutivo)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtConsecutivo_Tbcompetenciaspuntossilaba.setDisabled(false);
            txtConsecutivo_Tbprogramacionexperienciasilaber.setDisabled(false);
            txtConsecutivo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtConsecutivo_Tbcompetenciaspuntossilaba.setValue(entity.getTbcompetenciaspuntossilaba()
                                                                     .getConsecutivo());
            txtConsecutivo_Tbcompetenciaspuntossilaba.setDisabled(false);
            txtConsecutivo_Tbprogramacionexperienciasilaber.setValue(entity.getTbprogramacionexperienciasilaber()
                                                                           .getConsecutivo());
            txtConsecutivo_Tbprogramacionexperienciasilaber.setDisabled(false);
            txtConsecutivo.setValue(entity.getConsecutivo());
            txtConsecutivo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTbmapacompetenciassilaber = (TbmapacompetenciassilaberDTO) (evt.getComponent()
                                                                               .getAttributes()
                                                                               .get("selectedTbmapacompetenciassilaber"));
        txtConsecutivo_Tbcompetenciaspuntossilaba.setValue(selectedTbmapacompetenciassilaber.getConsecutivo_Tbcompetenciaspuntossilaba());
        txtConsecutivo_Tbcompetenciaspuntossilaba.setDisabled(false);
        txtConsecutivo_Tbprogramacionexperienciasilaber.setValue(selectedTbmapacompetenciassilaber.getConsecutivo_Tbprogramacionexperienciasilaber());
        txtConsecutivo_Tbprogramacionexperienciasilaber.setDisabled(false);
        txtConsecutivo.setValue(selectedTbmapacompetenciassilaber.getConsecutivo());
        txtConsecutivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTbmapacompetenciassilaber == null) &&
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
            entity = new Tbmapacompetenciassilaber();

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);

            entity.setConsecutivo(consecutivo);
            entity.setTbcompetenciaspuntossilaba((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcompetenciaspuntossilaba) != null)
                ? businessDelegatorView.getTbcompetenciaspuntossilaba(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcompetenciaspuntossilaba)) : null);
            entity.setTbprogramacionexperienciasilaber((FacesUtils.checkInteger(
                    txtConsecutivo_Tbprogramacionexperienciasilaber) != null)
                ? businessDelegatorView.getTbprogramacionexperienciasilaber(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbprogramacionexperienciasilaber)) : null);
            businessDelegatorView.saveTbmapacompetenciassilaber(entity);
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
                Integer consecutivo = new Integer(selectedTbmapacompetenciassilaber.getConsecutivo());
                entity = businessDelegatorView.getTbmapacompetenciassilaber(consecutivo);
            }

            entity.setTbcompetenciaspuntossilaba((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcompetenciaspuntossilaba) != null)
                ? businessDelegatorView.getTbcompetenciaspuntossilaba(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcompetenciaspuntossilaba)) : null);
            entity.setTbprogramacionexperienciasilaber((FacesUtils.checkInteger(
                    txtConsecutivo_Tbprogramacionexperienciasilaber) != null)
                ? businessDelegatorView.getTbprogramacionexperienciasilaber(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbprogramacionexperienciasilaber)) : null);
            businessDelegatorView.updateTbmapacompetenciassilaber(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTbmapacompetenciassilaber = (TbmapacompetenciassilaberDTO) (evt.getComponent()
                                                                                   .getAttributes()
                                                                                   .get("selectedTbmapacompetenciassilaber"));

            Integer consecutivo = new Integer(selectedTbmapacompetenciassilaber.getConsecutivo());
            entity = businessDelegatorView.getTbmapacompetenciassilaber(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbmapacompetenciassilaber(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTbmapacompetenciassilaber(entity);
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
            selectedTbmapacompetenciassilaber = (TbmapacompetenciassilaberDTO) (evt.getComponent()
                                                                                   .getAttributes()
                                                                                   .get("selectedTbmapacompetenciassilaber"));

            Integer consecutivo = new Integer(selectedTbmapacompetenciassilaber.getConsecutivo());
            entity = businessDelegatorView.getTbmapacompetenciassilaber(consecutivo);
            businessDelegatorView.deleteTbmapacompetenciassilaber(entity);
            data.remove(selectedTbmapacompetenciassilaber);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer consecutivo,
        Integer consecutivo_Tbcompetenciaspuntossilaba,
        Integer consecutivo_Tbprogramacionexperienciasilaber)
        throws Exception {
        try {
            businessDelegatorView.updateTbmapacompetenciassilaber(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TbmapacompetenciassilaberView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtConsecutivo_Tbcompetenciaspuntossilaba() {
        return txtConsecutivo_Tbcompetenciaspuntossilaba;
    }

    public void setTxtConsecutivo_Tbcompetenciaspuntossilaba(
        InputText txtConsecutivo_Tbcompetenciaspuntossilaba) {
        this.txtConsecutivo_Tbcompetenciaspuntossilaba = txtConsecutivo_Tbcompetenciaspuntossilaba;
    }

    public InputText getTxtConsecutivo_Tbprogramacionexperienciasilaber() {
        return txtConsecutivo_Tbprogramacionexperienciasilaber;
    }

    public void setTxtConsecutivo_Tbprogramacionexperienciasilaber(
        InputText txtConsecutivo_Tbprogramacionexperienciasilaber) {
        this.txtConsecutivo_Tbprogramacionexperienciasilaber = txtConsecutivo_Tbprogramacionexperienciasilaber;
    }

    public InputText getTxtConsecutivo() {
        return txtConsecutivo;
    }

    public void setTxtConsecutivo(InputText txtConsecutivo) {
        this.txtConsecutivo = txtConsecutivo;
    }

    public List<TbmapacompetenciassilaberDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTbmapacompetenciassilaber();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<TbmapacompetenciassilaberDTO> tbmapacompetenciassilaberDTO) {
        this.data = tbmapacompetenciassilaberDTO;
    }

    public TbmapacompetenciassilaberDTO getSelectedTbmapacompetenciassilaber() {
        return selectedTbmapacompetenciassilaber;
    }

    public void setSelectedTbmapacompetenciassilaber(
        TbmapacompetenciassilaberDTO tbmapacompetenciassilaber) {
        this.selectedTbmapacompetenciassilaber = tbmapacompetenciassilaber;
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
