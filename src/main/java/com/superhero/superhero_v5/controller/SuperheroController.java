package com.superhero.superhero_v5.controller;

import com.superhero.superhero_v5.DTO.HeroRealCreationYearDTO;
import com.superhero.superhero_v5.DTO.SuperheroFormDTO;
import com.superhero.superhero_v5.DTO.SuperheroPowersDTO;
import com.superhero.superhero_v5.repository.ISuperheroRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/superhero")
@Controller
public class SuperheroController {
    ISuperheroRepository iSuperheroRepository;

    public SuperheroController(ApplicationContext context, @Value("${superhero.repository.impl}") String impl){
        iSuperheroRepository = (ISuperheroRepository) context.getBean(impl);
    }
    
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Azure-DEMO";
    }   

    @GetMapping()
    public String getHeroInformation(Model model) {
        List<HeroRealCreationYearDTO> heroList = iSuperheroRepository.getHeroInfo();
        model.addAttribute("heroList", heroList);
        return "index";
    }

    @GetMapping("superpower/{name}")
    public String getHeroPowers(@PathVariable String name, Model model){
        SuperheroPowersDTO superheroPowers = iSuperheroRepository.getHeroPower(name);
        model.addAttribute("name", superheroPowers.getHeroName());
        model.addAttribute("powers", superheroPowers.getHeroPower());
        return "powers";
    }

    @GetMapping("/create")
    public String createSuperhero(Model model){
        SuperheroFormDTO superheroForm = new SuperheroFormDTO();
        model.addAttribute("superheroForm", superheroForm);

        List<String> cityList = iSuperheroRepository.getCities();
        model.addAttribute("cityList", cityList);

        List<String> powerList = iSuperheroRepository.getPowers();
        model.addAttribute("powerList", powerList);

        return "addSuperhero";
    }

    @PostMapping("/add")
    public String createSuperhero(@ModelAttribute SuperheroFormDTO superhero){
        iSuperheroRepository.addSuperHero(superhero);
        return "redirect:/superhero";
    }

    // No finished
    @GetMapping("/update/{name}")
    public String updateSuperhero(@ModelAttribute SuperheroFormDTO superhero){
        return "updateSuperhero";
    }

}
