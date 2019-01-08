package fr.laerce.cinema.web;

import fr.laerce.cinema.model.Genre;
import fr.laerce.cinema.service.GenreManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
@RequestMapping("/genre")
public class GenreController {

    /**
     *On crée un attribut accesible a toutes les methodes
     */
    GenreManager genreManager;

    /**
     *On donne une valeur a genreManager dans leconstructeur ou on crash l'app si genremanager est null
     * @param genreManager
     */
    public GenreController(GenreManager genreManager){
        this.genreManager = genreManager;
        assert(genreManager != null);
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("")
    public String main(Model model){
        model.addAttribute("genres", genreManager.getAll());
        model.addAttribute("newgenre", new Genre());
        return "genre/form";
    }

}
