package modena.infra.db.entity;

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
    private String adressStreet;
    private String addressComplement;
    private String addressNeighborhood;
    private String addressCity;
    private String addressCode;
    private Date heiringDate;
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
        this.workPermit = workPermit.replaceAll("[^\\d]", "");
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

    public String getAdressStreet() {
        return adressStreet;
    }

    public void setAdressStreet(String adressStreet) {
        this.adressStreet = adressStreet;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    public String getAddressNeighborhood() {
        return addressNeighborhood;
    }

    public void setAddressNeighborhood(String addressNeighborhood) {
        this.addressNeighborhood = addressNeighborhood;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getHeiringDate() {
        return convertDateToYearMonthDay(this.heiringDate);
    }

    public void setHeiringDate(String heiringDate) {
        this.heiringDate = convertYearMonthDayToDate(heiringDate);

        System.out.println(this.heiringDate.toString());
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
        return this.adressStreet + "%" + this.addressComplement + "%" + this.addressNeighborhood + "%"
                + this.addressCity + "%" + this.addressCode;
    }

    public void setAddress(String string) {
        String[] address = string.split("%");
        this.adressStreet = address[0];
        this.addressComplement = address[1];
        this.addressNeighborhood = address[2];
        this.addressCity = address[3];
        this.addressCode = address[4];
    }

}
