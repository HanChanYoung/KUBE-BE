
FROM openjdk:11-jre

# app 디렉토리 생성
RUN mkdir -p /app

#Docker 이미지 내부에서 RUN, CMD, ENTRYPOINT의 명령이 실행될 디렉터리를 설정
WORKDIR /app

# 현재 디렉터리에 있는 파일들을 이미지 내부 /app 디렉터리에 추가함
ADD . /app/

COPY build/libs/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java"]

CMD ["-jar","app.jar"]
