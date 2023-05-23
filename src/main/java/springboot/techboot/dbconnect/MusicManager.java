package springboot.techboot.dbconnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.techboot.DB.Music;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class MusicManager {
  @Autowired
  private DBConnector dbConnector;

  public ArrayList<Music> getMusicList(){
    ArrayList<Music> musics=new ArrayList<>();
    try{
      PreparedStatement preparedStatement = dbConnector
          .getConnection().prepareStatement("select * from musics order by name asc");
      ResultSet resultSet=preparedStatement.executeQuery();
      while(resultSet.next()){
        Music music=new Music();
        music.setId(resultSet.getLong("id"));
        music.setAuthor(resultSet.getString("author"));
        music.setName(resultSet.getString("name"));
        music.setDuaration(resultSet.getInt("duration"));
        musics.add(music);
      }
      preparedStatement.close();
    }catch (Exception e){
      e.printStackTrace();
    }
    return musics;
  }
  public void addMusics(Music music){
    try{
      PreparedStatement preparedStatement = dbConnector
          .getConnection().prepareStatement("insert into musics(name,author,duration)" +
              "VALUES (?,?,?)");
      preparedStatement.setString(1, music.getName());
      preparedStatement.setString(2, music.getAuthor());
      preparedStatement.setInt(3, music.getDuaration());
      preparedStatement.executeUpdate();
      preparedStatement.close();
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
