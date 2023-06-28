package com.example.library.controller;

import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Display the form to create a new author
    @GetMapping("/new")
    public String showNewAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "author-form";
    }

    // Create a new author
    @PostMapping
    public String createAuthor(@ModelAttribute Author newAuthor) {
        authorRepository.save(newAuthor);
        return "redirect:/authors";
    }

    // Read all authors
    @GetMapping
    public String readAllAuthors(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "authors-list";
    }

    // Read an author by id
    @GetMapping("/{id}")
    public String readAuthor(@PathVariable Long id, Model model) {
        Author author = authorRepository.findById(id).orElseThrow(); // throw your exception here
        model.addAttribute("author", author);
        return "author-details";
    }

    // Display the form to update an author by id
    @GetMapping("/{id}/edit")
    public String showUpdateAuthorForm(@PathVariable Long id, Model model) {
        Author author = authorRepository.findById(id).orElseThrow(); // throw your exception here
        model.addAttribute("author", author);
        return "author-form";
    }

    // Update an author by id
    @PostMapping("/{id}")
    public String updateAuthor(@PathVariable Long id, @ModelAttribute Author updatedAuthor) {
        authorRepository.findById(id).map(author -> {
            author.setName(updatedAuthor.getName());
            return authorRepository.save(author);
        }).orElseThrow(); // throw your exception here
        return "redirect:/authors";
    }

    // Delete an author by id
    @PostMapping("/{id}/delete")
    public String deleteAuthor(@PathVariable Long id) {
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }
}


