package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbelementosdidacticosDTO;
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
public class TbelementosdidacticosView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbelementosdidacticosView.class);
    private InputText txtCantidad;
    private InputText txtDescripcion;
    private InputText txtConsecutivo_Tbsocio;
    private InputText txtConsecutivo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TbelementosdidacticosDTO> data;
    private TbelementosdidacticosDTO selectedTbelementosdidacticos;
    private Tbelementosdidacticos entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TbelementosdidacticosView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TbelementosdidacticosDTO tbelementosdidacticosDTO = (TbelementosdidacticosDTO) e.getObject();

            if (txtCantidad == null) {
                txtCantidad = new InputText();
            }

            txtCantidad.setValue(tbelementosdidacticosDTO.getCantidad());

            if (txtDescripcion == null) {
                txtDescripcion = new InputText();
            }

            txtDescripcion.setValue(tbelementosdidacticosDTO.getDescripcion());

            if (txtConsecutivo_Tbsocio == null) {
                txtConsecutivo_Tbsocio = new InputText();
            }

            txtConsecutivo_Tbsocio.setValue(tbelementosdidacticosDTO.getConsecutivo_Tbsocio());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }

            txtConsecutivo.setValue(tbelementosdidacticosDTO.getConsecutivo());

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbelementosdidacticos(consecutivo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTbelementosdidacticos = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTbelementosdidacticos = null;

        if (txtCantidad != null) {
            txtCantidad.setValue(null);
            txtCantidad.setDisabled(true);
        }

        if (txtDescripcion != null) {
            txtDescripcion.setValue(null);
            txtDescripcion.setDisabled(true);
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
                ? businessDelegatorView.getTbelementosdidacticos(consecutivo)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCantidad.setDisabled(false);
            txtDescripcion.setDisabled(false);
            txtConsecutivo_Tbsocio.setDisabled(false);
            txtConsecutivo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCantidad.setValue(entity.getCantidad());
            txtCantidad.setDisabled(false);
            txtDescripcion.setValue(entity.getDescripcion());
            txtDescripcion.setDisabled(false);
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
        selectedTbelementosdidacticos = (TbelementosdidacticosDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedTbelementosdidacticos"));
        txtCantidad.setValue(selectedTbelementosdidacticos.getCantidad());
        txtCantidad.setDisabled(false);
        txtDescripcion.setValue(selectedTbelementosdidacticos.getDescripcion());
        txtDescripcion.setDisabled(false);
        txtConsecutivo_Tbsocio.setValue(selectedTbelementosdidacticos.getConsecutivo_Tbsocio());
        txtConsecutivo_Tbsocio.setDisabled(false);
        txtConsecutivo.setValue(selectedTbelementosdidacticos.getConsecutivo());
        txtConsecutivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTbelementosdidacticos == null) && (entity == null)) {
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
            entity = new Tbelementosdidacticos();

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);

            entity.setCantidad(FacesUtils.checkInteger(txtCantidad));
            entity.setConsecutivo(consecutivo);
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setTbsocio((FacesUtils.checkInteger(txtConsecutivo_Tbsocio) != null)
                ? businessDelegatorView.getTbsocio(FacesUtils.checkInteger(
                        txtConsecutivo_Tbsocio)) : null);
            businessDelegatorView.saveTbelementosdidacticos(entity);
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
                Integer consecutivo = new Integer(selectedTbelementosdidacticos.getConsecutivo());
                entity = businessDelegatorView.getTbelementosdidacticos(consecutivo);
            }

            entity.setCantidad(FacesUtils.checkInteger(txtCantidad));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setTbsocio((FacesUtils.checkInteger(txtConsecutivo_Tbsocio) != null)
                ? businessDelegatorView.getTbsocio(FacesUtils.checkInteger(
                        txtConsecutivo_Tbsocio)) : null);
            businessDelegatorView.updateTbelementosdidacticos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTbelementosdidacticos = (TbelementosdidacticosDTO) (evt.getComponent()
                                                                           .getAttributes()
                                                                           .get("selectedTbelementosdidacticos"));

            Integer consecutivo = new Integer(selectedTbelementosdidacticos.getConsecutivo());
            entity = businessDelegatorView.getTbelementosdidacticos(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbelementosdidacticos(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTbelementosdidacticos(entity);
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
            selectedTbelementosdidacticos = (TbelementosdidacticosDTO) (evt.getComponent()
                                                                           .getAttributes()
                                                                           .get("selectedTbelementosdidacticos"));

            Integer consecutivo = new Integer(selectedTbelementosdidacticos.getConsecutivo());
            entity = businessDelegatorView.getTbelementosdidacticos(consecutivo);
            businessDelegatorView.deleteTbelementosdidacticos(entity);
            data.remove(selectedTbelementosdidacticos);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer cantidad, Integer consecutivo,
        String descripcion, Integer consecutivo_Tbsocio)
        throws Exception {
        try {
            entity.setCantidad(FacesUtils.checkInteger(cantidad));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            businessDelegatorView.updateTbelementosdidacticos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TbelementosdidacticosView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtCantidad() {
        return txtCantidad;
    }

    public void setTxtCantidad(InputText txtCantidad) {
        this.txtCantidad = txtCantidad;
    }

    public InputText getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputText txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
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

    public List<TbelementosdidacticosDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTbelementosdidacticos();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TbelementosdidacticosDTO> tbelementosdidacticosDTO) {
        this.data = tbelementosdidacticosDTO;
    }

    public TbelementosdidacticosDTO getSelectedTbelementosdidacticos() {
        return selectedTbelementosdidacticos;
    }

    public void setSelectedTbelementosdidacticos(
        TbelementosdidacticosDTO tbelementosdidacticos) {
        this.selectedTbelementosdidacticos = tbelementosdidacticos;
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
