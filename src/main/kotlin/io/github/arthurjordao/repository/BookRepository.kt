package io.github.arthurjordao.repository

import io.github.arthurjordao.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

/**
 * Created by arthur on 10/05/17.
 */
interface BookRepository : JpaRepository<Book, Long> {
}