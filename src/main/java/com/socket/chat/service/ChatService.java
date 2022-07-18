package com.socket.chat.service;

import com.socket.chat.Entity.Chat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatService {
    void writeChat(String writer, String content);

    List<Chat> getAllChat();
}
