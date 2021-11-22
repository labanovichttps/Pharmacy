package com.labanovich.constants;

public final class SqlConstants {

    public static final String INSERT_NEW_USER = "INSERT INTO users(login,name, surname, email, password) value (?,?,?,?,?) ";
    public static final String GET_USER_BY_LOGIN = "select id, login, name, surname, email, password from users where login like ? and password like ?";
    public static final String GET_ALL_COURSES = "select id, title, subtitle, description, date, place, author, status, type, user_id\n" +
                                                 "from courses;";
}
