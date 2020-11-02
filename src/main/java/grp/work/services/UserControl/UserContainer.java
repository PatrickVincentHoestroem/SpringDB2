package grp.work.services.UserControl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("singleton")
public class UserContainer extends ArrayList<User> {

    public User getById(int input_id) {
        // Iterate all items and check if item 'id' is same as 'input_id'
        for (int i = 0; i < size(); i++) {
            if (get(i).getId() == input_id) {
                return get(i);
            }
        }
        return null;
    }
}
