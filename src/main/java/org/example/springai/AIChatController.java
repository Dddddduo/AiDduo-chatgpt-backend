package org.example.springai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dduoai")
public class AIChatController {

    private final ChatClient chatClient;

    public AIChatController(ChatClient.Builder builder) {
        this.chatClient = builder
                .build();
    }

    @GetMapping("/chat")
    public String chat(String message) {
        return this.chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

}
