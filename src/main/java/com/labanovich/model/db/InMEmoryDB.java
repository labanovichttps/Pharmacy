package com.labanovich.model.db;

import com.labanovich.model.entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class InMEmoryDB  {
    private static Map<User, String> users = new HashMap<>();
    static {
        users.put(new User(1, "admin", "Alex", "Smith", "admin@gmail.com"), "q123");
    }


    public static User selectUserByLoginAndPassword(String login, String password){
        User user = new User(login);
        String pass = users.get(user);
        if(Objects.nonNull(pass) && pass.equals(password)){
            user = users.keySet()
                    .stream()
                    .filter(user::equals)
                    .findFirst()
                    .get();

        }else {
            user = null;
        }
        return user;
    }
}
