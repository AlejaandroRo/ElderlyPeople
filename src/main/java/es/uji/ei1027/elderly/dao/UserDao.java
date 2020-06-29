package es.uji.ei1027.elderly.dao;

import es.uji.ei1027.elderly.model.UserDetails;
import java.util.Collection;

public interface UserDao {
    UserDetails loadUserByUsername(String username, String password);
}
