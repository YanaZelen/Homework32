package web.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.Author;
import web.model.Book;
import web.model.Genre;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  @EntityGraph(value = "bookWithAuthorAndGenreEntityGraph")
  Page<Book> findByAuthorsAndGenre(Author author, Genre genre, Pageable pageable);
  @EntityGraph(value = "bookWithAuthorAndGenreEntityGraph", type = EntityGraph.EntityGraphType.FETCH)
  Optional<Book> findById(Long id);
}
