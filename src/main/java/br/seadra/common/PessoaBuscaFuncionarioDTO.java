package br.seadra.common;

import com.seadra.documents.Pessoa;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.*;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 08/07/2020
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class PessoaBuscaFuncionarioDTO {

    @Id
    String id;
    String nome;
    String cpf;
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
    String tipopessoa;
    LocalDateTime dataCadastro;

    public PessoaBuscaFuncionarioDTO(Pessoa objPessoa) {
        id = objPessoa.getId();
        nome = objPessoa.getNome();
        cpf = objPessoa.getCpf();
        estado = objPessoa.getEstado();
        cidade = objPessoa.getCidade();
        endereco = objPessoa.getEndereco();
        bairro = objPessoa.getBairro();
        cep = objPessoa.getCep();
        telefone = objPessoa.getTelefone();
        email = objPessoa.getEmail();
        status = objPessoa.getStatus();
        profissao = objPessoa.getProfissao();
        especialidade = objPessoa.getEspecialidade();
        datanascimento = objPessoa.getDatanascimento();
        sexo = objPessoa.getSexo();
        etinia = objPessoa.getEtinia();
        raca = objPessoa.getRaca();
        imagem = objPessoa.getImagem();
        dataCadastro = objPessoa.getDatacadastro();
        tipopessoa = objPessoa.getTipopessoa().getDescricao();
        obs = objPessoa.getObs();

    }
}
