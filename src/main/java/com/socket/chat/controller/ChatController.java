package com.socket.chat.controller;

import com.socket.chat.Entity.Chat;
import com.socket.chat.domain.Member;
import com.socket.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/chat")
    public String chat(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("user");
        if(member == null){
            return "redirect:/";
        }
        List<Chat> allChat = chatService.getAllChat();
        System.out.println("allChat = " + allChat.toString());
        log.info("@ChatController");
        model.addAttribute("user", member);
        model.addAttribute("chats", allChat);
        return "socket/chat";
    }
}
