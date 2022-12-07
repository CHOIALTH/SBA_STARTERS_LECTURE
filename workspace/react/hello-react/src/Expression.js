function Pay() {
  const item = "카드";
  const title = "밥, 음료수";
  const price = 10000;
  const imgUrl = "https://t1.daumcdn.net/cfile/tistory/99B00247600A4BDF15";
  const result = (
    <div>
      <h1>{title} 먹었습니다.</h1>
      <h2>
        {item}로 - {price / 10} 원을 지불합니다.(10개월 할부액!)
      </h2>
      <img src={imgUrl} alt="현미밥"></img>
    </div>
  );

  return result;
}
export default Pay;
