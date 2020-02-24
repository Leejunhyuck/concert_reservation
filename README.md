# 어플리케이션 내용

## 주제
공연 등록 & 예약 어플리케이션
    
## 어플리케이션 기능 (application layer)
* 회원가입
* 로그인
* 자신의 사용자 정보 조회
* 공연 정보 조회
* 공연 예약, 취소, 변경
* 공연에 예약 현황 조회

## api list (controller, UI layer)
* POST /api/v1/user/register 
   + 회원가입
* POST /api/v1/user/login 
   + 로그인
* GET /api/v1/user/my_page 
    + 자신의 사용자 정보 조회
* GET /api/v1/concerts 
    + 공연 정보 조회
* POST /api/v1/reservation/concerts/{concertId}/{seatNumber} 
    + 공연 예약, 취소, 변경
* GET /api/v1/reservation/concerts/{concertId} 
    + 공연에 대한 예약 현황 조회

# 주안점
   ## 1. DTO와 VO 분리
   * DTO와 VO를 분리하였다. 잘 모르고 같이 사용하였다. DTO와 VO를 나누어서 사용하였다.
   * VO와 DTO둘다 데이터를 저장하는 용도이다. 다만 각각 사용영역을 구분해서 사용한다.  
   * VO와 DTO에 대해 간략히 정리한다.
   * VO는 Database와 밀접하다.
     즉 DB의 도메인정보를 클라이언트에게 전달할 때, 그 도메인단위 정보를 VO로 구현하여 사용한단다.
   * 클라이언트와 데이터를 주고 받는 경우, VO가 가진 맴버변수보다 적은 멤버변수를 갖을 수 있으며, 
     VO에는 없는 추가적인 변수를 가질수도 있다. 이렇게 DB의 도메인과 일치하지 않으며, 
     어떤 로직에 사용되는 영속적이지 않는 데이터를 포함하는 DTO클래스로 만들어서 사용한다.

  ## 2. 구조적인 설계
   * 본 프로젝트의 기능은 크게  user, concert 두가지로 나뉜다. 
   패키지는 크게 모델별로 나누고 기능별로 세분화 하는 것이 좋다고 생각한다. 
    
   - 이유는, 구체적으로 보자면 DB의 테이블이라 할 수도 있습니다. 
    기본적으로 업무에서 웹프로젝트를 작성할 때 주된 작업은 DB에 있는 자료를 
    입력, 수정, 삭제하는 식의 작업이라서 테이블별로 분류한 패키지는 DB와 관련된 작업을 편하게 할수 있고, 
    동시에 협업 할 경우에도 패키지구조 이해를 쉽게 할수 있다.

           
              org
              └── raccoon
                  └── concert
                      ├── DemoApplication.java
                      ├── user
                      |   ├── service
                      |   ├── controller 
                      |   |     └── reservationConrtoller
                      |   |     └── concertController  
                      |   ├── model
                      |   └── repository              
                      ├── concert
                      |   ├── service
                      |   ├── controller
                      |   |      └── userController  
                      |   ├── model
                      |   └── repository                
                      └── config   
    
    
    
   ## 3. service 객체의 2단 상속
    
        interface GenericService
        Service extends GenericService
        ServiceImpl

   - 기본 CRUD를 GenericService에 만들어두고 상속 받는 Service만의 함수를 만들고, 이를 ServiceImpl에서 구현하였다.
   - service에서 serviceImpl 구조를 사용 하는 이유 
        + 객체지향의 다형성을 지키기 위하여 사용
        + 옛날에 AOP기능을 사용하기 위하여 dynimic proxy를 구현하기 위해서는
          interface 클래스를 사용하여야 하였기 때문 (현재는 이 방법을 사용 하지 않아도 가능하다)      
# Refactoring
   ## Exception Handler    
1. @ControllerAdvice 
    - 공통 Exception 클래스를 만들고 해당 어노테이션 추가
    - 서비스, 컨트롤러단에서는 exception을 throw 하는 역할만하고 공통 클래스에서 일괄처리
2. @ExceptionHandler 
    - 컨트롤러 별로 Exception 처리 
3. try/catch
    - 메소드 단위에서 exception 처리
    - 안티패턴, 불가피한경우 구체적인 Exception 지정 

  ## 에러 인터페이스 정의를 제대로 해야한다.
    ex) 만약 배송관련 모듈에서 발생한 에외코드랑 에러가 난 번호를 
    리턴 해 준다고 하자, 그러면 @ControllerAdvice를 이용해서 통합
    으로 처리하려고 했지만 리턴 타입이 다르니까 통합해서 처리할 수 없다.
    보통 에러를 한 곳에 정리를 하여 에러 객체를 리턴하는 방식을 사용한다.
    그러면 throw new 커스텀Exception()을 하여주만 끝나기 때문에 
    유지보수에 도움 이 된다.
# if문이 없어야 하나? 지나친 삼항연산자 지양

    <pre>
    <code>
    int a;
    if(5<4) {
        a = 50;
    }else {
        a = 40;
    }
 
    int b = (5 < 4) ? 50 : 40; 
    {code}
    </code>
    </pre>
   
    if문이 없는 코드가 깔끔하다는 인식이 있는거 같다.
    삼항연산자로 코드를 작성하면 깔끔하지만, 많이 알려지다보니 남발하여 코드의 가독성을 떨어뜨리는 경우가 있는거 같다.
    
    * 코틀린에는 삼항연산자를 지원하지 않는다. (본 코드는 자바(JAVA))

# 코틀린 기본적인 문법 숙지



