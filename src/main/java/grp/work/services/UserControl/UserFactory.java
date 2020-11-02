package grp.work.services.UserControl;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class UserFactory {
    private static int cnt = 0;

    public User createUser(String fName, String lName, String phone) {
        return new User(fName, lName, phone, cnt++);
    }

}
