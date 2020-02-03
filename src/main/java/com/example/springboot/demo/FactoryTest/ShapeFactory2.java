package com.example.springboot.demo.FactoryTest;

/**
 * 利用反射解决简单工厂每次增加新了产品类都要修改产品工厂的弊端
 *
 * @author Administrator
 */
public class ShapeFactory2 {
    public static Object getClass(Class<? extends Shape> clazz) {
        Object obj = null;
        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }


    public static void main(String[] args) {
        Circle circle = (Circle) ShapeFactory2.getClass(Circle.class);
        circle.draw();
        Rectangle rectangle = (Rectangle) ShapeFactory2.getClass(Rectangle.class);
        rectangle.draw();
        Square square = (Square) ShapeFactory2.getClass(Square.class);
        square.draw();
    }

}
