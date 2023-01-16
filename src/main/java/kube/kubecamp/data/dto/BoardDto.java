package kube.kubecamp.data.dto;


import kube.kubecamp.data.entity.BoardEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BoardDto {

    @NotNull
    private String boardId;

    @NotNull
    private String providerId;

    private int categoryId;

    private LocalDateTime rentStartDate;

    private LocalDateTime rentEndDate;

    private String boardName;

    private String boardDesc;

    @NotNull
    private float price;

    @ColumnDefault("11")
    private String stateStatusCode;

    private String delvyStatusCode;

    private String boardAddr;

    private LocalDateTime delDate;

    private String imgSrc;

    @ColumnDefault("false")
    private boolean isDeleted;

    public String getDelvyStatusCode() {
        return delvyStatusCode;
    }

    public void setDelvyStatusCode(String delvyStatusCode) {

        if (delvyStatusCode.equals("직접직접")){
            this.delvyStatusCode="21";
        }
        else if(delvyStatusCode.equals("직접서비스")){
            this.delvyStatusCode="22";
        }
        else if(delvyStatusCode.equals("서비스직접")){
            this.delvyStatusCode="23";
        }
        else{
            this.delvyStatusCode="24";
        }


    }

    public BoardEntity toEntityBoard(){

        return BoardEntity.builder()
                .boardId(boardId)
                .providerId(providerId)
                .categoryId(categoryId)
                .rentStartDate(rentStartDate)
                .boardName(boardName)
                .boardDesc(boardDesc)
                .price(price)
                .stateStatusCode(stateStatusCode)
                .delvyStatusCode(delvyStatusCode)
                .boardAddr(boardAddr)
                .delDate(delDate)
                .isDeleted(isDeleted)
                .build();
    }

}
