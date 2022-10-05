package com.sm.whale.user

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@CrossOrigin("*")
@RestController
class UserController {

    @GetMapping("")
    fun print():String {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.
        newBuilder().
        uri(URI.create("https://kauth.kakao.com/oauth/authorize?client_id=67b953cbc8d4605993e7dddfaffa3830&redirect_uri=http://localhost:8080/oauth&response_type=code")).build();
        println(
                client.sendAsync(request,HttpResponse.BodyHandlers.ofString()).thenAccept(System.out::println).join()
        );

        return "Hello World"
    }

    @GetMapping("/oauth")
    fun oauthRedirect():String {
        return "login success"
    }
}