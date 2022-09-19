src/main/resources/application.properties 에서 디비 설정을 해주시면 됩니다.

전체 파일에서 아래 부분만 설정해주시면 됩니다.

spring.datasource.url=jdbc:mysql://localhost:<Port Number>/<Database Name>?allowPublicKeyRetrieval=true&useSSL=false&userUnicode=true&serverTimezone=Asia/Seoul
Example: spring.datasource.url=jdbc:mysql://localhost:3306/whale?allowPublicKeyRetrieval=true&useSSL=false&userUnicode=true&serverTimezone=Asia/Seoul


spring.datasource.username=<Mysql User Name>
spring.datasource.password=<Mysql Password>

spring.jpa.show-sql=true

그렇게 실행시키시고 http://localhost:8080으로 들어가보시면 아래처럼 뜨면 실행 성공!

<img width="938" alt="Screen Shot 2022-09-20 at 1 09 51" src="https://user-images.githubusercontent.com/95198715/191063173-48059227-a2da-49ad-b635-65e72a18ea1e.png">
