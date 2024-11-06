package com.example.calender.controller;


import com.example.calender.dto.CalenderRequestDto;
import com.example.calender.dto.CalenderResponseDto;
import com.example.calender.entity.Calender;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/todo")
public class CalenderController {
    private final Map<Long, Calender> calenderList = new HashMap<>();

    // 일정 생성
    @PostMapping
    public ResponseEntity<CalenderResponseDto> createCalender(@RequestBody CalenderRequestDto requestDto) {
        // 식별자가 1씩 증가 하도록 만듦
        Long calenderId = calenderList.isEmpty() ? 1 : Collections.max(calenderList.keySet()) + 1;

        LocalDateTime dateTime = LocalDateTime.now();

        // 원하는 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 포맷 적용
        String formattedDate = dateTime.format(formatter);


        //요청 받은 데이터로 Calender 객체 생성
        Calender calender = new Calender(calenderId, requestDto.getAuthor(), requestDto.getContents(),
                requestDto.getPassword(), formattedDate, formattedDate);

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

        // 수정일 날짜 기준 내림차순
        responseList.sort(Comparator.comparing(CalenderResponseDto::getChangeDate).reversed());

        return new ResponseEntity<>(responseList,HttpStatus.OK);

    }


    // 일정 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity <CalenderResponseDto> findCalenderById(@PathVariable Long id) {

        Calender calender = calenderList.get(id);

        // 일정이 없는 지 확인
        if(calender == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CalenderResponseDto(calender),HttpStatus.OK);
    }

    // 일정 수정
    @PatchMapping("/{id}")
    public ResponseEntity<CalenderResponseDto> updateTitle(
            @PathVariable Long id,
            @RequestBody CalenderRequestDto dto
    ) {
        Calender calender = calenderList.get(id);

        //NPE 방지
        if(calender == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // 작성자와 할 일 수정
        if(dto.getAuthor() == null || dto.getContents() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //비밀번호가 같은 지 확인
        if(!Objects.equals(calender.getPassword(), dto.getPassword())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }



        calender.update(dto);

        return new ResponseEntity<>(new CalenderResponseDto(calender), HttpStatus.OK);
    }


    // 식별자 단건 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalender(
            @PathVariable Long id,
            @RequestBody CalenderRequestDto dto) {

        Calender calender = calenderList.get(id);

        //calenderlist의 key값을 id를 포함하고 있다면 그리고 요청받은 패스워드 값이 같다면.
        if (calenderList.containsKey(id)) {
            //비밀번호가 맞는 지 확인하고 맞으면 삭제.
            if (Objects.equals(calender.getPassword(), dto.getPassword())) {

                calenderList.remove(id);

                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
