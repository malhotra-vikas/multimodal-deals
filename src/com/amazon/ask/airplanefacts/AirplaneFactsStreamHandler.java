package com.amazon.ask.airplanefacts;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.airplanefacts.handlers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AirplaneFactsStreamHandler extends SkillStreamHandler {

    private static final Logger log = LoggerFactory.getLogger(AirplaneFactsStreamHandler.class);

    private static Skill getSkill() {
        log.debug("in getSkill");

        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new FactIntentHandler(),
                        new BuyDealIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new FallBackIntentHandler())
                // Add your skill id below and uncomment to enable skill ID verification
                .withSkillId("amzn1.ask.skill.3c9a3519-1cb1-4630-b7ef-447044eb871a")
                .build();
    }

    public AirplaneFactsStreamHandler() {
        super(getSkill());
    }

}
