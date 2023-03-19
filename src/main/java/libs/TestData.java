package libs;

import org.aeonbits.owner.ConfigFactory;

public class TestData {
    public static ConfigHiddenProperties configHiddenProperties = ConfigFactory.create(ConfigHiddenProperties.class);
    public final static String VALID_LOGIN = System.getProperty("login", configHiddenProperties.login());
    public final static String VALID_PASSWORD = System.getProperty("password", configHiddenProperties.password());

    public final static String NAME_OF_USER = System.getProperty("nameOfUser", configHiddenProperties.nameOfUser());
    public final static String OCCUPATION_TEXT = System.getProperty("occupationText", configHiddenProperties.occupationText());

    public final static String EXIST_LOGIN = System.getProperty("existLogin", configHiddenProperties.existLogin());

    public final static String TOPIC_TEXT = System.getProperty("topicText", configHiddenProperties.topicText());
    public final static String MESSAGE_TEXT = System.getProperty("messageText", configHiddenProperties.messageText());


}
