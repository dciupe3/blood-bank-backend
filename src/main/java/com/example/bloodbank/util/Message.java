package com.example.bloodbank.util;

import lombok.Getter;

@Getter
public class Message {
    private String email;
    private String number;
    private String text;

    private Message(Builder builder) {
        this.email = builder.email;
        this.number = builder.number;
        this.text = builder.text;
    }

    public static class Builder {
        private String email;
        private String number;
        private String text;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
