package libs;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:./src/main/java/resources/hiddenConfig.properties")   // link на hiddenConfig.properties - файл
public interface ConfigHiddenProperties extends Config {
    String login();
    String password();

    String nameOfUser();
    String occupationText();

    String existLogin();
}
