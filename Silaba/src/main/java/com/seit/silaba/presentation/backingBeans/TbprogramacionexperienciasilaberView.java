package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbprogramacionexperienciasilaberDTO;
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
public class TbprogramacionexperienciasilaberView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbprogramacionexperienciasilaberView.class);
    private InputText txtConsecutivo_Tbcontenidosilaber;
    private InputText txtConsecutivo_Tbsilaber;
    private InputText txtConsecutivo;
    private Calendar txtFechaProgramacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TbprogramacionexperienciasilaberDTO> data;
    private TbprogramacionexperienciasilaberDTO selectedTbprogramacionexperienciasilaber;
    private Tbprogramacionexperienciasilaber entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TbprogramacionexperienciasilaberView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TbprogramacionexperienciasilaberDTO tbprogramacionexperienciasilaberDTO =
                (TbprogramacionexperienciasilaberDTO) e.getObject();

            if (txtConsecutivo_Tbcontenidosilaber == null) {
                txtConsecutivo_Tbcontenidosilaber = new InputText();
            }

            txtConsecutivo_Tbcontenidosilaber.setValue(tbprogramacionexperienciasilaberDTO.getConsecutivo_Tbcontenidosilaber());

            if (txtConsecutivo_Tbsilaber == null) {
                txtConsecutivo_Tbsilaber = new InputText();
            }

            txtConsecutivo_Tbsilaber.setValue(tbprogramacionexperienciasilaberDTO.getConsecutivo_Tbsilaber());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }

            txtConsecutivo.setValue(tbprogramacionexperienciasilaberDTO.getConsecutivo());

            if (txtFechaProgramacion == null) {
                txtFechaProgramacion = new Calendar();
            }

            txtFechaProgramacion.setValue(tbprogramacionexperienciasilaberDTO.getFechaProgramacion());

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbprogramacionexperienciasilaber(consecutivo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTbprogramacionexperienciasilaber = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTbprogramacionexperienciasilaber = null;

        if (txtConsecutivo_Tbcontenidosilaber != null) {
            txtConsecutivo_Tbcontenidosilaber.setValue(null);
            txtConsecutivo_Tbcontenidosilaber.setDisabled(true);
        }

        if (txtConsecutivo_Tbsilaber != null) {
            txtConsecutivo_Tbsilaber.setValue(null);
            txtConsecutivo_Tbsilaber.setDisabled(true);
        }

        if (txtFechaProgramacion != null) {
            txtFechaProgramacion.setValue(null);
            txtFechaProgramacion.setDisabled(true);
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

    public void listener_txtFechaProgramacion() {
        Date inputDate = (Date) txtFechaProgramacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = (consecutivo != null)
                ? businessDelegatorView.getTbprogramacionexperienciasilaber(consecutivo)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtConsecutivo_Tbcontenidosilaber.setDisabled(false);
            txtConsecutivo_Tbsilaber.setDisabled(false);
            txtFechaProgramacion.setDisabled(false);
            txtConsecutivo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtFechaProgramacion.setValue(entity.getFechaProgramacion());
            txtFechaProgramacion.setDisabled(false);
            txtConsecutivo_Tbcontenidosilaber.setValue(entity.getTbcontenidosilaber()
                                                             .getConsecutivo());
            txtConsecutivo_Tbcontenidosilaber.setDisabled(false);
            txtConsecutivo_Tbsilaber.setValue(entity.getTbsilaber()
                                                    .getConsecutivo());
            txtConsecutivo_Tbsilaber.setDisabled(false);
            txtConsecutivo.setValue(entity.getConsecutivo());
            txtConsecutivo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTbprogramacionexperienciasilaber = (TbprogramacionexperienciasilaberDTO) (evt.getComponent()
                                                                                             .getAttributes()
                                                                                             .get("selectedTbprogramacionexperienciasilaber"));
        txtFechaProgramacion.setValue(selectedTbprogramacionexperienciasilaber.getFechaProgramacion());
        txtFechaProgramacion.setDisabled(false);
        txtConsecutivo_Tbcontenidosilaber.setValue(selectedTbprogramacionexperienciasilaber.getConsecutivo_Tbcontenidosilaber());
        txtConsecutivo_Tbcontenidosilaber.setDisabled(false);
        txtConsecutivo_Tbsilaber.setValue(selectedTbprogramacionexperienciasilaber.getConsecutivo_Tbsilaber());
        txtConsecutivo_Tbsilaber.setDisabled(false);
        txtConsecutivo.setValue(selectedTbprogramacionexperienciasilaber.getConsecutivo());
        txtConsecutivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTbprogramacionexperienciasilaber == null) &&
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
            entity = new Tbprogramacionexperienciasilaber();

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);

            entity.setConsecutivo(consecutivo);
            entity.setFechaProgramacion(FacesUtils.checkDate(
                    txtFechaProgramacion));
            entity.setTbcontenidosilaber((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcontenidosilaber) != null)
                ? businessDelegatorView.getTbcontenidosilaber(
                    FacesUtils.checkInteger(txtConsecutivo_Tbcontenidosilaber))
                : null);
            entity.setTbsilaber((FacesUtils.checkInteger(
                    txtConsecutivo_Tbsilaber) != null)
                ? businessDelegatorView.getTbsilaber(FacesUtils.checkInteger(
                        txtConsecutivo_Tbsilaber)) : null);
            businessDelegatorView.saveTbprogramacionexperienciasilaber(entity);
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
                Integer consecutivo = new Integer(selectedTbprogramacionexperienciasilaber.getConsecutivo());
                entity = businessDelegatorView.getTbprogramacionexperienciasilaber(consecutivo);
            }

            entity.setFechaProgramacion(FacesUtils.checkDate(
                    txtFechaProgramacion));
            entity.setTbcontenidosilaber((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcontenidosilaber) != null)
                ? businessDelegatorView.getTbcontenidosilaber(
                    FacesUtils.checkInteger(txtConsecutivo_Tbcontenidosilaber))
                : null);
            entity.setTbsilaber((FacesUtils.checkInteger(
                    txtConsecutivo_Tbsilaber) != null)
                ? businessDelegatorView.getTbsilaber(FacesUtils.checkInteger(
                        txtConsecutivo_Tbsilaber)) : null);
            businessDelegatorView.updateTbprogramacionexperienciasilaber(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTbprogramacionexperienciasilaber = (TbprogramacionexperienciasilaberDTO) (evt.getComponent()
                                                                                                 .getAttributes()
                                                                                                 .get("selectedTbprogramacionexperienciasilaber"));

            Integer consecutivo = new Integer(selectedTbprogramacionexperienciasilaber.getConsecutivo());
            entity = businessDelegatorView.getTbprogramacionexperienciasilaber(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbprogramacionexperienciasilaber(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTbprogramacionexperienciasilaber(entity);
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
            selectedTbprogramacionexperienciasilaber = (TbprogramacionexperienciasilaberDTO) (evt.getComponent()
                                                                                                 .getAttributes()
                                                                                                 .get("selectedTbprogramacionexperienciasilaber"));

            Integer consecutivo = new Integer(selectedTbprogramacionexperienciasilaber.getConsecutivo());
            entity = businessDelegatorView.getTbprogramacionexperienciasilaber(consecutivo);
            businessDelegatorView.deleteTbprogramacionexperienciasilaber(entity);
            data.remove(selectedTbprogramacionexperienciasilaber);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer consecutivo,
        Date fechaProgramacion, Integer consecutivo_Tbcontenidosilaber,
        Integer consecutivo_Tbsilaber) throws Exception {
        try {
            entity.setFechaProgramacion(FacesUtils.checkDate(fechaProgramacion));
            businessDelegatorView.updateTbprogramacionexperienciasilaber(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TbprogramacionexperienciasilaberView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtConsecutivo_Tbcontenidosilaber() {
        return txtConsecutivo_Tbcontenidosilaber;
    }

    public void setTxtConsecutivo_Tbcontenidosilaber(
        InputText txtConsecutivo_Tbcontenidosilaber) {
        this.txtConsecutivo_Tbcontenidosilaber = txtConsecutivo_Tbcontenidosilaber;
    }

    public InputText getTxtConsecutivo_Tbsilaber() {
        return txtConsecutivo_Tbsilaber;
    }

    public void setTxtConsecutivo_Tbsilaber(InputText txtConsecutivo_Tbsilaber) {
        this.txtConsecutivo_Tbsilaber = txtConsecutivo_Tbsilaber;
    }

    public Calendar getTxtFechaProgramacion() {
        return txtFechaProgramacion;
    }

    public void setTxtFechaProgramacion(Calendar txtFechaProgramacion) {
        this.txtFechaProgramacion = txtFechaProgramacion;
    }

    public InputText getTxtConsecutivo() {
        return txtConsecutivo;
    }

    public void setTxtConsecutivo(InputText txtConsecutivo) {
        this.txtConsecutivo = txtConsecutivo;
    }

    public List<TbprogramacionexperienciasilaberDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTbprogramacionexperienciasilaber();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<TbprogramacionexperienciasilaberDTO> tbprogramacionexperienciasilaberDTO) {
        this.data = tbprogramacionexperienciasilaberDTO;
    }

    public TbprogramacionexperienciasilaberDTO getSelectedTbprogramacionexperienciasilaber() {
        return selectedTbprogramacionexperienciasilaber;
    }

    public void setSelectedTbprogramacionexperienciasilaber(
        TbprogramacionexperienciasilaberDTO tbprogramacionexperienciasilaber) {
        this.selectedTbprogramacionexperienciasilaber = tbprogramacionexperienciasilaber;
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
