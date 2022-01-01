package center.misaki.schoolgrade.Domain;

import lombok.Data;

@Data
public class GradeGraph {
    private String courseName;
    private Integer B60;
    private Integer B60_70;
    private Integer B70_80;
    private Integer B80_90;
    private Integer B90_100;

    public GradeGraph(String courseName, Integer b60, Integer b60_70, Integer b70_80, Integer b80_90, Integer b90_100) {
        this.courseName = courseName;
        B60 = b60;
        B60_70 = b60_70;
        B70_80 = b70_80;
        B80_90 = b80_90;
        B90_100 = b90_100;
    }

    public GradeGraph() {
    }
}
