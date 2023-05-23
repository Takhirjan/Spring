package springboot.techboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.techboot.beans.TestA;

@Controller
public class SecondController {
@Autowired
private TestA testA;
  @GetMapping(value = "/test-b")
  public String testB(Model model){
    model.addAttribute("testA",testA);
    return "test";
  }
  @GetMapping(value = "/change-test-b")
  public String changeTestB(){
  testA.setName("Takha");
  testA.setPrice(777);
    return "redirect:/test-b";
  }
}
