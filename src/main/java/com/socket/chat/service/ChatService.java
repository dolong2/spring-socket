package com.socket.chat.service;

import com.socket.chat.Entity.Chat;
import com.socket.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    public void writeChat(String writer, String content){
        Chat chat = Chat.builder()
                .writer(writer)
                .content(content)
                .build();
        chatRepository.save(chat);
    }

    public List<Chat> getAllChat(){
        return chatRepository.findAll();
    }
}
