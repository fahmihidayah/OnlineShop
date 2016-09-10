package onlineShop.routes;

/**
 * Created by Damian Bartos
 * 30.08.2016.
 */
public abstract class Route {
    //  MAIN
    private static final String API = "/api";
    private static final String PUBLIC = "/public";

    private static final String USER = "/user";
    private static final String ITEM = "/item";
    private static final String ORDER = "/order";
    private static final String ADDRESS ="/address";
    private static final String CART = "/cart";
    private static final String AUTH = "/auth";

    //  CRUD
    private static final String ADD = "/add";
    private static final String CREATE = "/create";
    private static final String READ = "";
    private static final String UPDATE = "/update";
    private static final String DELETE = "/delete";
    private static final String LIST = "/all";  // for list /all?page=x%size=y
    private static final String ID = "";        // for id   /?id=x
    private static final String MAX_ELEM = "/num";

    //  AUTH
    public static final String REGISTER = PUBLIC + AUTH + "/register";

    //  USER
    public static final String USER_READ = API + USER + READ + ID;
    public static final String USER_CURRENT_USER = API + USER + READ + "/my";
    public static final String USER_LIST = API + USER + READ + LIST;
    public static final String USER_UPDATE = API + USER + UPDATE;
    public static final String USER_DELETE = API + USER + DELETE;
    public static final String USER_CHANGE_ROLE = API + USER + "/role";

    //  ITEM
    public static final String ITEM_CREATE = API + ITEM + CREATE;
    public static final String ITEM_READ = PUBLIC + ITEM + READ + ID;
    public static final String ITEM_READ_LIST = PUBLIC + ITEM + READ + LIST;
    public static final String ITEM_UPDATE = API + ITEM + UPDATE + "";
    public static final String ITEM_DELETE = API + ITEM + DELETE + "";
    public static final String ITEM_MAX_ELEM = PUBLIC + ITEM + MAX_ELEM;

    //  ORDER
    public static final String ORDER_CREATE = API + ORDER + CREATE;
    public static final String ORDER_READ = API + ORDER + READ + "";

    //  SHOPPING CART
    public static final String CART_ADD = PUBLIC + CART + ADD;
    public static final String CART_REMOVE = PUBLIC + CART + DELETE;
    public static final String CART_READ = API + CART + READ;

}
