// Write your code here
package com.example.song.repository;
import java.util.*;

//import com.example.spring.boot.model.Song;
import com.example.song.model.Song;

public interface SongRepository
{
    ArrayList<Song> getSongs();
    Song getSongById(int songId);
    Song addSong(Song song);
    Song updateSong(Song song,int songId);
    void deleteSong(int songId);
}