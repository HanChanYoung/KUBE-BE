package kube.kubecamp.data.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "RESERVATION")
public class RsvdEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long rsvdId;

    Long boardId;

    String lenderId;

    LocalDate rentStartDate;

    LocalDate rentEndDate;

    String delvyOptionCode;

    String rsvdStatusCode;

    String lenderAddr;

    boolean isDeleted;

}