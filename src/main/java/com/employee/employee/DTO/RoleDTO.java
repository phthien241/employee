package com.employee.employee.DTO;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Range;

public class RoleDTO {
    public ObjectId id;
    public String title;
    public String description;
    public Range<Double> salaryRange;

    public ObjectId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Range<Double> getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(Range<Double> salaryRange) {
        this.salaryRange = salaryRange;
    }
}
