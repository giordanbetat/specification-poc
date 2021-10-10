package com.specification.poc.specification;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class BaseSpecification<T> implements Specification<T> {

  transient List<Specification<T>> specifications = new ArrayList<>();

  @Override
  public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    return criteriaBuilder.and(specifications.stream()
        .map(criteria -> criteria.toPredicate(root, query, criteriaBuilder))
        .toArray(Predicate[]::new));
  }
}
