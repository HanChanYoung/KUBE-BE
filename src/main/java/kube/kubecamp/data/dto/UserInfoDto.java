package kube.kubecamp.data.dto;

import kube.kubecamp.data.entity.UserEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserInfoDto {

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
