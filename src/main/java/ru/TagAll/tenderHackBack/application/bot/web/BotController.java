package ru.TagAll.tenderHackBack.application.bot.web;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.TagAll.tenderHackBack.application.bot.model.BotSettingDto;
import ru.TagAll.tenderHackBack.application.bot.servcie.BotService;
import ru.TagAll.tenderHackBack.application.bot.servcie.impl.BotServiceImpl;
import ru.TagAll.tenderHackBack.application.common.Endpoints;
import ru.TagAll.tenderHackBack.application.customer.model.SessionDto;
import ru.TagAll.tenderHackBack.swagger.BadRequestSystemError;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = "Контроллер натсройки бота")
public class BotController {

    private final BotServiceImpl botService;

    @BadRequestSystemError
    @PostMapping(value = Endpoints.Bot.START_BOT)
    public void startBot(@PathVariable Long sessionId ) {
         botService.startBot(sessionId);
    }

    @BadRequestSystemError
    @PostMapping(value = Endpoints.Bot.STOP_BOT)
    public void stopBot(@PathVariable Long sessionId ) {
         botService.stopBot(sessionId);
    }

    @BadRequestSystemError
    @PostMapping(value = Endpoints.Bot.CHANGE_DELAY)
    public void changeDelay(@RequestBody Long delay ) {
         botService.changeDelay(delay);
    }

    @BadRequestSystemError
    @PostMapping(value = Endpoints.Bot.SETTING_BOT_SAVE)
    public void settingBotSave(@RequestBody Long sessionId, BotSettingDto botSettingDto) {
          botService.settingBotSave(sessionId, botSettingDto);
    }

    @BadRequestSystemError
    @GetMapping(value = Endpoints.Bot.SETTING_BOT_GET)
    public BotSettingDto settingBotGet(@RequestBody Long sessionId) {
        return botService.settingBotGet(sessionId);
    }



}
