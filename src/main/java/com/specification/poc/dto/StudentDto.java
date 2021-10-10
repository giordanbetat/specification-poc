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
public class StudentDto {

  private UUID id;
  private String studentName;
  private String studentAddress;
  private Set<StudentPhoneDto> phones = new HashSet<>();
}
