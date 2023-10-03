package modena;

import java.io.File;
import java.util.ArrayList;

import modena.infra.db.entity.AdminEntity;
import modena.infra.db.entity.NrEntity;
import modena.infra.db.entity.UserDependentEntity;
import modena.infra.db.entity.UserEntity;
import modena.infra.db.repository.AdminRepository;
import modena.infra.db.repository.NrRepository;
import modena.infra.db.repository.UserDependentRepository;
import modena.infra.db.repository.UserRepository;
import modena.ui.admin.LoginFrameBeans;

public class App {

    public static void main(String[] args) {
        boot();
        // test();
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFrameBeans().setVisible(true);
        });

    }

    private static void test() {

        for (int i = 0; i < 5; i++) {
            // UserEntity userDb = testeUserTable(String.valueOf(i));
        }

        // NrRepository nrRepository = testNrTable(userDb);

        // testUserDependentRepository(userDb);

        // ArrayList<NrEntity> nrs = nrRepository.listByUserId(1);

        // System.out.println(nrs.size());
    }

    private static void testUserDependentRepository(UserEntity userDb) {
        UserDependentEntity userDependentEntity = new UserDependentEntity();
        userDependentEntity.setName("userDependent1");
        userDependentEntity.setAge(10);
        userDependentEntity.setUserId(userDb.getId());
        UserDependentRepository userDependentRepository = new UserDependentRepository();
        userDependentRepository.create(userDependentEntity);
    }

    private static NrRepository testNrTable(UserEntity userDb) {
        NrEntity nrEntity = new NrEntity();
        nrEntity.setName("nr1");
        nrEntity.setTitle("nr1");
        nrEntity.setDate("2023-07-10");
        nrEntity.setUserId(userDb.getId());

        NrRepository nrRepository = new NrRepository();
        nrRepository.create(nrEntity);
        nrRepository.create(nrEntity);
        nrRepository.create(nrEntity);
        nrRepository.create(nrEntity);
        nrRepository.create(nrEntity);
        nrRepository.create(nrEntity);
        nrRepository.create(nrEntity);
        nrRepository.create(nrEntity);
        nrRepository.create(nrEntity);
        return nrRepository;
    }

    private static UserEntity testeUserTable(String text) {
        UserRepository userRepository = new UserRepository();
        UserEntity userEntity = new UserEntity();
        userEntity.setName("user" + text);
        userEntity.setEmail("user_" + text + "@email.com");
        userEntity.setCpf("46260974809");
        userEntity.setRg("5023325642");
        userEntity.setAge(10);
        userEntity.setAsoDate("2023-07-10");
        userEntity.setAddress(new ArrayList<String>() {
            {
                add("Rua 1");
                add("Complemento");
                add("Bairro");
            }
        });
        userEntity.setSalary(2050.40);
        userEntity.setPis("22141232");
        userEntity.setWorkPermit("adm2321322421214151414in");
        userEntity.setMilitaryReservist("21342423");
        userEntity.setHeiringDate("2023-07-10");
        userEntity.setOperationState("admin");
        userEntity.setStatus(true);

        userRepository.create(userEntity);

        UserEntity userDb = userRepository.getByName(userEntity.getName());
        return userDb;
    }

    static void boot() {
        // delete file sqlite_db.db
        File file = new File("sqlite_db.db");
        file.delete();

        AdminRepository adminRepository = new AdminRepository();
        AdminEntity adminEntity = new AdminEntity("admin", "admin", "admin",
                "admin.email@email.com");
        adminRepository.create(adminEntity);
    }
}
