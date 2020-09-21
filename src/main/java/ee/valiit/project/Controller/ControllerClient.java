package ee.valiit.project.Controller;

import ee.valiit.project.Entity.ClientEntity;
import ee.valiit.project.Entity.DeviceEntity;
import ee.valiit.project.Service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")

public class ControllerClient {
    @Autowired
    ServiceClient serviceClient;

    //create new client
    @PostMapping("client")
    public void createClient(@RequestBody ClientEntity request) {
        serviceClient.createClient(request.getName());
    }

    //search client_id via client name; and then return all device data via identified client_id
    @GetMapping("client/{name}")
    public List<DeviceEntity> client_id(@PathVariable("name") String name) {
        return serviceClient.getDeviceData(name);
    }

    @GetMapping("clientId/{name}")
    //search client_id via client name
    public int getClientId(@PathVariable("name") String name) {
        return serviceClient.getClientId(name);
    }

    // clients by partial match
//    @GetMapping("clientlike")
//    public List<ClientEntity> searchClient(@RequestParam(name = "nameLike") String nameLike) {
//        return serviceClient.getClientViaName(nameLike);
//    }

    // devices by client name
    @GetMapping("devicelike")
    public List<ClientEntity> getDevicesByClientName(@RequestParam(name = "deviceLike", required = false) String clientLike,
                                                     @RequestParam(name = "productLike", required = false) String productLike,
                                                     @RequestParam(name = "serialNumberLike", required = false) String serialNumberLike) {
        return serviceClient.getDevicesByClientName(clientLike, productLike, serialNumberLike);
    }
}
