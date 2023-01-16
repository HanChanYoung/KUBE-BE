package kube.kubecamp.data.handler.impl;


import kube.kubecamp.data.dao.UserDAO;
import kube.kubecamp.data.entity.UserEntity;
import kube.kubecamp.data.handler.UserDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDataHandlerImpl implements UserDataHandler {

    UserDAO userDAO;

    @Autowired
    public UserDataHandlerImpl(UserDAO userDAO){

        this.userDAO = userDAO;
    }

    @Override
    public UserEntity saveUserEntity(String userId, String userName, String email, boolean isDeleted){
        UserEntity userEntity = new UserEntity(userId,userName,email,isDeleted);

        return userDAO.saveUser(userEntity);
    }

    @Override
    public UserEntity getUserEntity(String userId){

        return userDAO.getUser(userId);
    }
}
