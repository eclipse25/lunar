package com.lunar.lunar.controller;

import com.lunar.lunar.domain.Author;
import com.lunar.lunar.domain.Literature;
import com.lunar.lunar.repository.AuthorRepository;
import com.lunar.lunar.service.LiteratureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/literatures")
@RequiredArgsConstructor
public class LiteratureController {

    private final LiteratureService literatureService;
    private final AuthorRepository authorRepository;

    @GetMapping
    public List<Literature> getAll() {
        return literatureService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Literature> getById(@PathVariable Long id) {
        return literatureService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Literature literature) {
        // author가 반드시 존재해야 함
        Author author = authorRepository.findById(literature.getAuthor().getId())
                .orElse(null);
        if (author == null) {
            return ResponseEntity.badRequest().body("Author not found");
        }

        literature.setAuthor(author);  // 영속성 보장
        return ResponseEntity.ok(literatureService.save(literature));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        literatureService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
