package springcore.tasks.tasktwo.firsttask.verisontwo;

import springcore.tasks.tasktwo.firsttask.versionone.Shape;

public class Draw3DDimension implements DrawDimension {

    @Override
    public void drawDimension(Shape shape) {
        System.out.println(String.format("Drawing 3D %s", shape.getShapeName()));
    }
}
