package grp.work.services.UserControl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class UserHandler {
    private final UserFactory userFactory;
    private final UserContainer userContainer;

    public UserHandler(UserFactory userFactory, UserContainer userContainer) {
        this.userFactory = userFactory;
        this.userContainer = userContainer;
    }

    public void createUser(String fName, String lName, String phone) {
        User user = userFactory.createUser(fName, lName, phone);
        userContainer.add(user);
    }

    public void deleteUser(User user) {
        userContainer.remove(user);
    }

    public void deleteUser(int id) {
        userContainer.remove(id);
    }

    public UserContainer getContainer() {
        return userContainer;
    }
}
