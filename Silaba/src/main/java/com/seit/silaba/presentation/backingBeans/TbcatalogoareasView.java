package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbcatalogoareasDTO;
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
public class TbcatalogoareasView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbcatalogoareasView.class);
    private InputText txtCodigo;
    private InputText txtDescripcion;
    private InputText txtFechaCreacion;
    private InputText txtUsuarioCreacion;
    private InputText txtConsecutivo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TbcatalogoareasDTO> data;
    private TbcatalogoareasDTO selectedTbcatalogoareas;
    private Tbcatalogoareas entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TbcatalogoareasView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TbcatalogoareasDTO tbcatalogoareasDTO = (TbcatalogoareasDTO) e.getObject();

            if (txtCodigo == null) {
                txtCodigo = new InputText();
            }

            txtCodigo.setValue(tbcatalogoareasDTO.getCodigo());

            if (txtDescripcion == null) {
                txtDescripcion = new InputText();
            }

            txtDescripcion.setValue(tbcatalogoareasDTO.getDescripcion());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new InputText();
            }

            txtFechaCreacion.setValue(tbcatalogoareasDTO.getFechaCreacion());

            if (txtUsuarioCreacion == null) {
                txtUsuarioCreacion = new InputText();
            }

            txtUsuarioCreacion.setValue(tbcatalogoareasDTO.getUsuarioCreacion());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }

            txtConsecutivo.setValue(tbcatalogoareasDTO.getConsecutivo());

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbcatalogoareas(consecutivo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTbcatalogoareas = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTbcatalogoareas = null;

        if (txtCodigo != null) {
            txtCodigo.setValue(null);
            txtCodigo.setDisabled(true);
        }

        if (txtDescripcion != null) {
            txtDescripcion.setValue(null);
            txtDescripcion.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtUsuarioCreacion != null) {
            txtUsuarioCreacion.setValue(null);
            txtUsuarioCreacion.setDisabled(true);
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
                ? businessDelegatorView.getTbcatalogoareas(consecutivo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCodigo.setDisabled(false);
            txtDescripcion.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtUsuarioCreacion.setDisabled(false);
            txtConsecutivo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCodigo.setValue(entity.getCodigo());
            txtCodigo.setDisabled(false);
            txtDescripcion.setValue(entity.getDescripcion());
            txtDescripcion.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtUsuarioCreacion.setValue(entity.getUsuarioCreacion());
            txtUsuarioCreacion.setDisabled(false);
            txtConsecutivo.setValue(entity.getConsecutivo());
            txtConsecutivo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTbcatalogoareas = (TbcatalogoareasDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedTbcatalogoareas"));
        txtCodigo.setValue(selectedTbcatalogoareas.getCodigo());
        txtCodigo.setDisabled(false);
        txtDescripcion.setValue(selectedTbcatalogoareas.getDescripcion());
        txtDescripcion.setDisabled(false);
        txtFechaCreacion.setValue(selectedTbcatalogoareas.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtUsuarioCreacion.setValue(selectedTbcatalogoareas.getUsuarioCreacion());
        txtUsuarioCreacion.setDisabled(false);
        txtConsecutivo.setValue(selectedTbcatalogoareas.getConsecutivo());
        txtConsecutivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTbcatalogoareas == null) && (entity == null)) {
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
            entity = new Tbcatalogoareas();

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);

            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setConsecutivo(consecutivo);
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setFechaCreacion(FacesUtils.checkString(txtFechaCreacion));
            entity.setUsuarioCreacion(FacesUtils.checkString(txtUsuarioCreacion));
            businessDelegatorView.saveTbcatalogoareas(entity);
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
                Integer consecutivo = new Integer(selectedTbcatalogoareas.getConsecutivo());
                entity = businessDelegatorView.getTbcatalogoareas(consecutivo);
            }

            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setFechaCreacion(FacesUtils.checkString(txtFechaCreacion));
            entity.setUsuarioCreacion(FacesUtils.checkString(txtUsuarioCreacion));
            businessDelegatorView.updateTbcatalogoareas(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTbcatalogoareas = (TbcatalogoareasDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedTbcatalogoareas"));

            Integer consecutivo = new Integer(selectedTbcatalogoareas.getConsecutivo());
            entity = businessDelegatorView.getTbcatalogoareas(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbcatalogoareas(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTbcatalogoareas(entity);
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
            selectedTbcatalogoareas = (TbcatalogoareasDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedTbcatalogoareas"));

            Integer consecutivo = new Integer(selectedTbcatalogoareas.getConsecutivo());
            entity = businessDelegatorView.getTbcatalogoareas(consecutivo);
            businessDelegatorView.deleteTbcatalogoareas(entity);
            data.remove(selectedTbcatalogoareas);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String codigo, Integer consecutivo,
        String descripcion, String fechaCreacion, String usuarioCreacion)
        throws Exception {
        try {
            entity.setCodigo(FacesUtils.checkString(codigo));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            entity.setFechaCreacion(FacesUtils.checkString(fechaCreacion));
            entity.setUsuarioCreacion(FacesUtils.checkString(usuarioCreacion));
            businessDelegatorView.updateTbcatalogoareas(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TbcatalogoareasView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(InputText txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public InputText getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputText txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public InputText getTxtFechaCreacion() {
        return txtFechaCreacion;
    }

    public void setTxtFechaCreacion(InputText txtFechaCreacion) {
        this.txtFechaCreacion = txtFechaCreacion;
    }

    public InputText getTxtUsuarioCreacion() {
        return txtUsuarioCreacion;
    }

    public void setTxtUsuarioCreacion(InputText txtUsuarioCreacion) {
        this.txtUsuarioCreacion = txtUsuarioCreacion;
    }

    public InputText getTxtConsecutivo() {
        return txtConsecutivo;
    }

    public void setTxtConsecutivo(InputText txtConsecutivo) {
        this.txtConsecutivo = txtConsecutivo;
    }

    public List<TbcatalogoareasDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTbcatalogoareas();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TbcatalogoareasDTO> tbcatalogoareasDTO) {
        this.data = tbcatalogoareasDTO;
    }

    public TbcatalogoareasDTO getSelectedTbcatalogoareas() {
        return selectedTbcatalogoareas;
    }

    public void setSelectedTbcatalogoareas(TbcatalogoareasDTO tbcatalogoareas) {
        this.selectedTbcatalogoareas = tbcatalogoareas;
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
