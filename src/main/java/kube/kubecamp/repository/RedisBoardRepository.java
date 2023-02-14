package kube.kubecamp.repository;

import kube.kubecamp.data.dto.BoardDto;
import org.springframework.data.repository.CrudRepository;

public interface RedisBoardRepository extends CrudRepository<BoardDto,Long> {
}
