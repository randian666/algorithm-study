package com.algorithm.study.demo.algorithm.greedyalgorithm;

import lombok.*;

/**
 * @author xun2.liu
 * @title: MoneyBusi
 * @projectName algorithm-study
 * @description: 零钱支付
 * @date 2019/11/14 17:19
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MoneyBusi {
    /** 面值 */
    private String value;

    /** 张数 */
    private int num;

    /** 金额 */
    private int memory;
}
