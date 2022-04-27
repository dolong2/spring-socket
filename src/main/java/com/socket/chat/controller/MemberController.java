package com.socket.chat.controller;

import com.socket.chat.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MemberController {
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("member", new Member());
        return "/socket/name";
    }
    @PostMapping("/")
    public String inputName(@ModelAttribute Member member, HttpServletResponse response){
        Cookie cookie = new Cookie("userName", member.getName());
        response.addCookie(cookie);
        return "redirect:/chat";
    }
}
