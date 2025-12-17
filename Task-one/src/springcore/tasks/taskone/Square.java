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
        String result = String.format("Area of Square is %f", area);
        System.out.println(result);
        return area;
    }


}
