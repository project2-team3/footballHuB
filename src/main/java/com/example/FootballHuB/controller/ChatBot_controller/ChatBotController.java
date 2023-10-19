package com.example.FootballHuB.controller.ChatBot_controller;

import com.example.FootballHuB.dto.ChatGpt_dto.ChatGptRequest;
import com.example.FootballHuB.dto.ChatGpt_dto.ChatGptResponse;
import com.example.FootballHuB.dto.ChatGpt_dto.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Pattern;


@RestController
//@RequestMapping("/bot")
public class ChatBotController {

    @Value("${openai.api.model}")
    private String model;

    @Value("${openai.api.url}")
    private  String apiUrl;

    @Autowired
    private RestTemplate template;


    @GetMapping("/ChatBot")
    public ModelAndView chat(){
        ModelAndView ma = new ModelAndView("ChatBot");
        return ma;
    }


    @PostMapping("/ChatBot")
    public String fromHtmlMessage(@RequestBody String requestMessage) {
        try {
            String userMessage = URLDecoder.decode(requestMessage, "UTF-8");
            System.out.println(userMessage);

            ChatGptRequest request = new ChatGptRequest(model, userMessage);
            ChatGptResponse chatGptResponse = template.postForObject(apiUrl, request, ChatGptResponse.class);
            assert chatGptResponse != null;

            String GptResponse_content = chatGptResponse.getChoices().get(0).getMessage().getContent();

            // GPT의 응답형태 (JSON/String)에 따른 처리
            String regex = "\\{\"message\":.*\\}";
            if (Pattern.matches(regex, GptResponse_content)) {

                ObjectMapper objectMapper = new ObjectMapper(); // JSON 파싱을 위한 ObjectMapper
                JsonNode jsonResponse = objectMapper.readTree(GptResponse_content); // GPT 모델의 응답 JSON을 파싱
                String responseMessage = jsonResponse.get("message").asText();  // "message" 키의 값을 가져와 반환

                return "{ \"response\" : \"" + responseMessage + "\" }";
            } else {
                GptResponse_content = GptResponse_content.replace(":", "|");
                GptResponse_content = GptResponse_content.replace("\"", "\\\"");
                GptResponse_content = GptResponse_content.replace("\n", "\\n");
                GptResponse_content = GptResponse_content.replace("\r", "\\r");
                GptResponse_content = GptResponse_content.replace("\t", "\\t");

                return "{ \"response\" : \"" + GptResponse_content + "\" }";
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
