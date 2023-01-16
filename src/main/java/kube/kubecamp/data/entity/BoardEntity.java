package kube.kubecamp.data.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="BOARD_LIST_TB")
public class BoardEntity extends BaseTimeEntity {

    @Id
    String boardId;

    String providerId;

    int categoryId;

    LocalDateTime rentStartDate;

    LocalDateTime rentEndDate;

    String boardName;

    String boardDesc;

    float price;

    String stateStatusCode;

    String delvyStatusCode;

    String boardAddr;

    LocalDateTime delDate;

    String imgSrc;

    boolean isDeleted;

}
