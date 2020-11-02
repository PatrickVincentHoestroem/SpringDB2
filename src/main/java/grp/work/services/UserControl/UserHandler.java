package grp.work.services.UserControl;

public class UserHandler {
    private UserFactory userFactory;
    private UserContainer userContainer;

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
