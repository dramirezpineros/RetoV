package co.usa.mintic.retotres.model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * clase principal de audience
 * @author diego felipe
 */
@Entity
@Table(name="audience")
public class audience implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String owner;
    private Integer capacity;
    private String description;

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties("audiences")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "audience")
    @JsonIgnoreProperties({"audience","client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "audience")
    @JsonIgnoreProperties("audience")
    private List<Reservation> reservations;

    /**
     * funcion get
     * @return id
     */
    public Integer getId() {
        return id;
    }
    /**
     * funcion set
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * funcion get
     * @return owner
     */
    public String getOwner() {
        return owner;
    }
    /**
     * funcion set
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
    /**
     * funcion get
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * funcion set
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * funcion get
     * @return capacity
     */
    public Integer getCapacity() {
        return capacity;
    }
    /**
     * funcion set
     * @param capacity
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    /**
     * funcion get
     * @return desciption
     */
    public String getDescription() {
        return description;
    }
    /**
     * funcion set
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * funcion get category
     * @return
     */
    public Category getCategory() {
        return category;
    }
    /**
     * funcion set
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    /**
     * funcion get
     * @return message
     */
    public List<Message> getMessages() {
        return messages;
    }
    /**
     * funcion set
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    /**
     * funcion get
     * @return reservation
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    /**
     * funcion set
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

  
    



    
}
