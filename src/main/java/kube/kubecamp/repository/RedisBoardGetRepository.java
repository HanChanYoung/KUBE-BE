package kube.kubecamp.repository;

import kube.kubecamp.data.dto.BoardDtoGet;
import org.springframework.data.repository.CrudRepository;

public interface RedisBoardGetRepository extends CrudRepository<BoardDtoGet,Long> {
}
