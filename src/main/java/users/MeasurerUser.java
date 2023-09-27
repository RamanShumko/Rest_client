package users;

import entity.Measurement;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class MeasurerUser {

        private final RestTemplate restTemplate = new RestTemplate();

        public Integer rainyDaysCount() {
            String url = "http://localhost:8080/measurements/rainyDaysCount";

            return restTemplate.getForObject(url, Integer.class);
        }

        public void createMeasurement(Map<String, Object> jsonToSend) {
            String url = "http://localhost:8080/measurements/add";
            String response = restTemplate.postForObject(url, jsonToSend, String.class);
            System.out.println(response);
        }

        public List<Measurement> getAllMeasurements() {
            String url = "http://localhost:8080/measurements";
            ResponseEntity<List<Measurement>> response = restTemplate.exchange(url, HttpMethod.GET,
                    null, new ParameterizedTypeReference<List<Measurement>>() {});

            return response.getBody();
        }
}
