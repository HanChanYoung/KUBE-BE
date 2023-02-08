package kube.kubecamp.repository;

import kube.kubecamp.data.dto.UserInfoDto;
import org.springframework.data.repository.CrudRepository;

public interface RedisUserRepository extends CrudRepository<UserInfoDto,String> {

}
