package com.epam.task.sixth.data.book.impl.repository;

import com.epam.task.sixth.data.DataException;
import com.epam.task.sixth.data.book.BookSpecification;
import com.epam.task.sixth.data.book.BookRepository;
import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookGenre;

import java.util.LinkedList;
import java.util.List;

public class MockBookRepository implements BookRepository {
    private final List<Book> books;

    public MockBookRepository() {
        books = new LinkedList<>();
        books.add(new Book(1, "Достоевский", "Преступление и наказание", BookGenre.STORY));
        books.add(new Book(2, "Толстой", "Война и мир", BookGenre.NOVEL));
        books.add(new Book(3, "Носов", "Живая шляпа", BookGenre.STORY));
        books.add(new Book(4, "Марк Твен", "Приключения Тома Сойера", BookGenre.NOVEL));
        books.add(new Book(5, "Джек Лондон", "Белый Клык", BookGenre.TALE));
        books.add(new Book(6, "Джек Лондон", "Любовь к жизни", BookGenre.STORY));
    }

    public void addBook(Book book) throws DataException {
        if (!books.contains(book)){
            books.add(book);
        } else {
            throw new DataException("The book already exists");
        }
    }

    public void removeBook(Book book) throws DataException {
        if (books.contains(book)) {
            books.remove(book);
        } else {
            throw new DataException("The book doesn't exist");
        }
    }

    public void updateBook(Book book) throws DataException {
        if (!books.contains(book)) {
            throw new DataException("The book doesn't exist");
        }

        int index = books.indexOf(book);
        books.set(index, book);
    }

    public List<Book> query(BookSpecification specification) {
        List<Book> result = new LinkedList<>();
        for (Book book : books) {
            if (specification.specified(book)) {
                result.add(book);
            }
        }
        return result;
    }
}
