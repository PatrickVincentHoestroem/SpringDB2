package grp.work.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import grp.work.services.UserControl.User;
import grp.work.services.UserControl.UserHandler;

import java.util.ArrayList;
import java.util.List;

/*
* So this was a hassle...
*
* Important pointers:
*   + Always put controller classes into a controller package
*   + Use FileSystemXmlApplicationContext for absolute path to bean-config.xml that is placed in the root folder
*   + You don't have to use 'model.addAttribute()' inside a method, you can call '@ModelAttribute("<attr-name>")' on
*       method and its return statement is put into the model. The method is also called before any Mapping method.
*/

@Controller
public class AppController {
    private static final String ctxPath = "C:\\Users\\patri\\IdeaProjects\\Sem02\\SpringDB2\\src\\main\\java\\grp\\work\\bean-config.xml";
    private static final ApplicationContext ctx = new FileSystemXmlApplicationContext(ctxPath);
    private final UserHandler userHandler;

    public AppController() {
        userHandler = (UserHandler) ctx.getBean("userHandler");
    }
    @ModelAttribute("users")
    public List<User> addUsers() {
        userHandler.createUser("Lars", "Helmig", "65123476");
        userHandler.createUser("Kasper", "Larsen", "21658734");
        userHandler.createUser("Kim", "Jørgensen", "23674598");
        userHandler.createUser("Kurt", "Vestergård", "45764367");
        return userHandler.getContainer();
    }
    @ModelAttribute
    public void addTexts(final Model model) {
        List<String> texts = new ArrayList<>();
        texts.add("Hello");
        texts.add("World");
        texts.add("Again");
        model.addAttribute("texts", texts);
    }
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
