package com.example.calender.controller;


import com.example.calender.dto.CalenderRequsetDto;
import com.example.calender.dto.CalenderResponseDto;
import com.example.calender.entity.Calender;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/todo")
public class CalenderController {
    private final Map<Long, Calender> calenderList = new HashMap<>();

    // 일정 생성
    @PostMapping
    public ResponseEntity<CalenderResponseDto> createCalender(@RequestBody CalenderRequsetDto requsetDto) {
        // 식별자가 1씩 증가 하도록 만듦
        Long calenderId = calenderList.isEmpty() ? 1 : Collections.max(calenderList.keySet()) + 1;

        //요청 받은 데이터로 Calender 객체 생성
        Calender calender = new Calender(calenderId, requsetDto.getAuthor(), requsetDto.getContents(),
                requsetDto.getPassword(), requsetDto.getCreateDate(), requsetDto.getChangeDate());

        // Inmemory DB에 Memo 저장
        calenderList.put(calenderId, calender);

        return new ResponseEntity<>(new CalenderResponseDto(calender), HttpStatus.CREATED);
    }

    // 일정 전체 조회
    @GetMapping
    public ResponseEntity<List<CalenderResponseDto>> findAllCalender() {
        //init List
        List<CalenderResponseDto> responseList = new ArrayList<>();

        //HashMap<Calender> -> List<CalenderResponseDto>
        for(Calender calender : calenderList.values()) {
            CalenderResponseDto responseDto = new CalenderResponseDto(calender);
            responseList.add(responseDto);
        }

        return new ResponseEntity<>(responseList,HttpStatus.OK);

    }

}
