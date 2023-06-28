package modena;

import modena.infra.db.entity.AdminEntity;
import modena.infra.db.repository.AdminRepository;
import modena.ui.admin.LoginFrameBeans;

public class App {

    public static void main(String[] args) {

        AdminRepository adminRepository = new AdminRepository();
        AdminEntity adminEntity = new AdminEntity("admin", "admin", "admin",
                "admin.email@email.com");
        adminRepository.create(adminEntity);

        java.awt.EventQueue.invokeLater(() -> {
            new LoginFrameBeans().setVisible(true);
        });

    }

}
