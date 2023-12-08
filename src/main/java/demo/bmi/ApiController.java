package demo.bmi;

/*
 * Author: Mohammed Amine Malloul
 * Created 05/11/2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService){
        this.apiService = apiService;
    }

    @GetMapping("/fetch")
    public String fetchDataFromApi(){
        return apiService.fetchDataFromApi();
    }
}
