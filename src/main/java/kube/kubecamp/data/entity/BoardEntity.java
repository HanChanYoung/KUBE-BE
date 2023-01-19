package kube.kubecamp.data.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert
@Table(name="BOARD_LIST")
public class BoardEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long boardId;

    String providerId;

    String categoryName;

    LocalDate rentStartDate;

    LocalDate rentEndDate;

    String boardName;

    String boardDesc;

    float price;

    String stateStatusCode;

    String delvyStatusCode;

    String boardAddr;

    String imgSrc;

    boolean isDeleted;


}
