package com.labanovich.constants;

public final class SqlConstants {

    public static final String INSERT_NEW_USER = "INSERT INTO users(login,name, surname, email, password) value (?,?,?,?,?) ";
    public static final String GET_USER_BY_LOGIN = "select id, login, name, surname, email, password from users where login like ? and password like ?";
    public static final String GET_USER_BY_ID = "select id, login, name, surname, email from users where id = ?;";
    public static final String GET_ALL_CURES = """
            select cure.id, name, ct.type, dose, delivery_time, description, price
            from cure
                     inner join cure_type ct on cure.type_id = ct.id;""";

    public static final String ADD_NEW_CURE_INTO_BASKET = "insert into user_basket (user_id, cure_id)\n" +
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
                   ub.id basket_cure_id,
                   ub.user_id,
                   ub.cure_id,
                   order_date
            from cure
                     join cure_type ct on cure.type_id = ct.id
                     join user_basket ub on cure.id = ub.cure_id
            where user_id = ?;""";

    public static final String DELETE_CURE_FROM_BASKET = """
            delete from user_basket
                            where id = ?;
            """;

    public static final String PLACE_THE_ORDER = """
                        update user_basket
                        set order_date = current_timestamp
                        where user_id = ?;
                        
                        INSERT INTO `user-order` (user_initials, user_email, total, order_time)
                        select concat(u.name, ' ', u.surname) user_initials, u.email, sum(c.price) total, ub.order_date
                        from users u
                                 join user_basket ub on u.id = ub.user_id
                                 join cure c on c.id = ub.cure_id
                                where ub.user_id = 1
                        group by ub.order_date;
                        
                        insert into user_order_cures (user_id, cure_id, order_date)
                        select user_id, cure_id, order_date
                        from user_basket ub
                        where ub.user_id = ?;
                        
                        delete from user_basket
                        where user_id = ?;
            """;
    public static final String GET_ALL_ORDERS = "select id, user_initials, user_email, total, order_time\n" +
                                                "from `user-order`;";

    public static final String EDIT_USER = """
            update users
            set name = ?, surname = ?, email = ?
            where id = ?;""";

}
