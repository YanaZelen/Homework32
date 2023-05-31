package web.controller;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Author;
import web.model.Genre;
import web.model.Book;
import web.repository.BookCreateService;
import web.service.GenreService;
import web.service.BookService;

@Controller
@RequestMapping(value = "/book")
@RequiredArgsConstructor
public class BookController {

  private final BookCreateService bookCreateService;
  private final BookService bookService;
  private final GenreService genreService;

  @GetMapping(value = "/createGenre")
  public ResponseEntity<Void> createCategory() {
    bookCreateService.saveThemes();
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/createBook")
  public ResponseEntity<String> createProduct() {
    Book randomBookAndTheme = bookCreateService.getRandomProductAndTheme();
    return ResponseEntity.ok(randomBookAndTheme.toString());
  }

  @GetMapping(value = "/findBookByAuthorsAndGenre")
  public ResponseEntity<String> findBookByAuthorsAndGenre(@RequestParam Author author, @RequestParam Genre genre) {
    Pageable pageable = PageRequest.of(0,4, Sort.by("page").ascending());
    Page<Book> result = bookService.findByAuthorsAndGenre(author, genre, pageable);
    System.out.println(result.getNumber());
    System.out.println(result.getTotalElements());
    System.out.println(result.getSize());
    System.out.println(result.getTotalPages());
    return ResponseEntity.ok(result.toString());
  }

  @GetMapping(value = "/findAllBooks")
  public ResponseEntity<String> findAllBooks() {
    List<Genre> all = genreService.findAll();
    for (Genre genre : all) {
      for (Book book : genre.getBooks()) {
        System.out.println(book);
      }
    }
    return ResponseEntity.ok(all.toString());
  }
}