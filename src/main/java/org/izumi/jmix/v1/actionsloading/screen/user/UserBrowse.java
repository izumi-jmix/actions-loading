package org.izumi.jmix.v1.actionsloading.screen.user;

import io.jmix.ui.component.GroupTable;
import org.izumi.jmix.v1.actionsloading.entity.User;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("User.browse")
@UiDescriptor("user-browse.xml")
@LookupComponent("usersTable")
@Route("users")
public class UserBrowse extends StandardLookup<User> {

    @Autowired
    private GroupTable<User> usersTable;

    @Install(to = "usersTable.myOwnAction", subject = "enabledRule")
    private boolean usersTableMyOwnActionEnabledRule() {
        return usersTable.getSelected().size() == 2;
    }
}