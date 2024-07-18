FROM openjdk:8-jdk-alpine

LABEL author="RENALDI DWI IRAWAN" website="reyxsfact.vercel.app"

WORKDIR /app

COPY base_project_service/target/*.jar /app

EXPOSE 8088

ENTRYPOINT ["java","-jar"]
CMD ["base_project_service-1.0-SNAPSHOT.jar"]

VOLUME ./volumeKampus


