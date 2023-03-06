package com.example.song.controller;

/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here

//import com.example.song.Song;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

import com.example.song.model.Song;
import com.example.song.service.SongJpaService;

@RestController
public class SongController 
{
    @Autowired
    public SongJpaService songService;

    @GetMapping("/songs")
    public ArrayList<Song> getSongs()
    {
        return songService.getSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable("songId") int songId)
    {
        return songService.getSongById(songId);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song)
    {
        return songService.addSong(song);
    }
    @PutMapping("/songs/{songId}")
    public Song updateSong(@RequestBody Song song,@PathVariable("songId") int songId)
    {
        return songService.updateSong(song,songId);
    }
    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId)
    {
        songService.deleteSong(songId);
    }
}