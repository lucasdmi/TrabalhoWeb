package br.iff.edu.javaweb20181.trabalhoweb.bean;

import br.iff.edu.javaweb20181.trabalhoweb.dao.CelularDAO;
import br.iff.edu.javaweb20181.trabalhoweb.model.Celular;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Lucas
 */
@Named
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {

    @Inject
    private LoginBean loginBean;
    private List<Celular> celulares;
    private List<Celular> filteredCelular;
    private Celular celularSelecionado;
    private String descricao;
    private String preco;
    private String marca;
    private String camera;
    private String memoria;
    private String sistemaOperacional;
    private String processador;
    private String imagem;

    public ProdutoBean() {
    }

    @PostConstruct
    public void inicializar() {
        limpar();
        
        CelularDAO cDAO = new CelularDAO();
        celulares = cDAO.findAll();

        if (!loginBean.isLogado()) {
            try {
                FacesContext.getCurrentInstance().
                        getExternalContext().
                        redirect("index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void limpar() {
        descricao = "";
        preco = "";
        marca = "";
        camera = "";
        memoria = "";
        sistemaOperacional = "";
        processador = "";
        imagem = "";
    }

    public void excluir() {

        if (celularSelecionado != null) {
            CelularDAO cDAO = new CelularDAO();
            cDAO.delete(celularSelecionado.getId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão de Clientes", "Cliente excluído com sucesso!"));
        }

    }

    public void alterar() {
         CelularDAO cDAO = new CelularDAO();
        if(cDAO.update(celularSelecionado)){
            inicializar();
        }
    }

    public void redefinir() {
        for (Celular c : celulares) {
            if (c.getDescricao().equals(descricao)) {
                marca = c.getMarca();
                preco = c.getPreco();
                camera = c.getCamera();
                memoria = c.getMemoria();
                sistemaOperacional = c.getSistemaOperacional();
                processador = c.getProcessador();
            }
        }
    }

    public void carregarObj() {
        if (celularSelecionado != null) {
            preco = celularSelecionado.getPreco();
            marca = celularSelecionado.getMarca();
            camera = celularSelecionado.getCamera();
            memoria = celularSelecionado.getMemoria();
            descricao = celularSelecionado.getDescricao();
            sistemaOperacional = celularSelecionado.getSistemaOperacional();
            processador = celularSelecionado.getProcessador();

        }
    }

    public void salvar() {
        CelularDAO cDAO = new CelularDAO();
        Celular c = new Celular();
        c.setDescricao(descricao);
        c.setPreco(preco);
        c.setMarca(marca);
        c.setMemoria(memoria);
        c.setCamera(camera);
        c.setSistemaOperacional(sistemaOperacional);
        c.setProcessador(processador);
        c.setImagem(imagem);
        cDAO.insert(c);
        limpar();
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public List<Celular> getCelulares() {
        return celulares;
    }

    public void setCelulares(List<Celular> celulares) {
        this.celulares = celulares;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public List<Celular> getFilteredCelular() {
        return filteredCelular;
    }

    public void setFilteredCelular(List<Celular> filteredCelular) {
        this.filteredCelular = filteredCelular;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Celular getCelularSelecionado() {
        return celularSelecionado;
    }

    public void setCelularSelecionado(Celular celularSelecionado) {
        this.celularSelecionado = celularSelecionado;
    }

    /**
     * @return the loginBean
     */
    public LoginBean getLoginBean() {
        return loginBean;
    }

    /**
     * @param loginBean the loginBean to set
     */
    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

}
