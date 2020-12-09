package com.cybertek.service;

import com.cybertek.dto.UserDTO;

import java.util.List;

/*
In stead of doing this for each Interface (under 'service') related to 'dto' :
    UserDTO save(UserDTO user); // whenever we pass the user it will save it.

    UserDTO findByID(String userName); //

    List<UserDTO> findAll(); // to return all the users

    void delete(UserDTO user); //  to delete a user Object
        // or:
    void deleteByID(String userName); // delete by user name

...we'll create Generics: 'CrudeService<T,ID> and extend it.
    - 'T' is Type. 'ID' is Unique Identifier and it can be any data type (String, Long, Object...)

*/

// We are passing 'String'
// because String firstName, lastName, userName, phone are all unique Strings for all Users
public interface UserService extends CrudService<UserDTO,String> {



    // Specific to 'UserService':

    List<UserDTO> findManagers();

    List<UserDTO> findEmloyees();







}
