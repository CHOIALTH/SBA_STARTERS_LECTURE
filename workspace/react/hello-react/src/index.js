import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import reportWebVitals from "./reportWebVitals";

import BoardList from "./22-12-06/BoardList";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <BoardList></BoardList>
    {/* <TotalUserInform></TotalUserInform> */}
    {/* <Loop></Loop> */}
    {/* <TotalUserInform></TotalUserInform> */}
    {/* <UserInform></UserInform> */}
    {/* <LoginForm></LoginForm> */}
    {/* <EventComponent2 name="나는 인덱스에서 보내는 내용"></EventComponent2>
    <EventComponent name="리액트이벤트처리"></EventComponent> */}
    {/* <Book
      title="리액트"
      body="리액트 이야기를 재밌게 풀어봅시다"
      price="30000"
    ></Book>
    <Book
      title="스프링"
      body="MVC는 물론 부트까지도 재밌게 다룹니다"
      price="40000"
    ></Book>
    <Book
      title="마리아DB"
      body="오라클 MySQL mariadb 비교하여 설명합니다"
      price="25000"
    ></Book> */}
    {/* <ConstructorTest writer="작성자명!"></ConstructorTest> */}
    {/* <A></A>
    <B></B>
    <C></C> */}
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
