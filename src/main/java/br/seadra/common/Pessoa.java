package br.seadra.common;

import com.seadra.documents.TipoPessoa;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 06/11/2020
 */

@Data
@Document(collection = "pessoa")
public class Pessoa {
    @Id
    String id;
    String nome;
    String cpf;
    String cnpj;
    String pais;
    String estado;
    String cidade;
    String endereco;
    String bairro;
    String cep;
    String telefone;
    String email;
    String status;
    String profissao;
    String especialidade;
    Date datanascimento;
    String sexo;
    String etinia;
    String raca;
    String imagem;
    String obs;
    com.seadra.documents.TipoPessoa tipopessoa;
    LocalDateTime datacadastro = LocalDateTime.now();

    public Pessoa() {
    }

     public Pessoa(Pessoa objPessoa) {
        super();
        this.id = objPessoa.id;
        this.nome = objPessoa.nome;
        this.cpf = objPessoa.cpf;
        this.cnpj = objPessoa.cnpj;
        this.pais = objPessoa.pais;
        this.estado = objPessoa.estado;
        this.cidade = objPessoa.cidade;
        this.endereco = objPessoa.endereco;
        this.bairro = objPessoa.bairro;
        this.cep = objPessoa.cep;
        this.telefone = objPessoa.telefone;
        this.email = objPessoa.email;
        this.status = objPessoa.status;
        this.profissao = objPessoa.profissao;
        this.especialidade = objPessoa.especialidade;
        this.datanascimento = objPessoa.datanascimento;
        this.sexo = objPessoa.sexo;
        this.etinia = objPessoa.etinia;
        this.raca = objPessoa.raca;
        this.imagem = objPessoa.imagem;
        this.obs = objPessoa.obs;
        this.datacadastro = objPessoa.datacadastro;
        this.tipopessoa = objPessoa.tipopessoa;
    }

    public Pessoa(String id, String nome, String cpf, String cnpj, String pais, String estado, String cidade, String endereco, String bairro, String cep, String telefone, String email, String status, String profissao, String especialidade, Date datanascimento, String sexo, String etinia, String raca, String imagem, String obs, com.seadra.documents.TipoPessoa tipopessoa, LocalDateTime datacadastro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.status = status;
        this.profissao = profissao;
        this.especialidade = especialidade;
        this.datanascimento = datanascimento;
        this.sexo = sexo;
        this.etinia = etinia;
        this.raca = raca;
        this.imagem = imagem;
        this.obs = obs;
        this.tipopessoa = tipopessoa;
        this.datacadastro = datacadastro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEtinia() {
        return etinia;
    }

    public void setEtinia(String etinia) {
        this.etinia = etinia;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public com.seadra.documents.TipoPessoa getTipopessoa() {
        return tipopessoa;
    }

    public void setTipopessoa(TipoPessoa tipopessoa) {
        this.tipopessoa = tipopessoa;
    }

    public LocalDateTime getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(LocalDateTime datacadastro) {
        this.datacadastro = datacadastro;
    }
}