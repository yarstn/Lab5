package com.example.lab5event.Controller;

import com.example.lab5event.ApiMessage.ApiMessage;
import com.example.lab5event.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/event")
public class EvantController {
    ArrayList<Event> events = new ArrayList<>();

    @GetMapping("/events")
    public ArrayList<Event> getEvents() {
        return events;
    }

    @PostMapping("/add")
    public ApiMessage addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiMessage("Event added");
    }

    @PutMapping("/update/{index}")
    public ApiMessage updateEvent(@RequestBody Event event, @PathVariable int index) {
        if (index < 0 || index >= events.size()) {
            return new ApiMessage("Index out of bounds");
        }
        events.set(index, event);
        return new ApiMessage("Event updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiMessage deleteEvent(@PathVariable int index) {
        if (index < 0 || index >= events.size()) {
            return new ApiMessage("Index out of bounds");
        }
        events.remove(index);
        return new ApiMessage("Event deleted");
    }

    @GetMapping("/all-event")
    public ArrayList<Event> getAllEvents() {
        return events;
    }

    @PutMapping("/capacity/{index}/{capacity}")
    public ApiMessage setCapacity(@PathVariable int index, @PathVariable int capacity) {
        if (index < 0 || index >= events.size()) {
            return new ApiMessage("Index out of bounds");
        }
        Event event = events.get(index);
        event.setCapacity(capacity);
        events.set(index, event);
        return new ApiMessage("Event updated");
    }

    @GetMapping("/search/{id}")
    public ApiMessage searchEvent(@PathVariable int id,Event event) {
        if (id < 0 || id >= events.size()) {
            return new ApiMessage("Index out of bounds");
        }
         event = events.get(id);
        return new ApiMessage("Event found");
    }
}