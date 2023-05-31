package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.model.Author;
import web.service.AuthorService;

import java.util.List;

@Controller
@RequestMapping(value = "/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping(value = "/")
    public ResponseEntity<String> getHomePage() {
        List<Author> authors = authorService.listAll();
        return ResponseEntity.ok(authors.toString());
    }

    @GetMapping(value = "/surName/{surName}")
    public ResponseEntity<String> getAuthorBySurName(@PathVariable("surName") String surName) {
        return ResponseEntity.ok(authorService.findBySurName(surName).toString());
    }

    @GetMapping(value = "/surName")
    public ResponseEntity<String> getAuthorByNameAndSurName(@RequestParam("name") String name,
                                                        @RequestParam("surName") String surName) {
        return ResponseEntity.ok(authorService.findAuthorByNameAndSurName(name, surName).toString());
    }

    @GetMapping(value = "/surName/all/{name}")
    public ResponseEntity<String> getAllAuthorContainsName(@PathVariable("name") String name) {
        return ResponseEntity.ok(authorService.findAllByNameContaining(name).toString());
    }
}