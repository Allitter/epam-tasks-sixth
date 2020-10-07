package com.epam.tasks.sixth.data.book.sorters;

import com.epam.tasks.sixth.model.Book;
import java.util.List;

public interface BookSorter {

    List<Book> sort(List<Book> books);

}
