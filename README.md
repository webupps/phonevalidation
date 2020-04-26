# phonevalidation
Demo

Direction 

Add Database Information in application.properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

Install the database from database folder to your env

Use postman to test
Create
POST request: http://localhost:8080/api/phone/add 
Headers: Content-Type : application/json
Body: raw JSON
{
	"number": "702 419 0447"
}

Read
Get request: http://localhost:8080/api/phone/get/5

Update
POST request: http://localhost:8080/api/phone/update
{
	 "id": 5,
    "number": "7034190626"
}

Delete
Get request: http://localhost:8080/api/phone/del/3

Pagination
Get request: http://localhost:8080/api/phone/getall?pageNo=1&pageSize=2&sortBy=id
