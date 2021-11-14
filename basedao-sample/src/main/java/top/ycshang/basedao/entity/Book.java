package top.ycshang.basedao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @program: basedao-sample
 * @description: 实体类
 * @author: ycshang
 * @create: 2021-11-14 22:21
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long id;
    private String isbn;
    private String name;
    private Double price;
    private LocalDate published;
}