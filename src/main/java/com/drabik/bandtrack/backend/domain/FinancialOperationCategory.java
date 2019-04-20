package com.drabik.bandtrack.backend.domain;

import javax.persistence.*;

@Entity
@Table(name = "FINANCIAL_OPERATION_CATEGORY")
public class FinancialOperationCategory implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "financial_operation_category_name")
    private String name;

    @Column(name = "from_required")
    private Boolean fromRequired;

    @Column(name = "to_required")
    private Boolean toRequired;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFromRequired() {
        return fromRequired;
    }

    public void setFromRequired(Boolean fromRequired) {
        this.fromRequired = fromRequired;
    }

    public Boolean getToRequired() {
        return toRequired;
    }

    public void setToRequired(Boolean toRequired) {
        this.toRequired = toRequired;
    }
}
