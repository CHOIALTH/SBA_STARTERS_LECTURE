import React from "react";
class LoginForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      id: "아직 설정전",
      pw: "아직 설정전",
      idResult: "",
      pwResult: "",
    };
  }
  changeHandler = (e) => {
    // id나 pw 하나하나 입력할때마다
    //id 입력 중 발생 e.target.value
    //pw 입력 중 발생 e.target.value
    // this.setState({ id: e.target.value, pw: e.taget.value });
    if (e.target.id == "id") {
      this.setState({ id: e.target.value });
    } else if (e.target.id == "pw") {
      this.setState({ pw: e.target.value });
    }
  };

  loginHandler = (e) => {
    // 화살표함수 내의 this는 화살표방향에 따라 읽는다?
    this.setState({ idResult: this.state.id, pwResult: this.state.pw });
  };
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
        <label>PW : </label>
        <input
          type="password"
          id="pw"
          name="pw"
          placeholder="비밀번호 입력란"
          onChange={this.changeHandler}
        ></input>

        <button id="loginBtn" onClick={this.loginHandler}>
          {/* this. 안붙이면 loginHandler is not defiend 오류 뜸 */}
          로그인 버튼
        </button>
        <h1>
          로그인-ID/PW 입력 결과 = {this.state.idResult},{this.state.pwResult}
        </h1>
      </>
    );
  }
}
export default LoginForm;
