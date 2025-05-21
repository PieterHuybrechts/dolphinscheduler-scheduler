package be.pieterh.dolphinscheduler_scheduler

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller("/")
class PersonsController {

    val persons = mutableListOf<Person>()

    @GetMapping
    fun get(model: Model): String {
        model.addAttribute("persons", persons)
        return "index"
    }

    @PostMapping("/persons")
    fun addPerson(model: Model, @RequestParam name: String, @RequestParam age: Int): String {
        val person = Person(name, age)
        persons.add(person)

        model.addAttribute("person", person)
        return "fragments :: person"
    }

}