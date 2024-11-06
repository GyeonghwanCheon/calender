package com.example.calender.dto;

import lombok.Getter;

import java.time.LocalDate;


@Getter
public class CalenderRequestDto {

    private String author;

    private String contents;

    private String password;

    private LocalDate createDate;

    private LocalDate changeDate;
}
