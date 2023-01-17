package kube.kubecamp.data.dto;


import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDtoGet {



    @NotNull
    private String boardId;

    private int categoryId;

    private LocalDateTime rentStartDate;

    private LocalDateTime rentEndDate;

    private String boardName;

    private String boardDesc;

    @NotNull
    private float price;

    private String imgSrc;

}
