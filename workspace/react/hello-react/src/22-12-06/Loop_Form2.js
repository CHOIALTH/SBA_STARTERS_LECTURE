import React from "react";
class Loop extends React.Component {
  render() {
    const loop = this.props.userList.map((oneUser, index) => {
      return (
        <li key={index}>
          {oneUser.id} : {oneUser.name} : {oneUser.age}{" "}
        </li>
      );
    }); //loop end

    return <ul>{loop}</ul>;
  } //render
} //class

class UserInform extends React.Component {
  constructor(props) {
    super(props);
    this.state = { id: "", pw: "", name: "", age: 0 };
  }
  changeHandler = (ev) => {
    if (ev.target.id === "id") this.setState({ id: ev.target.value });
    if (ev.target.id === "pw") this.setState({ pw: ev.target.value });
    if (ev.target.id === "name") this.setState({ name: ev.target.value });
    if (ev.target.id === "age") this.setState({ age: ev.target.value });
  };
  addUserHandler = () => {
    // {id:'sba6' , pw:'sba6', name : '이길동6', age : 6} 입력했다면
    // 프로퍼티 전달 addUser 함수 전달
    this.props.addUser({
      id: this.state.id,
      pw: this.state.pw,
      name: this.state.name,
      age: this.state.age,
    });
  };

  render() {
    return (
      <div>
        <h1>
          아이디입력
          <input
            type="text"
            id="id"
            name="id"
            placeholder="아이디 입력"
            onChange={this.changeHandler}
          />{" "}
        </h1>
        <h1>
          암호입력
          <input
            type="password"
            id="pw"
            name="pw"
            placeholder="암호 입력"
            onChange={this.changeHandler}
          />{" "}
        </h1>
        <h1>
          이름입력
          <input
            type="text"
            id="name"
            name="name"
            placeholder="이름 입력"
            onChange={this.changeHandler}
          />{" "}
        </h1>
        <h1>
          나이입력
          <input
            type="text"
            id="age"
            name="age"
            placeholder="나이 입력"
            onChange={this.changeHandler}
          />{" "}
        </h1>
        <button id="userinsertbtn" onClick={this.addUserHandler}>
          회원가입버튼
        </button>
      </div>
    );
  }
}
class TotalUserInform extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      userList: [
        { id: "sba1", pw: "sba1", name: "홍길동", age: 20 },
        { id: "sba2", pw: "sba2", name: "김영희", age: 30 },
        { id: "sba3", pw: "sba3", name: "안철수", age: 35 },
        { id: "sba4", pw: "sba4", name: "박보검", age: 25 },
        { id: "sba5", pw: "sba5", name: "이길동", age: 22 },
      ],
    };
  } //constructor
  //userList 변경가능. 변경시 화면 리렌더링
  //userList 수정 기능 this.setState(userList수정...);

  render() {
    const addUser = (oneUser) => {
      this.state.userList.push(oneUser); //갯수 변경
      this.setState({ userList: this.state.userList });
    };
    return (
      <div>
        <UserInform addUser={addUser} />
        <Loop userList={this.state.userList} />
        {/* Loop 내부 this.props.userList 출력 */}
      </div>
    );
  }
}
export default TotalUserInform;
