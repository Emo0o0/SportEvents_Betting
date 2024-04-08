package com.example.sportevents_betting.persistence.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InternalLogger {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String logMessage;
    @CreationTimestamp
    private Timestamp timestamp;

}
