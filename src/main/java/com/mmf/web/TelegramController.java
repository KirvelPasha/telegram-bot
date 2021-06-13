package com.mmf.web;

import com.mmf.service.TelegramService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/feedback")
public class TelegramController {

    private final TelegramService telegramService;

    @Autowired
    public TelegramController(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @PostMapping
    public ResponseEntity<Void> sendFeedBack(@RequestPart("message") String message, @RequestPart("multipartFile") MultipartFile multipartFile) {
        telegramService.sendFeedBack(message, multipartFile);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
