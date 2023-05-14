package springboot.techboot.controller;

import springboot.techboot.DB.Music;

import java.util.ArrayList;

public class DBManager {
  private static final ArrayList<Music> musics=new ArrayList<>(); //final щзначает, что его я не могу переназначать,
  // но менять внутри можно
  private static Long id=10L;
  static {
    musics.add(new Music(1L,"Music 1","Singer 1",188));
    musics.add(new Music(2L,"Music 2","Singer 2",155));
    musics.add(new Music(3L,"Music 3","Singer 3",157));
    musics.add(new Music(4L,"Music 4","Singer 4",160));
    musics.add(new Music(5L,"Music 5","Singer 5",200));
    musics.add(new Music(6L,"Music 6","Singer 6",189));
    musics.add(new Music(7L,"Music 7","Singer 7",320));
    musics.add(new Music(8L,"Music 8","Singer 8",154));
    musics.add(new Music(9L,"Music 9","Singer 9",202));

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
