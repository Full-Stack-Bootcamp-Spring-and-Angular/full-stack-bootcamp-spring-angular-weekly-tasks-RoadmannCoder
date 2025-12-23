package springcore.tasks.tasktwo.firsttask.verisontwo;

import springcore.tasks.tasktwo.firsttask.versionone.Shape;

public class Rectangle implements Shape {

    private DrawDimension drawDimension;
    @Override
    public void draw() {
        drawDimension.drawDimension(this);
    }

    @Override
    public String getShapeName() {
        return "Rectangle";
    }

    @Override
    public double getArea(int diemnsion) {
        double area = diemnsion * diemnsion;
        String result = String.format("Area of Rectangle is %f", area);
        System.out.println(result);
        return area;
    }

    public void setDrawDimension(DrawDimension drawDimension) {
        this.drawDimension = drawDimension;
    }
}
