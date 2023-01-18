package kube.kubecamp.repository;

import kube.kubecamp.data.entity.RsvdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RsvdRepository extends JpaRepository<RsvdEntity, Long> {
}
