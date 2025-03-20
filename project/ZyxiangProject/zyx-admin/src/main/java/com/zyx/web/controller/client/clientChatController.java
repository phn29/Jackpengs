package com.zyx.web.controller.client;

import com.zyx.common.core.domain.entity.SysChat;
import com.zyx.system.domain.ResponseData;
import com.zyx.system.service.ISysChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/client")
public class clientChatController {
    @Autowired
    private ISysChatService sysChatService;

    //跳转到聊天页面
    @GetMapping("/chat")
    public String Chat(){
        return "client/chat/chat";
    }

    //咨询预约
    @PostMapping("/chat/insert")
    @ResponseBody
    public ResponseData insertChar(SysChat sysChat){
        String expertId = sysChat.getExpertId();
        String stuId = sysChat.getStuId();
        SysChat sysChat1 = new SysChat();
        sysChat1.setStuId(stuId);
        sysChat1.setExpertId(expertId);
        List<SysChat> sysChats = sysChatService.selectSysChatList(sysChat1);
        if(sysChats.size() != 0){
            return ResponseData.fail();
        }
        sysChatService.insertSysChat(sysChat);
        return ResponseData.ok("");
    }
}
