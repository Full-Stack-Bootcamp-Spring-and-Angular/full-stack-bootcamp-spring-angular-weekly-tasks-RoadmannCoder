package springcore.tasks.tasktwo.firstTask.versionone;

import org.springframework.aop.scope.ScopedProxyUtils;

public class Circle implements Shape {

    private Draw2D draw2D;
    private Draw3D draw3D;

    Circle(Draw2D draw2D, Draw3D draw3D) {
        this.draw2D = draw2D;
        this.draw3D = draw3D;
    }

    @Override
    public void draw() {
        System.out.println(draw2D.draw(this));
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
