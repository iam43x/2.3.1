package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/**")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getUsersList(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/add")
    public String addUserList() {
        return "create";
    }

    @PostMapping("/add")
    public String addUser(WebRequest request, ModelMap modelMap) {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        if (userService.addUser(new User(firstName, lastName))) {
            modelMap.addAttribute("message", "Пользователь добавлен!");
        } else {
            modelMap.addAttribute("message", "Произошла ошибка:(");
        }
        return "create";
    }

    @GetMapping("/updt")
    public String updateUserList(WebRequest request,ModelMap modelMap) {
        try{
            Long id=Long.parseLong(request.getParameter("id"));
            User user=userService.getUserById(id);
            modelMap.addAttribute("user",user);
                return "update";
        }catch (Exception e){
            return "redirect: /";
        }
    }

    @PostMapping("/updt")
    public String updateUser(WebRequest request,ModelMap modelMap){
        try{
            Long id=Long.parseLong(request.getParameter("id"));
            String firstName=request.getParameter("firstName");
            String lastName=request.getParameter("lastName");
            userService.updateUser(firstName,lastName,id);
        }catch (Exception e){

        }
        return "redirect: /";
    }

    @PostMapping("/del")
    public String deleteUser(WebRequest request){
        try{
           Long id= Long.parseLong(request.getParameter("id"));
           userService.deleteUser(id);

        }catch (Exception e){

        }
    return "redirect: /";
    }


}
