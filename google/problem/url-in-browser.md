### Problem
What happens when you type in a URL in browser

### Reference
- [check here](http://stackoverflow.com/questions/2092527/what-happens-when-you-type-in-a-url-in-browser)

### Answer
We consider the simplest possible HTTP request
```
1. browser check cache; if requested object is in cache and is fresh, skip to #9
2. browser asks OS for server's IP address
3. OS makes a DNS lookup and replies the IP address to the browser
4. browser opens a TCP connection to server(this step in much more complexed with HTTPS)
5. browser sends the HTTP request through TCP connection
6. browser receives HTTP response and may close the TCP connection, or reuse it for another request
7. browser checks if the response is a redirect (3xx result status code), authorization request (401), error (4xx and 5xx), etc. These are handled differently from normal response (2xx)
8. if cachaeable, response is stored in cache
9. browser decodes response (e.g., if it is ziped)
10. browswer determines what to do with response (e.g., is it a HTML page, is it an image ...)
11. browser render response, of offers a download dialog for unrecognized types
```
