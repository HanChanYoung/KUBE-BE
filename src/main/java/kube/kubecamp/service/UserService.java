package kube.kubecamp.service;

import kube.kubecamp.data.dto.UserInfoDto;

public interface UserService {

    UserInfoDto saveUser(String userId, String userName, String email, boolean isDeleted);

    UserInfoDto getUser(String userId);

}
