package com.yijyun.restful.pojo.ro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class WebhookEventRo {

    @NotNull(message = "Parameters are required.")
    @JsonProperty("destination")
    private String destination;
    @NotNull(message = "Parameters are required.")
    @JsonProperty("events")
    private List<EventsDTO> events;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<EventsDTO> getEvents() {
        return events;
    }

    public void setEvents(List<EventsDTO> events) {
        this.events = events;
    }

    @NoArgsConstructor
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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public MessageDTO getMessage() {
            return message;
        }

        public void setMessage(MessageDTO message) {
            this.message = message;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public SourceDTO getSource() {
            return source;
        }

        public void setSource(SourceDTO source) {
            this.source = source;
        }

        public String getReplyToken() {
            return replyToken;
        }

        public void setReplyToken(String replyToken) {
            this.replyToken = replyToken;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }

        public String getWebhookEventId() {
            return webhookEventId;
        }

        public void setWebhookEventId(String webhookEventId) {
            this.webhookEventId = webhookEventId;
        }

        public DeliveryContextDTO getDeliveryContext() {
            return deliveryContext;
        }

        public void setDeliveryContext(DeliveryContextDTO deliveryContext) {
            this.deliveryContext = deliveryContext;
        }

        @NoArgsConstructor
        public static class MessageDTO {
            @JsonProperty("type")
            private String type;
            @JsonProperty("id")
            private String id;
            @JsonProperty("text")
            private String text;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }


        @NoArgsConstructor
        public static class SourceDTO {
            @JsonProperty("type")
            private String type;
            @JsonProperty("userId")
            private String userId;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }
        }

        @NoArgsConstructor
        public static class DeliveryContextDTO {
            @JsonProperty("isRedelivery")
            private Boolean isRedelivery;

            public Boolean getRedelivery() {
                return isRedelivery;
            }

            public void setRedelivery(Boolean redelivery) {
                isRedelivery = redelivery;
            }
        }
    }
}
