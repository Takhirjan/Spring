package springboot.techboot.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.techboot.controller.DBManager;
import springboot.techboot.dbconnect.DBConnector;

import java.sql.Connection;

@Configuration
public class BeanConfig {
  @Bean(name = "Takha")
  public TestB testB(){
    TestB testB=new TestB("Takha",55);
    testB.setCode("Takhirzhan");
    return testB;
  }
  @Bean(name = "johnBean")
  public TestB testBa(){
    TestB testB=new TestB("John",999);
    return testB;
  }
  @Bean
  public DBConnector connection(){
    DBConnector dbConnector=new DBConnector("jdbc:mysql://localhost:3306/techboot","root","");
    return dbConnector;
  }
@Bean
  public DBManager dbManager(){
    return new DBManager();
}
}
