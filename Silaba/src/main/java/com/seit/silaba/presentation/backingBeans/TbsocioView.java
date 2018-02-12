package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbsocioDTO;
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
public class TbsocioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbsocioView.class);
    private InputText txtApellido;
    private InputText txtNombre;
    private InputText txtTelefonoCelular;
    private InputText txtTelefonoFijo;
    private InputText txtUsuarioCreacion;
    private InputText txtConsecutivo;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaNacimiento;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TbsocioDTO> data;
    private TbsocioDTO selectedTbsocio;
    private Tbsocio entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TbsocioView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TbsocioDTO tbsocioDTO = (TbsocioDTO) e.getObject();

            if (txtApellido == null) {
                txtApellido = new InputText();
            }

            txtApellido.setValue(tbsocioDTO.getApellido());

            if (txtNombre == null) {
                txtNombre = new InputText();
            }

            txtNombre.setValue(tbsocioDTO.getNombre());

            if (txtTelefonoCelular == null) {
                txtTelefonoCelular = new InputText();
            }

            txtTelefonoCelular.setValue(tbsocioDTO.getTelefonoCelular());

            if (txtTelefonoFijo == null) {
                txtTelefonoFijo = new InputText();
            }

            txtTelefonoFijo.setValue(tbsocioDTO.getTelefonoFijo());

            if (txtUsuarioCreacion == null) {
                txtUsuarioCreacion = new InputText();
            }

            txtUsuarioCreacion.setValue(tbsocioDTO.getUsuarioCreacion());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }

            txtConsecutivo.setValue(tbsocioDTO.getConsecutivo());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(tbsocioDTO.getFechaCreacion());

            if (txtFechaNacimiento == null) {
                txtFechaNacimiento = new Calendar();
            }

            txtFechaNacimiento.setValue(tbsocioDTO.getFechaNacimiento());

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbsocio(consecutivo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTbsocio = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTbsocio = null;

        if (txtApellido != null) {
            txtApellido.setValue(null);
            txtApellido.setDisabled(true);
        }

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtTelefonoCelular != null) {
            txtTelefonoCelular.setValue(null);
            txtTelefonoCelular.setDisabled(true);
        }

        if (txtTelefonoFijo != null) {
            txtTelefonoFijo.setValue(null);
            txtTelefonoFijo.setDisabled(true);
        }

        if (txtUsuarioCreacion != null) {
            txtUsuarioCreacion.setValue(null);
            txtUsuarioCreacion.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaNacimiento != null) {
            txtFechaNacimiento.setValue(null);
            txtFechaNacimiento.setDisabled(true);
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

    public void listener_txtFechaNacimiento() {
        Date inputDate = (Date) txtFechaNacimiento.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = (consecutivo != null)
                ? businessDelegatorView.getTbsocio(consecutivo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtApellido.setDisabled(false);
            txtNombre.setDisabled(false);
            txtTelefonoCelular.setDisabled(false);
            txtTelefonoFijo.setDisabled(false);
            txtUsuarioCreacion.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaNacimiento.setDisabled(false);
            txtConsecutivo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtApellido.setValue(entity.getApellido());
            txtApellido.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaNacimiento.setValue(entity.getFechaNacimiento());
            txtFechaNacimiento.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtTelefonoCelular.setValue(entity.getTelefonoCelular());
            txtTelefonoCelular.setDisabled(false);
            txtTelefonoFijo.setValue(entity.getTelefonoFijo());
            txtTelefonoFijo.setDisabled(false);
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
        selectedTbsocio = (TbsocioDTO) (evt.getComponent().getAttributes()
                                           .get("selectedTbsocio"));
        txtApellido.setValue(selectedTbsocio.getApellido());
        txtApellido.setDisabled(false);
        txtFechaCreacion.setValue(selectedTbsocio.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaNacimiento.setValue(selectedTbsocio.getFechaNacimiento());
        txtFechaNacimiento.setDisabled(false);
        txtNombre.setValue(selectedTbsocio.getNombre());
        txtNombre.setDisabled(false);
        txtTelefonoCelular.setValue(selectedTbsocio.getTelefonoCelular());
        txtTelefonoCelular.setDisabled(false);
        txtTelefonoFijo.setValue(selectedTbsocio.getTelefonoFijo());
        txtTelefonoFijo.setDisabled(false);
        txtUsuarioCreacion.setValue(selectedTbsocio.getUsuarioCreacion());
        txtUsuarioCreacion.setDisabled(false);
        txtConsecutivo.setValue(selectedTbsocio.getConsecutivo());
        txtConsecutivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTbsocio == null) && (entity == null)) {
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
            entity = new Tbsocio();

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);

            entity.setApellido(FacesUtils.checkString(txtApellido));
            entity.setConsecutivo(consecutivo);
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaNacimiento(FacesUtils.checkDate(txtFechaNacimiento));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setTelefonoCelular(FacesUtils.checkString(txtTelefonoCelular));
            entity.setTelefonoFijo(FacesUtils.checkString(txtTelefonoFijo));
            entity.setUsuarioCreacion(FacesUtils.checkString(txtUsuarioCreacion));
            businessDelegatorView.saveTbsocio(entity);
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
                Integer consecutivo = new Integer(selectedTbsocio.getConsecutivo());
                entity = businessDelegatorView.getTbsocio(consecutivo);
            }

            entity.setApellido(FacesUtils.checkString(txtApellido));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaNacimiento(FacesUtils.checkDate(txtFechaNacimiento));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setTelefonoCelular(FacesUtils.checkString(txtTelefonoCelular));
            entity.setTelefonoFijo(FacesUtils.checkString(txtTelefonoFijo));
            entity.setUsuarioCreacion(FacesUtils.checkString(txtUsuarioCreacion));
            businessDelegatorView.updateTbsocio(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTbsocio = (TbsocioDTO) (evt.getComponent().getAttributes()
                                               .get("selectedTbsocio"));

            Integer consecutivo = new Integer(selectedTbsocio.getConsecutivo());
            entity = businessDelegatorView.getTbsocio(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbsocio(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTbsocio(entity);
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
            selectedTbsocio = (TbsocioDTO) (evt.getComponent().getAttributes()
                                               .get("selectedTbsocio"));

            Integer consecutivo = new Integer(selectedTbsocio.getConsecutivo());
            entity = businessDelegatorView.getTbsocio(consecutivo);
            businessDelegatorView.deleteTbsocio(entity);
            data.remove(selectedTbsocio);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String apellido, Integer consecutivo,
        Date fechaCreacion, Date fechaNacimiento, String nombre,
        String telefonoCelular, String telefonoFijo, String usuarioCreacion)
        throws Exception {
        try {
            entity.setApellido(FacesUtils.checkString(apellido));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaNacimiento(FacesUtils.checkDate(fechaNacimiento));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setTelefonoCelular(FacesUtils.checkString(telefonoCelular));
            entity.setTelefonoFijo(FacesUtils.checkString(telefonoFijo));
            entity.setUsuarioCreacion(FacesUtils.checkString(usuarioCreacion));
            businessDelegatorView.updateTbsocio(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TbsocioView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(InputText txtApellido) {
        this.txtApellido = txtApellido;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtTelefonoCelular() {
        return txtTelefonoCelular;
    }

    public void setTxtTelefonoCelular(InputText txtTelefonoCelular) {
        this.txtTelefonoCelular = txtTelefonoCelular;
    }

    public InputText getTxtTelefonoFijo() {
        return txtTelefonoFijo;
    }

    public void setTxtTelefonoFijo(InputText txtTelefonoFijo) {
        this.txtTelefonoFijo = txtTelefonoFijo;
    }

    public InputText getTxtUsuarioCreacion() {
        return txtUsuarioCreacion;
    }

    public void setTxtUsuarioCreacion(InputText txtUsuarioCreacion) {
        this.txtUsuarioCreacion = txtUsuarioCreacion;
    }

    public Calendar getTxtFechaCreacion() {
        return txtFechaCreacion;
    }

    public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
        this.txtFechaCreacion = txtFechaCreacion;
    }

    public Calendar getTxtFechaNacimiento() {
        return txtFechaNacimiento;
    }

    public void setTxtFechaNacimiento(Calendar txtFechaNacimiento) {
        this.txtFechaNacimiento = txtFechaNacimiento;
    }

    public InputText getTxtConsecutivo() {
        return txtConsecutivo;
    }

    public void setTxtConsecutivo(InputText txtConsecutivo) {
        this.txtConsecutivo = txtConsecutivo;
    }

    public List<TbsocioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTbsocio();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TbsocioDTO> tbsocioDTO) {
        this.data = tbsocioDTO;
    }

    public TbsocioDTO getSelectedTbsocio() {
        return selectedTbsocio;
    }

    public void setSelectedTbsocio(TbsocioDTO tbsocio) {
        this.selectedTbsocio = tbsocio;
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
