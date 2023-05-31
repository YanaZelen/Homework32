package web.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
  @Query("SELECT DISTINCT a FROM Genre a JOIN FETCH a.books")
  List<Genre> listAll();
}
