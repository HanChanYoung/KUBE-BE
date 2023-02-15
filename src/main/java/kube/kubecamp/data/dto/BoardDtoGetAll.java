package kube.kubecamp.data.dto;

import kube.kubecamp.data.entity.BoardEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RedisHash(value="boardGetAll",timeToLive = 60)
public class BoardDtoGetAll implements Serializable {

    private static final long serialVersionUID = -214490344996507077L;


    @NotNull
    @Column
    private Long boardId;


    @Column
    private String categoryName;

    @Column
    private LocalDate rentStartDate;

    @Column
    private LocalDate rentEndDate;

    @Column
    private String boardName;

    @Column
    private String boardDesc;

    @NotNull
    @Column
    private float price;

    @Column
    private String imgSrc;


    public BoardEntity toEntityBoard(){

        return BoardEntity.builder()
                .boardId(boardId)
                .categoryName(categoryName)
                .rentStartDate(rentStartDate)
                .rentEndDate(rentEndDate)
                .boardName(boardName)
                .boardDesc(boardDesc)
                .price(price)
                .imgSrc(imgSrc)
                .build();
    }
}
