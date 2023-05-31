package web.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Author;
import web.model.Book;
import web.model.Genre;
import web.repository.BookRepository;

@Service
@Transactional
public class BookService {
  private final BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public Book save(Book book) {
    return bookRepository.save(book);
  }

  public Optional<Book> findById(Long id) {
    return bookRepository.findById(id);
  }

  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  public void delete(Book book) {
    bookRepository.delete(book);
  }

  public Page<Book> findByAuthorsAndGenre(Author author, Genre genre, Pageable pageable) {
    return bookRepository.findByAuthorsAndGenre(author, genre, pageable);
  }

}
