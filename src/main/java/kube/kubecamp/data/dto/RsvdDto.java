package kube.kubecamp.data.dto;


import kube.kubecamp.data.entity.RsvdEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RsvdDto {

    @NotNull
    private Long rsvdId;

    @NotNull
    private Long boardId;

    @NotNull
    private String lenderId;

    private LocalDate rentStartDate;

    private LocalDate rentEndDate;

    private String delvyOptionCode;

    private String rsvdStatusCode;
    private String lenderAddr;

    @ColumnDefault("false")
    private boolean isDeleted;

    public String getDelvyOptionCode() {
        return delvyOptionCode;
    }

    public void setDelvyOptionCode(String delvyOptionCode) {

        if (delvyOptionCode.equals("직접직접")) {
            this.delvyOptionCode = "21";
        } else if (delvyOptionCode.equals("직접서비스")) {
            this.delvyOptionCode = "22";
        } else if (delvyOptionCode.equals("서비스직접")) {
            this.delvyOptionCode = "23";
        } else {
            this.delvyOptionCode = "24";
        }


    }

    public RsvdEntity toEntityRsvd() {

        return RsvdEntity.builder()
                .rsvdId(rsvdId)
                .boardId(boardId)
                .lenderId(lenderId)
                .rentStartDate(rentStartDate)
                .rentEndDate(rentEndDate)
                .delvyOptionCode(delvyOptionCode)
                .lenderAddr(lenderAddr)
                .rsvdStatusCode(rsvdStatusCode)
                .isDeleted(isDeleted)
                .build();
    }

}
