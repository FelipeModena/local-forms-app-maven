package modena.infra.usecase.model;

public class UserDependentModel {
    private String name;
    private int age;
    private String dependReason;

    public UserDependentModel(String name, int age, String dependReason) {
        this.name = name;
        this.age = age;
        this.dependReason = dependReason;
    }

}
