package it.nsis.hazelcast.server.cache;


import com.hazelcast.map.MapStore;
import it.nsis.model.Rilevazione;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.*;

/**
 * @author mirco.cennamo on 28/11/2023
 * @project hazelcast-server
 */
@Slf4j
public class TargheMapStore implements MapStore<String, Rilevazione> {
    @Override
    public synchronized  void store(String s, Rilevazione rilevazione) {
        log.debug("TargheMapStore store :: Non implementato");
    }

    @Override
    public synchronized  void storeAll(Map<String, Rilevazione> map) {
        log.debug("TargheMapStore storeAll :: Non implementato");
    }

    @Override
    public synchronized  void delete(String s) {
        log.debug("TargheMapStore delete :: Non implementato");
    }

    @Override
    public synchronized  void deleteAll(Collection<String> collection) {
        log.debug("TargheMapStore deleteAll :: Non implementato");
    }

    @Override
    public synchronized  Rilevazione load(String key) {
        log.debug("TargheMapStore load :: Non implementato");
       log.debug("la lettura dal DB in casi di miss in cache non è stato implementato per evitare accessi al DB");
       return null;
    }

    @Override
    public synchronized  Map<String, Rilevazione> loadAll(Collection<String> keys) {
        log.debug("[START] TargheMapStore loadAll keys {} "  , keys);
        Map<String, Rilevazione> result = new HashMap<>();
        for(String key:keys){
            result.put(key, createValue(key));
        }
        log.debug("[STOP] TargheMapStore loadAll keys {} and values {} "  , keys ,result);
        return result;
    }

    @Override
    public Iterable<String> loadAllKeys() {
        log.debug("[START] TargheMapStore loadAllKeys");
        List<String> result = null;

          //  result = randomStrings();
                result = new ArrayList<>();
                result.add("ABCD");
                result.add("EFGH");
        log.debug("[STOP] TargheMapStore loadAllKeys  result {} " , result);
        return result;
    }




    private Rilevazione createValue(String key){
        Rilevazione value = new Rilevazione();
        value.setInsertAt(Date.from(Instant.now()));
        value.setUpdateAt(null);
        value.setLicensePlate(key);
        value.setFound(false);
        return  value;
    }

    private String randomString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


    private List<String> randomStrings(){
        List<String> results = new ArrayList<>();
       for(int i=0;i<100;i++){
           results.add(randomString());
       }
       return results;
    }
}
