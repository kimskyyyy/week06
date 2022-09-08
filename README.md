Week06 Mini Project Team09
=============      
Frontend GitHub: https://github.com/sooo0y/Daily_Life     
Backend GitHub: https://github.com/kimskyyyy/week06   

:v: 프로젝트 소개
-------------   
<img src="https://user-images.githubusercontent.com/110077343/189123103-ea8e89b2-62e5-4be8-8f3a-f97e859a69e3.png"></img><br/>
소소한 일상의 지금을 공유해 보세요!   
사진 찍을 때 V하는 것처럼, 자신의 지금 이 순간을 공유하고 자유롭게 소통하는 일상 공유 플랫폼       

:date: 제작 기간
-------------   
2022.09.02 ~ 2022.09.08(7일)   

:family: 팀 멤버 소개 & 담당 기능 구현
-------------   
|이름|포지션|담당 기능 구현|
|------|---|---|
|김소연|Frontend|모든 기능 구현(메인페이지, 회원가입, 로그인, 게시글CRUD, 댓글CRUD, 마이페이지 조회 등)|
|김규수|Backend|회원가입, 로그인(Spring security, JWT), 댓글CRUD, ERD 관리|
|김하늘|Backend|이미지 업로드(s3), 게시글CRUD, 서버 배포, front-back 연동, GitHub 관리|

:computer: 프로젝트 주요 기능
-------------  
1) 메인페이지: 카드형으로 전체 게시글 조회   
<img src="https://user-images.githubusercontent.com/110077343/189138295-4cb8995b-fc9b-48b9-b790-2426ce1b59b6.png"></img><br/>       
2) 회원가입: id 중복 확인, password 일치 확인, 유효성 검사(id: 숫자0-9, 영문자 대소문자 포함 4-12자, pw: 숫자0-9, 영문자 대소문자 포함 4-32자)   
<img src="https://user-images.githubusercontent.com/110077343/189138219-63eeeb33-4cc2-405e-a0b6-f82f4d1041ec.png"></img><br/>     
3) 로그인 페이지: id, password로 로그인, 로그인 성공시 HTTP Headers Response를 통해 Authorization Token, Refresh Token 발급   
 <img src="https://user-images.githubusercontent.com/110077343/189137589-2d3356d8-3e80-418e-8aec-c8677a10df34.png"></img><br/>
4) 게시글 작성 페이지: 게시글 작성 및 이미지 업로드   
<img src="https://user-images.githubusercontent.com/110077343/189138503-d3108cde-b75c-4d42-896d-35fcdfc2aa74.png"></img><br/>     
5) 게시글 조회 및 댓글 페이지: 게시글 조회 및 댓글 생성, 조회, 수정, 삭제    
<img src="https://user-images.githubusercontent.com/110077343/189138612-ee6423c4-8d86-4b9a-b20e-4b51f5bd734e.png"></img><br/>       
6) 게시글 수정 페이지: 게시글 수정    
<img src="https://user-images.githubusercontent.com/110077343/189138869-00e25720-9987-4164-bd43-2ee2842d93cb.png"></img><br/>     
7) 마이페이지: 내가 쓴 글 조회, 수정, 삭제   
<img src="https://user-images.githubusercontent.com/110077343/189138735-332f907c-5009-4ac3-83cb-12424051c345.png"></img><br/>     

:movie_camera: 시연 영상
-------------  
<iframe width="951" height="535" src="https://www.youtube.com/embed/u03fdC7WDBY" title="Daily_Life" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe> 
[![Video Label](Http://img.youtube.com.vi/u03fdC7WDBY.0.jpg)](https://www.youtube.com/embed/u03fdC7WDBY)

:green_book: 와이어프레임
------------- 
<img src="https://user-images.githubusercontent.com/110077343/189107732-e7c70398-c4d2-4e80-8ea0-9f261afbad0f.png"></img><br/>
<img src="https://user-images.githubusercontent.com/110077343/189108012-b0f5330f-2f1b-4c2b-8cd8-a4b25f9602dd.png"></img><br/>


:blue_book: ERD
-------------
<img src="https://user-images.githubusercontent.com/110077343/189080595-4f655837-5f4c-45c3-9246-9b32bd0e67c4.png"></img><br/>


:orange_book: API
------------- 
노션: https://www.notion.so/9-SA-0a09a8b578a54242b56f371e4986326c

:construction_worker: 기술 스택 & Tools
------------- 
공통   
<img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white">
<img src="https://img.shields.io/badge/Google Sheets-34A853?style=for-the-badge&logo=Google Sheets&logoColor=white">
<img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white">
<img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white">
<img src="https://img.shields.io/badge/Ubuntu-E95420?style=for-the-badge&logo=Ubuntu&logoColor=white">

Frontend    
<img src="https://img.shields.io/badge/CSS Modules-000000?style=for-the-badge&logo=CSS Modules&logoColor=white">
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white">
<img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=React&logoColor=white">
<img src="https://img.shields.io/badge/Redux-764ABC?style=for-the-badge&logo=Redux&logoColor=white">
<img src="https://img.shields.io/badge/Axios-5A29E4?style=for-the-badge&logo=Axios&logoColor=white">

Backend   
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white">
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
<img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=Spring Security&logoColor=white">   
<img src="https://img.shields.io/badge/JSON Web Tokens-000000?style=for-the-badge&logo=JSON Web Tokens&logoColor=white">
<img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=Gradle&logoColor=white"> 
<img src="https://img.shields.io/badge/IntelliJ IDEA-000000?style=for-the-badge&logo=IntelliJ IDEA&logoColor=white"> 
<img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white"> 
<img src="https://img.shields.io/badge/Amazon S3-569A31?style=for-the-badge&logo=Amazon S3&logoColor=white"> 
<img src="https://img.shields.io/badge/Amazon EC2-FF9900?style=for-the-badge&logo=Amazon EC2&logoColor=white"> 
<img src="https://img.shields.io/badge/Sourcetree-0052CC?style=for-the-badge&logo=Sourcetree&logoColor=white">    

:rage: Trouble Shooting
------------- 
1) 프론트-백엔드 연결 후 회원가입 안됨 -> 사전 협의된 API가 Backend에서 수정이 있었는데 반영을 안해서 발생했고 API의 중요성을 알게됨

2) local에서 테스트용으로 사용하던 h2-DB Console이, server 테스트에서는 console이 안뜨고 에러 페이지 -> 배포 환경에서 사용하려면 properties에 h2웹 허용 설정 추가

3) 헤더에 토큰이 안보여지는 문제 -> WebConfig에 exposeHeaders 설정 추가

4) backend에서는 정상 작동 하지만 프론트에서 게시글 수정, 삭제 시 CORS 관련 403 에러 -> WebConfig에 설정이 잘되어있었는데 에러가 발생했고 webSecurityConfig 쪽도 수정이 필요하다는 것을 알게됨 PreFlight가 토큰(권한) 없이 이용 가능하게끔 설정 함

5) 헤더에 토큰이 요청되지 않는 사항 발생 -> Service에 Refresh-Token을 헤더에 보내는 과정에서 Refresh-Token에 대한 명칭 통일(refreshtoken)

6) 이미지 업로드와 게시글 추가를 별도의 API로 사용하다보니, 이미지를 우선적으로 업로드하여 url을 받아오고, 그 url을 다시 보내야 하는 번거로움이 있었음 -> 이미지 업로드에 성공했지만, 이미지 업로드와 게시글 업로드가 동시에 될 수 있는 코드 작성의 필요성을 느낌
 
