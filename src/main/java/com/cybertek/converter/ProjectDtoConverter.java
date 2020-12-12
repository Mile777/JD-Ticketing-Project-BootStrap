package com.cybertek.converter;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.TaskDTO;
import com.cybertek.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.crypto.spec.PSource;

@Component // to create an Object
@ConfigurationPropertiesBinding // to auto-bind
public class ProjectDtoConverter implements Converter<String, ProjectDTO> {

    @Autowired
    ProjectService projectService;

    @Override
    public ProjectDTO convert(String source) { // source would print Project Code, unique value/primary key for Project (dto/ProjectDTO/private String projectCode;)

        return projectService.findById(source);
    }
}
