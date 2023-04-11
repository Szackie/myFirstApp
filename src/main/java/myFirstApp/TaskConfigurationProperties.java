package myFirstApp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("task")
public class TaskConfigurationProperties {
    private Template template;

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public static class Template{
        private boolean AllowMultipleTasks;

        public boolean isAllowMultipleTasks() {
            return AllowMultipleTasks;
        }

        public void setAllowMultipleTasks(boolean allowMultipleTasks) {
            AllowMultipleTasks = allowMultipleTasks;
        }
    }

}
