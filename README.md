# calender
---

## API 명세서

#### 1. 하루 일정 조회

+ 설명 : 일정 하나를 조회합니다
+ HTTP : GET
+ URL : localhost:8080/todo/{todoId}
+ 상태 코드 : 200 OK
  ```
  {
      "author" : "String",
      "contents" : "String"        
  }
  ```
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
+ URL : localhost:8080/todo?change_date={date}&author={author}
+ 상태 코드 : 200 OK
  ```
  [
    {
      "author" : "String",
      "contents" : "String"        
    },
    {
      "author" : "String",
      "contents" : "String"
    }
  ]
  ```
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
+ URL : localhost:8080/todo
+ RequestBody
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
+ 상태 코드 : 200 OK
  ```
  {
      "id" : "id",
      "author" : "String",
      "contents" : "String",
      "password" : "password"       
  }
  ```
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


#### 4. 일정 수정

+ 설명 : 일정을 수정합니다
+ HTTP : PUT
+ URL : localhost:8080/todo/{todoId}
+ RequestBody
```
{
    "author" : "author",
    "contents" : "contents",
    "password" : "password",
    "change_date" : "change_date"
}
```
+ 상태 코드 : 200 OK
```
{
    "author" : "author",
    "contents" : "contents",
    "password" : "password"
}
```
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

#### 5. 일정 삭제 

+ 설명 : 일정을 삭제합니다
+ HTTP : DELETE
+ URL : localhost:8080/todo/{todoId}
+ RequestBody
```
{
    "password" : "password",
}
```
+ 상태 코드 : 200 OK
```
{
    "password" : "password",
}
```
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

---

## ERD
![ERD_IMAGE](https://github.com/user-attachments/assets/19f76a94-b1ed-4fbe-91cf-c04cb7b46f38) 


---

## SQL
![SQL_IMAGE](https://github.com/user-attachments/assets/e59ade16-c821-4928-8f84-37fcd0225045)


