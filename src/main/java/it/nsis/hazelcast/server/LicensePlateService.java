package it.nsis.hazelcast.server;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import it.nsis.model.Rilevazione;
import it.nsis.model.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author mirco.cennamo on 12/12/2023
 * @project hazelcast-server
 */
@Configuration
@Slf4j
public class LicensePlateService {

    @Autowired
    private HazelcastInstance hazelcastInstance;
    private static final String TARGHE = "TARGHE";
    private static final String STATUS = "STATUS";



    public Status statusCacheLicensePlate(){
        IMap<String, Status> statusIMap = hazelcastInstance.getMap(STATUS);
        return    statusIMap.get(TARGHE);
     }

    public Integer sizeCacheLicensePlate(){
        IMap<String, Rilevazione> targhe = hazelcastInstance.getMap(TARGHE);
        return  targhe.keySet().size();
    }
}
