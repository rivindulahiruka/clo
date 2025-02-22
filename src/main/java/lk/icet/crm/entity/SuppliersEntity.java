package lk.icet.crm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class SuppliersEntity {
    @Id
    private Integer supplierId;
    private String suppliersName;
    private String suppliersContact;
    private String suppliersAddress;
    private String suppliersProductName;
}
