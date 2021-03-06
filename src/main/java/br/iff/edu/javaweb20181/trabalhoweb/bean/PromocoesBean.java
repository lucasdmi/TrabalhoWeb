package br.iff.edu.javaweb20181.trabalhoweb.bean;

import br.iff.edu.javaweb20181.trabalhoweb.dao.PromocaoDAO;
import java.io.IOException;
import br.iff.edu.javaweb20181.trabalhoweb.model.Promocao;
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

@Named
@ManagedBean
@ViewScoped
public class PromocoesBean implements Serializable {

    @Inject
    private LoginBean loginBean;
    private List<Promocao> promocoes;
    private List<Promocao> filteredpromocao;
    private Promocao promocaoSelecionada;
    private String preco;
    private String validade;
    private String desconto;
    private String imagem;

    @PostConstruct
    public void inicializar() {
        PromocaoDAO pDAO = new PromocaoDAO();
        promocoes = pDAO.findAll();
        if (!loginBean.isLogado()) {
            try {
                FacesContext.getCurrentInstance().
                        getExternalContext().
                        redirect("index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(PromocoesBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void inserir() {
        Promocao p = new Promocao();
        PromocaoDAO pDAO = new PromocaoDAO();
        p.setDesconto(desconto);
        p.setPreco(preco);
        p.setValidade(validade);
        p.setImagem(getImagem());
        pDAO.insert(p);
        
        limpar();

    }

    public void limpar() {
        desconto = "";
        preco = "";
        validade = "";
        imagem = "";

    }

    public void excluir() {
    PromocaoDAO pDAO = new PromocaoDAO();
        if (promocaoSelecionada != null) {
          pDAO.delete(promocaoSelecionada.getId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão de Clientes", "Cliente excluído com sucesso!"));
            
        }

    }

    public void alterar() {
        PromocaoDAO pDAO = new PromocaoDAO();
        pDAO.update(promocaoSelecionada);
        
    }

   

    public void carregarObj() {
        if (promocaoSelecionada != null) {
            desconto = promocaoSelecionada.getDesconto();
            validade = promocaoSelecionada.getValidade();
            preco = promocaoSelecionada.getPreco();

        }
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public List<Promocao> getPromocoes() {
        return promocoes;
    }

    public void setPromocoes(List<Promocao> promocoes) {
        this.promocoes = promocoes;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Promocao getPromocaoSelecionada() {
        return promocaoSelecionada;
    }

    public void setPromocaoSelecionada(Promocao promocaoSelecionada) {
        this.promocaoSelecionada = promocaoSelecionada;
    }

    public List<Promocao> getFilteredpromocao() {
        return filteredpromocao;
    }

    public void setFilteredpromocao(List<Promocao> filteredpromocao) {
        this.filteredpromocao = filteredpromocao;
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
