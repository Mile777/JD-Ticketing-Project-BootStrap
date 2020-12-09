package com.cybertek.dto;

import com.cybertek.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor // to pass an empty Object
@AllArgsConstructor // to create an Object based on dummy data
@Getter // in MVC everything is getting behind Getters ...
@Setter // ... and Setters

    // Based on 'project/crate.html/UI (Administration > Project Create) we determine what we need: ...
    //  ...Project Name, Project Code, Assigned Manager, Project Start Date, Project End Date...
public class ProjectDTO {



    private String projectName;
    private String projectCode;
    private UserDTO assignedManager; // 'UserDTO' will give us this Object.

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String projectDetail;
    private Status projectStatus; // ENUM created under 'enums > Status'



}
