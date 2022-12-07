function Calc(param) {
  //매개변수명은 아무거나 사용해도 무방
  let su1 = parseInt(param.su1);
  let su2 = parseInt(param.su2);
  // 각 변수에 parseInt 안씌우면 더하기시 문자결합이 되버린다
  //   let su1 = 10;
  //   let su2 = 20; //Calc함수내 지역변수로 선언됨
  let centerStyle = { textAlign: "center" };
  //   let op_list = ["+", "-", "*", "/"];
  const cal = {};
  let index = parseInt(Math.random() * 3);
  const theStyle = { backgroundColor: "orange" };
  return (
    <div style={centerStyle}>
      <h1 style={theStyle}>
        {su1}+{su2} = {su1 + su2}
      </h1>
      <h1 style={{ background: "red" }}>
        {su1}-{su2} = {su1 - su2}
      </h1>
      <h1 style={{ background: "green" }}>
        {su1}*{su2} = {su1 * su2}
      </h1>
      <h1 style={{ background: "yellow" }}>
        {su1}/{su2} = {su1 / su2}
      </h1>
    </div>
  );
}
//export default 시 선언한 함수와 이름 일치시켜야

export default Calc;
//1. Calc 함수정의
//2. 외부 파일에서는 Calculator 로 지정
//3. 10 + 20 = 30 , 10 - 20 = -1 , 10 * 20 = 200 , 10 / 20 = 0.5
// 4. 더하기 배경색 오렌지, 나머지 적당한 색 / 전부 중앙정렬
