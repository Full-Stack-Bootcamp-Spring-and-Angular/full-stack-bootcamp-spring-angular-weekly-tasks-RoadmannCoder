package springcore.tasks.tasktwo.firstTask.versionone;

public class Draw2D {

    public String draw(Shape shape) {
        return String.format("Drawing 2D %s", shape.getShapeName());
    }
}
