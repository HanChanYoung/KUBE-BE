package kube.kubecamp.data.dao.impl;

import kube.kubecamp.data.dao.UserDAO;
import kube.kubecamp.data.entity.UserEntity;
import kube.kubecamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAOImpl implements UserDAO {

    UserRepository userRepository;

    @Autowired
    public UserDAOImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity){
        userRepository.save(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity getUser(String userId){
        UserEntity userEntity = userRepository.getById(userId);
        return userEntity;
    }


}
