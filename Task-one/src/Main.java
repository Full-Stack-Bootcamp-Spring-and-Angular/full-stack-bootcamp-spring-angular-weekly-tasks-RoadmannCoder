import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springcore.tasks.taskone.Circle;
import springcore.tasks.taskone.Shape;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your diemnsion: ");
        int diemnsion = scanner.nextInt();

        Shape circle =  context.getBean("circle", Shape.class);
        Shape square = context.getBean("square", Shape.class);
        circle.getArea(diemnsion);
        square.getArea(diemnsion);


    }
}