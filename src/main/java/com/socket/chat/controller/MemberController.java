package com.socket.chat.controller;

import com.socket.chat.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MemberController {
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("member", new Member());
        return "/socket/name";
    }
    @PostMapping("/")
    public String inputName(@ModelAttribute Member member, RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("memberName", member.getName());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/chat";
    }
}
