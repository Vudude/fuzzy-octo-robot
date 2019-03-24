package com.example.demo

import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


@RestController
class WordCountController(
        private val wordCountService: WordCountService
) {

    @ApiOperation(
            value = "Counts appearances of a specified word on a given html source page",
            notes = "Uses a Regex expression to find occurrences of given word. Does not find occurrences " +
                    "that are inside of another word."
    )
    @RequestMapping("/", method = [RequestMethod.POST])
    fun wordCount(@RequestBody request: WordCountRequest): WordCountResponse  {
        return wordCountService.countWords(request)
    }

}

