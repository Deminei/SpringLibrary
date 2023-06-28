package com.example.library.controller;

import com.example.library.exception.ResourceNotFoundException;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    // Display form to create a new book
    @GetMapping("/new")
    public String showNewBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorRepository.findAll());
        return "book-form";
    }

    // Create a new book
    @PostMapping
    public String createBook(@ModelAttribute Book newBook) {
        bookRepository.save(newBook);
        return "redirect:/books";
    }

    // Read all books
    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", bookRepository.findAll());
        return "books-list";
    }

    // Read a book by its id
    @GetMapping("/{id}")
    public String readBook(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        model.addAttribute("book", book);
        return "book-details";
    }

    // Display the form to update a book by id
    @GetMapping("/{id}/edit")
    public String showUpdateBookForm(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        authorRepository.findById(id).orElseThrow();
        model.addAttribute("book", book);
        model.addAttribute("authors", authorRepository.findAll());
        return "book-form";
    }

    // Update a book by its id
    @PutMapping("/{id}")
    public String updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        bookRepository.findById(id).map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    return bookRepository.save(book);
        }).orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        return "redirect:/books";
    }

    // Delete a book by its id
    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}

