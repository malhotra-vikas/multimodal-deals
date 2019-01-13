package com.amazon.ask.airplanefacts;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.airplanefacts.handlers.*;

public class AirplaneFactsStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
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
