src/main/resources/application.properties 에서 디비 설정을 해주시면 됩니다.

전체 파일에서 아래 부분만 설정해주시면 됩니다.

spring.datasource.url=jdbc:mysql://localhost:<Port Number>/<Database Name>?allowPublicKeyRetrieval=true&useSSL=false&userUnicode=true&serverTimezone=Asia/Seoul
Example: spring.datasource.url=jdbc:mysql://localhost:3306/whale?allowPublicKeyRetrieval=true&useSSL=false&userUnicode=true&serverTimezone=Asia/Seoul


spring.datasource.username=<Mysql User Name>
spring.datasource.password=<Mysql Password>

spring.jpa.show-sql=true

그렇게 실행시키시고 http://localhost:8080으로 들어가보시면 아래처럼 뜨면 실행 성공!

<img width="938" alt="Screen Shot 2022-09-20 at 1 09 51" src="https://user-images.githubusercontent.com/95198715/191063173-48059227-a2da-49ad-b635-65e72a18ea1e.png">

## 도커로 로컬에서 프로젝트 실행하기
1. 루트 path에서 `docker-compose up -d` 명령어를 실행한다.
   - 다만, docker 호스트가 실행되고 있어야한다. (맥이나 윈도우 사용자면 docker-desktop 설치하여 실행)
2. 기다리고, 브라우저에서 `localhost:8080`을 요청하면 서버가 응답할것.

## 도커로 프로젝트 실행할 떄의 장점
- 해당 코프링 프로젝트는 java 17 버전이 컴퓨터에 설치되어있어야한다. 나는 자바 버전이 11밖에 없어서 설치하기 귀찮아서 도커를 이용.
- 스프링 서버가 실행되려면 mysql도 실행중이어야한다. 즉, 내 컴퓨터에 mysql을 설치하여야하는데, docker-compose에서 mysql 컨테이너를 정의하여 사용하면, 실제로 내 컴퓨터에 mysql설치할 필요 없음.
- 프로젝트 실행을 위한 여러 피로도를 낮춰줌. 추후에 Dockerfile을 이용하여 배포하여도 좋을듯.