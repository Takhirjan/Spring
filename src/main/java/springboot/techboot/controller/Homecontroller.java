package springboot.techboot.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.techboot.DB.Music;

import java.util.ArrayList;

@Controller
public class Homecontroller {

  @GetMapping(value = "/") // @WebServlet(value = "/") + doGet()
  public String indexPage(Model model){
    ArrayList<Music> musicArray = DBManager.getMusics();
    model.addAttribute("musics", musicArray);
    // request.setAttribute("muzikalar", musicArray);
    return "index"; // request.getRequestDispatchet("/index.html").forward(request, response);
  }

  @GetMapping(value="/about")
  public String about(){
    return "about_page";
  }
  @PostMapping(value = "/add-music")
  public String addMusic(Music music){
  DBManager.addMusic(music);
  return "redirect:/";
  }
  @PostMapping(value = "/add-music-v2")
  public String addMusicV2(
      @RequestParam(name="music-name") String name,
      @RequestParam(name="music-author") String author,
      @RequestParam(name="music-duaration") int duration
  ){
  Music music=new Music();
    music.setName(name);
    music.setAuthor(author);
    music.setDuaration(duration);
    DBManager.addMusic(music);
    return "redirect:/";
  }
  @GetMapping(value = "/music-details")
  public String getMusic(@RequestParam(name = "MusicId")int id,
                         Model model){
    Music music=DBManager.getMusic(id);
    model.addAttribute("muzyka",music);
    return  "details";

  }
  @GetMapping(value = "/add-music")
  public String addMudicPage(Model model){
    return "addmusic";
  }
}