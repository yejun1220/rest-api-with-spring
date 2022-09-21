package com.example.restapi.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class EventValidator {
    public void validEventDto(EventDto eventDto, Errors errors) {
        if(eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() > 0) {
        errors.rejectValue("basePrice", "wrongValue", "basePrice is wrong");
        }
    }
}
