package springboot.techboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.techboot.beans.TestA;
import springboot.techboot.beans.TestB;

@Controller
public class FirstController {
 @Autowired //Из контекста подтягивает экземпляр объекта
 private TestA testA;

 @Autowired
 @Qualifier("Takha")
 private TestB testB;
  @GetMapping(value="/test-a")
  public String testA(Model model){
    System.out.println(testA.getName()+" "+testA.getPrice());
    model.addAttribute("testA",testA);
    System.out.println(testB.getCode()+" "+testB.getVolume());
    return "test";
  }

}
