package com.lunar.lunar.repository;

import com.lunar.lunar.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}