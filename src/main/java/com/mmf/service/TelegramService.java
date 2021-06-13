package com.mmf.service;

import org.springframework.web.multipart.MultipartFile;

public interface TelegramService {
    void sendFeedBack(String message, MultipartFile multipartFile);
}
