package com.afpa.tennis.core.service;

import com.afpa.tennis.core.entity.Joueur;
import com.afpa.tennis.core.repository.JoueurRepository;

import java.util.List;

public class JoueurService {
    private JoueurRepository joueurRepository;

    public JoueurService(){
        this.joueurRepository = new JoueurRepository();
    }

    public void create(Joueur joueur){
        joueurRepository.create(joueur);
    }

    public Joueur getJoueur(Long id){
        return joueurRepository.getById(id);
    }

    public void update(Joueur joueur) {
        joueurRepository.update(joueur);
    }

    public List<Joueur> liste(){
        return joueurRepository.liste();
    }
}
