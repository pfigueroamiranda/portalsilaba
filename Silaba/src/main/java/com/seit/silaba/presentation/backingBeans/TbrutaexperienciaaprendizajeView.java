package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.exceptions.*;
import com.seit.silaba.modelo.*;
import com.seit.silaba.modelo.dto.RutaFormacionDTO;
import com.seit.silaba.modelo.dto.TbrutaexperienciaaprendizajeDTO;
import com.seit.silaba.presentation.businessDelegate.*;
import com.seit.silaba.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.context.RequestContext;
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
import java.util.Map;
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
public class TbrutaexperienciaaprendizajeView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TbrutaexperienciaaprendizajeView.class);
    private InputText txtCodigo;
    private InputText txtDescripcion;
    private InputText txtFechaCreacion;
    private InputText txtUsuarioCreacion;
    private InputText txtConsecutivo_Tbcatalogoexperienciaaprendizaje;
    private InputText txtConsecutivo_Tbsilaber;
    private InputText txtConsecutivo;
    private Calendar txtFechaRealVisita;
    private Calendar txtFechaPosibleVisita;
    private InputText descripcionCtlgoPto;
    private InputText consecutivoCtlgoPto;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TbrutaexperienciaaprendizajeDTO> data;
    private TbrutaexperienciaaprendizajeDTO selectedTbrutaexperienciaaprendizaje;
    private Tbrutaexperienciaaprendizaje entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;
    
    private Integer intConsecutivo;
    private boolean renderedMostrarDetalle;
    private  List<Tbrutaexperienciaaprendizaje> proyectos;
    private List<Tbexperienciapuntos> listaExperienciaXPunto ;
    private Tbsilaber silaber;

    public TbrutaexperienciaaprendizajeView() {
        super();
//        consultarProyectos();
        init();
        
    }
    public void init(){
    	 this.silaber= (Tbsilaber) FacesUtils.getSession().getAttribute("silaber"); 
    	renderedMostrarDetalle = false;
    	
    }


    public void rowEventListener(RowEditEvent e) {
        try {
            TbrutaexperienciaaprendizajeDTO tbrutaexperienciaaprendizajeDTO = (TbrutaexperienciaaprendizajeDTO) e.getObject();

            if (txtCodigo == null) {
                txtCodigo = new InputText();
            }

            txtCodigo.setValue(tbrutaexperienciaaprendizajeDTO.getCodigo());

            if (txtDescripcion == null) {
                txtDescripcion = new InputText();
            }

            txtDescripcion.setValue(tbrutaexperienciaaprendizajeDTO.getDescripcion());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new InputText();
            }

            txtFechaCreacion.setValue(tbrutaexperienciaaprendizajeDTO.getFechaCreacion());

            if (txtUsuarioCreacion == null) {
                txtUsuarioCreacion = new InputText();
            }

            txtUsuarioCreacion.setValue(tbrutaexperienciaaprendizajeDTO.getUsuarioCreacion());

            if (txtConsecutivo_Tbcatalogoexperienciaaprendizaje == null) {
                txtConsecutivo_Tbcatalogoexperienciaaprendizaje = new InputText();
            }

            txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setValue(tbrutaexperienciaaprendizajeDTO.getConsecutivo_Tbcatalogoexperienciaaprendizaje());

            if (txtConsecutivo_Tbsilaber == null) {
                txtConsecutivo_Tbsilaber = new InputText();
            }

            txtConsecutivo_Tbsilaber.setValue(tbrutaexperienciaaprendizajeDTO.getConsecutivo_Tbsilaber());

            if (txtConsecutivo == null) {
                txtConsecutivo = new InputText();
            }
            
            if (txtFechaCreacion == null) {
                txtFechaCreacion = new InputText();
            }

            txtFechaRealVisita.setValue(tbrutaexperienciaaprendizajeDTO.getFechaRealVisita());
            if (txtFechaRealVisita == null) {
            	txtFechaRealVisita = new Calendar();
            }

            txtFechaPosibleVisita.setValue(tbrutaexperienciaaprendizajeDTO.getFechaPosibleVisita());
            if (txtFechaPosibleVisita == null) {
            	txtFechaPosibleVisita = new Calendar();
            }

            descripcionCtlgoPto.setValue(tbrutaexperienciaaprendizajeDTO.getDescripcionCtlgoPto());
            if (descripcionCtlgoPto == null) {
            	descripcionCtlgoPto = new InputText();
            }

            consecutivoCtlgoPto.setValue(tbrutaexperienciaaprendizajeDTO.getConsecutivoCtlgoPto());
            if (consecutivoCtlgoPto == null) {
            	consecutivoCtlgoPto = new InputText();
            }

            txtFechaCreacion.setValue(tbrutaexperienciaaprendizajeDTO.getFechaCreacion());

            txtConsecutivo.setValue(tbrutaexperienciaaprendizajeDTO.getConsecutivo());

            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbrutaexperienciaaprendizaje(consecutivo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTbrutaexperienciaaprendizaje = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTbrutaexperienciaaprendizaje = null;
        btnSave.setDisabled(true);
        proyectos=null;
        intConsecutivo =0;
      

        return "";
    }

    public void listener_txtId() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = (consecutivo != null)
                ? businessDelegatorView.getTbrutaexperienciaaprendizaje(consecutivo)
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
            txtConsecutivo_Tbsilaber.setDisabled(false);
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
            txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setValue(entity.getTbcatalogoexperienciaaprendizaje()
                                                                           .getConsecutivo());
            txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setDisabled(false);
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
        selectedTbrutaexperienciaaprendizaje = (TbrutaexperienciaaprendizajeDTO) (evt.getComponent()
                                                                                     .getAttributes()
                                                                                     .get("selectedTbrutaexperienciaaprendizaje"));
        txtCodigo.setValue(selectedTbrutaexperienciaaprendizaje.getCodigo());
        txtCodigo.setDisabled(false);
        txtDescripcion.setValue(selectedTbrutaexperienciaaprendizaje.getDescripcion());
        txtDescripcion.setDisabled(false);
        txtFechaCreacion.setValue(selectedTbrutaexperienciaaprendizaje.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtUsuarioCreacion.setValue(selectedTbrutaexperienciaaprendizaje.getUsuarioCreacion());
        txtUsuarioCreacion.setDisabled(false);
        txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setValue(selectedTbrutaexperienciaaprendizaje.getConsecutivo_Tbcatalogoexperienciaaprendizaje());
        txtConsecutivo_Tbcatalogoexperienciaaprendizaje.setDisabled(false);
        txtConsecutivo_Tbsilaber.setValue(selectedTbrutaexperienciaaprendizaje.getConsecutivo_Tbsilaber());
        txtConsecutivo_Tbsilaber.setDisabled(false);
        txtConsecutivo.setValue(selectedTbrutaexperienciaaprendizaje.getConsecutivo());
        txtConsecutivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTbrutaexperienciaaprendizaje == null) &&
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
            entity = new Tbrutaexperienciaaprendizaje();

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
            entity.setTbsilaber((FacesUtils.checkInteger(txtConsecutivo_Tbsilaber) != null)
                ? businessDelegatorView.getTbsilaber(FacesUtils.checkInteger(txtConsecutivo_Tbsilaber)) : null);
            businessDelegatorView.saveTbrutaexperienciaaprendizaje(entity);
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
                Integer consecutivo = new Integer(selectedTbrutaexperienciaaprendizaje.getConsecutivo());
                entity = businessDelegatorView.getTbrutaexperienciaaprendizaje(consecutivo);
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
            entity.setTbsilaber((FacesUtils.checkInteger(
                    txtConsecutivo_Tbsilaber) != null)
                ? businessDelegatorView.getTbsilaber(FacesUtils.checkInteger(
                        txtConsecutivo_Tbsilaber)) : null);
            businessDelegatorView.updateTbrutaexperienciaaprendizaje(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTbrutaexperienciaaprendizaje = (TbrutaexperienciaaprendizajeDTO) (evt.getComponent()
                                                                                         .getAttributes()
                                                                                         .get("selectedTbrutaexperienciaaprendizaje"));

            Integer consecutivo = new Integer(selectedTbrutaexperienciaaprendizaje.getConsecutivo());
            entity = businessDelegatorView.getTbrutaexperienciaaprendizaje(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);
            entity = businessDelegatorView.getTbrutaexperienciaaprendizaje(consecutivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTbrutaexperienciaaprendizaje(entity);
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
            selectedTbrutaexperienciaaprendizaje = (TbrutaexperienciaaprendizajeDTO) (evt.getComponent()
                                                                                         .getAttributes()
                                                                                         .get("selectedTbrutaexperienciaaprendizaje"));

            Integer consecutivo = new Integer(selectedTbrutaexperienciaaprendizaje.getConsecutivo());
            entity = businessDelegatorView.getTbrutaexperienciaaprendizaje(consecutivo);
            businessDelegatorView.deleteTbrutaexperienciaaprendizaje(entity);
            data.remove(selectedTbrutaexperienciaaprendizaje);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String codigo, Integer consecutivo,
        String descripcion, String fechaCreacion, String usuarioCreacion,
        Integer consecutivo_Tbcatalogoexperienciaaprendizaje,
        Integer consecutivo_Tbsilaber) throws Exception {
        try {
            entity.setCodigo(FacesUtils.checkString(codigo));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            entity.setFechaCreacion(FacesUtils.checkString(fechaCreacion));
            entity.setUsuarioCreacion(FacesUtils.checkString(usuarioCreacion));
            businessDelegatorView.updateTbrutaexperienciaaprendizaje(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TbrutaexperienciaaprendizajeView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }
    
    
    /*****************AQUI VAMOS EN EL CODIGO***********/
    public String grabar(){
    	
    	try {
	    	if(intConsecutivo.intValue()!=0){
	    		
	    		 
	    		
	    		for (Tbrutaexperienciaaprendizaje proyecto : proyectos) {
	    			 
	    			entity = new Tbrutaexperienciaaprendizaje();
	    			Integer estado = 1;
	    			
	    			entity.setDescripcion(proyecto.getDescripcion());
	    			entity.setConsecutivoCtlgoPto(proyecto.getConsecutivoCtlgoPto());
	    			entity.setDescripcionCtlgoPto(proyecto.getDescripcionCtlgoPto());
	    			entity.setFechaCreacion(ManipulacionFechas.dateToString(new Date(),false));
	    			entity.setEstado(estado);
	    			entity.setFechaRealVisita(proyecto.getFechaRealVisita());
	    			entity.setFechaPosibleVisita(proyecto.getFechaPosibleVisita());
	    			entity.setUsuarioCreacion(proyecto.getTbsilaber().getUsuario());
	    			entity.setTbcatalogoexperienciaaprendizaje(proyecto.getTbcatalogoexperienciaaprendizaje());
	    			entity.setTbsilaber(silaber);
	    			businessDelegatorView.saveTbrutaexperienciaaprendizaje(entity);
				}
	    		FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
	    	}
    		action_clear();
    		//consultarProyectos(silaber.getConsecutivo());
    		
               
               
               renderedMostrarDetalle = true;
           } catch (Exception e) {
               entity = null;
               FacesUtils.addErrorMessage(e.getMessage());
           }
    
    	
    	return "";
    }
   public String consultarRuta(){
    	//acetaminofen
    	try {
    		
	    	if(intConsecutivo.intValue()!=0){
	    		btnSave.setDisabled(false);
	    		Tbcatalogoexperienciaaprendizaje proyecto = businessDelegatorView.getTbcatalogoexperienciaaprendizaje(intConsecutivo);
	    		proyectos = new ArrayList<Tbrutaexperienciaaprendizaje>();
	    		
	    		//consultarProyectos(this.silaber.getConsecutivo());
	    		List<Tbexperienciapuntos>  listaExperiencia =consultarExperienciaXPuntoSilaba();
	    		
	    		
	    		for (Tbexperienciapuntos tbexperienciapuntos : listaExperiencia) {
	    			entity = new Tbrutaexperienciaaprendizaje();
	    			Integer consecutivoCatalogo = tbexperienciapuntos.getTbcatalogopuntossilaba().getConsecutivo();
	    			 Tbcatalogopuntossilaba cata= businessDelegatorView.getTbcatalogopuntossilaba(consecutivoCatalogo);
	    			String descripcionCatalogo 	= cata.getDescripcion();
	    			
	    			Integer estado = 1;
	    			
	    			Integer consecutivo= proyectos.size()+1;
	    			 
	    			entity.setDescripcion(proyecto.getDescripcion());
	    			entity.setConsecutivoCtlgoPto(consecutivoCatalogo);
	    			entity.setDescripcionCtlgoPto(descripcionCatalogo);
	    			entity.setFechaCreacion(ManipulacionFechas.dateToString(new Date(),false));
	    			entity.setEstado(estado);
	    			entity.setFechaRealVisita(FacesUtils.checkDate(txtFechaRealVisita));
	    			entity.setFechaPosibleVisita(FacesUtils.checkDate(txtFechaPosibleVisita));
	    			entity.setUsuarioCreacion("userWeb");
	    			entity.setTbcatalogoexperienciaaprendizaje(proyecto);
	    			entity.setTbsilaber(silaber);
	    			proyectos.add(entity);
	    			
				}
	    		
	    	}else{
	    		//consultarRutasFormacion();
	    		proyectos=null;
	    		btnSave.setDisabled(true);
	    	}
    		
               renderedMostrarDetalle = true;
           } catch (Exception e) {
               entity = null;
               FacesUtils.addErrorMessage(e.getMessage());
           }
    
    	
    	return "";
    }
   
    public List<Tbexperienciapuntos> consultarExperienciaXPuntoSilaba(){
    	List<Tbexperienciapuntos> lista = null;
    	 
 	   Object[] variables = {"tbcatalogoexperienciaaprendizaje.consecutivo", false, intConsecutivo, "="};
 	
 	try {
 		lista =   	businessDelegatorView.findByCriteriaInTbexperienciapuntos(variables, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return lista;
    }
    
    public String consultarExperienciasXPuntoSilaba(){
    	
    	 
    	   Object[] variables = {"tbcatalogoexperienciaaprendizaje.consecutivo", false, intConsecutivo, "="};
    	
    	try {
			listaExperienciaXPunto =   	businessDelegatorView.findByCriteriaInTbexperienciapuntos(variables, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "";
    	
    }
    public void mostrarDetalle(ActionEvent actionEvent) {
    	
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int consProyecto = (params.get("consProyecto")!= null) ? Integer.parseInt(params.get("consProyecto")) : -1;
        
        RequestContext.getCurrentInstance().openDialog("viewCars", null, null);

    }
  
    public String mostrarDetalle2() {
    	
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int consProyecto = (params.get("consProyecto")!= null) ? Integer.parseInt(params.get("consProyecto")) : -1;
        
        RequestContext.getCurrentInstance().openDialog("viewCars", null, null);
        return "goDetalleProgramacionProyectos";

    } 
    
    public void eliminarProyecto(ActionEvent actionEvent) {
    	
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int consProyecto = (params.get("consProyecto")!= null) ? Integer.parseInt(params.get("consProyecto")) : -1;
        int consSilaber = (params.get("consSilaber")!= null) ? Integer.parseInt(params.get("consSilaber")) : -1;
       
        
        try {
        	Tbrutaexperienciaaprendizaje proyecto =businessDelegatorView.getTbrutaexperienciaaprendizaje(consProyecto);
        	businessDelegatorView.deleteTbrutaexperienciaaprendizaje(proyecto);
        	consultarProyectos(consSilaber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

    }   
    private void consultarProyectos(){
    	
		consultarProyectos(this.silaber.getConsecutivo());
    }
    
    public void consultarProyectos(Integer codSilaber){
    	
		Object[] variables = {"tbsilaber.consecutivo", false, codSilaber, "="};
		try {
			proyectos = businessDelegatorView.findByCriteriaInTbrutaexperienciaaprendizaje(variables, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    
    public List<Tbrutaexperienciaaprendizaje> consultarRutasFormacion() throws Exception{
    	List<Tbrutaexperienciaaprendizaje> formacionDTOs = null ;
    	try {
    		String user ="2";
    		formacionDTOs = businessDelegatorView.consultarRutasFormacion(user); 
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return formacionDTOs;
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

    public InputText getTxtConsecutivo_Tbsilaber() {
        return txtConsecutivo_Tbsilaber;
    }

    public void setTxtConsecutivo_Tbsilaber(InputText txtConsecutivo_Tbsilaber) {
        this.txtConsecutivo_Tbsilaber = txtConsecutivo_Tbsilaber;
    }

    public InputText getTxtConsecutivo() {
        return txtConsecutivo;
    }

    public void setTxtConsecutivo(InputText txtConsecutivo) {
        this.txtConsecutivo = txtConsecutivo;
    }

    public List<TbrutaexperienciaaprendizajeDTO> getData() {
        try {
            if (data == null) {
            	
                data = businessDelegatorView.getDataTbrutaexperienciaaprendizaje( silaber.getConsecutivo());
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<TbrutaexperienciaaprendizajeDTO> tbrutaexperienciaaprendizajeDTO) {
        this.data = tbrutaexperienciaaprendizajeDTO;
    }

    public TbrutaexperienciaaprendizajeDTO getSelectedTbrutaexperienciaaprendizaje() {
        return selectedTbrutaexperienciaaprendizaje;
    }

    public void setSelectedTbrutaexperienciaaprendizaje(
        TbrutaexperienciaaprendizajeDTO tbrutaexperienciaaprendizaje) {
        this.selectedTbrutaexperienciaaprendizaje = tbrutaexperienciaaprendizaje;
    }

    public CommandButton getBtnSave() {
    	
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
        btnSave.setDisabled(false);
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
    	consultarProyectos();
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

	public Integer getIntConsecutivo() {
		return intConsecutivo;
	}

	public void setIntConsecutivo(Integer intConsecutivo) {
		this.intConsecutivo = intConsecutivo;
	}

	public List<Tbrutaexperienciaaprendizaje> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Tbrutaexperienciaaprendizaje> proyectos) {
		this.proyectos = proyectos;
	}


	public boolean isRenderedMostrarDetalle() {
		return renderedMostrarDetalle;
	}


	public void setRenderedMostrarDetalle(boolean renderedMostrarDetalle) {
		this.renderedMostrarDetalle = renderedMostrarDetalle;
	}

	public List<Tbexperienciapuntos> getListaExperienciaXPunto() {
		return listaExperienciaXPunto;
	}

	public void setListaExperienciaXPunto(List<Tbexperienciapuntos> listaExperienciaXPunto) {
		this.listaExperienciaXPunto = listaExperienciaXPunto;
	}	
}
