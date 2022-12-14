package com.yijyun.restful.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yijyun.restful.model.MessageItem;
import com.yijyun.restful.pojo.ro.LinePushMessageRo;
import com.yijyun.restful.pojo.ro.PushMessageRo;
import com.yijyun.restful.pojo.ro.WebhookEventRo;
import com.yijyun.restful.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class LineService {

    @Value("${message_push}")
    String pushApi;

    @Value("${channel_access_token}")
    String channelAccessToken;
    @Autowired
    MessageRepository messageRepository;

    public void lineEvent(WebhookEventRo webhookEventRo) {
        for (WebhookEventRo.EventsDTO eventsDTO : webhookEventRo.getEvents()) {
            if (Objects.equals(eventsDTO.getMessage().getType(), "text")) {
                MessageItem messageItem = new MessageItem(eventsDTO.getSource().getUserId(), eventsDTO.getMessage().getText(),Long.toString(eventsDTO.getTimestamp()));
                messageRepository.insert(messageItem);
            }
        }
    }

    public void pushMessage(PushMessageRo pushMessageRo) {
        LinePushMessageRo linePushMessageRo = pushMessageToLine(pushMessageRo);
        Gson gson = new Gson();
        try {
            String respond = callApiPost(pushApi, gson.toJson(linePushMessageRo, LinePushMessageRo.class));
            System.out.println(respond);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private LinePushMessageRo pushMessageToLine(PushMessageRo pushMessageRo) {
        List<LinePushMessageRo.MessagesDTO> messagesDTOList = new ArrayList<>();
        LinePushMessageRo.MessagesDTO messagesDTO = new LinePushMessageRo.MessagesDTO();
        messagesDTO.setType("text");
        messagesDTO.setText(pushMessageRo.getMessage());
        messagesDTOList.add(messagesDTO);

        LinePushMessageRo linePushMessageRo = new LinePushMessageRo();
        linePushMessageRo.setTo(pushMessageRo.getUserId());
        linePushMessageRo.setMessages(messagesDTOList);
        return linePushMessageRo;
    }

    private String callApiPost(String api, String json) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(api);

        StringEntity entity = new StringEntity(json, "UTF-8");
        httpPost.setEntity(entity);

        httpPost.setHeader("Content-type", "application/json; charset=UTF-8");
        httpPost.setHeader("Authorization", "Bearer " + channelAccessToken);
        CloseableHttpResponse response = client.execute(httpPost);
        return EntityUtils.toString(response.getEntity());
    }
    public String getHistory(String userId,Integer size){
        List<MessageItem> messageItem =  messageRepository.findMessageItemByUserId(userId,size);
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<MessageItem>>(){}.getType();
        return gson.toJson(messageItem, listType);
    }
}
