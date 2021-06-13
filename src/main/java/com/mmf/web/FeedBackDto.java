package com.mmf.web;


import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public class FeedBackDto {
    private String message;

    private MultipartFile multipartFile;

    public FeedBackDto(String message, MultipartFile multipartFile) {
        this.message = message;
        this.multipartFile = multipartFile;
    }

    public FeedBackDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedBackDto that = (FeedBackDto) o;
        return Objects.equals(message, that.message) && Objects.equals(multipartFile, that.multipartFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, multipartFile);
    }

    @Override
    public String toString() {
        return "FeedBackDto{" +
                "message='" + message + '\'' +
                ", multipartFile=" + multipartFile +
                '}';
    }
}
