/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.iff.edu.javaweb20181.trabalhoweb.bean;

import br.iff.edu.javaweb20181.trabalhoweb.dao.ContatoDAO;
import br.iff.edu.javaweb20181.trabalhoweb.model.Contato;

/**
 *
 * @author Lucas
 */
public class ContatoBean {
    
    private String nome;
    private String email;
    private String mensagem;
    
    public void salvarMensagem()
    {
       Contato c = new Contato();
       c.setNome(nome);
       c.setEmail(email);
       c.setMens(mensagem);
       
       ContatoDAO cDAO = new ContatoDAO();
       cDAO.insert(c);
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
