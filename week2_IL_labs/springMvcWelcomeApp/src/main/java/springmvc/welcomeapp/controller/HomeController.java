import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome() {
        return "welcome"; // This is the logical view name
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String greet(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting"; // This is the logical view name
    }
}
