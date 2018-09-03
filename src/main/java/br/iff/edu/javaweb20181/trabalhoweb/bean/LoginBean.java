/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iff.edu.javaweb20181.trabalhoweb.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author 16322064711
 */
@Named
@SessionScoped
public class LoginBean implements Serializable{
    
    private String usuario;
    private String senha;
    private boolean logado;
    
   

    

    @PostConstruct
    public void init(){
        logado = false;
    }
    
    
    public void logar(){
       if(usuario.equals("teste") && senha.equals("123"))
       {
           logado = true;
           
           System.out.println(logado);
           try {
               FacesContext.getCurrentInstance().
                       getExternalContext().
                       redirect("index.xhtml");
           } catch (IOException ex) {
               Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       else
       {
          logado = false;
       }
    }
    
     public void sair(){
        usuario = null;
        senha = null;
        logado = false;
        try {
            FacesContext.getCurrentInstance().
                    getExternalContext().
                    redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
