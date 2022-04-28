package com.socket.chat.controller;

import com.socket.chat.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class ChatController {
    @GetMapping("/chat")
    public String chat(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("user");
        if(member == null){
            return "redirect:/";
        }
        log.info("@ChatController");
        model.addAttribute("user", member);
        return "socket/chat";
    }
}
