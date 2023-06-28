package modena.infra.usecase;

import modena.infra.db.entity.AdminEntity;
import modena.infra.db.repository.AdminRepository;

public class AdminUsecase {

    private AdminRepository adminRepository = new AdminRepository();

    public boolean loginUser(String username, String password) {
        AdminEntity adminEntity = toEntity(username, password);
        adminEntity = adminRepository.read(adminEntity);

        if (adminEntity != null) {

            adminRepository.put("logged", "true");
            return true;
        } else {
            return false;
        }
    }

    public boolean checkLoggedUser() {
        return true;

    }

    private AdminEntity toEntity(String name, String password) {
        return new AdminEntity(null, name, password, null);
    }

}
