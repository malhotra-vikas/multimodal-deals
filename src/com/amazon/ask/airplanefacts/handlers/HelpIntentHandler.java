package com.amazon.ask.airplanefacts.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class HelpIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.HelpIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "I can tell you all amazing deals. Try saying tell me a deal";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Amazing Deals", speechText)
                .withReprompt(speechText)
                .build();
    }

}
