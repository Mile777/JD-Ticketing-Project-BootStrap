package com.cybertek.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// This Abstract Class is a mechanism to Save the Data we create/update into the Data Base!

// Abstract Class because we don't want to create any Objects from this class.
//(it is not wrong to be a Class either)
public abstract class AbstractMapService<T,ID> {

                                                // Map is used (Key, Value)
                                                // ex. <1,role1> ; <2, role2> ;
    protected Map<ID,T> map = new HashMap<>();  // Wer are making it Generic so all Interfaces under 'service' package can use it..
                                                // ..'CrudeService', 'ProjectService', 'RoleService', 'UserService'.
                                                // ID= Unique Identifier= 1;
                                                // 'T'= Type= Object= role1

    /* from 'CrudeService' (I):
                                T save(T object);

                                T findById(ID id);

                                List<T> findAll();

                                void delete(T object);

                                void deleteById(ID id);

                                void update(T object);
     */

    T save(ID id,T object){ // to be able to Save it we need an ID (Key) and type of Object (Value), and it will return T.
        map.put(id,object);
        return object;
        // why are we saving and then returning the Object?
        // think of UI, and creating a new user and displaying it inside the User List.
    }


    List<T> findAll(){
        return new ArrayList<>(map.values());   // whatever is inside the 'map' assign it to a list
    }
    //..and return it as ArrayList

    T findById(ID id){      // we'll find it by user ID or Role ID
        return map.get(id); // ..and returns the Object which is the 'id'
    }


    void deleteById(ID id){ // delete by a unique thing, in this case it is 'ID'
        map.remove(id);     //
    }


    void delete(T object){
    // entrySet() is to convert all map Objects to String.
        // and then we 'removeIf(...)' if it equals to the provided 'object'.
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }


    void update(ID id,T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object)); // deleting the Object..
        map.put(id,object); // ..then adding a new one.
                            // We need to update the Abstract method with 'super', 'UserServiceImpl' and 'RoleServiceImpl' > public void update(UserDTO object) {


    }








}
