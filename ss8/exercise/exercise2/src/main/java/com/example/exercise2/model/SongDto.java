package com.example.exercise2.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongDto implements Validator {
    private int id;
    private String name;
    private String artist;
    private String kindOfMusic;

    public SongDto() {
    }

    public SongDto(int id, String name, String artist, String kindOfMusic) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (songDto.getName().equals("")){
            errors.rejectValue("name",null,"Please fill in the information");
        } else if (!songDto.getName().matches("^[a-zA-z0-9\\s]{1,800}$")) {
            errors.rejectValue("name",null,"Please do not enter special characters and maximum 800 characters");
        }
        if (songDto.getArtist().equals("")){
            errors.rejectValue("artist","Please fill in the information");
        } else if (!songDto.getArtist().matches("^[a-zA-z0-9\\s]{1,300}$")) {
            errors.rejectValue("artist","Please do not enter special characters and maximum 300 characters");
        }
        if (songDto.getKindOfMusic().equals("")){
            errors.rejectValue("kindOfMusic","Please fill in the information");
        } else if (!songDto.getKindOfMusic().matches("[a-zA-Z,]{1,1000}")) {
            errors.rejectValue("kindOfMusic","Please do not enter special characters and maximum 1000 characters");
        }
    }
}
