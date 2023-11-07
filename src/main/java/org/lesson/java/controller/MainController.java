package org.lesson.java.bestoftheyear.controller;

import java.util.ArrayList;

import org.lesson.java.bestoftheyear.Movie;
import org.lesson.java.bestoftheyear.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Matteo");
        return "index";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        model.addAttribute("movies",getBestMovies());
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        model.addAttribute("songs",getBestSongs());
        return "songs";
    }

    private ArrayList<Movie> getBestMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        for(int i=0; i<10; i++) {
            movies.add(new Movie(i, "Lorem "+i));
        }
        return movies;
    }

    private ArrayList<Song> getBestSongs() {
        ArrayList<Song> songs = new ArrayList<>();
        for(int i=0; i<10; i++) {
            songs.add(new Song(i, "Ipsum "+i));
        }
        return songs;
    }
}