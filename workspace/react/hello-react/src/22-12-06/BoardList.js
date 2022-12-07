import React from "react";

class BoardHeading extends React.Component {
  render() {
    return (
      <thead>
        <tr>
          <th style={{ width: 100 }}>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>조회수</th>
          <th colSpan="2">부가기능</th>
        </tr>
      </thead>
    );
  } //render
  //게시물 테이블 제목행 구성
  // 번호 제목 작성자 조회수
} // class
class Board extends React.Component {
  //BoardList 내부 게시물 5개 배열 테이블 내부 출력
  //단 출력시 viewCount 1 증가 (반복문 활용)
  //   state = { seq: "" };
  render() {
    const deleteHandler = (e) => {
      //삭제버튼 클릭한 게시물이 몇번째인지 알아온다. 부모 처리함수에 전달한다
      this.props.deleteBoard(e.target.id);
    };
    const updateHandler = (e) => {
      const obj = {
        seq: e.target.id,
        title: "수정한제목",
        writer: "수정한작성자",
        viewCount: 0,
      };
      this.props.updateBoard(obj);
    };

    const board_tr = this.props.body.map(function (oneBoard, index) {
      return (
        <>
          <tr key={oneBoard.seq}>
            <td>{oneBoard.seq}</td>
            <td>{oneBoard.title}</td>
            <td>{oneBoard.writer}</td>
            <td>{oneBoard.viewCount + 1}</td>
            <td>
              <button id={index} onClick={deleteHandler}>
                삭제버튼
              </button>
            </td>
            <td>
              <button id={oneBoard.seq} onClick={updateHandler}>
                수정버튼
              </button>
            </td>
          </tr>
        </>
      );
    });
    return (
      <>
        <tbody>{board_tr}</tbody>
      </>
    );
  } //render
} // class

class BoardInsertForm extends React.Component {
  // 제목 : 입력창 / 작성자 : 입력창 / 글추가버튼
  // 제목값, 작성자값 전달받아서 글추가 버튼 클릭시
  // 번호 : 게시물리스트 갯수+1, // 조회수 : 기본값 0
  //게시물 1개 객체 생성..
  //props.addBoard(게시물 1개 객체 전달..)

  state = { seq: this.props.size, title: "", writer: "", viewCount: 0 };
  //생성자밖이니까 this.state라고 안씀
  //seq: 게시물전체개수 + 1..
  //   changeBoard = (ev) => {
  //     if (ev.target.id == "title") this.setState({ title: ev.target.value });
  //     if (ev.target.id == "writer") this.setState({ writer: ev.target.value });
  //   };

  render() {
    const changeHandler = (e) => {
      this.setState({ [e.target.id]: e.target.value });
    };
    const inserHandler = () => {
      this.props.addBoard({
        seq: this.state.seq + 1,
        title: this.state.title,
        writer: this.state.writer,
        viewCount: 0,
      });
    };
    return (
      <div>
        제목 입력:
        <input
          onChange={changeHandler}
          id="title"
          type="text"
          placeholder="제목을 입력하세요"
        ></input>
        작성자명 :
        <input
          onChange={changeHandler}
          id="writer"
          type="text"
          placeholder="작성자명을 입력하세요"
        ></input>
        <button onClick={inserHandler}>게시글작성</button>
      </div>
    );
  }
}

class BoardList extends React.Component {
  //Boardlist --> Board로 List 전달해야(props활용해서)
  constructor(props) {
    super(props);
    this.state = {
      boardList: [
        //현재 생성자 함수에서만 사용 or render할 함수에서도 사용할 지 or 값 변경시 화면도 같이 렌더링 필요한지 판단해야!
        { seq: 1, title: "제목1", writer: "작성자1", viewCount: 1 },
        { seq: 2, title: "제목2", writer: "작성자2", viewCount: 10 },
        { seq: 3, title: "제목3", writer: "작성자3", viewCount: 5 },
        { seq: 4, title: "제목4", writer: "작성자4", viewCount: 123 },
        { seq: 5, title: "제목5", writer: "작성자5", viewCount: 17 },
        // 배열안에 각 원소마다 {}이기만 하면 되는거지, 원소전부를 () 로 묶으면 마지막 원소만 나오는 현상 발견..
      ],
    };
  } //constructor
  render() {
    //addBoard 구현
    //1. 입력된 게시물 1개 전달
    //2. 1번 전달 게시물을 게시물리스트 추가
    //3. state 게시물리스트 값 변경
    const addBoard = (newBoard) => {
      this.state.boardList.push(newBoard);
      this.setState({ boardList: this.state.boardList });
    };
    const deleteBoard = (index) => {
      //배열 추가 : .push() (배열개수변화O) / 반복 : .map() / 삭제 :
      // 기타 : splice (배열개수변화O), filter
      //   this.state.boardList.splice(배열순서, 순서로부터 처리할 개수);
      this.state.boardList.splice(index, 1);
      this.setState({ boardList: this.state.boardList });
    };
    const updateBoard = (updateBoard) => {
      //선언한 updateoard != 매개변수 updatedBoard
      //배열에서 반복하면서 수정클릭게시물의 seq와 배열 내 5개 게시물들의 seq 비교
      //수정클릭게시물의 seq와 일치하는 게시물 찾으면
      //찾은 게시물을 수정입력(제목,작성자)..게시물내용 변경한다
      //state 알려준다
      this.state.boardList.map(function (oneBoard) {
        updateBoard.seq == oneBoard.seq ? updateBoard : oneBoard;
        //
      });
    };
    return (
      <div>
        <table border="3">
          <BoardHeading></BoardHeading>
          <Board body={this.state.boardList} deleteBoard={deleteBoard}></Board>
        </table>
        <br></br> <hr></hr>
        <BoardInsertForm
          size={this.state.boardList.length}
          //boardlist의 길이를 변수 size에 담아 전달
          addBoard={addBoard}
        ></BoardInsertForm>
      </div>
    );
  } //render
} // class

export default BoardList;
