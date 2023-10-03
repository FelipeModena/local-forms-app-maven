package modena.infra.db.entity;

import modena.infra.db.entity.common.CommonEntity;

public class UserDependentEntity extends CommonEntity {
    private String name;
    private int age;
    private String dependency;
    private int userId;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDependency() {
        return dependency;
    }
    public void setDependency(String dependency) {
        this.dependency = dependency;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }



}
