package com.gl.request;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class LocationRequest {
    private String locationName;
    private int capacity;
}
