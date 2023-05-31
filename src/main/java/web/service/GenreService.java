package web.service;

import java.util.List;
import java.util.Optional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Genre;
import web.repository.GenreRepository;

@Service
@Transactional
public class GenreService {

  private final GenreRepository genreRepository;

  @Autowired
  public GenreService(GenreRepository genreRepository) {
    this.genreRepository = genreRepository;
  }

  public Genre save(Genre genre) {
    return genreRepository.save(genre);
  }

  public Optional<Genre> findById(Long id) {
    return genreRepository.findById(id);
  }

  @Transactional
  public List<Genre> findAll() {
    List<Genre> all = genreRepository.findAll();
    for (Genre genre : all) {
      Hibernate.initialize(genre.getBooks());
    }
    return all;
  }

  public void delete(Genre genre) {
    genreRepository.delete(genre);
  }
}
