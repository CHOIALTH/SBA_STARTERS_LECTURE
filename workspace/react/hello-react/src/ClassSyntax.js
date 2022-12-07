import React from "react";
//React에 내장된 것 사용하려면 React 사용하겠다고 선언!
class Employee extends React.Component {
  //class로 선언시 매개변수 필요X
  // extends React.Component(React에 내장됨) : Employee가 함수역할을 할거야~
  //React.Component 상속 표현
  render() {
    //render 안의 내용이 화면에 노출된다. 따라서 jsx를 render안에 작성해야
    const clickHandler = () => {
      alert("react class 방식으로 정의되었습니다");
    };
    return (
      <div onClick={clickHandler}>
        <h1>테스트 해보슈</h1>
      </div>
    );
  }
}
//jsx 태그의 속성명이나 css 속성명 두단어결합시 무조건 camelCase 적용!

export default Employee;
