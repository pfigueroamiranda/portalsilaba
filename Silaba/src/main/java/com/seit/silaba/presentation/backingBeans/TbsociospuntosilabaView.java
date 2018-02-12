package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbsociospuntosilabaDTO;
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
public class TbsociospuntosilabaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbsociospuntosilabaView.class);
    private InputText txtConsecutivo_Tbcatalogopuntossilaba;
    private InputText txtConsecutivo_Tbsocio;
    private InputText txtConsecutivo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TbsociospuntosilabaDTO> data;
    private TbsociospuntosilabaDTO selectedTbsociospuntosilaba;
    private Tbsociospuntosilaba entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TbsociospuntosilabaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TbsociospuntosilabaDTO tbsociospuntosilabaDTO = (TbsociospuntosilabaDTO) e.getObject();

            if (txtConsecutivo_Tbcatalogopuntossilaba == null) {
                txtConsecutivo_Tbcatalogopuntossilaba = new InputText();
            }

            txtConsecutivo_Tbcatalogopuntossilaba.setValue(tbsociospuntosilabaDTO.getConsecutivo_Tbcatalogopuntossilaba());

            if (txtConsecutivo_Tbsocio == null) {
                txtConsecutivo_Tbsocio = new InputText();
            }

            txtConsecutivo_Tbsocio.setValue(tbsociospuntosilabaDTO.getConsecutivo_Tbsocio());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }

            txtConsecutivo.setValue(tbsociospuntosilabaDTO.getConsecutivo());

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbsociospuntosilaba(consecutivo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTbsociospuntosilaba = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTbsociospuntosilaba = null;

        if (txtConsecutivo_Tbcatalogopuntossilaba != null) {
            txtConsecutivo_Tbcatalogopuntossilaba.setValue(null);
            txtConsecutivo_Tbcatalogopuntossilaba.setDisabled(true);
        }

        if (txtConsecutivo_Tbsocio != null) {
            txtConsecutivo_Tbsocio.setValue(null);
            txtConsecutivo_Tbsocio.setDisabled(true);
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
                ? businessDelegatorView.getTbsociospuntosilaba(consecutivo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtConsecutivo_Tbcatalogopuntossilaba.setDisabled(false);
            txtConsecutivo_Tbsocio.setDisabled(false);
            txtConsecutivo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtConsecutivo_Tbcatalogopuntossilaba.setValue(entity.getTbcatalogopuntossilaba()
                                                                 .getConsecutivo());
            txtConsecutivo_Tbcatalogopuntossilaba.setDisabled(false);
            txtConsecutivo_Tbsocio.setValue(entity.getTbsocio().getConsecutivo());
            txtConsecutivo_Tbsocio.setDisabled(false);
            txtConsecutivo.setValue(entity.getConsecutivo());
            txtConsecutivo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTbsociospuntosilaba = (TbsociospuntosilabaDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedTbsociospuntosilaba"));
        txtConsecutivo_Tbcatalogopuntossilaba.setValue(selectedTbsociospuntosilaba.getConsecutivo_Tbcatalogopuntossilaba());
        txtConsecutivo_Tbcatalogopuntossilaba.setDisabled(false);
        txtConsecutivo_Tbsocio.setValue(selectedTbsociospuntosilaba.getConsecutivo_Tbsocio());
        txtConsecutivo_Tbsocio.setDisabled(false);
        txtConsecutivo.setValue(selectedTbsociospuntosilaba.getConsecutivo());
        txtConsecutivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTbsociospuntosilaba == null) && (entity == null)) {
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
            entity = new Tbsociospuntosilaba();

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);

            entity.setConsecutivo(consecutivo);
            entity.setTbcatalogopuntossilaba((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogopuntossilaba) != null)
                ? businessDelegatorView.getTbcatalogopuntossilaba(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogopuntossilaba)) : null);
            entity.setTbsocio((FacesUtils.checkInteger(txtConsecutivo_Tbsocio) != null)
                ? businessDelegatorView.getTbsocio(FacesUtils.checkInteger(
                        txtConsecutivo_Tbsocio)) : null);
            businessDelegatorView.saveTbsociospuntosilaba(entity);
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
                Integer consecutivo = new Integer(selectedTbsociospuntosilaba.getConsecutivo());
                entity = businessDelegatorView.getTbsociospuntosilaba(consecutivo);
            }

            entity.setTbcatalogopuntossilaba((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogopuntossilaba) != null)
                ? businessDelegatorView.getTbcatalogopuntossilaba(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogopuntossilaba)) : null);
            entity.setTbsocio((FacesUtils.checkInteger(txtConsecutivo_Tbsocio) != null)
                ? businessDelegatorView.getTbsocio(FacesUtils.checkInteger(
                        txtConsecutivo_Tbsocio)) : null);
            businessDelegatorView.updateTbsociospuntosilaba(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTbsociospuntosilaba = (TbsociospuntosilabaDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedTbsociospuntosilaba"));

            Integer consecutivo = new Integer(selectedTbsociospuntosilaba.getConsecutivo());
            entity = businessDelegatorView.getTbsociospuntosilaba(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbsociospuntosilaba(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTbsociospuntosilaba(entity);
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
            selectedTbsociospuntosilaba = (TbsociospuntosilabaDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedTbsociospuntosilaba"));

            Integer consecutivo = new Integer(selectedTbsociospuntosilaba.getConsecutivo());
            entity = businessDelegatorView.getTbsociospuntosilaba(consecutivo);
            businessDelegatorView.deleteTbsociospuntosilaba(entity);
            data.remove(selectedTbsociospuntosilaba);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer consecutivo,
        Integer consecutivo_Tbcatalogopuntossilaba, Integer consecutivo_Tbsocio)
        throws Exception {
        try {
            businessDelegatorView.updateTbsociospuntosilaba(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TbsociospuntosilabaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtConsecutivo_Tbcatalogopuntossilaba() {
        return txtConsecutivo_Tbcatalogopuntossilaba;
    }

    public void setTxtConsecutivo_Tbcatalogopuntossilaba(
        InputText txtConsecutivo_Tbcatalogopuntossilaba) {
        this.txtConsecutivo_Tbcatalogopuntossilaba = txtConsecutivo_Tbcatalogopuntossilaba;
    }

    public InputText getTxtConsecutivo_Tbsocio() {
        return txtConsecutivo_Tbsocio;
    }

    public void setTxtConsecutivo_Tbsocio(InputText txtConsecutivo_Tbsocio) {
        this.txtConsecutivo_Tbsocio = txtConsecutivo_Tbsocio;
    }

    public InputText getTxtConsecutivo() {
        return txtConsecutivo;
    }

    public void setTxtConsecutivo(InputText txtConsecutivo) {
        this.txtConsecutivo = txtConsecutivo;
    }

    public List<TbsociospuntosilabaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTbsociospuntosilaba();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TbsociospuntosilabaDTO> tbsociospuntosilabaDTO) {
        this.data = tbsociospuntosilabaDTO;
    }

    public TbsociospuntosilabaDTO getSelectedTbsociospuntosilaba() {
        return selectedTbsociospuntosilaba;
    }

    public void setSelectedTbsociospuntosilaba(
        TbsociospuntosilabaDTO tbsociospuntosilaba) {
        this.selectedTbsociospuntosilaba = tbsociospuntosilaba;
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
