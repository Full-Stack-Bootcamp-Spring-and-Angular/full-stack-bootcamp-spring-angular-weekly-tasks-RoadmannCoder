package springcore.tasks.taskone;

import org.springframework.aop.scope.ScopedProxyUtils;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public double getArea(int diemnsion) {
        double area = Math.PI * diemnsion * diemnsion;
        System.out.println("Area of " + getShapeName() + " is " + area);
        return area;
    }


}
