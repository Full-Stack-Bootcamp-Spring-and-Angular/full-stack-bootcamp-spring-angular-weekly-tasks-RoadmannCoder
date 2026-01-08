package springcore.tasks.tasktwo.firstTask.verisontwo;

import springcore.tasks.tasktwo.firstTask.versionone.Shape;

public class Draw3DDimension implements DrawDimension {

    @Override
    public void drawDimension(Shape shape) {
        System.out.println(String.format("Drawing 3D %s", shape.getShapeName()));
    }
}
