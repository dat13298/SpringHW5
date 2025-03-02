package com.aptech.springfhw5.common.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;


@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity<K extends Serializable & Comparable<K>, E extends AbstractEntity<K, ?>> implements Comparable<E> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private K id;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Override
    public int compareTo(E o) {
        if (this == o){
            return 0;
        }
        return this.getId().compareTo(o.getId());
    }
}
