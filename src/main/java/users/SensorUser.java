package users;

import entity.Sensor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class SensorUser {

    private final RestTemplate restTemplate = new RestTemplate();

    public void createSensor(Map<String, Object> jsonToSend) {
        String url = "http://localhost:8080/sensors/registration";
        String response = restTemplate.postForObject(url, jsonToSend, String.class);
        System.out.println(response);
    }

    public List<Sensor> getAllSensors() {
        String url = "http://localhost:8080/sensors";
        ResponseEntity<List<Sensor>> response = restTemplate.exchange(url, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Sensor>>() {});

        return response.getBody();
    }
}
