package ma.mundia.banque_digital_backend.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class GeminiService {
    private static final String GEMINI_API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent";
    private static final String API_KEY = "AIzaSyALCh-o0IJG8QvJ-hdd1We0WSKXhCU-Pz0"; // Remplacez par votre clé API

    private final RestTemplate restTemplate = new RestTemplate();

    public String sendMessage(String message) {
        // En-têtes de la requête
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Corps de la requête
        String requestBody = String.format("""
            {
                "contents": [
                    {
                        "parts": [
                            {
                                "text": "%s"
                            }
                        ]
                    }
                ]
            }
            """, message);

        // Envoyer la requête à l'API Gemini
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                GEMINI_API_URL + "?key=" + API_KEY,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        // Récupérer la réponse
        return responseEntity.getBody();
    }
}
