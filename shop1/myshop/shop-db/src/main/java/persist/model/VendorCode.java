package persist.model;

import java.io.Serializable;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vendor_codes")
public class VendorCode  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @OneToMany(
            mappedBy = "vendor_code",
            cascade = CascadeType.ALL)
    private List<Product> products;

    public VendorCode() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       VendorCode vendorCode = (VendorCode) o;
        return id.equals(vendorCode.id) &&
                title.equals(vendorCode.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
