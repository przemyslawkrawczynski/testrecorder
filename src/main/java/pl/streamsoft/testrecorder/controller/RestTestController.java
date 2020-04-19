package pl.streamsoft.testrecorder.controller;

import org.springframework.web.bind.annotation.*;
import pl.streamsoft.testrecorder.ExampleDto;

@RestController
@RequestMapping("/app/api")
public class RestTestController {

    @GetMapping
    public String callMathodGet(@RequestBody ExampleDto first, @RequestParam Integer second) {
        return "Test";
    }

}
