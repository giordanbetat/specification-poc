package com.specification.poc.controller;

import com.specification.poc.dto.UniversityDto;
import com.specification.poc.dto.UniversityFilterDto;
import com.specification.poc.entity.UniversityEntity;
import com.specification.poc.mapper.UniversityMapper;
import com.specification.poc.service.UniversityService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/universities")
public class UniversityController {

  private final UniversityService service;
  private final UniversityMapper mapper;

  @GetMapping
  public List<UniversityDto> findAll(UniversityFilterDto filter) {
    return service.findAll(filter)
        .stream().map(mapper::toDto).collect(Collectors.toList());
  }

  @PostMapping
  public UniversityDto save(@RequestBody UniversityDto dto) {
    UniversityEntity entity = service.save(mapper.toEntity(dto));

    return mapper.toDto(entity);
  }
}
