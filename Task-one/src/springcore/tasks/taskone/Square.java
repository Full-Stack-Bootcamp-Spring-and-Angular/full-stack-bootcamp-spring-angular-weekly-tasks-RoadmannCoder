package springcore.tasks.taskone;

public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public double getArea(int diemnsion) {
        double area = diemnsion * diemnsion;
        System.out.println("Area of " + getShapeName() + " is " + area);
        return area;
    }


}
