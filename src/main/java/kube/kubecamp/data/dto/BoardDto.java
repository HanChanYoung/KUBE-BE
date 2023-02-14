package kube.kubecamp.data.dto;


import kube.kubecamp.data.entity.BoardEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
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
@RedisHash(value="board",timeToLive = 60)
public class BoardDto implements Serializable {

    private static final long serialVersionUID = -214490344996507077L;
    @Id
    @NotNull
    @Column
    private Long boardId;

    @NotNull
    @Column
    private String providerId;

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

    @ColumnDefault("defal")
    private String stateStatusCode;

    @Column
    private String delvyStatusCode;
    @Column
    private String boardAddr;

    @Column
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
                .categoryName(categoryName)
                .rentStartDate(rentStartDate)
                .boardName(boardName)
                .boardDesc(boardDesc)
                .price(price)
                .stateStatusCode(stateStatusCode)
                .delvyStatusCode(delvyStatusCode)
                .boardAddr(boardAddr)
                .isDeleted(isDeleted)
                .build();
    }

}
