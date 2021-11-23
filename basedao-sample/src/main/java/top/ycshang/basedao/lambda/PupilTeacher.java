package top.ycshang.basedao.lambda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-24 00:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PupilTeacher {
    private Integer teacherId;
    private String teacherName;
}