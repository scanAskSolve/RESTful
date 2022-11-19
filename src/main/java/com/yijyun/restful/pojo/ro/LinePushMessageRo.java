package com.yijyun.restful.pojo.ro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
public class LinePushMessageRo {

    @NotNull
    @JsonProperty("to")
    private String to;
    @NotNull
    @JsonProperty("messages")
    private List<MessagesDTO> messages;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<MessagesDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessagesDTO> messages) {
        this.messages = messages;
    }

    @NoArgsConstructor
    public static class MessagesDTO {
        @JsonProperty("type")
        private String type;
        @JsonProperty("text")
        private String text;
        @JsonProperty("packageId")
        private String packageId;
        @JsonProperty("stickerId")
        private String stickerId;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getPackageId() {
            return packageId;
        }

        public void setPackageId(String packageId) {
            this.packageId = packageId;
        }

        public String getStickerId() {
            return stickerId;
        }

        public void setStickerId(String stickerId) {
            this.stickerId = stickerId;
        }
    }
}
