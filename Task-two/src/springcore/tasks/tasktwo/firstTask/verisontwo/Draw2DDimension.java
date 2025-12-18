package springcore.tasks.tasktwo.firstTask.verisontwo;

import springcore.tasks.tasktwo.firstTask.versionone.Shape;

public class Draw2DDimension implements DrawDimension{
    @Override
    public void drawDimension(Shape shape) {
        System.out.println(String.format("Drawing 2D %s", shape.getShapeName()));
    }
}
