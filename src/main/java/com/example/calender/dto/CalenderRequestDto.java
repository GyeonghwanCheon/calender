package com.example.calender.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
public class CalenderRequestDto {

    private String author;

    private String contents;

    private String password;

    private String createDate;

    private String changeDate;
}
