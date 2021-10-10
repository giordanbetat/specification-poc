package com.specification.poc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UniversityFilterDto {

  private String name;
  private String address;
  private String studentName;
  private String studentAddress;
}
