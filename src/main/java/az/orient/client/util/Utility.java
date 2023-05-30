package az.orient.client.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Utility {

    public String sendGet(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
        return responseEntity.getBody();
    }

    public String sendPost(String url,String data) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");
        headers.add("Accept","application/json");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url,new HttpEntity<>(data,headers),String.class);
        return responseEntity.getBody();
    }

}
