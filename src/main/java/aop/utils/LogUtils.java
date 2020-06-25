package aop.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description 使用spring的注解方式注入切面类  @Aspect
 * @Author WGL
 * @Date 2020/6/10 10:24
 * @Version 1.0
 */
@Aspect
@Component
public class LogUtils {
    /**
     * @Description 告诉Spring每个方法在什么时候运行
     * @Beforce 在目标方法之前运行
     * @After 在目标方法结束之后运行
     * @AfterReturning 在目标方法正常返回之后运行
     * @ArterThrowing 在目标方法抛出异常之后运行
     *
     * point.getSignature().getName() 获取方法名
     * point.getArgs()获取到目标方法运行时使用的参数
     * 设置spring哪个参数是获取结果的参数
     * returning = "result"
     * Object result Object类型可以接收任何类型的结果 缩小范围可能会导致无法执行接收结果的通知
     * 设置spring哪个参数是接收exception的
     * throwing = "exception"
     * @Date 2020/6/10 12:36
     **/

    //抽取可重用的切入点表达式
    //随便声明一个无返回的空方法 加上注解 @Pointcut
    @Pointcut("execution(public int aop.impl.MyMathCalculator.*(int,int))")
    public void myPointcut(){}

/*    @Before("myPointcut()")
    public static void logStart(JoinPoint point) {

        System.out.println("[" + point.getSignature().getName() + "]" +
                "方法开始执行，用的参数列表" + Arrays.asList(point.getArgs()));
    }

    @AfterReturning(value = "myPointcut()",returning = "result")
    public static void logReturning(JoinPoint joinPoint,double result) {
        System.out.println("[" + joinPoint.getSignature().getName() + "]" +
                "方法执行完成计算结果是：" + result);
    }

    @AfterThrowing(value = "myPointcut()",throwing = "exception")
    public static void logException(JoinPoint joinPoint,Exception exception) {
        System.out.println("[" + joinPoint.getSignature().getName() + "]" +
                "方法执行出现异常了，异常信息是：" + exception);
    }

    @After("myPointcut()")
    public static void logEnd(JoinPoint joinPoint) {
        System.out.println("[" + joinPoint.getSignature().getName() + "]方法执行结束");
    }

 */
    /**
     * @Description
     * spring 的环绕通知是前面四个通知的 结合体
     * 环绕通知 和普通通知一起执行 ，环绕优于普通通知的执行
     *  原因：
     *     proceed =pjp.proceed(args); 调用方法在环绕通知那里所以要优于普通通知的执行
     * @Date  2020/6/11 17:01
     * @param pjp
     * @return
     **/
    @Around("myPointcut()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        //获取方法参数
        Object[] args = pjp.getArgs();
        //获取方法名
        String name = pjp.getSignature().getName();

        Object proceed = null;
        try {
            System.out.println("【环绕前置通知】["+name+"方法开始]");
            //利用反射调用目标的方法即可 就是 method.invoke(obj,args)
            proceed =pjp.proceed(args);
            System.out.println("【环绕返回通知】["+name+"方法返回]，返回值"+proceed);
        } catch (Exception e) {
            System.out.println("【环绕异常通知】["+name+"]方法出现异常，异常信息："+e);
        }finally {
            System.out.println("【环绕后置通知】["+name+"]方法结束");
        }
        return proceed;
    }
}
