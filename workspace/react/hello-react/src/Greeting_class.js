import React from "react";

class GreetingClass extends React.Component {
  render() {
    const welcome = (ev) => {
      // 변수선언은 render함수 내에 해야!!! (const 특징때문)
      //   alert(this.value + "합니다"); -- react에선 this 없다..(jsx구조기때문)
      alert(ev.target.value + "합니다 :)");
      // 여기서 ev.target은 input태그!
      console.log(ev.target);
      console.log("웰컴");
    };
    return (
      <input
        id="grtBtn"
        type={"button"}
        value={"인사"}
        onClick={welcome}
      ></input>
    );
  }
}

export default GreetingClass;
