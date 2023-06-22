package modena;

import modena.infra.db.entity.AdminEntity;
import modena.infra.db.repository.AdminRepository;
import modena.ui.admin.AdminLoginFrame;

public class App {
    public static void main(String[] args) {

        AdminLoginFrame adminLoginFrame = new AdminLoginFrame();
        adminLoginFrame.initialize();
        AdminRepository adminRepository = new AdminRepository();

        AdminEntity adminEntity = new AdminEntity("admin", "admin", "admin", "admin.email@email.com");
        adminRepository.create(adminEntity);
        // MenuFrame menuFrame = new MenuFrame();
        // menuFrame.initialize();
    }

}
