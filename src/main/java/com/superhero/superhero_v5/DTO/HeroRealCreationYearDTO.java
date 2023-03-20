package com.superhero.superhero_v5.DTO;

public class HeroRealCreationYearDTO {
    private String heroName;
    private String realName;
    private String creationYear;

    public HeroRealCreationYearDTO(String heroName, String realName, String creationYear) {
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public String getCreationYear() {
        return creationYear;
    }
}
