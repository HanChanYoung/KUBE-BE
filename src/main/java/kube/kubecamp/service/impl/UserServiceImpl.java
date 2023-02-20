package kube.kubecamp.service.impl;


import kube.kubecamp.data.dto.UserInfoDto;
import kube.kubecamp.data.entity.UserEntity;
import kube.kubecamp.data.handler.UserDataHandler;
import kube.kubecamp.repository.RedisUserRepository;
import kube.kubecamp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserDataHandler userDataHandler;

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final RedisUserRepository redisUserRepository;


    @Autowired
    public UserServiceImpl (UserDataHandler userDataHandler, RedisUserRepository redisUserRepository){
        this.userDataHandler = userDataHandler;
        this.redisUserRepository=redisUserRepository;
    }

    @Transactional(readOnly = false)
    @Override
    public UserInfoDto saveUser(String userId, String userName, String email, boolean isDeleted){

        UserEntity userEntity = userDataHandler.saveUserEntity(userId, userName, email, isDeleted);

        UserInfoDto userInfoDto = new UserInfoDto(userEntity.getUserId(), userEntity.getUserName(),
                                                    userEntity.getEmail(),userEntity.getIsDeleted());

        //Cache
        redisUserRepository.save(userInfoDto);

        log.info("Response DTO : {}",userInfoDto);
        return userInfoDto;
    }

    @Transactional(readOnly = true)
    @Override
    public UserInfoDto getUser(String userId) {
        long startTime = System.currentTimeMillis();

        UserEntity userEntity = userDataHandler.getUserEntity(userId);


        try{
            Optional<UserInfoDto> foundResponseDto = redisUserRepository.findById(userId);

            if (foundResponseDto.isPresent()) {
            log.info("Cache Data is exist");
//            log.info("[getUser] Response ::  Response Time = {}ms", (System.currentTimeMillis() - startTime));
            return foundResponseDto.get();
              }
             else{
            log.info("Cache Data does NOT exist");
//            UserInfoDto userInfoDto = new UserInfoDto(userEntity.getUserId(), userEntity.getUserName(),
//                    userEntity.getEmail(),userEntity.getIsDeleted());

            }
        }catch (Exception e){
            e.getMessage();
        }


        UserInfoDto userInfoDto = new UserInfoDto(userEntity.getUserId(), userEntity.getUserName(),
                userEntity.getEmail(),userEntity.getIsDeleted());

        redisUserRepository.save(userInfoDto);
        log.info("DB SELECTs");
//        log.info("[getUser] Response ::  Response Time = {}ms", (System.currentTimeMillis() - startTime));
//        log.info("Response DTO : {}",userInfoDto);
        return userInfoDto;
    }



}
