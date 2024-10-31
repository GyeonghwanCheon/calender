# calender
---

## API 명세서

#### 1. 하루 일정 조회

+ 설명 : 일정 하나를 조회합니다
+ HTTP : GET
+ URL : localhost:8080/todo/{1}?id=int
+ 상태 코드 : 200 OK
+ 에러 코드 : 404 Not Found
  ```
  {
      "message" : "Resource does not exist on server"       
  }
  ```
|Key|Value|Description|
|------|---|---|
|id|int|식별자ID|


#### 2. 전체 일정 조회

+ 설명 : 일정 전체를 조회합니다
+ HTTP : GET
+ URL : localhost:8080/todo?change_date=date&author=varchar(50)
+ 상태 코드 : 200 OK
+ 에러 코드 : 404 Not Found
  ```
  {
      "message" : "Resource does not exist on server"       
  }
  ``` 
+ Param
|Key|Value|Description|
|------|---|---|
|change_date|date|수정일|
|author|varchar(50)|작성자|


#### 3. 일정 저장

+ 설명 : 일정을 저장합니다
+ HTTP : POST
+ URL : localhost:8080/todo?id=int&author=String&contents=String&password=String&create_date=date&change_date=date
+ 상태 코드 : 200 OK
+ 오류 코드
+ 400 Red Request
```
{
   "errors": [
        {
        "param": "password",
        "value": 123,
        "error": "TypeError",
        "msg": "must be String"
        }
    ]
}
```
+ 404 Not Found
```
{
   "message" : "Resource does not exist on server"
}
```

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

#### 4. 일정 수정

+ 설명 : 일정을 수정합니다
+ HTTP : PUT
+ URL : localhost:8080/todo/{1}?author=Stirng&contents=String&password=String&change_date=date
+ 상태 코드 : 200 OK
+ 오류 코드
+ 400 Red Request
```
{
   "errors": [
        {
        "param": "password",
        "msg": "Password does not match"
        }
    ]
}
```
+ JSON
```
{
    "author" : "author",
    "contents" : "contents",
    "password" : "password",
    "change_date" : "change_date"
}
```

#### 5. 일정 삭제 

+ 설명 : 일정을 삭제합니다
+ HTTP : DELETE
+ URL : localhost:8080/todo/{1}?password=String
+ 상태 코드 : 200 OK
+ 오류 코드
+ 400 Red Request
```
{
   "errors": [
        {
        "param": "password",
        "msg": "Password does not match"
        }
    ]
}
```
+ JSON
```
{
    "password" : "password",
}
```

---

## ERD
![ERD_IMAGE](https://github.com/user-attachments/assets/19f76a94-b1ed-4fbe-91cf-c04cb7b46f38) 


---

## SQL
![SQL_IMAGE](https://github.com/user-attachments/assets/e59ade16-c821-4928-8f84-37fcd0225045)


