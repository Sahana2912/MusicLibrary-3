/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here
package com.example.song.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.song.model.Song;
import com.example.song.repository.SongJpaRepository;
import com.example.song.repository.SongRepository;

@Service 
public class SongJpaService implements SongRepository
{
    @Autowired
    private SongJpaRepository songJpaRepository;

    @Override 
    public ArrayList<Song> getSongs()
    {
        List<Song> li=songJpaRepository.findAll();
        ArrayList<Song> songs=new ArrayList<>(li);
        return songs;
    }

    @Override 

    public Song getSongById(int songId)
    {
        try 
        {
        Song song=songJpaRepository.findById(songId).get();
        return song;
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override 
    public Song addSong(Song song)
    {
        try
        {
            songJpaRepository.save(song);
            return song;
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song updateSong(Song song,int songId)
    {
        try{
        Song existingSong=songJpaRepository.findById(songId).get();

        // if(song.getSongId()!=0)
        // {
        //     existingSong.setSongId(song.getSongId());
        // }
        if(song.getSongName()!=null)
        {
            existingSong.setSongName(song.getSongName());
        }
        if(song.getSinger()!=null)
        {
            existingSong.setSinger(song.getSinger());
        }
        if(song.getLyricist()!=null)
        {
            existingSong.setLyricist(song.getLyricist());
        }
        if(song.getMusicDirector()!=null)
        {
            existingSong.setMusicDirector(song.getMusicDirector());
        }
        songJpaRepository.save(existingSong);
        return existingSong;
        }

        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
    }

    @Override
    public void deleteSong(int songId)
    {
        try 
        {
            songJpaRepository.deleteById(songId);
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}