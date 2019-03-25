# fuzzy-octo-robot
Web service for counting the number of occurrences of a word in a single given URL html source.

This application is deployed using Heroku at https://word-count-api.herokuapp.com/ and 
can be used by sending a POST request.

Documentation can be found at https://word-count-api.herokuapp.com/swagger-ui.html 


Test Cases

- Positive Case - Word Exists on page

Request
~~~~
{
	"url": "https://www.virtusize.jp/",
	"word": "fit"
}
~~~~

Response
~~~~
{
    "count": 2
}
~~~~

- Negative Case - Word does not exist

Request
~~~~
{
	"url": "https://www.virtusize.jp/",
	"word": "supercalifragilisticexpealidocious"
}
~~~~
Response
~~~~
{
    "count": 0
}
~~~~

- Website does not exist

Request
~~~~
{
	"url": "http://notarealwebsite.stuff",
	"word": "supercalifragilisticexpealidocious"
}
~~~~
Response
~~~~
{
    "timestamp": "2019-03-25T10:53:08.255+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "I/O error on GET request for \"http://notarealwebsite.stuff\": notarealwebsite.stuff; nested exception is java.net.UnknownHostException: notarealwebsite.stuff",
    "path": "/"
}

