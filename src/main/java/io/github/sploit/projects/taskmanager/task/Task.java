package io.github.sploit.projects.taskmanager.task;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;

    private String description;

    // @ManyToOne(cascade = CascadeType.ALL)
    // private List list;
    // @JoinColumn(name = "task_id")
    
    @Column(name = "created_at", updatable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate createDate;

    @Column(name = "updated_at")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate updateDate;
}
