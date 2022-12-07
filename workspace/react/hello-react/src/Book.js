import React from "react";

class BookHeading extends React.Component {
  //
  render() {
    return (
      <>
        <h1> 제목 = {this.props.title}</h1>
      </>
    );
  }
}

class BookBody extends React.Component {
  constructor(props) {
    super(props);
    this.body = "내용 = " + this.props.body;
    this.price = "가격 = " + this.props.price + "원";
  }
  render() {
    return (
      <>
        <hr>
          <h2>{this.body}</h2>
          <h2>{this.price}</h2>
        </hr>
      </>
    );
  }
}

class Book extends React.Component {
  constructor(props) {
    super(props);
    this.title = "제목 = " + props.title;
    // this.title = props.title;
    // this.body = props.body;
    // this.price = props.price;
    console.log("props콘솔", props);
  }
  //   render() {
  //     return (
  //       <>
  //         <h1>오늘 구입한 책 목록</h1>
  //         제목: {this.title} <br></br> 내용 :{this.body}
  //         <br></br> 가격: {this.price}
  //       </>
  //     );
  //   }
  //이것도 맞음
  render() {
    const body = "내용 = " + this.props.body;
    const price = "가격 = " + this.props.price;
    return (
      <>
        <BookHeading title={this.props.title}></BookHeading>
        <BookBody body={this.props.body} price={this.props.price}></BookBody>
        {/* <h1>오늘 구입한 책 목록</h1>
        제목: {this.title} <br></br> 내용 :{body}
        <br></br> 가격: {price} */}
        {/* <h1>오늘 구입한 책 목록</h1>
        제목: {this.title} <br></br> 내용 :{this.body}
        <br></br> 가격: {this.price} */}
      </>
    );
  }
}

export default Book;
// 오늘 구입한 책목록
// 제목 , 내용, 가격
