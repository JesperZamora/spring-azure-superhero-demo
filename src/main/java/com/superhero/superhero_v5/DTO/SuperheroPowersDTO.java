package com.superhero.superhero_v5.DTO;

import java.util.List;

public class SuperheroPowersDTO {
    private String heroName;
    private List<String> heroPowerList;

    public SuperheroPowersDTO(String heroName, List<String> heroPowerList) {
        this.heroName = heroName;
        this.heroPowerList = heroPowerList;
    }

    public String getHeroName() {
        return heroName;
    }

    public List<String> getHeroPower() {
        return heroPowerList;
    }

    public void addHeroPower(String superpower) {
        heroPowerList.add(superpower);
    }
}
