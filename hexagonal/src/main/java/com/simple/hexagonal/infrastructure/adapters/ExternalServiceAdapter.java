package com.simple.hexagonal.infrastructure.adapters;

import com.simple.hexagonal.domain.models.AdditionalTaskInfo;
import com.simple.hexagonal.domain.ports.output.ExternalServicePort;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter(){
        restTemplate = new RestTemplate();
    }


    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        String apiUrl = "";
        ResponseEntity<JsonPlaceHolderTodo> response = restTemplate.getForEntity(apiUrl,JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = response.getBody();
        if()
    }

    private static class JsonPlaceHolderTodo{
        private Long id;
        private Long userId;

        public Long getId(){
            return id;
        }

        public void setId(Long id){
            this.id = id;
        }

        public Long setUserId(){
            return userId;
        }
        public void setUserId(Long userId){
            this.userId = userId;
        }
    }

    private static class JsonHolderUser{
        private Long id;
        private String name;
        private String email;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
