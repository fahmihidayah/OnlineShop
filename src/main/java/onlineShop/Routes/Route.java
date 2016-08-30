package onlineShop.routes;

/**
 * Created by Damian Bartos
 * 30.08.2016.
 */
public abstract class Route {
    //  MAIN
    private static final String API = "/api";

    private static final String USER    = API + "/user";
    private static final String ITEM    = API + "/item";
    private static final String ORDER   = API + "/order";
    private static final String ADDRESS = API + "/address";

    //  CRUD
    private static final String CREATE = "/create";
    private static final String READ   = "/";
    private static final String UPDATE = "/update";
    private static final String DELETE = "/delete";

    //  USER
    public static final String REGISTER = USER + "/register";
    public static final String LOGIN    = USER + "/login";
    public static final String LOGOUT   = USER + "/logout";

    //  ITEM
    public static final String ITEM_CREATE = ITEM + CREATE;
    public static final String ITEM_READ   = ITEM + READ + "";
    public static final String ITEM_UPDATE = ITEM + UPDATE + "";
    public static final String ITEM_DELETE = ITEM + DELETE + "";

    //  ORDER
    public static final String ORDER_CREATE = ORDER + CREATE;
    public static final String ORDER_READ   = ORDER+ READ + "";
    public static final String ORDER_UPDATE = ORDER + UPDATE + "";
    public static final String ORDER_DELETE = ORDER + DELETE + "";

    //  ADDRESS
    public static final String ADDRESS_CREATE = ADDRESS + CREATE;
    public static final String ADDRESS_READ   = ADDRESS + READ + "";
    public static final String ADDRESS_UPDATE = ADDRESS + UPDATE + "";
    public static final String ADDRESS_DELETE = ADDRESS + DELETE + "";

}
