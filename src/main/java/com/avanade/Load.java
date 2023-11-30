package com.avanade;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author mirco.cennamo on 28/11/2023
 * @project hazelcast-server
 */
@Configuration
@Slf4j
 class Load {


    @Autowired
    private HazelcastInstance hazelcastInstance;
    private static final String TARGHE = "TARGHE";

    @Bean
    CommandLineRunner initDatabase() {

        return args -> {
            log.info("start loagind");
            initialLoader(hazelcastInstance);
            log.info("end loadind");


        };
    }

    public static void initialLoader(HazelcastInstance instance) {
        IMap<String, String> targhe = instance.getMap(TARGHE);
        targhe.loadAll(true);
        log.debug("Caricamento targhe terminato ");

    }

}
