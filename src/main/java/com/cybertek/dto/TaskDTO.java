package com.cybertek.dto;

import com.cybertek.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {

// Project
    // Assigned Employees
    // Task Subject
    // Task Details
    // Status of the task inside the table

    private Long id; // Primary Key
    private ProjectDTO project; // we created Project details under 'ProjectDTO'
    private UserDTO assignedEmployee; // we created employees/users under 'UserDTO'.
    private String taskSubject;
    private String taskDetails;
    private Status taskStatus; // we created project Status ENUMS under 'enums/Status'.
    private LocalDate assignedDate;

    public TaskDTO(ProjectDTO project, UserDTO assignedEmployee, String taskSubject, String taskDetails, Status taskStatus, LocalDate assignedDate) {
        this.project = project;
        this.assignedEmployee = assignedEmployee;
        this.taskSubject = taskSubject;
        this.taskDetails = taskDetails;
        this.taskStatus = taskStatus;
        this.assignedDate = assignedDate;
        this.id= UUID.randomUUID().getMostSignificantBits();  //Unique identifier
    }
}
