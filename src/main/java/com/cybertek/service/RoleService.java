package com.cybertek.service;

import com.cybertek.dto.RoleDTO;
import com.cybertek.dto.UserDTO;

import java.util.List;



// We are passing 'Long' as the Unique Identifier
// because all Rolls we'll share a unique 'Long id'.
public interface RoleService extends CrudService<RoleDTO,Long> {

/*
    RoleDTO save(RoleDTO user); // whenever we pass the use it will save it.

    RoleDTO findByID(long id); //

    List<RoleDTO> findAll(); // to return all the Rols

    void delete(RoleDTO role); //  to delete a role Object
    // or:
    void deleteByID(long id); // delete by role name

 */
}
