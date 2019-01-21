# profile-management

This is a simple REST based microservices app for User profile management. 
	 The admin user is able to assign 2 types of permissions to every user: 'ADMIN' and 'USER'
	 'ADMIN' - Allowed to Create, Read, Update and Delete Users
	 'USER' - Allowed to only read and delete their own profile

##Requirements
	For building and running the application you need:

	 JDK 1.8
	 Maven 3
	 MySQL

##Steps to Setup

	1. Clone the repository
		git clone https://github.com/ashukhard/profile-management.git
	
	2. Execute/Import SQL scripts for MySQL setup from ~//profile-management/src/main/resources/query.sql
	
	3. Run the app using maven
		cd profile-management
		mvn spring-boot:run

##To view Swagger 2 API docs
	Run the server and browse to localhost:8090/swagger-ui.html

##Endpoints details
Following are the endpoints in brief:
	
	1.POST User Login : http://localhost:8090/user/login
	2.GET a User: http://localhost:8090/user/{id}
	3.POST Create User: http://localhost:8090/user
	4.PUT Update User: http://localhost:8090/user/{id}
	5.DELETE User: http://localhost:8090/user/{id}
	6.GET all Users: http://localhost:8090/users

##Detail endpoint execution
All the endpoints other than POST User login are protected. General flow is to get authenticated first with login endpoint and
then use the JWT token generated for other endpoints. SQL scripts creates an admin with username: admin and password: password .

###1.POST User Login
	POST http://localhost:8090/user/login
	Content-Type:application/json
	
	Request Body:
	{
    	"username": "testUser2",
    	"password": "test112"
	}
	
	Response Body:
	{
		"token":"eyJhbGciOxxxx9NiJ9.eyJzdWI9wZXMiOiJST0xFXxxxxxDA1ODE5NX0.hZfGwkcUwdcN9JxxxxxwNcyHaPk"
	}

###2.GET a User
	GET http://localhost:8090/user/1
	Content-Type:application/json
	Authorization:Bearer eyJhbGciOxxxx9NiJ9.eyJzdWI9wZXMiOiJST0xFXxxxxxDA1ODE5NX0.hZfGwkcUwdcN9JxxxxxwNcyHaPk
	
	Request Body:
	empty
	
	Response Body:
	{
	    "id": 1,
	    "username": "admin",
	    "firstname": "testFN",
	    "lastname": "testLN",
	    "dateOfBirth": "15-Feb-1995",
	    "roles": [
	        {
	            "id": 1,
	            "name": "ADMIN"
	        }
	    ],
	    "address": [
	        {
	            "id": 2,
	            "name": "4, Corell St., Melbourne",
	            "type": "HOME"
	        },
	        {
	            "id": 1,
	            "name": "ay@gmail.com",
	            "type": "EMAIL"
	        }
	    ]
	}
	
###3.POST Create User
The roles and address-type can be added, refer to possible options in the end.

	POST http://localhost:8090/user
	Content-Type:application/json
	Authorization:Bearer eyJhbGciOxxxx9NiJ9.eyJzdWI9wZXMiOiJST0xFXxxxxxDA1ODE5NX0.hZfGwkcUwdcN9JxxxxxwNcyHaPk
	
	Request Body:
	{
	    "id": null,
	    "username": "testUser2",
	    "firstname": "testU2FN",
	    "lastname": "testU2LN",
	    "dateOfBirth": "01-JAN-1999",
	    "password": "test123",
	    "roles": [
	        {
	            "id": 2,
	            "name": "USER"
	        }
	    ],
	    "address": [
	        {
	            "id": null,
	            "name": "ay2@gmail.com",
	            "type": "EMAIL"
	        },
	        {
	            "id": null,
	            "name": "42, Corell St., Melbourne",
	            "type": "HOME"
	        }
	    ]
	}
	
	Response Body:
	"OK"
Possible ROLES are:
{
    "id": 1,
    "name": "ADMIN"
}
or/and
{
    "id": 2,
    "name": "USER"
} 
Possible ADDRESS types are:
HOME, OFFICE, EMAIL

###4.PUT Update User
The roles and address-type can be updated or new once can be added, refer to possible options in the end.

	PUT http://localhost:8090/user/2
	Content-Type:application/json
	Authorization:Bearer eyJhbGciOxxxx9NiJ9.eyJzdWI9wZXMiOiJST0xFXxxxxxDA1ODE5NX0.hZfGwkcUwdcN9JxxxxxwNcyHaPk
	
	Request Body:
	{
	    "id": 2,
	    "username": "testUser2",
	    "firstname": "updatedtestU2FN",
	    "lastname": "updatedtestU2LN",
	    "dateOfBirth": "17-FEB-1989",
	    "roles": [
	        {
	            "id": 1,
	            "name": "ADMIN"
	        }
	    ],
	    "address": [
	        {
	            "id": 15,
	            "name": "ay2.l65n@gmail.com",
	            "type": "EMAIL"
	        },
	        {
	            "id": 16,
	            "name": "42, Corell St., Melbourne, VIC, 3006",
	            "type": "HOME"
	        },
	        {
	            "id": null,
	            "name": "101, Collins St., Melbourne, VIC, 3000",
	            "type": "OFFICE"
	        }
	    ]
	}
	
	Response Body:
	"OK"

Possible ROLES are:
{
    "id": 1,
    "name": "ADMIN"
}
or/and
{
    "id": 2,
    "name": "USER"
} 

Possible ADDRESS types are:
HOME, OFFICE, EMAIL

###5.DELETE User
	DELETE http://localhost:8090/user/2
	Content-Type:application/json
	Authorization:Bearer eyJhbGciOxxxx9NiJ9.eyJzdWI9wZXMiOiJST0xFXxxxxxDA1ODE5NX0.hZfGwkcUwdcN9JxxxxxwNcyHaPk
	
	Request Body:
	empty
	
	Response Body:
	"OK"

###6.GET all Users
	GET http://localhost:8090/users
	Content-Type:application/json
	Authorization:Bearer eyJhbGciOxxxx9NiJ9.eyJzdWI9wZXMiOiJST0xFXxxxxxDA1ODE5NX0.hZfGwkcUwdcN9JxxxxxwNcyHaPk
	
	Request Body:
	empty
	
	Response Body:
	[{
	    "id": 1,
	    "username": "admin",
	    "firstname": "testFN",
	    "lastname": "testLN",
	    "dateOfBirth": "15-Feb-1995",
	    "roles": [
	        {
	            "id": 1,
	            "name": "ADMIN"
	        }
	    ],
	    "address": [
	        {
	            "id": 2,
	            "name": "4, Corell St., Melbourne",
	            "type": "HOME"
	        },
	        {
	            "id": 1,
	            "name": "ay@gmail.com",
	            "type": "EMAIL"
	        }
	    ]
	}]
	
##Efforts and challenges
It took over three days, around 15-18 hours to build the app. I have used spring security before but this was the firstime I 
was using JWT based spring security so took some time to understand and integrate it.

Thanks and all the suggestions for improvements are welcomed.
	
