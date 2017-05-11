package io.github.arthurjordao.Controller

import io.github.arthurjordao.model.Author
import io.github.arthurjordao.repository.AuthorRepository
import io.github.arthurjordao.repository.BookRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by arthur on 10/05/17.
 */
@Controller
@RequestMapping("/authors")
class AuthorController (val authorRepository: AuthorRepository) {
//    @GetMapping("/new")
//    fun formAuthor(model : Model) : String {
//        model.addAttribute("author", Author())
//        return "authors/form"
//    }
}