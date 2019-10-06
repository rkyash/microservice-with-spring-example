package com.rkyash.userDemo.repository;

import com.rkyash.userDemo.dto.User;
import com.rkyash.userDemo.service.UserService;
import com.rkyash.userDemo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    List<User> userList=new ArrayList<>();


    public List<User> getAllUsers() {
        return userList;
    }

    public User getUser(String id) {
        Optional<User> firstList=userList.stream()
                .filter(u->u.getId().equals(id))
                .findFirst();
        if(firstList.isPresent())
            return firstList.get();
        else
        return new User();
    }

    public void addUser(User user) {
            userList.add(user);
    }

    public User updateUser(User user) {
        for (User u:userList){
            if (u.getId().equals(user.getId())){
                u.setName(user.getName());
                u.setAddress(user.getAddress());
                return u;
            }
        }
        return new User();
    }

    public User deleteUser(String id) {
       Optional<User> findUser=userList.stream()
               .filter(u->u.getId().equals(id))
               .findFirst();
       if (findUser.isPresent()){
           User user=findUser.get();
           userList.remove(user);
           return user;
       }else{
           return new User();
       }
    }
}
