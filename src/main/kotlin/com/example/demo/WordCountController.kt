package com.example.demo

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


@RestController
class WordCountController(
        private val wordCountService: WordCountService
) {

    @RequestMapping("/", method = [RequestMethod.POST])
    fun wordCount(@RequestBody request: WordCountRequest): WordCountResponse  {
        return wordCountService.countWords(request)
    }

}

