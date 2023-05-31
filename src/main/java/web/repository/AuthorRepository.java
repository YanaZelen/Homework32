package web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.Author;
import web.model.Book;
import web.model.Genre;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
  Author findAuthorBySurName(String surName);

  Author findAuthorByNameAndSurName(String name, String surName);

  List<Author> findAllByNameContaining(String name);

  @EntityGraph(value = "authorOnlyEntityGraph")
  List<Author> findAll();
  @EntityGraph(value = "authorAndBooksEntityGraph", type = EntityGraph.EntityGraphType.FETCH)
  List<Author> findAllByBooks();

  Author findAuthorByName(String name);
}
