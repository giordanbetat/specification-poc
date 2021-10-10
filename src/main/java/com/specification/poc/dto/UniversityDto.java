package com.specification.poc.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UniversityDto {

  private UUID id;
  private String name;
  private String address;
  private Set<StudentDto> students = new HashSet<>();
}
