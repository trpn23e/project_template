= Project Template for Intelli J =

Intelli J 2017.1.6, JDK 1.8.0.161 64bit, Spring Boot 2.0.1 Release, Spring 5.0.5 Release,
JMS Apache Active MQ, JPA, QueryDSL, React, Element UI

•Make root directory's name would be 'home' or possible to change anything you want but recommend to check realted configurations and settings

    
    템플릿 구축 환경 : Spring Boot 2.0.1 Release, JDK 1.8.0.161, Apache ActiveMQ(JMS),
                      Gradle 4.8.1, Mybatis 3, JPA, Query DSL 4.2.1,
                      H2 Db(Embedded Database), JSP, React, Element UI React,
                      WebPack4, Babel 7
    
    설치방법 : 
     1.아무 드라이브에 PROJECT.zip을 그대로 압축해제, IntelliJ로 디렉토리 오픈
     2.Run/Debug Configuration에서 Gradle 추가 
       (
         Gradle project : home:project:subprj
         Tasks : bootRun
         Script parameters : --stacktrace <--- 해도되고 안해도됨
    
     BackEnd 접속 URL : http://localhost:50000
     FrontEnd 접속 URL : http://localhost:3000
    
     (C:\PROJECT\home\project\subprj\frontend\my-app 경로의 CMD창에서 
       npm install 후 (이미 설치된 node_module이 있기때문에 안해줘도 되지만 구동시
       모듈을 못찾아서 오류 발생하는 경우 한번 돌려준다)
       npm run dev, npm start등으로 구동시킴
      *Node JS 설치되있어야 함
    
     3. 필요없는 모듈등은 적당히 삭제, 변경해서 사용하면 됨
        ex) frontend측 필요없을 경우 C:\PROJECT\home\project\subprj\frontend 삭제
