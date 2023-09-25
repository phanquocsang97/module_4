package com.example.exercise2.controller;

import com.example.exercise2.model.Song;
import com.example.exercise2.model.SongDto;
import com.example.exercise2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String showList(Model model){
        List<Song> songList = songService.findAll();
        model.addAttribute("songList",songList);
        return "home";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("songDto",new SongDto());
        return "create";
    }
    @PostMapping("/create")
    public String saveInfo(@Valid @ModelAttribute SongDto songDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.create(song);
        redirectAttributes.addFlashAttribute("mess","Created Success!!");
        return "redirect:/song";
    }
}
