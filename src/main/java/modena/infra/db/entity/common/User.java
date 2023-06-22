package modena.infra.db.entity.common;

public class User extends CommonEntity {

    public String name;
    public String email;
    public String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
