package springcore.tasks.tasktwo.firsttask.versionone;

public class Square implements Shape{

    private Draw2D draw2D;
    private Draw3D draw3D;
    @Override
    public void draw() {
        System.out.println(draw2D.draw(this));
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

    public void setDraw2D(Draw2D draw2D) {
        this.draw2D = draw2D;
    }

    public void setDraw3D(Draw3D draw3D) {
        this.draw3D = draw3D;
    }
}
