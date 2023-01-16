package kube.kubecamp.data.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="USER_TB")
public class UserEntity extends BaseTimeEntity {

    @Id
    String userId;

    String userName;

    String email;

    Boolean isDeleted;

}
