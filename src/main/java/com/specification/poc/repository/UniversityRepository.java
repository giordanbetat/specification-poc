package com.specification.poc.repository;

import com.specification.poc.entity.UniversityEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<UniversityEntity, UUID> {

  List<UniversityEntity> findAll(Specification<UniversityEntity> filter);
}
