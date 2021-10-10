package com.specification.poc.service;

import com.specification.poc.dto.UniversityFilterDto;
import com.specification.poc.entity.UniversityEntity;
import com.specification.poc.repository.UniversityRepository;
import com.specification.poc.specification.UniversitySpecification;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniversityService {

  private final UniversityRepository repository;

  public List<UniversityEntity> findAll(UniversityFilterDto filter) {

    return repository.findAll(buildSpecification(filter));
  }

  private UniversitySpecification buildSpecification(UniversityFilterDto filter) {
    return new UniversitySpecification()
        .filterByName(filter.getName())
        .filterByAddress(filter.getAddress())
        .filterByStudentName(filter.getStudentName())
        .filterByStudentAddress(filter.getStudentAddress());
  }

  public UniversityEntity save(UniversityEntity entity) {

    return repository.save(entity);
  }

}
