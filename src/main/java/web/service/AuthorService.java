package web.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Author;
import web.repository.AuthorRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthorService {
  private final AuthorRepository repo;

  public List<Author> listAll() {
    return (List<Author>) repo.findAll();
  }

  public Author getById(Long id) {
    return repo.findById(id).get();
  }

  public Author saveAuthor(Author author) {
    return repo.save(author);
  }

  public Author findBySurName(String surName) {
    return repo.findAuthorBySurName(surName);
  }

  public Author findAuthorByNameAndSurName(String name, String surName) {
    return repo.findAuthorByNameAndSurName(name, surName);
  }

  public List<Author> findAllByNameContaining(String name) {
    return repo.findAllByNameContaining(name);
  }

  public Author getByName(String name) {
    return repo.findAuthorByName(name);
  }

  public void deleteAuthor(Author author) {
    repo.delete(author);
  }
}
