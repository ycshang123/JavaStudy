package top.ycshang.basedao.enmu;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-21 15:45
 **/
public class StudyJava {
    private String month;
    private ProjectEnum projectEnum;

    public StudyJava(String month, ProjectEnum projectEnum) {
        this.month = month;
        this.projectEnum = projectEnum;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public ProjectEnum getProjectEnum() {
        return projectEnum;
    }

    public void setProjectEnum(ProjectEnum projectEnum) {
        this.projectEnum = projectEnum;
    }
}