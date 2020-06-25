package aop.impl;

import aop.inter.Calculator;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author WGL
 * @Date 2020/6/10 10:09
 * @Version 1.0
 */
@Service
public class MyMathCalculator implements Calculator {
    private int result;
    @Override
    public int add(int i, int j) {
        //在这里调用工具类还是存在耦合，没有将业务逻辑与日志逻辑分离出去
        // LogUtils.logStart(i,j);
        result = i + j;
        // System.out.println("add方法运行完成，计算结果是【"+result+"】");
        return result;
    }

    @Override
    public int sub(int i, int j) {
        // System.out.println("sub 方法开始了，它使用的参数是【"+i+","+j+"】");
        result = i - j;
        // System.out.println("sub 方法运行完成，计算结果是【"+result+"】");
        return result;
    }

    @Override
    public int mul(int i, int j) {
        // System.out.println("mul 方法开始了，它使用的参数是【"+i+","+j+"】");
        result = i * j;
        // System.out.println("mul 方法运行完成，计算结果是【"+result+"】");
        return result;
    }

    @Override
    public int div(int i, int j) {
        // System.out.println("div 方法开始了，它使用的参数是【"+i+","+j+"】");
        result = i / j;
        // System.out.println("div 方法运行完成，计算结果是【"+result+"】");
        return result;
    }
}
