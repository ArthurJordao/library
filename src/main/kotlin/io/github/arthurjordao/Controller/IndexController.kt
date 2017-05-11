package io.github.arthurjordao.Controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
* Created by arthur on 11/05/17.
*/
@Controller
@RequestMapping("/")
class IndexController {

    @GetMapping
    fun index() : String {
        return "index"
    }

}