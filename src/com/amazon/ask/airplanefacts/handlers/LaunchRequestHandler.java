package com.amazon.ask.airplanefacts.handlers;

import com.amazon.ask.airplanefacts.util.FactsUtil;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.model.interfaces.display.*;
import com.amazon.ask.model.services.directive.Directive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

public class LaunchRequestHandler implements RequestHandler {

    private static final Logger log = LoggerFactory.getLogger(LaunchRequestHandler.class);

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        String title = "Amazing Deals";
        String primaryText = "Welcome to the Amazing Deals.";
        String secondaryText = "Would you like to hear about a deal?";
        String speechText = "Welcome to Amazing Deals. I have all the amazing deals that you would love to know about. " +
                "Would you like to hear a deal?";
        String backgroundImageURL = "https://s3.amazonaws.com/dealsskillassets/background_300.jpg";

        Image backgroundImage = FactsUtil.getImage(backgroundImageURL);

        //Template template = getBodyTemplate6(primaryText, secondaryText, image);
        Template template = FactsUtil.getBodyTemplate3(primaryText, secondaryText, backgroundImage, title, null);

        SupportedInterfaces supportedInterfaces = input.getRequestEnvelope().getContext().getSystem().getDevice().getSupportedInterfaces();
        log.error("supportedInterfaces     " + supportedInterfaces.toString());
        log.error("supportedInterfaces     " + supportedInterfaces.getDisplay());

        //log.error("getTemplateVersion   " + supportedInterfaces.getDisplay().getTemplateVersion());

        // Device supports display interface
        if(null!=input.getRequestEnvelope().getContext().getDisplay()) {
            return input.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(title, speechText)
                    .addRenderTemplateDirective(template)
                    .withReprompt(speechText)
                    .build();
        } else {
            //Headless device
            return input.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(title, speechText)
                    .withReprompt(speechText)
                    .build();
        }
    }
}
