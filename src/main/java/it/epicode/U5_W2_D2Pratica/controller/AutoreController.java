package it.epicode.U5_W2_D2Pratica.controller;

import it.epicode.U5_W2_D2Pratica.dto.AutoreDto;

import it.epicode.U5_W2_D2Pratica.exception.NotFoundException;
import it.epicode.U5_W2_D2Pratica.model.Autore;
import it.epicode.U5_W2_D2Pratica.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autore")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @PostMapping("")
    public Autore saveAutore(@RequestBody AutoreDto autoreDto){
        return autoreService.saveAutore(autoreDto);
    }

    @GetMapping("{id}")
    public Autore getAutore(@PathVariable int id) throws NotFoundException {
        return autoreService.getAutore(id);
    }

    @GetMapping("")
    public Page<Autore> getAllAutori(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(defaultValue = "id") String sortBy){
        return autoreService.getAllAutori(page, size, sortBy);
    }

    @PutMapping("{id}")
    public Autore updateAutore(@PathVariable int id,@RequestBody AutoreDto autoreDto) throws NotFoundException{
        return autoreService.updateAutore(id, autoreDto);
    }

    @DeleteMapping("{id}")
    public void deleteAutore(@PathVariable int id) throws NotFoundException{
        autoreService.deleteAutore(id);
    }
}
