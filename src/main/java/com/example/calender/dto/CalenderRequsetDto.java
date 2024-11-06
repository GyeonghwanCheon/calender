package com.example.calender.dto;

import lombok.Getter;

@Getter
public class CalenderRequsetDto {
    private String author;
    private String contents;
    private String password;
    private String createDate;
    private String changeDate;
}
