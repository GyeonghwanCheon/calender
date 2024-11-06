package com.example.calender.entity;

import com.example.calender.dto.CalenderRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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


        LocalDateTime dateTime = LocalDateTime.now();
        // 원하는 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 포맷 적용
        String formattedDate = dateTime.format(formatter);
        this.changeDate = formattedDate;
    }
}
