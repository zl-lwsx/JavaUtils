package com.lwsx.utils.designpatterns;

/**
 * 装饰者模式
 * <p>
 * 应用场景：
 * 扩展一个类的功能 或 给一个类添加附加职责
 * <p>
 * 优点：
 * 1.不改变原有对象的情况下给一个对象扩展功能
 * 2.使用不同的组合可以实现不同的效果
 * 3.符合开闭原则：对拓展开放，对修改关闭
 * <p>
 * 案例：
 * Servlet Api:
 * HttpServletRequestWrapper
 * HttpServletResponseWrapper
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConcreteDecorator2(new ConreteDecorator1(new ConcreteComponent()));
        component.operation();
    }
}

interface Component {
    void operation();
}

class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("拍照.");
    }

}

abstract class Decorator implements Component {
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}

class ConreteDecorator1 extends Decorator {
    public ConreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加美颜.");
        component.operation();
    }
}

class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加滤镜.");
        component.operation();
    }
}