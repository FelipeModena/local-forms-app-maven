package modena.infra.usecase.user;

import java.util.List;

import com.toedter.calendar.JDateChooser;

import modena.infra.db.repository.AdminRepository;
import modena.infra.usecase.model.NrModel;
import modena.infra.usecase.model.UserDependentModel;

public class CreateNewUserUseCase {
    private AdminRepository adminRepository = new AdminRepository();

    public void createNewUser(User user) {

    }

    class User {
        private String name;
        private String cpf;
        private String rg;
        private int age;
        private String workPermit;
        private String pis;
        private String militaryReservist;
        private String adressStreet;
        private String addressComplement;
        private String addressNeighborhood;
        private String addressCity;
        private String addressCode;
        private JDateChooser heiringDate;
        private float salary;
        private String operationState;
        private List<NrModel> nrsList;
        private List<UserDependentModel> dependents;

        public User(String name, String cpf, String rg, int age, String workPermit, String pis,
                String militaryReservist, String adressStreet, String adressComplement, String adressNeighborhood,
                String adressCity, String adressCode, JDateChooser heiringDate, float salary, String operationState,
                List<NrModel> nrsList, List<UserDependentModel> dependents) {
            this.name = name;
            this.cpf = cpf;
            this.rg = rg;
            this.age = age;
            this.workPermit = workPermit;
            this.pis = pis;
            this.militaryReservist = militaryReservist;
            this.adressStreet = adressStreet;
            this.addressComplement = adressComplement;
            this.addressNeighborhood = adressNeighborhood;
            this.addressCity = adressCity;
            this.addressCode = adressCode;
            this.heiringDate = heiringDate;
            this.salary = salary;
            this.operationState = operationState;
            this.nrsList = nrsList;
            this.dependents = dependents;
        }
    }
}
