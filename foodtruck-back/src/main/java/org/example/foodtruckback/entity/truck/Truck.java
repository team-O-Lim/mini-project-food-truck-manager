package org.example.foodtruckback.entity.truck;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.foodtruckback.common.enums.TurckStatus;
import org.example.foodtruckback.entity.user.User;
import org.example.foodtruckback.entity.base.BaseTimeEntity;

@Entity
@Table(
        name = "trucks",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_trucks_owner_name",
                columnNames = {"owner_id", "name"})
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Truck extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_trucks_owner_id"))
    private User owner;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 50)
    private String cuisine;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private TurckStatus status = TurckStatus.ACTIVE;
}
