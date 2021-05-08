# fishmarket

1. 설치 및 환경설정
  - java v11.0.x
  - spring boot v2.4.5
  - build gradle
  
2. 테이블 자동 생성

3. API List
  - 점포 추가 API
  POST /v1/stores
  request body
  <pre><code>{
  "name": "인어수산2",
  "owner": "장인어",
  "description": "인천소래포구 종합어시장 갑각류센터 인어수산",
  "level": 1,
  "address": "인천광역시 남동구 논현동 680-1 소래포구 종합어시장 1 층 1 호",
  "phone": "010-1111-2222",
  "businessTimes": [
    {
      "day": "Monday",
      "open": "13:00",
      "close": "20:00"
    },
    {
      "day": "Tuesday",
      "open": "13:00",
      "close": "23:00"
    },
    {
      "day": "Wednesday",
      "open": "09:00",
      "close": "18:00"
    },
    {
      "day": "Thursday",
      "open": "09:00",
      "close": "23:00"
    },
    {
      "day": "Friday",
      "open": "09:00",
      "close": "23:00"
    },
    {
      "day": "Saturday",
      "open": "09:00",
      "close": "15:00"
    }
  ]
}</code></pre>
  
  - 점포 휴무일 등록 API
    POST /v1/stores/holidays
    request body
    <code><pre>
    {"id": 1, "holidays": [
"2021-05-07",
"2021-05-08" ]
}
    </code></pre>
  - 점포 목록 조회 API
    GET /v1/stores
    
    
  - 점포상세정보조회API
    GET /v1/stores/{id}
