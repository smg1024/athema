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


## 6. 역할 분담

## 7. 트러블슈팅
|이름|문제|해결 방법|
|:--:|--|--|
|김상민|① mybatis mapper에서 하나 이상의 parameter 종류를 사용할 때 문제가 발생함.<br> ② 스크립트 영역에서 thymeleaf 값을 불러올때 null은 불러올 수 없는 문제가 발생함.<br> ③ thymeleaf를 이용해서 session에 대한 정보 유무를 판단할 때 페이지 parsing을 진행하지 못한다는 문제가 발생함. |① param# 방식으로 넣어서 문제를 해결함.<br>② null check를 설정해서  해결함.<br> ③ session의 null 여부를 확인한 후 삼항연산자를 활용하는 방식으로 해결함.
|임민하|① 자바스크립트에서 숫자를 더하는 경우 값을 숫자로 인식하지 못했다.<br>② git 저장소의 소스코드와 로컬의 소스코드 충돌로 pull을 할 수 없는 경우가 생겼음.<br>|① parseInt 안에 숫자를 넣어서 해결함.<br>② 나의 코드를 무시하고 덮어쓰는 방식이지만 overwrite를 클릭한 후 mark as merged를 클릭하면 pull이 가능했다.<br> 
