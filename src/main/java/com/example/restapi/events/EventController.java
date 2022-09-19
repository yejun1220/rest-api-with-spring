package com.example.restapi.events;

import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Controller
@RequestMapping(value = "/api/events", produces = MediaTypes.HAL_JSON_VALUE)
public class EventController {

    @PostMapping
    public ResponseEntity createEvent(@RequestBody Event event) {
        // created()는 uri가 필요하다.
        URI createdUri = linkTo(EventController.class).slash("{id}").toUri();
        event.setId(1);

        // Header의 Location 정보는 ResponseEntity.created(uri정보)에 의해 만들어진다.
        // 객체를 body에 담을 수도 있고 헤더 정보 등을 셋팅 할수 있기 때문에 ResponseEntity 사용
        return ResponseEntity.created(createdUri).body(event);
    }
}
