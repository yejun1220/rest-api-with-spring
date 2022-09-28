package com.example.restapi.events;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest(name = "{index}: basePrice={0}, maxPrice={1}, isFree={2}")
    @CsvSource({
            "0, 0, true",
            "100, 0, false",
            "0, 1000, false"
    })
    void testFree(int basePrice, int maxPrice, boolean isFree) {
        // given
        Event freeEvent = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();

        // when
        freeEvent.update();

        // then
        assertThat(freeEvent.isFree()).isEqualTo(isFree);

    }

    @ParameterizedTest(name = "{index}: location={0}, isOffline={1}")
    @CsvSource({
            "강남, true",
            ", false"

    })
    void testOffline(String location, boolean isOffline) {
        // given
        Event hasLocationEvent = Event.builder()
                .location(location)
                .build();

        // when
        hasLocationEvent.update();

        // then
        assertThat(hasLocationEvent.isOffline()).isEqualTo(isOffline);
    }
}