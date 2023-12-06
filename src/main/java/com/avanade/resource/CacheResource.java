package com.avanade.resource;


import com.avanade.Load;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author mirco.cennamo on 20/10/2023
 * @project spring-boot-kafka-producer
 */
@RestController
@RequestMapping("nsis")
@Slf4j
public class CacheResource {

   @Autowired
   Load load;


    @GetMapping(path = "/initialLoader/targhe")
    public ResponseEntity startInitialLoader(){
        load.initialLoaderTarghe();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
