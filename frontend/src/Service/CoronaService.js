// 코로나 관련 api 호출     Author : JHW

import axios from 'axios';

export async function getCoronaCntOfEachCity() {
  return await axios.get(
    'https://api.corona-19.kr/korea/country/new/?serviceKey=goGbrTXFuZaszIh5AREyLPj23NlpDUvxV'
  );
}
