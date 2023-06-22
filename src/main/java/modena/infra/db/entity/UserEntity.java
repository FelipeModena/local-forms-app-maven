package modena.infra.db.entity;

import modena.infra.db.entity.common.CommonEntity;

public class UserEntity extends CommonEntity {
    public String name;
    public String email;
    public String username;

    public UserEntity(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String password;

}
