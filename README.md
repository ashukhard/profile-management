# profile-management

This is a simple REST based microservices app for User profile management.

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