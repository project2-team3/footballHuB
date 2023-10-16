package com.example.FootballHuB.controller.ChatBot_controller;

import com.example.FootballHuB.dto.ChatGpt_dto.ChatGptRequest;
import com.example.FootballHuB.dto.ChatGpt_dto.ChatGptResponse;
import com.example.FootballHuB.dto.ChatGpt_dto.Message;
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

            // 대화에서 이스케이프 처리합니다.
            userMessage = userMessage.replace("\"", "\\\"");
            userMessage = userMessage.replace("\n", "\\n");
            userMessage = userMessage.replace("\r", "\\r");
            userMessage = userMessage.replace("\\r", "\\\r");
            userMessage = userMessage.replace("\t", "\\t");

            ChatGptRequest request = new ChatGptRequest(model, userMessage);
            ChatGptResponse chatGptResponse = template.postForObject(apiUrl, request, ChatGptResponse.class);
            assert chatGptResponse != null;

            System.out.println(chatGptResponse.getChoices().get(0).getMessage().getContent());
            return "{ \"response\" : \"" + chatGptResponse.getChoices().get(0).getMessage().getContent() + "\" }";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
