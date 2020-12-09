package com.cybertek.service;

import java.util.List;


// this is Generics: 'CrudService<T,ID>'
// 'T' is type,
// 'ID' is unique identifier (any data type)

public interface CrudService<T,ID> { // GENERICS

    /*
    In stead of doing this for each Interface (under 'service') related to 'dto' :
    UserDTO save(UserDTO user); // whenever we pass the use it will save it.

        UserDTO save(UserDTO user);

        UserDTO findByID(String userName);

        List<UserDTO> findAll();

        void delete(UserDTO user);
        // or:
        void deleteByID(String userName);



        we'll do only in this Interface and all others will extend it:

     */

    T save(T object);

    T findById(ID id);

    List<T> findAll();

    void delete(T object);

    void deleteById(ID id);

    void update(T object); // update the object > Implementation for this method is inside 'AbstractMapService'


}
