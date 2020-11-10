package br.seadra;

import br.seadra.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 06/11/2020
 */

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void run(String... arg0) {

    }
}