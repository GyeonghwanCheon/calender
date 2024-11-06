package com.example.calender.entity;

import com.example.calender.dto.CalenderRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
public class Calender {

    private Long id; // 식별자 ID

    private String author; // 작성자

    private String contents; // 할 일

    private String password; // 비밀번호

    private String createDate; // 작성일

    private String changeDate; // 수정일


    public void update(CalenderRequestDto dto) {
        this.author = dto.getAuthor();
        this.contents = dto.getContents();
        this.password = dto.getPassword();
    }
}
