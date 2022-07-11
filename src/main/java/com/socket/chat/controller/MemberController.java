package com.socket.chat.controller;

import com.socket.chat.domain.Member;
import com.socket.chat.error.exception.MemberNameEmptyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MemberController {
    @GetMapping("/")
    public String name(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null){
            session.invalidate();
        }
        model.addAttribute("member", new Member());
        return "/socket/name";
    }
    @PostMapping("/")
    public String inputName(@ModelAttribute Member member, HttpServletRequest request){
        if(member.getName()==""){
            throw new MemberNameEmptyException();
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", member);
        return "redirect:/chat";
    }
}
