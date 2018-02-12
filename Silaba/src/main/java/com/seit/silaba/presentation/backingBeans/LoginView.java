package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.modelo.Tbsilaber;
import com.seit.silaba.presentation.businessDelegate.IBusinessDelegatorView;
import com.seit.silaba.utilities.*;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


@ViewScoped
@ManagedBean(name = "loginView")
public class LoginView {
    private String userId;
    private String password;
    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;
	  @ManagedProperty(value = "#{BusinessDelegatorView}")
	    private IBusinessDelegatorView businessDelegatorView;
	  

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(
        AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String login() {
        try {
        	FacesUtils.getSession().setAttribute("silaber",null); 
            
            Object[] variables = {"usuario", true, this.getUserId(), "=","contrasena", true, this.getPassword(), "="};
              
            List<Tbsilaber>  sil  = businessDelegatorView.findByCriteriaInTbsilaber(variables, null, null);
    		if(!sil.isEmpty()){
    			FacesUtils.getSession().setAttribute("silaber", sil.get(0));     
    			Authentication request = new UsernamePasswordAuthenticationToken(this.getUserId(),
    					this.getPassword());
    			Authentication result = authenticationManager.authenticate(request);
    			SecurityContext securityContext = SecurityContextHolder.getContext();
    			securityContext.setAuthentication(result);
    			
    			FacesUtils.getHttpSession(true)
    			.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
    		}else{
    			FacesUtils.addErrorMessage("Fallo usuario o contraseña");
    			return "/login.xhtml";
    		}
    		
        } catch (AuthenticationException e) {
            FacesUtils.addErrorMessage("Fallo usuario o contraseña");

            return "/login.xhtml";
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 FacesUtils.addErrorMessage("Fallo usuario o contraseña");
			 return "/login.xhtml";
		}

        return "/XHTML/initialMenu.xhtml";
    }
    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }
}
