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
        String result = String.format("Area of Circle is %f", area);
        System.out.println(result);
        return area;
    }


}
