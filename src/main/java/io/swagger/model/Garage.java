package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Garage
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-09T18:50:43.350+02:00")
@Entity
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("id_partner")
    @Column(nullable = false)
    private Integer idPartner = null;

    @JsonProperty("partner")
    private String partner = null;

    @JsonProperty("name")
    @Column(nullable = false)
    private String name = null;

    @JsonProperty("phone")
    private String phone = null;

    @JsonProperty("description")
    private String description = null;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("address")
    //@Column(nullable = false)
    private Address address = null;

    @ElementCollection
    @JsonProperty("coordinates")
    @Valid
    @Column(nullable = false)
    private List<String> coordinates = null;

    @ElementCollection
    @JsonProperty("comments")
    @Valid
    private List<Comment> comments = null;

    public Garage id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(value = "")



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Garage idPartner(Integer idPartner) {
        this.idPartner = idPartner;
        return this;
    }

    /**
     * Get idPartner
     *
     * @return idPartner
     **/
    @ApiModelProperty(value = "")


    public Integer getIdPartner() {
        return idPartner;
    }

    public void setIdPartner(Integer idPartner) {
        this.idPartner = idPartner;
    }

    public Garage partner(String partner) {
        this.partner = partner;
        return this;
    }

    /**
     * Get partner
     *
     * @return partner
     **/
    @ApiModelProperty(value = "")


    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public Garage name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @ApiModelProperty(value = "")


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Garage phone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Get phone
     *
     * @return phone
     **/
    @ApiModelProperty(value = "")


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Garage description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    @ApiModelProperty(value = "")


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Garage address(Address address) {
        this.address = address;
        return this;
    }

    /**
     * Get address
     *
     * @return address
     **/
    @ApiModelProperty(value = "")

    @Valid

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Garage coordinates(List<String> coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public Garage addCoordinatesItem(String coordinatesItem) {
        if (this.coordinates == null) {
            this.coordinates = new ArrayList<String>();
        }
        this.coordinates.add(coordinatesItem);
        return this;
    }

    /**
     * Get coordinates
     *
     * @return coordinates
     **/
    @ApiModelProperty(value = "")

    @Size(min = 2, max = 2)
    public List<String> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<String> coordinates) {
        this.coordinates = coordinates;
    }

    public Garage comments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public Garage addCommentsItem(Comment commentsItem) {
        if (this.comments == null) {
            this.comments = new ArrayList<Comment>();
        }
        this.comments.add(commentsItem);
        return this;
    }

    /**
     * Get comments
     *
     * @return comments
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Garage garage = (Garage) o;
        return Objects.equals(this.id, garage.id) &&
                Objects.equals(this.idPartner, garage.idPartner) &&
                Objects.equals(this.partner, garage.partner) &&
                Objects.equals(this.name, garage.name) &&
                Objects.equals(this.phone, garage.phone) &&
                Objects.equals(this.description, garage.description) &&
                Objects.equals(this.address, garage.address) &&
                Objects.equals(this.coordinates, garage.coordinates) &&
                Objects.equals(this.comments, garage.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPartner, partner, name, phone, description, address, coordinates, comments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Garage {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    idPartner: ").append(toIndentedString(idPartner)).append("\n");
        sb.append("    partner: ").append(toIndentedString(partner)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
        sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

