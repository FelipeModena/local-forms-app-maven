/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modena.ui.appFrames.forms.newUserForms;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import modena.infra.db.entity.UserDependentEntity;
import modena.infra.db.entity.UserEntity;
import modena.infra.db.repository.UserDependentRepository;
import modena.infra.db.repository.UserRepository;

/**
 *
 * @author felip
 */
public class NewUserFormsFrameBusiness {

    public class NewUserFormsFrameBusinessProps {
        String name;
        int age;
        String email;
        String cpf;
        String rg;
        ArrayList<String> address;
        double salary;
        String pis;
        String workPermit;
        String militaryReservist;
        Date heiringDate;
        String operationState;
        Date asoDate;
        String jobFunction;
        String operationSite;
        ArrayList<UserDependentProps> userDependents;

        public NewUserFormsFrameBusinessProps(String name, int age, String email, String cpf, String rg,
                ArrayList<String> address, double salary, String pis, String workPermit, String militaryReservist,
                Date heiringDate, String operationState, Date asoDate, String jobFunction, String operationSite) {
            this.name = name;
            this.age = age;
            this.email = email;
            this.cpf = cpf;
            this.rg = rg;
            this.address = address;
            this.salary = salary;
            this.pis = pis;
            this.workPermit = workPermit;
            this.militaryReservist = militaryReservist;
            this.heiringDate = heiringDate;
            this.operationState = operationState;
            this.asoDate = asoDate;
            this.jobFunction = jobFunction;
            this.operationSite = operationSite;
        }

    }

    class UserDependentProps {
        String name;
        int age;
        String dependency;
        public UserDependentProps(String name, int age, String dependency) {
            this.name = name;
            this.age = age;
            this.dependency = dependency;
        }

    }

    public int createNewUser(NewUserFormsFrameBusinessProps newUserFormsFrameBusinessProps) {
        int response=-1;
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            UserRepository userRepository = new UserRepository();
            UserEntity userEntity = new UserEntity();

            userEntity.setName(newUserFormsFrameBusinessProps.name);
            userEntity.setAge(newUserFormsFrameBusinessProps.age);
            userEntity.setEmail(newUserFormsFrameBusinessProps.email);
            userEntity.setCpf(newUserFormsFrameBusinessProps.cpf);
            userEntity.setRg(newUserFormsFrameBusinessProps.rg);
            userEntity.setAddress(newUserFormsFrameBusinessProps.address);
            userEntity.setSalary(newUserFormsFrameBusinessProps.salary);
            userEntity.setPis(newUserFormsFrameBusinessProps.pis);
            userEntity.setWorkPermit(newUserFormsFrameBusinessProps.workPermit);
            userEntity.setMilitaryReservist(newUserFormsFrameBusinessProps.militaryReservist);
            userEntity.setHeiringDate(dateFormat.format(newUserFormsFrameBusinessProps.heiringDate));
            userEntity.setOperationState(newUserFormsFrameBusinessProps.operationState);
            userEntity.setAsoDate(dateFormat.format(newUserFormsFrameBusinessProps.asoDate));
            userEntity.setStatus(true);

            response = userRepository.create(userEntity).getId();

            // response.data={};

        } catch (IllegalArgumentException e) {
            e.getMessage();
            response=0;
            // TODO: handle exception
        }

        return response;
    }
    public int createUserDependents(int id, ArrayList<UserDependentProps> userDependentProps){
        try {
                ArrayList<UserDependentEntity> userDependentEntities = new ArrayList<UserDependentEntity>();
            for (UserDependentProps user : userDependentProps) {
                UserDependentEntity userDependentEntity = new UserDependentEntity();
                userDependentEntity.setName(user.name);
                userDependentEntity.setAge(user.age);
                userDependentEntity.setDependency(user.dependency);
                userDependentEntity.setUserId(id);

                userDependentEntities.add(userDependentEntity);
            }

            UserDependentRepository userDependentRepository = new UserDependentRepository();
            userDependentRepository.createByList(userDependentEntities);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 1;
    }

}
