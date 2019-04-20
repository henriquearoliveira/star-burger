package com.startup.burger.exceptions;

import java.time.LocalDateTime;

public class ErrorDetail {

    private String title;
    private int status;
    private String detail;
    private LocalDateTime timestamp;
    private String developerMessage;

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    private ErrorDetail(Builder builder) {
        this.title = builder.title;
        this.status = builder.status;
        this.detail = builder.detail;
        this.timestamp = builder.timestamp;
        this.developerMessage = builder.developerMessage;
    }

    public static class Builder {

        private String title;
        private int status;
        private String detail;
        private LocalDateTime timestamp;
        private String developerMessage;

        public Builder() {
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setStatus(int status) {
            this.status = status;
            return this;
        }

        public Builder setDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setDeveloperMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ErrorDetail build() {
            return new ErrorDetail(this);
//            ErrorDetails errorDetails = new ErrorDetails();
//            errorDetails.setTitle(title);
//            errorDetails.setStatus(status);
//            errorDetails.setDetail(detail);
//            errorDetails.setTimestamp(timestamp);
//            errorDetails.setDeveloperMessage(developerMessage);
//            return errorDetails;
        }
    }
}
