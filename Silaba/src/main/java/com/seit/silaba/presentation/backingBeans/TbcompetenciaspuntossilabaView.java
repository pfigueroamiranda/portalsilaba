package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbcompetenciaspuntossilabaDTO;
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
public class TbcompetenciaspuntossilabaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbcompetenciaspuntossilabaView.class);
    private InputText txtConsecutivo_Tbcatalogocompetencias;
    private InputText txtConsecutivo_Tbcatalogopuntossilaba;
    private InputText txtConsecutivo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TbcompetenciaspuntossilabaDTO> data;
    private TbcompetenciaspuntossilabaDTO selectedTbcompetenciaspuntossilaba;
    private Tbcompetenciaspuntossilaba entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TbcompetenciaspuntossilabaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TbcompetenciaspuntossilabaDTO tbcompetenciaspuntossilabaDTO = (TbcompetenciaspuntossilabaDTO) e.getObject();

            if (txtConsecutivo_Tbcatalogocompetencias == null) {
                txtConsecutivo_Tbcatalogocompetencias = new InputText();
            }

            txtConsecutivo_Tbcatalogocompetencias.setValue(tbcompetenciaspuntossilabaDTO.getConsecutivo_Tbcatalogocompetencias());

            if (txtConsecutivo_Tbcatalogopuntossilaba == null) {
                txtConsecutivo_Tbcatalogopuntossilaba = new InputText();
            }

            txtConsecutivo_Tbcatalogopuntossilaba.setValue(tbcompetenciaspuntossilabaDTO.getConsecutivo_Tbcatalogopuntossilaba());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }

            txtConsecutivo.setValue(tbcompetenciaspuntossilabaDTO.getConsecutivo());

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbcompetenciaspuntossilaba(consecutivo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTbcompetenciaspuntossilaba = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTbcompetenciaspuntossilaba = null;

        if (txtConsecutivo_Tbcatalogocompetencias != null) {
            txtConsecutivo_Tbcatalogocompetencias.setValue(null);
            txtConsecutivo_Tbcatalogocompetencias.setDisabled(true);
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
                ? businessDelegatorView.getTbcompetenciaspuntossilaba(consecutivo)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtConsecutivo_Tbcatalogocompetencias.setDisabled(false);
            txtConsecutivo_Tbcatalogopuntossilaba.setDisabled(false);
            txtConsecutivo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtConsecutivo_Tbcatalogocompetencias.setValue(entity.getTbcatalogocompetencias()
                                                                 .getConsecutivo());
            txtConsecutivo_Tbcatalogocompetencias.setDisabled(false);
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
        selectedTbcompetenciaspuntossilaba = (TbcompetenciaspuntossilabaDTO) (evt.getComponent()
                                                                                 .getAttributes()
                                                                                 .get("selectedTbcompetenciaspuntossilaba"));
        txtConsecutivo_Tbcatalogocompetencias.setValue(selectedTbcompetenciaspuntossilaba.getConsecutivo_Tbcatalogocompetencias());
        txtConsecutivo_Tbcatalogocompetencias.setDisabled(false);
        txtConsecutivo_Tbcatalogopuntossilaba.setValue(selectedTbcompetenciaspuntossilaba.getConsecutivo_Tbcatalogopuntossilaba());
        txtConsecutivo_Tbcatalogopuntossilaba.setDisabled(false);
        txtConsecutivo.setValue(selectedTbcompetenciaspuntossilaba.getConsecutivo());
        txtConsecutivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTbcompetenciaspuntossilaba == null) &&
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
            entity = new Tbcompetenciaspuntossilaba();

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);

            entity.setConsecutivo(consecutivo);
            entity.setTbcatalogocompetencias((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogocompetencias) != null)
                ? businessDelegatorView.getTbcatalogocompetencias(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogocompetencias)) : null);
            entity.setTbcatalogopuntossilaba((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogopuntossilaba) != null)
                ? businessDelegatorView.getTbcatalogopuntossilaba(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogopuntossilaba)) : null);
            businessDelegatorView.saveTbcompetenciaspuntossilaba(entity);
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
                Integer consecutivo = new Integer(selectedTbcompetenciaspuntossilaba.getConsecutivo());
                entity = businessDelegatorView.getTbcompetenciaspuntossilaba(consecutivo);
            }

            entity.setTbcatalogocompetencias((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogocompetencias) != null)
                ? businessDelegatorView.getTbcatalogocompetencias(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogocompetencias)) : null);
            entity.setTbcatalogopuntossilaba((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogopuntossilaba) != null)
                ? businessDelegatorView.getTbcatalogopuntossilaba(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogopuntossilaba)) : null);
            businessDelegatorView.updateTbcompetenciaspuntossilaba(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTbcompetenciaspuntossilaba = (TbcompetenciaspuntossilabaDTO) (evt.getComponent()
                                                                                     .getAttributes()
                                                                                     .get("selectedTbcompetenciaspuntossilaba"));

            Integer consecutivo = new Integer(selectedTbcompetenciaspuntossilaba.getConsecutivo());
            entity = businessDelegatorView.getTbcompetenciaspuntossilaba(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbcompetenciaspuntossilaba(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTbcompetenciaspuntossilaba(entity);
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
            selectedTbcompetenciaspuntossilaba = (TbcompetenciaspuntossilabaDTO) (evt.getComponent()
                                                                                     .getAttributes()
                                                                                     .get("selectedTbcompetenciaspuntossilaba"));

            Integer consecutivo = new Integer(selectedTbcompetenciaspuntossilaba.getConsecutivo());
            entity = businessDelegatorView.getTbcompetenciaspuntossilaba(consecutivo);
            businessDelegatorView.deleteTbcompetenciaspuntossilaba(entity);
            data.remove(selectedTbcompetenciaspuntossilaba);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer consecutivo,
        Integer consecutivo_Tbcatalogocompetencias,
        Integer consecutivo_Tbcatalogopuntossilaba) throws Exception {
        try {
            businessDelegatorView.updateTbcompetenciaspuntossilaba(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TbcompetenciaspuntossilabaView").requestRender();
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

    public List<TbcompetenciaspuntossilabaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTbcompetenciaspuntossilaba();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<TbcompetenciaspuntossilabaDTO> tbcompetenciaspuntossilabaDTO) {
        this.data = tbcompetenciaspuntossilabaDTO;
    }

    public TbcompetenciaspuntossilabaDTO getSelectedTbcompetenciaspuntossilaba() {
        return selectedTbcompetenciaspuntossilaba;
    }

    public void setSelectedTbcompetenciaspuntossilaba(
        TbcompetenciaspuntossilabaDTO tbcompetenciaspuntossilaba) {
        this.selectedTbcompetenciaspuntossilaba = tbcompetenciaspuntossilaba;
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
