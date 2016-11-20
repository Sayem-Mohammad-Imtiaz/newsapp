# README #

##Technology stack application using ##
1. Spring Boot has the charge of managing server side code
2. In memory SQL database HSQLDB has been used for repository purpose. Data will not be persisted. So
you will lost data every time you restart servlet conatiner.
3. Template engine Thyemleaf used for HTML rendering
4. For UI design, Bootstrap and Font-awesome has been used
 
## Deploy application in a servlet container ##
1. Clone newsapp project in your machine
2. Go to root directory of the project
3. Open shell and type following command: ./mvnw clean package
4. Go to target directory and copy newsapp.war
5. Paste it to any servlet container. For Tomcat, paste it in webapps folder and start tomcat
6. You should be able to access application in following URL: http://host:port/newsapp/news 
7. Landing page (http://host:port/newsapp/news) shows a list of all the story so far created
8. To add a story, click Add Story menu from top nav bar or paste this URL: http://host:port/newsapp/news/addStory

## Run application with embedded tomcat ##
1. Clone newsapp project in your machine
2. Go to root directory of the project
3. Open shell and type following command: ./mvnw clean spring-boot:run
4. Application will be deployed at default port 8080 (If available). 
5. If port 8080 is not available, you can run with port of your choice with command line arguments. 
For example, to run in port 9070, type: ./mvnw clean spring-boot:run -Drun.arguments="--server.port=9070"
