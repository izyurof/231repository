import hibernate.config.JavaConfig;
import hibernate.model.User;
import hibernate.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = new User("tr", "Izyurov", (byte) 31, "higher");
        userService.saveUser(user);
////        user.setName("Gena");
//        userService.deleteUser(user);
    }
}
