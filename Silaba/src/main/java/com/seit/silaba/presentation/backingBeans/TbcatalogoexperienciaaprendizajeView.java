package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbcatalogoexperienciaaprendizajeDTO;
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
public class TbcatalogoexperienciaaprendizajeView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbcatalogoexperienciaaprendizajeView.class);
    private InputText txtCodigo;
    private InputText txtDescripcion;
    private InputText txtFechaCreacion;
    private InputText txtUsuarioCreacion;
    private InputText txtConsecutivo_Tbcatalogoexperienciaaprendizaje;
    private InputText txtConsecutivo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TbcatalogoexperienciaaprendizajeDTO> data;
    private TbcatalogoexperienciaaprendizajeDTO selectedTbcatalogoexperienciaaprendizaje;
    private Tbcatalogoexperienciaaprendizaje entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TbcatalogoexperienciaaprendizajeView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TbcatalogoexperienciaaprendizajeDTO tbcatalogoexperienciaaprendizajeDTO =
                (TbcatalogoexperienciaaprendizajeDTO) e.getObject();

            if (txtCodigo == null) {
                txtCodigo = new InputText();
            }

            txtCodigo.setValue(tbcatalogoexperienciaaprendizajeDTO.getCodigo());

            if (txtDescripcion == null) {
                txtDescripcion = new InputText();
            }

            txtDescripcion.setValue(tbcatalogoexperienciaaprendizajeDTO.getDescripcion());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new InputText();
            }

            txtFechaCreacion.setValue(tbcatalogoexperienciaaprendizajeDTO.getFechaCreacion());

            if (txtUsuarioCreacion == null) {
                txtUsuarioCreacion = new InputText();
            }

            txtUsuarioCreacion.setValue(tbcatalogoexperienciaaprendizajeDTO.getUsuarioCreacion());

            if (txtConsecutivo_Tbcatalogoexperienciaaprendizaje == null) {
                txtConsecutivo_Tbcatalogoexperienciaaprendizaje = new InputText();
            }

            txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setValue(tbcatalogoexperienciaaprendizajeDTO.getConsecutivo_Tbcatalogoexperienciaaprendizaje());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }

            txtConsecutivo.setValue(tbcatalogoexperienciaaprendizajeDTO.getConsecutivo());

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbcatalogoexperienciaaprendizaje(consecutivo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTbcatalogoexperienciaaprendizaje = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTbcatalogoexperienciaaprendizaje = null;

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

        if (txtConsecutivo_Tbcatalogoexperienciaaprendizaje != null) {
            txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setValue(null);
            txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setDisabled(true);
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
                ? businessDelegatorView.getTbcatalogoexperienciaaprendizaje(consecutivo)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCodigo.setDisabled(false);
            txtDescripcion.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtUsuarioCreacion.setDisabled(false);
            txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setDisabled(false);
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
            /*txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setValue(entity.getTbcatalogoexperienciaaprendizaje()
                                                                           .getConsecutivo());
                                                                           */
            txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setDisabled(false);
            txtConsecutivo.setValue(entity.getConsecutivo());
            txtConsecutivo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTbcatalogoexperienciaaprendizaje = (TbcatalogoexperienciaaprendizajeDTO) (evt.getComponent()
                                                                                             .getAttributes()
                                                                                             .get("selectedTbcatalogoexperienciaaprendizaje"));
        txtCodigo.setValue(selectedTbcatalogoexperienciaaprendizaje.getCodigo());
        txtCodigo.setDisabled(false);
        txtDescripcion.setValue(selectedTbcatalogoexperienciaaprendizaje.getDescripcion());
        txtDescripcion.setDisabled(false);
        txtFechaCreacion.setValue(selectedTbcatalogoexperienciaaprendizaje.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtUsuarioCreacion.setValue(selectedTbcatalogoexperienciaaprendizaje.getUsuarioCreacion());
        txtUsuarioCreacion.setDisabled(false);
        txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setValue(selectedTbcatalogoexperienciaaprendizaje.getConsecutivo_Tbcatalogoexperienciaaprendizaje());
        txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setDisabled(false);
        txtConsecutivo.setValue(selectedTbcatalogoexperienciaaprendizaje.getConsecutivo());
        txtConsecutivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTbcatalogoexperienciaaprendizaje == null) &&
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
            entity = new Tbcatalogoexperienciaaprendizaje();

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);

            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setConsecutivo(consecutivo);
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setFechaCreacion(FacesUtils.checkString(txtFechaCreacion));
            entity.setUsuarioCreacion(FacesUtils.checkString(txtUsuarioCreacion));
            entity.setTbcatalogoexperienciaaprendizaje((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogoexperienciaaprendizaje) != null)
                ? businessDelegatorView.getTbcatalogoexperienciaaprendizaje(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogoexperienciaaprendizaje)) : null);
            businessDelegatorView.saveTbcatalogoexperienciaaprendizaje(entity);
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
                Integer consecutivo = new Integer(selectedTbcatalogoexperienciaaprendizaje.getConsecutivo());
                entity = businessDelegatorView.getTbcatalogoexperienciaaprendizaje(consecutivo);
            }

            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setFechaCreacion(FacesUtils.checkString(txtFechaCreacion));
            entity.setUsuarioCreacion(FacesUtils.checkString(txtUsuarioCreacion));
            entity.setTbcatalogoexperienciaaprendizaje((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcatalogoexperienciaaprendizaje) != null)
                ? businessDelegatorView.getTbcatalogoexperienciaaprendizaje(
                    FacesUtils.checkInteger(
                        txtConsecutivo_Tbcatalogoexperienciaaprendizaje)) : null);
            businessDelegatorView.updateTbcatalogoexperienciaaprendizaje(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTbcatalogoexperienciaaprendizaje = (TbcatalogoexperienciaaprendizajeDTO) (evt.getComponent()
                                                                                                 .getAttributes()
                                                                                                 .get("selectedTbcatalogoexperienciaaprendizaje"));

            Integer consecutivo = new Integer(selectedTbcatalogoexperienciaaprendizaje.getConsecutivo());
            entity = businessDelegatorView.getTbcatalogoexperienciaaprendizaje(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbcatalogoexperienciaaprendizaje(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTbcatalogoexperienciaaprendizaje(entity);
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
            selectedTbcatalogoexperienciaaprendizaje = (TbcatalogoexperienciaaprendizajeDTO) (evt.getComponent()
                                                                                                 .getAttributes()
                                                                                                 .get("selectedTbcatalogoexperienciaaprendizaje"));

            Integer consecutivo = new Integer(selectedTbcatalogoexperienciaaprendizaje.getConsecutivo());
            entity = businessDelegatorView.getTbcatalogoexperienciaaprendizaje(consecutivo);
            businessDelegatorView.deleteTbcatalogoexperienciaaprendizaje(entity);
            data.remove(selectedTbcatalogoexperienciaaprendizaje);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String codigo, Integer consecutivo,
        String descripcion, String fechaCreacion, String usuarioCreacion,
        Integer consecutivo_Tbcatalogoexperienciaaprendizaje)
        throws Exception {
        try {
            entity.setCodigo(FacesUtils.checkString(codigo));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            entity.setFechaCreacion(FacesUtils.checkString(fechaCreacion));
            entity.setUsuarioCreacion(FacesUtils.checkString(usuarioCreacion));
            businessDelegatorView.updateTbcatalogoexperienciaaprendizaje(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TbcatalogoexperienciaaprendizajeView").requestRender();
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

    public InputText getTxtConsecutivo_Tbcatalogoexperienciaaprendizaje() {
        return txtConsecutivo_Tbcatalogoexperienciaaprendizaje;
    }

    public void setTxtConsecutivo_Tbcatalogoexperienciaaprendizaje(
        InputText txtConsecutivo_Tbcatalogoexperienciaaprendizaje) {
        this.txtConsecutivo_Tbcatalogoexperienciaaprendizaje = txtConsecutivo_Tbcatalogoexperienciaaprendizaje;
    }

    public InputText getTxtConsecutivo() {
        return txtConsecutivo;
    }

    public void setTxtConsecutivo(InputText txtConsecutivo) {
        this.txtConsecutivo = txtConsecutivo;
    }

    public List<TbcatalogoexperienciaaprendizajeDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTbcatalogoexperienciaaprendizaje();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<TbcatalogoexperienciaaprendizajeDTO> tbcatalogoexperienciaaprendizajeDTO) {
        this.data = tbcatalogoexperienciaaprendizajeDTO;
    }

    public TbcatalogoexperienciaaprendizajeDTO getSelectedTbcatalogoexperienciaaprendizaje() {
        return selectedTbcatalogoexperienciaaprendizaje;
    }

    public void setSelectedTbcatalogoexperienciaaprendizaje(
        TbcatalogoexperienciaaprendizajeDTO tbcatalogoexperienciaaprendizaje) {
        this.selectedTbcatalogoexperienciaaprendizaje = tbcatalogoexperienciaaprendizaje;
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
