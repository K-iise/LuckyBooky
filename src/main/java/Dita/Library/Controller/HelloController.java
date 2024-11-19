package Dita.Library.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("helloss")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
}
