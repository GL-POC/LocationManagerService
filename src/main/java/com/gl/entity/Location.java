package com.gl.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by chethana.nk on 29/3/18.
 */

@Document(collection = "location")
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    private String id;
    private String locationName;
    private int capacity;

}
