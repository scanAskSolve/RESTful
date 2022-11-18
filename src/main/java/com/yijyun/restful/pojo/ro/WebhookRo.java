package com.yijyun.restful.pojo.ro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WebhookRo {

    @JsonProperty("destination")
    private String destination;
    @JsonProperty("events")
    private List<EventsDTO> events;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class EventsDTO {
        @JsonProperty("type")
        private String type;
        @JsonProperty("message")
        private MessageDTO message;
        @JsonProperty("timestamp")
        private Long timestamp;
        @JsonProperty("source")
        private SourceDTO source;
        @JsonProperty("replyToken")
        private String replyToken;
        @JsonProperty("mode")
        private String mode;
        @JsonProperty("webhookEventId")
        private String webhookEventId;
        @JsonProperty("deliveryContext")
        private DeliveryContextDTO deliveryContext;

        @NoArgsConstructor
        @Data
        public static class MessageDTO {
            @JsonProperty("type")
            private String type;
            @JsonProperty("id")
            private String id;
            @JsonProperty("text")
            private String text;
        }

        @NoArgsConstructor
        @Data
        public static class SourceDTO {
            @JsonProperty("type")
            private String type;
            @JsonProperty("userId")
            private String userId;
        }

        @NoArgsConstructor
        @Data
        public static class DeliveryContextDTO {
            @JsonProperty("isRedelivery")
            private Boolean isRedelivery;
        }
    }
}
