package com.afpa.tennis.core.service;

import com.afpa.tennis.core.entity.Tournoi;
import com.afpa.tennis.core.repository.TournoiRepository;

import java.util.List;

public class TournoiService {
    private TournoiRepository tournoiRepository;

    public TournoiService(){
        this.tournoiRepository = new TournoiRepository();
    }

    public void create(Tournoi  tournoi){
        tournoiRepository.create(tournoi);
    }

    public Tournoi getTournoi(Long id){
        return tournoiRepository.getById(id);
    }

    public void update(Tournoi tournoi) {
        tournoiRepository.update(tournoi);
    }

    public List<Tournoi> liste(){
        return tournoiRepository.liste();
    }
}
