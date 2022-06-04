package org.easytours.tpmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.easytours.tpmodel.utils.TimeUtils;
import org.easytours.tpmodel.utils.Triple;

@Getter
@JsonIgnoreProperties(value = { "valid", "ratingAsString", "difficultyAsString", "totalTimeAsString" })
public class TourLog {
    private String dateTime;
    private String comment;
    private int difficulty;
    private long totalTime;
    private int rating;
    private int id;

    public TourLog(){}

    public TourLog(
            String datetime,
            String comment,
            int difficulty,
            long totalTime,
            int rating
            ){
        this.dateTime = datetime;
        this.comment = comment;
        this.difficulty = difficulty;
        this.totalTime = totalTime;
        this.rating = rating;
    }

    public String getDifficultyAsString(){
        return String.valueOf(difficulty);
    }

    public String getTotalTimeAsString(){
        Triple<Integer, Integer, Integer> time = TimeUtils.deconstructTime(totalTime);
        return String.format("%02d:%02d:%02d", time.getValue1(), time.getValue2(), time.getValue3());
    }

    public String getRatingAsString(){
        return String.valueOf(rating);
    }

    public void setId(int id){
        this.id = id;
    }

    public boolean isValid(){
        return null != dateTime && !dateTime.isEmpty() &&
                null != comment && !comment.isEmpty() &&
                0 <= totalTime &&
                1 <= rating && rating <= 5 &&
                1 <= difficulty && difficulty <= 5;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof TourLog) {
            return equals((TourLog) other);
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

    public boolean equals(TourLog other) {
        return isSame(dateTime, other.dateTime) &&
                isSame(comment, other.comment) &&
                totalTime == other.totalTime &&
                rating == other.rating &&
                difficulty == other.difficulty;
    }
}
