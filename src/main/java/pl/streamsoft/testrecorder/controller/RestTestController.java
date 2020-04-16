package pl.streamsoft.testrecorder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/api")
public class RestTestController {

    @GetMapping
    public String callMathodGet(String name) {
        return "Test";
    }

}
