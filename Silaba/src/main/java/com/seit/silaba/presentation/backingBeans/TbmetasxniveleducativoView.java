package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.TbmetasxniveleducativoDTO;
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
public class TbmetasxniveleducativoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbmetasxniveleducativoView.class);
    private InputText txtMeta;
    private InputText txtConsecutivo_Tbcompetenciasareas;
    private InputText txtConsecutivo_Tbniveleducativo;
    private InputText txtCosecutivo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TbmetasxniveleducativoDTO> data;
    private TbmetasxniveleducativoDTO selectedTbmetasxniveleducativo;
    private Tbmetasxniveleducativo entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TbmetasxniveleducativoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TbmetasxniveleducativoDTO tbmetasxniveleducativoDTO = (TbmetasxniveleducativoDTO) e.getObject();

            if (txtMeta == null) {
                txtMeta = new InputText();
            }

            txtMeta.setValue(tbmetasxniveleducativoDTO.getMeta());

            if (txtConsecutivo_Tbcompetenciasareas == null) {
                txtConsecutivo_Tbcompetenciasareas = new InputText();
            }

            txtConsecutivo_Tbcompetenciasareas.setValue(tbmetasxniveleducativoDTO.getConsecutivo_Tbcompetenciasareas());

            if (txtConsecutivo_Tbniveleducativo == null) {
                txtConsecutivo_Tbniveleducativo = new InputText();
            }

            txtConsecutivo_Tbniveleducativo.setValue(tbmetasxniveleducativoDTO.getConsecutivo_Tbniveleducativo());

            if (txtCosecutivo == null) {
                txtCosecutivo = new InputText();
            }

            txtCosecutivo.setValue(tbmetasxniveleducativoDTO.getCosecutivo());

            Integer cosecutivo = FacesUtils.checkInteger(txtCosecutivo);
            entity = businessDelegatorView.getTbmetasxniveleducativo(cosecutivo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTbmetasxniveleducativo = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTbmetasxniveleducativo = null;

        if (txtMeta != null) {
            txtMeta.setValue(null);
            txtMeta.setDisabled(true);
        }

        if (txtConsecutivo_Tbcompetenciasareas != null) {
            txtConsecutivo_Tbcompetenciasareas.setValue(null);
            txtConsecutivo_Tbcompetenciasareas.setDisabled(true);
        }

        if (txtConsecutivo_Tbniveleducativo != null) {
            txtConsecutivo_Tbniveleducativo.setValue(null);
            txtConsecutivo_Tbniveleducativo.setDisabled(true);
        }

        if (txtCosecutivo != null) {
            txtCosecutivo.setValue(null);
            txtCosecutivo.setDisabled(false);
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
            Integer cosecutivo = FacesUtils.checkInteger(txtCosecutivo);
            entity = (cosecutivo != null)
                ? businessDelegatorView.getTbmetasxniveleducativo(cosecutivo)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtMeta.setDisabled(false);
            txtConsecutivo_Tbcompetenciasareas.setDisabled(false);
            txtConsecutivo_Tbniveleducativo.setDisabled(false);
            txtCosecutivo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtMeta.setValue(entity.getMeta());
            txtMeta.setDisabled(false);
            txtConsecutivo_Tbcompetenciasareas.setValue(entity.getTbcompetenciasareas()
                                                              .getConsecutivo());
            txtConsecutivo_Tbcompetenciasareas.setDisabled(false);
            txtConsecutivo_Tbniveleducativo.setValue(entity.getTbniveleducativo()
                                                           .getConsecutivo());
            txtConsecutivo_Tbniveleducativo.setDisabled(false);
            txtCosecutivo.setValue(entity.getCosecutivo());
            txtCosecutivo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTbmetasxniveleducativo = (TbmetasxniveleducativoDTO) (evt.getComponent()
                                                                         .getAttributes()
                                                                         .get("selectedTbmetasxniveleducativo"));
        txtMeta.setValue(selectedTbmetasxniveleducativo.getMeta());
        txtMeta.setDisabled(false);
        txtConsecutivo_Tbcompetenciasareas.setValue(selectedTbmetasxniveleducativo.getConsecutivo_Tbcompetenciasareas());
        txtConsecutivo_Tbcompetenciasareas.setDisabled(false);
        txtConsecutivo_Tbniveleducativo.setValue(selectedTbmetasxniveleducativo.getConsecutivo_Tbniveleducativo());
        txtConsecutivo_Tbniveleducativo.setDisabled(false);
        txtCosecutivo.setValue(selectedTbmetasxniveleducativo.getCosecutivo());
        txtCosecutivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTbmetasxniveleducativo == null) && (entity == null)) {
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
            entity = new Tbmetasxniveleducativo();

            Integer cosecutivo = FacesUtils.checkInteger(txtCosecutivo);

            entity.setCosecutivo(cosecutivo);
            entity.setMeta(FacesUtils.checkInteger(txtMeta));
            entity.setTbcompetenciasareas((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcompetenciasareas) != null)
                ? businessDelegatorView.getTbcompetenciasareas(
                    FacesUtils.checkInteger(txtConsecutivo_Tbcompetenciasareas))
                : null);
            entity.setTbniveleducativo((FacesUtils.checkInteger(
                    txtConsecutivo_Tbniveleducativo) != null)
                ? businessDelegatorView.getTbniveleducativo(
                    FacesUtils.checkInteger(txtConsecutivo_Tbniveleducativo))
                : null);
            businessDelegatorView.saveTbmetasxniveleducativo(entity);
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
                Integer cosecutivo = new Integer(selectedTbmetasxniveleducativo.getCosecutivo());
                entity = businessDelegatorView.getTbmetasxniveleducativo(cosecutivo);
            }

            entity.setMeta(FacesUtils.checkInteger(txtMeta));
            entity.setTbcompetenciasareas((FacesUtils.checkInteger(
                    txtConsecutivo_Tbcompetenciasareas) != null)
                ? businessDelegatorView.getTbcompetenciasareas(
                    FacesUtils.checkInteger(txtConsecutivo_Tbcompetenciasareas))
                : null);
            entity.setTbniveleducativo((FacesUtils.checkInteger(
                    txtConsecutivo_Tbniveleducativo) != null)
                ? businessDelegatorView.getTbniveleducativo(
                    FacesUtils.checkInteger(txtConsecutivo_Tbniveleducativo))
                : null);
            businessDelegatorView.updateTbmetasxniveleducativo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTbmetasxniveleducativo = (TbmetasxniveleducativoDTO) (evt.getComponent()
                                                                             .getAttributes()
                                                                             .get("selectedTbmetasxniveleducativo"));

            Integer cosecutivo = new Integer(selectedTbmetasxniveleducativo.getCosecutivo());
            entity = businessDelegatorView.getTbmetasxniveleducativo(cosecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer cosecutivo = FacesUtils.checkInteger(txtCosecutivo);
            entity = businessDelegatorView.getTbmetasxniveleducativo(cosecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTbmetasxniveleducativo(entity);
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
            selectedTbmetasxniveleducativo = (TbmetasxniveleducativoDTO) (evt.getComponent()
                                                                             .getAttributes()
                                                                             .get("selectedTbmetasxniveleducativo"));

            Integer cosecutivo = new Integer(selectedTbmetasxniveleducativo.getCosecutivo());
            entity = businessDelegatorView.getTbmetasxniveleducativo(cosecutivo);
            businessDelegatorView.deleteTbmetasxniveleducativo(entity);
            data.remove(selectedTbmetasxniveleducativo);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer cosecutivo, Integer meta,
        Integer consecutivo_Tbcompetenciasareas,
        Integer consecutivo_Tbniveleducativo) throws Exception {
        try {
            entity.setMeta(FacesUtils.checkInteger(meta));
            businessDelegatorView.updateTbmetasxniveleducativo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TbmetasxniveleducativoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtMeta() {
        return txtMeta;
    }

    public void setTxtMeta(InputText txtMeta) {
        this.txtMeta = txtMeta;
    }

    public InputText getTxtConsecutivo_Tbcompetenciasareas() {
        return txtConsecutivo_Tbcompetenciasareas;
    }

    public void setTxtConsecutivo_Tbcompetenciasareas(
        InputText txtConsecutivo_Tbcompetenciasareas) {
        this.txtConsecutivo_Tbcompetenciasareas = txtConsecutivo_Tbcompetenciasareas;
    }

    public InputText getTxtConsecutivo_Tbniveleducativo() {
        return txtConsecutivo_Tbniveleducativo;
    }

    public void setTxtConsecutivo_Tbniveleducativo(
        InputText txtConsecutivo_Tbniveleducativo) {
        this.txtConsecutivo_Tbniveleducativo = txtConsecutivo_Tbniveleducativo;
    }

    public InputText getTxtCosecutivo() {
        return txtCosecutivo;
    }

    public void setTxtCosecutivo(InputText txtCosecutivo) {
        this.txtCosecutivo = txtCosecutivo;
    }

    public List<TbmetasxniveleducativoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTbmetasxniveleducativo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<TbmetasxniveleducativoDTO> tbmetasxniveleducativoDTO) {
        this.data = tbmetasxniveleducativoDTO;
    }

    public TbmetasxniveleducativoDTO getSelectedTbmetasxniveleducativo() {
        return selectedTbmetasxniveleducativo;
    }

    public void setSelectedTbmetasxniveleducativo(
        TbmetasxniveleducativoDTO tbmetasxniveleducativo) {
        this.selectedTbmetasxniveleducativo = tbmetasxniveleducativo;
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
