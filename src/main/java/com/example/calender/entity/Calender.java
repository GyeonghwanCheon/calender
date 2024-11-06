package com.example.calender.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;


@AllArgsConstructor
@Getter
public class Calender {

    private Long id; // 식별자 ID

    private String author; // 작성자

    private String contents; // 할 일

    private String password; // 비밀번호

    private LocalDate createDate; // 작성일

    private LocalDate changeDate; // 수정일

}
