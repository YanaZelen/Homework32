package web.model;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@NamedEntityGraph(
        name = "bookWithAuthorAndGenreEntityGraph",
        attributeNodes = {
                @NamedAttributeNode("name"),
                @NamedAttributeNode("genre"),
                @NamedAttributeNode("authors"),

        }
)

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
@Data
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Integer page;

  @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
  private List<Author> authors;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private Genre genre;

  public Book(String name, Integer page, Genre genre) {
    this.name = name;
    this.page = page;
    this.genre = genre;
  }
}
