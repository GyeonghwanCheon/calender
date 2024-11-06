package com.example.calender.controller;


import com.example.calender.dto.CalenderRequsetDto;
import com.example.calender.dto.CalenderResponseDto;
import com.example.calender.entity.Calender;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/todo")
public class CalenderController {
    private final Map<Long, Calender> calenderList = new HashMap<>();

    @PostMapping
    public ResponseEntity<CalenderResponseDto> createCalender(@RequestBody CalenderRequsetDto requsetDto) {
        // 식별자가 1씩 증가 하도록 만듦
        Long calenderId = calenderList.isEmpty() ? 1 : Collections.max(calenderList.keySet()) + 1;

        //요청 받은 데이터로 Calender 객체 생성
        Calender calender = new Calender(calenderId, requsetDto.getAuthor(), requsetDto.getContents(),
                requsetDto.getPassword(), requsetDto.getCreateDate(), requsetDto.getCreateDate());

        // Inmemory DB에 Memo 저장
        calenderList.put(calenderId, calender);

        return new ResponseEntity<>(new CalenderResponseDto(calender), HttpStatus.CREATED);
    }


}
