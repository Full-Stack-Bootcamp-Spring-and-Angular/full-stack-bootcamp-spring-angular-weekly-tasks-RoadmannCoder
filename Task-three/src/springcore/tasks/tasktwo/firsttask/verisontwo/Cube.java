package springcore.tasks.tasktwo.firsttask.verisontwo;

import springcore.tasks.tasktwo.firsttask.versionone.Shape;

public class Cube implements Shape {

    private DrawDimension drawDimension;
    Cube(DrawDimension drawDimension) {
        this.drawDimension = drawDimension;
    }
    @Override
    public void draw() {
        drawDimension.drawDimension(this);
    }

    @Override
    public String getShapeName() {
        return "Cube";
    }

    @Override
    public double getArea(int diemnsion) {
        double area = 6 * (diemnsion * diemnsion);
        String result = String.format("Area of Cube is %f", area);
        System.out.println(result);
        return area;
    }
}
