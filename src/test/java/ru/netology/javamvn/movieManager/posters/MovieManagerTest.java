package ru.netology.javamvn.movieManager.posters

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void constructorWithoutParamsCreatesEmptyArray() {
        // Проверяем добавление 0 фильмов
        MovieManager manager = new MovieManager();

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addMovieAddsOneFilm() {
        // Проверяем добавление одного фильма
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addThreeMovieMaintainsOrderOfAddition() {
        // Проверяем сохранение порядка добавления при добавлении трех фильмов
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");

        String[] expected = {"Бладшот", "Вперёд", "Отель Белград"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addFiveMovieMaintainsOrderOfAddition() {
        // Проверяем сохранение порядка добавления при добавлении пяти фильмов
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-Невидимка");

        String[] expected = {"Бладшот", "Вперёд", "Отель Белград", "Джентльмены", "Человек-Невидимка"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addSevenMovieMaintainsOrderOfAddition() {
        // Проверяем сохранение порядка добавления при добавлении cеми фильмов
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-Невидимка");
        manager.addMovie("Тролли.Мировой тур");
        manager.addMovie("Номер один");

        String[] expected = {"Бладшот", "Вперёд", "Отель Белград", "Джентльмены", "Человек-Невидимка", "Тролли.Мировой тур", "Номер один"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastReturnsSingleMovie() {
        // Проверяем возврат одного фильма через findLast()
        MovieManager manager = new MovieManager();

        manager.addMovie("Номер один");

        String[] expected = {"Номер один"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastReturnsAllFilmsWhenLessThanLimit() {
        // Проверяем возврат всех фильмов (в обратном порядке) когда их меньше limit
        MovieManager manager = new MovieManager(5);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");

        String[] expected = {"Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastReturnsLimitedFilmsWhenMoreThanLimit() {
        // Проверяем возврат всех фильмов (в обратном порядке) когда их больше limit
        MovieManager manager = new MovieManager(2);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");

        String[] expected = {"Джентельмены", "Отель Белград"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastReturnsExactlyLimitFilms() {
        // Проверяем возврат ровно limit фильмов когда их количество равно limit
        MovieManager manager = new MovieManager(3);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");

        String[] expected = {"Отель Белград", "Вперёд", "Бладшот"};

        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastReturnsEmptyArrayWhenLimitIsZero() {
        // Проверяем возврат пустого массива когда limit = 0 (даже при наличии фильмов)
        MovieManager manager = new MovieManager(0);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}