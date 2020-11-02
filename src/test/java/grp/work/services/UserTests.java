package grp.work.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import grp.work.services.UserControl.User;
import grp.work.services.UserControl.UserContainer;
import grp.work.services.UserControl.UserFactory;
import grp.work.services.UserControl.UserHandler;

class UserTests {

    private UserHandler userHandler;
    private UserContainer userContainer;
    private UserFactory userFactory;

    @Test
    public void user_checkIds() {
        User user01 = new User("Lars", "Helmig", "65123476", 0);
        User user02 = new User("Kasper", "Larsen", "21658734", 1);
        User user03 = new User("Kim", "Jørgensen", "23674598", 2);
        User user04 = new User("Kurt", "Vestergård", "45764367", 3);
        Assertions.assertEquals(0, user01.getId());
        Assertions.assertEquals(1, user02.getId());
        Assertions.assertEquals(2, user03.getId());
        Assertions.assertEquals(3, user04.getId());
    }

    @Test
    public void factory_createSingleUser() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("C:\\Users\\patri\\IdeaProjects\\Sem02\\SpringDB2\\src\\main\\java\\grp\\work\\bean-config.xml");
        userFactory = (UserFactory) ctx.getBean("userFactory");
        User user = userFactory.createUser("Lars", "Helmig", "65123476");
        Assertions.assertEquals(0, user.getId());
        Assertions.assertEquals("Lars", user.getFirstname());
        Assertions.assertEquals("Helmig", user.getLastname());
        Assertions.assertEquals("65123476", user.getPhone());
    }

    @Test
    public void handler() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("C:\\Users\\patri\\IdeaProjects\\Sem02\\SpringDB2\\src\\main\\java\\grp\\work\\bean-config.xml");
        userHandler = (UserHandler) ctx.getBean("userHandler");
        userHandler.createUser("Lars", "Helmig", "65123476");
        userHandler.createUser("Kasper", "Larsen", "21658734");
        userHandler.createUser("Kim", "Jørgensen", "23674598");
        userHandler.createUser("Kurt", "Vestergård", "45764367");
        userHandler.deleteUser(0);
        Assertions.assertEquals(3, userHandler.getContainer().getList().size());
        Assertions.assertEquals(1, userHandler.getContainer().get(0).getId());
        Assertions.assertEquals("Kasper", userHandler.getContainer().get(0).getFirstname());
        Assertions.assertEquals("Larsen", userHandler.getContainer().get(0).getLastname());
        Assertions.assertEquals("21658734", userHandler.getContainer().get(0).getPhone());
    }
}