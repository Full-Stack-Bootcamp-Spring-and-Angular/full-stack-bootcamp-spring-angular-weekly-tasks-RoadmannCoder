import org.springframework.context.support.ClassPathXmlApplicationContext;
import springcore.tasks.tasktwo.firsttask.versionone.Shape;

public class Main {
    public static void main(String[] args) {

//================================= First Task ==========================================================
        ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
        Shape Circle1 = context.getBean("circle", Shape.class);
        Shape Circle2 = context.getBean("circle2", Shape.class);
        Shape Square = context.getBean("square", Shape.class);

        System.out.println(String.format("Memory Location for Circle Singleton Scope is %s", Circle1));
        System.out.println(String.format("Memory Location for Circle 2 Prototype Scope is %s", Circle2));

        Shape Circle3 = context.getBean("circle2", Shape.class);
        System.out.println(String.format("Memory Location for Circle 2 After Initialize again Prototype Scope is %s", Circle3));

        Circle1.draw();
        Square.draw();
// ==================================== Second Task ==========================================================

        context.close();

    }
}