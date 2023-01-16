package kube.kubecamp.service.impl;


import kube.kubecamp.data.dto.UserInfoDto;
import kube.kubecamp.data.entity.UserEntity;
import kube.kubecamp.data.handler.UserDataHandler;
import kube.kubecamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserDataHandler userDataHandler;

    @Autowired
    public UserServiceImpl (UserDataHandler userDataHandler){
        this.userDataHandler = userDataHandler;
    }

    @Override
    public UserInfoDto saveUser(String userId, String userName, String email, boolean isDeleted){

        UserEntity userEntity = userDataHandler.saveUserEntity(userId, userName, email, isDeleted);

        UserInfoDto userInfoDto = new UserInfoDto(userEntity.getUserId(), userEntity.getUserName(),
                                                    userEntity.getEmail(),userEntity.getIsDeleted());

        return userInfoDto;
    }

    @Override
    public UserInfoDto getUser(String userId) {

        UserEntity userEntity = userDataHandler.getUserEntity(userId);

        UserInfoDto userInfoDto = new UserInfoDto(userEntity.getUserId(), userEntity.getUserName(),
                userEntity.getEmail(),userEntity.getIsDeleted());

        return userInfoDto;
    }



}
