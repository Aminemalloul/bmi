package demo.bmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);

    @Value("${api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String fetchDataFromApi() {
        try {
            // Make the request
            return restTemplate.getForObject(apiUrl, String.class);
        } catch (HttpStatusCodeException e) {
            // Log the status code in case of an error
            logger.error("HTTP Status Code: {}", e.getStatusCode());
            throw e;
        }
    }
}