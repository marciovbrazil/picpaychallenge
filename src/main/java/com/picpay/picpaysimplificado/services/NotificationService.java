package com.picpay.picpaysimplificado.services;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.picpay.picpaysimplificado.domain.user.User;
import com.picpay.picpaysimplificado.dtos.NotificationDTO;

/**
 * NotificationService
 */
@Service
public class NotificationService {

    private final RestTemplate restTemplate;

    NotificationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendNotification(User user, String mensagem) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationDTO = new NotificationDTO(email, mensagem);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", String.class);

        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new Exception("Serviço de notificação esta for do ar");
        }
    }
}