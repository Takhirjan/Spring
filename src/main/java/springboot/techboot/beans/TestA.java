package springboot.techboot.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component  //Он стал клмпонентом. С момента как я начну перезагружать проект. Он возбмет и быстро создаст
// объект из класса т.е экземпляр класса testA и технично сохранит его в контекст чтобы потом использовать когда надо
//ОН будет содан до того как я запущу проект
@Getter
@Setter
public class TestA {
  public TestA(){
    System.out.println("I am creating a new object of testA");
    this.name="Some name";
    this.price=2000;
  }
  private String name;
  private int price;

}
