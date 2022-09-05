FROM maven as build

WORKDIR /app

COPY pom.xml pom.xml

RUN mvn dependency:go-offline

COPY . .

RUN mvn package

FROM amazoncorretto:11-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar spring.jar

CMD ["java","-jar","spring.jar"]
