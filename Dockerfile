FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/Midterm_Project_CEN4802C-1.0-SNAPSHOT.jar /app/midterm_project.jar

ENTRYPOINT ["java", "-jar", "/app/midterm_project.jar"]
