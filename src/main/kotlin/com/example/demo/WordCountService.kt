package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class WordCountService {

    private val restTemplate = RestTemplate()

    fun countWords(request: WordCountRequest): WordCountResponse {
        val (url, word) = request

        val html = querySiteHtml(url)

        val regex = Regex("\\b($word)\\b")

        val match = regex.findAll(html)

        return WordCountResponse(match.count())
    }

    private fun querySiteHtml(url: String): String {
        val response = restTemplate.getForEntity(url, String::class.java)
        if (response.statusCode != HttpStatus.OK) throw Exception("Error: ${response.statusCodeValue}")
        return response.body!!
    }
}