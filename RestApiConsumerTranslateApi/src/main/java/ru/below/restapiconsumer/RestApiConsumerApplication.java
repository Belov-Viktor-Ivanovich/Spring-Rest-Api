package ru.below.restapiconsumer;

import net.minidev.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class RestApiConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(RestApiConsumerApplication.class, args);
        RestTemplate restTemplate = new RestTemplate();
        /*Map<String,String>jsonToSend = new HashMap<>();
        jsonToSend.put("name","testName");
        jsonToSend.put("age","testAge");

        HttpEntity<Map<String,String>> request = new HttpEntity<>(jsonToSend);

        String url = "https://reqres.in/api/users";
        var response =  restTemplate.getForObject(url, String.class);
        var responce2 = restTemplate.postForObject(url, request, Map.class);
        System.out.println(response);
        System.out.println("////////////////////////");
        System.out.println(responce2);*/
        var textToTranslate = "Hello";
        var url = "https://fasttranslator.onrender.com/api/v1/text/to/text?source="+textToTranslate+"&lang=en-ru";
        JSONObject jsonObject = restTemplate.getForObject(url, JSONObject.class);
        System.out.println(jsonObject.get("data"));
        /*var response =  restTemplate.getForObject(url, String.class);
        System.out.println(response);*/



    }

}
