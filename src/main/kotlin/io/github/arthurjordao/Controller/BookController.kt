package io.github.arthurjordao.Controller

import io.github.arthurjordao.model.Author
import io.github.arthurjordao.model.Book
import io.github.arthurjordao.repository.AuthorRepository
import io.github.arthurjordao.repository.BookRepository
import org.apache.coyote.http11.Constants.a
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import javax.validation.Valid

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

    @GetMapping("/new")
    fun bookForm(model: Model): String {
        model.addAttribute("authors", authorRepository.findAll())
        model.addAttribute("book", Book())
        return "books/form"
    }

    @PostMapping("/new")
    fun newBook(@Valid @ModelAttribute book: Book, bindingResult: BindingResult,
                redirectAttributes: RedirectAttributes, model: Model): String {
        if (!authorRepository.exists(book.author.id)) {
            bindingResult.rejectValue("author", "error.author", "Must contain a valid author")
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("authors", authorRepository.findAll())
            return "books/form"
        }
        bookRepository.save(book)
        redirectAttributes.addFlashAttribute("messages", listOf("The book was created"))
        return "redirect:/books"
    }

    @GetMapping("/edit/{id}")
    fun editForm(@PathVariable("id") bookId: Long, model: Model): String {
        model.addAttribute("book", bookRepository.findOne(bookId))
        model.addAttribute("authors", authorRepository.findAll())
        return "books/edit_form"
    }

    @PostMapping("/edit/{id}")
    fun editBook(@Valid @ModelAttribute book: Book, bindingResult: BindingResult,
                 redirectAttributes: RedirectAttributes, model: Model,
                 @PathVariable("id") bookId: Long): String {
        if (!authorRepository.exists(book.author.id)) {
            bindingResult.rejectValue("author", "error.author", "Must contain a valid author")
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("authors", authorRepository.findAll())
            return "books/edit_form"
        }
        book.id = bookId
        bookRepository.save(book)
        redirectAttributes.addFlashAttribute("messages", listOf("The book was edited"))
        return "redirect:/books"
    }
}
