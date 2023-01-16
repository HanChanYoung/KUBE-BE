package kube.kubecamp.data.dao;

import kube.kubecamp.data.entity.UserEntity;


public interface UserDAO {

    UserEntity saveUser(UserEntity userEntity);

    UserEntity getUser(String userId);

}
