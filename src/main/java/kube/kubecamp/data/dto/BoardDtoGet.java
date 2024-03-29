package kube.kubecamp.data.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RedisHash(value="boardGet",timeToLive = 60)
public class BoardDtoGet implements Serializable {

    private static final long serialVersionUID = -214490344996507077L;

    @Id
    @NotNull
    private Long boardId;

    private String categoryName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate rentStartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate rentEndDate;

    private String boardName;

    private String boardDesc;

    @NotNull
    private float price;

    private String imgSrc;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private List<List<LocalDate>> reservedDate;



}
