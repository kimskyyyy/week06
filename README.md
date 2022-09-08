Week06 Mini Project Team09
=============      
Frontend GitHub: https://github.com/sooo0y/Daily_Life     
Backend GitHub: https://github.com/kimskyyyy/week06   

:v: 프로젝트 소개
-------------   
<img src="/path/to/img.jpg" width="1000px" height="300px" title="px(픽셀) 크기 설정" alt="RubberDuck"></img><br/>
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
1) 메인페이지: 카드형으로(?) 전체 게시글 조회   
2) 회원가입: id 중복 확인, password 일치 확인, 유효성 검사(id: 숫자0-9, 영문자 대소문자 포함 4-12자, pw: 숫자0-9, 영문자 대소문자 포함 4-32자)   
3) 로그인 페이지: id, password로 로그인, 로그인 성공시 HTTP Headers Response를 통해 Authorization Token, Refresh Token 발급    
4) 게시글 작성 페이지: 게시글 작성 및 이미지 업로드   
5) 게시글 조회 및 댓글 페이지: 게시글 조회 및 댓글 생성, 조회, 수정, 삭제   
6) 게시글 수정 페이지: 게시글 수정   
7) 마이페이지: 내가 쓴 글 조회, 수정, 삭제   

:movie_camera: 시연 영상
-------------  

:green_book: 와이어프레임
------------- 
<img src="https://user-images.githubusercontent.com/110077343/189107732-e7c70398-c4d2-4e80-8ea0-9f261afbad0f.png" width="900px" height="370px" title="px(픽셀) 크기 설정" alt="WireFrame"></img><br/>
<img src="https://user-images.githubusercontent.com/110077343/189108012-b0f5330f-2f1b-4c2b-8cd8-a4b25f9602dd.png" width="900px" height="536px" title="px(픽셀) 크기 설정" alt="WireFrame"></img><br/>


:blue_book: ERD
-------------
<img src="https://user-images.githubusercontent.com/110077343/189080595-4f655837-5f4c-45c3-9246-9b32bd0e67c4.png" width="900px" height="520x" title="px(픽셀) 크기 설정" alt="WireFrame"></img><br/>


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
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white">CSS
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
