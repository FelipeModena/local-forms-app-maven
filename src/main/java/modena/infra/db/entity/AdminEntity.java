package modena.infra.db.entity;

public class AdminEntity extends UserEntity {
    public Role role;

    public AdminEntity(String name, String username, String password, String email) {
        setName(name);
        setPassword(password);
        setUsername(username);
        setEmail(email);
        role = Role.ADMIN;
    }

    public enum Role {
        ADMIN, USER
    }

}
