package modena.infra.db.entity;

public class AdminEntity extends UserEntity {
    public Role role;

    public AdminEntity(String name, String username, String password, String email) {
        super(name, email, username, password);
        role = Role.ADMIN;
    }

    public enum Role {
        ADMIN, USER
    }

}
