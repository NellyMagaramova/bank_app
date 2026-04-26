package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Objects;

@Entity
@Table(name = "Actions", schema = "public", catalog = "Bank")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Actions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypeAction typeAction;

    private Long summ;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private BankCard bankCard;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actions action = (Actions) o;
        return id.equals(action.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



}
