package com.specification.poc.mapper;

import com.specification.poc.dto.StudentDto;
import com.specification.poc.dto.StudentPhoneDto;
import com.specification.poc.dto.UniversityDto;
import com.specification.poc.entity.StudentEntity;
import com.specification.poc.entity.StudentPhoneEntity;
import com.specification.poc.entity.UniversityEntity;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UniversityMapper {

  public UniversityDto toDto(UniversityEntity entity) {
    return UniversityDto
        .builder()
        .id(entity.getId())
        .name(entity.getName())
        .address(entity.getAddress())
        .students(entity.getStudents().stream().map(this::toStudentDto)
            .collect(Collectors.toSet()))
        .build();
  }

  private StudentDto toStudentDto(StudentEntity studentEntity) {
    return StudentDto
        .builder()
        .id(studentEntity.getId())
        .studentName(studentEntity.getStudentName())
        .studentAddress(studentEntity.getStudentAddress())
        .phones(studentEntity.getPhones().stream().map(this::toStudentPhoneDto)
            .collect(Collectors.toSet()))
        .build();
  }

  private StudentPhoneDto toStudentPhoneDto(StudentPhoneEntity studentPhoneEntity) {
    return StudentPhoneDto
        .builder()
        .id(studentPhoneEntity.getId())
        .phone(studentPhoneEntity.getPhone())
        .type(studentPhoneEntity.getType())
        .build();
  }

  public UniversityEntity toEntity(UniversityDto dto) {
    return UniversityEntity
        .builder()
        .id(dto.getId())
        .name(dto.getName())
        .address(dto.getAddress())
        .students(dto.getStudents().stream().map(this::toStudentEntity)
            .collect(Collectors.toSet()))
        .build();
  }

  private StudentEntity toStudentEntity(StudentDto studentDto) {
    return StudentEntity
        .builder()
        .id(studentDto.getId())
        .studentName(studentDto.getStudentName())
        .studentAddress(studentDto.getStudentAddress())
        .phones(studentDto.getPhones().stream().map(this::toStudentPhoneEntity)
            .collect(Collectors.toSet()))
        .build();
  }

  private StudentPhoneEntity toStudentPhoneEntity(StudentPhoneDto studentPhoneDto) {
    return StudentPhoneEntity
        .builder()
        .id(studentPhoneDto.getId())
        .phone(studentPhoneDto.getPhone())
        .type(studentPhoneDto.getType())
        .build();
  }

}
