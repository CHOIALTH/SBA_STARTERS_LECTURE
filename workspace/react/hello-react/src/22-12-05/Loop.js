import React from "react";

class Loop extends React.Component {
  constructor(props) {
    super(props);
    // this.userList = [
    //   { id: "sba1", pw: "sba1", name: "베츠", age: 20 },
    //   { id: "sba2", pw: "sba2", name: "베닌텐디", age: 30 },
    //   { id: "sba3", pw: "sba3", name: "앨스버리", age: 32 },
    //   { id: "sba4", pw: "sba4", name: "오티스", age: 40 },
    //   { id: "sba5", pw: "sba5", name: "라미레즈", age: 39 },
    // ];
  }
  render() {
    const loop = this.userList.map((oneuser, index) => {
      // 여기서 oneuser, index 는 매개변수
      return (
        <div>
          <li key={index}>
            {oneuser.id}:{oneuser.name}:{oneuser.age}
          </li>
        </div>
      );
    }); //loop end
    // return <ol>{loop}</ol>;
    // const loop = () => {
    //   let result = "";
    //   for (var i = 0; i < this.userList.length; i++) {
    //     result +=
    //       this.userList[i].id + this.userList[i].name + +this.userList[i].age;
    //   } // for end
    //   return result;
    // }; // loop end
    // const outerResult = loop();
    // return (
    //   <>
    //     <ol>{outerResult}</ol>
    //   </>
    // );
  }
}
class UserInform extends React.Component {
  joinHandler = (e) => {};

  render() {
    return (
      <>
        <label>ID : </label>
        <input
          type="text"
          id="id"
          name="id"
          placeholder="아이디 입력란"
          onChange={this.changeHandler}
        ></input>
        <br></br>
        <label>PW : </label>
        <input
          type="password"
          id="pw"
          name="pw"
          placeholder="비밀번호 입력란"
          onChange={this.changeHandler}
        ></input>
        <br></br>
        <label>이름 : </label>

        <input
          type="text"
          id="name"
          name="name"
          placeholder="이름 입력란"
          onChange={this.changeHandler}
        ></input>
        <br></br>
        <label>나이 : </label>

        <input
          type="text"
          id="age"
          name="age"
          placeholder="나이 입력란"
          onChange={this.changeHandler}
        ></input>
        <br></br>
        <button id="userInsertBtn" onClick={this.joinHandler}>
          회원가입 버튼
        </button>
      </>
    );
  }
}
class TotalUserInform extends React.Component {
  constructor(props) {
    super(props);
    this.userList = [{ id: "", name: "", age: "" }];
    console.log(this.userList);

    // this.userList = [
    //   { id: "sba1", pw: "sba1", name: "베츠", age: 20 },
    //   { id: "sba2", pw: "sba2", name: "베닌텐디", age: 30 },
    //   { id: "sba3", pw: "sba3", name: "앨스버리", age: 32 },
    //   { id: "sba4", pw: "sba4", name: "오티스", age: 40 },
    //   { id: "sba5", pw: "sba5", name: "라미레즈", age: 39 },
    // ];
  }
  render() {
    const loop = this.userList.map((oneuser, index) => {
      // 여기서 oneuser, index 는 매개변수
      return (
        <div>
          <li key={index}>
            {oneuser.id}:{oneuser.name}:{oneuser.age}
          </li>
        </div>
      );
    }); //loop end
    return (
      <div>
        <UserInform></UserInform>
        <ol>{loop}</ol>
      </div>
    );
  }
}
export default Loop;
export { UserInform, TotalUserInform };
