package com.example.lab5event.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private int id;
    private String description;
    private int capacity;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}