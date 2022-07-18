package com.socket.chat.service.impl;

import com.socket.chat.Entity.Chat;
import com.socket.chat.repository.ChatRepository;
import com.socket.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;

    @Override
    @Transactional
    public void writeChat(String writer, String content){
        Chat chat = Chat.builder()
                .writer(writer)
                .content(content)
                .build();
        chatRepository.save(chat);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Chat> getAllChat(){
        return chatRepository.findAll();
    }
}
