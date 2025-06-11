package it.epicode.U5_W2_D2Pratica.service;

import it.epicode.U5_W2_D2Pratica.dto.AutoreDto;
import it.epicode.U5_W2_D2Pratica.exception.NotFoundException;
import it.epicode.U5_W2_D2Pratica.model.Autore;
import it.epicode.U5_W2_D2Pratica.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    public Autore saveAutore(AutoreDto autoreDto){

        Autore autore = new Autore();
        autore.setNome(autoreDto.getNome());
        autore.setCognome(autoreDto.getCognome());
        autore.setEmail(autoreDto.getEmail());
        autore.setDataNascita(autoreDto.getDataNascita());
        autore.setAvatar("https://ui-avatars.com/api" + autore.getNome() + autore.getCognome());
        return autoreRepository.save(autore);
    }

    public Autore getAutore(int id) throws NotFoundException {
       return autoreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Non esiste un autore con questo id " + id));
    }

    public Page<Autore> getAllAutori(int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return autoreRepository.findAll(pageable);
    }

    public Autore updateAutore(int id, AutoreDto autoreDto) throws NotFoundException{
        Autore autoreDaAggiornare = getAutore(id);
        autoreDaAggiornare.setNome(autoreDto.getNome());
        autoreDaAggiornare.setCognome(autoreDto.getCognome());
        autoreDaAggiornare.setEmail(autoreDto.getEmail());
        autoreDaAggiornare.setDataNascita(autoreDto.getDataNascita());
        autoreDaAggiornare.setAvatar("https://ui-avatars.com/api" + autoreDto.getNome() + autoreDto.getCognome());
        return autoreRepository.save(autoreDaAggiornare);
    }

    public void deleteAutore(int id) throws NotFoundException{
        Autore autoreDaCancellare = getAutore(id);
        autoreRepository.delete(autoreDaCancellare);
    }


}
