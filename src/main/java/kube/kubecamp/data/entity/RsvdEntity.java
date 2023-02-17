package kube.kubecamp.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate rentStartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate rentEndDate;

    String delvyOptionCode;

    String rsvdStatusCode;

    String lenderAddr;

    boolean isDeleted;

}