package com.drabik.bandtrack.backend.domain;

import com.drabik.bandtrack.backend.enums.FinancialSubjectEnum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FINANCIAL_OPERATION")
public class FinancialOperation extends BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "from_type")
    @Enumerated(EnumType.STRING)
    private FinancialSubjectEnum fromType;

    @Column(name = "from_id")
    private Long fromId;

    @Column(name = "to_type")
    @Enumerated(EnumType.STRING)
    private FinancialSubjectEnum toType;

    @Column(name = "to_id")
    private Long toId;

    @OneToOne
    @JoinColumn(name = "related_to_id")
    private FinancialOperation relatedToId;

    @ManyToMany
    @JoinTable(
            name = "financial_operation_tag",
            joinColumns = @JoinColumn(name = "financial_operation_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "financial_operation_category_id")
    private FinancialOperationCategory financialOperationCategory;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FinancialSubjectEnum getFromType() {
        return fromType;
    }

    public void setFromType(FinancialSubjectEnum fromType) {
        this.fromType = fromType;
    }

    public FinancialSubjectEnum getToType() {
        return toType;
    }

    public void setToType(FinancialSubjectEnum toType) {
        this.toType = toType;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FinancialOperationCategory getFinancialOperationCategory() {
        return financialOperationCategory;
    }

    public void setFinancialOperationCategory(FinancialOperationCategory financialOperationCategory) {
        this.financialOperationCategory = financialOperationCategory;
    }

    public FinancialOperation getRelatedToId() {
        return relatedToId;
    }

    public void setRelatedToId(FinancialOperation relatedToId) {
        this.relatedToId = relatedToId;
    }
}
