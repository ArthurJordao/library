package io.github.arthurjordao.model

import org.hibernate.validator.constraints.NotEmpty
import javax.persistence.*

/**
 * Created by arthur on 10/05/17.
 */
@Entity
class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Long = 0
    @NotEmpty
    var name : String = ""
    @OneToMany(mappedBy = "author")
    var books : List<Book> = ArrayList<Book>()
}