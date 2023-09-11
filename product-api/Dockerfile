FROM openjdk:17

RUN mkdir -p deploy

## 이동
WORKDIR /deploy
# 복사 명령어
COPY ./build/libs/product-api-0.0.1-SNAPSHOT.jar product.jar

# 실행할 명령어
ENTRYPOINT ["java", "-jar","/deploy/product.jar"]