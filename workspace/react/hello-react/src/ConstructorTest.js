import React from "react";

class ConstructorTest extends React.Component {
  title = "제목"; //현재 객체의 모든함수에서 사용 가능(변수 선언 위치에 따라 사용가능한 범위가 달라짐)

  constructor(props) {
    super(props);
    //나를 상속해준 부모객체에 props 변수를 전달하겠다. (부모의 생성자 호출)
    //react constructor 사용시 필수적으로 super() 첫번째 문장에 사용. 부모가 먼저 만들어져야 상속받은걸 사용할 수 있으니까
    //constructor 내부에는 this.을 붙여 필요한 변수 선언 가능. 함수안에 함수 선언도 가능(JS 특징)
    console.log("생성시 함수 호출");
    this.contents = "내용"; //현재 객체의 모든함수에서 사용 가능
    this.writer = props.writer; //호출하고 있는 다른 외부파일에서 전달받음
    this.list = { a: 100, b: "비" }; //객체가 들어가는 형태
    this.arr = [1, 2, 3, 4];
  }
  render() {
    console.log("렌더함수 호출");
    const title = "제목2";
    return (
      <>
        test 제목 : {this.title}
        내용 : {this.contents}
        작성자 : {this.writer}
      </>
    );
  }
}

export default ConstructorTest;
