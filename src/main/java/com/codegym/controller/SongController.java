package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.model.SongForm;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/song")
@PropertySource("classpath:upload_file.properties")
public class SongController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private ISongService songService;

    @RequestMapping("")
    public String index(Model model){
        List<Song> songList =songService.findAllSong();
        model.addAttribute("songs",songList);
        return "home";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute SongForm songForm) {
        MultipartFile multipartFile = songForm.getNameSong();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getNameSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getId(),songForm.getName(),songForm.getSinger(),songForm.getCategory(),fileName);
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songForm", songForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
    @GetMapping("/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
        songService.remove(id);
        return "redirect:/song";
    }

}
