FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN javac *.java

ENTRYPOINT ["java", "WebsiteMonitorApp"]