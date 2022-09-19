package com.example.restapi.events;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {

    @Test
    void builder() {
        Event event = Event.builder()
                .name("")
                .build();

        assertThat(event).isNotNull();
    }

    @Test
    void javaBeanSpec() {
        // given
        String name = "Event";

        // when
        Event event = new Event();
        event.setName(name);

        // then
        assertThat(event.getName()).isEqualTo(name);
    }
}