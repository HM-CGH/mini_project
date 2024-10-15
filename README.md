# mini_project



```java
클래스 -> CommandSender(파스칼 표기법)
메서드/함수 -> getCommand(CamelCase) (is)Command -> 커맨드인지 아닌지 true false

변수 -> player_name(Snake_Case)
프라이빗 변수 -> _player_name


인터페이스 -> Stage

StageHandler <- 처리기
ConsoleHandler <- 처리기

Stage interface를 상속받는 애들을 관리함

new StageHandler().createStage(STAGE.DUNGEON);
new StageHandler().createStage(STAGE.VILLAGE);


Player 이진호 = new Player();

이진호.setName("cod51ess");

import asdmkasdmkas.StageHandler;

StageHandler st = new StageHandler();

st.createStage(STAGE.DUNGEON);





class StageHandler{
    public static StageHandler instance = new StageHandler();
    private StageHandler(){}
    public void createStage(Stage st){
        stasd.as.dasd;
    }
}


```


어떤 객체는 전부 Handler가 관리

객체는 자기 자신을 관리할 권한이 없음

나는 크리퍼 객체야. Monster interface를 상속해야함