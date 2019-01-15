package com.amazon.ask.airplanefacts.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Permissions;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.*;
import com.amazon.ask.model.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazon.speech.ui.AskForPermissionsConsentCard;

import java.util.*;

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
        String imageUrl = "https://s3.amazonaws.com/ask-samples-resources/images/background-image.jpg";

        Image image = getImage(imageUrl);

        Template template = getBodyTemplate6(primaryText, secondaryText, image);
        Session session = input.getRequestEnvelope().getSession();

        Permissions permissions = session.getUser().getPermissions();
        log.error("-------------------------111111111111111111111");
        if (permissions == null) {
            log.error("-------------------------22222222222222222222222");

            List<String> permissionsList = new ArrayList<>();
            permissionsList.add("alexa::profile:name:read`");
            permissionsList.add("alexa::profile:email:read");

            AskForPermissionsConsentCard askForPermissionsConsentCard = new AskForPermissionsConsentCard();
            log.error("The user hasn't authorized the skill. Sending a permissions card.");
            speechText = "You have not given this skill permissions to access your details. " +
                    "Using the Alexa App on your phone, please give this skill permissions to access your name and email address.";

            log.error("-------------------------333333333333333333333333333");

            if(null!=input.getRequestEnvelope().getContext().getDisplay()) {
                log.error("-------------------------44444444444444444444");

                return input.getResponseBuilder()
                        .withSpeech(speechText)
                        .withSimpleCard(title, speechText)
                        .addRenderTemplateDirective(template)
                        //.withAskForPermissionsConsentCard(permissionsList)
                        .withReprompt(speechText)
                        .build();

            } else {
                //Headless device
                return input.getResponseBuilder()
                        .withSimpleCard("Missing Permissions", speechText)
                        .withSpeech(speechText)
                        .withAskForPermissionsConsentCard(permissionsList)
                        .build();
            }

        }

        // Device supports display interface
        if(null!=input.getRequestEnvelope().getContext().getDisplay()) {
            return displayResponse(input, speechText, title, template);
        } else {
            //Headless device
            return input.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(title, speechText)
                    .withReprompt(speechText)
                    .build();
        }
    }

    private Optional<Response> displayResponse (HandlerInput input, String speechText, String title, Template template) {
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard(title, speechText)
                .addRenderTemplateDirective(template)
                .withReprompt(speechText)
                .build();
    }

    /**
     * Helper method to create a body template 6
     * @param primaryText the primary text to be displayed in the template on the show
     * @param secondaryText the secondary text to be displayed in the template on the show
     * @param image  the url of the image
     * @return Template
     */
    private Template getBodyTemplate6(String primaryText, String secondaryText, Image image) {
        return BodyTemplate6.builder()
                .withBackgroundImage(image)
                .withTextContent(getTextContent(primaryText, secondaryText))
                .build();
    }

    /**
     * Helper method to create the image object for display interfaces
     * @param imageUrl the url of the image
     * @return Image that is used in a body template
     */
    private Image getImage(String imageUrl) {
        List<ImageInstance> instances = getImageInstance(imageUrl);
        return Image.builder()
                .withSources(instances)
                .build();
    }

    /**
     * Helper method to create List of image instances
     * @param imageUrl the url of the image
     * @return instances that is used in the image object
     */
    private List<ImageInstance> getImageInstance(String imageUrl) {
        List<ImageInstance> instances = new ArrayList<>();
        ImageInstance instance = ImageInstance.builder()
                .withUrl(imageUrl)
                .build();
        instances.add(instance);
        return instances;
    }

    /**
     * Helper method that returns text content to be used in the body template.
     * @param primaryText
     * @param secondaryText
     * @return RichText that will be rendered with the body template
     */
    private TextContent getTextContent(String primaryText, String secondaryText) {
        return TextContent.builder()
                .withPrimaryText(makeRichText(primaryText))
                .withSecondaryText(makeRichText(secondaryText))
                .build();
    }

    /**
     * Helper method that returns the rich text that can be set as the text content for a body template.
     * @param text The string that needs to be set as the text content for the body template.
     * @return RichText that will be rendered with the body template
     */
    private RichText makeRichText(String text) {
        return RichText.builder()
                .withText(text)
                .build();
    }
}
