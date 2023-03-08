package libs;

import org.aeonbits.owner.ConfigFactory;

public class TestData {
    public static ConfigHiddenProperties configHiddenProperties = ConfigFactory.create(ConfigHiddenProperties.class);
    public final static String VALID_LOGIN = System.getProperty("bengamin_franklin@i.ua", configHiddenProperties.login());
    public final static String VALID_PASSWORD = System.getProperty("htZctym2220", configHiddenProperties.password());

    public final static String NAME_OF_USER = System.getProperty("[ Dyad'ko Ben ]", configHiddenProperties.nameOfUser());
    public final static String OCCUPATION_TEXT = System.getProperty("test engineer", configHiddenProperties.occupationText());

}
