package kube.kubecamp.data.dto;

import kube.kubecamp.data.entity.BoardEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BoardDtoGetAll {

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