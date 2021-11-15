package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    TShirt first = new TShirt(5, "Adidas Blue", 1500, "Blue", "48");
    Book second = new Book(15, "Harry Potter", 600, "J.K.Rowling", 650, 2004);
    Book third = new Book(65, "Lord of The Rings", 550, "Tolkien", 1000, 1980);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    public void shouldRemoveByIdIfExists() {
        repository.removeById(65);
        assertEquals(null, repository.findById(65));
    }

    @Test
    public void shouldNotRemoveByIdIfNotExists() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(14);
        });
    }
}