package br.seadra.controller;

import br.seadra.common.PessoaBuscaFuncionarioDTO;
import br.seadra.common.PessoaBuscaPacienteDTO;
import br.seadra.repository.PessoaRepository;
import br.seadra.services.PessoaService;
import com.seadra.documents.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 08/07/2020
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("pessoa")
@RestController
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping(value = "/todos")
    public Flux<Pessoa> getAll() {
        return pessoaService.findAll();
    }

    @GetMapping(value = "/buscarid/{id}")
    public Mono<Pessoa> getById(@PathVariable String id) {
        return pessoaService.findById(id)
                .map(pessoa -> ResponseEntity.ok(pessoa))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/buscacpf/{cpf}")
    public Mono<ResponseEntity<Pessoa>> getByCpf(@PathVariable String cpf) {
        return pessoaRepository.findByCpf(cpf)
                .filter(c -> c.getStatus().equals("Ativo"))
                //.filter(c -> c.getTipopessoa().toString().equals("Paciente"))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscanome/{nome}")
    public Flux<ResponseEntity<Pessoa>> getByNome(@PathVariable String nome) {
        return pessoaRepository.findByNome(nome)
                .filter(c -> c.getStatus().equals("Ativo"))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @RequestMapping(value="/flux20Painel", method=RequestMethod.GET)
    public ResponseEntity<List<PessoaBuscaPacienteDTO>> findAllPaciente() {
        Flux<Pessoa> listFlux = pessoaService.findAll();
        List<PessoaBuscaPacienteDTO> listDto = listFlux.toStream()
                .filter(c -> c.getStatus().equals("Ativo"))
                .filter(c -> c.getTipopessoa().getDescricao().equals("Exportador"))
                .sorted(Comparator.comparing(Pessoa::getId).reversed())
                .map(PessoaBuscaPacienteDTO::new)
                .limit(20)
                .collect( Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/flux20Exportador", method=RequestMethod.GET)
    public ResponseEntity<List<PessoaBuscaFuncionarioDTO>> findAllFuncionario() {
        Flux<Pessoa> listFlux = pessoaService.findAll();
        List<PessoaBuscaFuncionarioDTO> listDto = listFlux.toStream()
                .filter(c -> c.getStatus().equals("Ativo"))
                .filter(c -> c.getTipopessoa().getDescricao().equals("Exportador"))
                .sorted(Comparator.comparing(Pessoa::getId).reversed())
                .map(PessoaBuscaFuncionarioDTO::new)
                .limit(20)
                .collect( Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/buscaEmail/{email}")
    public Flux<ResponseEntity<Pessoa>> getByEmail(@PathVariable String email) {
        return pessoaRepository.findByEmail(email)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/exportador/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<Pessoa>> create(@RequestBody Pessoa pessoa) {
        return pessoaService.save(pessoa)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/put/{id}")
    public Mono<ResponseEntity<Pessoa>>
                    updatePessoa(@PathVariable(value="id") String id,
                                 @RequestBody Pessoa pessoa) {

        return pessoaService.findById(id)
                .flatMap(pessoaExiste -> {
                    pessoa.setNome(pessoa.getNome());
                    pessoa.setCpf(pessoa.getCpf());
                    pessoa.setEstado(pessoa.getEstado());
                    pessoa.setCidade(pessoa.getCidade());
                    pessoa.setEndereco(pessoa.getEndereco());
                    pessoa.setBairro(pessoa.getBairro());
                    pessoa.setCep(pessoa.getCep());
                    pessoa.setTelefone(pessoa.getTelefone());
                    pessoa.setEmail(pessoa.getEmail());
                    pessoa.setStatus(pessoa.getStatus());
                    pessoa.setProfissao(pessoa.getProfissao());
                    pessoa.setSexo(pessoa.getSexo());
                    pessoa.setEtinia(pessoa.getEtinia());
                    pessoa.setRaca(pessoa.getRaca());
                    pessoa.setDatacadastro(pessoa.getDatacadastro());
                    return pessoaService.update(pessoa);
                })
                .map(updatePessoa -> ResponseEntity.ok(updatePessoa))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    // https://localhost:8080/pessoa/fullsearch?nome=maria
    // https://localhost:8080/pessoa/fullsearch?nome=maria&?cpf=6452545225888
    @RequestMapping(value="/fullsearch", method=RequestMethod.GET)
    public ResponseEntity<Flux<Pessoa>> fullSearch(
            @RequestParam(value="nome", defaultValue="") String nome,
            @RequestParam(value="cpf", defaultValue="") String cpf,
            @RequestParam(value="email", defaultValue="") String email,
            @RequestParam(value="telefone", defaultValue="") String telefone,
            @RequestParam(value="cep", defaultValue="") String cep
    )
    {
        Flux<Pessoa> list = pessoaRepository.fullSearch(nome, cpf, email, telefone, cep);
        return ResponseEntity.ok().body(list);
    }
}
