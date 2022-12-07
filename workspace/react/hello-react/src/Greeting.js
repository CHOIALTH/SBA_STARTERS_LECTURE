function Greeting() {
  //   let index = 0;
  let index = parseInt(Math.random() * 3);
  //*10 : 0 <= ? < 10.0
  // Math.random - 난수(기본 : 0~1 사이의 값)뿌려줌. 위처럼 범위를 설정 할 수 있다.
  //   let insa;
  //   if (index == 0) {
  //     insa = "오늘도 즐거운 하루 되세요";
  //   } else if (index == 1) {
  //     insa = "안녕하세요 리액트";
  //   } else if (index == 2) {
  //     insa = "오늘 날씨 어때요?";
  //   }
  //   let result = <h1>{insa}</h1>;
  //   return result;
  //이상 JS if 조건문
  let insa1 = "오늘도 즐거운 하루 되세요!";
  let insa2 = "안녕하세요 리액트!";
  let insa3 = "오늘 날씨 어때요?";
  let style2 = { color: "pink", border: "2px solid yellow" };
  return index == 0 ? (
    <h1>
      {index}:{insa1}
    </h1>
  ) : index == 1 ? (
    <h1
      style={{
        color: "red",
        border: "2px solid blue",
        backgroundColor: "black",
      }}
    >
      {/* background = backgroundColor */}
      {index}:{insa2}
    </h1>
  ) : (
    <h1 style={style2}>
      {index}:{insa3}
    </h1>
  );
  //   return index == 0 ? <h1>{insa1}</h1> : <h1>{insa2}</h1>;

  //이상 JSX 조건삼항연산자 기본형식 => 변수명 = 값1 ? true시 도출값 : false시 도출값
}
export default Greeting;
