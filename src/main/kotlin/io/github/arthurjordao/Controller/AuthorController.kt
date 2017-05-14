package io.github.arthurjordao.Controller

import io.github.arthurjordao.model.Author
import io.github.arthurjordao.repository.AuthorRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import javax.validation.Valid

/**
 * Created by arthur on 10/05/17.
 */
@Controller
@RequestMapping("/authors")
class AuthorController(val authorRepository: AuthorRepository) {

    @GetMapping
    fun listAuthors(model: Model): String {
        model.addAttribute("authors", authorRepository.findAll())
        return "authors/list"
    }

    @GetMapping("/new")
    fun formAuthor(model: Model): String {
        model.addAttribute("author", Author())
        return "authors/form"
    }

    @PostMapping("/new")
    fun createAuthor(@Valid @ModelAttribute("author") author: Author, bindingResult: BindingResult,
                     redirectAttributes: RedirectAttributes): String {
        if (bindingResult.hasErrors())
            return "authors/form"
        authorRepository.save(author)
        val messages : List<String> = listOf("The author was created.")
        redirectAttributes.addFlashAttribute("messages", messages)
        return "redirect:/authors"
    }

    @GetMapping("/edit/{id}")
    fun formEditAuthor(model: Model, @PathVariable("id") authorId: Long): String {
        val author = authorRepository.findOne(authorId)
        model.addAttribute("author", author)
        return "authors/edit_form"
    }

    @PostMapping("/edit/{id}")
    fun editAuthor(@Valid @ModelAttribute("author") author: Author, bindingResult: BindingResult,
                   redirectAttributes: RedirectAttributes, @PathVariable("id") authorId: Long): String {
        if (bindingResult.hasErrors())
            return "authors/edit_form"
        author.id = authorId;
        authorRepository.save(author)
        val messages : List<String> = listOf("The author was edited.")
        redirectAttributes.addFlashAttribute("messages", messages)
        return "redirect:/authors"
    }

    @GetMapping("/delete/{id}")
    fun confirmDelete(@PathVariable("id") authorId: Long, model: Model): String {
        val author = authorRepository.findOne(authorId)
        model.addAttribute("author", author)
        return "authors/delete"
    }

    @PostMapping("/delete/{id}")
    fun deleteAuthor(@PathVariable("id") authorId: Long, redirectAttributes: RedirectAttributes):String {
        authorRepository.delete(authorId)
        redirectAttributes.addFlashAttribute("messages", listOf("The author was deleted"))
        return "redirect:/authors"
    }
    @GetMapping("/details/{id}")
    fun details(@PathVariable("id") authorId: Long, model: Model): String {
        val author = authorRepository.findOne(authorId)
        model.addAttribute("author", author)
        return "authors/details"
    }
}