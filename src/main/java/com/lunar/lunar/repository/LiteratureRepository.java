package com.lunar.lunar.repository;

import com.lunar.lunar.domain.Literature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiteratureRepository extends JpaRepository<Literature, Long> {
}