package modena.matricula.db.entity;

import modena.matricula.db.entity.common.CommonEntity;

public class ProjectEntity extends CommonEntity {
    public String name;
    public String description;
    public String startDate;
    public String endDate;
    public String status;

    public ProjectEntity(String name, String description, String startDate, String endDate, String status) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

}
