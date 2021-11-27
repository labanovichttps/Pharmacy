package com.labanovich.constants;

public final class SqlConstants {

    public static final String INSERT_NEW_USER = "INSERT INTO users(login,name, surname, email, password) value (?,?,?,?,?) ";
    public static final String GET_USER_BY_LOGIN = "select id, login, name, surname, email, password from users where login like ? and password like ?";
    public static final String GET_USER_BY_ID = "select id, login, name, surname, email from users where id = ?;";
    public static final String GET_ALL_CURES = """
            select cure.id, name, ct.type, dose, delivery_time, description, price
            from cure
                     inner join cure_type ct on cure.type_id = ct.id;""";

    public static final String ADD_NEW_CURE_INTO_BASKET = "insert into user_order (user_id, cure_id)\n" +
                                                          "values (?, ?);";

    public static final String GET_ALL_CURES_FROM_BASKET = """
                                                           select cure.id,
                                                           cure.name,
                                                           dose,
                                                           delivery_time,
                                                           description,
                                                           type_id,
                                                           price,
                                                           type,
                                                           user_id,
                                                           cure_id,
                                                           order_date
                                                    from cure
                                                             join cure_type ct on cure.type_id = ct.id
                                                             join user_order uo on cure.id = uo.cure_id where user_id = ?;""";
}
