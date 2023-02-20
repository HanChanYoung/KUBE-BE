package kube.kubecamp.data.dto;

import kube.kubecamp.data.entity.UserEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value="user")
public class UserInfoDto implements Serializable {

    private static final long serialVersionUID = -214490344996507077L;
    @Id
    @NotNull
    private String userId;

    @NotNull
    private String userName;

    @NotNull
    private String email;

    @ColumnDefault("false")
    private boolean isDeleted;

    public UserEntity toEntity(){

        return UserEntity.builder()
                .userId(userId)
                .userName(userName)
                .email(email)
                .isDeleted(isDeleted)
                .build();

    }




}
