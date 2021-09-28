package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.FilmModel;
import apap.tutorial.cineplux.repository.FilmDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FilmServiceImpl implements FilmService{

    @Autowired
    FilmDB filmDB;

    @Override
    public void addFilm(FilmModel film) {
        filmDB.save(film);
    }
}

