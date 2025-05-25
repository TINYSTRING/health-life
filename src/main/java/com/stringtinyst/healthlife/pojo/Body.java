package com.stringtinyst.healthlife.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Body {
    private int bodyMetricID;
    private String userID;
    private BigDecimal heightCM;
    private BigDecimal weightKG;
    private LocalDate recordDate; // 改为 LocalDate

    // Getters and Setters
}
