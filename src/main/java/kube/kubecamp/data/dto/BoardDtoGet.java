package kube.kubecamp.data.dto;


import lombok.*;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDtoGet {



    @NotNull
    private Long boardId;

    private String categoryName;

    private LocalDate rentStartDate;

    private LocalDate rentEndDate;

    private String boardName;

    private String boardDesc;

    @NotNull
    private float price;

    private String imgSrc;

    private List<List<LocalDate>> reservedDate;



}
