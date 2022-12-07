import React from "react";
import { useState } from "react";
// function EventComponent() {
//   // const clickHandler = (){}
//   // function clickHandler(){}
// }

// const [clickHandler, setClickHandler] = useState();
class EventComponent extends React.Component {
  state = { value: 0, name: this.props.name };
  //state 객체와 setState는 자동으로 역할이 정해져 포함돼있다.
  //   clickHandler() {
  //     // 클래스메서드 + 유명함수
  //   }
  value = 0;
  clickHandler = () => {
    this.setState({
      value: this.state.value + 1,
      name: "이벤트처리중",
    }); //setState : setter 역할
  };
  render() {
    // const clickHandler = () => {
    //   this.setState({ value: this.state.value + 1, name: "이벤트처리이후" }); //현재 객체에 포함된 state 변수를 수정하는 내장함수
    //   //해석 - 변경해야할 value : 이값으로 변경해주세요
    //   //   alert(++this.value);
    //   //alert 안 문장 : this.value = this.value + 1 ;
    // };
    //   const clickHandler = ()=>{
    //클래스메서드 + 화살표함수
    // }
    return (
      <>
        <div>
          <h1>
            {this.state.value}와 {this.state.name}
          </h1>
        </div>
        <button onClick={this.clickHandler}>클릭버튼</button>
        <div>전달받은 {this.state.name}</div>
      </>
    ); //return
  } //render
} //class

export default EventComponent;
