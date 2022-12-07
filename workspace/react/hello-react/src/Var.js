function Var() {
  let str1 = "리턴문테스트222";
  let str2 = "이번에는 변수를 테스트 해봅니다";
  let str3 = "logo512.png";
  return (
    <>
      <h1>{str1}</h1>
      <p>{str2}</p>
      <img src={str3} alt=""></img>
    </>
  );
}

export default Var;
