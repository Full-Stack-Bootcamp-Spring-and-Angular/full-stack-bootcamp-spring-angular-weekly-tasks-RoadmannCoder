package springcore.tasks.tasktwo.firsttask.versionone;

public class Draw3D {
    public String draw(Shape shape) {
        return String.format("Drawing 3D %s", shape.getShapeName());
    }
}
