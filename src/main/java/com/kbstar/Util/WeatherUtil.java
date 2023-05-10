package com.kbstar.Util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;

public class WeatherUtil {
    // 방법1. "해당하는 지역"정보 넣으면 - 현재 시간정보 에 맞는 "해당하는 지역"의 날씨정보 보내주기
    public static String getWeather1(String loc) throws Exception {
        // 2- (test폴더 - calendarTest 파일)에서 오늘날짜 출력되도록 테스트하고 > 아래 붙여넣기.
        Calendar c = Calendar.getInstance(); // 최신 Date 함수
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DATE);

        String month_str = month+""; // 정수 -> 문자로 변환
        if(month_str.length() == 1){
            month_str = "0"+month_str; // month_str = 0 + 문자
        }

        String today = ""+year+month_str+day+"0600"; // 년월일 + 아침 6시 로 출력
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst"); /*데이터 주는 곳의 URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=UP8G6N6OpRgPX6lzlmQNwDfqRck%2FkQ5692WWfL5o3NUuDkbQXx9UDw%2FrehulcnGdqJecvSaigAsMuiZCXh8hmQ%3D%3D"); /*= 다음부터 내 인증키 입력 Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("stnId","UTF-8") + "=" + URLEncoder.encode(loc, "UTF-8")); /*108 전국, 109 서울, 인천, 경기도 등 (활용가이드 하단 참고자료 참조)*/
        urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode(today, "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600 (1800)-최근 24시간 자료만 제공*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
      //  System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();


        // 3. data 중 body 가져오기 위해
        JSONParser jsonParser = new JSONParser();
        // 4. 이렇게 하면, json -> Java object 로 바뀐다.
            // 1) jsonObj { JSONObject 형태 } - response - body - items 속에 ->
            // 2) items 속에 있는 item 은 item : [] 형태이므로 [JSONArray] 로 빼내기
            // 3) item 속에 있는 속성들은 다시 또 { JSONObject 형태 }이므로, 1)과 동일하게 빼내기.
            // 4) 속성 들 중에, "wfSv" 를 최종적으로 꺼내기.
        JSONObject jsonObj = (JSONObject)jsonParser.parse(sb.toString());
        JSONObject response = (JSONObject)jsonObj.get("response");
        JSONObject body = (JSONObject)response.get("body");
        JSONObject items = (JSONObject)body.get("items");
            // 2) items 속에 있는 건 배열에 담긴 item!
            JSONArray item = (JSONArray)items.get("item");

            // 3) item 배열에서 꺼내는 객체들은 JSONObject 이며 이름은 obj로 하기.
            JSONObject obj = (JSONObject)item.get(0);
            // 4) obj에서 String 속성 "wfSv" 꺼내기(get)
            String result =  (String)obj.get("wfSv");
        return result;
    }

    //방법2. "해당하는 지역"정보 넣으면 - 해당하는 JSON 정보를 그대로 return 해주기.
    public static Object getWeather2(String loc) throws Exception {
        // 2- (test폴더 - calendarTest 파일)에서 오늘날짜 출력되도록 테스트하고 > 아래 붙여넣기.
        Calendar c = Calendar.getInstance(); // 최신 Date 함수
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DATE);

        String month_str = month+""; // 정수 -> 문자로 변환
        if(month_str.length() == 1){
            month_str = "0"+month_str; // month_str = 0 + 문자
        }

        String today = ""+year+month_str+day+"0600"; // 년월일 + 아침 6시 로 출력
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst"); /*데이터 주는 곳의 URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=UP8G6N6OpRgPX6lzlmQNwDfqRck%2FkQ5692WWfL5o3NUuDkbQXx9UDw%2FrehulcnGdqJecvSaigAsMuiZCXh8hmQ%3D%3D"); /*= 다음부터 내 인증키 입력 Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("stnId","UTF-8") + "=" + URLEncoder.encode(loc, "UTF-8")); /*108 전국, 109 서울, 인천, 경기도 등 (활용가이드 하단 참고자료 참조)*/
        urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode(today, "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600 (1800)-최근 24시간 자료만 제공*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        //  System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();


        // 3. data 중 body 가져오기 위해
        JSONParser jsonParser = new JSONParser();
        // 4. 이렇게 하면, json -> Java object 로 바뀐다.
        // 1) jsonObj { JSONObject 형태 } - response - body - items 속에 ->
        // 2) items 속에 있는 item 은 item : [] 형태이므로 [JSONArray] 로 빼내기
        // 3) item 속에 있는 속성들은 다시 또 { JSONObject 형태 }이므로, 1)과 동일하게 빼내기.
        // 4) 속성 들 중에, "wfSv" 를 최종적으로 꺼내기.
        JSONObject jsonObj = (JSONObject)jsonParser.parse(sb.toString());




        return jsonObj; // 기상청의 JSON 정보를 그대~로 브라우저 화면에 보여주기.
    }

    //방법3. "해당하는 지역"정보 넣으면 -  return 해주기.
    public static Object getWeather3(String loc) throws Exception {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/AsosHourlyInfoService/getWthrDataList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=UP8G6N6OpRgPX6lzlmQNwDfqRck%2FkQ5692WWfL5o3NUuDkbQXx9UDw%2FrehulcnGdqJecvSaigAsMuiZCXh8hmQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호 Default : 10*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수 Default : 1*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default : XML*/
        urlBuilder.append("&" + URLEncoder.encode("dataCd","UTF-8") + "=" + URLEncoder.encode("ASOS", "UTF-8")); /*자료 분류 코드(ASOS)*/
        urlBuilder.append("&" + URLEncoder.encode("dateCd","UTF-8") + "=" + URLEncoder.encode("HR", "UTF-8")); /*날짜 분류 코드(HR)*/
        urlBuilder.append("&" + URLEncoder.encode("startDt","UTF-8") + "=" + URLEncoder.encode("20230509", "UTF-8")); /*조회 기간 시작일(YYYYMMDD)*/
        urlBuilder.append("&" + URLEncoder.encode("startHh","UTF-8") + "=" + URLEncoder.encode("01", "UTF-8")); /*조회 기간 시작시(HH)*/
        urlBuilder.append("&" + URLEncoder.encode("endDt","UTF-8") + "=" + URLEncoder.encode("20230509", "UTF-8")); /*조회 기간 종료일(YYYYMMDD) (전일(D-1) 까지 제공)*/
        urlBuilder.append("&" + URLEncoder.encode("endHh","UTF-8") + "=" + URLEncoder.encode("12", "UTF-8")); /*조회 기간 종료시(HH)*/
        urlBuilder.append("&" + URLEncoder.encode("stnIds","UTF-8") + "=" + URLEncoder.encode(loc, "UTF-8")); /*종관기상관측 지점 번호 (활용가이드 하단 첨부 참조)*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        JSONParser jsonParser = new JSONParser();
        JSONObject jo = (JSONObject) jsonParser.parse(sb.toString());
        return jo;
    }
}
