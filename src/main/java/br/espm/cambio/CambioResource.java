package br.espm.cambio;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CambioResource {

    @Autowired
    private MoedaService moedaService;

    // @GetMapping("/hello")
    // public String helloWorld() {
    //     return "Hello ESPM";
    // }

    @GetMapping("/moeda")
    public List<Moeda> listMoeda() {
        return moedaService.listaAll();
    }

    @GetMapping("/moeda/{simbolo:[A-Z]{3,}}")
    public Moeda findMoedaBySimbolo(@PathVariable String simbolo) {
        return moedaService.findBySimbolo(simbolo);
    }

    @GetMapping("/moeda/{id:[a-f0-9]{8}(?:-[a-f0-9]{4}){4}[a-f0-9]{8}}")
    public Moeda findMoedaById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        return moedaService.findBy(uuid);
    }

    @PostMapping("/moeda")
    public void save(@RequestBody Moeda moeda) {
        moedaService.create(moeda);
    }
    
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
    return moedaService.deleteById(id)
                .map(record -> {
                repository.deleteById(id);
                return ResponseEntity.ok().build();
           }).orElse(ResponseEntity.notFound().build());
}

}