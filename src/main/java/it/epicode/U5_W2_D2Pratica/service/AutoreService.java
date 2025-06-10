package it.epicode.U5_W2_D2Pratica.service;

import it.epicode.U5_W2_D2Pratica.exception.AutoreNotFoundException;
import it.epicode.U5_W2_D2Pratica.model.Autore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {
    private List<Autore> autori = new ArrayList<>();

    public Autore saveAutore(Autore autore){
        autore.setId(new Random().nextInt(1,200));
        autore.setAvatar("https://ui-avatars.com/api" + autore.getNome() + autore.getCognome());
        autori.add(autore);
        return autore;
    }

    public Autore getAutore(int id) throws AutoreNotFoundException {
        return autori.stream().filter(autore -> autore.getId()== id)
                .findFirst()
                .orElseThrow(() -> new AutoreNotFoundException("Non esiste un autore con questo id " + id));
    }

    public List<Autore> getAllAutori(){
        return autori;
    }

    public Autore updateAutore(int id, Autore autore) throws AutoreNotFoundException{
        Autore autoreDaCercare = getAutore(id);
        autoreDaCercare.setNome(autore.getNome());
        autoreDaCercare.setCognome(autore.getCognome());
        autoreDaCercare.setEmail(autore.getEmail());
        autoreDaCercare.setDataNascita(autore.getDataNascita());
        return autoreDaCercare;
    }

    public void deleteAutore(int id) throws AutoreNotFoundException{
        Autore autoreDaCancellare = getAutore(id);
        autori.remove(autoreDaCancellare);
    }


}
