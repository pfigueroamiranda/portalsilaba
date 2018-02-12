package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbcontenidosilaberDTO;
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
public class TbcontenidosilaberView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbcontenidosilaberView.class);
    private InputText txtDescripcion;
    private InputText txtObservacion;
    private InputText txtUrl;
    private InputText txtUsuarioCreacion;
    private InputText txtConsecutivo_Tbcatalogopuntossilaba;
    private InputText txtConsecutivo;
    private Calendar txtFechaCreacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TbcontenidosilaberDTO> data;
    private TbcontenidosilaberDTO selectedTbcontenidosilaber;
    private Tbcontenidosilaber entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TbcontenidosilaberView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TbcontenidosilaberDTO tbcontenidosilaberDTO = (TbcontenidosilaberDTO) e.getObject();

            if (txtDescripcion == null) {
                txtDescripcion = new InputText();
            }

            txtDescripcion.setValue(tbcontenidosilaberDTO.getDescripcion());

            if (txtObservacion == null) {
                txtObservacion = new InputText();
            }

            txtObservacion.setValue(tbcontenidosilaberDTO.getObservacion());

            if (txtUrl == null) {
                txtUrl = new InputText();
            }

            txtUrl.setValue(tbcontenidosilaberDTO.getUrl());

            if (txtUsuarioCreacion == null) {
                txtUsuarioCreacion = new InputText();
            }

            txtUsuarioCreacion.setValue(tbcontenidosilaberDTO.getUsuarioCreacion());

            if (txtConsecutivo_Tbcatalogopuntossilaba == null) {
                txtConsecutivo_Tbcatalogopuntossilaba = new InputText();
            }

            txtConsecutivo_Tbcatalogopuntossilaba.setValue(tbcontenidosilaberDTO.getConsecutivo_Tbcatalogopuntossilaba());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }

            txtConsecutivo.setValue(tbcontenidosilaberDTO.getConsecutivo());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(tbcontenidosilaberDTO.getFechaCreacion());

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbcontenidosilaber(consecutivo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTbcontenidosilaber = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTbcontenidosilaber = null;

        if (txtDescripcion != null) {
            txtDescripcion.setValue(null);
            txtDescripcion.setDisabled(true);
        }

        if (txtObservacion != null) {
            txtObservacion.setValue(null);
            txtObservacion.setDisabled(true);
        }

        if (txtUrl != null) {
            txtUrl.setValue(null);
            txtUrl.setDisabled(true);
        }

        if (txtUsuarioCreacion != null) {
            txtUsuarioCreacion.setValue(null);
            txtUsuarioCreacion.setDisabled(true);
        }

        if (txtConsecutivo_Tbcatalogopuntossilaba != null) {
            txtConsecutivo_Tbcatalogopuntossilaba.setValue(null);
            txtConsecutivo_Tbcatalogopuntossilaba.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
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

    public void listener_txtFechaCreacion() {
        Date inputDate = (Date) txtFechaCreacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = (consecutivo != null)
                ? businessDelegatorView.getTbcontenidosilaber(consecutivo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtDescripcion.setDisabled(false);
            txtObservacion.setDisabled(false);
            txtUrl.setDisabled(false);
            txtUsuarioCreacion.setDisabled(false);
            txtConsecutivo_Tbcatalogopuntossilaba.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtConsecutivo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDescripcion.setValue(entity.getDescripcion());
            txtDescripcion.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtObservacion.setValue(entity.getObservacion());
            txtObservacion.setDisabled(false);
            txtUrl.setValue(entity.getUrl());
            txtUrl.setDisabled(false);
            txtUsuarioCreacion.setValue(entity.getUsuarioCreacion());
            txtUsuarioCreacion.setDisabled(false);
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
        selectedTbcontenidosilaber = (TbcontenidosilaberDTO) (evt.getComponent()
                                                                 .getAttributes()
                                                                 .get("selectedTbcontenidosilaber"));
        txtDescripcion.setValue(selectedTbcontenidosilaber.getDescripcion());
        txtDescripcion.setDisabled(false);
        txtFechaCreacion.setValue(selectedTbcontenidosilaber.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtObservacion.setValue(selectedTbcontenidosilaber.getObservacion());
        txtObservacion.setDisabled(false);
        txtUrl.setValue(selectedTbcontenidosilaber.getUrl());
        txtUrl.setDisabled(false);
        txtUsuarioCreacion.setValue(selectedTbcontenidosilaber.getUsuarioCreacion());
        txtUsuarioCreacion.setDisabled(false);
        txtConsecutivo_Tbcatalogopuntossilaba.setValue(selectedTbcontenidosilaber.getConsecutivo_Tbcatalogopuntossilaba());
        txtConsecutivo_Tbcatalogopuntossilaba.setDisabled(false);
        txtConsecutivo.setValue(selectedTbcontenidosilaber.getConsecutivo());
        txtConsecutivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTbcontenidosilaber == null) && (entity == null)) {
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
            entity = new Tbcontenidosilaber();

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);

            entity.setConsecutivo(consecutivo);
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setUrl(FacesUtils.checkString(txtUrl));
            entity.setUsuarioCreacion(FacesUtils.checkString(txtUsuarioCreacion));
            entity.setTbcatalogopuntossilaba((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogopuntossilaba) != null)
                ? businessDelegatorView.getTbcatalogopuntossilaba(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogopuntossilaba)) : null);
            businessDelegatorView.saveTbcontenidosilaber(entity);
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
                Integer consecutivo = new Integer(selectedTbcontenidosilaber.getConsecutivo());
                entity = businessDelegatorView.getTbcontenidosilaber(consecutivo);
            }

            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setObservacion(FacesUtils.checkString(txtObservacion));
            entity.setUrl(FacesUtils.checkString(txtUrl));
            entity.setUsuarioCreacion(FacesUtils.checkString(txtUsuarioCreacion));
            entity.setTbcatalogopuntossilaba((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogopuntossilaba) != null)
                ? businessDelegatorView.getTbcatalogopuntossilaba(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogopuntossilaba)) : null);
            businessDelegatorView.updateTbcontenidosilaber(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTbcontenidosilaber = (TbcontenidosilaberDTO) (evt.getComponent()
                                                                     .getAttributes()
                                                                     .get("selectedTbcontenidosilaber"));

            Integer consecutivo = new Integer(selectedTbcontenidosilaber.getConsecutivo());
            entity = businessDelegatorView.getTbcontenidosilaber(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbcontenidosilaber(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTbcontenidosilaber(entity);
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
            selectedTbcontenidosilaber = (TbcontenidosilaberDTO) (evt.getComponent()
                                                                     .getAttributes()
                                                                     .get("selectedTbcontenidosilaber"));

            Integer consecutivo = new Integer(selectedTbcontenidosilaber.getConsecutivo());
            entity = businessDelegatorView.getTbcontenidosilaber(consecutivo);
            businessDelegatorView.deleteTbcontenidosilaber(entity);
            data.remove(selectedTbcontenidosilaber);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer consecutivo, String descripcion,
        Date fechaCreacion, String observacion, String url,
        String usuarioCreacion, Integer consecutivo_Tbcatalogopuntossilaba)
        throws Exception {
        try {
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setObservacion(FacesUtils.checkString(observacion));
            entity.setUrl(FacesUtils.checkString(url));
            entity.setUsuarioCreacion(FacesUtils.checkString(usuarioCreacion));
            businessDelegatorView.updateTbcontenidosilaber(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TbcontenidosilaberView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputText txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public InputText getTxtObservacion() {
        return txtObservacion;
    }

    public void setTxtObservacion(InputText txtObservacion) {
        this.txtObservacion = txtObservacion;
    }

    public InputText getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(InputText txtUrl) {
        this.txtUrl = txtUrl;
    }

    public InputText getTxtUsuarioCreacion() {
        return txtUsuarioCreacion;
    }

    public void setTxtUsuarioCreacion(InputText txtUsuarioCreacion) {
        this.txtUsuarioCreacion = txtUsuarioCreacion;
    }

    public InputText getTxtConsecutivo_Tbcatalogopuntossilaba() {
        return txtConsecutivo_Tbcatalogopuntossilaba;
    }

    public void setTxtConsecutivo_Tbcatalogopuntossilaba(
        InputText txtConsecutivo_Tbcatalogopuntossilaba) {
        this.txtConsecutivo_Tbcatalogopuntossilaba = txtConsecutivo_Tbcatalogopuntossilaba;
    }

    public Calendar getTxtFechaCreacion() {
        return txtFechaCreacion;
    }

    public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
        this.txtFechaCreacion = txtFechaCreacion;
    }

    public InputText getTxtConsecutivo() {
        return txtConsecutivo;
    }

    public void setTxtConsecutivo(InputText txtConsecutivo) {
        this.txtConsecutivo = txtConsecutivo;
    }

    public List<TbcontenidosilaberDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTbcontenidosilaber();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TbcontenidosilaberDTO> tbcontenidosilaberDTO) {
        this.data = tbcontenidosilaberDTO;
    }

    public TbcontenidosilaberDTO getSelectedTbcontenidosilaber() {
        return selectedTbcontenidosilaber;
    }

    public void setSelectedTbcontenidosilaber(
        TbcontenidosilaberDTO tbcontenidosilaber) {
        this.selectedTbcontenidosilaber = tbcontenidosilaber;
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
