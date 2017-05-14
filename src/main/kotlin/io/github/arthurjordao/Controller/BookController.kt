package io.github.arthurjordao.Controller

import io.github.arthurjordao.repository.AuthorRepository
import io.github.arthurjordao.repository.BookRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by arthur on 14/05/17.
 */
@Controller
@RequestMapping("/books")
class BookController(val bookRepository: BookRepository, val authorRepository: AuthorRepository) {

    @GetMapping
    fun listBooks(model: Model): String {
        model.addAttribute("books", bookRepository.findAll())
        return "books/list"
    }

}