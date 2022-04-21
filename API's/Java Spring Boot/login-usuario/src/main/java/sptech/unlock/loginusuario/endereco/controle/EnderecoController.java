package sptech.unlock.loginusuario.endereco.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.endereco.entidade.Endereco;
import sptech.unlock.loginusuario.endereco.repositorio.RepositorioEndereco;

@RestController
@RequestMapping(path = "/endereco")
public class EnderecoController {

    @Autowired
    private RepositorioEndereco enderecos;


    @GetMapping
    public ResponseEntity getEndereco(){
        if(enderecos.findAll().isEmpty()){
            return ResponseEntity.status(204).body(enderecos.findAll());
        }else{
            return ResponseEntity.status(200).body(enderecos.findAll());
        }
    }

    @PostMapping
    public ResponseEntity cadastrarEndereco(@RequestBody Endereco endereco){
        enderecos.save(endereco);
        return ResponseEntity.status(201).body(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizaEndereco(
            @PathVariable Integer id,
            @RequestBody Endereco end
    ){
        for (Endereco endereco : enderecos.findAll()){
            if(endereco.getId().equals(id)){
                endereco.setCep(end.getCep());
                endereco.setLogradouro(end.getLogradouro());
                endereco.setNumero(end.getNumero());
                endereco.setUf(end.getUf());
                endereco.setCidade(end.getCidade());
                endereco.setBairro(end.getBairro());
                Endereco enderecoSalvo = enderecos.save(endereco);

                return ResponseEntity.status(200).body(enderecoSalvo);
            }
        }
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEndereco(@PathVariable Integer id){
        if(enderecos.existsById(id)){
            enderecos.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(204).build();
    }

}
