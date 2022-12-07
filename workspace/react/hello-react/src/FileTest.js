import React from "react";
//React 관련 코드 사용을 했다면 React를 먼저 import 해줘야..
function A() {
  //반복문 조건문 실행문장
  return (
    <div>
      <h1>A함수구조로 정의된 component입니다</h1>
    </div>
  );
}
const B = () => {
  return (
    <div>
      <h1>B 화살표함수구조로 정의된 component입니다</h1>
    </div>
  );
};
class C extends React.Component {
  //이 안에서 변수 선언, 또다른 함수(메서드) 선언 가능. 이 안에 render  존재 필수!!
  //상속에 의해 자동으로 포함되는 메서드가 있다.. 아래와 같은 메서드..
  //render () - 화면에 랜더링시 호출할 요소 정의 . 매개변수 사용 X
  //constructor(props) - <C /> (C라는 이름의 component 생성하라) 생성되면서 호출(따라서 constructor 가 render 메서드보다 먼저 호출됨). 초기변수 정의. 매개변수 props
  render() {
    return (
      <div>
        <h1>C 클래스 구조로 정의된 component입니다</h1>
      </div>
    );
  }
} //C : not 함수 but 클래스

export default A; //export default 의 형식으론 하나의 함수에만 사용가능
export { B };
export { C };
