package center.misaki.schoolgrade.Domain;

import lombok.Data;

/**
 * 分数详情
 */
@Data
public class GDeatail {
    private String courseName;
    private Integer high;
    private Integer low;

    public GDeatail(String courseName, Integer high, Integer low) {
        this.courseName = courseName;
        this.high = high;
        this.low = low;
    }

    public GDeatail() {
    }
}
