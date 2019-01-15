package com.amazon.ask.airplanefacts.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static final Logger log = LoggerFactory.getLogger(PropertyReader.class);

    private static PropertyReader propertyReader;
    private String skillName = "";
    private String skillResponseEmailTo= "";
    private String skillResponseEmailFrom= "";
    private String skillResponseEmailFromName= "";

    private boolean propertyRead = false;
    private String fatalError = "";
    private String welcomeMessage = "";
    private String speechHelp = "";
    private String goodBye = "";
    private String speechReprompt= "";
    private String speechSorry = "";
    private String skillId = "";
    private String speechKids = "";
    private String speechTeens = "";
    private String speechAdults = "";
    private String speechShipSize = "";
    private String speechFamilyFriendly = "";
    private String speechEnglish = "";
    private String speechEmail = "";
    private String speechName = "";
    private String speechBudget = "";
    private String speechCruiseLength = "";
    private String speechCruiseDate = "";
    private String speechProgressive = "";
    private String speechDestination = "";
    private String speechPermissionText = "";
    private String speechEmailSubject = "";
    private String speechThanks = "";
    private String speechCatelog = "";
    private String speechShort = "";
    private String speechDidNotUnderstand = "";

    private PropertyReader() {
        Properties skillProperties = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("skill.properties");
            // load a properties file

            skillProperties.load(input);
            skillName = skillProperties.getProperty("skill");
            skillResponseEmailTo= skillProperties.getProperty("skill-response-email-to");
            skillResponseEmailFrom= skillProperties.getProperty("skill-response-email-from");
            skillResponseEmailFromName= skillProperties.getProperty("skill-response-email-from-name");

            speechDidNotUnderstand= skillProperties.getProperty("speech-did-not-understand");
            speechKids= skillProperties.getProperty("speech-kids");
            speechTeens= skillProperties.getProperty("speech-teens");
            speechAdults= skillProperties.getProperty("speech-adults");
            speechShipSize= skillProperties.getProperty("speech-ship-size");
            speechFamilyFriendly= skillProperties.getProperty("speech-family-friendly");
            speechEnglish= skillProperties.getProperty("speech-english");
            speechEmail= skillProperties.getProperty("speech-email");
            speechName= skillProperties.getProperty("speech-name");
            speechBudget= skillProperties.getProperty("speech-budget");
            speechCruiseLength= skillProperties.getProperty("speech-cruise-length");
            speechCruiseDate= skillProperties.getProperty("speech-cruise-date");
            speechProgressive= skillProperties.getProperty("speech-progressive");
            speechDestination= skillProperties.getProperty("speech-destination");
            speechPermissionText= skillProperties.getProperty("speech-permission-text");
            speechEmailSubject= skillProperties.getProperty("speech-email-subject");
            speechThanks= skillProperties.getProperty("speech-thanks");
            speechShort= skillProperties.getProperty("speech-short");
            speechCatelog= skillProperties.getProperty("speech-catelog");
            speechKids = skillProperties.getProperty("speech-kids");

            fatalError = skillProperties.getProperty("speech-fatal-error");
            welcomeMessage = skillProperties.getProperty("speech-welcome");
            speechHelp = skillProperties.getProperty("speech-help");
            goodBye = skillProperties.getProperty("speech-goodbye");
            speechSorry = skillProperties.getProperty("speech-sorry");
            speechReprompt = skillProperties.getProperty("speech-reprompt");
            skillId = skillProperties.getProperty("skill-id");

            propertyRead = true;

            log.info("Coming from LOG 4 J - The skill name is :- " + skillName);

        } catch (IOException ioException) {
             propertyRead = false;
            log.error("Coming from LOG 4 J - Skill Property file not loaded");
        }

    }

    public String getSpeechDidNotUnderstand() {
        return speechDidNotUnderstand;
    }

    public String getSkillId () {
        return skillId;
    }

    public String getSpeechKids() {
        return speechKids;
    }

    public String getSpeechTeens() {
        return speechTeens;
    }

    public String getSpeechAdults() {
        return speechAdults;
    }

    public String getSpeechShipSize() {
        return speechShipSize;
    }

    public String getSpeechFamilyFriendly() {
        return speechFamilyFriendly;
    }

    public String getSpeechEnglish() {
        return speechEnglish;
    }

    public String getSpeechEmail() {
        return speechEmail;
    }

    public String getSpeechName() {
        return speechName;
    }

    public String getSpeechBudget() {
        return speechBudget;
    }

    public String getSpeechCruiseLength() {
        return speechCruiseLength;
    }

    public String getSpeechCruiseDate() {
        return speechCruiseDate;
    }

    public String getSpeechProgressive() {
        return speechProgressive;
    }

    public String getSpeechDestination() {
        return speechDestination;
    }

    public String getSpeechPermissionText() {
        return speechPermissionText;
    }

    public String getSpeechEmailSubject() {
        return speechEmailSubject;
    }

    public String getSpeechReprompt () {
        return speechReprompt;
    }

    public String getSpeechSorry () {
        return speechSorry;
    }

    public String getGoodBye () {
        return goodBye;
    }

    public String getSpeechHelp () {
        return speechHelp;
    }

    public String getFatalError () {
        return fatalError;
    }

    public String getWelcomeMessage () {
        return welcomeMessage;
    }

    public boolean isPropertyRead () {
        return propertyRead;
    }

    public String getSkillName () {
        return skillName;
    }

    public String getSpeechThanks() {
        return speechThanks;
    }

    public String getSpeechCatelog() {
        return speechCatelog;
    }

    public String getSpeechShort() {
        return speechShort;
    }

    public String getSkillResponseEmailTo () {
        return skillResponseEmailTo;
    }
    public String getSkillResponseEmailFrom () {
        return skillResponseEmailFrom;
    }
    public String getSkillResponseEmailFromName () {
        return skillResponseEmailFromName;
    }


    public static PropertyReader getPropertyReader () {
        if (propertyReader == null) {
            propertyReader = new PropertyReader();
        }
        return propertyReader;
    }

}
