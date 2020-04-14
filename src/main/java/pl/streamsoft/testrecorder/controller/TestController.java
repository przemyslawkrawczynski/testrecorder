package pl.streamsoft.testrecorder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.streamsoft.testrecorder.pub.dto.ClientDto;

@Controller
@RequestMapping("/app")
public class TestController {

    @GetMapping("test")
    public String hello(Model model) {
        ClientDto kowalski = new ClientDto(1L, "Jan Kowalski", "test@test.com", 86081326548L, 125225225L, null);
        model.addAttribute("client", kowalski);
        return "hello";
    }

    @PostMapping("/user/add")
    public String helloController(@ModelAttribute ClientDto client, Model model) {
        System.out.println(client.toString());
        model.addAttribute("clientDto", client);
        return "decisionList";
    }

}
