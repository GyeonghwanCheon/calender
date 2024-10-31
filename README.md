# calender

#### 1. 하루 일정 조회

+ 설명 : 일정 하나를 조회합니다
+ HTTP : GET
+ URL : localhost:8080/todo/{1}
+ 상태 코드 : 200 OK


#### 2. 전체 일정 조회

+ 설명 : 일정 전체를 조회합니다
+ HTTP : GET
+ URL : localhost:8080/todo
+ 상태 코드 : 200 OK

|Key|Value|Description|
|------|---|---|
|change_date|date|수정일|
|author|varchar(50)|작성자|


#### 3. 일정 저장

+ 설명 : 일정을 저장합니다
+ HTTP : POST
+ URL : localhost:8080/todo
+ 상태 코드 : 200 OK
+ JSON
```
{
    "id" : "id",
    "author" : "author",
    "contents" : "contents",
    "password" : "password",
    "create_date" : "YYYY-MM-DD",
    "change_date" : "2024-10-31"

}
```
  
