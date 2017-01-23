package by.zhukovski.elibrary.service.factory;

import by.zhukovski.elibrary.service.EditService;
import by.zhukovski.elibrary.service.ViewService;
import by.zhukovski.elibrary.service.impl.EditServiceImpl;
import by.zhukovski.elibrary.service.impl.ViewServiceImpl;

/**
 * Created by sleipnir on 18.1.17.
 */
public class ServiceFactory {
    private static final ServiceFactory FACTORY = new ServiceFactory();

    private EditService editService = new EditServiceImpl();
    private ViewService viewService = new ViewServiceImpl();

    public static ServiceFactory getFactory() {
        return FACTORY;
    }

    public EditService getEditService() {
        return editService;
    }

    public  ViewService getViewService() {
        return  viewService;
    }

}
