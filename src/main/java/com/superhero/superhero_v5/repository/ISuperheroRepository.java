package com.superhero.superhero_v5.repository;

import com.superhero.superhero_v5.DTO.HeroRealCreationYearDTO;
import com.superhero.superhero_v5.DTO.SuperheroFormDTO;
import com.superhero.superhero_v5.DTO.SuperheroPowersDTO;

import java.util.List;

public interface ISuperheroRepository {

    List<HeroRealCreationYearDTO> getHeroInfo();
    SuperheroPowersDTO getHeroPower(String name);
    List<String> getCities();
    List<String> getPowers();
    void addSuperHero(SuperheroFormDTO form);
    void editHero();

}
