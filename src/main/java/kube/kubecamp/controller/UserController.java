package kube.kubecamp.controller;


import kube.kubecamp.data.dto.UserInfoDto;
import kube.kubecamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");

    }
    @GetMapping("/user/{userid}")
    public UserInfoDto getUser(@PathVariable("userid") String userId){
        return userService.getUser(userId);
    }

    @PostMapping("/user")
    public UserInfoDto createUser(@Valid @RequestBody UserInfoDto userInfoDto){

        String userId = userInfoDto.getUserId();
        String userName = userInfoDto.getUserName();
        String email = userInfoDto.getEmail();
        boolean isDeleted = userInfoDto.isDeleted();

        return userService.saveUser(userId,userName,email,isDeleted);
    }

}
