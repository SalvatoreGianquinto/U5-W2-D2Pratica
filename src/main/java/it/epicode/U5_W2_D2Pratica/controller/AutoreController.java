package it.epicode.U5_W2_D2Pratica.controller;

import it.epicode.U5_W2_D2Pratica.exception.AutoreNotFoundException;
import it.epicode.U5_W2_D2Pratica.exception.BlogPostNotFoundException;
import it.epicode.U5_W2_D2Pratica.model.Autore;
import it.epicode.U5_W2_D2Pratica.model.BlogPost;
import it.epicode.U5_W2_D2Pratica.service.AutoreService;
import it.epicode.U5_W2_D2Pratica.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @PostMapping("/autore")
    public Autore saveAutore(@RequestBody Autore autore){
        return autoreService.saveAutore(autore);
    }

    @GetMapping("/autore/{id}")
    public Autore getAutore(@PathVariable int id) throws AutoreNotFoundException{
        return autoreService.getAutore(id);
    }

    @GetMapping("/autore")
    public List<Autore> getAllAutori(){
        return autoreService.getAllAutori();
    }

    @PutMapping("/autore/{id}")
    public Autore updateAutore(@PathVariable int id,@RequestBody Autore autore) throws AutoreNotFoundException{
        return autoreService.updateAutore(id, autore);
    }

    @DeleteMapping("/autore/{id}")
    public void deleteAutore(@PathVariable int id) throws AutoreNotFoundException{
        autoreService.deleteAutore(id);
    }
}
