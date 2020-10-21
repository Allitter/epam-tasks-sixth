package com.epam.task.sixth.data.book;

import com.epam.task.sixth.model.Book;

import java.util.List;

public interface BookSpecification {

    List<Book> find(List<Book> books);

}
