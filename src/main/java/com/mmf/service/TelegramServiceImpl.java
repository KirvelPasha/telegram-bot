package com.mmf.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

@Component
public class TelegramServiceImpl extends TelegramLongPollingBot implements TelegramService {
    @Value("${bot.name}")
    private String botUserName;

    @Value("${bot.token}")
    private String botToken;

    @Value("${bot.chat-id}")
    private String chatId;

    @Autowired
    public TelegramServiceImpl() {

    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void sendFeedBack(String message, MultipartFile multipartFile) {
        try {
            SendMessage sendMessage = new SendMessage(chatId, message);
            execute(sendMessage);
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(chatId);
            sendPhoto.setPhoto("feedback", multipartFile.getInputStream());
            execute(sendPhoto);
        } catch (TelegramApiException | IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update != null && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String message = "mock message";
            try {
                execute(new SendMessage(String.valueOf(chatId), message));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
    }

}

