package springboot.techboot.controller;

import springboot.techboot.DB.Music;

import java.util.ArrayList;

public class DBManager {
  private static final ArrayList<Music> musics=new ArrayList<>(); //final щзначает, что его я не могу переназначать,
  // но менять внутри можно
  private static Long id=5L;
  static {
    musics.add(new Music(1L,"Music 1","Singer 1",188));
    musics.add(new Music(2L,"Music 2","Singer 2",155));
    musics.add(new Music(3L,"Music 3","Singer 3",157));
    musics.add(new Music(4L,"Music 4","Singer 4",160));
  }
  public static ArrayList<Music> getMusics(){
    return musics;
  }
  public static void addMusic(Music music){
    music.setId(id);
    id++;
    musics.add(music);
  }
  public static Music getMusic(int id){
   return  musics.stream().filter(music -> music.getId()==id).findFirst().orElse(null);
  }
}
