package com.stringtinyst.healthlife.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exer {
    private int exerciseItemID;
    private String userID;
    private LocalDate recordDate;
    private String exerciseType;
    private int durationMinutes;
    private Integer estimatedCaloriesBurned;

    // Getters and Setters
}
