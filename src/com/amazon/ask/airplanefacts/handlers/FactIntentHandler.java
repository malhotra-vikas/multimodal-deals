package com.amazon.ask.airplanefacts.handlers;

import com.amazon.ask.airplanefacts.util.FactsUtil;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static com.amazon.ask.request.Predicates.intentName;

public class FactIntentHandler implements RequestHandler {
    private static final Logger log = LoggerFactory.getLogger(FactIntentHandler.class);

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("FactIntent").or(intentName("AMAZON.YesIntent")));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        Map<String, String> facts = FactsUtil.getFactMap();
        Map<String, String> dealImages = FactsUtil.getImageMap();
        List<String> keys = FactsUtil.getKeys();
        Map<String, String> dealLandingPages = FactsUtil.getDealsLangingPage();

        if (keys.size() <= 0) {
            keys = FactsUtil.getKeys();
        }

        int index = new Random().nextInt(keys.size());
        String key = keys.get(index);
        keys.remove(index);

        String title = "Amazing Deals";
        String primaryText = facts.get(key);
        //FIXME: If you would like to display additional text, please set the secondary text accordingly
        String secondaryText = "XXXYYY";
        String speechText = "<speak> " + primaryText + "<break time=\"1s\"/>  Do you wish to buy this deal? Of you could say Next Deal" + " </speak>";
        String dealImageUrl = dealImages.get(key);
        String dealLandingPageURL = dealLandingPages.get(key);

        Image dealImage = FactsUtil.getImage(dealImageUrl);
        String backgroundImageURL = "https://s3.amazonaws.com/dealsskillassets/deal_background_Transparent.png";
        Image backgroundImage = FactsUtil.getImage(backgroundImageURL);

        log.error(" in FactIntentHandler - title " + title);
        log.error(" in FactIntentHandler - primary Text " + primaryText);
        log.error(" in FactIntentHandler - secondary Text " + secondaryText);
        log.error(" in FactIntentHandler - image URL  " + dealImageUrl);
        log.error(" in FactIntentHandler - Landing page URL  " + dealLandingPageURL);

        //Template template = getBodyTemplate3(title, primaryText, secondaryText, image);
        Template template = FactsUtil.getBodyTemplate3(primaryText, secondaryText, backgroundImage, title, dealImage);

        // Device supports display interface
        if(null!=input.getRequestEnvelope().getContext().getDisplay()) {
            return input.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(title, primaryText)
                    .addRenderTemplateDirective(template)
                    .withReprompt(speechText)
                    .build();
        } else {
            // Headless device
            return input.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(title, primaryText)
                    .withReprompt(speechText)
                    .build();
        }
    }



}
