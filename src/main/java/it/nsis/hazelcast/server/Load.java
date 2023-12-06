package it.nsis.hazelcast.server;

import it.nsis.hazelcast.server.cache.InitialLoaderException;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import it.nsis.model.EnumStatus;
import it.nsis.model.Rilevazione;
import it.nsis.model.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * @author mirco.cennamo on 28/11/2023
 * @project hazelcast-server
 */
@Configuration
@Slf4j
public class Load {


    @Autowired
    private HazelcastInstance hazelcastInstance;
    private static final String TARGHE = "TARGHE";
    private static final String STATUS = "STATUS";



    public  void initialLoaderTarghe() {
        IMap<String, Rilevazione> targhe = hazelcastInstance.getMap(TARGHE);
        IMap<String, Status> statusIMap = hazelcastInstance.getMap(STATUS);
       Status statusTarghe =   statusIMap.get(TARGHE);
       if(statusTarghe!=null && (statusTarghe.getStatus()== EnumStatus.READY || statusTarghe.getStatus()== EnumStatus.RUNNING )){
           log.debug("stato cache targhe {} non permette initial loader ", statusTarghe.getStatus());
           throw new InitialLoaderException("Initial Loader failed ::: status " + statusTarghe.getStatus() );
       }
       if(statusTarghe==null){
           statusTarghe = new Status();
           statusTarghe.setInsertAt(LocalDateTime.now());
       }else{
           statusTarghe.setUpdateAt(LocalDateTime.now());
       }
        targhe.loadAll(true);
        log.debug("Caricamento targhe terminato ");
        statusTarghe.setStatus(EnumStatus.READY);
        ;
        statusIMap.put(TARGHE,statusTarghe);

    }

}
