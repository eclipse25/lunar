package com.lunar.lunar.service;

import com.lunar.lunar.domain.Literature;
import com.lunar.lunar.repository.LiteratureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LiteratureService {

    private final LiteratureRepository literatureRepository;

    public List<Literature> findAll() {
        return literatureRepository.findAll();
    }

    public Optional<Literature> findById(Long id) {
        return literatureRepository.findById(id);
    }

    public Literature save(Literature literature) {
        return literatureRepository.save(literature);
    }

    public void deleteById(Long id) {
        literatureRepository.deleteById(id);
    }
}
