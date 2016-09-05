package onlineShop.routes;

/**
 * Created by Damian Bartos
 * 30.08.2016.
 */
public abstract class Route {
    //  MAIN
    private static final String API = "/api";

    private static final String USER = API + "/user";
    private static final String ITEM = API + "/item";
    private static final String ORDER = API + "/order";
    private static final String ADDRESS = API + "/address";
    private static final String CART = API + "/cart";

    //  CRUD
    private static final String CREATE = "/create";
    private static final String READ = "";
    private static final String UPDATE = "/update";
    private static final String DELETE = "/delete";
    private static final String LIST = "/all";
    // for list user /all?page=x%size=y
    private static final String ID = "";

    //  USER
    public static final String REGISTER = USER + "/register";
    public static final String LOGIN = USER + "/login";
    public static final String LOGOUT = USER + "/logout";

    //  ITEM
    public static final String ITEM_CREATE = ITEM + CREATE;
    public static final String ITEM_READ = ITEM + READ + ID;
    public static final String ITEM_READ_LIST = ITEM + READ + LIST;
    public static final String ITEM_UPDATE = ITEM + UPDATE + "";
    public static final String ITEM_DELETE = ITEM + DELETE + "";

    //  ORDER
    public static final String ORDER_CREATE = ORDER + CREATE;
    public static final String ORDER_READ = ORDER + READ + "";
    public static final String ORDER_UPDATE = ORDER + UPDATE + "";
    public static final String ORDER_DELETE = ORDER + DELETE + "";

    //  ADDRESS
    public static final String ADDRESS_CREATE = ADDRESS + CREATE;
    public static final String ADDRESS_READ = ADDRESS + READ + "";
    public static final String ADDRESS_UPDATE = ADDRESS + UPDATE + "";
    public static final String ADDRESS_DELETE = ADDRESS + DELETE + "";

    //  SHOPPING CART
    public static final String CART_CREATE = CART + CREATE;
    public static final String CART_READ = CART + READ + "";
    public static final String CART_UPDATE = CART + UPDATE + "";
    public static final String CART_DELETE = CART + DELETE + "";

}
