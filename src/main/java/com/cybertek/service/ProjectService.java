package com.cybertek.service;

import com.cybertek.dto.ProjectDTO;
//                                                             Project Code is unique and its a String
public interface ProjectService extends CrudService<ProjectDTO,String>  {

    // Step 2. (Step 3. implementation/ProjectServiceImpl)
    void comlete(ProjectDTO project);
}
