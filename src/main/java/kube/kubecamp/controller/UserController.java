package kube.kubecamp.controller;


import kube.kubecamp.data.dto.UserInfoDto;
import kube.kubecamp.service.UserService;
import kube.kubecamp.service.impl.PingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger; // 인터페이스로 slf4j를 사용함
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    PingServiceImpl pingService = new PingServiceImpl();
    int num = pingService.getOption();

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

//    @ModelAttribute
//    public void setResponseHeader(HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin","*");
//
//    }
    @GetMapping("/user/{userid}")
    public UserInfoDto getUser(@PathVariable("userid") String userId){
//
//        if(num==0){
//            log.info("num0000");
//            return userService.getUser(userId);
//
//        }
//        else{
//            log.info("ELSE ELSE ELES");
//            return userService.getUsers(userId);
//        }
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
