package ee.valiit.project.Service;

import ee.valiit.project.Entity.DeviceEntity;
import ee.valiit.project.Repository.RepositoryWO;
import ee.valiit.project.Entity.WorkOrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
public class ServiceWO {
    @Autowired
    public RepositoryWO repositoryWO;

    public void createWO(WorkOrderEntity createWO) {
        repositoryWO.createWO(createWO);
    }

//    //TOPELT
//    public List<WorkOrderEntity> getWorkOrderInfo(int deviceId) {
//        return repositoryWO.getWorkOrderInfo(deviceId);
//    }

    //Get the whole list of work orders
    public List<WorkOrderEntity> getWorkOrderInfoAll() {
        return repositoryWO.getWorkOrderInfoAll();
    }

    //get all work orders info by specific device id, product id, consumable id, technician id or status.
    public List<WorkOrderEntity> getAllWorkOrderInfo(Integer productId, Integer deviceId, Integer consumableId, Integer technicianId, Boolean status) {
        if (productId != null) {
            return repositoryWO.getAllWorkOrderInfoByProductId(productId);
        } else if (deviceId != null) {
            return repositoryWO.getAllWorkOrderInfoByDeviceId(deviceId);
        } else if (consumableId != null) {
            return repositoryWO.getAllWorkOrderInfoByConsumableId(consumableId);
        } else if (technicianId != null) {
            return repositoryWO.getAllWorkOrderInfoByTechnicianId(technicianId);
        } else if (status != null){
            return repositoryWO.getAllWorkOrderInfoByStatus(status);
        } else {
            return repositoryWO.getWorkOrderInfoAll();
        }
    }
        //Update status of specific work order by id
        public void updateWorkOrderStatus (WorkOrderEntity workOrderEntity, Integer id){
            repositoryWO.updateStatus(workOrderEntity, id);
    }
}