package kube.kubecamp.data.handler;

import kube.kubecamp.data.entity.UserEntity;

public interface UserDataHandler {

    UserEntity saveUserEntity(String userId, String userName, String email, boolean isDeleted);

    UserEntity getUserEntity(String userId);
}
