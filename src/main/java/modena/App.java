package modena;

import modena.infra.db.entity.AdminEntity;
import modena.infra.db.entity.NrEntity;
import modena.infra.db.entity.UserEntity;
import modena.infra.db.repository.AdminRepository;
import modena.infra.db.repository.NrRepository;
import modena.infra.db.repository.UserRepository;
import modena.infra.db.sqlite.connect.ConnectionManagerSQLite;
import modena.ui.admin.LoginFrameBeans;

public class App {

    public static void main(String[] args) {
        boot();
        test();
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFrameBeans().setVisible(true);
        });

    }

    private static void test() {

        UserRepository userRepository = new UserRepository();
        UserEntity userEntity = new UserEntity();
        userEntity.setName("new user");
        userEntity.setEmail("user1@email.com");
        userEntity.setCpf("46260974809");
        userEntity.setRg("5023325642");
        userEntity.setAddress("rua1%bloco1%apto1%bairro1%cidade1%cep1");
        userEntity.setSalary(0);
        userEntity.setPis("22141232");
        userEntity.setWorkPermit("adm2321322421214151414in");
        userEntity.setMilitaryReservist("21342423");
        userEntity.setHeiringDate("2023-07-10");
        userEntity.setOperationState("admin");
        userEntity.setStatus(true);

        userRepository.create(userEntity);

        UserEntity userDb = userRepository.getByName(userEntity.getName());

        NrEntity nrEntity = new NrEntity();
        nrEntity.setName("nr1");
        nrEntity.setTitle("nr1");
        nrEntity.setDate("2023-07-10");
        nrEntity.setUserId(userDb.getId());

        NrRepository nrRepository = new NrRepository();
        nrRepository.create(nrEntity);

    }

    static void boot() {

        AdminRepository adminRepository = new AdminRepository();
        AdminEntity adminEntity = new AdminEntity("admin", "admin", "admin",
                "admin.email@email.com");
        adminRepository.create(adminEntity);
    }
}
