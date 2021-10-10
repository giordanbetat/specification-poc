package com.specification.poc.specification;

import com.specification.poc.entity.StudentEntity;
import com.specification.poc.entity.UniversityEntity;
import java.util.Objects;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UniversitySpecification extends BaseSpecification<UniversityEntity> {

  public UniversitySpecification filterByName(String name) {
    if (Objects.nonNull(name)) {
      specifications.add((root, query, criteriaBuilder) ->
          criteriaBuilder.like(root.get("name"), "%" + name + "%"));
    }
    return this;
  }

  public UniversitySpecification filterByAddress(String address) {
    if (Objects.nonNull(address)) {
      specifications.add((root, query, criteriaBuilder) ->
          criteriaBuilder.like(root.get("address"), "%" + address + "%"));
    }
    return this;
  }

  public UniversitySpecification filterByStudentName(String studentName) {
    if (Objects.nonNull(studentName)) {
      specifications.add((root, query, criteriaBuilder) -> {
        var subQuery = query.subquery(String.class);
        var studentRoot = subQuery.from(StudentEntity.class);
        subQuery.select(root.get("id"))
            .where(criteriaBuilder.equal(root.get("id"), studentRoot.get("universityId")),
                criteriaBuilder.like(studentRoot.get("studentName"), "%" + studentName + "%"));
        return criteriaBuilder.in(root.get("id")).value(subQuery);
      });
    }
    return this;
  }

  public UniversitySpecification filterByStudentAddress(String studentAddress) {
    if (Objects.nonNull(studentAddress)) {
      specifications.add((root, query, criteriaBuilder) -> {
        var subQuery = query.subquery(String.class);
        var studentRoot = subQuery.from(StudentEntity.class);
        subQuery.select(root.get("id"))
            .where(criteriaBuilder.equal(root.get("id"), studentRoot.get("universityId")),
                criteriaBuilder.like(studentRoot.get("studentAddress"),
                    "%" + studentAddress + "%"));
        return criteriaBuilder.in(root.get("id")).value(subQuery);
      });
    }
    return this;
  }

}
