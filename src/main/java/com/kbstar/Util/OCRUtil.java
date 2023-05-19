package com.kbstar.Util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OCRUtil {
    // 스프링부트에서 제공하는 라이브러리가 아니라서, OCRUtil은, 상단에 @ 없음
    public static Object getResult(String imgpath, String imgname){
        JSONObject jobj = null; // {} 0.이거 만들 준비

        // 네이버 클라우드에서 전체 가져왔다.
        // 아래 3줄은 나의 정보 붙여넣기.
        String apiURL = "https://uhucar79op.apigw.ntruss.com/custom/v1/22512/438afcf978eec326d868f679f3e11778756d5d45242a2fcdb54ebc11c6427dbf/infer";
                String secretKey = "YmtqUnNhdklKblhzc0NYSEJySmtRUHV4dlptUERzcnM=";
        String imageFile = imgpath + imgname; // 서버에 저장하겠다.

        try {
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setReadTimeout(30000);
            con.setRequestMethod("POST");
            String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-OCR-SECRET", secretKey);

            JSONObject json = new JSONObject();
            json.put("version", "V2");
            json.put("requestId", UUID.randomUUID().toString());
            json.put("timestamp", System.currentTimeMillis());
            JSONObject image = new JSONObject();
            image.put("format", "jpg");
            image.put("name", "demo");
            JSONArray images = new JSONArray();
            images.add(image); // 수정.
            json.put("images", images);
            String postParams = json.toString();

            con.connect();
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            long start = System.currentTimeMillis();
            File file = new File(imageFile);
            writeMultiPart(wr, postParams, file, boundary); // writeMultiPart :여기서 서버로 전송.
            wr.close();

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer(); // 결과 : response 에 담김

            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine); // response : json(string)이다.
            }
            br.close();
            // while문이 다 돌고 난 뒤에 response로 결과가 담기니까, json을 출력하기 위한 함수 준비하기.
            JSONParser parser = new JSONParser(); // JSONParser : json을 출력하기 위한 함수.
            jobj = (JSONObject) parser.parse( response.toString() ); // json -> jsonObj로 보여주기.

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }


        return jobj; // 최종. 만든 {JSON object 형태이다.} 반환하기.
    }
    
    // 네이버 클라우드에서 제공하는 함수 붙여넣기.
    private static void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
            IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(boundary).append("\r\n");
        sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
        sb.append(jsonMessage);
        sb.append("\r\n");

        out.write(sb.toString().getBytes("UTF-8"));
        out.flush();

        if (file != null && file.isFile()) {
            out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
            StringBuilder fileString = new StringBuilder();
            fileString
                    .append("Content-Disposition:form-data; name=\"file\"; filename=");
            fileString.append("\"" + file.getName() + "\"\r\n");
            fileString.append("Content-Type: application/octet-stream\r\n\r\n");
            out.write(fileString.toString().getBytes("UTF-8"));
            out.flush();

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[8192];
                int count;
                while ((count = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, count);
                }
                out.write("\r\n".getBytes());
            }

            out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
        }
        out.flush();
    }
    // OCR1 : 사업자등록증 인식 기능 만들기. 보여줄 JSONObject 정보를 map으로 한번에 담기
    public static Map getData(JSONObject jobj){
        Map<String, String> map = new HashMap<>();

        //JSONObject result = (JSONObject) OCRUtil.getResult(imgpath, imgname);
        // 꺼내기
        // images : []
        JSONArray images = (JSONArray) jobj.get("images");
        // {}
        JSONObject obj = (JSONObject) images.get(0);
        // fields : []
        JSONArray fields = (JSONArray) obj.get("fields");
        String biznum = "";
        String bizname = "";
        String bizowner = "";
        String bizdate = "";
        String bizadd = "";
        // {}
        JSONObject biznum_obj = (JSONObject) fields.get(0);
        biznum = (String) biznum_obj.get("inferText");

        JSONObject bizname_obj = (JSONObject) fields.get(1);
        bizname = (String) bizname_obj.get("inferText");

        JSONObject bizowner_obj = (JSONObject) fields.get(2);
        bizowner = (String) bizowner_obj.get("inferText");

        JSONObject bizdate_obj = (JSONObject) fields.get(3);
        bizdate = (String) bizdate_obj.get("inferText");

        JSONObject bizadd_obj = (JSONObject) fields.get(4);
        bizadd = (String) bizadd_obj.get("inferText");

        // 하나씩 result 집어넣기.
        map.put("biznum", biznum);
        map.put("bizname", bizname);
        map.put("bizowner", bizowner);
        map.put("bizdate", bizdate);
        map.put("bizadd", bizadd);

        return map;
    }

    // OCR2 : ocr 납부 고지서 인식 기능 만들기
    public static Map getOcr(JSONObject jobj){
        Map<String, String> map = new HashMap<>();

        // 0. images : []
        JSONArray images = (JSONArray) jobj.get("images");
        JSONObject obj2 = (JSONObject) images.get(0); // { 텅 }
        // 1. fields : []
        JSONArray fields = (JSONArray) obj2.get("fields");

        // 2. 꺼낼 값들 초기화 하기.
        String ocrnum = "";
        String amount = "";
        String custnum = "";

        // 3. 1번의 fields의 배열[] 안에 있는 {"name":"ocrnum", ... }, {"name":"ocrnum", ... }, {"name":"ocrnum", ... }
        JSONObject ocrnum_obj = (JSONObject) fields.get(0); // {ocrnum} 은 fields 배열의 0번째에 위치.
        ocrnum = (String) ocrnum_obj.get("inferText"); // 최종.그 0번째 중에서, "inferText" : 값("ocrnum")가져오기.

        JSONObject amount_obj = (JSONObject) fields.get(1); // {amount} 은 fields 배열의 1번째에 위치.
        amount = (String) amount_obj.get("inferText"); // 최종.

        JSONObject custnum_obj = (JSONObject) fields.get(2); // {custnum} 은 fields 배열의 2번째에 위치.
        custnum = (String) custnum_obj.get("inferText"); // 최종.

       

        // 하나씩 result 집어넣기.
        map.put("ocrnum", ocrnum); // "" 이안에 넣은 명칭으로 jsp에서 꺼내기
        map.put("amount", amount);
        map.put("custnum", custnum);

        return map;
    }

}
