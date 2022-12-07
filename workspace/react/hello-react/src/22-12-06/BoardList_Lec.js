import React from "react";

class BoardHeading extends React.Component {
  //게시물 테이블 제목행 구성
  // 번호 제목 작성자 조회수
  render() {
    return (
      <thead>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>조회수</th>
          <th colSpan="2">추가동작</th>
        </tr>
      </thead>
    );
  }
}

class Board extends React.Component {
  // state = {seq : ''}
  render() {
    const deleteHandler = (e) => {
      //삭제버튼 클릭한 게시물이 몇번째인지 알아온다. 부모 처리함수에 전달한다
      this.props.deleteBoard(e.target.id);
    };

    const updateHandler = (e) => {
      const obj = {
        seq: e.target.id,
        title: "수정한 제목",
        writer: "수정한 작성자",
        viewcount: 0,
      };
      this.props.updateBoard(obj);
    };
    //BoardList 내부 게시물 5개 배열 테이블 내부 출력
    //단, 출력시 viewcount 1 증가
    //배열 map 반복
    const board_tr = this.props.body.map(function (oneboard, index) {
      return (
        <tr key={oneboard.seq}>
          <td>{oneboard.seq}</td>
          <td>{oneboard.title}</td>
          <td>{oneboard.writer}</td>
          <td>{++oneboard.viewcount}</td>
          <td>
            <button id={index} onClick={deleteHandler}>
              삭제
            </button>
          </td>
          <td>
            <button id={oneboard.seq} onClick={updateHandler}>
              수정
            </button>
          </td>
        </tr>
      );
    });

    return <tbody>{board_tr}</tbody>;
  }
}

class BoardInsertForm extends React.Component {
  state = {
    size: this.props.size,
    title: "",
    writer: "",
    seq: this.props.size,
    viewcount: 0,
  };
  render() {
    const changeHandler = (e) => {
      //this.setState({title: ? , writer : ?})
      this.setState({ [e.target.id]: e.target.value });
    };
    const insertHandler = () => {
      this.setState({ seq: this.state.seq + 1 });
      this.props.addBoard({
        seq: this.state.seq,
        title: this.state.title,
        writer: this.state.writer,
        viewcount: this.state.viewcount,
      });
    };
    return (
      <div>
        제목입력 : <input type="text" id="title" onChange={changeHandler} />
        작성자입력 : <input type="text" id="writer" onChange={changeHandler} />
        <button onClick={insertHandler}>글추가버튼</button>
      </div>
    );
  }
  // 제목 : 입력창
  // 작성자 : 입력창
  // 글추가버튼

  //제목값, 작성자값 전달받아서 글추가버튼 클릭시
  // 번호 : 게시물리스트 갯수+1
  // 조회수 : 0
  // 게시물1개 객체 생성
  // props.addBoard(게시물1개 객체 전달)
}

class BoardList extends React.Component {
  constructor(props) {
    super(props);
    //현재생성자함수에서만, render도, 값 변경시 렌더링 필요 판단
    this.state = {
      boardList: [
        { seq: 1, title: "제목1", writer: "작성자1", viewcount: 1 },
        { seq: 2, title: "제목2", writer: "작성자2", viewcount: 10 },
        { seq: 3, title: "제목3", writer: "작성자3", viewcount: 5 },
        { seq: 4, title: "제목4", writer: "작성자4", viewcount: 123 },
        { seq: 5, title: "제목5", writer: "작성자5", viewcount: 0 },
      ],
    };
  } //constructor

  render() {
    //addBoard 구현
    //1. 입력된 게시물 1개 전달
    //2. 1번 전달 게시물을 게시물리스트 추가
    //3. state 게시물리스트값 변경
    const addBoard = (newBoard) => {
      //1
      this.state.boardList.push(newBoard); //2
      this.setState({ boardList: this.state.boardList }); //3
    };
    // this.props.deleteBoard(e.target.id);
    const deleteBoard = (index) => {
      //push(배열갯수변화) , map , filter , splice ,
      this.state.boardList.splice(index, 1); //배열갯수변화
      this.setState({ boardList: this.state.boardList });
    };
    const updateBoard = (updateBoard) => {
      this.setState({
        boardList: this.state.boardList.map(function (oneBoard) {
          return updateBoard.seq == oneBoard.seq ? updateBoard : oneBoard;
        }),
      });
    };
    //배열에서 반복하면서 수정클릭게시물seq와 배열내 5개 게시물들의 seq 비교
    //수정클릭게시물seq 일치하는 게시물 찾았다
    // 찾은 게시물을 수정입력(제목, 작성자 )게시물내용 변경한다.
    //state 알려준다

    return (
      <div>
        <table border="3">
          <BoardHeading />
          <Board
            body={this.state.boardList}
            deleteBoard={deleteBoard}
            updateBoard={updateBoard}
          />
        </table>
        <br />
        <hr />
        <br />
        <BoardInsertForm
          size={this.state.boardList.length}
          addBoard={addBoard}
        />
      </div>
    );
  }
}
export default BoardList;
/*
<table>
<tr><th></th></tr>
<tbody>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
</tbody>
</table>*/
