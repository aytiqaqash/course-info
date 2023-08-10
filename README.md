# Requirements
 
- Java version is: java 17.0.7 2023-04-18 LTS
- Maven version is: Apache Maven 3.8.1

# How to create jar file from this repo?

1. Clone the project 
2. cd to the project directory 
3. execute: ``` java -jar course-info-server/target/course-info-server-1.0-SNAPSHOT.jar ```

## In case you want to create new Jar file
 - Execute before step 3 mentioned above: ``` mvn clean verify ```

**FYI**: Project retrieves courses from pluralsight of the author 
**@Sander_Mak**

### What does this app?

- Retrieve courses from Pluralsight
- Save Courses to H2 database
- Return back JSON from ``` GET /courses ```
- Add notes to the course based on id ``` POST /courses/{id}/notes ```

curl command to send post request:
```
curl -X POST -H "Content-Type: text/plain" --data "Your note is here..." http://localhost:8080/courses/1c6a8467-04a1-41fb-95b7-08e8938c4213/notes
```