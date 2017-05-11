package io.github.arthurjordao.model

import org.hibernate.validator.constraints.NotEmpty
import javax.persistence.*

/**
 * Created by arthur on 10/05/17.
 */
@Entity
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Long = 0
    @ManyToOne
    var author : Author = Author()
    @NotEmpty
    var name : String = ""
}
