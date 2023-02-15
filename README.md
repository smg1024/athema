# athema
멀티캠퍼스 웹서비스 백엔드 개발 4회차 팀 프로젝트 by 3조 포비와 친구들

## 1. 프로젝트 주제
- Naver Cloud Platform과 API(지도, 결제, SNS 로그인, 챗봇) 및 웹소켓을 활용한 테마 기반 여행 예약 웹 서비스 개발 

![image](https://user-images.githubusercontent.com/58433759/218383511-64587501-f643-410e-b3c8-34dcac56ae3f.png)


## 2. 프로젝트 목적
- 사용자가 선택한 테마를 특징으로 한 여행 예약 웹사이트
- ‘어떠한’ 여행을 떠나고 싶은지 먼저 묻고, 그에 따라서 '테마' 여행 추천 및 예약 진행 → Athema = '어때?' + '테마'
- 여행의 목적에 맞게 계획을 짜기 어려워하거나, 정보 수집이 어렵게 느껴지는 사람에게 유용한 서비스
- HTML 5 반응형 웹 사이트 구현
- 수업 시간에 배운 MyBatis, thymeleaf로 동적인 화면 구현
- 수업 시간에 배운 Naver Cloud Platform과 여러 API 등을 활용하여 기능을 다양화
- Zoom, Notion, ERDCloud, Github, Figma 사용을 통해 팀원과의 협업 경험

## 3. 시스템 구성도 / 사용 도구
⚒️ **시스템 구성도** 
![image](https://user-images.githubusercontent.com/58433759/218406414-c947b7ff-8179-4a2f-8ea3-71adc2fbe189.png)

⚒️ **사용 도구** 
![image](https://user-images.githubusercontent.com/58433759/218408167-1c8c88fc-3472-4f68-a0c6-449cda263d92.png)

|                            언어                            |                 개발도구                  |    Database    |                           협업도구                           |          Framework          |         Server          |
|:--------------------------------------------------------:|:-------------------------------------:|:--------------:|:--------------------------------------------------------:|:---------------------------:|:-----------------------:|
| Java<br/>HTML5<br/>CSS3<br/>JavaScript<br/>XML<br/>AJAX  | Eclipse 2020-12<br/>SpringBoot 2.7.7  |  MySQL 8.0.30  | Github<br/>Zoom<br/>Google Drive<br/>Google Docs<br/>Notion<br/>ERD Cloud | Thymeleaf<br/>Mybatis 3.2.2 | NCP(Naver Cloud Platform)<br/>Apache Tomcat |

## 4. DB 설계
> 11개의 테이블 사용 + 조원끼리 논의한 내용들과 피드백 메모 <br/>

![image](https://user-images.githubusercontent.com/58433759/217460880-08b80f88-8e45-4e73-a1aa-8d1cc3b324ce.png)

## 5. 프로젝트 기능 구현
😃 사용자 페이지

![image](https://user-images.githubusercontent.com/58433759/218676397-13f666b0-4ebc-44ec-b70f-705406c3ba03.png)

🧑‍💻 관리자 페이지

![image](https://user-images.githubusercontent.com/58433759/218932704-a21fd0e1-571e-4904-9a2b-314e468d9870.png)


## 6. 역할 분담

## 7. 트러블슈팅
|이름|문제|해결 방법|
|:--:|--|--|
|김상민|① mybatis mapper에서 하나 이상의 parameter 종류를 사용할 때 문제가 발생함.<br> ② 스크립트 영역에서 thymeleaf 값을 불러올때 null은 불러올 수 없는 문제가 발생함.<br> ③ thymeleaf를 이용해서 session에 대한 정보 유무를 판단할 때 페이지 parsing을 진행하지 못한다는 문제가 발생함. |① param# 방식으로 넣어서 문제를 해결함.<br>② null check를 설정해서  해결함.<br> ③ session의 null 여부를 확인한 후 삼항연산자를 활용하는 방식으로 해결함.
|임민하|① 자바스크립트에서 숫자를 더하는 경우 값을 문자로 인식함.<br>② git 저장소의 소스코드와 로컬의 소스코드 충돌로 pull을 할 수 없는 경우가 생김.<br>|① parseInt() 안에 숫자를 넣어서 해결함.<br>② 나의 코드를 무시하고 덮어쓰는 방식이지만 overwrite를 클릭, mark as merged 클릭 후 pull 받아 문제 해결 함.<br> 
|최효정|① 소셜로그인 구현 시 받아오는 정보가 부족해 NULL로 표시되는 문제가 발생함.<br> ② 비밀번호가 DB에 그대로 노출되는 문제가 발생함. <br> ③ 챗봇 실행시 응답코드 200 (정상 호출) 까지는 받았는데 그 이후로 jsonparser만 돌리면 값이 null로 나오는 문제가 발생함. <br> ④ NCP에 서버 올린 뒤 소셜로그인이 안되는 문제가 발생함. <br> ⑤ NCP에 서버 올리고 챗봇 한글이 깨지는 현상이 나타남. |① 1. id를 email 형식으로 바꾸고 pwd는 null로 변경하되, 자체 register에서는 js를 통해 DB에 null 입력을 제한함. 2. 카카오 가입자는 가입 완료시 이름, 휴대폰 등 필수 정보를 추가로 입력하는 폼을 작성하도록 페이지를 이동시킴. <br> ② pom.xml에 Spring Security 추가 후 인터페이스 객체인 PasswordEncoder 알고리즘을 통해 암호화 거쳐서 DB에 저장하기로 함.  1. SqlException → mem_pwd 컬럼 varchar(100)으로 변경함.  2. Encoded password does not look like BCrypt. → encoder.matches 메소드 문법 순서가 잘못됨. <br> ③ 디코드 된 String값을 한줄씩 디버깅해보니 (JSONObject)bubblesArray.get(0)이 아니라 description 속성은 get(1)번째에 있었음. <br> ④ 스크립트에서 redirectURI 수정 및 Service에서도 해당코드 수정 → 개발자 센터 애플리케이션에도 uri 새로 등록함. <br> ⑤ InpuStreamReader에서 UTF-8로 인코딩해줌 (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8")); → Window OS에서는 java 기본 인코딩이 UTF-8이라 문제가 없었던것. 앞으로 입출력 기능 만들 때는 무조건 인코딩을 확인함.
