import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springcore.tasks.tasktwo.firstTask.versionone.Draw2D;
import springcore.tasks.tasktwo.firstTask.versionone.Draw3D;
import springcore.tasks.tasktwo.firstTask.versionone.Shape;
import springcore.tasks.tasktwo.secondTask.Vehicle;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//====================================== First Task ======================================
        //Version One
        Shape circle = context.getBean("circle", Shape.class);
        circle.draw();
        Shape square = context.getBean("square", Shape.class);
        square.draw();

        //Version Two
        Shape rectangle = context.getBean("rectangle", Shape.class);
        rectangle.draw();
        Shape cube = context.getBean("cube", Shape.class);
        cube.draw();
//====================================== Second Task ======================================
        Vehicle Car = context.getBean("car", Vehicle.class);
        Car.insertVehicleData();
        Vehicle Plane = context.getBean("plane", Vehicle.class);
        Plane.insertVehicleData();


    }
}