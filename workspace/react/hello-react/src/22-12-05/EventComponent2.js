import { useState } from "react";
function EventComponent2(p) {
  //state 객체 변수와 setState 함수 없다
  //useState 라이브러리 호출
  const [value, setValue] = useState(0);
  const [name, setName] = useState(p.name);
  // this.state.value = 0 으로 초기화 했다는 뜻.

  const clickHandler = () => {
    // value = value + 1;
    setValue(value + 1);
    // setValue(++value);

    // name = "이벤트 처리중";
    setName("이벤트 처리중");
  };
  return (
    <>
      <div>
        <h1>
          {value}와 {name}
        </h1>
      </div>
      <button onClick={clickHandler}>클릭버튼</button>
      <div>전달받은 {p.name}</div>
    </>
  );
}
export default EventComponent2;
