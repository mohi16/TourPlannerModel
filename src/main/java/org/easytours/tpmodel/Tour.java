package org.easytours.tpmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(value = { "valid" })
public class Tour {
    private String name;
    private String description;
    private String from;
    private String to;
    private double distance;
    private long estTime;
    private String transportType;
    private String routeInfo;
    private String image;
    private TourLog[] tourLogs;

    public Tour(){}
    public Tour(
            String name,
            String description,
            String from,
            String to,
            double distance,
            long estTime,
            String transportType,
            String routeInfo,
            String image
    ) {
        this.name = name;
        this.description = description;
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.estTime = estTime;
        this.transportType = transportType;
        this.routeInfo = routeInfo;
        this.image = image;
    }


    @Override
    public boolean equals(Object other) {
        if (other instanceof Tour) {
            return equals((Tour) other);
        } else {
            return false;
        }
    }

    private boolean isSame(Object left, Object right) {
        if (null == left && null == right) {
            return true;
        } else if (null != left){
            return left.equals(right);
        } else {
            return false;
        }
    }

    public boolean equals(Tour other) {
        return isSame(name, other.name) &&
                isSame(description, other.description) &&
                isSame(from, other.from) &&
                isSame(to, other.to) &&
                distance == other.distance &&
                estTime == other.estTime &&
                isSame(transportType, other.transportType) &&
                isSame(routeInfo, other.routeInfo);
    }

    public boolean isValid(){
        return null != name && !name.isEmpty() &&
                null != description && !description.isEmpty() &&
                null != from  && !from.isEmpty() &&
                null != to  && !to.isEmpty()&&
                0 <= distance &&
                0 <= estTime &&
                null != transportType && !transportType.isEmpty() &&
                null != routeInfo  && !routeInfo.isEmpty();
    }

}
