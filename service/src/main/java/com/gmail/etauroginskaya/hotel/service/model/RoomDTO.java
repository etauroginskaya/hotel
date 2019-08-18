package com.gmail.etauroginskaya.hotel.service.model;

import com.gmail.etauroginskaya.hotel.service.validators.annotations.RoomIDExists;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class RoomDTO {
    public interface New {
    }

    public interface Update {
    }

    @NotNull(groups = {Update.class})
    @RoomIDExists(groups = {Update.class})
    @Null(groups = {New.class})
    private String id;
    @NotBlank(groups = {New.class, Update.class})
    @Size(groups = {New.class, Update.class})
    private String name;
    @NotNull(groups = {New.class, Update.class})
    @Min(value = 1, groups = {New.class, Update.class})
    private int numberOfBeds;
    @NotNull(groups = {New.class, Update.class})
    @DecimalMin(value = "0.00", groups = {New.class, Update.class})
    private BigDecimal price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}