package io.github.arthurjordao.repository

import io.github.arthurjordao.model.Author
import org.springframework.data.repository.CrudRepository

/**
 * Created by arthur on 10/05/17.
 */
interface AuthorRepository : CrudRepository<Author, Long> {}