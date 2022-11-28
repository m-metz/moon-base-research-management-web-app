
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuildingController {

    @RequestMapping(path = "api/v1/building")
    public class BaseController {
    private final BuildingService buildingService;

    @Autowired
    public BaseController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping
    public List<Building> getBases() {
        return buildingService.getAllBuildings();
    }

    
}
