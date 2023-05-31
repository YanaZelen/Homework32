package web.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import web.model.Genre;
import web.model.Book;
import web.service.GenreService;
import web.service.BookService;

@Component
@RequiredArgsConstructor
public class BookCreateService {
  private final GenreService genreService;
  private final BookService bookService;
  private final String[] themes = {"Ужасы", "Драма", "Поэзия", "Научпоп", "Философия"};
  private ArrayList<Genre> genres = new ArrayList<>();

  private final String[][] products = {
      {"Оно", "Ктулху"},
      {"Война и мир", "Преступление и наказание", "Анна Каренина"},
      {"Анна Ахматова", "Вера Полозкова", "Владимир Маяковский"},
      {"Что скрывает кожа", "Разбуди свой мозг", "Как хочет женщина"},
      {"Государство", "Искусство войны", "Лучшее в нас"}
  };

  public Book getRandomProductAndTheme() {
    Random random = new Random();
    int themeIndex = random.nextInt(themes.length);
    int bookIndex = random.nextInt(products[themeIndex].length);
    Genre genre = genres.get(themeIndex);
    Genre genre1 = genres.get(random.nextInt(themes.length));
    String product = products[themeIndex][bookIndex];
    return bookService.save(new Book(product, Integer.valueOf(random.nextInt(500)), genre));
  }

  public void saveThemes() {
    for (String theme : themes) {
      Genre genre = new Genre(theme);
      genre = genreService.save(genre);
      genres.add(genre);
      System.out.println("Создана категория:" + genre);
    }
  }
}
