package web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraphs({
        @NamedEntityGraph(name = "authorOnlyEntityGraph"),
        @NamedEntityGraph(name = "authorAndBooksEntityGraph",
                attributeNodes = {@NamedAttributeNode("books")})
})

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "authors")
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String surName;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id")
  private List<Book> books;
}
