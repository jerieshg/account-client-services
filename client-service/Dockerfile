FROM openjdk:21
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk
ENV PATH=$PATH:$JAVA_HOME/bin
COPY build/libs/client-service.jar /app/application.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/application.jar"]
