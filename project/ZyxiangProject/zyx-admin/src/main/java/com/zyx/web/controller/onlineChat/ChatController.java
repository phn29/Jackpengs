package com.zyx.web.controller.onlineChat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    @GetMapping("/onlineChat")
    public String chat(){
        return "onlineChat/main";
    }
}
