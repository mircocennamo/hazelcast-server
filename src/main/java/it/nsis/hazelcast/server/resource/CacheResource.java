package it.nsis.hazelcast.server.resource;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.nsis.hazelcast.server.LicensePlateService;
import it.nsis.hazelcast.server.Load;
import it.nsis.model.Status;
import it.nsis.viewmodel.RilevazioneResponseVm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author mirco.cennamo on 20/10/2023
 * @project hazelcast-server
 */
@RestController
@RequestMapping("nsis")
@Slf4j
public class CacheResource {

   @Autowired
   Load load;

   @Autowired
   LicensePlateService licensePlateService;

    @Operation(summary = "initial loader from DB to Cache")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "initial loader started",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Error in initial loader",
                    content = @Content) })
    @GetMapping(path = "scntt/cache/initialLoader/targhe")
    public ResponseEntity startInitialLoader(){
        load.initialLoaderTarghe();
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "status license plate cache")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "return status cache license plate",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Status.class)) }),
            @ApiResponse(responseCode = "500", description = "Error in return status cache license plate",
                    content = @Content) })
    @GetMapping(path = "scntt/cache/status/targhe")
    public ResponseEntity<Status> statusCacheLicensePlate(){
        Status status = licensePlateService.statusCacheLicensePlate();
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @Operation(summary = "status license plate cache")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "return status cache license plate",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Status.class)) }),
            @ApiResponse(responseCode = "500", description = "Error in return status cache license plate",
                    content = @Content) })
    @GetMapping(path = "scntt/cache/size/targhe")
    public ResponseEntity<Integer> sizeCacheLicensePlate(){
        Integer size = licensePlateService.sizeCacheLicensePlate();
        return new ResponseEntity<>(size,HttpStatus.OK);
    }
}



