package com.gfg.jbdll.config;

import com.gfg.jbdll.domain.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class AppConfig {

    /***
     * Providing custom bean to IoC is via @Bean annotation

     * */

    @Bean
    @Scope("request")
    public Movie movieBean(){
        System.out.println("i am creating a bean of movie");
        Movie movie=new Movie();
        return movie;
    }


    /**
     * Logging in SB
     *
     * 1. ERROR
     * 2. WARNING
     * 3. INFO
     * 4. DEBUG
     * 5. TRACE
     *
     *
     * */



}
