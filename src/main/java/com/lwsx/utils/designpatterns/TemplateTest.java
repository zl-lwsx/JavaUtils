package com.lwsx.utils.designpatterns;

/**
 * 模板方法模式
 * 定义：定义一个操作的算法骨架，而将一些步骤延迟到子类中。
 * Template Method使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤
 *
 * 经典案例：
 * 1:在servlet里的应用：
 *  HttpServlet.service();
 * 2:在spring中的应用：
 *  AbstractController
 *      算法骨架：handleRequest
 *      用户重写handleRequestInternal
 */
public class TemplateTest {
    public static void main(String[] args) {
        AbstractClass abstractClass = new Subclass();
        abstractClass.operation();
    }
}

abstract class AbstractClass {
    public void operation() {
        //open
        System.out.println(" pre ...");
        System.out.println(" step1 ");
        System.out.println(" step2 ");
        templateMethod();
        //  ...
    }

    abstract protected void templateMethod();
}

class Subclass extends AbstractClass {

    @Override
    protected void templateMethod() {
        System.out.println("Subclass executed ......");
    }
}
