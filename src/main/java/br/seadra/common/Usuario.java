package br.seadra.common;

import com.seadra.documents.Perfil;
import com.seadra.documents.Pessoa;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Data

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 06/11/2020
 */

@Document(collection = "usuario")
public class Usuario  {
    @Id
    private long id;
    private String login;
    private String senha;
    private Perfil perfil;
    private Pessoa pessoa;
    private String Status;
    LocalDateTime dataCadastro = LocalDateTime.now();

}