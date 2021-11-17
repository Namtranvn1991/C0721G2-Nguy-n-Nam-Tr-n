package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Music;
import cg.wbd.grandemonstration.model.MusicForm;
import cg.wbd.grandemonstration.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class MusicController {


    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    IMusicService musicService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm", new MusicForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveMusic(@ModelAttribute MusicForm musicForm){
        MultipartFile multipartFile = musicForm.getPath();
//        String fileName = multipartFile.getOriginalFilename();
        String fileName = musicForm.getNameOfSong();
        try {
            FileCopyUtils.copy(musicForm.getPath().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Music music = new Music(musicForm.getNameOfSong(),musicForm.getSinger(),musicForm.getType(),fileName);
        musicService.addMusic(music);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm", musicForm);
        modelAndView.addObject("message", "Created new music successfully !");
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteMusic(@PathVariable Integer id){
        musicService.delete(id);
        return "redirect:/";
    }


    @GetMapping(value = "")
    public String getListPage(Model model){
        model.addAttribute("musicList",musicService.findAll());
        return "/list";
    }
}
