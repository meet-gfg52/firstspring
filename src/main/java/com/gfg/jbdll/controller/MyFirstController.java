package com.gfg.jbdll.controller;

import com.gfg.jbdll.config.AppConfig;
import com.gfg.jbdll.domain.Movie;
import com.gfg.jbdll.service.GreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyFirstController {


    /***
     *
     * API ->
     * it let's you communicate with servers
     * Types of commnunication
     * 1. Statefull
     *     req -1 bankwebsite.com/transactions -> 1 - 10 transactions
     *     req -2 bankwebsite.com/transactions -> 11- 20 transactions
     *     req -3 bankwebsite.com/transactions -> 21- 30 transactions
     *     req -4 bankwebsite.com/transactions -- EMPTY response
     * 2. Stateless
     *
     *          req -1 bankwebsite.com/transactions?start=1&end=10 -> 1 - 10 transactions
     *          req -2 bankwebsite.com/transactions?start=1&end=10 -> 1- 10 transactions
     *          req -3 bankwebsite.com/transactions?start=20&end=30-> 20 -30 transactions
     *          req -4 bankwebsite.com/transactions?start=11&end=20-- 11 -20 transaction
     *
     *           query param
     *           bankwebsite.com/transactions?page=1
     *             path-variable
                 bankwebsite.com/transactions/1/10

                google.com/photos/family/kid?user=john

                google.com/photos/john/family/kid
     *
     * Statefull -> SOAP  ( by default SOAP is stateless but can be used as State full)
     *
     * <MOVIE>
     *     <TITLE>MIB</TITLE>
     *     <GENRE>ACTION</GENRE>
     * </MOVIE>
     *
     * Stateless -> REST (Representational State Transfer)
     *
     * There is no strict structure for REST.
     * It could be JSON( widly used)
     * Image, PDF, CSV
     *
     * example JSON:
     * {
     *     "title":"MIB",
     *     "genre":"ACTION"
     * }
     *
     * REST HTTP request Types
     * 1. GET -> get's the resource from the server
     * 2. POST -> create a new resource in the application
     * 3. DELETE -> delete the resource in the application
     * 4. PUT -> updating the resource in the application -> create a new copy of entire resource
     * 5. PATCH -> updating the resource in the application -> update the same copy
     * OPTIONS ( get the response/ request options & types for an API)
     * HEAD (to give the topmost sample resource)
     * TRACE( get response with the server trace)
     *
     *
     * API contract if mututally agreed
     * API documentation if release for public
     *
     * steps:
     *  1. endpoint ex:/movie..
     *  2. Request type: POST/PUT/DELETE
     *  3. Request body
     *  4. Success & failure response
     *  5. HTTP status codes -> https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
     *
     * Successful response
     * {
     *      "title":"MIB",
     *       "genre":"ACTION"
     * }
     * Failure response: fjwejf
     * {
     *    "title":"",
     *    "genre":""
     * }
     *
     *              Safety & Idempotence
     *
     * GET          yes & yes
     * POST         no & no
     * PUT          no & yes
     * DELETE       no & yes
     * PATCH        no & yes
     *
     *
     * For SpringBoot, API request type can be mentioned in 2 ways:
     * 1. Generic annotation -> @RequestType(value="/greet",method=RequestMethod.GET)
     * 2. @GetMapping, @PostMapping
     * */

    MyFirstController(){
        System.out.println("^^^^^^^^^^^^^^i am called");
    }


    @Autowired
    ApplicationContext context;

    /**
     *Type: GET
     * Endpoint: /greet
     * */

    /**
     * Get via request param
     * */   @GetMapping(value="/greet")
    public String greetUser(@RequestParam("abc") String name,@RequestParam("pqr") String lastName){
        GreetService service=new GreetService();
        return service.greetUser(name);

    }

    @GetMapping(value="/greet/{name}")
    public String greetUserViaPath(@PathVariable("name") String name){
        System.out.println("in greet controller:"+ context.getBean(Movie.class).hashCode());
        GreetService service=new GreetService();
        return service.greetUser(name);
    }

}
