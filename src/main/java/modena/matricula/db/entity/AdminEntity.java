package modena.matricula.db.entity;

public class AdminEntity {

    public String name;
    public String email;
    public String password;

    public enum Role {
        ADMIN, USER
    }

    public AdminEntity(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
