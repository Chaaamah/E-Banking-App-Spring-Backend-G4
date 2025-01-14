package ma.mundia.banque_digital_backend.web;

import ma.mundia.banque_digital_backend.services.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatbot")
public class ChatbotController {
    @Autowired
    private GeminiService geminiService;

    @PostMapping("/query")
    public String sendQuery(@RequestParam String message) {
        return geminiService.sendMessage(message);
    }
}
