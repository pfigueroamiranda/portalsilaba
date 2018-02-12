package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbsilaberDTO;
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
public class TbsilaberView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbsilaberView.class);
    private InputText txtApellido;
    private InputText txtNombre;
    private InputText txtTelefonoCelular;
    private InputText txtTelefonoFijo;
    private InputText txtUsuarioCreacion;
    private InputText txtConsecutivo;
    private InputText txtUsuario;
    private InputText txtContrasena;
    private InputText txtContrasena2;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaNacimiento;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TbsilaberDTO> data;
    private TbsilaberDTO selectedTbsilaber;
    private Tbsilaber entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TbsilaberView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TbsilaberDTO tbsilaberDTO = (TbsilaberDTO) e.getObject();

            if (txtApellido == null) {
                txtApellido = new InputText();
            }

            txtApellido.setValue(tbsilaberDTO.getApellido());

            if (txtNombre == null) {
                txtNombre = new InputText();
            }

            txtNombre.setValue(tbsilaberDTO.getNombre());

            if (txtTelefonoCelular == null) {
                txtTelefonoCelular = new InputText();
            }

            txtTelefonoCelular.setValue(tbsilaberDTO.getTelefonoCelular());

            if (txtTelefonoFijo == null) {
                txtTelefonoFijo = new InputText();
            }

            txtTelefonoFijo.setValue(tbsilaberDTO.getTelefonoFijo());

            if (txtUsuarioCreacion == null) {
                txtUsuarioCreacion = new InputText();
            }

            txtUsuarioCreacion.setValue(tbsilaberDTO.getUsuarioCreacion());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }

            txtConsecutivo.setValue(tbsilaberDTO.getConsecutivo());
            
            if (txtUsuario == null) {
                txtUsuario = new InputText();
            }

            txtUsuario.setValue(tbsilaberDTO.getUsuario());
            
            if (txtContrasena == null) {
            	txtContrasena = new InputText();
            }

            txtContrasena.setValue(tbsilaberDTO.getContrasena());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(tbsilaberDTO.getFechaCreacion());

            if (txtFechaNacimiento == null) {
                txtFechaNacimiento = new Calendar();
            }

            txtFechaNacimiento.setValue(tbsilaberDTO.getFechaNacimiento());

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbsilaber(consecutivo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTbsilaber = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTbsilaber = null;

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
        
        if (txtUsuario != null) {
            txtUsuario.setValue(null);
            txtUsuario.setDisabled(true);
        }
        
        if (txtContrasena != null) {
        	txtContrasena.setValue(null);
        	txtContrasena.setDisabled(true);
        }
        
        if (txtContrasena2 != null) {
        	txtContrasena2.setValue(null);
        	txtContrasena2.setDisabled(true);
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
                ? businessDelegatorView.getTbsilaber(consecutivo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtApellido.setDisabled(false);
            txtNombre.setDisabled(false);
            txtTelefonoCelular.setDisabled(false);
            txtTelefonoFijo.setDisabled(false);
            txtUsuarioCreacion.setDisabled(false);
            txtUsuario.setDisabled(false);
            txtContrasena.setDisabled(false);
            txtContrasena2.setDisabled(false);
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
            txtUsuario.setValue(entity.getUsuario());
            txtUsuario.setDisabled(false);
            txtContrasena.setValue(entity.getContrasena());
            txtContrasena.setDisabled(false);
            txtContrasena2.setValue(entity.getContrasena());
            txtContrasena2.setDisabled(false);
            txtConsecutivo.setValue(entity.getConsecutivo());
            txtConsecutivo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTbsilaber = (TbsilaberDTO) (evt.getComponent().getAttributes()
                                               .get("selectedTbsilaber"));
        txtApellido.setValue(selectedTbsilaber.getApellido());
        txtApellido.setDisabled(false);
        txtFechaCreacion.setValue(selectedTbsilaber.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaNacimiento.setValue(selectedTbsilaber.getFechaNacimiento());
        txtFechaNacimiento.setDisabled(false);
        txtNombre.setValue(selectedTbsilaber.getNombre());
        txtNombre.setDisabled(false);
        txtTelefonoCelular.setValue(selectedTbsilaber.getTelefonoCelular());
        txtTelefonoCelular.setDisabled(false);
        txtTelefonoFijo.setValue(selectedTbsilaber.getTelefonoFijo());
        txtTelefonoFijo.setDisabled(false);
        txtUsuarioCreacion.setValue(selectedTbsilaber.getUsuarioCreacion());
        txtUsuarioCreacion.setDisabled(false);
        //txtUsuario.setValue(selectedTbsilaber.getUsuario());
        //txtUsuario.setDisabled(false);
        txtContrasena.setValue(selectedTbsilaber.getContrasena());
        txtContrasena.setDisabled(false);
        txtConsecutivo.setValue(selectedTbsilaber.getConsecutivo());
        txtConsecutivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTbsilaber == null) && (entity == null)) {
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
            entity = new Tbsilaber();

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);

            entity.setApellido(FacesUtils.checkString(txtApellido));
            entity.setConsecutivo(consecutivo);
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaNacimiento(FacesUtils.checkDate(txtFechaNacimiento));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setTelefonoCelular(FacesUtils.checkString(txtTelefonoCelular));
            entity.setTelefonoFijo(FacesUtils.checkString(txtTelefonoFijo));
            entity.setUsuarioCreacion(FacesUtils.checkString(txtUsuarioCreacion));
            entity.setUsuario(FacesUtils.checkString(txtUsuario));
            entity.setContrasena(FacesUtils.checkString(txtContrasena));
            businessDelegatorView.saveTbsilaber(entity);
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
                Integer consecutivo = new Integer(selectedTbsilaber.getConsecutivo());
                entity = businessDelegatorView.getTbsilaber(consecutivo);
            }

            entity.setApellido(FacesUtils.checkString(txtApellido));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaNacimiento(FacesUtils.checkDate(txtFechaNacimiento));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setTelefonoCelular(FacesUtils.checkString(txtTelefonoCelular));
            entity.setTelefonoFijo(FacesUtils.checkString(txtTelefonoFijo));
            entity.setUsuarioCreacion(FacesUtils.checkString(txtUsuarioCreacion));
            entity.setUsuario(FacesUtils.checkString(txtUsuario));
            entity.setContrasena(FacesUtils.checkString(txtContrasena));
            businessDelegatorView.updateTbsilaber(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTbsilaber = (TbsilaberDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedTbsilaber"));

            Integer consecutivo = new Integer(selectedTbsilaber.getConsecutivo());
            entity = businessDelegatorView.getTbsilaber(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbsilaber(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTbsilaber(entity);
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
            selectedTbsilaber = (TbsilaberDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedTbsilaber"));

            Integer consecutivo = new Integer(selectedTbsilaber.getConsecutivo());
            entity = businessDelegatorView.getTbsilaber(consecutivo);
            businessDelegatorView.deleteTbsilaber(entity);
            data.remove(selectedTbsilaber);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String apellido, Integer consecutivo,
        Date fechaCreacion, Date fechaNacimiento, String nombre,
        String telefonoCelular, String telefonoFijo, String usuarioCreacion,
    	String usuario, String contrasena)
        throws Exception {
        try {
            entity.setApellido(FacesUtils.checkString(apellido));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaNacimiento(FacesUtils.checkDate(fechaNacimiento));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setTelefonoCelular(FacesUtils.checkString(telefonoCelular));
            entity.setTelefonoFijo(FacesUtils.checkString(telefonoFijo));
            entity.setUsuarioCreacion(FacesUtils.checkString(usuarioCreacion));
            entity.setUsuario(FacesUtils.checkString(usuario));
            entity.setContrasena(FacesUtils.checkString(contrasena));
            businessDelegatorView.updateTbsilaber(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TbsilaberView").requestRender();
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

    public List<TbsilaberDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTbsilaber();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TbsilaberDTO> tbsilaberDTO) {
        this.data = tbsilaberDTO;
    }

    public TbsilaberDTO getSelectedTbsilaber() {
        return selectedTbsilaber;
    }

    public void setSelectedTbsilaber(TbsilaberDTO tbsilaber) {
        this.selectedTbsilaber = tbsilaber;
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

	public InputText getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(InputText txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public InputText getTxtContrasena() {
		return txtContrasena;
	}

	public void setTxtContrasena(InputText txtContrasena) {
		this.txtContrasena = txtContrasena;
	}

	public InputText getTxtContrasena2() {
		return txtContrasena2;
	}

	public void setTxtContrasena2(InputText txtContrasena2) {
		this.txtContrasena2 = txtContrasena2;
	}
}
