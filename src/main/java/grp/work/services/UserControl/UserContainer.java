package grp.work.services.UserControl;

import java.util.ArrayList;
import java.util.Comparator;

public class UserContainer {
    private ArrayList<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public void remove(User user) {
        users.remove(user);
    }

    public void remove(int id) {
        User user = getById(id);
        remove(user);
    }

    public User get(int index) {
        return users.get(index);
    }

    public User getById(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return users.get(i);
            }
        }
        return null;
    }

    public ArrayList<User> getList() {
        return users;
    }

    public void sort(Comparator comparator) {
        users.sort(comparator);
    }
}
