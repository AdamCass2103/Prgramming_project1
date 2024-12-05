package Question_1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ContainerManager manager = new ContainerManager();

        manager.add(new Box(4, 3, 4, 5));
        manager.add(new Cylinder(10, 4, 6));
        manager.add(new Pyramid(3, 3, 2));

        System.out.println("Total Weight: " + manager.totalWeight());
        System.out.println("Total Rectangular Volume: " + manager.totalRectangularVolume());

        List<IMeasurableContainer> allContainers = manager.getAllContainers();
        for (IMeasurableContainer container : allContainers) {
            if (container instanceof Box) {
                Box box = (Box) container;
                System.out.println("Box: " + box.getLength() + "x" + box.getWidth() + "x" + box.getDepth() + " Weight: " + box.getWeight());
            } else if (container instanceof Cylinder) {
                Cylinder cylinder = (Cylinder) container;
                System.out.println("Cylinder: Height=" + cylinder.getHeight() + " Diameter=" + cylinder.getDiameter() + " Weight: " + cylinder.getWeight());
            } else if (container instanceof Pyramid) {
                Pyramid pyramid = (Pyramid) container;
                System.out.println("Pyramid: Length=" + pyramid.getLength() + " Weight: " + pyramid.getWeight());
            }
        }
    }
}