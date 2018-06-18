package com.gl.response;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class LocationResponse {
    private String id;
    private String locationName;
    private int capacity;
}
