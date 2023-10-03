package modena.infra.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modena.infra.db.entity.common.CommonEntity;
import modena.infra.usecase.model.NrModel;
import modena.infra.usecase.model.UserDependentModel;

public class UserEntity extends CommonEntity {
    private String name;
    private String email;
    private String username;
    private String cpf;
    private String rg;
    private int age;
    private String workPermit;
    private String pis;
    private String militaryReservist;
    private String address;
    private Date heiringDate;
    private Date asoDate;

    private double salary;
    private String operationState;
    private List<NrModel> nrsList;
    private List<UserDependentModel> dependents;
    private String password;
    public boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UserEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        // remove all special characters
        this.cpf = cpf.replaceAll("[^\\d]", "");
    }

    public String getRg() {

        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg.replaceAll("[^\\d]", "");

        this.rg = rg;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWorkPermit() {
        return workPermit;
    }

    public void setWorkPermit(String workPermit) {
        // remove all special characters
        String workPermitWithoutSpecialCharacters = workPermit.replaceAll("[^0-9]", "");

        if (workPermitWithoutSpecialCharacters.isEmpty()) {

            throw new IllegalArgumentException("Work permit must be a number");
        } else {
            this.workPermit = workPermitWithoutSpecialCharacters;
        }
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis.replaceAll("[^\\d]", "");
    }

    public String getMilitaryReservist() {
        return militaryReservist;
    }

    public void setMilitaryReservist(String militaryReservist) {
        this.militaryReservist = militaryReservist.replaceAll("[^\\d]", "");

    }

    public String getAsoDate() {
        return convertDateToYearMonthDay(this.asoDate);

    }

    public void setAsoDate(String asoDate) {
        this.asoDate = convertYearMonthDayToDate(asoDate);

    }

    public String getHeiringDate() {
        return convertDateToYearMonthDay(this.heiringDate);
    }

    public void setHeiringDate(String heiringDate) {
        this.heiringDate = convertYearMonthDayToDate(heiringDate);

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getOperationState() {
        return operationState;
    }

    public void setOperationState(String operationState) {
        this.operationState = operationState;
    }

    public List<NrModel> getNrsList() {
        return nrsList;
    }

    public void setNrsList(List<NrModel> nrsList) {
        this.nrsList = nrsList;
    }

    public List<UserDependentModel> getDependents() {
        return dependents;
    }

    public void setDependents(List<UserDependentModel> dependents) {
        this.dependents = dependents;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {

        String[] address = new String[this.address.split("%").length];
        return this.address;
    }

    public void setAddress(ArrayList<String> listAddressStrings) {
        String address = "";
        for (String string : listAddressStrings) {
            address += string + "%";
        }
        this.address = address;
    }

    public void setAddressRepository(String address) {
        this.address = address;
    }

}
