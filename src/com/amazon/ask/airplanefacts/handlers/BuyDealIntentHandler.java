package com.amazon.ask.airplanefacts.handlers;

import com.amazon.ask.airplanefacts.util.FactsUtil;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.*;

import java.util.*;

import static com.amazon.ask.request.Predicates.intentName;

public class BuyDealIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("BuyIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {


        String title = "Amazing Deals";
        String primaryText = "Thanks for your interest. You will soon get a link to the deal in your email as well as on your phone as a text.";
        //FIXME: If you would like to display additional text, please set the secondary text accordingly
        String secondaryText = "";
        String speechText = "<speak> " + primaryText + "<break time=\"1s\"/>  You can say Next Deal, if you wish to see another say Next Deal" + " </speak>";

        Image barcodeImage = FactsUtil.getImage("http://www.totalcustomsolutions.com/wp-content/uploads/2014/01/qr-code-sample.png");
        String backgroundImageURL = "https://s3.amazonaws.com/dealsskillassets/main_background_transparent.png";

        Image backgroundImage = FactsUtil.getImage(backgroundImageURL);

        Template template = FactsUtil.getBodyTemplate3(primaryText, secondaryText, backgroundImage, title, barcodeImage);

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
