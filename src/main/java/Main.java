import hibernate.config.JavaConfig;
import hibernate.model.User;
import hibernate.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = new User("Andry", "Izyurov", (byte) 31, "higher");
        userService.saveUser(user);
    }
}
