package com.socket.chat.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Chat {
    @Id
    @GeneratedValue
    private Long id;

    private String writer;

    private String content;
}
