package org.lesson.java.bestoftheyear.controller;

import java.util.ArrayList;

import org.lesson.java.bestoftheyear.Movie;
import org.lesson.java.bestoftheyear.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/movies/{id}")
    public String movie(Model model, @PathVariable int id) {
        model.addAttribute("data", getMovie(getBestMovies(), id));
        return "selected";
    }

    @GetMapping("/songs/{id}")
    public String song(Model model, @PathVariable int id) {
        model.addAttribute("data", getSong(getBestSongs(), id));
        return "selected";
    }

    private ArrayList<Movie> getBestMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        for(int i=0; i<10; i++) {
            movies.add(new Movie(i, "Movie "+i));
        }
        return movies;
    }

    private ArrayList<Song> getBestSongs() {
        ArrayList<Song> songs = new ArrayList<>();
        for(int i=0; i<10; i++) {
            songs.add(new Song(i, "Song "+i));
        }
        return songs;
    }

    private Movie getMovie(ArrayList<Movie> movies, int id) {
        return movies.stream().filter(movie -> movie.getId() == id).toList().get(0);
    }

    private Song getSong(ArrayList<Song> songs, int id) {
        return songs.stream().filter(song -> song.getId() == id).toList().get(0);
    }

}